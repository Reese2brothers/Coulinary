package com.paraglan.coulinary.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MainCategoriesDao {
    @Query("SELECT * FROM MainCategories")
    fun getAll(): Flow<List<MainCategories>>

    @Insert
    suspend fun insert(mainCategories: MainCategories)

    @Delete
    suspend fun delete(mainCategories: MainCategories)

    @Query("DELETE FROM MainCategories")
    suspend fun deleteAll()
    @Upsert
    suspend fun update(mainCategories: MainCategories)
}
