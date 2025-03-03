package com.paraglan.coulinary.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MainCategories(
    val title : String,
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

