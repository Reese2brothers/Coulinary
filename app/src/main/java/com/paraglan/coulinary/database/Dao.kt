package com.paraglan.coulinary.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MainCategoriesDao {
    @Query("SELECT * FROM MainCategories")
    fun getAll(): Flow<List<MainCategories>>

    @Query("SELECT wordkey FROM maincategories")
    suspend fun getAllKeys(): List<String>

//    @Query("SELECT * FROM maincategories WHERE wordkey = :wordkey")
//    suspend fun getSectionByWordkey(wordkey: String): MainCategories?

    @Query("SELECT * FROM maincategories WHERE id = :id")
    suspend fun getCategoryById(id: Int): MainCategories?

    @Insert
    suspend fun insert(mainCategories: MainCategories)
    @Delete
    suspend fun delete(mainCategories: MainCategories)
//    @Query("DELETE FROM MainCategories")
//    suspend fun deleteAll()
    @Upsert
    suspend fun upsert(mainCategories: MainCategories)
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

@Dao
interface OneDao {
    @Query("SELECT * FROM one")
    fun getAll(): Flow<List<One>>

    @Upsert
    suspend fun upsert(one : One)

    @Delete
    suspend fun delete(one: One)

    @Query("DELETE FROM one")
    suspend fun deleteAll()

    @Query("SELECT images FROM one WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE one SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM one")
    suspend fun getAllImages(): List<One>

    @Query("UPDATE one SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM one WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE one SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM one WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwoDao {
    @Query("SELECT * FROM two")
    fun getAll(): Flow<List<Two>>

    @Upsert
    suspend fun upsert(two : Two)

    @Delete
    suspend fun delete(two: Two)

    @Query("DELETE FROM two")
    suspend fun deleteAll()

    @Query("SELECT images FROM two WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String

    @Query("UPDATE two SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM two")
    suspend fun getAllImages(): List<Two>

    @Query("UPDATE two SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM two WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String

    @Query("UPDATE two SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM two WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
