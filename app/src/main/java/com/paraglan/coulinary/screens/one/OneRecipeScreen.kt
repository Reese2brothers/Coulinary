package com.paraglan.coulinary.screens.one

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import kotlinx.coroutines.delay

@Composable
fun OneRecipeScreen(navController: NavController, title: String, content: String, image: String, videos: String, id: Int) {
    var panelState by remember { mutableStateOf(PanelState.Hidden) }
    var isPressed by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val listImages by db.oneDao().getAll().collectAsState(initial = emptyList())
    var startAnimation by remember { mutableStateOf(false) }
    var selectedImage by remember { mutableStateOf(image) }

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

    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        Image(painter = painterResource(R.drawable.foncook), contentDescription = "foncook",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp).padding(top = 270.dp, bottom = 16.dp), horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(R.drawable.edit), contentDescription = "edit",
                        modifier = Modifier.size(30.dp).clickable {  }
                    )
                    Image (painter = painterResource(R.drawable.baseline_favorite_border_24), contentDescription = "favourite",
                        modifier = Modifier.size(30.dp).clickable { }
                    )
                    Image (painter = painterResource(R.drawable.share), contentDescription = "share",
                        modifier = Modifier.size(30.dp).clickable { }
                    )
                    Image (painter = painterResource(R.drawable.baseline_picture_as_pdf_24), contentDescription = "pdf",
                        modifier = Modifier.size(30.dp).clickable { }
                    )
                    Image (painter = painterResource(R.drawable.baseline_photo_size_select_actual_24), contentDescription = "photo",
                        modifier = Modifier.size(30.dp).clickable { }
                    )
                    Image (painter = painterResource(R.drawable.baseline_ondemand_video_24), contentDescription = "video",
                        modifier = Modifier.size(30.dp).clickable { }
                    )
                }
                Text(text = title, fontSize = 22.sp, color = colorResource(R.color.boloto),
                    fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.interregular)),
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                Text(text = content, fontSize = 16.sp, color = colorResource(R.color.boloto),
                    fontFamily = FontFamily(Font(R.font.interregular)),
                    modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 8.dp, vertical = 8.dp)
                    .verticalScroll(rememberScrollState())
                )
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
            Column(modifier = Modifier.fillMaxWidth().height(panelHeight).offset(y = animatedOffset)
                .background(
                    brush = Brush.linearGradient(colors = listOf(colorResource(R.color.boloto), colorResource(R.color.white))),
                    shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
                ). border(2.dp, colorResource(R.color.black), shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom) {
                LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp).height(100.dp), state = rememberLazyListState()) {
                    items(listImages){ item ->
                       AsyncImage(model = item.images, contentDescription = "photo",
                            modifier = Modifier.size(100.dp).padding(horizontal = 8.dp).clickable {
                                selectedImage = item.images
                            }.clip(CutCornerShape(bottomStart = 16.dp))
                                .border(2.dp, colorResource(R.color.white), shape = CutCornerShape(bottomStart = 16.dp)),
                           contentScale = ContentScale.Crop
                       )
                    }
                }
                Row(modifier = Modifier.fillMaxWidth().padding(start = 24.dp, bottom = 8.dp), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start){
                    Image (painter = painterResource(R.drawable.baseline_add_photo_alternate_24), contentDescription = "gallery",
                        modifier = Modifier.size(35.dp).offset(x = 16.dp).clickable { }
                    )
                    Image (painter = painterResource(R.drawable.baseline_add_a_photo_24), contentDescription = "camera",
                        modifier = Modifier.size(30.dp).offset(x = 32.dp).clickable { }
                    )
                    Icon(painter = painterResource(R.drawable.delete), contentDescription = "deleteall",
                        modifier = Modifier.size(25.dp).offset(x = 48.dp).clickable { }, tint = colorResource(R.color.white)
                    )
                }
                AsyncImage(model = selectedImage, contentDescription = "photo",
                    modifier = Modifier .width(if (isPressed) expandedImageWidth else collapsedImageWidth)
                        .height(if (isPressed) expandedImageHeight else collapsedImageHeight)
                        .padding(horizontal = 8.dp).clip(RoundedCornerShape(16.dp)),
                    placeholder = painterResource(R.drawable.noimage),
                    error = painterResource(R.drawable.noimage),
                    fallback = painterResource(R.drawable.noimage),
                    contentScale = if(isPressed) ContentScale.Crop else ContentScale.Fit
                )
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically,
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