package com.paraglan.coulinary.screens

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.intl.Locale
import androidx.core.content.FileProvider
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.UUID
import kotlin.text.clear
import kotlin.text.format

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ImagePicker(
    onImageSelected: (Uri?) -> Unit,
    onBitmapSelected: (Bitmap?) -> Unit,
    onLaunchCamera: ((() -> Unit) -> Unit),
    onLaunchPhotoPicker: ((() -> Unit) -> Unit)
) {
    val context = LocalContext.current
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var currentUri: Uri? by remember { mutableStateOf(null) }

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        Log.d("ImagePicker", "cameraLauncher success: $success")
        if (success) {
            Log.d("ImagePicker", "currentUri: $currentUri")
            currentUri?.let { uri ->
                try {
                    val btm = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
                    Log.d("ImagePicker", "bitmap: $btm")
                    onBitmapSelected(btm)
                    Log.d("ImagePicker", "onBitmapSelected called")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } else {
            Log.d("ImagePicker", "cameraLauncher not success")
        }
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let {
                selectedImageUri = saveImageToFile(context, it)
                onImageSelected(selectedImageUri)
            }
        }
    )
    val legacyPhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                selectedImageUri = saveImageToFile(context, it)
                onImageSelected(selectedImageUri)
            }
        }
    )
    val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.CAMERA
        )
    } else {
        arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    }
    val permissionState = rememberMultiplePermissionsState(permissions.toList())

    LaunchedEffect(Unit) {
        permissionState.launchMultiplePermissionRequest()
    }

    fun launchCamera() {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.US).format(java.util.Date())
        val storageDir: File = context.getExternalFilesDir(null)!!
        val photoFile = File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", photoFile)
        currentUri = uri
        cameraLauncher.launch(uri)
    }
    fun launchPhotoPicker() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            photoPickerLauncher.launch(
                PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.ImageOnly
                )
            )
        } else {
            legacyPhotoPickerLauncher.launch("image/*")
        }
    }
    onLaunchCamera { launchCamera() }
    onLaunchPhotoPicker { launchPhotoPicker() }
}
fun saveImageToFile(context: Context, uri: Uri): Uri? {
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.US).format(java.util.Date())
    val storageDir: File = context.getExternalFilesDir(null)!!
    val imageFile = File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)

    try {
        val inputStream = context.contentResolver.openInputStream(uri)
        if (inputStream == null) {
            Log.e("ImagePicker", "saveImageToFile: inputStream is null for uri: $uri")
            return null
        }
        val outputStream = FileOutputStream(imageFile)
        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }
        return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", imageFile)
    } catch (e: Exception) {
        Log.e("ImagePicker", "saveImageToFile: error saving image: ${e.message}", e)
        return null
    }
}
fun saveImageToFile2(context: Context, bitmap: Bitmap): Uri? {
    val filename = "JPEG_${SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.getDefault()).format(java.util.Date())}_${UUID.randomUUID()}.jpg"
    val imageCollection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
    } else {
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    }
    val contentValues = ContentValues().apply {
        put(MediaStore.Images.Media.DISPLAY_NAME, filename)
        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            put(MediaStore.Images.Media.IS_PENDING, 1)
        }
    }
    val contentResolver = context.contentResolver
    val imageUri = contentResolver.insert(imageCollection, contentValues)
    return try {
        imageUri?.let {
            contentResolver.openOutputStream(it)?.use { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                contentValues.clear()
                contentValues.put(MediaStore.Images.Media.IS_PENDING, 0)
                contentResolver.update(it, contentValues, null, null)
            }
            it
        }
    } catch (e: Exception) {
        imageUri?.let { contentResolver.delete(it, null, null) }
        null
    }
}