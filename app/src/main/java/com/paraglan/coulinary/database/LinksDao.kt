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

@Dao
interface ThreeLinksDao {
    @Query("SELECT * FROM threeLinks")
    fun getAll(): Flow<List<ThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(threeLinks: ThreeLinks)

    @Delete
    suspend fun deleteLinks(threeLinks: ThreeLinks)

    @Query("DELETE FROM threeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(threeLinks: ThreeLinks)
}
@Dao
interface FourLinksDao {
    @Query("SELECT * FROM fourLinks")
    fun getAll(): Flow<List<FourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fourLinks: FourLinks)

    @Delete
    suspend fun deleteLinks(fourLinks: FourLinks)

    @Query("DELETE FROM fourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fourLinks: FourLinks)
}
@Dao
interface FiveLinksDao {
    @Query("SELECT * FROM fiveLinks")
    fun getAll(): Flow<List<FiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiveLinks: FiveLinks)

    @Delete
    suspend fun deleteLinks(fiveLinks: FiveLinks)

    @Query("DELETE FROM fiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiveLinks: FiveLinks)
}
@Dao
interface SixLinksDao {
    @Query("SELECT * FROM sixLinks")
    fun getAll(): Flow<List<SixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixLinks: SixLinks)

    @Delete
    suspend fun deleteLinks(sixLinks: SixLinks)

    @Query("DELETE FROM sixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixLinks: SixLinks)
}
@Dao
interface SevenLinksDao {
    @Query("SELECT * FROM sevenLinks")
    fun getAll(): Flow<List<SevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sevenLinks: SevenLinks)

    @Delete
    suspend fun deleteLinks(sevenLinks: SevenLinks)

    @Query("DELETE FROM sevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sevenLinks: SevenLinks)
}
@Dao
interface EightLinksDao {
    @Query("SELECT * FROM eightLinks")
    fun getAll(): Flow<List<EightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightLinks: EightLinks)

    @Delete
    suspend fun deleteLinks(eightLinks: EightLinks)

    @Query("DELETE FROM eightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightLinks: EightLinks)
}
@Dao
interface NineLinksDao {
    @Query("SELECT * FROM nineLinks")
    fun getAll(): Flow<List<NineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(nineLinks: NineLinks)

    @Delete
    suspend fun deleteLinks(nineLinks: NineLinks)

    @Query("DELETE FROM nineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(nineLinks: NineLinks)
}
@Dao
interface TenLinksDao {
    @Query("SELECT * FROM tenLinks")
    fun getAll(): Flow<List<TenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(tenLinks: TenLinks)

    @Delete
    suspend fun deleteLinks(tenLinks: TenLinks)

    @Query("DELETE FROM tenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(tenLinks: TenLinks)
}
@Dao
interface ElevenLinksDao {
    @Query("SELECT * FROM elevenLinks")
    fun getAll(): Flow<List<ElevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(elevenLinks: ElevenLinks)

    @Delete
    suspend fun deleteLinks(elevenLinks: ElevenLinks)

    @Query("DELETE FROM elevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(elevenLinks: ElevenLinks)
}

@Dao
interface TwelveLinksDao {
    @Query("SELECT * FROM twelveLinks")
    fun getAll(): Flow<List<TwelveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twelveLinks: TwelveLinks)

    @Delete
    suspend fun deleteLinks(twelveLinks: TwelveLinks)

    @Query("DELETE FROM twelveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twelveLinks: TwelveLinks)
}

@Dao
interface ThirteenLinksDao {
    @Query("SELECT * FROM thirteenLinks")
    fun getAll(): Flow<List<ThirteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirteenLinks: ThirteenLinks)

    @Delete
    suspend fun deleteLinks(thirteenLinks: ThirteenLinks)

    @Query("DELETE FROM thirteenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirteenLinks: ThirteenLinks)
}

@Dao
interface FourteenLinksDao {
    @Query("SELECT * FROM fourteenLinks")
    fun getAll(): Flow<List<FourteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fourteenLinks: FourteenLinks)

    @Delete
    suspend fun deleteLinks(fourteenLinks: FourteenLinks)

    @Query("DELETE FROM fourteenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fourteenLinks: FourteenLinks)
}

@Dao
interface FifteenLinksDao {
    @Query("SELECT * FROM fifteenLinks")
    fun getAll(): Flow<List<FifteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fifteenLinks: FifteenLinks)

    @Delete
    suspend fun deleteLinks(fifteenLinks: FifteenLinks)

    @Query("DELETE FROM fifteenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fifteenLinks: FifteenLinks)
}

@Dao
interface SixteenLinksDao {
    @Query("SELECT * FROM sixteenLinks")
    fun getAll(): Flow<List<SixteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixteenLinks: SixteenLinks)

    @Delete
    suspend fun deleteLinks(sixteenLinks: SixteenLinks)

    @Query("DELETE FROM sixteenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixteenLinks: SixteenLinks)
}

@Dao
interface SeventeenLinksDao {
    @Query("SELECT * FROM seventeenLinks")
    fun getAll(): Flow<List<SeventeenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventeenLinks: SeventeenLinks)

    @Delete
    suspend fun deleteLinks(seventeenLinks: SeventeenLinks)

    @Query("DELETE FROM seventeenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventeenLinks: SeventeenLinks)
}

@Dao
interface EighteenLinksDao {
    @Query("SELECT * FROM eighteenLinks")
    fun getAll(): Flow<List<EighteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eighteenLinks: EighteenLinks)

    @Delete
    suspend fun deleteLinks(eighteenLinks: EighteenLinks)

    @Query("DELETE FROM eighteenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eighteenLinks: EighteenLinks)
}

@Dao
interface NineteenLinksDao {
    @Query("SELECT * FROM nineteenLinks")
    fun getAll(): Flow<List<NineteenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(nineteenLinks: NineteenLinks)

    @Delete
    suspend fun deleteLinks(nineteenLinks: NineteenLinks)

    @Query("DELETE FROM nineteenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(nineteenLinks: NineteenLinks)
}

@Dao
interface TwentyLinksDao {
    @Query("SELECT * FROM twentyLinks")
    fun getAll(): Flow<List<TwentyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyLinks: TwentyLinks)

    @Delete
    suspend fun deleteLinks(twentyLinks: TwentyLinks)

    @Query("DELETE FROM twentyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyLinks: TwentyLinks)
}
@Dao
interface TwentyOneLinksDao {
    @Query("SELECT * FROM twentyOneLinks")
    fun getAll(): Flow<List<TwentyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyOneLinks: TwentyOneLinks)

    @Delete
    suspend fun deleteLinks(twentyOneLinks: TwentyOneLinks)

    @Query("DELETE FROM twentyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyOneLinks: TwentyOneLinks)
}

@Dao
interface TwentyTwoLinksDao {
    @Query("SELECT * FROM twentyTwoLinks")
    fun getAll(): Flow<List<TwentyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyTwoLinks: TwentyTwoLinks)

    @Delete
    suspend fun deleteLinks(twentyTwoLinks: TwentyTwoLinks)

    @Query("DELETE FROM twentyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyTwoLinks: TwentyTwoLinks)
}

@Dao
interface TwentyThreeLinksDao {
    @Query("SELECT * FROM twentyThreeLinks")
    fun getAll(): Flow<List<TwentyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyThreeLinks: TwentyThreeLinks)

    @Delete
    suspend fun deleteLinks(twentyThreeLinks: TwentyThreeLinks)

    @Query("DELETE FROM twentyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyThreeLinks: TwentyThreeLinks)
}

@Dao
interface TwentyFourLinksDao {
    @Query("SELECT * FROM twentyFourLinks")
    fun getAll(): Flow<List<TwentyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyFourLinks: TwentyFourLinks)

    @Delete
    suspend fun deleteLinks(twentyFourLinks: TwentyFourLinks)

    @Query("DELETE FROM twentyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyFourLinks: TwentyFourLinks)
}

@Dao
interface TwentyFiveLinksDao {
    @Query("SELECT * FROM twentyFiveLinks")
    fun getAll(): Flow<List<TwentyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyFiveLinks: TwentyFiveLinks)

    @Delete
    suspend fun deleteLinks(twentyFiveLinks: TwentyFiveLinks)

    @Query("DELETE FROM twentyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyFiveLinks: TwentyFiveLinks)
}

@Dao
interface TwentySixLinksDao {
    @Query("SELECT * FROM twentySixLinks")
    fun getAll(): Flow<List<TwentySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentySixLinks: TwentySixLinks)

    @Delete
    suspend fun deleteLinks(twentySixLinks: TwentySixLinks)

    @Query("DELETE FROM twentySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentySixLinks: TwentySixLinks)
}

@Dao
interface TwentySevenLinksDao {
    @Query("SELECT * FROM twentySevenLinks")
    fun getAll(): Flow<List<TwentySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentySevenLinks: TwentySevenLinks)

    @Delete
    suspend fun deleteLinks(twentySevenLinks: TwentySevenLinks)

    @Query("DELETE FROM twentySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentySevenLinks: TwentySevenLinks)
}

@Dao
interface TwentyEightLinksDao {
    @Query("SELECT * FROM twentyEightLinks")
    fun getAll(): Flow<List<TwentyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyEightLinks: TwentyEightLinks)

    @Delete
    suspend fun deleteLinks(twentyEightLinks: TwentyEightLinks)

    @Query("DELETE FROM twentyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyEightLinks: TwentyEightLinks)
}

@Dao
interface TwentyNineLinksDao {
    @Query("SELECT * FROM twentyNineLinks")
    fun getAll(): Flow<List<TwentyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(twentyNineLinks: TwentyNineLinks)

    @Delete
    suspend fun deleteLinks(twentyNineLinks: TwentyNineLinks)

    @Query("DELETE FROM twentyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(twentyNineLinks: TwentyNineLinks)
}

@Dao
interface ThirtyLinksDao {
    @Query("SELECT * FROM thirtyLinks")
    fun getAll(): Flow<List<ThirtyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyLinks: ThirtyLinks)

    @Delete
    suspend fun deleteLinks(thirtyLinks: ThirtyLinks)

    @Query("DELETE FROM thirtyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyLinks: ThirtyLinks)
}
@Dao
interface ThirtyOneLinksDao {
    @Query("SELECT * FROM thirtyOneLinks")
    fun getAll(): Flow<List<ThirtyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyOneLinks: ThirtyOneLinks)

    @Delete
    suspend fun deleteLinks(thirtyOneLinks: ThirtyOneLinks)

    @Query("DELETE FROM thirtyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyOneLinks: ThirtyOneLinks)
}

@Dao
interface ThirtyTwoLinksDao {
    @Query("SELECT * FROM thirtyTwoLinks")
    fun getAll(): Flow<List<ThirtyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyTwoLinks: ThirtyTwoLinks)

    @Delete
    suspend fun deleteLinks(thirtyTwoLinks: ThirtyTwoLinks)

    @Query("DELETE FROM thirtyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyTwoLinks: ThirtyTwoLinks)
}

@Dao
interface ThirtyThreeLinksDao {
    @Query("SELECT * FROM thirtyThreeLinks")
    fun getAll(): Flow<List<ThirtyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyThreeLinks: ThirtyThreeLinks)

    @Delete
    suspend fun deleteLinks(thirtyThreeLinks: ThirtyThreeLinks)

    @Query("DELETE FROM thirtyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyThreeLinks: ThirtyThreeLinks)
}

@Dao
interface ThirtyFourLinksDao {
    @Query("SELECT * FROM thirtyFourLinks")
    fun getAll(): Flow<List<ThirtyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyFourLinks: ThirtyFourLinks)

    @Delete
    suspend fun deleteLinks(thirtyFourLinks: ThirtyFourLinks)

    @Query("DELETE FROM thirtyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyFourLinks: ThirtyFourLinks)
}

@Dao
interface ThirtyFiveLinksDao {
    @Query("SELECT * FROM thirtyFiveLinks")
    fun getAll(): Flow<List<ThirtyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyFiveLinks: ThirtyFiveLinks)

    @Delete
    suspend fun deleteLinks(thirtyFiveLinks: ThirtyFiveLinks)

    @Query("DELETE FROM thirtyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyFiveLinks: ThirtyFiveLinks)
}

@Dao
interface ThirtySixLinksDao {
    @Query("SELECT * FROM thirtySixLinks")
    fun getAll(): Flow<List<ThirtySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtySixLinks: ThirtySixLinks)

    @Delete
    suspend fun deleteLinks(thirtySixLinks: ThirtySixLinks)

    @Query("DELETE FROM thirtySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtySixLinks: ThirtySixLinks)
}

@Dao
interface ThirtySevenLinksDao {
    @Query("SELECT * FROM thirtySevenLinks")
    fun getAll(): Flow<List<ThirtySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtySevenLinks: ThirtySevenLinks)

    @Delete
    suspend fun deleteLinks(thirtySevenLinks: ThirtySevenLinks)

    @Query("DELETE FROM thirtySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtySevenLinks: ThirtySevenLinks)
}

@Dao
interface ThirtyEightLinksDao {
    @Query("SELECT * FROM thirtyEightLinks")
    fun getAll(): Flow<List<ThirtyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyEightLinks: ThirtyEightLinks)

    @Delete
    suspend fun deleteLinks(thirtyEightLinks: ThirtyEightLinks)

    @Query("DELETE FROM thirtyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyEightLinks: ThirtyEightLinks)
}

@Dao
interface ThirtyNineLinksDao {
    @Query("SELECT * FROM thirtyNineLinks")
    fun getAll(): Flow<List<ThirtyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(thirtyNineLinks: ThirtyNineLinks)

    @Delete
    suspend fun deleteLinks(thirtyNineLinks: ThirtyNineLinks)

    @Query("DELETE FROM thirtyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(thirtyNineLinks: ThirtyNineLinks)
}

@Dao
interface FourtyLinksDao {
    @Query("SELECT * FROM fourtyLinks")
    fun getAll(): Flow<List<FourtyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyLinks: FourtyLinks)

    @Delete
    suspend fun deleteLinks(fortyLinks: FourtyLinks)

    @Query("DELETE FROM fourtyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyLinks: FourtyLinks)
}
@Dao
interface FourtyOneLinksDao {
    @Query("SELECT * FROM fourtyOneLinks")
    fun getAll(): Flow<List<FourtyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyOneLinks: FourtyOneLinks)

    @Delete
    suspend fun deleteLinks(fortyOneLinks: FourtyOneLinks)

    @Query("DELETE FROM fourtyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyOneLinks: FourtyOneLinks)
}

@Dao
interface FourtyTwoLinksDao {
    @Query("SELECT * FROM fourtyTwoLinks")
    fun getAll(): Flow<List<FourtyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyTwoLinks: FourtyTwoLinks)

    @Delete
    suspend fun deleteLinks(fortyTwoLinks: FourtyTwoLinks)

    @Query("DELETE FROM fourtyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyTwoLinks: FourtyTwoLinks)
}

@Dao
interface FourtyThreeLinksDao {
    @Query("SELECT * FROM fourtyThreeLinks")
    fun getAll(): Flow<List<FourtyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyThreeLinks: FourtyThreeLinks)

    @Delete
    suspend fun deleteLinks(fortyThreeLinks: FourtyThreeLinks)

    @Query("DELETE FROM fourtyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyThreeLinks: FourtyThreeLinks)
}

@Dao
interface FourtyFourLinksDao {
    @Query("SELECT * FROM fourtyFourLinks")
    fun getAll(): Flow<List<FourtyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyFourLinks: FourtyFourLinks)

    @Delete
    suspend fun deleteLinks(fortyFourLinks: FourtyFourLinks)

    @Query("DELETE FROM fourtyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyFourLinks: FourtyFourLinks)
}

@Dao
interface FourtyFiveLinksDao {
    @Query("SELECT * FROM fourtyFiveLinks")
    fun getAll(): Flow<List<FourtyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyFiveLinks: FourtyFiveLinks)

    @Delete
    suspend fun deleteLinks(fortyFiveLinks: FourtyFiveLinks)

    @Query("DELETE FROM fourtyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyFiveLinks: FourtyFiveLinks)
}

@Dao
interface FourtySixLinksDao {
    @Query("SELECT * FROM fourtySixLinks")
    fun getAll(): Flow<List<FourtySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortySixLinks: FourtySixLinks)

    @Delete
    suspend fun deleteLinks(fortySixLinks: FourtySixLinks)

    @Query("DELETE FROM fourtySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortySixLinks: FourtySixLinks)
}

@Dao
interface FourtySevenLinksDao {
    @Query("SELECT * FROM fourtySevenLinks")
    fun getAll(): Flow<List<FourtySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortySevenLinks: FourtySevenLinks)

    @Delete
    suspend fun deleteLinks(fortySevenLinks: FourtySevenLinks)

    @Query("DELETE FROM fourtySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortySevenLinks: FourtySevenLinks)
}

@Dao
interface FourtyEightLinksDao {
    @Query("SELECT * FROM fourtyEightLinks")
    fun getAll(): Flow<List<FourtyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyEightLinks: FourtyEightLinks)

    @Delete
    suspend fun deleteLinks(fortyEightLinks: FourtyEightLinks)

    @Query("DELETE FROM fourtyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyEightLinks: FourtyEightLinks)
}

@Dao
interface FourtyNineLinksDao {
    @Query("SELECT * FROM fourtyNineLinks")
    fun getAll(): Flow<List<FourtyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fortyNineLinks: FourtyNineLinks)

    @Delete
    suspend fun deleteLinks(fortyNineLinks: FourtyNineLinks)

    @Query("DELETE FROM fourtyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fortyNineLinks: FourtyNineLinks)
}

@Dao
interface FiftyLinksDao {
    @Query("SELECT * FROM fiftyLinks")
    fun getAll(): Flow<List<FiftyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyLinks: FiftyLinks)

    @Delete
    suspend fun deleteLinks(fiftyLinks: FiftyLinks)

    @Query("DELETE FROM fiftyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyLinks: FiftyLinks)
}
@Dao
interface FiftyOneLinksDao {
    @Query("SELECT * FROM fiftyOneLinks")
    fun getAll(): Flow<List<FiftyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyOneLinks: FiftyOneLinks)

    @Delete
    suspend fun deleteLinks(fiftyOneLinks: FiftyOneLinks)

    @Query("DELETE FROM fiftyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyOneLinks: FiftyOneLinks)
}

@Dao
interface FiftyTwoLinksDao {
    @Query("SELECT * FROM fiftyTwoLinks")
    fun getAll(): Flow<List<FiftyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyTwoLinks: FiftyTwoLinks)

    @Delete
    suspend fun deleteLinks(fiftyTwoLinks: FiftyTwoLinks)

    @Query("DELETE FROM fiftyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyTwoLinks: FiftyTwoLinks)
}

@Dao
interface FiftyThreeLinksDao {
    @Query("SELECT * FROM fiftyThreeLinks")
    fun getAll(): Flow<List<FiftyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyThreeLinks: FiftyThreeLinks)

    @Delete
    suspend fun deleteLinks(fiftyThreeLinks: FiftyThreeLinks)

    @Query("DELETE FROM fiftyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyThreeLinks: FiftyThreeLinks)
}

@Dao
interface FiftyFourLinksDao {
    @Query("SELECT * FROM fiftyFourLinks")
    fun getAll(): Flow<List<FiftyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyFourLinks: FiftyFourLinks)

    @Delete
    suspend fun deleteLinks(fiftyFourLinks: FiftyFourLinks)

    @Query("DELETE FROM fiftyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyFourLinks: FiftyFourLinks)
}

@Dao
interface FiftyFiveLinksDao {
    @Query("SELECT * FROM fiftyFiveLinks")
    fun getAll(): Flow<List<FiftyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyFiveLinks: FiftyFiveLinks)

    @Delete
    suspend fun deleteLinks(fiftyFiveLinks: FiftyFiveLinks)

    @Query("DELETE FROM fiftyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyFiveLinks: FiftyFiveLinks)
}

@Dao
interface FiftySixLinksDao {
    @Query("SELECT * FROM fiftySixLinks")
    fun getAll(): Flow<List<FiftySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftySixLinks: FiftySixLinks)

    @Delete
    suspend fun deleteLinks(fiftySixLinks: FiftySixLinks)

    @Query("DELETE FROM fiftySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftySixLinks: FiftySixLinks)
}

@Dao
interface FiftySevenLinksDao {
    @Query("SELECT * FROM fiftySevenLinks")
    fun getAll(): Flow<List<FiftySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftySevenLinks: FiftySevenLinks)

    @Delete
    suspend fun deleteLinks(fiftySevenLinks: FiftySevenLinks)

    @Query("DELETE FROM fiftySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftySevenLinks: FiftySevenLinks)
}

@Dao
interface FiftyEightLinksDao {
    @Query("SELECT * FROM fiftyEightLinks")
    fun getAll(): Flow<List<FiftyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyEightLinks: FiftyEightLinks)

    @Delete
    suspend fun deleteLinks(fiftyEightLinks: FiftyEightLinks)

    @Query("DELETE FROM fiftyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyEightLinks: FiftyEightLinks)
}

@Dao
interface FiftyNineLinksDao {
    @Query("SELECT * FROM fiftyNineLinks")
    fun getAll(): Flow<List<FiftyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(fiftyNineLinks: FiftyNineLinks)

    @Delete
    suspend fun deleteLinks(fiftyNineLinks: FiftyNineLinks)

    @Query("DELETE FROM fiftyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(fiftyNineLinks: FiftyNineLinks)
}

@Dao
interface SixtyLinksDao {
    @Query("SELECT * FROM sixtyLinks")
    fun getAll(): Flow<List<SixtyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyLinks: SixtyLinks)

    @Delete
    suspend fun deleteLinks(sixtyLinks: SixtyLinks)

    @Query("DELETE FROM sixtyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyLinks: SixtyLinks)
}
@Dao
interface SixtyOneLinksDao {
    @Query("SELECT * FROM sixtyOneLinks")
    fun getAll(): Flow<List<SixtyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyOneLinks: SixtyOneLinks)

    @Delete
    suspend fun deleteLinks(sixtyOneLinks: SixtyOneLinks)

    @Query("DELETE FROM sixtyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyOneLinks: SixtyOneLinks)
}

@Dao
interface SixtyTwoLinksDao {
    @Query("SELECT * FROM sixtyTwoLinks")
    fun getAll(): Flow<List<SixtyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyTwoLinks: SixtyTwoLinks)

    @Delete
    suspend fun deleteLinks(sixtyTwoLinks: SixtyTwoLinks)

    @Query("DELETE FROM sixtyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyTwoLinks: SixtyTwoLinks)
}

@Dao
interface SixtyThreeLinksDao {
    @Query("SELECT * FROM sixtyThreeLinks")
    fun getAll(): Flow<List<SixtyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyThreeLinks: SixtyThreeLinks)

    @Delete
    suspend fun deleteLinks(sixtyThreeLinks: SixtyThreeLinks)

    @Query("DELETE FROM sixtyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyThreeLinks: SixtyThreeLinks)
}

@Dao
interface SixtyFourLinksDao {
    @Query("SELECT * FROM sixtyFourLinks")
    fun getAll(): Flow<List<SixtyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyFourLinks: SixtyFourLinks)

    @Delete
    suspend fun deleteLinks(sixtyFourLinks: SixtyFourLinks)

    @Query("DELETE FROM sixtyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyFourLinks: SixtyFourLinks)
}

@Dao
interface SixtyFiveLinksDao {
    @Query("SELECT * FROM sixtyFiveLinks")
    fun getAll(): Flow<List<SixtyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyFiveLinks: SixtyFiveLinks)

    @Delete
    suspend fun deleteLinks(sixtyFiveLinks: SixtyFiveLinks)

    @Query("DELETE FROM sixtyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyFiveLinks: SixtyFiveLinks)
}

@Dao
interface SixtySixLinksDao {
    @Query("SELECT * FROM sixtySixLinks")
    fun getAll(): Flow<List<SixtySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtySixLinks: SixtySixLinks)

    @Delete
    suspend fun deleteLinks(sixtySixLinks: SixtySixLinks)

    @Query("DELETE FROM sixtySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtySixLinks: SixtySixLinks)
}

@Dao
interface SixtySevenLinksDao {
    @Query("SELECT * FROM sixtySevenLinks")
    fun getAll(): Flow<List<SixtySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtySevenLinks: SixtySevenLinks)

    @Delete
    suspend fun deleteLinks(sixtySevenLinks: SixtySevenLinks)

    @Query("DELETE FROM sixtySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtySevenLinks: SixtySevenLinks)
}

@Dao
interface SixtyEightLinksDao {
    @Query("SELECT * FROM sixtyEightLinks")
    fun getAll(): Flow<List<SixtyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyEightLinks: SixtyEightLinks)

    @Delete
    suspend fun deleteLinks(sixtyEightLinks: SixtyEightLinks)

    @Query("DELETE FROM sixtyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyEightLinks: SixtyEightLinks)
}

@Dao
interface SixtyNineLinksDao {
    @Query("SELECT * FROM sixtyNineLinks")
    fun getAll(): Flow<List<SixtyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(sixtyNineLinks: SixtyNineLinks)

    @Delete
    suspend fun deleteLinks(sixtyNineLinks: SixtyNineLinks)

    @Query("DELETE FROM sixtyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(sixtyNineLinks: SixtyNineLinks)
}

@Dao
interface SeventyLinksDao {
    @Query("SELECT * FROM seventyLinks")
    fun getAll(): Flow<List<SeventyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyLinks: SeventyLinks)

    @Delete
    suspend fun deleteLinks(seventyLinks: SeventyLinks)

    @Query("DELETE FROM seventyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyLinks: SeventyLinks)
}
@Dao
interface SeventyOneLinksDao {
    @Query("SELECT * FROM seventyOneLinks")
    fun getAll(): Flow<List<SeventyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyOneLinks: SeventyOneLinks)

    @Delete
    suspend fun deleteLinks(seventyOneLinks: SeventyOneLinks)

    @Query("DELETE FROM seventyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyOneLinks: SeventyOneLinks)
}

@Dao
interface SeventyTwoLinksDao {
    @Query("SELECT * FROM seventyTwoLinks")
    fun getAll(): Flow<List<SeventyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyTwoLinks: SeventyTwoLinks)

    @Delete
    suspend fun deleteLinks(seventyTwoLinks: SeventyTwoLinks)

    @Query("DELETE FROM seventyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyTwoLinks: SeventyTwoLinks)
}

@Dao
interface SeventyThreeLinksDao {
    @Query("SELECT * FROM seventyThreeLinks")
    fun getAll(): Flow<List<SeventyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyThreeLinks: SeventyThreeLinks)

    @Delete
    suspend fun deleteLinks(seventyThreeLinks: SeventyThreeLinks)

    @Query("DELETE FROM seventyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyThreeLinks: SeventyThreeLinks)
}

@Dao
interface SeventyFourLinksDao {
    @Query("SELECT * FROM seventyFourLinks")
    fun getAll(): Flow<List<SeventyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyFourLinks: SeventyFourLinks)

    @Delete
    suspend fun deleteLinks(seventyFourLinks: SeventyFourLinks)

    @Query("DELETE FROM seventyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyFourLinks: SeventyFourLinks)
}

@Dao
interface SeventyFiveLinksDao {
    @Query("SELECT * FROM seventyFiveLinks")
    fun getAll(): Flow<List<SeventyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyFiveLinks: SeventyFiveLinks)

    @Delete
    suspend fun deleteLinks(seventyFiveLinks: SeventyFiveLinks)

    @Query("DELETE FROM seventyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyFiveLinks: SeventyFiveLinks)
}

@Dao
interface SeventySixLinksDao {
    @Query("SELECT * FROM seventySixLinks")
    fun getAll(): Flow<List<SeventySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventySixLinks: SeventySixLinks)

    @Delete
    suspend fun deleteLinks(seventySixLinks: SeventySixLinks)

    @Query("DELETE FROM seventySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventySixLinks: SeventySixLinks)
}

@Dao
interface SeventySevenLinksDao {
    @Query("SELECT * FROM seventySevenLinks")
    fun getAll(): Flow<List<SeventySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventySevenLinks: SeventySevenLinks)

    @Delete
    suspend fun deleteLinks(seventySevenLinks: SeventySevenLinks)

    @Query("DELETE FROM seventySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventySevenLinks: SeventySevenLinks)
}

@Dao
interface SeventyEightLinksDao {
    @Query("SELECT * FROM seventyEightLinks")
    fun getAll(): Flow<List<SeventyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyEightLinks: SeventyEightLinks)

    @Delete
    suspend fun deleteLinks(seventyEightLinks: SeventyEightLinks)

    @Query("DELETE FROM seventyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyEightLinks: SeventyEightLinks)
}

@Dao
interface SeventyNineLinksDao {
    @Query("SELECT * FROM seventyNineLinks")
    fun getAll(): Flow<List<SeventyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(seventyNineLinks: SeventyNineLinks)

    @Delete
    suspend fun deleteLinks(seventyNineLinks: SeventyNineLinks)

    @Query("DELETE FROM seventyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(seventyNineLinks: SeventyNineLinks)
}

@Dao
interface EightyLinksDao {
    @Query("SELECT * FROM eightyLinks")
    fun getAll(): Flow<List<EightyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyLinks: EightyLinks)

    @Delete
    suspend fun deleteLinks(eightyLinks: EightyLinks)

    @Query("DELETE FROM eightyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyLinks: EightyLinks)
}
@Dao
interface EightyOneLinksDao {
    @Query("SELECT * FROM eightyOneLinks")
    fun getAll(): Flow<List<EightyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyOneLinks: EightyOneLinks)

    @Delete
    suspend fun deleteLinks(eightyOneLinks: EightyOneLinks)

    @Query("DELETE FROM eightyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyOneLinks: EightyOneLinks)
}

@Dao
interface EightyTwoLinksDao {
    @Query("SELECT * FROM eightyTwoLinks")
    fun getAll(): Flow<List<EightyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyTwoLinks: EightyTwoLinks)

    @Delete
    suspend fun deleteLinks(eightyTwoLinks: EightyTwoLinks)

    @Query("DELETE FROM eightyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyTwoLinks: EightyTwoLinks)
}

@Dao
interface EightyThreeLinksDao {
    @Query("SELECT * FROM eightyThreeLinks")
    fun getAll(): Flow<List<EightyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyThreeLinks: EightyThreeLinks)

    @Delete
    suspend fun deleteLinks(eightyThreeLinks: EightyThreeLinks)

    @Query("DELETE FROM eightyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyThreeLinks: EightyThreeLinks)
}

@Dao
interface EightyFourLinksDao {
    @Query("SELECT * FROM eightyFourLinks")
    fun getAll(): Flow<List<EightyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyFourLinks: EightyFourLinks)

    @Delete
    suspend fun deleteLinks(eightyFourLinks: EightyFourLinks)

    @Query("DELETE FROM eightyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyFourLinks: EightyFourLinks)
}

@Dao
interface EightyFiveLinksDao {
    @Query("SELECT * FROM eightyFiveLinks")
    fun getAll(): Flow<List<EightyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyFiveLinks: EightyFiveLinks)

    @Delete
    suspend fun deleteLinks(eightyFiveLinks: EightyFiveLinks)

    @Query("DELETE FROM eightyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyFiveLinks: EightyFiveLinks)
}

@Dao
interface EightySixLinksDao {
    @Query("SELECT * FROM eightySixLinks")
    fun getAll(): Flow<List<EightySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightySixLinks: EightySixLinks)

    @Delete
    suspend fun deleteLinks(eightySixLinks: EightySixLinks)

    @Query("DELETE FROM eightySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightySixLinks: EightySixLinks)
}

@Dao
interface EightySevenLinksDao {
    @Query("SELECT * FROM eightySevenLinks")
    fun getAll(): Flow<List<EightySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightySevenLinks: EightySevenLinks)

    @Delete
    suspend fun deleteLinks(eightySevenLinks: EightySevenLinks)

    @Query("DELETE FROM eightySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightySevenLinks: EightySevenLinks)
}

@Dao
interface EightyEightLinksDao {
    @Query("SELECT * FROM eightyEightLinks")
    fun getAll(): Flow<List<EightyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyEightLinks: EightyEightLinks)

    @Delete
    suspend fun deleteLinks(eightyEightLinks: EightyEightLinks)

    @Query("DELETE FROM eightyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyEightLinks: EightyEightLinks)
}

@Dao
interface EightyNineLinksDao {
    @Query("SELECT * FROM eightyNineLinks")
    fun getAll(): Flow<List<EightyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(eightyNineLinks: EightyNineLinks)

    @Delete
    suspend fun deleteLinks(eightyNineLinks: EightyNineLinks)

    @Query("DELETE FROM eightyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(eightyNineLinks: EightyNineLinks)
}

@Dao
interface NinetyLinksDao {
    @Query("SELECT * FROM ninetyLinks")
    fun getAll(): Flow<List<NinetyLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyLinks: NinetyLinks)

    @Delete
    suspend fun deleteLinks(ninetyLinks: NinetyLinks)

    @Query("DELETE FROM ninetyLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyLinks: NinetyLinks)
}
@Dao
interface NinetyOneLinksDao {
    @Query("SELECT * FROM ninetyOneLinks")
    fun getAll(): Flow<List<NinetyOneLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyOneLinks: NinetyOneLinks)

    @Delete
    suspend fun deleteLinks(ninetyOneLinks: NinetyOneLinks)

    @Query("DELETE FROM ninetyOneLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyOneLinks: NinetyOneLinks)
}

@Dao
interface NinetyTwoLinksDao {
    @Query("SELECT * FROM ninetyTwoLinks")
    fun getAll(): Flow<List<NinetyTwoLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyTwoLinks: NinetyTwoLinks)

    @Delete
    suspend fun deleteLinks(ninetyTwoLinks: NinetyTwoLinks)

    @Query("DELETE FROM ninetyTwoLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyTwoLinks: NinetyTwoLinks)
}

@Dao
interface NinetyThreeLinksDao {
    @Query("SELECT * FROM ninetyThreeLinks")
    fun getAll(): Flow<List<NinetyThreeLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyThreeLinks: NinetyThreeLinks)

    @Delete
    suspend fun deleteLinks(ninetyThreeLinks: NinetyThreeLinks)

    @Query("DELETE FROM ninetyThreeLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyThreeLinks: NinetyThreeLinks)
}

@Dao
interface NinetyFourLinksDao {
    @Query("SELECT * FROM ninetyFourLinks")
    fun getAll(): Flow<List<NinetyFourLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyFourLinks: NinetyFourLinks)

    @Delete
    suspend fun deleteLinks(ninetyFourLinks: NinetyFourLinks)

    @Query("DELETE FROM ninetyFourLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyFourLinks: NinetyFourLinks)
}

@Dao
interface NinetyFiveLinksDao {
    @Query("SELECT * FROM ninetyFiveLinks")
    fun getAll(): Flow<List<NinetyFiveLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyFiveLinks: NinetyFiveLinks)

    @Delete
    suspend fun deleteLinks(ninetyFiveLinks: NinetyFiveLinks)

    @Query("DELETE FROM ninetyFiveLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyFiveLinks: NinetyFiveLinks)
}

@Dao
interface NinetySixLinksDao {
    @Query("SELECT * FROM ninetySixLinks")
    fun getAll(): Flow<List<NinetySixLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetySixLinks: NinetySixLinks)

    @Delete
    suspend fun deleteLinks(ninetySixLinks: NinetySixLinks)

    @Query("DELETE FROM ninetySixLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetySixLinks: NinetySixLinks)
}

@Dao
interface NinetySevenLinksDao {
    @Query("SELECT * FROM ninetySevenLinks")
    fun getAll(): Flow<List<NinetySevenLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetySevenLinks: NinetySevenLinks)

    @Delete
    suspend fun deleteLinks(ninetySevenLinks: NinetySevenLinks)

    @Query("DELETE FROM ninetySevenLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetySevenLinks: NinetySevenLinks)
}

@Dao
interface NinetyEightLinksDao {
    @Query("SELECT * FROM ninetyEightLinks")
    fun getAll(): Flow<List<NinetyEightLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyEightLinks: NinetyEightLinks)

    @Delete
    suspend fun deleteLinks(ninetyEightLinks: NinetyEightLinks)

    @Query("DELETE FROM ninetyEightLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyEightLinks: NinetyEightLinks)
}

@Dao
interface NinetyNineLinksDao {
    @Query("SELECT * FROM ninetyNineLinks")
    fun getAll(): Flow<List<NinetyNineLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(ninetyNineLinks: NinetyNineLinks)

    @Delete
    suspend fun deleteLinks(ninetyNineLinks: NinetyNineLinks)

    @Query("DELETE FROM ninetyNineLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(ninetyNineLinks: NinetyNineLinks)
}

@Dao
interface HundredLinksDao {
    @Query("SELECT * FROM HundredLinks")
    fun getAll(): Flow<List<HundredLinks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLinks(HundredLinks: HundredLinks)

    @Delete
    suspend fun deleteLinks(HundredLinks: HundredLinks)

    @Query("DELETE FROM HundredLinks")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsertLink(HundredLinks: HundredLinks)
}
