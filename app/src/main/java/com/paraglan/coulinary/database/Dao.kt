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

@Dao
interface ThreeDao {
    @Query("SELECT * FROM three")
    fun getAll(): Flow<List<Three>>

    @Upsert
    suspend fun upsert(three: Three)

    @Delete
    suspend fun delete(three: Three)

    @Query("DELETE FROM three")
    suspend fun deleteAll()

    @Query("SELECT images FROM three WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE three SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM three")
    suspend fun getAllImages(): List<Three>

    @Query("UPDATE three SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM three WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE three SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM three WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FourDao {
    @Query("SELECT * FROM four")
    fun getAll(): Flow<List<Four>>

    @Upsert
    suspend fun upsert(four: Four)

    @Delete
    suspend fun delete(four: Four)

    @Query("DELETE FROM four")
    suspend fun deleteAll()

    @Query("SELECT images FROM four WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE four SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM four")
    suspend fun getAllImages(): List<Four>

    @Query("UPDATE four SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM four WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE four SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM four WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiveDao {
    @Query("SELECT * FROM five")
    fun getAll(): Flow<List<Five>>

    @Upsert
    suspend fun upsert(five: Five)

    @Delete
    suspend fun delete(five: Five)

    @Query("DELETE FROM five")
    suspend fun deleteAll()

    @Query("SELECT images FROM five WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE five SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM five")
    suspend fun getAllImages(): List<Five>

    @Query("UPDATE five SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM five WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE five SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM five WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixDao {
    @Query("SELECT * FROM six")
    fun getAll(): Flow<List<Six>>

    @Upsert
    suspend fun upsert(six: Six)

    @Delete
    suspend fun delete(six: Six)

    @Query("DELETE FROM six")
    suspend fun deleteAll()

    @Query("SELECT images FROM six WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE six SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM six")
    suspend fun getAllImages(): List<Six>

    @Query("UPDATE six SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM six WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE six SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM six WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SevenDao {
    @Query("SELECT * FROM seven")
    fun getAll(): Flow<List<Seven>>

    @Upsert
    suspend fun upsert(seven: Seven)

    @Delete
    suspend fun delete(seven: Seven)

    @Query("DELETE FROM seven")
    suspend fun deleteAll()

    @Query("SELECT images FROM seven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seven")
    suspend fun getAllImages(): List<Seven>

    @Query("UPDATE seven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightDao {
    @Query("SELECT * FROM eight")
    fun getAll(): Flow<List<Eight>>

    @Upsert
    suspend fun upsert(eight: Eight)

    @Delete
    suspend fun delete(eight: Eight)

    @Query("DELETE FROM eight")
    suspend fun deleteAll()

    @Query("SELECT images FROM eight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eight")
    suspend fun getAllImages(): List<Eight>

    @Query("UPDATE eight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NineDao {
    @Query("SELECT * FROM nine")
    fun getAll(): Flow<List<Nine>>

    @Upsert
    suspend fun upsert(nine: Nine)

    @Delete
    suspend fun delete(nine: Nine)

    @Query("DELETE FROM nine")
    suspend fun deleteAll()

    @Query("SELECT images FROM nine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE nine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM nine")
    suspend fun getAllImages(): List<Nine>

    @Query("UPDATE nine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM nine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE nine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM nine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TenDao {
    @Query("SELECT * FROM ten")
    fun getAll(): Flow<List<Ten>>

    @Upsert
    suspend fun upsert(ten: Ten)

    @Delete
    suspend fun delete(ten: Ten)

    @Query("DELETE FROM ten")
    suspend fun deleteAll()

    @Query("SELECT images FROM ten WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ten SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ten")
    suspend fun getAllImages(): List<Ten>

    @Query("UPDATE ten SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ten WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ten SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ten WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface ElevenDao {
    @Query("SELECT * FROM eleven")
    fun getAll(): Flow<List<Eleven>>

    @Upsert
    suspend fun upsert(eleven: Eleven)

    @Delete
    suspend fun delete(eleven: Eleven)

    @Query("DELETE FROM eleven")
    suspend fun deleteAll()

    @Query("SELECT images FROM eleven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eleven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eleven")
    suspend fun getAllImages(): List<Eleven>

    @Query("UPDATE eleven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eleven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eleven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eleven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwelveDao {
    @Query("SELECT * FROM twelve")
    fun getAll(): Flow<List<Twelve>>

    @Upsert
    suspend fun upsert(twelve: Twelve)

    @Delete
    suspend fun delete(twelve: Twelve)

    @Query("DELETE FROM twelve")
    suspend fun deleteAll()

    @Query("SELECT images FROM twelve WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twelve SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twelve")
    suspend fun getAllImages(): List<Twelve>

    @Query("UPDATE twelve SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twelve WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twelve SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twelve WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirteenDao {
    @Query("SELECT * FROM thirteen")
    fun getAll(): Flow<List<Thirteen>>

    @Upsert
    suspend fun upsert(thirteen: Thirteen)

    @Delete
    suspend fun delete(thirteen: Thirteen)

    @Query("DELETE FROM thirteen")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirteen SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirteen")
    suspend fun getAllImages(): List<Thirteen>

    @Query("UPDATE thirteen SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FourteenDao {
    @Query("SELECT * FROM fourteen")
    fun getAll(): Flow<List<Fourteen>>

    @Upsert
    suspend fun upsert(fourteen: Fourteen)

    @Delete
    suspend fun delete(fourteen: Fourteen)

    @Query("DELETE FROM fourteen")
    suspend fun deleteAll()

    @Query("SELECT images FROM fourteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fourteen SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fourteen")
    suspend fun getAllImages(): List<Fourteen>

    @Query("UPDATE fourteen SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fourteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fourteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fourteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FifteenDao {
    @Query("SELECT * FROM fifteen")
    fun getAll(): Flow<List<Fifteen>>

    @Upsert
    suspend fun upsert(fifteen: Fifteen)

    @Delete
    suspend fun delete(fifteen: Fifteen)

    @Query("DELETE FROM fifteen")
    suspend fun deleteAll()

    @Query("SELECT images FROM fifteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fifteen SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fifteen")
    suspend fun getAllImages(): List<Fifteen>

    @Query("UPDATE fifteen SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fifteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fifteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fifteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface SixteenDao {
    @Query("SELECT * FROM sixteen")
    fun getAll(): Flow<List<Sixteen>>

    @Upsert
    suspend fun upsert(sixteen: Sixteen)

    @Delete
    suspend fun delete(sixteen: Sixteen)

    @Query("DELETE FROM sixteen")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixteen SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixteen")
    suspend fun getAllImages(): List<Sixteen>

    @Query("UPDATE sixteen SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventeenDao {
    @Query("SELECT * FROM seventeen")
    fun getAll(): Flow<List<Seventeen>>

    @Upsert
    suspend fun upsert(seventeen: Seventeen)

    @Delete
    suspend fun delete(seventeen: Seventeen)

    @Query("DELETE FROM seventeen")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventeen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventeen SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventeen")
    suspend fun getAllImages(): List<Seventeen>

    @Query("UPDATE seventeen SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventeen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventeen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventeen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EighteenDao {
    @Query("SELECT * FROM eighteen")
    fun getAll(): Flow<List<Eighteen>>

    @Upsert
    suspend fun upsert(eighteen: Eighteen)

    @Delete
    suspend fun delete(eighteen: Eighteen)

    @Query("DELETE FROM eighteen")
    suspend fun deleteAll()

    @Query("SELECT images FROM eighteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eighteen SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eighteen")
    suspend fun getAllImages(): List<Eighteen>

    @Query("UPDATE eighteen SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eighteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eighteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eighteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NineteenDao {
    @Query("SELECT * FROM nineteen")
    fun getAll(): Flow<List<Nineteen>>

    @Upsert
    suspend fun upsert(nineteen: Nineteen)

    @Delete
    suspend fun delete(nineteen: Nineteen)

    @Query("DELETE FROM nineteen")
    suspend fun deleteAll()

    @Query("SELECT images FROM nineteen WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE nineteen SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM nineteen")
    suspend fun getAllImages(): List<Nineteen>

    @Query("UPDATE nineteen SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM nineteen WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE nineteen SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM nineteen WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentyDao {
    @Query("SELECT * FROM twenty")
    fun getAll(): Flow<List<Twenty>>

    @Upsert
    suspend fun upsert(twenty: Twenty)

    @Delete
    suspend fun delete(twenty: Twenty)

    @Query("DELETE FROM twenty")
    suspend fun deleteAll()

    @Query("SELECT images FROM twenty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twenty SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twenty")
    suspend fun getAllImages(): List<Twenty>

    @Query("UPDATE twenty SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twenty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twenty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twenty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface TwentyOneDao {
    @Query("SELECT * FROM twentyOne")
    fun getAll(): Flow<List<TwentyOne>>

    @Upsert
    suspend fun upsert(twentyOne: TwentyOne)

    @Delete
    suspend fun delete(twentyOne: TwentyOne)

    @Query("DELETE FROM twentyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentyOne")
    suspend fun getAllImages(): List<TwentyOne>

    @Query("UPDATE twentyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentyTwoDao {
    @Query("SELECT * FROM twentyTwo")
    fun getAll(): Flow<List<TwentyTwo>>

    @Upsert
    suspend fun upsert(twentyTwo: TwentyTwo)

    @Delete
    suspend fun delete(twentyTwo: TwentyTwo)

    @Query("DELETE FROM twentyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentyTwo")
    suspend fun getAllImages(): List<TwentyTwo>

    @Query("UPDATE twentyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentyThreeDao {
    @Query("SELECT * FROM twentyThree")
    fun getAll(): Flow<List<TwentyThree>>

    @Upsert
    suspend fun upsert(twentyThree: TwentyThree)

    @Delete
    suspend fun delete(twentyThree: TwentyThree)

    @Query("DELETE FROM twentyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentyThree")
    suspend fun getAllImages(): List<TwentyThree>

    @Query("UPDATE twentyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentyFourDao {
    @Query("SELECT * FROM twentyFour")
    fun getAll(): Flow<List<TwentyFour>>

    @Upsert
    suspend fun upsert(twentyFour: TwentyFour)

    @Delete
    suspend fun delete(twentyFour: TwentyFour)

    @Query("DELETE FROM twentyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentyFour")
    suspend fun getAllImages(): List<TwentyFour>

    @Query("UPDATE twentyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentyFiveDao {
    @Query("SELECT * FROM twentyFive")
    fun getAll(): Flow<List<TwentyFive>>

    @Upsert
    suspend fun upsert(twentyFive: TwentyFive)

    @Delete
    suspend fun delete(twentyFive: TwentyFive)

    @Query("DELETE FROM twentyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentyFive")
    suspend fun getAllImages(): List<TwentyFive>

    @Query("UPDATE twentyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface TwentySixDao {
    @Query("SELECT * FROM twentySix")
    fun getAll(): Flow<List<TwentySix>>

    @Upsert
    suspend fun upsert(twentySix: TwentySix)

    @Delete
    suspend fun delete(twentySix: TwentySix)

    @Query("DELETE FROM twentySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentySix")
    suspend fun getAllImages(): List<TwentySix>

    @Query("UPDATE twentySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentySevenDao {
    @Query("SELECT * FROM twentySeven")
    fun getAll(): Flow<List<TwentySeven>>

    @Upsert
    suspend fun upsert(twentySeven: TwentySeven)

    @Delete
    suspend fun delete(twentySeven: TwentySeven)

    @Query("DELETE FROM twentySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentySeven")
    suspend fun getAllImages(): List<TwentySeven>

    @Query("UPDATE twentySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentyEightDao {
    @Query("SELECT * FROM twentyEight")
    fun getAll(): Flow<List<TwentyEight>>

    @Upsert
    suspend fun upsert(twentyEight: TwentyEight)

    @Delete
    suspend fun delete(twentyEight: TwentyEight)

    @Query("DELETE FROM twentyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentyEight")
    suspend fun getAllImages(): List<TwentyEight>

    @Query("UPDATE twentyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface TwentyNineDao {
    @Query("SELECT * FROM twentyNine")
    fun getAll(): Flow<List<TwentyNine>>

    @Upsert
    suspend fun upsert(twentyNine: TwentyNine)

    @Delete
    suspend fun delete(twentyNine: TwentyNine)

    @Query("DELETE FROM twentyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM twentyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE twentyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM twentyNine")
    suspend fun getAllImages(): List<TwentyNine>

    @Query("UPDATE twentyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM twentyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE twentyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM twentyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtyDao {
    @Query("SELECT * FROM thirty")
    fun getAll(): Flow<List<Thirty>>

    @Upsert
    suspend fun upsert(thirty: Thirty)

    @Delete
    suspend fun delete(thirty: Thirty)

    @Query("DELETE FROM thirty")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirty SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirty")
    suspend fun getAllImages(): List<Thirty>

    @Query("UPDATE thirty SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface ThirtyOneDao {
    @Query("SELECT * FROM thirtyOne")
    fun getAll(): Flow<List<ThirtyOne>>

    @Upsert
    suspend fun upsert(thirtyOne: ThirtyOne)

    @Delete
    suspend fun delete(thirtyOne: ThirtyOne)

    @Query("DELETE FROM thirtyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtyOne")
    suspend fun getAllImages(): List<ThirtyOne>

    @Query("UPDATE thirtyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtyTwoDao {
    @Query("SELECT * FROM thirtyTwo")
    fun getAll(): Flow<List<ThirtyTwo>>

    @Upsert
    suspend fun upsert(thirtyTwo: ThirtyTwo)

    @Delete
    suspend fun delete(thirtyTwo: ThirtyTwo)

    @Query("DELETE FROM thirtyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtyTwo")
    suspend fun getAllImages(): List<ThirtyTwo>

    @Query("UPDATE thirtyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtyThreeDao {
    @Query("SELECT * FROM thirtyThree")
    fun getAll(): Flow<List<ThirtyThree>>

    @Upsert
    suspend fun upsert(thirtyThree: ThirtyThree)

    @Delete
    suspend fun delete(thirtyThree: ThirtyThree)

    @Query("DELETE FROM thirtyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtyThree")
    suspend fun getAllImages(): List<ThirtyThree>

    @Query("UPDATE thirtyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtyFourDao {
    @Query("SELECT * FROM thirtyFour")
    fun getAll(): Flow<List<ThirtyFour>>

    @Upsert
    suspend fun upsert(thirtyFour: ThirtyFour)

    @Delete
    suspend fun delete(thirtyFour: ThirtyFour)

    @Query("DELETE FROM thirtyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtyFour")
    suspend fun getAllImages(): List<ThirtyFour>

    @Query("UPDATE thirtyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtyFiveDao {
    @Query("SELECT * FROM thirtyFive")
    fun getAll(): Flow<List<ThirtyFive>>

    @Upsert
    suspend fun upsert(thirtyFive: ThirtyFive)

    @Delete
    suspend fun delete(thirtyFive: ThirtyFive)

    @Query("DELETE FROM thirtyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtyFive")
    suspend fun getAllImages(): List<ThirtyFive>

    @Query("UPDATE thirtyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface ThirtySixDao {
    @Query("SELECT * FROM thirtySix")
    fun getAll(): Flow<List<ThirtySix>>

    @Upsert
    suspend fun upsert(thirtySix: ThirtySix)

    @Delete
    suspend fun delete(thirtySix: ThirtySix)

    @Query("DELETE FROM thirtySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtySix")
    suspend fun getAllImages(): List<ThirtySix>

    @Query("UPDATE thirtySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtySevenDao {
    @Query("SELECT * FROM thirtySeven")
    fun getAll(): Flow<List<ThirtySeven>>

    @Upsert
    suspend fun upsert(thirtySeven: ThirtySeven)

    @Delete
    suspend fun delete(thirtySeven: ThirtySeven)

    @Query("DELETE FROM thirtySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtySeven")
    suspend fun getAllImages(): List<ThirtySeven>

    @Query("UPDATE thirtySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtyEightDao {
    @Query("SELECT * FROM thirtyEight")
    fun getAll(): Flow<List<ThirtyEight>>

    @Upsert
    suspend fun upsert(thirtyEight: ThirtyEight)

    @Delete
    suspend fun delete(thirtyEight: ThirtyEight)

    @Query("DELETE FROM thirtyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtyEight")
    suspend fun getAllImages(): List<ThirtyEight>

    @Query("UPDATE thirtyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface ThirtyNineDao {
    @Query("SELECT * FROM thirtyNine")
    fun getAll(): Flow<List<ThirtyNine>>

    @Upsert
    suspend fun upsert(thirtyNine: ThirtyNine)

    @Delete
    suspend fun delete(thirtyNine: ThirtyNine)

    @Query("DELETE FROM thirtyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM thirtyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE thirtyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM thirtyNine")
    suspend fun getAllImages(): List<ThirtyNine>

    @Query("UPDATE thirtyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM thirtyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE thirtyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM thirtyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortyDao {
    @Query("SELECT * FROM forty")
    fun getAll(): Flow<List<Forty>>

    @Upsert
    suspend fun upsert(forty: Forty)

    @Delete
    suspend fun delete(forty: Forty)

    @Query("DELETE FROM forty")
    suspend fun deleteAll()

    @Query("SELECT images FROM forty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE forty SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM forty")
    suspend fun getAllImages(): List<Forty>

    @Query("UPDATE forty SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM forty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE forty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM forty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface FortyOneDao {
    @Query("SELECT * FROM fortyOne")
    fun getAll(): Flow<List<FortyOne>>

    @Upsert
    suspend fun upsert(fortyOne: FortyOne)

    @Delete
    suspend fun delete(fortyOne: FortyOne)

    @Query("DELETE FROM fortyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortyOne")
    suspend fun getAllImages(): List<FortyOne>

    @Query("UPDATE fortyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortyTwoDao {
    @Query("SELECT * FROM fortyTwo")
    fun getAll(): Flow<List<FortyTwo>>

    @Upsert
    suspend fun upsert(fortyTwo: FortyTwo)

    @Delete
    suspend fun delete(fortyTwo: FortyTwo)

    @Query("DELETE FROM fortyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortyTwo")
    suspend fun getAllImages(): List<FortyTwo>

    @Query("UPDATE fortyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortyThreeDao {
    @Query("SELECT * FROM fortyThree")
    fun getAll(): Flow<List<FortyThree>>

    @Upsert
    suspend fun upsert(fortyThree: FortyThree)

    @Delete
    suspend fun delete(fortyThree: FortyThree)

    @Query("DELETE FROM fortyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortyThree")
    suspend fun getAllImages(): List<FortyThree>

    @Query("UPDATE fortyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortyFourDao {
    @Query("SELECT * FROM fortyFour")
    fun getAll(): Flow<List<FortyFour>>

    @Upsert
    suspend fun upsert(fortyFour: FortyFour)

    @Delete
    suspend fun delete(fortyFour: FortyFour)

    @Query("DELETE FROM fortyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortyFour")
    suspend fun getAllImages(): List<FortyFour>

    @Query("UPDATE fortyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortyFiveDao {
    @Query("SELECT * FROM fortyFive")
    fun getAll(): Flow<List<FortyFive>>

    @Upsert
    suspend fun upsert(fortyFive: FortyFive)

    @Delete
    suspend fun delete(fortyFive: FortyFive)

    @Query("DELETE FROM fortyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortyFive")
    suspend fun getAllImages(): List<FortyFive>

    @Query("UPDATE fortyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface FortySixDao {
    @Query("SELECT * FROM fortySix")
    fun getAll(): Flow<List<FortySix>>

    @Upsert
    suspend fun upsert(fortySix: FortySix)

    @Delete
    suspend fun delete(fortySix: FortySix)

    @Query("DELETE FROM fortySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortySix")
    suspend fun getAllImages(): List<FortySix>

    @Query("UPDATE fortySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortySevenDao {
    @Query("SELECT * FROM fortySeven")
    fun getAll(): Flow<List<FortySeven>>

    @Upsert
    suspend fun upsert(fortySeven: FortySeven)

    @Delete
    suspend fun delete(fortySeven: FortySeven)

    @Query("DELETE FROM fortySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortySeven")
    suspend fun getAllImages(): List<FortySeven>

    @Query("UPDATE fortySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortyEightDao {
    @Query("SELECT * FROM fortyEight")
    fun getAll(): Flow<List<FortyEight>>

    @Upsert
    suspend fun upsert(fortyEight: FortyEight)

    @Delete
    suspend fun delete(fortyEight: FortyEight)

    @Query("DELETE FROM fortyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortyEight")
    suspend fun getAllImages(): List<FortyEight>

    @Query("UPDATE fortyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FortyNineDao {
    @Query("SELECT * FROM fortyNine")
    fun getAll(): Flow<List<FortyNine>>

    @Upsert
    suspend fun upsert(fortyNine: FortyNine)

    @Delete
    suspend fun delete(fortyNine: FortyNine)

    @Query("DELETE FROM fortyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM fortyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fortyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fortyNine")
    suspend fun getAllImages(): List<FortyNine>

    @Query("UPDATE fortyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fortyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fortyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fortyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftyDao {
    @Query("SELECT * FROM fifty")
    fun getAll(): Flow<List<Fifty>>

    @Upsert
    suspend fun upsert(fifty: Fifty)

    @Delete
    suspend fun delete(fifty: Fifty)

    @Query("DELETE FROM fifty")
    suspend fun deleteAll()

    @Query("SELECT images FROM fifty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fifty SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fifty")
    suspend fun getAllImages(): List<Fifty>

    @Query("UPDATE fifty SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fifty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fifty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fifty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface FiftyOneDao {
    @Query("SELECT * FROM fiftyOne")
    fun getAll(): Flow<List<FiftyOne>>

    @Upsert
    suspend fun upsert(fiftyOne: FiftyOne)

    @Delete
    suspend fun delete(fiftyOne: FiftyOne)

    @Query("DELETE FROM fiftyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftyOne")
    suspend fun getAllImages(): List<FiftyOne>

    @Query("UPDATE fiftyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftyTwoDao {
    @Query("SELECT * FROM fiftyTwo")
    fun getAll(): Flow<List<FiftyTwo>>

    @Upsert
    suspend fun upsert(fiftyTwo: FiftyTwo)

    @Delete
    suspend fun delete(fiftyTwo: FiftyTwo)

    @Query("DELETE FROM fiftyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftyTwo")
    suspend fun getAllImages(): List<FiftyTwo>

    @Query("UPDATE fiftyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftyThreeDao {
    @Query("SELECT * FROM fiftyThree")
    fun getAll(): Flow<List<FiftyThree>>

    @Upsert
    suspend fun upsert(fiftyThree: FiftyThree)

    @Delete
    suspend fun delete(fiftyThree: FiftyThree)

    @Query("DELETE FROM fiftyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftyThree")
    suspend fun getAllImages(): List<FiftyThree>

    @Query("UPDATE fiftyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftyFourDao {
    @Query("SELECT * FROM fiftyFour")
    fun getAll(): Flow<List<FiftyFour>>

    @Upsert
    suspend fun upsert(fiftyFour: FiftyFour)

    @Delete
    suspend fun delete(fiftyFour: FiftyFour)

    @Query("DELETE FROM fiftyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftyFour")
    suspend fun getAllImages(): List<FiftyFour>

    @Query("UPDATE fiftyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftyFiveDao {
    @Query("SELECT * FROM fiftyFive")
    fun getAll(): Flow<List<FiftyFive>>

    @Upsert
    suspend fun upsert(fiftyFive: FiftyFive)

    @Delete
    suspend fun delete(fiftyFive: FiftyFive)

    @Query("DELETE FROM fiftyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftyFive")
    suspend fun getAllImages(): List<FiftyFive>

    @Query("UPDATE fiftyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface FiftySixDao {
    @Query("SELECT * FROM fiftySix")
    fun getAll(): Flow<List<FiftySix>>

    @Upsert
    suspend fun upsert(fiftySix: FiftySix)

    @Delete
    suspend fun delete(fiftySix: FiftySix)

    @Query("DELETE FROM fiftySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftySix")
    suspend fun getAllImages(): List<FiftySix>

    @Query("UPDATE fiftySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftySevenDao {
    @Query("SELECT * FROM fiftySeven")
    fun getAll(): Flow<List<FiftySeven>>

    @Upsert
    suspend fun upsert(fiftySeven: FiftySeven)

    @Delete
    suspend fun delete(fiftySeven: FiftySeven)

    @Query("DELETE FROM fiftySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftySeven")
    suspend fun getAllImages(): List<FiftySeven>

    @Query("UPDATE fiftySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftyEightDao {
    @Query("SELECT * FROM fiftyEight")
    fun getAll(): Flow<List<FiftyEight>>

    @Upsert
    suspend fun upsert(fiftyEight: FiftyEight)

    @Delete
    suspend fun delete(fiftyEight: FiftyEight)

    @Query("DELETE FROM fiftyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftyEight")
    suspend fun getAllImages(): List<FiftyEight>

    @Query("UPDATE fiftyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface FiftyNineDao {
    @Query("SELECT * FROM fiftyNine")
    fun getAll(): Flow<List<FiftyNine>>

    @Upsert
    suspend fun upsert(fiftyNine: FiftyNine)

    @Delete
    suspend fun delete(fiftyNine: FiftyNine)

    @Query("DELETE FROM fiftyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM fiftyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE fiftyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM fiftyNine")
    suspend fun getAllImages(): List<FiftyNine>

    @Query("UPDATE fiftyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM fiftyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE fiftyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM fiftyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtyDao {
    @Query("SELECT * FROM sixty")
    fun getAll(): Flow<List<Sixty>>

    @Upsert
    suspend fun upsert(sixty: Sixty)

    @Delete
    suspend fun delete(sixty: Sixty)

    @Query("DELETE FROM sixty")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixty SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixty")
    suspend fun getAllImages(): List<Sixty>

    @Query("UPDATE sixty SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface SixtyOneDao {
    @Query("SELECT * FROM sixtyOne")
    fun getAll(): Flow<List<SixtyOne>>

    @Upsert
    suspend fun upsert(sixtyOne: SixtyOne)

    @Delete
    suspend fun delete(sixtyOne: SixtyOne)

    @Query("DELETE FROM sixtyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtyOne")
    suspend fun getAllImages(): List<SixtyOne>

    @Query("UPDATE sixtyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtyTwoDao {
    @Query("SELECT * FROM sixtyTwo")
    fun getAll(): Flow<List<SixtyTwo>>

    @Upsert
    suspend fun upsert(sixtyTwo: SixtyTwo)

    @Delete
    suspend fun delete(sixtyTwo: SixtyTwo)

    @Query("DELETE FROM sixtyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtyTwo")
    suspend fun getAllImages(): List<SixtyTwo>

    @Query("UPDATE sixtyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtyThreeDao {
    @Query("SELECT * FROM sixtyThree")
    fun getAll(): Flow<List<SixtyThree>>

    @Upsert
    suspend fun upsert(sixtyThree: SixtyThree)

    @Delete
    suspend fun delete(sixtyThree: SixtyThree)

    @Query("DELETE FROM sixtyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtyThree")
    suspend fun getAllImages(): List<SixtyThree>

    @Query("UPDATE sixtyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtyFourDao {
    @Query("SELECT * FROM sixtyFour")
    fun getAll(): Flow<List<SixtyFour>>

    @Upsert
    suspend fun upsert(sixtyFour: SixtyFour)

    @Delete
    suspend fun delete(sixtyFour: SixtyFour)

    @Query("DELETE FROM sixtyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtyFour")
    suspend fun getAllImages(): List<SixtyFour>

    @Query("UPDATE sixtyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtyFiveDao {
    @Query("SELECT * FROM sixtyFive")
    fun getAll(): Flow<List<SixtyFive>>

    @Upsert
    suspend fun upsert(sixtyFive: SixtyFive)

    @Delete
    suspend fun delete(sixtyFive: SixtyFive)

    @Query("DELETE FROM sixtyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtyFive")
    suspend fun getAllImages(): List<SixtyFive>

    @Query("UPDATE sixtyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface SixtySixDao {
    @Query("SELECT * FROM sixtySix")
    fun getAll(): Flow<List<SixtySix>>

    @Upsert
    suspend fun upsert(sixtySix: SixtySix)

    @Delete
    suspend fun delete(sixtySix: SixtySix)

    @Query("DELETE FROM sixtySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtySix")
    suspend fun getAllImages(): List<SixtySix>

    @Query("UPDATE sixtySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtySevenDao {
    @Query("SELECT * FROM sixtySeven")
    fun getAll(): Flow<List<SixtySeven>>

    @Upsert
    suspend fun upsert(sixtySeven: SixtySeven)

    @Delete
    suspend fun delete(sixtySeven: SixtySeven)

    @Query("DELETE FROM sixtySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtySeven")
    suspend fun getAllImages(): List<SixtySeven>

    @Query("UPDATE sixtySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtyEightDao {
    @Query("SELECT * FROM sixtyEight")
    fun getAll(): Flow<List<SixtyEight>>

    @Upsert
    suspend fun upsert(sixtyEight: SixtyEight)

    @Delete
    suspend fun delete(sixtyEight: SixtyEight)

    @Query("DELETE FROM sixtyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtyEight")
    suspend fun getAllImages(): List<SixtyEight>

    @Query("UPDATE sixtyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SixtyNineDao {
    @Query("SELECT * FROM sixtyNine")
    fun getAll(): Flow<List<SixtyNine>>

    @Upsert
    suspend fun upsert(sixtyNine: SixtyNine)

    @Delete
    suspend fun delete(sixtyNine: SixtyNine)

    @Query("DELETE FROM sixtyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM sixtyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE sixtyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM sixtyNine")
    suspend fun getAllImages(): List<SixtyNine>

    @Query("UPDATE sixtyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM sixtyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE sixtyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM sixtyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventyDao {
    @Query("SELECT * FROM seventy")
    fun getAll(): Flow<List<Seventy>>

    @Upsert
    suspend fun upsert(seventy: Seventy)

    @Delete
    suspend fun delete(seventy: Seventy)

    @Query("DELETE FROM seventy")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventy WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventy SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventy")
    suspend fun getAllImages(): List<Seventy>

    @Query("UPDATE seventy SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventy WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventy SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventy WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface SeventyOneDao {
    @Query("SELECT * FROM seventyOne")
    fun getAll(): Flow<List<SeventyOne>>

    @Upsert
    suspend fun upsert(seventyOne: SeventyOne)

    @Delete
    suspend fun delete(seventyOne: SeventyOne)

    @Query("DELETE FROM seventyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventyOne")
    suspend fun getAllImages(): List<SeventyOne>

    @Query("UPDATE seventyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventyTwoDao {
    @Query("SELECT * FROM seventyTwo")
    fun getAll(): Flow<List<SeventyTwo>>

    @Upsert
    suspend fun upsert(seventyTwo: SeventyTwo)

    @Delete
    suspend fun delete(seventyTwo: SeventyTwo)

    @Query("DELETE FROM seventyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventyTwo")
    suspend fun getAllImages(): List<SeventyTwo>

    @Query("UPDATE seventyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventyThreeDao {
    @Query("SELECT * FROM seventyThree")
    fun getAll(): Flow<List<SeventyThree>>

    @Upsert
    suspend fun upsert(seventyThree: SeventyThree)

    @Delete
    suspend fun delete(seventyThree: SeventyThree)

    @Query("DELETE FROM seventyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventyThree")
    suspend fun getAllImages(): List<SeventyThree>

    @Query("UPDATE seventyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventyFourDao {
    @Query("SELECT * FROM seventyFour")
    fun getAll(): Flow<List<SeventyFour>>

    @Upsert
    suspend fun upsert(seventyFour: SeventyFour)

    @Delete
    suspend fun delete(seventyFour: SeventyFour)

    @Query("DELETE FROM seventyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventyFour")
    suspend fun getAllImages(): List<SeventyFour>

    @Query("UPDATE seventyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventyFiveDao {
    @Query("SELECT * FROM seventyFive")
    fun getAll(): Flow<List<SeventyFive>>

    @Upsert
    suspend fun upsert(seventyFive: SeventyFive)

    @Delete
    suspend fun delete(seventyFive: SeventyFive)

    @Query("DELETE FROM seventyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventyFive")
    suspend fun getAllImages(): List<SeventyFive>

    @Query("UPDATE seventyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface SeventySixDao {
    @Query("SELECT * FROM seventySix")
    fun getAll(): Flow<List<SeventySix>>

    @Upsert
    suspend fun upsert(seventySix: SeventySix)

    @Delete
    suspend fun delete(seventySix: SeventySix)

    @Query("DELETE FROM seventySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventySix")
    suspend fun getAllImages(): List<SeventySix>

    @Query("UPDATE seventySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventySevenDao {
    @Query("SELECT * FROM seventySeven")
    fun getAll(): Flow<List<SeventySeven>>

    @Upsert
    suspend fun upsert(seventySeven: SeventySeven)

    @Delete
    suspend fun delete(seventySeven: SeventySeven)

    @Query("DELETE FROM seventySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventySeven")
    suspend fun getAllImages(): List<SeventySeven>

    @Query("UPDATE seventySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventyEightDao {
    @Query("SELECT * FROM seventyEight")
    fun getAll(): Flow<List<SeventyEight>>

    @Upsert
    suspend fun upsert(seventyEight: SeventyEight)

    @Delete
    suspend fun delete(seventyEight: SeventyEight)

    @Query("DELETE FROM seventyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventyEight")
    suspend fun getAllImages(): List<SeventyEight>

    @Query("UPDATE seventyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface SeventyNineDao {
    @Query("SELECT * FROM seventyNine")
    fun getAll(): Flow<List<SeventyNine>>

    @Upsert
    suspend fun upsert(seventyNine: SeventyNine)

    @Delete
    suspend fun delete(seventyNine: SeventyNine)

    @Query("DELETE FROM seventyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM seventyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE seventyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM seventyNine")
    suspend fun getAllImages(): List<SeventyNine>

    @Query("UPDATE seventyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM seventyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE seventyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM seventyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightyDao {
    @Query("SELECT * FROM eighty")
    fun getAll(): Flow<List<Eighty>>

    @Upsert
    suspend fun upsert(eighty: Eighty)

    @Delete
    suspend fun delete(eighty: Eighty)

    @Query("DELETE FROM eighty")
    suspend fun deleteAll()

    @Query("SELECT images FROM eighty WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eighty SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eighty")
    suspend fun getAllImages(): List<Eighty>

    @Query("UPDATE eighty SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eighty WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eighty SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eighty WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface EightyOneDao {
    @Query("SELECT * FROM eightyOne")
    fun getAll(): Flow<List<EightyOne>>

    @Upsert
    suspend fun upsert(eightyOne: EightyOne)

    @Delete
    suspend fun delete(eightyOne: EightyOne)

    @Query("DELETE FROM eightyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightyOne")
    suspend fun getAllImages(): List<EightyOne>

    @Query("UPDATE eightyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightyTwoDao {
    @Query("SELECT * FROM eightyTwo")
    fun getAll(): Flow<List<EightyTwo>>

    @Upsert
    suspend fun upsert(eightyTwo: EightyTwo)

    @Delete
    suspend fun delete(eightyTwo: EightyTwo)

    @Query("DELETE FROM eightyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightyTwo")
    suspend fun getAllImages(): List<EightyTwo>

    @Query("UPDATE eightyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightyThreeDao {
    @Query("SELECT * FROM eightyThree")
    fun getAll(): Flow<List<EightyThree>>

    @Upsert
    suspend fun upsert(eightyThree: EightyThree)

    @Delete
    suspend fun delete(eightyThree: EightyThree)

    @Query("DELETE FROM eightyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightyThree")
    suspend fun getAllImages(): List<EightyThree>

    @Query("UPDATE eightyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightyFourDao {
    @Query("SELECT * FROM eightyFour")
    fun getAll(): Flow<List<EightyFour>>

    @Upsert
    suspend fun upsert(eightyFour: EightyFour)

    @Delete
    suspend fun delete(eightyFour: EightyFour)

    @Query("DELETE FROM eightyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightyFour")
    suspend fun getAllImages(): List<EightyFour>

    @Query("UPDATE eightyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightyFiveDao {
    @Query("SELECT * FROM eightyFive")
    fun getAll(): Flow<List<EightyFive>>

    @Upsert
    suspend fun upsert(eightyFive: EightyFive)

    @Delete
    suspend fun delete(eightyFive: EightyFive)

    @Query("DELETE FROM eightyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightyFive")
    suspend fun getAllImages(): List<EightyFive>

    @Query("UPDATE eightyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface EightySixDao {
    @Query("SELECT * FROM eightySix")
    fun getAll(): Flow<List<EightySix>>

    @Upsert
    suspend fun upsert(eightySix: EightySix)

    @Delete
    suspend fun delete(eightySix: EightySix)

    @Query("DELETE FROM eightySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightySix")
    suspend fun getAllImages(): List<EightySix>

    @Query("UPDATE eightySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightySevenDao {
    @Query("SELECT * FROM eightySeven")
    fun getAll(): Flow<List<EightySeven>>

    @Upsert
    suspend fun upsert(eightySeven: EightySeven)

    @Delete
    suspend fun delete(eightySeven: EightySeven)

    @Query("DELETE FROM eightySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightySeven")
    suspend fun getAllImages(): List<EightySeven>

    @Query("UPDATE eightySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightyEightDao {
    @Query("SELECT * FROM eightyEight")
    fun getAll(): Flow<List<EightyEight>>

    @Upsert
    suspend fun upsert(eightyEight: EightyEight)

    @Delete
    suspend fun delete(eightyEight: EightyEight)

    @Query("DELETE FROM eightyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightyEight")
    suspend fun getAllImages(): List<EightyEight>

    @Query("UPDATE eightyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface EightyNineDao {
    @Query("SELECT * FROM eightyNine")
    fun getAll(): Flow<List<EightyNine>>

    @Upsert
    suspend fun upsert(eightyNine: EightyNine)

    @Delete
    suspend fun delete(eightyNine: EightyNine)

    @Query("DELETE FROM eightyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM eightyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE eightyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM eightyNine")
    suspend fun getAllImages(): List<EightyNine>

    @Query("UPDATE eightyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM eightyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE eightyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM eightyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetyDao {
    @Query("SELECT * FROM ninety")
    fun getAll(): Flow<List<Ninety>>

    @Upsert
    suspend fun upsert(ninety: Ninety)

    @Delete
    suspend fun delete(ninety: Ninety)

    @Query("DELETE FROM ninety")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninety WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninety SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninety")
    suspend fun getAllImages(): List<Ninety>

    @Query("UPDATE ninety SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninety WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninety SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninety WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface NinetyOneDao {
    @Query("SELECT * FROM ninetyOne")
    fun getAll(): Flow<List<NinetyOne>>

    @Upsert
    suspend fun upsert(ninetyOne: NinetyOne)

    @Delete
    suspend fun delete(ninetyOne: NinetyOne)

    @Query("DELETE FROM ninetyOne")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetyOne WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetyOne SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetyOne")
    suspend fun getAllImages(): List<NinetyOne>

    @Query("UPDATE ninetyOne SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetyOne WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetyOne SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetyOne WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetyTwoDao {
    @Query("SELECT * FROM ninetyTwo")
    fun getAll(): Flow<List<NinetyTwo>>

    @Upsert
    suspend fun upsert(ninetyTwo: NinetyTwo)

    @Delete
    suspend fun delete(ninetyTwo: NinetyTwo)

    @Query("DELETE FROM ninetyTwo")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetyTwo WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetyTwo SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetyTwo")
    suspend fun getAllImages(): List<NinetyTwo>

    @Query("UPDATE ninetyTwo SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetyTwo WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetyTwo SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetyTwo WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetyThreeDao {
    @Query("SELECT * FROM ninetyThree")
    fun getAll(): Flow<List<NinetyThree>>

    @Upsert
    suspend fun upsert(ninetyThree: NinetyThree)

    @Delete
    suspend fun delete(ninetyThree: NinetyThree)

    @Query("DELETE FROM ninetyThree")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetyThree WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetyThree SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetyThree")
    suspend fun getAllImages(): List<NinetyThree>

    @Query("UPDATE ninetyThree SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetyThree WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetyThree SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetyThree WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetyFourDao {
    @Query("SELECT * FROM ninetyFour")
    fun getAll(): Flow<List<NinetyFour>>

    @Upsert
    suspend fun upsert(ninetyFour: NinetyFour)

    @Delete
    suspend fun delete(ninetyFour: NinetyFour)

    @Query("DELETE FROM ninetyFour")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetyFour WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetyFour SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetyFour")
    suspend fun getAllImages(): List<NinetyFour>

    @Query("UPDATE ninetyFour SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetyFour WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetyFour SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetyFour WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetyFiveDao {
    @Query("SELECT * FROM ninetyFive")
    fun getAll(): Flow<List<NinetyFive>>

    @Upsert
    suspend fun upsert(ninetyFive: NinetyFive)

    @Delete
    suspend fun delete(ninetyFive: NinetyFive)

    @Query("DELETE FROM ninetyFive")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetyFive WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetyFive SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetyFive")
    suspend fun getAllImages(): List<NinetyFive>

    @Query("UPDATE ninetyFive SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetyFive WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetyFive SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetyFive WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}
@Dao
interface NinetySixDao {
    @Query("SELECT * FROM ninetySix")
    fun getAll(): Flow<List<NinetySix>>

    @Upsert
    suspend fun upsert(ninetySix: NinetySix)

    @Delete
    suspend fun delete(ninetySix: NinetySix)

    @Query("DELETE FROM ninetySix")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetySix WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetySix SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetySix")
    suspend fun getAllImages(): List<NinetySix>

    @Query("UPDATE ninetySix SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetySix WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetySix SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetySix WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetySevenDao {
    @Query("SELECT * FROM ninetySeven")
    fun getAll(): Flow<List<NinetySeven>>

    @Upsert
    suspend fun upsert(ninetySeven: NinetySeven)

    @Delete
    suspend fun delete(ninetySeven: NinetySeven)

    @Query("DELETE FROM ninetySeven")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetySeven WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetySeven SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetySeven")
    suspend fun getAllImages(): List<NinetySeven>

    @Query("UPDATE ninetySeven SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetySeven WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetySeven SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetySeven WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetyEightDao {
    @Query("SELECT * FROM ninetyEight")
    fun getAll(): Flow<List<NinetyEight>>

    @Upsert
    suspend fun upsert(ninetyEight: NinetyEight)

    @Delete
    suspend fun delete(ninetyEight: NinetyEight)

    @Query("DELETE FROM ninetyEight")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetyEight WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetyEight SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetyEight")
    suspend fun getAllImages(): List<NinetyEight>

    @Query("UPDATE ninetyEight SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetyEight WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetyEight SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetyEight WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface NinetyNineDao {
    @Query("SELECT * FROM ninetyNine")
    fun getAll(): Flow<List<NinetyNine>>

    @Upsert
    suspend fun upsert(ninetyNine: NinetyNine)

    @Delete
    suspend fun delete(ninetyNine: NinetyNine)

    @Query("DELETE FROM ninetyNine")
    suspend fun deleteAll()

    @Query("SELECT images FROM ninetyNine WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE ninetyNine SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM ninetyNine")
    suspend fun getAllImages(): List<NinetyNine>

    @Query("UPDATE ninetyNine SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM ninetyNine WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE ninetyNine SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM ninetyNine WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}

@Dao
interface HundredDao {
    @Query("SELECT * FROM Hundred")
    fun getAll(): Flow<List<Hundred>>

    @Upsert
    suspend fun upsert(Hundred: Hundred)

    @Delete
    suspend fun delete(Hundred: Hundred)

    @Query("DELETE FROM Hundred")
    suspend fun deleteAll()

    @Query("SELECT images FROM Hundred WHERE title = :title")
    suspend fun getImagesByTitle(title: String): String?

    @Query("UPDATE Hundred SET images = :images WHERE id = :id")
    suspend fun updateImages(id: Int, images: String)

    @Query("SELECT * FROM Hundred")
    suspend fun getAllImages(): List<Hundred>

    @Query("UPDATE Hundred SET videos = :videos WHERE id = :id")
    suspend fun updateVideos(id: Int, videos: String)

    @Query("SELECT videos FROM Hundred WHERE title = :title")
    suspend fun getVideosByTitle(title: String): String?

    @Query("UPDATE Hundred SET videos = CASE WHEN videos IS NULL OR videos = '' THEN :newVideo ELSE videos || ',' || :newVideo END WHERE id = :id")
    suspend fun appendVideo(id: Int, newVideo: String)

    @Query("SELECT COUNT(*) FROM Hundred WHERE title = :title")
    suspend fun getVideoCountByTitle(title: String): Int
}


