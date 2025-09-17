package com.paraglan.coulinary.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.net.Uri
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
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
import androidx.navigation.NavController
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
@SuppressLint("ContextCastToActivity", "CoroutineCreationDuringComposition")
@Composable
fun MainScreen(navController: NavController){
    var isSearchIconClicked by remember {mutableStateOf(false)}
    val context = LocalContext.current as Activity
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val dairyList by db.mainCategoriesDao().getAll().collectAsState(initial = emptyList())
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var wordkey by remember { mutableStateOf("") }
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
    val isFavouritesEmpty by produceState<Boolean>(initialValue = true) {
        value = db.favouritesDao().isEmpty() }
    var favouritesCount by remember { mutableStateOf(0) }

    val wordKeys = listOf(
        "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twentyone", "twentytwo", "twentythree", "twentyfour", "twentyfive",
        "twentysix", "twentyseven", "twentyeight", "twentynine", "thirty",
        "thirtyone", "thirtytwo", "thirtythree", "thirtyfour", "thirtyfive", "thirtysix",
        "thirtyseven", "thirtyeight", "thirtynine", "forty", "fortyone", "fortytwo",
        "fortythree", "fortyfour", "fortyfive", "fortysix", "fortyseven",
        "fortyeight", "fortynine", "fifty", "fiftyone", "fiftytwo", "fiftythree", "fiftyfour", "fiftyfive",
        "fiftysix", "fiftyseven", "fiftyeight", "fiftynine", "sixty", "sixtyone", "sixtytwo", "sixtythree",
        "sixtyfour", "sixtyfive", "sixtysix", "sixtyseven", "sixtyeight", "sixtynine", "seventy", "seventyone",
        "seventytwo", "seventythree", "seventyfour", "seventyfive", "seventysix", "seventyseven", "seventyeight",
        "seventynine", "eighty", "eightyone", "eightytwo", "eightythree", "eightyfour", "eightyfive", "eightysix",
        "eightyseven", "eightyeight", "eightynine", "ninety", "ninetyone", "ninetytwo", "ninetythree", "ninetyfour",
        "ninetyfive", "ninetysix", "ninetyseven", "ninetyeight", "ninetynine", "hundred"
    )

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
        R.drawable.tortdecorthree, R.drawable.zharkoe, R.drawable.sallo, R.drawable.krugliebluda,
        R.drawable.mnogoblud, R.drawable.razniebluda, R.drawable.potatoes
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
                 Image(painter = painterResource(id = if (!isFavouritesEmpty) R.drawable.baseline_favorite_border_24
                 else R.drawable.baseline_favorite_24),
                     contentDescription = "border", modifier = Modifier.size(40.dp).clickable {
                             panelStateLeft = PanelState.Expanded
                         }, contentScale = ContentScale.FillBounds
                 )
                scope.launch { favouritesCount = db.favouritesDao().getCount() }
                Text(text = favouritesCount.toString(),
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
            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f), state = rememberLazyListState()) {
                itemsIndexed(filteredList) {index, item ->
                    Card(modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                        .fillMaxWidth().height(150.dp).background(Color.Transparent), shape = CutCornerShape(bottomStart = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.boloto)),
                        onClick = {
                            when(item.wordkey) {
                                "one" -> { navController.navigate("OneScreen") }
                                "two" -> { navController.navigate("TwoScreen") }
                                "three" -> { navController.navigate("ThreeScreen") }
                                "four" -> { navController.navigate("FourScreen") }
                                "five" -> { navController.navigate("FiveScreen") }
                                "six" -> { navController.navigate("SixScreen") }
                                "seven" -> { navController.navigate("SevenScreen") }
                                "eight" -> { navController.navigate("EightScreen") }
                                "nine" -> { navController.navigate("NineScreen") }
                                "ten" -> { navController.navigate("TenScreen") }
                                "eleven" -> { navController.navigate("ElevenScreen") }
                                "twelve" -> { navController.navigate("TwelveScreen") }
                                "thirteen" -> { navController.navigate("ThirteenScreen") }
                                "fourteen" -> { navController.navigate("FourteenScreen") }
                                "fifteen" -> { navController.navigate("FifteenScreen") }
                                "sixteen" -> { navController.navigate("SixteenScreen") }
                                "seventeen" -> { navController.navigate("SeventeenScreen") }
                                "eighteen" -> { navController.navigate("EighteenScreen") }
                                "nineteen" -> { navController.navigate("NineteenScreen") }
                                "twenty" -> { navController.navigate("TwentyScreen") }
                                "twentyOne" -> { navController.navigate("TwentyOneScreen") }
                                "twentyTwo" -> { navController.navigate("TwentyTwoScreen") }
                                "twentyThree" -> { navController.navigate("TwentyThreeScreen") }
                                "twentyFour" -> { navController.navigate("TwentyFourScreen") }
                                "twentyFive" -> { navController.navigate("TwentyFiveScreen") }
                                "twentySix" -> { navController.navigate("TwentySixScreen") }
                                "twentySeven" -> { navController.navigate("TwentySevenScreen") }
                                "twentyEight" -> { navController.navigate("TwentyEightScreen") }
                                "twentyNine" -> { navController.navigate("TwentyNineScreen") }
                                "thirty" -> { navController.navigate("ThirtyScreen") }
                                "thirtyOne" -> { navController.navigate("ThirtyOneScreen") }
                                "thirtyTwo" -> { navController.navigate("ThirtyTwoScreen") }
                                "thirtyThree" -> { navController.navigate("ThirtyThreeScreen") }
                                "thirtyFour" -> { navController.navigate("ThirtyFourScreen") }
                                "thirtyFive" -> { navController.navigate("ThirtyFiveScreen") }
                                "thirtySix" -> { navController.navigate("ThirtySixScreen") }
                                "thirtySeven" -> { navController.navigate("ThirtySevenScreen") }
                                "thirtyEight" -> { navController.navigate("ThirtyEightScreen") }
                                "thirtyNine" -> { navController.navigate("ThirtyNineScreen") }
                                "forty" -> { navController.navigate("FortyScreen") }
                                "fortyOne" -> { navController.navigate("FortyOneScreen") }
                                "fortyTwo" -> { navController.navigate("FortyTwoScreen") }
                                "fortyThree" -> { navController.navigate("FortyThreeScreen") }
                                "fortyFour" -> { navController.navigate("FortyFourScreen") }
                                "fortyFive" -> { navController.navigate("FortyFiveScreen") }
                                "fortySix" -> { navController.navigate("FortySixScreen") }
                                "fortySeven" -> { navController.navigate("FortySevenScreen") }
                                "fortyEight" -> { navController.navigate("FortyEightScreen") }
                                "fortyNine" -> { navController.navigate("FortyNineScreen") }
                                "fifty" -> { navController.navigate("FiftyScreen") }
                                "fiftyOne" -> { navController.navigate("FiftyOneScreen") }
                                "fiftyTwo" -> { navController.navigate("FiftyTwoScreen") }
                                "fiftyThree" -> { navController.navigate("FiftyThreeScreen") }
                                "fiftyFour" -> { navController.navigate("FiftyFourScreen") }
                                "fiftyFive" -> { navController.navigate("FiftyFiveScreen") }
                                "fiftySix" -> { navController.navigate("FiftySixScreen") }
                                "fiftySeven" -> { navController.navigate("FiftySevenScreen") }
                                "fiftyEight" -> { navController.navigate("FiftyEightScreen") }
                                "fiftyNine" -> { navController.navigate("FiftyNineScreen") }
                                "sixty" -> { navController.navigate("SixtyScreen") }
                                "sixtyOne" -> { navController.navigate("SixtyOneScreen") }
                                "sixtyTwo" -> { navController.navigate("SixtyTwoScreen") }
                                "sixtyThree" -> { navController.navigate("SixtyThreeScreen") }
                                "sixtyFour" -> { navController.navigate("SixtyFourScreen") }
                                "sixtyFive" -> { navController.navigate("SixtyFiveScreen") }
                                "sixtySix" -> { navController.navigate("SixtySixScreen") }
                                "sixtySeven" -> { navController.navigate("SixtySevenScreen") }
                                "sixtyEight" -> { navController.navigate("SixtyEightScreen") }
                                "sixtyNine" -> { navController.navigate("SixtyNineScreen") }
                                "seventy" -> { navController.navigate("SeventyScreen") }
                                "seventyOne" -> { navController.navigate("SeventyOneScreen") }
                                "seventyTwo" -> { navController.navigate("SeventyTwoScreen") }
                                "seventyThree" -> { navController.navigate("SeventyThreeScreen") }
                                "seventyFour" -> { navController.navigate("SeventyFourScreen") }
                                "seventyFive" -> { navController.navigate("SeventyFiveScreen") }
                                "seventySix" -> { navController.navigate("SeventySixScreen") }
                                "seventySeven" -> { navController.navigate("SeventySevenScreen") }
                                "seventyEight" -> { navController.navigate("SeventyEightScreen") }
                                "seventyNine" -> { navController.navigate("SeventyNineScreen") }
                                "eighty" -> { navController.navigate("EightyScreen") }
                                "eightyOne" -> { navController.navigate("EightyOneScreen") }
                                "eightyTwo" -> { navController.navigate("EightyTwoScreen") }
                                "eightyThree" -> { navController.navigate("EightyThreeScreen") }
                                "eightyFour" -> { navController.navigate("EightyFourScreen") }
                                "eightyFive" -> { navController.navigate("EightyFiveScreen") }
                                "eightySix" -> { navController.navigate("EightySixScreen") }
                                "eightySeven" -> { navController.navigate("EightySevenScreen") }
                                "eightyEight" -> { navController.navigate("EightyEightScreen") }
                                "eightyNine" -> { navController.navigate("EightyNineScreen") }
                                "ninety" -> { navController.navigate("NinetyScreen") }
                                "ninetyOne" -> { navController.navigate("NinetyOneScreen") }
                                "ninetyTwo" -> { navController.navigate("NinetyTwoScreen") }
                                "ninetyThree" -> { navController.navigate("NinetyThreeScreen") }
                                "ninetyFour" -> { navController.navigate("NinetyFourScreen") }
                                "ninetyFive" -> { navController.navigate("NinetyFiveScreen") }
                                "ninetySix" -> { navController.navigate("NinetySixScreen") }
                                "ninetySeven" -> { navController.navigate("NinetySevenScreen") }
                                "ninetyEight" -> { navController.navigate("NinetyEightScreen") }
                                "ninetyNine" -> { navController.navigate("NinetyNineScreen") }
                                "hundred" -> { navController.navigate("HundredScreen") }
                            }
                        }) {
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
                                Text(text = "${index + 1}/100", modifier = Modifier.padding(end = 8.dp, top = 4.dp),
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
                                                        wordkey = selectedItemEditMainItem!!.wordkey
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
                                                    onClick = { showDialogEditMainItem.value = false
                                                        focusRequester.freeFocus()
                                                        keyboardController?.hide()}) {
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
                                                        when(item.wordkey){
                                                            "one" -> { scope.launch{ val allImageUris = db.oneDao().getAllImages().map { it.images }
                                                                        .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                    db.oneDao().deleteAll()
                                                                    db.oneLinksDao().deleteAll()
                                                                    allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                    db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                                }
                                                            }
                                                            "two" -> { scope.launch{ val allImageUris = db.twoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twoDao().deleteAll()
                                                                db.twoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                                 }
                                                            }
                                                            "three" -> { scope.launch{ val allImageUris = db.threeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.threeDao().deleteAll()
                                                                db.threeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "four" -> { scope.launch{ val allImageUris = db.fourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fourDao().deleteAll()
                                                                db.fourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "five" -> { scope.launch{ val allImageUris = db.fiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiveDao().deleteAll()
                                                                db.fiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "six" -> { scope.launch{ val allImageUris = db.sixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixDao().deleteAll()
                                                                db.sixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seven" -> { scope.launch{ val allImageUris = db.sevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sevenDao().deleteAll()
                                                                db.sevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eight" -> { scope.launch{ val allImageUris = db.eightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightDao().deleteAll()
                                                                db.eightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "nine" -> { scope.launch{ val allImageUris = db.nineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.nineDao().deleteAll()
                                                                db.nineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ten" -> { scope.launch{ val allImageUris = db.tenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.tenDao().deleteAll()
                                                                db.tenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eleven" -> { scope.launch{ val allImageUris = db.elevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.elevenDao().deleteAll()
                                                                db.elevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twelve" -> { scope.launch{ val allImageUris = db.twelveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twelveDao().deleteAll()
                                                                db.twelveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirteen" -> { scope.launch{ val allImageUris = db.thirteenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirteenDao().deleteAll()
                                                                db.thirteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fourteen" -> { scope.launch{ val allImageUris = db.fourteenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fourteenDao().deleteAll()
                                                                db.fourteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fifteen" -> { scope.launch{ val allImageUris = db.fifteenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fifteenDao().deleteAll()
                                                                db.fifteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixteen" -> { scope.launch{ val allImageUris = db.sixteenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixteenDao().deleteAll()
                                                                db.sixteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventeen" -> { scope.launch{ val allImageUris = db.seventeenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventeenDao().deleteAll()
                                                                db.seventeenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eighteen" -> { scope.launch{ val allImageUris = db.eighteenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eighteenDao().deleteAll()
                                                                db.eighteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "nineteen" -> { scope.launch{ val allImageUris = db.nineteenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.nineteenDao().deleteAll()
                                                                db.nineteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twenty" -> { scope.launch{ val allImageUris = db.twentyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyDao().deleteAll()
                                                                db.twentyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentyOne" -> { scope.launch{ val allImageUris = db.twentyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyOneDao().deleteAll()
                                                                db.twentyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentyTwo" -> { scope.launch{ val allImageUris = db.twentyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyTwoDao().deleteAll()
                                                                db.twentyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentyThree" -> { scope.launch{ val allImageUris = db.twentyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyThreeDao().deleteAll()
                                                                db.twentyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentyFour" -> { scope.launch{ val allImageUris = db.twentyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyFourDao().deleteAll()
                                                                db.twentyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentyFive" -> { scope.launch{ val allImageUris = db.twentyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyFiveDao().deleteAll()
                                                                db.twentyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentySix" -> { scope.launch{ val allImageUris = db.twentySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentySixDao().deleteAll()
                                                                db.twentySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentySeven" -> { scope.launch{ val allImageUris = db.twentySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentySevenDao().deleteAll()
                                                                db.twentySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentyEight" -> { scope.launch{ val allImageUris = db.twentyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyEightDao().deleteAll()
                                                                db.twentyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "twentyNine" -> { scope.launch{ val allImageUris = db.twentyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.twentyNineDao().deleteAll()
                                                                db.twentyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirty" -> { scope.launch{ val allImageUris = db.thirtyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyDao().deleteAll()
                                                                db.thirtyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtyOne" -> { scope.launch{ val allImageUris = db.thirtyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyOneDao().deleteAll()
                                                                db.thirtyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtyTwo" -> { scope.launch{ val allImageUris = db.thirtyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyTwoDao().deleteAll()
                                                                db.thirtyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtyThree" -> { scope.launch{ val allImageUris = db.thirtyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyThreeDao().deleteAll()
                                                                db.thirtyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtyFour" -> { scope.launch{ val allImageUris = db.thirtyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyFourDao().deleteAll()
                                                                db.thirtyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtyFive" -> { scope.launch{ val allImageUris = db.thirtyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyFiveDao().deleteAll()
                                                                db.thirtyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtySix" -> { scope.launch{ val allImageUris = db.thirtySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtySixDao().deleteAll()
                                                                db.thirtySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtySeven" -> { scope.launch{ val allImageUris = db.thirtySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtySevenDao().deleteAll()
                                                                db.thirtySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtyEight" -> { scope.launch{ val allImageUris = db.thirtyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyEightDao().deleteAll()
                                                                db.thirtyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "thirtyNine" -> { scope.launch{ val allImageUris = db.thirtyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.thirtyNineDao().deleteAll()
                                                                db.thirtyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "forty" -> { scope.launch{ val allImageUris = db.fortyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyDao().deleteAll()
                                                                db.fortyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortyOne" -> { scope.launch{ val allImageUris = db.fortyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyOneDao().deleteAll()
                                                                db.fortyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortyTwo" -> { scope.launch{ val allImageUris = db.fortyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyTwoDao().deleteAll()
                                                                db.fortyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortyThree" -> { scope.launch{ val allImageUris = db.fortyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyThreeDao().deleteAll()
                                                                db.fortyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortyFour" -> { scope.launch{ val allImageUris = db.fortyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyFourDao().deleteAll()
                                                                db.fortyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortyFive" -> { scope.launch{ val allImageUris = db.fortyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyFiveDao().deleteAll()
                                                                db.fortyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortySix" -> { scope.launch{ val allImageUris = db.fortySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortySixDao().deleteAll()
                                                                db.fortySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortySeven" -> { scope.launch{ val allImageUris = db.fortySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortySevenDao().deleteAll()
                                                                db.fortySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortyEight" -> { scope.launch{ val allImageUris = db.fortyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyEightDao().deleteAll()
                                                                db.fortyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fortyNine" -> { scope.launch{ val allImageUris = db.fortyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fortyNineDao().deleteAll()
                                                                db.fortyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fifty" -> { scope.launch{ val allImageUris = db.fiftyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyDao().deleteAll()
                                                                db.fiftyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftyOne" -> { scope.launch{ val allImageUris = db.fiftyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyOneDao().deleteAll()
                                                                db.fiftyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftyTwo" -> { scope.launch{ val allImageUris = db.fiftyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyTwoDao().deleteAll()
                                                                db.fiftyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftyThree" -> { scope.launch{ val allImageUris = db.fiftyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyThreeDao().deleteAll()
                                                                db.fiftyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftyFour" -> { scope.launch{ val allImageUris = db.fiftyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyFourDao().deleteAll()
                                                                db.fiftyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftyFive" -> { scope.launch{ val allImageUris = db.fiftyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyFiveDao().deleteAll()
                                                                db.fiftyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftySix" -> { scope.launch{ val allImageUris = db.fiftySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftySixDao().deleteAll()
                                                                db.fiftySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftySeven" -> { scope.launch{ val allImageUris = db.fiftySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftySevenDao().deleteAll()
                                                                db.fiftySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftyEight" -> { scope.launch{ val allImageUris = db.fiftyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyEightDao().deleteAll()
                                                                db.fiftyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "fiftyNine" -> { scope.launch{ val allImageUris = db.fiftyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.fiftyNineDao().deleteAll()
                                                                db.fiftyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixty" -> { scope.launch{ val allImageUris = db.sixtyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyDao().deleteAll()
                                                                db.sixtyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtyOne" -> { scope.launch{ val allImageUris = db.sixtyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyOneDao().deleteAll()
                                                                db.sixtyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtyTwo" -> { scope.launch{ val allImageUris = db.sixtyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyTwoDao().deleteAll()
                                                                db.sixtyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtyThree" -> { scope.launch{ val allImageUris = db.sixtyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyThreeDao().deleteAll()
                                                                db.sixtyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtyFour" -> { scope.launch{ val allImageUris = db.sixtyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyFourDao().deleteAll()
                                                                db.sixtyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtyFive" -> { scope.launch{ val allImageUris = db.sixtyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyFiveDao().deleteAll()
                                                                db.sixtyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtySix" -> { scope.launch{ val allImageUris = db.sixtySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtySixDao().deleteAll()
                                                                db.sixtySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtySeven" -> { scope.launch{ val allImageUris = db.sixtySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtySevenDao().deleteAll()
                                                                db.sixtySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtyEight" -> { scope.launch{ val allImageUris = db.sixtyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyEightDao().deleteAll()
                                                                db.sixtyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "sixtyNine" -> { scope.launch{ val allImageUris = db.sixtyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.sixtyNineDao().deleteAll()
                                                                db.sixtyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventy" -> { scope.launch{ val allImageUris = db.seventyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyDao().deleteAll()
                                                                db.seventyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventyOne" -> { scope.launch{ val allImageUris = db.seventyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyOneDao().deleteAll()
                                                                db.seventyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventyTwo" -> { scope.launch{ val allImageUris = db.seventyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyTwoDao().deleteAll()
                                                                db.seventyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventyThree" -> { scope.launch{ val allImageUris = db.seventyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyThreeDao().deleteAll()
                                                                db.seventyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventyFour" -> { scope.launch{ val allImageUris = db.seventyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyFourDao().deleteAll()
                                                                db.seventyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventyFive" -> { scope.launch{ val allImageUris = db.seventyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyFiveDao().deleteAll()
                                                                db.seventyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventySix" -> { scope.launch{ val allImageUris = db.seventySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventySixDao().deleteAll()
                                                                db.seventySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventySeven" -> { scope.launch{ val allImageUris = db.seventySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventySevenDao().deleteAll()
                                                                db.seventySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventyEight" -> { scope.launch{ val allImageUris = db.seventyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyEightDao().deleteAll()
                                                                db.seventyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "seventyNine" -> { scope.launch{ val allImageUris = db.seventyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.seventyNineDao().deleteAll()
                                                                db.seventyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eighty" -> { scope.launch{ val allImageUris = db.eightyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyDao().deleteAll()
                                                                db.eightyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightyOne" -> { scope.launch{ val allImageUris = db.eightyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyOneDao().deleteAll()
                                                                db.eightyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightyTwo" -> { scope.launch{ val allImageUris = db.eightyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyTwoDao().deleteAll()
                                                                db.eightyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightyThree" -> { scope.launch{ val allImageUris = db.eightyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyThreeDao().deleteAll()
                                                                db.eightyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightyFour" -> { scope.launch{ val allImageUris = db.eightyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyFourDao().deleteAll()
                                                                db.eightyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightyFive" -> { scope.launch{ val allImageUris = db.eightyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyFiveDao().deleteAll()
                                                                db.eightyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightySix" -> { scope.launch{ val allImageUris = db.eightySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightySixDao().deleteAll()
                                                                db.eightySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightySeven" -> { scope.launch{ val allImageUris = db.eightySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightySevenDao().deleteAll()
                                                                db.eightySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightyEight" -> { scope.launch{ val allImageUris = db.eightyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyEightDao().deleteAll()
                                                                db.eightyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "eightyNine" -> { scope.launch{ val allImageUris = db.eightyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.eightyNineDao().deleteAll()
                                                                db.eightyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninety" -> { scope.launch{ val allImageUris = db.ninetyDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyDao().deleteAll()
                                                                db.ninetyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetyOne" -> { scope.launch{ val allImageUris = db.ninetyOneDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyOneDao().deleteAll()
                                                                db.ninetyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetyTwo" -> { scope.launch{ val allImageUris = db.ninetyTwoDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyTwoDao().deleteAll()
                                                                db.ninetyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetyThree" -> { scope.launch{ val allImageUris = db.ninetyThreeDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyThreeDao().deleteAll()
                                                                db.ninetyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetyFour" -> { scope.launch{ val allImageUris = db.ninetyFourDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyFourDao().deleteAll()
                                                                db.ninetyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetyFive" -> { scope.launch{ val allImageUris = db.ninetyFiveDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyFiveDao().deleteAll()
                                                                db.ninetyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetySix" -> { scope.launch{ val allImageUris = db.ninetySixDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetySixDao().deleteAll()
                                                                db.ninetySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetySeven" -> { scope.launch{ val allImageUris = db.ninetySevenDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetySevenDao().deleteAll()
                                                                db.ninetySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetyEight" -> { scope.launch{ val allImageUris = db.ninetyEightDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyEightDao().deleteAll()
                                                                db.ninetyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "ninetyNine" -> { scope.launch{ val allImageUris = db.ninetyNineDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.ninetyNineDao().deleteAll()
                                                                db.ninetyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                            "hundred" -> { scope.launch{ val allImageUris = db.hundredDao().getAllImages().map { it.images }
                                                                .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }.map { Uri.parse(it) }
                                                                db.hundredDao().deleteAll()
                                                                db.hundredLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri -> context.contentResolver.delete(imageUri, null, null) }
                                                                db.mainCategoriesDao().delete(selectedItemMainDeleteItem!!)
                                                            } }
                                                        }
                                                        focusRequester.freeFocus()
                                                        keyboardController?.hide()
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
                                                    onClick = { showDialogDeleteMainItem.value = false
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
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd){
            Column(modifier = Modifier.fillMaxHeight().width(panelWidth).offset(x = animatedOffset)
                .border(1.dp, Color.Black, CutCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                .background( brush = Brush.linearGradient(
                    colors = listOf(colorResource(R.color.trboloto), colorResource(R.color.white)),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                ), shape = CutCornerShape(topStart = 16.dp, bottomStart = 16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally) {
                 Column(modifier = Modifier.fillMaxWidth(),
                     horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.SpaceEvenly){
                     Row(modifier = Modifier.fillMaxWidth().padding(start = 24.dp, top = 16.dp), horizontalArrangement = Arrangement.Start,
                         verticalAlignment = Alignment.CenterVertically){
                         Icon(painter = painterResource(R.drawable.exitright), contentDescription = "exitresources",
                             modifier = Modifier.size(30.dp).clickable { panelStateRight = PanelState.Hidden
                                 focusRequester.freeFocus()
                                 keyboardController?.hide()}
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
                             .border(2.dp, Color.White, RoundedCornerShape(16.dp)),
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
                             if (text.isNotEmpty()) {
                                 scope.launch { if (selectedCategoryId == 0) {
                                         var newWordKey: String? = null
                                         val existingKeys = db.mainCategoriesDao().getAllKeys()
                                         for (key in wordKeys) {
                                             if (!existingKeys.contains(key)) {
                                                 newWordKey = key
                                                 break
                                             }
                                         }
                                         if (newWordKey == null) {
                                             Toast.makeText(context, context.getString(R.string.nothing_else_save), Toast.LENGTH_SHORT).show()
                                         } else {
                                             val item = MainCategories(title = text, image = choiceimage, wordkey = newWordKey, id = 0)
                                             db.mainCategoriesDao().insert(item)
                                             Toast.makeText(context, context.getString(R.string.new_category_saved), Toast.LENGTH_SHORT).show()
                                         }
                                     } else {
                                         val existingItem = db.mainCategoriesDao().getCategoryById(selectedCategoryId)
                                         if (existingItem != null) {
                                             val item = MainCategories(title = text, image = choiceimage, wordkey = existingItem.wordkey, id = selectedCategoryId)
                                             db.mainCategoriesDao().upsert(item)
                                             Toast.makeText(context, context.getString(R.string.new_category_saved), Toast.LENGTH_SHORT).show()
                                         } else {
                                             Toast.makeText(context, context.getString(R.string.nothing_else_save), Toast.LENGTH_SHORT).show()
                                         }
                                     }
                                 }
                             } else {
                                 Toast.makeText(context, context.getString(R.string.enter_name_category), Toast.LENGTH_SHORT).show()
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
                .border(1.dp, Color.Black, CutCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
                .background(brush = Brush.linearGradient(
                        colors = listOf(colorResource(R.color.white), colorResource(R.color.trboloto)),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f)
                    ), shape = CutCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally) {
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
                                shape = CutCornerShape(bottomStart = 8.dp),
                                border = BorderStroke(1.dp, color = colorResource(id = R.color.boloto)),
                                onClick = {
                                    val encodedTitle = URLEncoder.encode(item.title, "UTF-8")
                                    val encodedContent = URLEncoder.encode(item.content, "UTF-8")
                                    val encodedImages = URLEncoder.encode(item.images, "UTF-8") ?: R.drawable.baseline_add_photo_alternate_24.toString()
                                    when (item.favouriteskey) {
                                        "OneRecipeScreen" -> navController.navigate("OneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwoRecipeScreen" -> navController.navigate("TwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThreeRecipeScreen" -> navController.navigate("ThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FourRecipeScreen" -> navController.navigate("FourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiveRecipeScreen" -> navController.navigate("FiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixRecipeScreen" -> navController.navigate("SixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SevenRecipeScreen" -> navController.navigate("SevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightRecipeScreen" -> navController.navigate("EightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NineRecipeScreen" -> navController.navigate("NineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TenRecipeScreen" -> navController.navigate("TenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ElevenRecipeScreen" -> navController.navigate("ElevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwelveRecipeScreen" -> navController.navigate("TwelveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirteenRecipeScreen" -> navController.navigate("ThirteenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FourteenRecipeScreen" -> navController.navigate("FourteenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FifteenRecipeScreen" -> navController.navigate("FifteenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixteenRecipeScreen" -> navController.navigate("SixteenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventeenRecipeScreen" -> navController.navigate("SeventeenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EighteenRecipeScreen" -> navController.navigate("EighteenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NineteenRecipeScreen" -> navController.navigate("NineteenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyRecipeScreen" -> navController.navigate("TwentyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyOneRecipeScreen" -> navController.navigate("TwentyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyTwoRecipeScreen" -> navController.navigate("TwentyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyThreeRecipeScreen" -> navController.navigate("TwentyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyFourRecipeScreen" -> navController.navigate("TwentyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyFiveRecipeScreen" -> navController.navigate("TwentyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentySixRecipeScreen" -> navController.navigate("TwentySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentySevenRecipeScreen" -> navController.navigate("TwentySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyEightRecipeScreen" -> navController.navigate("TwentyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "TwentyNineRecipeScreen" -> navController.navigate("TwentyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyRecipeScreen" -> navController.navigate("ThirtyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyOneRecipeScreen" -> navController.navigate("ThirtyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyTwoRecipeScreen" -> navController.navigate("ThirtyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyThreeRecipeScreen" -> navController.navigate("ThirtyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyFourRecipeScreen" -> navController.navigate("ThirtyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyFiveRecipeScreen" -> navController.navigate("ThirtyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtySixRecipeScreen" -> navController.navigate("ThirtySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtySevenRecipeScreen" -> navController.navigate("ThirtySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyEightRecipeScreen" -> navController.navigate("ThirtyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "ThirtyNineRecipeScreen" -> navController.navigate("ThirtyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyRecipeScreen" -> navController.navigate("FortyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyOneRecipeScreen" -> navController.navigate("FortyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyTwoRecipeScreen" -> navController.navigate("FortyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyThreeRecipeScreen" -> navController.navigate("FortyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyFourRecipeScreen" -> navController.navigate("FortyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyFiveRecipeScreen" -> navController.navigate("FortyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortySixRecipeScreen" -> navController.navigate("FortySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortySevenRecipeScreen" -> navController.navigate("FortySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyEightRecipeScreen" -> navController.navigate("FortyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FortyNineRecipeScreen" -> navController.navigate("FortyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyRecipeScreen" -> navController.navigate("FiftyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyOneRecipeScreen" -> navController.navigate("FiftyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyTwoRecipeScreen" -> navController.navigate("FiftyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyThreeRecipeScreen" -> navController.navigate("FiftyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyFourRecipeScreen" -> navController.navigate("FiftyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyFiveRecipeScreen" -> navController.navigate("FiftyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftySixRecipeScreen" -> navController.navigate("FiftySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftySevenRecipeScreen" -> navController.navigate("FiftySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyEightRecipeScreen" -> navController.navigate("FiftyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "FiftyNineRecipeScreen" -> navController.navigate("FiftyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyRecipeScreen" -> navController.navigate("SixtyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyOneRecipeScreen" -> navController.navigate("SixtyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyTwoRecipeScreen" -> navController.navigate("SixtyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyThreeRecipeScreen" -> navController.navigate("SixtyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyFourRecipeScreen" -> navController.navigate("SixtyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyFiveRecipeScreen" -> navController.navigate("SixtyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtySixRecipeScreen" -> navController.navigate("SixtySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtySevenRecipeScreen" -> navController.navigate("SixtySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyEightRecipeScreen" -> navController.navigate("SixtyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SixtyNineRecipeScreen" -> navController.navigate("SixtyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyRecipeScreen" -> navController.navigate("SeventyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyOneRecipeScreen" -> navController.navigate("SeventyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyTwoRecipeScreen" -> navController.navigate("SeventyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyThreeRecipeScreen" -> navController.navigate("SeventyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyFourRecipeScreen" -> navController.navigate("SeventyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyFiveRecipeScreen" -> navController.navigate("SeventyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventySixRecipeScreen" -> navController.navigate("SeventySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventySevenRecipeScreen" -> navController.navigate("SeventySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyEightRecipeScreen" -> navController.navigate("SeventyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "SeventyNineRecipeScreen" -> navController.navigate("SeventyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyRecipeScreen" -> navController.navigate("EightyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyOneRecipeScreen" -> navController.navigate("EightyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyTwoRecipeScreen" -> navController.navigate("EightyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyThreeRecipeScreen" -> navController.navigate("EightyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyFourRecipeScreen" -> navController.navigate("EightyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyFiveRecipeScreen" -> navController.navigate("EightyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightySixRecipeScreen" -> navController.navigate("EightySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightySevenRecipeScreen" -> navController.navigate("EightySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyEightRecipeScreen" -> navController.navigate("EightyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "EightyNineRecipeScreen" -> navController.navigate("EightyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyRecipeScreen" -> navController.navigate("NinetyRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyOneRecipeScreen" -> navController.navigate("NinetyOneRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyTwoRecipeScreen" -> navController.navigate("NinetyTwoRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyThreeRecipeScreen" -> navController.navigate("NinetyThreeRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyFourRecipeScreen" -> navController.navigate("NinetyFourRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyFiveRecipeScreen" -> navController.navigate("NinetyFiveRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetySixRecipeScreen" -> navController.navigate("NinetySixRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetySevenRecipeScreen" -> navController.navigate("NinetySevenRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyEightRecipeScreen" -> navController.navigate("NinetyEightRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "NinetyNineRecipeScreen" -> navController.navigate("NinetyNineRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
                                        "OneHundredRecipeScreen" -> navController.navigate("OneHundredRecipeScreen/$encodedTitle/$encodedContent/$encodedImages/video/0")
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