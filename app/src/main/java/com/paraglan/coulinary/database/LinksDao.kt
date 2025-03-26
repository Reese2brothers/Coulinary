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
    suspend fun insertLinks(oneLinks: OneLinks)
    @Delete
    suspend fun deleteLinks(oneLinks: OneLinks)
    @Query("DELETE FROM oneLinks")
    suspend fun deleteAll()
    @Upsert
    suspend fun upsertLink(oneLinks: OneLinks)
}

@Dao
interface TwoLinksDao {
    @Query("SELECT * FROM twoLinks")
    fun getAll() : Flow<List<TwoLinks>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twoLinks: TwoLinks)
    @Delete
    suspend fun deleteLinks(twoLinks: TwoLinks)
    @Query("DELETE FROM twoLinks")
    suspend fun deleteAll()
    @Upsert
    suspend fun upsertLink(twoLinks: TwoLinks)
}