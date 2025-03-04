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