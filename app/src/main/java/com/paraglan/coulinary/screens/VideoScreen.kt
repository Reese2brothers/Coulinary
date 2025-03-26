package com.paraglan.coulinary.screens

import android.annotation.SuppressLint
import android.app.Activity
import com.paraglan.coulinary.R
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.paraglan.coulinary.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewModelScope
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import kotlin.text.split

@SuppressLint("ClickableViewAccessibility")
@Composable
fun VideoScreen(navController: NavController, videoUrl: String, title: String, id : Int, key : String) {
    Log.d("TAG", "VideoScreen: $videoUrl")
    val context = LocalContext.current
    var videosString by remember { mutableStateOf("") }
    var listVideos by remember { mutableStateOf<List<String>>(emptyList()) }
    var currentVideoUri by remember { mutableStateOf<String?>(null) }
    var videoCount by remember { mutableStateOf(0) }
    var selectedVideoUri by remember { mutableStateOf<Uri?>(null) }
    var isVideoCaptured by remember { mutableStateOf(false) }
    var mediaPlayer: MediaPlayer? by remember { mutableStateOf(null) }
    val showDialogThree = remember { mutableStateOf(false) }
    val showDialogFour = remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<String?>(null) }
    var sizer by remember { mutableStateOf(350.dp) }
    var isSizer by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    LaunchedEffect(key1 = videoUrl) {
        scope.launch {
            try {
                val decodedVideoUrl = URLDecoder.decode(videoUrl, StandardCharsets.UTF_8.toString()).split(",")
                Log.d("TAG", "VideoScreen: $decodedVideoUrl")
                if (decodedVideoUrl.size == 1 && decodedVideoUrl[0] == "video") {
                    listVideos = emptyList()
                } else {
                    listVideos = decodedVideoUrl.filter { it.startsWith("content://") }
                }
            } catch (e: Exception) {
                Log.e("TAG", "Error decoding video URL: ${e.message}")
            }
        }
    }
    fun releaseMediaPlayer(mediaPlayer: MediaPlayer?) {
        try {
            mediaPlayer?.apply {
                reset()
                release()
            }
        } catch (e: IllegalStateException) {
            Log.e("TAG", "Error releasing media player: ${e.message}")
        }
    }
    val videoPickerLauncherNew = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let { originalUri ->
                scope.launch {
                    val savedUri = saveVideoToFile(context, originalUri)
                    videosString = if (videosString.isEmpty()) {
                        savedUri.toString()
                    } else {
                        "$videosString,${savedUri.toString()}"
                    }
                    when(key){
                        "OneRecipeScreen" -> db.oneDao().appendVideo(id, savedUri.toString())
                         "TwoRecipeScreen" -> db.twoDao().appendVideo(id, savedUri.toString())
                        // "ThreeRecipeScreen" -> db.threeDao().updateVideos(id, videosString)
                    }
                    videoCount++
                    selectedVideoUri = savedUri
                    isVideoCaptured = true
                    listVideos = videosString.split(",").filter { it.startsWith("content://") }
                }
            }
        }
    )
    val videoPickerLauncherOld = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let { originalUri ->
                scope.launch {
                    val savedUri = saveVideoToFile(context, originalUri)
                    videosString = if (videosString.isEmpty()) {
                        savedUri.toString()
                    } else {
                        "$videosString,${savedUri.toString()}"
                    }
                    when(key){
                        "OneRecipeScreen" -> db.oneDao().appendVideo(id, savedUri.toString())
                         "TwoRecipeScreen" -> db.twoDao().appendVideo(id, savedUri.toString())
                        // "ThreeRecipeScreen" -> db.threeDao().updateVideos(id, videosString)
                    }
                    videoCount++
                    selectedVideoUri = savedUri
                    isVideoCaptured = true
                    listVideos = videosString.split(",").filter { it.startsWith("content://") }
                }
            }
        }
    )
    val videoCaptureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    scope.launch {
                        val savedUri = saveVideoToFile(context, uri)
                        videosString = if (videosString.isEmpty()) {
                            savedUri.toString()
                        } else {
                            "$videosString,${savedUri.toString()}"
                        }
                        when(key){
                            "OneRecipeScreen" -> db.oneDao().appendVideo(id, savedUri.toString())
                             "TwoRecipeScreen" -> db.twoDao().appendVideo(id, savedUri.toString())
                            // "ThreeRecipeScreen" -> db.threeDao().updateVideos(id, videosString)
                        }
                        videoCount++
                        selectedVideoUri = savedUri
                        isVideoCaptured = true
                        listVideos = videosString.split(",").filter { it.startsWith("content://") }
                    }
                }
            }
        }
    )
    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Image(painter = painterResource(R.drawable.foncook), contentDescription = "fon",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier.fillMaxWidth().height(80.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.weight(1f).clickable {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                videoPickerLauncherNew.launch(
                                    PickVisualMediaRequest(
                                        ActivityResultContracts.PickVisualMedia.VideoOnly
                                    )
                                )
                            } else {
                                videoPickerLauncherOld.launch("video/*")
                            }
                        })
                {
                    Icon(painter = painterResource(id = R.drawable.baseline_video_library), contentDescription = "add_video_from_gallery",
                        modifier = Modifier.size(35.dp), tint = colorResource(R.color.boloto)
                    )
                    Text(text = stringResource(R.string.onerec_video_from_gallery),
                        modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 4.dp),
                        textAlign = TextAlign.Center, fontSize = 11.sp,
                        color = colorResource(id = R.color.boloto), fontFamily = FontFamily(Font(R.font.interregular))
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.weight(1f).clickable { val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                            videoCaptureLauncher.launch(intent) }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_videocamera), contentDescription = "add_video_from_camera",
                        modifier = Modifier.size(39.dp), tint = colorResource(R.color.boloto)
                    )
                    Text(text = stringResource(R.string.onerec_video_from_camera),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
                        textAlign = TextAlign.Center, fontSize = 11.sp,
                        color = colorResource(id = R.color.boloto), fontFamily = FontFamily(Font(R.font.interregular))
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.weight(1f).clickable {
                            showDialogThree.value = true
                        }) {
                    Icon(painter = painterResource(id = R.drawable.delete), contentDescription = "delete all videos",
                        modifier = Modifier.size(30.dp), tint = colorResource(R.color.boloto)
                    )
                    Text(text = stringResource(R.string.onerec_delete_all_videos),
                        modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 4.dp),
                        textAlign = TextAlign.Center, fontSize = 11.sp,
                        color = colorResource(id = R.color.boloto), fontFamily = FontFamily(Font(R.font.interregular))
                    )
                }
                if (showDialogThree.value) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialogThree.value = false
                        },
                        containerColor = colorResource(id = R.color.white),
                        title = { Text(stringResource(R.string.confirm), color = colorResource(id = R.color.boloto),
                            fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                        text = {
                            Text(
                                stringResource(R.string.alert_delete_all_videos),
                                color = colorResource(id = R.color.boloto)
                            )
                        },
                        confirmButton = {
                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.boloto)
                            ),
                                onClick = {
                                    scope.launch {
                                        val videoUris = videosString.split(",").filter { it.isNotBlank() && it.startsWith("content://") }
                                        videoUris.forEach { uriString ->
                                            val uri = Uri.parse(uriString)
                                            val file = uri.path?.let { File(it) }
                                            if (file != null) {
                                                if (file.exists()) {
                                                    file.delete()
                                                }
                                            }
                                            try {
                                                context.contentResolver.delete(uri, null, null)
                                            } catch (e: SecurityException) {
                                                Log.e("TAG", "Error deleting video file: ${e.message}")
                                            }
                                        }
                                        videosString = "video"
                                        when(key){
                                            "OneRecipeScreen" -> db.oneDao().updateVideos(id, videosString)
                                            "TwoRecipeScreen" -> db.twoDao().updateVideos(id, videosString)
                                           // "ThreeRecipeScreen" -> db.threeDao().updateVideos(id, videosString)
                                        }
                                        withContext(Dispatchers.Main) {
                                            listVideos = emptyList()
                                        }
                                    }
                                    showDialogThree.value = false
                                }) {
                                Text(stringResource(R.string.yes), color = colorResource(id = R.color.white), fontSize = 16.sp)
                            }
                        },
                        dismissButton = {
                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.boloto)
                            ),
                                onClick = {
                                    showDialogThree.value = false
                                }) {
                                Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                            }
                        })
                }
            }
            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 4.dp, bottom = 8.dp)){
                itemsIndexed(listVideos) { index, item ->
                    VideoPlayer(videoUri = item)
                    Card(modifier = Modifier.fillMaxWidth().padding(top = 4.dp, start = 8.dp, end = 8.dp)
                        .height(sizer).background(Color.Transparent),
                        shape = RoundedCornerShape(8.dp)) {
                        fun createThumbnailForVideo(videoUri: Uri): String? {
                            try {
                                val thumbnailFile = File(context.cacheDir, "thumbnail_${videoUri.hashCode()}.jpg")
                                Glide.with(context)
                                    .asBitmap()
                                    .load(videoUri)
                                    .frame(1000)
                                    .into(object : CustomTarget<Bitmap>() {
                                        override fun onResourceReady(
                                            resource: Bitmap,
                                            transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                                        ) {
                                            val byteArray = resource.toByteArray()
                                            FileOutputStream(thumbnailFile).use { it.write(byteArray) }
                                        }
                                        override fun onLoadCleared(placeholder: Drawable?) {}
                                    })
                                return thumbnailFile.toURI().toString()
                            } catch (e: Exception) {
                                Log.e("TAG", "Error creating thumbnail: ${e.message}")
                            }
                            return null
                        }
                        Column(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                            horizontalAlignment = Alignment.CenterHorizontally) {

                            var isPlaying by remember { mutableStateOf(false) }
                            var videoDuration by remember { mutableStateOf(0) }
                            var videoPosition by remember { mutableStateOf(0) }
                            var isSeeking by remember { mutableStateOf(false) }
                            var newPosition by remember { mutableStateOf(0) }
                            val thumbnailUri = remember(item) { createThumbnailForVideo(Uri.parse(item)) }
                            LaunchedEffect(key1 = isPlaying) {
                                try {
                                    while (isPlaying && mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                        videoPosition = mediaPlayer!!.currentPosition
                                        delay(1000)
                                    }
                                } catch (e: Exception) {
                                    Log.e("TAG", "Error in  LaunchedEffect: ${e.message}")
                                }
                            }
                            LaunchedEffect(key1 = currentVideoUri) {
                                if (currentVideoUri != null) {
                                    mediaPlayer?.reset()
                                    mediaPlayer?.setDataSource(context, Uri.parse(currentVideoUri))
                                    mediaPlayer?.prepareAsync()
                                } else {
                                    releaseMediaPlayer(mediaPlayer)
                                    mediaPlayer = null
                                }
                            }
                            key(item) {
                                Box(modifier = Modifier.fillMaxWidth().weight(1f)) {
                                    AndroidView(factory = { context ->
                                        VideoView(context).apply {
                                            requestFocus()
                                            setOnTouchListener { v, event ->
                                                when (event.action) {
                                                    MotionEvent.ACTION_DOWN -> {
                                                        isSeeking = true
                                                        try {
                                                            if (mediaPlayer?.isPlaying == true) {
                                                                mediaPlayer?.pause()
                                                            }
                                                        } catch (e: IllegalStateException) {
                                                            Log.e(
                                                                "VideoView",
                                                                "Error pausing video: ${e.message}"
                                                            )
                                                        }
                                                    }

                                                    MotionEvent.ACTION_MOVE -> {
                                                        if (isSeeking) {
                                                            newPosition =
                                                                (event.x / v.width * videoDuration).toInt()
                                                            newPosition =
                                                                newPosition.coerceIn(
                                                                    0,
                                                                    videoDuration
                                                                )
                                                            try {
                                                                if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                                                    mediaPlayer?.seekTo(
                                                                        newPosition
                                                                    )
                                                                }
                                                            } catch (e: IllegalStateException) {
                                                                Log.e(
                                                                    "VideoView",
                                                                    "Error seeking video: ${e.message}"
                                                                )
                                                            }
                                                        }
                                                    }

                                                    MotionEvent.ACTION_UP -> {
                                                        isSeeking = false
                                                        try {
                                                            if (isPlaying && mediaPlayer != null && mediaPlayer?.isPlaying == false) {
                                                                mediaPlayer?.start()
                                                            }
                                                        } catch (e: IllegalStateException) {
                                                            Log.e(
                                                                "VideoView",
                                                                "Error starting video: ${e.message}"
                                                            )
                                                        }
                                                    }
                                                }
                                                true
                                            }

                                            layoutParams = ViewGroup.LayoutParams(
                                                ViewGroup.LayoutParams.MATCH_PARENT,
                                                ViewGroup.LayoutParams.MATCH_PARENT
                                            )
                                            setVideoURI(Uri.parse(item))
                                            setOnPreparedListener { player ->
                                                mediaPlayer = player
                                                videoDuration = player.duration
                                                isPlaying = false
                                            }
                                            setOnCompletionListener {
                                                isPlaying = false
                                                videoPosition = 0
                                                mediaPlayer?.seekTo(0)
                                            }
                                        }
                                    },
                                        update = { view ->
                                            view.setVideoURI(Uri.parse(item))
                                            view.setOnPreparedListener { player ->
                                                mediaPlayer = player
                                                videoDuration = player.duration
                                                isPlaying = false
                                            }
                                        },
                                        modifier = Modifier.fillMaxWidth().fillMaxHeight()
                                            .onReady {
                                                try {
                                                    if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                                        mediaPlayer?.start()
                                                    }
                                                } catch (e: IllegalStateException) {
                                                    Log.e("VideoView", "Error starting video in onReady: ${e.message}")
                                                }
                                            }
                                    )
                                    AsyncImage(model = thumbnailUri, contentDescription = "Video Thumbnail",
                                        modifier = Modifier.fillMaxWidth().aspectRatio(16f / 10f)
                                            .alpha(if (!isPlaying && videoPosition == 0) 1f else 0f)
                                    )
                                }
                            }
                            Slider(value = videoPosition.toFloat(),
                                onValueChange = {
                                    try {
                                        if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                            videoPosition = it.toInt()
                                            mediaPlayer?.seekTo(videoPosition)
                                        }
                                    } catch (e: IllegalStateException) {
                                        Log.e("VideoView", "Error seeking video: ${e.message}")
                                    }
                                },
                                valueRange = 0f..videoDuration.toFloat(),
                                modifier = Modifier.fillMaxWidth(),
                                colors = SliderColors(
                                    thumbColor = Color.Red,
                                    activeTrackColor = Color.Red,
                                    inactiveTrackColor = Color.LightGray,
                                    activeTickColor = Color.Red,
                                    disabledActiveTickColor = Color.Gray,
                                    disabledActiveTrackColor = Color.Gray,
                                    disabledInactiveTickColor = Color.LightGray,
                                    disabledInactiveTrackColor = Color.LightGray,
                                    disabledThumbColor = Color.Gray,
                                    inactiveTickColor = Color.LightGray
                                )
                            )
                            fun formatTime(timeInMillis: Int): String {
                                val totalSeconds = timeInMillis / 1000
                                val seconds = totalSeconds % 60
                                val minutes = (totalSeconds / 60) % 60
                                val hours = totalSeconds / 3600
                                return String.format("%02d:%02d:%02d", hours, minutes, seconds)
                            }
                            Row( modifier = Modifier.fillMaxWidth().height(50.dp).background(colorResource(R.color.white)),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically) {
                                Icon(painter = painterResource(if(!isSizer) R.drawable.baseline_fullscreen_24 else R.drawable.baseline_fullscreen_exit_24), contentDescription = "go_to_full_screen",
                                    modifier = Modifier.size(30.dp).padding(start = 8.dp)
                                        .clickable {
                                            isSizer = !isSizer
                                            if(isSizer) sizer = 550.dp else sizer = 350.dp
                                        }
                                )
                                Text(text = formatTime(videoPosition) + " / " + formatTime(videoDuration),
                                    modifier = Modifier.weight(0.7f), textAlign = TextAlign.Center
                                )
                                Icon(painter = if (isPlaying) painterResource(R.drawable.baseline_video_pause)
                                else painterResource(R.drawable.baseline_video_play),
                                    contentDescription = if (isPlaying) "Pause" else "Play",
                                    modifier = Modifier.size(30.dp).padding(end = 4.dp).clickable {
                                        isPlaying = !isPlaying

                                        if (isPlaying && mediaPlayer != null) {
                                            mediaPlayer?.start()
                                        } else {
                                            mediaPlayer?.pause()
                                        }
                                    }
                                )
                                Icon(painter = painterResource(R.drawable.baseline_video_stop), contentDescription = "Stop",
                                    modifier = Modifier.size(35.dp).clickable {
                                        isPlaying = false
                                        mediaPlayer?.pause()
                                        mediaPlayer?.seekTo(0)
                                        videoPosition = 0
                                    })
//                                Icon(painter = painterResource(id = R.drawable.delete),
//                                    contentDescription = "delete_item_video",
//                                    modifier = Modifier.size(30.dp).padding(end = 8.dp).clickable {
//                                        showDialogFour.value = true
//                                        selectedItem = item
//                                    }, tint = colorResource(R.color.black)
//                                )
                                if (showDialogFour.value) {
                                    AlertDialog(
                                        onDismissRequest = {
                                            showDialogFour.value = false
                                        },
                                        containerColor = colorResource(id = R.color.white),
                                        title = { Text(
                                            stringResource(R.string.confirm), color = colorResource(id = R.color.boloto),
                                            fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                                        text = {
                                            Text(
                                                stringResource(R.string.alert_delete_video),
                                                color = colorResource(id = R.color.boloto)
                                            )
                                        },
                                        confirmButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.boloto)
                                            ),
                                                onClick = {
                                                    scope.launch {
                                                        val videoUriToDelete = Uri.parse(selectedItem)
                                                        try {
                                                            context.contentResolver.delete(videoUriToDelete, null, null)
                                                            Log.d("TAG", "Deleted video URI: $videoUriToDelete")
                                                        } catch (e: SecurityException) {
                                                            Log.e("TAG", "Error deleting video file: ${e.message}")
                                                        }
                                                        val updatedList = videosString.split(",").filter { it != selectedItem }
                                                        var updatedVideosString = updatedList.joinToString(",")
                                                        if (updatedVideosString.isEmpty()) {
                                                            updatedVideosString = "video"
                                                        }
                                                        when(key){
                                                            "OneRecipeScreen" ->  db.oneDao().updateVideos(id, updatedVideosString)
                                                            "TwoRecipeScreen" -> db.twoDao().updateVideos(id, updatedVideosString)
                                                            //"ThreeRecipeScreen" -> db.threeDao().updateVideos(id, videosString)

                                                        }
                                                        withContext(Dispatchers.Main) {
                                                            listVideos = listVideos.filter { it != selectedItem }
                                                            if (currentVideoUri == selectedItem) {
                                                                currentVideoUri = null
                                                            }
                                                        }
                                                    }
                                                    showDialogFour.value = false
                                                }) {
                                                Text(stringResource(R.string.yes), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                            }
                                        },
                                        dismissButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.boloto)
                                            ),
                                                onClick = {
                                                    showDialogFour.value = false
                                                }) {
                                                Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                            }
                                        })
                                }
                            }

                        }
                    }
                }
            }
        }

    }
}
fun saveVideoToFile(context: Context, uri: Uri): Uri {
    val inputStream = context.contentResolver.openInputStream(uri)
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES)
    if (!storageDir?.exists()!!) {
        storageDir.mkdirs()
    }
    val videoFile = File(storageDir, "VIDEO_${timeStamp}.mp4")
    if (!videoFile.exists()) {
        val outputStream = FileOutputStream(videoFile)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
    }
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", videoFile)
}
@Composable
fun VideoPlayer(videoUri: String) {
    var mediaPlayer: MediaPlayer? by remember { mutableStateOf(null) }
    val context = LocalContext.current
    LaunchedEffect(key1 = videoUri) {
        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(context, Uri.parse(videoUri))
                prepareAsync()
            } catch (e: Exception) {
                Log.e("VideoPlayer", "Error initialized MediaPlayer: ${e.message}")
            }
        }
    }
}
fun Modifier.onReady(onReady: () -> Unit): Modifier = composed {
    var isReady by remember { mutableStateOf(false) }
    DisposableEffect(key1 = isReady) {
        if (!isReady) {
            onReady()
            isReady = true
        }
        onDispose {  }
    }
    this
}
fun Bitmap.toByteArray(): ByteArray {
    val stream = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output.ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.JPEG, 100, stream)
    return stream.toByteArray()
}