package com.paraglan.coulinary.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MainCategoriesDao {
    @Query("SELECT * FROM MainCategories")
    fun getAll(): Flow<List<MainCategories>>

    @Query("SELECT wordkey FROM maincategories")
    suspend fun getAllKeys(): List<String>

    @Query("SELECT * FROM maincategories WHERE wordkey = :wordkey")
    suspend fun getSectionByWordkey(wordkey: String): MainCategories?

    @Insert
    suspend fun insert(mainCategories: MainCategories)
    @Delete
    suspend fun delete(mainCategories: MainCategories)
    @Query("DELETE FROM MainCategories")
    suspend fun deleteAll()
    @Upsert
    suspend fun update(mainCategories: MainCategories)
}

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites")
    fun getAll(): Flow<List<Favourites>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourites(favourites: Favourites)

    @Delete
    suspend fun deleteFavourites(favourites: Favourites)

    @Query("DELETE FROM favourites")
    suspend fun deleteAll()

    @Query("SELECT EXISTS(SELECT * FROM Favourites WHERE title = :title AND favouriteskey = :key)")
    suspend fun isFavourite(title: String, key: String): Boolean

    @Query("DELETE FROM Favourites WHERE title = :title AND favouriteskey = :key")
    suspend fun deleteFavourite(title: String, key: String)

    @Query("SELECT COUNT(*) FROM favourites")
    suspend fun isEmpty(): Boolean

    @Query("SELECT COUNT(*) FROM favourites")
    suspend fun getCount(): Int
}
