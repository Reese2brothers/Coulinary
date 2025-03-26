package com.paraglan.coulinary.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OneLinks(
    val title : String,
    val link : String,
    val image : String,
    var comment : String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

@Entity
data class TwoLinks(
    val title : String,
    val link : String,
    val image : String,
    var comment : String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
