package com.paraglan.coulinary.screens.sixs.fiftyone

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import com.paraglan.coulinary.R
import com.paraglan.coulinary.database.AppDatabase
import com.paraglan.coulinary.database.Favourites
import com.paraglan.coulinary.database.FiftyOne
import com.paraglan.coulinary.database.Four
import com.paraglan.coulinary.screens.ImagePicker
import com.paraglan.coulinary.screens.ones.one.PanelState
import com.paraglan.coulinary.screens.ones.one.saveTextAsPdf
import com.paraglan.coulinary.screens.saveImageToFile2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FiftyOneRecipeScreen(navController: NavController, title: String, content: String, image: String, videos: String, id: Int) {
    val decTitle = URLDecoder.decode(title, StandardCharsets.UTF_8.toString())
    val decContent = URLDecoder.decode(content, StandardCharsets.UTF_8.toString())
    var panelState by remember { mutableStateOf(PanelState.Hidden) }
    var isPressed by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    var showImagePicker by remember { mutableStateOf(false) }
    var launchCamera: () -> Unit = {}
    var launchPhotoPicker: () -> Unit = {}
    var listsImage = remember { mutableStateListOf<String>() }
    var listsVideo = remember { mutableStateListOf<String>() }

    var selectedImage by remember { mutableStateOf("") }
    var isCamera by remember { mutableStateOf(false) }
    var isGallery by remember { mutableStateOf(false) }
    val showDialogDeleteAll = remember { mutableStateOf(false) }
    val showDialogEditRecipe = remember { mutableStateOf(false) }
    val showDialogPdf = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by remember { mutableStateOf(decTitle) }
    var text2 by remember { mutableStateOf(decContent) }
    val field1 = remember { mutableStateOf("") }
    var tints by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = text) {
        tints = db.favouritesDao().isFavourite(text, "FiftyOneRecipeScreen")
    }
    LaunchedEffect(key1 = listsImage) {
        withContext(Dispatchers.IO) {
            val imagesString = db.fiftyOneDao().getImagesByTitle(title) ?: ""
            if (imagesString.isNotEmpty()) {
                val imagesList = imagesString.split(",").map { it.trim() }
                listsImage.addAll(imagesList)
                if (listsImage.isNotEmpty()){
                    selectedImage = listsImage[0]
                }
                Log.d("TAG", "FiftyOneRecipeScreen: $listsImage")
            }
        }
    }
    LaunchedEffect(key1 = listsVideo) {
        withContext(Dispatchers.IO) {
            val videoString = db.fiftyOneDao().getVideosByTitle(title) ?: ""
            if (videoString.isNotEmpty()) {
                val videosList = videoString.split(",").map { it.trim() }
                listsVideo.addAll(videosList)
                Log.d("TAG", "FiftyOneRecipeScreen: $listsVideo")
            }
        }
    }
    LaunchedEffect(isCamera) {
        if (isCamera) {
            launchCamera()
            isCamera = false
        }
    }
    LaunchedEffect(isGallery) {
        if (isGallery) {
            launchPhotoPicker()
            isGallery = false
        }
    }
    //выдвижная панель сверху
    val panelHeight = 600.dp
    val animatedOffset by animateDpAsState(
        targetValue = if (panelState == PanelState.Expanded) 0.dp else -panelHeight + 250.dp,
        animationSpec = tween(durationMillis = 500)
    )
    val width = LocalConfiguration.current.screenWidthDp.dp
    // Анимация для развертывания
    val expandedImageHeight by animateDpAsState(
        targetValue = if (isPressed) 400.dp else 200.dp,
        animationSpec = tween(durationMillis = 500), // Длительность развертывания
        label = "expandedImageHeight"
    )
    val expandedImageWidth by animateDpAsState(
        targetValue = if (isPressed) width - 16.dp else 300.dp,
        animationSpec = tween(durationMillis = 500), // Длительность развертывания
        label = "expandedImageWidth"
    )
    // Анимация для свертывания
    val collapsedImageHeight by animateDpAsState(
        targetValue = if (!isPressed) 200.dp else 400.dp,
        animationSpec = tween(durationMillis = 1000), // Длительность свертывания
        label = "collapsedImageHeight"
    )
    val collapsedImageWidth by animateDpAsState(
        targetValue = if (!isPressed) 300.dp else 200.dp,
        animationSpec = tween(durationMillis = 1000), // Длительность свертывания
        label = "collapsedImageWidth"
    )
    LaunchedEffect(isPressed) {
        if (isPressed) {
            delay(500)
        }
    }
    fun updateDatabaseWithImages(title: String, images: List<String>) {
        val distinctImages = images.distinct()
        val imagessString = distinctImages.joinToString(",")
        scope.launch {
            db.fiftyOneDao().updateImages(id, imagessString)
        }
    }
    if (showImagePicker) {
        ImagePicker(
            onImageSelected = { uri ->
                uri?.let {
                    selectedImage = it.toString()
                    listsImage.add(it.toString())
                    updateDatabaseWithImages(title, listsImage)
                }
                showImagePicker = false
            },
            onBitmapSelected = { btm ->
                btm?.let {
                    val savedUri = saveImageToFile2(context, it)
                    savedUri?.let { uri ->
                        selectedImage = uri.toString()
                        listsImage.add(uri.toString())
                        updateDatabaseWithImages(title, listsImage)
                    }
                }
                showImagePicker = false
            },
            onLaunchCamera = { cameraLauncher ->
                launchCamera = cameraLauncher
            },
            onLaunchPhotoPicker = { photoPickerLauncher ->
                launchPhotoPicker = photoPickerLauncher
            }
        )
    }
    fun onDelete(imageUri: String) {
        scope.launch {
            if (imageUri.startsWith("content://") || imageUri.startsWith("file://")) {
                val uriToDelete = Uri.parse(imageUri)
                try {
                    context.contentResolver.delete(uriToDelete, null, null)
                } catch (e: SecurityException) {
                    Log.e("TAG", "Error deleting image: ${e.message}")
                }
            }
            listsImage.remove(imageUri)
            updateDatabaseWithImages(title, listsImage)
        }
    }
    fun deleteAllImages(){
        scope.launch {
            val urisToDelete = listsImage.filter { it.startsWith("content://") || it.startsWith("file://") }
            for (imageUri in urisToDelete) {
                val uriToDelete = Uri.parse(imageUri)
                try {
                    context.contentResolver.delete(uriToDelete, null, null)
                } catch (e: SecurityException) {
                    Log.e("TAG", "Error deleting image: ${e.message}")
                }
            }
            listsImage.clear()
            selectedImage = R.drawable.noimage.toString()
            withContext(Dispatchers.IO) {
                updateDatabaseWithImages(title, listsImage)
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        Image(painter = painterResource(R.drawable.foncook), contentDescription = "foncook",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp).padding(top = 270.dp, bottom = 16.dp), horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(R.drawable.edit), contentDescription = "edit",
                    modifier = Modifier.size(30.dp).clickable {
                        if(tints) { scope.launch { db.favouritesDao().deleteFavourite(text, "FiftyOneRecipeScreen") } }
                        showDialogEditRecipe.value = true
                    }
                )
                if (showDialogEditRecipe.value) {
                    AlertDialog(onDismissRequest = { showDialogEditRecipe.value = false },
                        containerColor = colorResource(id = R.color.white),
                        title = { androidx.compose.material.Text(
                            stringResource(R.string.confirm),
                            color = colorResource(id = R.color.boloto),
                            fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        },
                        text = {
                            Column(modifier = Modifier.fillMaxWidth().weight(1f), horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly){
                                OutlinedTextField(value = text,
                                    onValueChange = { text = it },
                                    placeholder = {
                                        Text(
                                            stringResource(R.string.enter_title_new_recipe), color = colorResource(
                                                R.color.boloto)
                                        )
                                    },
                                    trailingIcon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "clear",
                                        modifier = Modifier.size(20.dp).clickable { text = "" }, tint = colorResource(
                                            R.color.boloto)
                                    ) },
                                    textStyle = TextStyle(color = colorResource(R.color.boloto), fontSize = 20.sp),
                                    modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
                                        .border(3.dp, colorResource(R.color.boloto), RoundedCornerShape(8.dp)),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = colorResource(R.color.boloto),
                                        unfocusedBorderColor = colorResource(R.color.boloto),
                                        cursorColor = colorResource(R.color.boloto),
                                        focusedPlaceholderColor = colorResource(R.color.boloto),
                                        focusedTextColor = colorResource(R.color.boloto)
                                    ),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                OutlinedTextField(value = text2,
                                    onValueChange = { text2 = it },
                                    placeholder = {
                                        Text(
                                            stringResource(R.string.enter_content_new_recipe), color = colorResource(
                                                R.color.boloto)
                                        )
                                    },
                                    trailingIcon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "clear",
                                        modifier = Modifier.size(20.dp).clickable { text2 = "" }, tint = colorResource(
                                            R.color.boloto)
                                    ) },
                                    textStyle = TextStyle(color = colorResource(R.color.boloto), fontSize = 20.sp),
                                    modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
                                        .border(3.dp, colorResource(R.color.boloto), RoundedCornerShape(8.dp)),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = colorResource(R.color.boloto),
                                        unfocusedBorderColor = colorResource(R.color.boloto),
                                        cursorColor = colorResource(R.color.boloto),
                                        focusedPlaceholderColor = colorResource(R.color.boloto),
                                        focusedTextColor = colorResource(R.color.boloto)
                                    ),
                                    shape = RoundedCornerShape(8.dp)
                                )
                            }
                        },
                        confirmButton = {
                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.boloto)
                            ), onClick = {
                                scope.launch {
                                    db.fiftyOneDao().upsert(
                                        FiftyOne(title = text, content = text2,
                                            images = listsImage.joinToString(","), videos = videos, id = id)
                                    )
                                    if(!tints){ db.favouritesDao().insertFavourites(Favourites(title = text, content = text2, images = selectedImage, favouriteskey = "FiftyOneRecipeScreen")) }
                                }
                                showDialogEditRecipe.value = false
                            }) {
                                androidx.compose.material.Text(
                                    stringResource(R.string.yes), color = colorResource(id = R.color.white),
                                    fontSize = 16.sp
                                )
                            }
                        },
                        dismissButton = {
                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.boloto)
                            ),
                                onClick = { showDialogEditRecipe.value = false
                                }) {
                                androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                            }
                        })
                }

                Image (painter = painterResource(if(!tints) R.drawable.baseline_favorite_border_24 else R.drawable.baseline_favorite_24), contentDescription = "favourite",
                    modifier = Modifier.size(30.dp).clickable {
                        scope.launch {
                            if (tints) {
                                db.favouritesDao().deleteFavourite(text, "FiftyOneRecipeScreen")
                            } else {
                                db.favouritesDao().insertFavourites(
                                    Favourites(title = text, content = text2, images = selectedImage, favouriteskey = "FiftyOneRecipeScreen")
                                )
                            }
                            tints = !tints
                        }
                    }
                )
                Image (painter = painterResource(R.drawable.share), contentDescription = "share",
                    modifier = Modifier.size(30.dp).clickable {
                        val maxLength = 1000
                        val firstImageUri = if (listsImage.isNotEmpty()) listsImage[0] else null
                        val textt = "Recepie: $text\n\nContent: $text2"
                        if (textt.length > maxLength) {
                            scope.launch {
                                val parts = textt.chunked(maxLength)
                                var inten: Intent? = null
                                for (i in parts.indices.reversed()) {
                                    if (i == 0 && firstImageUri != null) {
                                        inten = Intent().apply {
                                            action = Intent.ACTION_SEND
                                            putExtra(Intent.EXTRA_TEXT, parts[i])
                                            type = "text/plain"
                                            putExtra(Intent.EXTRA_STREAM, Uri.parse(firstImageUri))
                                            type = "*/*"
                                            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                        }
                                        context.startActivity(
                                            Intent.createChooser(inten, context.getString(
                                                R.string.onerec_share_recepie_via)))
                                    } else {
                                        delay(1000)
                                        val nextShareIntent = Intent().apply { action = Intent.ACTION_SEND
                                            putExtra(Intent.EXTRA_TEXT, parts[i])
                                            type = "text/plain"
                                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                            inten?.component?.let { component ->
                                                this.component = component
                                            }
                                        }
                                        context.startActivity(
                                            Intent.createChooser(nextShareIntent, context.getString(
                                                R.string.onerec_share_recepie_via)))
                                    }
                                }
                            }
                        } else {
                            val shareIntent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, text)
                                type = "text/plain"
                                if (firstImageUri != null) {
                                    putExtra(
                                        Intent.EXTRA_STREAM,
                                        Uri.parse(firstImageUri)
                                    )
                                    type = "*/*"
                                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                }
                            }
                            context.startActivity(
                                Intent.createChooser(
                                    shareIntent,
                                    context.getString(R.string.onerec_share_recepie_via)
                                )
                            )
                        }
                    }
                )
                Image (painter = painterResource(R.drawable.baseline_picture_as_pdf_24), contentDescription = "pdf",
                    modifier = Modifier.size(30.dp).clickable {
                        showDialogPdf.value = true
                    }
                )
                if (showDialogPdf.value) {
                    AlertDialog(
                        onDismissRequest = { showDialogPdf.value = false },
                        containerColor = colorResource(id = R.color.white),
                        title = { Text(text = stringResource(R.string.enter_file_name), color = colorResource(id = R.color.boloto),
                            fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                        text = {
                            Column {
                                OutlinedTextField(
                                    value = field1.value,
                                    placeholder = { Text(stringResource(R.string.placeholder_enter_file_name), color = colorResource(id = R.color.boloto), fontSize = 14.sp) },
                                    trailingIcon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "clear",
                                        modifier = Modifier.clickable { field1.value = ""},
                                        tint = colorResource(id = R.color.boloto)
                                    ) },
                                    onValueChange = { field1.value = it },
                                    modifier = Modifier.padding(top = 8.dp),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedTextColor = colorResource(R.color.boloto),
                                        focusedBorderColor = colorResource(id = R.color.boloto),
                                        unfocusedBorderColor = colorResource(id = R.color.boloto),
                                        cursorColor = colorResource(id = R.color.boloto)
                                    )
                                )
                            }
                        },
                        confirmButton = {
                            Button(colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.boloto)
                            ),
                                onClick = {
                                    val filename = field1.value
                                    saveTextAsPdf(context, text, text2, filename, listsImage.toList())
                                    showDialogPdf.value = false
                                }) { Text(stringResource(R.string.save), color = colorResource(id = R.color.white), fontSize = 16.sp)
                            }
                        },
                        dismissButton = { Button(colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.boloto)
                        ),
                            onClick = { showDialogPdf.value = false }) {
                            Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                        }
                        })
                }
                Image (painter = painterResource(R.drawable.baseline_photo_size_select_actual_24), contentDescription = "photo",
                    modifier = Modifier.size(30.dp).clickable { panelState = PanelState.Expanded
                        isPressed = true}
                )
                Image (painter = painterResource(R.drawable.baseline_ondemand_video_24), contentDescription = "video",
                    modifier = Modifier.size(30.dp)
                        .clickable {
                            val modifiedList = listsVideo.filter { it != "video" }.toMutableList()
                            if (modifiedList.isEmpty()) {
                                modifiedList.add("video")
                            }
                            val encodedList = modifiedList.joinToString(",") { URLEncoder.encode(it, StandardCharsets.UTF_8.toString()) }
                            navController.navigate("VideoScreen/$encodedList/$text/$id/FiftyOneRecipeScreen")
                            Log.d("TAG", "VideoScreenEncodedList: $encodedList")
                        }
                )
            }
            Text(text = text, fontSize = 22.sp, color = colorResource(R.color.boloto),
                fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.interregular)),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(text = text2, fontSize = 16.sp, color = colorResource(R.color.boloto),
                fontFamily = FontFamily(Font(R.font.interregular)),
                modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 8.dp, vertical = 8.dp)
                    .verticalScroll(rememberScrollState())
            )
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
            Column(modifier = Modifier.fillMaxWidth().height(panelHeight).offset(y = animatedOffset)
                .border(1.dp, colorResource(R.color.black), shape = CutCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(brush = Brush.linearGradient(colors = listOf(
                    colorResource(R.color.boloto), colorResource(R.color.white)
                )), shape = CutCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom) {
                LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp).height(100.dp), state = rememberLazyListState()) {
                    items(listsImage){ item ->
                        Box(modifier = Modifier.size(100.dp).padding(horizontal = 8.dp).clickable {
                            selectedImage = item }, contentAlignment = Alignment.TopEnd) {
                            AsyncImage(model = item, contentDescription = "photo",
                                modifier = Modifier.fillMaxSize().clip(CutCornerShape(bottomStart = 16.dp))
                                    .border(2.dp, colorResource(R.color.white), shape = CutCornerShape(bottomStart = 16.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Box(modifier = Modifier.size(24.dp).padding(end = 4.dp, top = 4.dp).background(
                                Color.Black, RoundedCornerShape(12.dp)
                            ).clickable{
                                onDelete(item) }, contentAlignment = Alignment.Center) {
                                Icon(painter = painterResource(R.drawable.delete), contentDescription = "delete",
                                    modifier = Modifier.size(14.dp), tint = Color.White
                                )
                            }
                        }
                    }
                }
                Row(modifier = Modifier.fillMaxWidth().padding(start = 24.dp, bottom = 8.dp), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start){
                    Image (painter = painterResource(R.drawable.baseline_add_photo_alternate_24), contentDescription = "gallery",
                        modifier = Modifier.size(35.dp).offset(x = 16.dp).clickable {
                            showImagePicker = true
                            isGallery = true
                            launchPhotoPicker.invoke()
                        }
                    )
                    Image (painter = painterResource(R.drawable.baseline_add_a_photo_24), contentDescription = "camera",
                        modifier = Modifier.size(30.dp).offset(x = 32.dp).clickable {
                            showImagePicker = true
                            isCamera = true
                            launchCamera.invoke()
                        }
                    )
                    Icon(painter = painterResource(R.drawable.delete), contentDescription = "deleteall",
                        modifier = Modifier.size(25.dp).offset(x = 48.dp).clickable {
                            showDialogDeleteAll.value = true
                        }, tint = colorResource(R.color.white)
                    )
                    if (showDialogDeleteAll.value) {
                        AlertDialog(onDismissRequest = { showDialogDeleteAll.value = false },
                            containerColor = colorResource(id = R.color.white),
                            title = { androidx.compose.material.Text(
                                stringResource(R.string.confirm),
                                color = colorResource(id = R.color.boloto),
                                fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            },
                            text = { androidx.compose.material.Text(
                                stringResource(R.string.delete_all_photos),
                                color = colorResource(id = R.color.boloto)
                            )
                            },
                            confirmButton = {
                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.boloto)
                                ), onClick = {
                                    deleteAllImages()
                                    showDialogDeleteAll.value = false
                                }) {
                                    androidx.compose.material.Text(
                                        stringResource(R.string.yes), color = colorResource(id = R.color.white),
                                        fontSize = 16.sp
                                    )
                                }
                            },
                            dismissButton = {
                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.boloto)
                                ),
                                    onClick = { showDialogDeleteAll.value = false
                                    }) {
                                    androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                }
                            })
                    }
                }
                AsyncImage(model = selectedImage, contentDescription = "bigphoto",
                    modifier = Modifier .width(if (isPressed) expandedImageWidth else collapsedImageWidth)
                        .height(if (isPressed) expandedImageHeight else collapsedImageHeight)
                        .padding(horizontal = 8.dp).clip(RoundedCornerShape(16.dp)),
                    placeholder = painterResource(R.drawable.noimage),
                    error = painterResource(R.drawable.noimage),
                    fallback = painterResource(R.drawable.noimage),
                    contentScale = if(isPressed) ContentScale.Crop else ContentScale.Fit
                )
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End){
                    Image(painter = painterResource(if(isPressed) R.drawable.baseline_fullscreen_exit_24 else R.drawable.baseline_fullscreen_24),
                        contentDescription = "big", modifier = Modifier.size(40.dp).clickable { if(isPressed){ panelState = PanelState.Hidden
                            isPressed = false
                        }else{ panelState = PanelState.Expanded
                            isPressed = true
                        } }, contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}