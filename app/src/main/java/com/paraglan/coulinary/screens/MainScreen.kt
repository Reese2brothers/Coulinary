package com.paraglan.coulinary.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.paraglan.coulinary.R
import com.paraglan.coulinary.database.AppDatabase
import com.paraglan.coulinary.database.Favourites
import com.paraglan.coulinary.database.MainCategories
import kotlinx.coroutines.launch
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ContextCastToActivity")
@Composable
fun MainScreen(){
    var isSearchIconClicked by remember {mutableStateOf(false)}
    val context = LocalContext.current as Activity
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val dairyList by db.mainCategoriesDao().getAll().collectAsState(initial = emptyList())
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var choiceimage by remember { mutableStateOf(R.drawable.baseline_image_24) }
    var panelStateRight by remember { mutableStateOf(PanelState.Hidden) }
    var panelStateLeft by remember { mutableStateOf(PanelState.Hidden) }
    var selectedCategoryId by remember { mutableStateOf<Int>(0) }
    var selectedItemFavourites by remember { mutableStateOf<Favourites?>(null) }
    var selectedItemFavouritesDeleteItem by remember { mutableStateOf<Favourites?>(null) }
    var selectedItemMainDeleteItem by remember { mutableStateOf<MainCategories?>(null) }
    var selectedItemEditMainItem by remember { mutableStateOf<MainCategories?>(null) }
    val showDialogFavouriteDeleteItem = remember { mutableStateOf(false) }
    val showDialogFavDeleteAll = remember { mutableStateOf(false) }
    val showDialogDeleteMainItem = remember { mutableStateOf(false) }
    val showDialogEditMainItem = remember { mutableStateOf(false) }

    val listimages = listOf(R.drawable.gorshokkk, R.drawable.konhveti, R.drawable.lazania, R.drawable.lazaniatwo,
        R.drawable.lepeshka, R.drawable.lepeshkatwo, R.drawable.meetrulet, R.drawable.meetrulettwo,
        R.drawable.meetruletthree, R.drawable.oreo, R.drawable.pastashokoladna, R.drawable.savoyari,
        R.drawable.sendvichipechivo, R.drawable.tortizpechenia, R.drawable.tortpechenie,
        R.drawable.tortshuba, R.drawable.zapekanka, R.drawable.zapekankatwo, R.drawable.zapekankathree,
        R.drawable.zlakkozinak, R.drawable.smuzithree, R.drawable.stakani, R.drawable.specii,
        R.drawable.fruitssmuzi, R.drawable.ovoshsmuzi, R.drawable.bbq, R.drawable.bize, R.drawable.blini,
        R.drawable.blinsnachinkoi, R.drawable.moxito, R.drawable.moxitotwo, R.drawable.borsch,
        R.drawable.brinza, R.drawable.burger, R.drawable.buterbrot, R.drawable.cake,
        R.drawable.caketwo,R.drawable.chainik, R.drawable.cheburek, R.drawable.cocktail,
        R.drawable.decor, R.drawable.duhovka, R.drawable.fish,
        R.drawable.fishtwo, R.drawable.fishthree, R.drawable.fri,
        R.drawable.garnir,R.drawable.grill, R.drawable.hleb, R.drawable.kabachki,
        R.drawable.konfeti, R.drawable.konfetitwo, R.drawable.kotleti,
        R.drawable.krem, R.drawable.kremtwo, R.drawable.lavash,
        R.drawable.meat,R.drawable.meattwo, R.drawable.microvolnovka, R.drawable.morozivo,
        R.drawable.morozivotwo, R.drawable.multivarka, R.drawable.narezka,
        R.drawable.narezkatwo, R.drawable.oladi, R.drawable.oladitwo,
        R.drawable.olivie,R.drawable.panini, R.drawable.paninitwo, R.drawable.pashtet,
        R.drawable.pasta, R.drawable.pechentort, R.drawable.pechivo,
        R.drawable.pechivotwo, R.drawable.pirog, R.drawable.pirogtwo,
        R.drawable.pirogenoe,R.drawable.pizza, R.drawable.pizzatwo, R.drawable.pizzathree,
        R.drawable.rulet, R.drawable.salat, R.drawable.salattwo,
        R.drawable.salatthree, R.drawable.salatfour, R.drawable.salatfive,
        R.drawable.shashlik,R.drawable.shashliktwo, R.drawable.smuzi, R.drawable.smuzitwo,
        R.drawable.solenia, R.drawable.soleniatwo, R.drawable.sous,
        R.drawable.soustwo, R.drawable.sousthree, R.drawable.suppure,
        R.drawable.suppuretwo,R.drawable.teacup, R.drawable.testo, R.drawable.tikva,
        R.drawable.tikvatwo, R.drawable.tushen, R.drawable.tushentwo,
        R.drawable.tworog, R.drawable.vipechka, R.drawable.vipechkatwo,
        R.drawable.zhele, R.drawable.blinisnachinkoi, R.drawable.buterbrodi, R.drawable.gorshok,
        R.drawable.kanape, R.drawable.keks, R.drawable.kekstwo, R.drawable.kruasan,
        R.drawable.marmelad, R.drawable.morkovpirog, R.drawable.ovoshnarezka, R.drawable.pechen,
        R.drawable.seledka, R.drawable.sharlotka, R.drawable.sloenka, R.drawable.sushi,
        R.drawable.sushitwo, R.drawable.tortdecor, R.drawable.tortdecortwo,
        R.drawable.tortdecorthree, R.drawable.zharkoe
    )
    //выдвижная панель справа
    val panelWidth = 350.dp
    val animatedOffset by animateDpAsState(
        targetValue = if (panelStateRight == PanelState.Expanded) 0.dp else panelWidth,
        animationSpec = tween(durationMillis = 300)
    )
    //выдвижная панель слева
    val panelWidthLeft = 350.dp
    val animatedOffsetLeft by animateDpAsState(
        targetValue = if (panelStateLeft == PanelState.Expanded) 0.dp else panelWidthLeft,
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
    var listFavourites by remember { mutableStateOf<List<Favourites>>(emptyList()) }
    LaunchedEffect(Unit) {
        db.favouritesDao().getAll().collect { favourites ->
            listFavourites = favourites
        }
    }
    BackHandler { context.finishAffinity() }

    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Image(painter = painterResource(R.drawable.foncook), contentDescription = "foncook",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly){
            Row(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
                 Image(painter = painterResource(R.drawable.baseline_favorite_border_24),
                     contentDescription = "border", modifier = Modifier.size(40.dp).clickable {
                             panelStateLeft = PanelState.Expanded
                         }, contentScale = ContentScale.FillBounds
                 )
                Text(text = "0",
                    fontSize = 12.sp,
                    color = colorResource(R.color.boloto),
                    modifier = Modifier.offset(y = 8.dp, x = -4.dp),
                    fontFamily = FontFamily(Font(R.font.interregular))
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
                 Image(painter = painterResource(R.drawable.baseline_add_box_24), contentDescription = "box",
                             modifier = Modifier.size(40.dp).clickable {
                                 text = ""
                                 choiceimage = R.drawable.baseline_image_24
                                 selectedCategoryId = 0
                                 panelStateRight = PanelState.Expanded
                                 }, contentScale = ContentScale.FillBounds
                         )
            }
            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {
                itemsIndexed(filteredList) {index, item ->
                    Card(modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                        .fillMaxWidth().height(150.dp).background(Color.Transparent), shape = CutCornerShape(bottomStart = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.boloto)),
                        onClick = { }) {
                        Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.fillMaxHeight().weight(1f), contentAlignment = Alignment.TopEnd) {
                                Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                    val painter = rememberAsyncImagePainter(
                                        model = item.image, error = painterResource(R.drawable.baseline_image_24)
                                    )
                                    Image(painter = painter, contentDescription = "choise_image",
                                        modifier = Modifier.fillMaxHeight().width(150.dp).padding(top = 4.dp, bottom = 4.dp, start = 8.dp)
                                    )
                                    Text(text = item.title, modifier = Modifier.fillMaxWidth().wrapContentHeight(Alignment.CenterVertically)
                                            .padding(end = 8.dp),
                                        textAlign = TextAlign.Center,
                                        fontSize = 30.sp, color = colorResource(id = R.color.boloto),
                                        fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.interregular))
                                    )
                                }
                            }
                            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = "${index + 1}/50", modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                    textAlign = TextAlign.Center, fontSize = 12.sp, color = colorResource(id = R.color.boloto),
                                )
                                Column {
                                    Image(painter = painterResource(id = R.drawable.edit), contentDescription = "edit_item",
                                        modifier = Modifier.size(30.dp).padding(end = 8.dp, bottom = 8.dp).offset(y = -8.dp).clickable {
                                            showDialogEditMainItem.value = true
                                            selectedItemEditMainItem = item
                                            }
                                    )
                                    if (showDialogEditMainItem.value) {
                                        AlertDialog(
                                            onDismissRequest = { showDialogEditMainItem.value = false },
                                            containerColor = colorResource(id = R.color.white),
                                            title = { androidx.compose.material.Text(
                                                stringResource(R.string.confirm),
                                                color = colorResource(id = R.color.boloto),
                                                fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                            },
                                            text = { androidx.compose.material.Text(
                                                stringResource(R.string.edit_category),
                                                color = colorResource(id = R.color.boloto))
                                            },
                                            confirmButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.boloto)),
                                                    onClick = {
                                                        showDialogEditMainItem.value = false
                                                        text = selectedItemEditMainItem!!.title
                                                        choiceimage = selectedItemEditMainItem!!.image
                                                        selectedCategoryId = selectedItemEditMainItem!!.id
                                                        panelStateRight = PanelState.Expanded
                                                    }) {
                                                    androidx.compose.material.Text(
                                                        stringResource(R.string.yes), color = colorResource(id = R.color.white),
                                                        fontSize = 16.sp
                                                    )
                                                }
                                            },
                                            dismissButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.boloto)),
                                                    onClick = { showDialogEditMainItem.value = false }) {
                                                    androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                                }
                                            })
                                    }
                                    Image(painter = painterResource(id = R.drawable.delete), contentDescription = "delete_item",
                                        modifier = Modifier.size(30.dp).padding(end = 8.dp, bottom = 4.dp).clickable {
                                            showDialogDeleteMainItem.value = true
                                            selectedItemMainDeleteItem = item
                                            }
                                    )
                                    if (showDialogDeleteMainItem.value) {
                                        AlertDialog(
                                            onDismissRequest = { showDialogDeleteMainItem.value = false },
                                            containerColor = colorResource(id = R.color.white),
                                            title = { androidx.compose.material.Text(
                                                stringResource(R.string.confirm),
                                                color = colorResource(id = R.color.boloto),
                                                fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                            },
                                            text = { androidx.compose.material.Text(
                                                stringResource(R.string.delete_category),
                                                color = colorResource(id = R.color.boloto))
                                            },
                                            confirmButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.boloto)),
                                                    onClick = {
                                                        scope.launch { db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!) }
                                                        showDialogDeleteMainItem.value = false
                                                    }) {
                                                    androidx.compose.material.Text(stringResource(R.string.yes), color = colorResource(id = R.color.white),
                                                        fontSize = 16.sp
                                                    )
                                                }
                                            },
                                            dismissButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.boloto)),
                                                    onClick = { showDialogDeleteMainItem.value = false }) {
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
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd){
            Column(modifier = Modifier.fillMaxHeight().width(panelWidth).offset(x = animatedOffset).background(
                    colorResource(R.color.trboloto), shape = CutCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                ), horizontalAlignment = Alignment.CenterHorizontally) {
                 Column(modifier = Modifier.fillMaxWidth(),
                     horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.SpaceEvenly){
                     Row(modifier = Modifier.fillMaxWidth().padding(start = 24.dp, top = 16.dp), horizontalArrangement = Arrangement.Start,
                         verticalAlignment = Alignment.CenterVertically){
                         Icon(painter = painterResource(R.drawable.exitright), contentDescription = "exitresources",
                             modifier = Modifier.size(30.dp).clickable { panelStateRight = PanelState.Hidden }
                         , tint = colorResource(R.color.white))
                     }
                     Image(painter = painterResource(choiceimage), contentDescription = "choiceimage",
                         modifier = Modifier.size(160.dp)
                     )
                     OutlinedTextField(value = text,
                         onValueChange = { text = it },
                         placeholder = {
                             Text(text = stringResource(R.string.name_category), color = colorResource(R.color.white))
                         },
                         trailingIcon = {  Icon(Icons.Default.Close, contentDescription = "close",
                             tint = colorResource(R.color.white), modifier = Modifier.clickable {
                                 text = ""
                             }
                         ) },
                         textStyle = TextStyle(color = colorResource(R.color.white), fontSize = 20.sp),
                         modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
                             .border(2.dp, Color.White, RoundedCornerShape(8.dp)),
                         colors = TextFieldDefaults.outlinedTextFieldColors(
                             focusedBorderColor = Color.White,
                             unfocusedBorderColor = Color.White,
                             cursorColor = colorResource(R.color.white),
                             focusedPlaceholderColor = colorResource(R.color.white),
                             focusedTextColor = colorResource(R.color.white)),
                         shape = RoundedCornerShape(16.dp)
                     )
                     Box(modifier = Modifier.fillMaxWidth().height(70.dp).background(Color.Transparent, RoundedCornerShape(16.dp))
                         .padding(horizontal = 16.dp).clickable {
                             panelStateRight = PanelState.Hidden
                             focusRequester.freeFocus()
                             keyboardController?.hide()
                             if(text.isNotEmpty()){
                                 scope.launch {
                                     val item = MainCategories(title = text, image = choiceimage, id = selectedCategoryId)
                                     db.mainCategoriesDao().update(item)
                                 }
                             } else {
                                 Toast.makeText(context,
                                     context.getString(R.string.enter_name_category), Toast.LENGTH_SHORT).show()
                             }
                         },
                         contentAlignment = Alignment.Center){
                         Image(painter = painterResource(R.drawable.foncook), contentDescription = "savechoice",
                             modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp)), contentScale = ContentScale.FillBounds
                         )
                         Text(text = stringResource(R.string.save), fontSize = 24.sp,
                             color = colorResource(R.color.boloto), fontWeight = FontWeight.Bold,
                             fontFamily = FontFamily(Font(R.font.interregular))
                         )
                     }
                     LazyVerticalGrid(columns = GridCells.Fixed(2), state = rememberLazyGridState(), modifier = Modifier
                         .fillMaxWidth().weight(1f).padding(top = 16.dp)) {
                         items(listimages) { item ->
                             Image(painter = painterResource(item), contentDescription = "Grid Image",
                                 modifier = Modifier.size(160.dp).padding(8.dp).clickable {
                                     choiceimage = item
                                 }
                             )
                         }
                     }
                 }
            }

        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){
            Column(modifier = Modifier.fillMaxHeight().width(panelWidthLeft).offset(x = -animatedOffsetLeft)
                .background(colorResource(R.color.trboloto), shape = CutCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                ), horizontalAlignment = Alignment.CenterHorizontally) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly) {
                    Row(modifier = Modifier.fillMaxWidth().padding(end = 24.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(text = stringResource(R.string.favourite), modifier = Modifier.offset(x = -100.dp),
                            textAlign = TextAlign.Start, fontWeight = FontWeight.Bold,
                            fontSize = 24.sp, color = colorResource(id = R.color.white),
                            fontFamily = FontFamily(Font(R.font.interregular))
                        )
                        Image(painter = painterResource(id = R.drawable.delete),
                            contentDescription = "delete_all_favourites",
                            modifier = Modifier.size(35.dp).padding(end = 8.dp).offset(x = -8.dp).clickable {
                                showDialogFavDeleteAll.value = true
                            }
                        )
                        if (showDialogFavDeleteAll.value) {
                            AlertDialog(
                                onDismissRequest = { showDialogFavDeleteAll.value = false },
                                containerColor = colorResource(id = R.color.white),
                                title = { androidx.compose.material.Text(stringResource(R.string.confirm),
                                    color = colorResource(id = R.color.boloto),
                                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                },
                                text = { androidx.compose.material.Text(
                                    stringResource(R.string.delete_all_from_favourite),
                                    color = colorResource(id = R.color.boloto))
                                },
                                confirmButton = {
                                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                        containerColor = colorResource(id = R.color.boloto)),
                                        onClick = {
                                            scope.launch {
                                                selectedItemFavourites?.let {
                                                    db.favouritesDao().deleteAll()
                                                }
                                            }
                                            focusRequester.freeFocus()
                                            keyboardController?.hide()
                                            showDialogFavDeleteAll.value = false
                                        }) {
                                        androidx.compose.material.Text(stringResource(R.string.yes), color = colorResource(id = R.color.white),
                                            fontSize = 16.sp
                                        )
                                    }
                                },
                                dismissButton = {
                                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                        containerColor = colorResource(id = R.color.boloto)),
                                        onClick = { showDialogFavDeleteAll.value = false
                                            focusRequester.freeFocus()
                                            keyboardController?.hide()}) {
                                        androidx.compose.material.Text(stringResource(R.string.cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                    }
                                })
                        }
                        Icon(painter = painterResource(R.drawable.exitleft), contentDescription = "exitresources",
                            modifier = Modifier.size(30.dp).clickable { panelStateLeft = PanelState.Hidden },
                            tint = colorResource(R.color.white))
                    }
                    LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {
                        itemsIndexed(listFavourites) { index, item ->
                            Card(modifier = Modifier.padding(top = 4.dp, start = 8.dp,
                                end = 8.dp, bottom = 4.dp).fillMaxWidth().height(120.dp).background(Color.Transparent),
                                shape = CutCornerShape(bottomStart = 8.dp), //elevation = 5.dp,
                                border = BorderStroke(1.dp, color = colorResource(id = R.color.boloto)),
                                onClick = {
                                    val encodedTitle = URLEncoder.encode(item.title, "UTF-8")
                                    val encodedContent = URLEncoder.encode(item.content, "UTF-8")
                                    val encodedImages = URLEncoder.encode(item.images, "UTF-8")
                                        ?: R.drawable.baseline_add_photo_alternate_24.toString()
                                    when (item.favouriteskey) {
                                       // "OneRecepiesScreen" -> navController.navigate("OneRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                                       // "TwoRecepiesScreen" -> navController.navigate("TwoRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                                       // "ThreeRecepiesScreen" -> navController.navigate("ThreeRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                                        //"FourRecepiesScreen" -> navController.navigate("FourRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                                        //"FiveRecepiesScreen" -> navController.navigate("FiveRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                                        // ... другие экраны ...
                                        else -> { /* Unknown favouriteskey */
                                        }
                                    }
                                }) {
                                Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                    Box(modifier = Modifier.fillMaxHeight().weight(1f), contentAlignment = Alignment.TopEnd) {
                                        Row(modifier = Modifier.fillMaxHeight().background(colorResource(R.color.white)),
                                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                            val firstImageUri = remember(item.images) {
                                                item.images.split(",")
                                                    .firstOrNull {
                                                        it.startsWith("content://") || it.startsWith(
                                                            "file://"
                                                        )
                                                    }
                                            }
                                            AsyncImage(model = ImageRequest.Builder(context).data(firstImageUri)
                                                .crossfade(true).build(),
                                                contentDescription = "choise_image",
                                                modifier = Modifier.fillMaxHeight().width(120.dp).fillMaxHeight(),
                                                contentScale = ContentScale.Crop,
                                                placeholder = painterResource(R.drawable.baseline_image_24),
                                                error = painterResource(R.drawable.baseline_error)
                                            )
                                            Text(text = item.title, modifier = Modifier.fillMaxWidth()
                                                .wrapContentHeight(Alignment.CenterVertically).padding(end = 8.dp),
                                                textAlign = TextAlign.Center, fontSize = 24.sp,
                                                color = colorResource(id = R.color.boloto), fontWeight = FontWeight.Bold,
                                                fontFamily = FontFamily(Font(R.font.interregular))
                                            )
                                        }
                                    }
                                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween,
                                        horizontalAlignment = Alignment.CenterHorizontally) {
                                        androidx.compose.material.Text(text = "${index + 1}",
                                            modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                            textAlign = TextAlign.Center, fontSize = 12.sp,
                                            color = colorResource(id = R.color.boloto),
                                        )
                                        androidx.compose.material.Icon(
                                            painter = painterResource(id = R.drawable.delete),
                                            contentDescription = "delete_item_favourites",
                                            modifier = Modifier.size(30.dp).padding(end = 8.dp, bottom = 4.dp).clickable {
                                                showDialogFavouriteDeleteItem.value = true
                                                selectedItemFavouritesDeleteItem = item
                                            },
                                            tint = colorResource(R.color.boloto)
                                        )
                                        if (showDialogFavouriteDeleteItem.value) {
                                            AlertDialog(
                                                onDismissRequest = { showDialogFavouriteDeleteItem.value = false },
                                                containerColor = colorResource(id = R.color.white),
                                                title = { androidx.compose.material.Text(stringResource(R.string.confirm),
                                                        color = colorResource(id = R.color.boloto),
                                                        fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                                },
                                                text = { androidx.compose.material.Text(
                                                    stringResource(R.string.delete_from_favourite),
                                                        color = colorResource(id = R.color.boloto))
                                                },
                                                confirmButton = {
                                                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                        containerColor = colorResource(id = R.color.boloto)),
                                                        onClick = {
                                                            scope.launch {
                                                               db.favouritesDao().deleteFavourites(selectedItemFavouritesDeleteItem!!)
                                                            }
                                                            showDialogFavouriteDeleteItem.value = false
                                                        }) {
                                                        androidx.compose.material.Text(stringResource(R.string.yes), color = colorResource(id = R.color.white),
                                                            fontSize = 16.sp
                                                        )
                                                    }
                                                },
                                                dismissButton = {
                                                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                        containerColor = colorResource(id = R.color.boloto)),
                                                        onClick = { showDialogFavouriteDeleteItem.value = false }) {
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
            }
        }
    }
}
enum class PanelState {
    Hidden,
    Expanded
}