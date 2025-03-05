package com.paraglan.coulinary.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface OneLinksDao {
    @Query("SELECT * FROM oneLinks")
    fun getAll() : Flow<List<OneLinks>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneLinks(oneLinks: OneLinks)
    @Delete
    suspend fun deleteOneLinks(oneLinks: OneLinks)
    @Query("DELETE FROM oneLinks")
    suspend fun deleteAll()
    @Upsert
    suspend fun upsertLink(oneLinks: OneLinks)
}