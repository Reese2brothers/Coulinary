package com.paraglan.coulinary.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MainCategories(
    val title : String,
    val image : Int,
    var wordkey : String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Favourites(
    val title : String,
    val content : String,
    val images : String,
    val favouriteskey : String
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

@Entity
data class One(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Two(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Three(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Four(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Five(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Six(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Seven(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Eight(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Nine(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Ten(
    val title : String,
    val content : String,
    val images : String,
    val videos : String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Eleven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Twelve(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Thirteen(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Fourteen(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Fifteen(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Sixteen(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Seventeen(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Eighteen(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Nineteen(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Twenty(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwentyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Thirty(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class ThirtyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Fourty(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FourtyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Fifty(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class FiftyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Sixty(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SixtyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Seventy(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class SeventyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Eighty(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class EightyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Ninety(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetyOne(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetyTwo(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetyThree(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetyFour(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetyFive(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetySix(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetySeven(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetyEight(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class NinetyNine(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class Hundred(
    val title: String,
    val content: String,
    val images: String,
    val videos: String = "video",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
