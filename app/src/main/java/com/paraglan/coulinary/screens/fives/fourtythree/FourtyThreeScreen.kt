package com.paraglan.coulinary.screens.fives.fourtythree

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ShareCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.paraglan.coulinary.R
import com.paraglan.coulinary.database.AppDatabase
import com.paraglan.coulinary.database.Four
import com.paraglan.coulinary.database.FourLinks
import com.paraglan.coulinary.database.FourtyThree
import com.paraglan.coulinary.database.FourtyThreeLinks
import com.paraglan.coulinary.screens.ImagePicker
import com.paraglan.coulinary.screens.PanelState
import com.paraglan.coulinary.screens.ones.one.isNetworkAvailable
import com.paraglan.coulinary.screens.saveImageToFile2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourtyThreeScreen(navController: NavController) {
    var isSearchIconClicked by remember { mutableStateOf(false) }
    val context = LocalContext.current as Activity
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val dairyList by db.fourtyThreeDao().getAll().collectAsState(initial = emptyList())
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by remember { mutableStateOf("") }
    var commentForLink by remember { mutableStateOf("") }
    var titleLink by remember { mutableStateOf("") }
    var newTitleText by remember { mutableStateOf("") }
    var newContentText by remember { mutableStateOf("") }
    var panelStateLeft by remember { mutableStateOf(PanelState.Hidden) }
    var panelStateRight by remember { mutableStateOf(PanelState.Hidden) }
    val listState = rememberLazyListState()
    var isLoading by remember { mutableStateOf(false) }
    var isFirstLaunch by remember { mutableStateOf(true) }
    var selectedRecipeId by remember { mutableStateOf<Int>(0) }
    var selectedRecipeVideo by remember { mutableStateOf<Uri?>(null) }

    val itemsFlow: Flow<List<FourtyThreeLinks>> = db.fourtyThreeLinksDao().getAll()
    val fourtyThreelistFlow: Flow<List<FourtyThree>> = db.fourtyThreeDao().getAll()
    val links by itemsFlow.collectAsState(initial = emptyList())
    val showDialogLinkDeleteAll = remember { mutableStateOf(false) }
    val showDialogAddNewLink = remember { mutableStateOf(false) }
    val showDialogDeleteItemLink = remember { mutableStateOf(false) }
    val showDialogLinkEditComment = remember { mutableStateOf(false) }
    var showDialogDeleteItemRecipe = remember { mutableStateOf(false) }
    var showDialogEditItemRecipe = remember { mutableStateOf(false) }
    var selectedDeleteItemRecipe by remember { mutableStateOf<FourtyThree?>(null) }
    var selectedEditItemRecipe by remember { mutableStateOf<FourtyThree?>(null) }
    var selectedDeleteItemLink by remember { mutableStateOf<FourtyThreeLinks?>(null) }
    var selectedEditItemLink by remember { mutableStateOf<FourtyThreeLinks?>(null) }

    var selectedImageUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var launchCamera: () -> Unit = {}
    var launchPhotoPicker: () -> Unit = {}
    ImagePicker(
        onImageSelected = { uri ->
            selectedImageUri = uri
            bitmap = null
        },
        onBitmapSelected = { btm ->
            if (btm != null) {
                val uri = saveImageToFile2(context, btm)
                bitmap = btm
                selectedImageUri = uri
            }
        },
        onLaunchCamera = { cameraLauncher ->
            launchCamera = cameraLauncher
        },
        onLaunchPhotoPicker = { photoPickerLauncher ->
            launchPhotoPicker = photoPickerLauncher
        }
    )
    //выдвижная панель слева
    val panelWidthLeft = 350.dp
    val animatedOffsetLeft by animateDpAsState(
        targetValue = if (panelStateLeft == PanelState.Expanded) 0.dp else panelWidthLeft,
        animationSpec = tween(durationMillis = 300)
    )
    //выдвижная панель справа
    val panelWidthRight = 350.dp
    val animatedOffsetRight by animateDpAsState(
        targetValue = if (panelStateRight == PanelState.Expanded) 0.dp else panelWidthRight,
        animationSpec = tween(durationMillis = 300)
    )
    val filteredList = if (searchText.isEmpty()) {
        dairyList
    } else {
        dairyList.filter { it.title.contains(searchText, ignoreCase = true) }
    }
    LaunchedEffect(key1 = isSearchIconClicked) {
        if (isSearchIconClicked) {
            focusRequester.requestFocus()
            keyboardController?.show()
            isSearchIconClicked = false
        }
    }
    LaunchedEffect(key1 = links) {
        if (!isFirstLaunch && links.isNotEmpty()) {
            listState.animateScrollToItem(links.size - 1)
        }
        if (links.isNotEmpty()) {
            isFirstLaunch = false
        }
    }
    LaunchedEffect(key1 = isFirstLaunch) {
        if (isFirstLaunch) {
            listState.scrollToItem(0)
        }
    }
    LaunchedEffect(key1 = bitmap) {
        if (bitmap != null) {
            Log.d("FourtyThreeScreen", "LaunchedEffect bitmap: $bitmap")
        }
    }

    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Image(painter = painterResource(R.drawable.foncook), contentDescription = "foncook",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
                Image(painter = painterResource(R.drawable.links),
                    contentDescription = "links", modifier = Modifier.size(40.dp).clickable {
                        panelStateLeft = PanelState.Expanded
                    }, contentScale = ContentScale.FillBounds
                )
                TextField(value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier.weight(1f).focusRequester(focusRequester).onKeyEvent {
                        if (it.key == Key.Enter) {
                            keyboardController?.hide()
                            true
                        } else {
                            false
                        }
                    },
                    placeholder = { Text(stringResource(R.string.search), color = colorResource(R.color.boloto)) },
                    leadingIcon = {   Icon(
                        Icons.Default.Search, contentDescription = "search",
                        tint = colorResource(R.color.boloto), modifier = Modifier.clickable {
                            isSearchIconClicked = true
                        }
                    ) },
                    trailingIcon = {  if (searchText.isNotEmpty()) {
                        Icon(
                            Icons.Default.Close, contentDescription = "close",
                            tint = colorResource(R.color.boloto), modifier = Modifier.clickable {
                                searchText = ""
                                focusRequester.freeFocus()
                                keyboardController?.hide()
                            }
                        )
                    } },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(R.color.lightgray),
                        cursorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(color = colorResource(R.color.boloto), fontSize = 24.sp),
                    singleLine = true,
                    keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = androidx.compose.foundation.text.KeyboardActions(onSearch = {
                        keyboardController?.hide()
                    })
                )
                Icon(painter = painterResource(R.drawable.baseline_add_box_24), contentDescription = "box",
                    modifier = Modifier.size(40.dp).clickable {
                        selectedImageUri = null
                        newTitleText = ""
                        newContentText = ""
                        selectedRecipeVideo = null
                        selectedRecipeId = 0
                        panelStateRight = PanelState.Expanded
                    }, tint = colorResource(R.color.yellow)
                )
            }
            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 4.dp, bottom = 4.dp)) {
                itemsIndexed(filteredList) {index, item ->
                    Card(modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                        .fillMaxWidth().height(120.dp).background(Color.Transparent).clickable {
                            if(item.images.isEmpty()){
                                val encodedImageUri = R.drawable.noimage.toString()
                                val encodedVideoUri = URLEncoder.encode(item.videos, StandardCharsets.UTF_8.toString()) ?: "video"
                                navController.navigate("FourtyThreeRecipeScreen/${item.title}/${item.content}/$encodedImageUri/$encodedVideoUri/${item.id}")
                            } else {
                                val encodedImageUri = URLEncoder.encode(item.images, StandardCharsets.UTF_8.toString())
                                val encodedVideoUri = URLEncoder.encode(item.videos, StandardCharsets.UTF_8.toString()) ?: "video"
                                navController.navigate("FourtyThreeRecipeScreen/${item.title}/${item.content}/$encodedImageUri/$encodedVideoUri/${item.id}")
                            }

                        },
                        shape = CutCornerShape(bottomStart = 8.dp),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.boloto)),
                    ){
                        Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center){
                            Box(modifier = Modifier.fillMaxHeight().weight(1f), contentAlignment = Alignment.TopEnd) {
                                Row(modifier = Modifier.fillMaxHeight().background(colorResource(R.color.white)),
                                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                    val firstImageUri = item.images.split(",")
                                        .firstOrNull { it.startsWith("content://") }
                                        ?.trim()
                                        ?: item.images.split(",").firstOrNull()?.trim()
                                    val imageModel = if (firstImageUri.isNullOrEmpty()
                                        || firstImageUri == R.drawable.noimage.toString()) {
                                        R.drawable.noimage
                                    } else {
                                        firstImageUri
                                    }
                                    AsyncImage(model = ImageRequest.Builder(context).data(imageModel)
                                        .crossfade(true).build(),
                                        contentDescription = "choice_image",
                                        modifier = Modifier.fillMaxHeight().width(150.dp).fillMaxHeight(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(text = item.title, modifier = Modifier.fillMaxWidth()
                                        .wrapContentHeight(Alignment.CenterVertically).padding(end = 8.dp),
                                        textAlign = TextAlign.Center,
                                        fontSize = 24.sp, color = colorResource(id = R.color.boloto),
                                        fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.interregular))
                                    )
                                }
                            }
                            Column(modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally){
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    androidx.compose.material.Text(
                                        text = "${index + 1}",
                                        modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                        textAlign = TextAlign.Center,
                                        fontSize = 12.sp,
                                        color = colorResource(id = R.color.boloto),
                                    )
                                    val isFavourite by produceState<Boolean>(initialValue = false, item.title) {
                                        value = db.favouritesDao().isFavourite(item.title, "FourtyThreeRecipeScreen")
                                    }
                                    Icon(painter = painterResource(id = if (isFavourite) R.drawable.baseline_favorite_24 else
                                        R.drawable.baseline_favorite_border_24),
                                        contentDescription = "show_favourites",
                                        modifier = Modifier.size(25.dp).padding(end = 8.dp, bottom = 4.dp),
                                        tint = Color.Unspecified
                                    )
                                }
                                Image(painter = painterResource(id = R.drawable.edit),
                                    contentDescription = "edit_item", modifier = Modifier.size(30.dp)
                                        .padding(end = 8.dp, bottom = 4.dp).clickable {
                                            showDialogEditItemRecipe.value = true
                                            selectedEditItemRecipe = item
                                        }
                                )
                                if (showDialogEditItemRecipe.value) {
                                    AlertDialog(onDismissRequest = { showDialogEditItemRecipe.value = false },
                                        containerColor = colorResource(id = R.color.white),
                                        title = { androidx.compose.material.Text(
                                            stringResource(R.string.confirm),
                                            color = colorResource(id = R.color.boloto),
                                            fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                        },
                                        text = { androidx.compose.material.Text(
                                            stringResource(R.string.edit_recipe),
                                            color = colorResource(id = R.color.boloto)
                                        )
                                        },
                                        confirmButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.boloto)
                                            ), onClick = {
                                                panelStateRight = PanelState.Expanded
                                                newTitleText = selectedEditItemRecipe!!.title ?: ""
                                                newContentText = selectedEditItemRecipe!!.content ?: ""
                                                selectedImageUri = selectedEditItemRecipe!!.images.toUri()
                                                selectedRecipeVideo = selectedEditItemRecipe!!.videos.toUri()
                                                selectedRecipeId = selectedEditItemRecipe!!.id
                                                focusRequester.freeFocus()
                                                keyboardController?.hide()
                                                showDialogEditItemRecipe.value = false
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
                                                onClick = { showDialogEditItemRecipe.value = false
                                                    focusRequester.freeFocus()
                                                    keyboardController?.hide()}) {
                                                androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                            }
                                        })
                                }
                                Image(painter = painterResource(id = R.drawable.delete),
                                    contentDescription = "delete_item", modifier = Modifier.size(30.dp)
                                        .padding(end = 8.dp, bottom = 4.dp).clickable {
                                            showDialogDeleteItemRecipe.value = true
                                            selectedDeleteItemRecipe = item
                                        }
                                )
                                if (showDialogDeleteItemRecipe.value) {
                                    AlertDialog(onDismissRequest = { showDialogDeleteItemRecipe.value = false },
                                        containerColor = colorResource(id = R.color.white),
                                        title = { androidx.compose.material.Text(
                                            stringResource(R.string.confirm),
                                            color = colorResource(id = R.color.boloto),
                                            fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                        },
                                        text = { androidx.compose.material.Text(
                                            stringResource(R.string.delete_recipe),
                                            color = colorResource(id = R.color.boloto)
                                        )
                                        },
                                        confirmButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.boloto)
                                            ), onClick = {
                                                scope.launch {
                                                    val imageUrisToDelete = selectedDeleteItemRecipe?.images?.split(",")
                                                        ?.filter { it.isNotBlank() }
                                                        ?.map { Uri.parse(it) } ?: emptyList()
                                                    selectedDeleteItemRecipe?.let { db.fourtyThreeDao().delete(it) }
                                                    imageUrisToDelete.forEach { imageUri ->
                                                        if (imageUri.scheme == "content") {
                                                            context.contentResolver.delete(imageUri, null, null)
                                                        } else if (imageUri.scheme == "file") {
                                                            val file = File(imageUri.path!!)
                                                            if (file.exists()) {
                                                                file.delete()
                                                            }
                                                        }
                                                    }
                                                    val videoUrisToDelete = selectedDeleteItemRecipe?.videos?.split(",")
                                                        ?.filter { it.isNotBlank() }
                                                        ?.map { Uri.parse(it) } ?: emptyList()
                                                    videoUrisToDelete.forEach { videoUri ->
                                                        if (videoUri.scheme == "content") {
                                                            context.contentResolver.delete(videoUri, null, null)
                                                        } else if (videoUri.scheme == "file") {
                                                            val file = File(videoUri.path!!)
                                                            if (file.exists()) {
                                                                file.delete()
                                                            }
                                                        }
                                                    }
                                                }
                                                focusRequester.freeFocus()
                                                keyboardController?.hide()
                                                showDialogDeleteItemRecipe.value = false
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
                                                onClick = { showDialogDeleteItemRecipe.value = false
                                                    focusRequester.freeFocus()
                                                    keyboardController?.hide()}) {
                                                androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                            }
                                        })
                                }
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){
            Column(modifier = Modifier.fillMaxHeight().width(panelWidthLeft)
                .offset(x = -animatedOffsetLeft)
                .border(1.dp, Color.Black, shape = CutCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
                .background(brush = Brush.linearGradient(
                    colors = listOf(colorResource(R.color.white), colorResource(R.color.trboloto)),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                ), shape = CutCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                ),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier.fillMaxWidth().padding(end = 24.dp, top = 16.dp),
                    horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(R.string.links), modifier = Modifier.offset(x = -70.dp),
                        textAlign = TextAlign.Start, fontWeight = FontWeight.Bold,
                        fontSize = 24.sp, color = colorResource(id = R.color.white),
                        fontFamily = FontFamily(Font(R.font.interregular))
                    )
                    if (isLoading) {
                        CircularProgressIndicator(color = colorResource(id = R.color.white),
                            modifier = Modifier.size(35.dp).offset(x = -16.dp))
                    }
                    Icon(painter = painterResource(id = R.drawable.baseline_add_box_24),
                        contentDescription = "add_new_link",
                        modifier = Modifier.size(40.dp).padding(end = 8.dp).offset(x = -12.dp).clickable {
                            commentForLink = ""
                            showDialogAddNewLink.value = true
                        }, tint = colorResource(R.color.yellow)
                    )
                    if (showDialogAddNewLink.value) {
                        AlertDialog(onDismissRequest = { showDialogAddNewLink.value = false },
                            containerColor = colorResource(id = R.color.white),
                            title = { androidx.compose.material.Text(
                                stringResource(R.string.enter_new_link),
                                color = colorResource(id = R.color.boloto), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            },
                            text = {
                                Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceEvenly,
                                    horizontalAlignment = Alignment.CenterHorizontally){
                                    TextField(value = titleLink,
                                        onValueChange = { titleLink = it },
                                        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                                            .border(2.dp, colorResource(R.color.boloto), RoundedCornerShape(16.dp))
                                            .focusRequester(focusRequester).onKeyEvent {
                                                if (it.key == Key.Enter) {
                                                    keyboardController?.hide()
                                                    true
                                                } else {
                                                    false
                                                }
                                            },
                                        placeholder = { Text(context.getString(R.string.enter_link), color = colorResource(
                                            R.color.boloto)
                                        ) },
                                        trailingIcon = {  if (titleLink.isNotEmpty()) {
                                            Icon(
                                                Icons.Default.Close, contentDescription = "close",
                                                tint = colorResource(R.color.boloto), modifier = Modifier.clickable {
                                                    titleLink = ""
                                                    focusRequester.freeFocus()
                                                    keyboardController?.hide()
                                                }
                                            )
                                        } },
                                        shape = RoundedCornerShape(16.dp),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.white),
                                            cursorColor = colorResource(R.color.boloto),
                                            unfocusedIndicatorColor = colorResource(R.color.boloto),
                                            focusedIndicatorColor = colorResource(R.color.boloto)
                                        ),
                                        textStyle = TextStyle(color = colorResource(R.color.boloto), fontSize = 16.sp),
                                        singleLine = true,
                                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(imeAction = ImeAction.Search),
                                        keyboardActions = androidx.compose.foundation.text.KeyboardActions(onSearch = {
                                            keyboardController?.hide()
                                        })
                                    )
                                    TextField(value = commentForLink,
                                        onValueChange = { commentForLink = it },
                                        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp)
                                            .border(2.dp, colorResource(R.color.boloto), RoundedCornerShape(16.dp))
                                            .focusRequester(focusRequester).onKeyEvent {
                                                if (it.key == Key.Enter) {
                                                    keyboardController?.hide()
                                                    true
                                                } else {
                                                    false
                                                }
                                            },
                                        placeholder = { Text(
                                            stringResource(R.string.enter_comment), color = colorResource(
                                                R.color.boloto)
                                        ) },
                                        trailingIcon = {  if (commentForLink.isNotEmpty()) {
                                            Icon(
                                                Icons.Default.Close, contentDescription = "close",
                                                tint = colorResource(R.color.boloto), modifier = Modifier.clickable {
                                                    commentForLink = ""
                                                    focusRequester.freeFocus()
                                                    keyboardController?.hide()
                                                }
                                            )
                                        } },
                                        shape = RoundedCornerShape(16.dp),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.white),
                                            cursorColor = colorResource(R.color.boloto),
                                            unfocusedIndicatorColor = colorResource(R.color.boloto),
                                            focusedIndicatorColor = colorResource(R.color.boloto)
                                        ),
                                        textStyle = TextStyle(color = colorResource(R.color.boloto), fontSize = 16.sp),
                                        singleLine = true,
                                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(imeAction = ImeAction.Search),
                                        keyboardActions = androidx.compose.foundation.text.KeyboardActions(onSearch = {
                                            keyboardController?.hide()
                                        })
                                    )
                                }
                            },
                            confirmButton = {
                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.boloto)
                                ), onClick = {
                                    scope.launch {
                                        parseFourtyThreeLinkAndSave(context = context, titleLink = titleLink, db = db,
                                            scope = scope, onSuccess = {
                                                showDialogAddNewLink.value = false
                                                titleLink = ""
                                            }, comment = commentForLink, id = 0, listState = listState, links = links,
                                            setIsLoading = { isLoading = it }
                                        )
                                    }
                                    showDialogAddNewLink.value = false
                                }) { Text(stringResource(R.string.yes), color = colorResource(id = R.color.white), fontSize = 16.sp) }
                            },
                            dismissButton = {
                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.boloto)
                                ),
                                    onClick = { showDialogAddNewLink.value = false
                                        focusRequester.freeFocus()
                                        keyboardController?.hide()}) {
                                    androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                }
                            })
                    }
                    Image(painter = painterResource(id = R.drawable.delete),
                        contentDescription = "delete_all_links",
                        modifier = Modifier.size(35.dp).padding(end = 8.dp).offset(x = -8.dp).clickable {
                            showDialogLinkDeleteAll.value = true
                        }
                    )
                    if (showDialogLinkDeleteAll.value) {
                        AlertDialog(onDismissRequest = { showDialogLinkDeleteAll.value = false },
                            containerColor = colorResource(id = R.color.white),
                            title = { androidx.compose.material.Text(
                                stringResource(R.string.confirm),
                                color = colorResource(id = R.color.boloto),
                                fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            },
                            text = { androidx.compose.material.Text(
                                stringResource(R.string.delete_all_links),
                                color = colorResource(id = R.color.boloto)
                            )
                            },
                            confirmButton = {
                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.boloto)
                                ), onClick = {
                                    scope.launch {
                                        db.fourtyThreeLinksDao().deleteAll()
                                    }
                                    focusRequester.freeFocus()
                                    keyboardController?.hide()
                                    showDialogLinkDeleteAll.value = false
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
                                    onClick = { showDialogLinkDeleteAll.value = false
                                        focusRequester.freeFocus()
                                        keyboardController?.hide()}) {
                                    androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                }
                            })
                    }
                    Icon(painter = painterResource(R.drawable.exitleft), contentDescription = "exitlinks",
                        modifier = Modifier.size(30.dp).clickable {
                            focusRequester.freeFocus()
                            keyboardController?.hide()
                            panelStateLeft = PanelState.Hidden },
                        tint = colorResource(R.color.white)
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 8.dp), state = listState) {
                    items(links){ item ->
                        Box(modifier = Modifier.fillMaxWidth().height(370.dp).padding(horizontal = 16.dp, vertical = 8.dp)
                            .border(1.dp, color = colorResource(R.color.yellow), RoundedCornerShape(16.dp))
                            .background(Color.Transparent, RoundedCornerShape(16.dp))){
                            Image(painter = painterResource(R.drawable.foncook), contentDescription = "foncook",
                                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp)), contentScale = ContentScale.FillBounds
                            )
                            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly){
                                Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly){
                                    Text(text = item.comment, fontSize = 16.sp,
                                        color = colorResource(R.color.red), fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font(R.font.interregular)), modifier = Modifier.weight(1f).padding(start = 8.dp)
                                    )
                                    Image(painter = painterResource(id = R.drawable.edit),
                                        contentDescription = "edit link",
                                        modifier = Modifier.size(20.dp).offset(x = -24.dp).clickable {
                                            selectedEditItemLink = item
                                            showDialogLinkEditComment.value = true
                                        }
                                    )
                                    key(selectedEditItemLink) {
                                        if (showDialogLinkEditComment.value) {
                                            var tempComment by remember { mutableStateOf(selectedEditItemLink?.comment ?: "") }
                                            AlertDialog(onDismissRequest = { showDialogLinkEditComment.value = false },
                                                containerColor = colorResource(id = R.color.white),
                                                title = { androidx.compose.material.Text(
                                                    stringResource(R.string.confirm),
                                                    color = colorResource(id = R.color.boloto),
                                                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                                },
                                                text = {
                                                    OutlinedTextField(value = tempComment,
                                                        onValueChange = { tempComment = it },
                                                        placeholder = {
                                                            Text(
                                                                stringResource(R.string.enter_comment), color = colorResource(
                                                                    R.color.boloto)
                                                            )
                                                        },
                                                        trailingIcon = {  if (tempComment.isNotEmpty()) {
                                                            Icon(
                                                                Icons.Default.Close, contentDescription = "clear",
                                                                tint = colorResource(R.color.boloto), modifier = Modifier.clickable {
                                                                    tempComment = ""
                                                                }
                                                            )
                                                        } },
                                                        textStyle = TextStyle(color = colorResource(
                                                            R.color.boloto), fontSize = 20.sp),
                                                        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 8.dp)
                                                            .border(2.dp, colorResource(R.color.boloto), RoundedCornerShape(16.dp)),
                                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                                            focusedBorderColor = colorResource(R.color.boloto),
                                                            unfocusedBorderColor = colorResource(R.color.boloto),
                                                            cursorColor = colorResource(R.color.boloto),
                                                            focusedPlaceholderColor = colorResource(
                                                                R.color.boloto),
                                                            focusedTextColor = colorResource(R.color.boloto)
                                                        ),
                                                        shape = RoundedCornerShape(16.dp)
                                                    )
                                                },
                                                confirmButton = {
                                                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                        containerColor = colorResource(id = R.color.boloto)
                                                    ), onClick = {
                                                        scope.launch {
                                                            selectedEditItemLink?.let { it.comment = tempComment
                                                                db.fourtyThreeLinksDao().upsertLink(it)
                                                            }
                                                        }
                                                        focusRequester.freeFocus()
                                                        keyboardController?.hide()
                                                        showDialogLinkEditComment.value = false
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
                                                        onClick = { showDialogLinkEditComment.value = false
                                                            focusRequester.freeFocus()
                                                            keyboardController?.hide()}) {
                                                        androidx.compose.material.Text(
                                                            stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                                    }
                                                })
                                        }
                                    }
                                    Image(painter = painterResource(R.drawable.share), contentDescription = "share",
                                        modifier = Modifier.size(20.dp).offset(x = -16.dp).clickable {
                                            val shareIntent = ShareCompat.IntentBuilder.from(context as Activity).setType("text/plain")
                                                .setText(item.link)
                                                .intent
                                            context.startActivity(Intent.createChooser(shareIntent, null))
                                        }
                                    )
                                    Image(painter = painterResource(R.drawable.delete), contentDescription = "deleteItem",
                                        modifier = Modifier.size(20.dp).offset(x = -8.dp).clickable {
                                            showDialogDeleteItemLink.value = true
                                            selectedDeleteItemLink = item
                                        }
                                    )
                                    if (showDialogDeleteItemLink.value) {
                                        AlertDialog(onDismissRequest = { showDialogDeleteItemLink.value = false },
                                            containerColor = colorResource(id = R.color.white),
                                            title = { androidx.compose.material.Text(
                                                stringResource(R.string.confirm),
                                                color = colorResource(id = R.color.boloto), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                            },
                                            text = { Text(
                                                stringResource(R.string.delete_link), color = colorResource(id = R.color.boloto),
                                                fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                            },
                                            confirmButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.boloto)
                                                ), onClick = {
                                                    scope.launch {
                                                        selectedDeleteItemLink?.let {
                                                            db.fourtyThreeLinksDao().deleteLinks(it)
                                                        }
                                                    }
                                                    showDialogDeleteItemLink.value = false
                                                }) { Text(stringResource(R.string.yes), color = colorResource(id = R.color.white), fontSize = 16.sp) }
                                            },
                                            dismissButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.boloto)
                                                ),
                                                    onClick = { showDialogDeleteItemLink.value = false
                                                        focusRequester.freeFocus()
                                                        keyboardController?.hide()}) {
                                                    androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                                }
                                            })
                                    }
                                }
                                AsyncImage(model = item.image, contentDescription = "playerphoto",
                                    modifier = Modifier.fillMaxWidth().height(200.dp).padding(horizontal = 16.dp).clip(
                                        RoundedCornerShape(16.dp)
                                    )
                                        .aspectRatio(16f / 9f),
                                    placeholder = painterResource(R.drawable.noimage),
                                    error = painterResource(R.drawable.noimage),
                                    fallback = painterResource(R.drawable.noimage)
                                )
                                Text(text = item.title, fontSize = 14.sp, color = colorResource(R.color.boloto),
                                    fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.interregular)),
                                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                                )
                                val annotatedText = buildAnnotatedString {
                                    pushStringAnnotation(tag = "URL", annotation = item.link)
                                    withStyle(
                                        style = SpanStyle(
                                            color = colorResource(id = R.color.blue),
                                            textDecoration = TextDecoration.Underline
                                        )
                                    ) {
                                        append(item.link)
                                    }
                                    pop()
                                }
                                ClickableText(
                                    text = annotatedText,
                                    onClick = { offset ->
                                        annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                                            .firstOrNull()?.let { annotation ->
                                                val url = annotation.item
                                                val intent = Intent(Intent.ACTION_VIEW)
                                                intent.data = Uri.parse(url)
                                                try {
                                                    context.startActivity(intent)
                                                } catch (e: ActivityNotFoundException) {
                                                    Toast.makeText(context,
                                                        context.getString(R.string.please_check_your_link), Toast.LENGTH_SHORT).show()
                                                    e.printStackTrace()
                                                }
                                            }
                                    },
                                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 16.dp, end = 32.dp, bottom = 8.dp)
                                )
                            }
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd){
                                Image(painter = painterResource(R.drawable.copy), contentDescription = "copy",
                                    modifier = Modifier.size(40.dp).offset(x = -8.dp, y = -8.dp).clickable {
                                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                        val clip = ClipData.newPlainText("Copied Text", item.link)
                                        clipboard.setPrimaryClip(clip)
                                        Toast.makeText(context, context.getString(R.string.the_link_is_copied), Toast.LENGTH_SHORT).show()
                                    }, contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd){
            Column(modifier = Modifier.fillMaxHeight().width(panelWidthRight)
                .offset(x = animatedOffsetRight)
                .border(1.dp, color = Color.Black, shape = CutCornerShape(topStart = 16.dp, bottomStart = 16.dp)).background( brush = Brush.linearGradient(
                    colors = listOf(colorResource(R.color.trboloto), colorResource(R.color.white)),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                ),
                    shape = CutCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                ),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier.fillMaxWidth().padding(start = 24.dp, top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(R.drawable.exitright), contentDescription = "exitresources",
                        modifier = Modifier.size(30.dp).clickable {
                            panelStateRight = PanelState.Hidden
                            focusRequester.freeFocus()
                            keyboardController?.hide()
                        }, tint = colorResource(R.color.white)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.width(200.dp).padding(end = 4.dp)) {
                        Image(painter = painterResource(R.drawable.baseline_save_24),
                            contentDescription = "saveicon",
                            modifier = Modifier.size(35.dp).clickable {
                                if(newTitleText.isNotEmpty() && newContentText.isNotEmpty()){
                                    val imageToSave = selectedImageUri?.toString() ?: R.drawable.noimage.toString()
                                    val videoToSave = selectedRecipeVideo?.toString() ?: "video"
                                    val recipe = FourtyThree(title = newTitleText, content = newContentText,
                                        images = imageToSave, videos = videoToSave, id = selectedRecipeId)
                                    scope.launch { db.fourtyThreeDao().upsert(recipe) }
                                    focusRequester.freeFocus()
                                    keyboardController?.hide()
                                    panelStateRight = PanelState.Hidden
                                } else {
                                    Toast.makeText(context, context.getString(R.string.enter_title_and_recipe), Toast.LENGTH_SHORT).show()
                                }
                            }
                        )
                        Image(painter = painterResource(R.drawable.baseline_add_a_photo_24),
                            contentDescription = "cameraicon",
                            modifier = Modifier.size(30.dp).clickable {
                                launchCamera()
                            }
                        )
                        Image(painter = painterResource(R.drawable.baseline_add_photo_alternate_24), contentDescription = "galleryicon",
                            modifier = Modifier.size(35.dp).clickable { launchPhotoPicker() }
                        )
                        Icon(painter = painterResource(R.drawable.delete), contentDescription = "deletephoto",
                            modifier = Modifier.size(25.dp).clickable {
                                selectedImageUri = null
                                bitmap = null
                            }, tint = Color.White
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().height(700.dp)
                    .imePadding().padding(top = 8.dp).verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    if (bitmap != null && !bitmap!!.isRecycled) {
                        Image(bitmap = bitmap!!.asImageBitmap(), contentDescription = "playerphoto",
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).width(300.dp)
                                .height(180.dp).clip(RoundedCornerShape(16.dp)), contentScale = ContentScale.Crop
                        )
                    } else if (selectedImageUri != null) {
                        Image(painter = rememberAsyncImagePainter(model = selectedImageUri,
                            placeholder = painterResource(R.drawable.noimage), error = painterResource(
                                R.drawable.noimage),
                            fallback = painterResource(R.drawable.noimage)
                        ),
                            contentDescription = "playerphoto",
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).width(300.dp).height(180.dp)
                                .clip(RoundedCornerShape(16.dp)), contentScale = ContentScale.Crop
                        )
                    } else {
                        Icon(painter = painterResource(R.drawable.noimage), contentDescription = "playerphoto",
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).width(200.dp).height(100.dp)
                                .clip(RoundedCornerShape(16.dp)), tint = Color.White
                        )
                    }

                    TextField(
                        value = newTitleText,
                        onValueChange = { newTitleText = it },
                        modifier = Modifier.fillMaxWidth().focusRequester(focusRequester).onKeyEvent {
                            if (it.key == Key.Enter) {
                                keyboardController?.hide()
                                true
                            } else {
                                false
                            }
                        },
                        placeholder = {
                            Text(context.getString(R.string.enter_title_new_recipe), color = colorResource(
                                R.color.boloto)
                            )
                        },
                        trailingIcon = {
                            if (newTitleText.isNotEmpty()) {
                                Icon(
                                    Icons.Default.Close, contentDescription = "close",
                                    tint = colorResource(R.color.boloto), modifier = Modifier.clickable { newTitleText = "" }
                                )
                            }
                        },
                        shape = RoundedCornerShape(0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.white),
                            cursorColor = colorResource(R.color.boloto),
                            unfocusedIndicatorColor = colorResource(R.color.boloto),
                            focusedIndicatorColor = colorResource(R.color.boloto)
                        ),
                        textStyle = TextStyle(color = colorResource(R.color.boloto), fontSize = 22.sp),
                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(imeAction = ImeAction.Default),
                        keyboardActions = androidx.compose.foundation.text.KeyboardActions(onSearch = {
                            keyboardController?.hide()
                        }),
                        singleLine = false
                    )
                    TextField(
                        value = newContentText,
                        onValueChange = { newContentText = it },
                        modifier = Modifier.fillMaxWidth().weight(1f).focusRequester(focusRequester)
                            .onKeyEvent {
                                if (it.key == Key.Enter) {
                                    keyboardController?.hide()
                                    true
                                } else {
                                    false
                                }
                            },
                        placeholder = {
                            Text(context.getString(R.string.enter_content_new_recipe), color = colorResource(
                                R.color.boloto)
                            )
                        },
                        trailingIcon = { if (newContentText.isNotEmpty()) {
                            Icon(
                                Icons.Default.Close, contentDescription = "close",
                                tint = colorResource(R.color.boloto), modifier = Modifier.clickable { newContentText = "" }
                            )
                        }
                        },
                        shape = RoundedCornerShape(0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.white),
                            cursorColor = colorResource(R.color.boloto),
                            unfocusedIndicatorColor = colorResource(R.color.boloto),
                            focusedIndicatorColor = colorResource(R.color.boloto)
                        ),
                        textStyle = TextStyle(color = colorResource(R.color.boloto), fontSize = 16.sp),
                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(imeAction = ImeAction.Default),
                        keyboardActions = androidx.compose.foundation.text.KeyboardActions(onSearch = {
                            keyboardController?.hide()
                        }),
                        singleLine = false
                    )
                }
            }
        }
    }
}
fun parseFourtyThreeLinkAndSave(context: Context, titleLink: String, db: AppDatabase, scope: CoroutineScope,
                         onSuccess: () -> Unit, comment : String, id: Int, listState: LazyListState, links: List<FourtyThreeLinks>,
                         setIsLoading: (Boolean) -> Unit) {
    if (!isNetworkAvailable(context)) {
        setIsLoading(false)
        scope.launch(Dispatchers.Main) {
            Toast.makeText(context,
                context.getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show()
        }
        return
    }
    setIsLoading(true)
    scope.launch(Dispatchers.IO) {
        var textLink = ""
        var imageLink = ""
        var title = ""
        try {
            val client = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()
            val request = Request.Builder()
                .url(titleLink)
                .build()
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val html = response.body?.string()
                if (html != null) {
                    val doc: Document = Jsoup.parse(html)
                    val metaTitle = doc.select("meta[property=og:title]").attr("content")
                    val metaDescription = doc.select("meta[property=og:description]").attr("content")
                    val metaImage = doc.select("meta[property=og:image]").attr("content")
                    val metaUrl = doc.select("meta[property=og:url]").attr("content")

                    title = if (metaTitle.isNotEmpty()) metaTitle else doc.title()
                    textLink = if (metaDescription.isNotEmpty()) metaDescription else ""
                    imageLink = if (metaImage.isNotEmpty()) metaImage else ""
                    if (imageLink.isEmpty()) {
                        val firstImage = doc.select("img").firstOrNull()
                        imageLink = firstImage?.attr("abs:src") ?: ""
                    }
                    if (metaUrl.isNotEmpty()) {
                        textLink = metaUrl
                    } else {
                        textLink = titleLink
                    }
                    if (imageLink.isNotEmpty()) {
                        val bitmap = try {
                            val url = URL(imageLink)
                            BitmapFactory.decodeStream(url.openConnection().getInputStream())
                        } catch (e: Exception) {
                            null
                        }
                        if (bitmap == null) {
                            imageLink = ""
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("LinkParsing", "Error parsing link: ${e.message}")
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Error parsing link", Toast.LENGTH_SHORT).show()
            }
        } finally {
            setIsLoading(false)
        }
        if (title.isNotEmpty() && textLink.isNotEmpty()) {
            db.fourtyThreeLinksDao().upsertLink(FourtyThreeLinks(title = title, link = textLink, image = imageLink, comment = comment, id = id))
            withContext(Dispatchers.Main) {
                onSuccess()
                if (links.isNotEmpty()){
                    listState.animateScrollToItem(links.size)
                }
            }
        } else {
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Error parsing link", Toast.LENGTH_SHORT).show()
            }
        }
    }
}