package com.paraglan.coulinary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MainCategories::class, Favourites::class, One::class, Two::class, OneLinks::class, TwoLinks::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mainCategoriesDao(): MainCategoriesDao
    abstract fun favouritesDao(): FavouritesDao
    abstract fun oneDao(): OneDao
    abstract fun twoDao(): TwoDao
    abstract fun oneLinksDao(): OneLinksDao
    abstract fun twoLinksDao(): TwoLinksDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}