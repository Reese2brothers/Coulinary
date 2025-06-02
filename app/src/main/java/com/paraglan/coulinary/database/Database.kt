package com.paraglan.coulinary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MainCategories::class, Favourites::class, One::class, Two::class, Three::class,
    Four::class, Five::class, Six::class, Seven::class, Eight::class, Nine::class, Ten::class,
    Eleven::class, Twelve::class, Thirteen::class, Fourteen::class, Fifteen::class,
    Sixteen::class, Seventeen::class, Eighteen::class, Nineteen::class, Twenty::class,
    TwentyOne::class, TwentyTwo::class, TwentyThree::class, TwentyFour::class, TwentyFive::class,
    TwentySix::class, TwentySeven::class, TwentyEight::class, TwentyNine::class, Thirty::class,
    ThirtyOne::class, ThirtyTwo::class, ThirtyThree::class, ThirtyFour::class, ThirtyFive::class,
    ThirtySix::class, ThirtySeven::class, ThirtyEight::class, ThirtyNine::class, Forty::class,
    FortyOne::class, FortyTwo::class, FortyThree::class, FortyFour::class, FortyFive::class,
    FortySix::class, FortySeven::class, FortyEight::class, FortyNine::class, Fifty::class,
    FiftyOne::class, FiftyTwo::class, FiftyThree::class, FiftyFour::class, FiftyFive::class,
    FiftySix::class, FiftySeven::class, FiftyEight::class, FiftyNine::class, Sixty::class,
    SixtyOne::class, SixtyTwo::class, SixtyThree::class, SixtyFour::class, SixtyFive::class,
    SixtySix::class, SixtySeven::class, SixtyEight::class, SixtyNine::class, Seventy::class,
    SeventyOne::class, SeventyTwo::class, SeventyThree::class, SeventyFour::class, SeventyFive::class,
    SeventySix::class, SeventySeven::class, SeventyEight::class, SeventyNine::class, Eighty::class,
    EightyOne::class, EightyTwo::class, EightyThree::class, EightyFour::class, EightyFive::class,
    EightySix::class, EightySeven::class, EightyEight::class, EightyNine::class, Ninety::class,
    NinetyOne::class, NinetyTwo::class, NinetyThree::class, NinetyFour::class, NinetyFive::class,
    NinetySix::class, NinetySeven::class, NinetyEight::class, NinetyNine::class, Hundred::class,
    OneLinks::class, TwoLinks::class, ThreeLinks::class, FourLinks::class, FiveLinks::class, SixLinks::class,
    SevenLinks::class, EightLinks::class, NineLinks::class, TenLinks::class,
    ElevenLinks::class, TwelveLinks::class, ThirteenLinks::class, FourteenLinks::class, FifteenLinks::class,
    SixteenLinks::class, SeventeenLinks::class, EighteenLinks::class, NineteenLinks::class, TwentyLinks::class,
    TwentyOneLinks::class, TwentyTwoLinks::class, TwentyThreeLinks::class, TwentyFourLinks::class, TwentyFiveLinks::class,
    TwentySixLinks::class, TwentySevenLinks::class, TwentyEightLinks::class, TwentyNineLinks::class, ThirtyLinks::class,
    ThirtyOneLinks::class, ThirtyTwoLinks::class, ThirtyThreeLinks::class, ThirtyFourLinks::class, ThirtyFiveLinks::class,
    ThirtySixLinks::class, ThirtySevenLinks::class, ThirtyEightLinks::class, ThirtyNineLinks::class, FortyLinks::class,
    FortyOneLinks::class, FortyTwoLinks::class, FortyThreeLinks::class, FortyFourLinks::class, FortyFiveLinks::class,
    FortySixLinks::class, FortySevenLinks::class, FortyEightLinks::class, FortyNineLinks::class, FiftyLinks::class,
    FiftyOneLinks::class, FiftyTwoLinks::class, FiftyThreeLinks::class, FiftyFourLinks::class, FiftyFiveLinks::class,
    FiftySixLinks::class, FiftySevenLinks::class, FiftyEightLinks::class, FiftyNineLinks::class, SixtyLinks::class,
    SixtyOneLinks::class, SixtyTwoLinks::class, SixtyThreeLinks::class, SixtyFourLinks::class, SixtyFiveLinks::class,
    SixtySixLinks::class, SixtySevenLinks::class, SixtyEightLinks::class, SixtyNineLinks::class, SeventyLinks::class,
    SeventyOneLinks::class, SeventyTwoLinks::class, SeventyThreeLinks::class, SeventyFourLinks::class, SeventyFiveLinks::class,
    SeventySixLinks::class, SeventySevenLinks::class, SeventyEightLinks::class, SeventyNineLinks::class, EightyLinks::class,
    EightyOneLinks::class, EightyTwoLinks::class, EightyThreeLinks::class, EightyFourLinks::class, EightyFiveLinks::class,
    EightySixLinks::class, EightySevenLinks::class, EightyEightLinks::class, EightyNineLinks::class, NinetyLinks::class,
    NinetyOneLinks::class, NinetyTwoLinks::class, NinetyThreeLinks::class, NinetyFourLinks::class, NinetyFiveLinks::class,
    NinetySixLinks::class, NinetySevenLinks::class, NinetyEightLinks::class, NinetyNineLinks::class, HundredLinks::class

                     ], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mainCategoriesDao(): MainCategoriesDao
    abstract fun favouritesDao(): FavouritesDao
    abstract fun oneDao(): OneDao
    abstract fun twoDao(): TwoDao
    abstract fun threeDao(): ThreeDao
    abstract fun fourDao(): FourDao
    abstract fun fiveDao(): FiveDao
    abstract fun sixDao(): SixDao
    abstract fun sevenDao(): SevenDao
    abstract fun eightDao(): EightDao
    abstract fun nineDao(): NineDao
    abstract fun tenDao(): TenDao
    abstract fun elevenDao(): ElevenDao
    abstract fun twelveDao(): TwelveDao
    abstract fun thirteenDao(): ThirteenDao
    abstract fun fourteenDao(): FourteenDao
    abstract fun fifteenDao(): FifteenDao
    abstract fun sixteenDao(): SixteenDao
    abstract fun seventeenDao(): SeventeenDao
    abstract fun eighteenDao(): EighteenDao
    abstract fun nineteenDao(): NineteenDao
    abstract fun twentyDao(): TwentyDao
    abstract fun twentyOneDao(): TwentyOneDao
    abstract fun twentyTwoDao(): TwentyTwoDao
    abstract fun twentyThreeDao(): TwentyThreeDao
    abstract fun twentyFourDao(): TwentyFourDao
    abstract fun twentyFiveDao(): TwentyFiveDao
    abstract fun twentySixDao(): TwentySixDao
    abstract fun twentySevenDao(): TwentySevenDao
    abstract fun twentyEightDao(): TwentyEightDao
    abstract fun twentyNineDao(): TwentyNineDao
    abstract fun thirtyDao(): ThirtyDao
    abstract fun thirtyOneDao(): ThirtyOneDao
    abstract fun thirtyTwoDao(): ThirtyTwoDao
    abstract fun thirtyThreeDao(): ThirtyThreeDao
    abstract fun thirtyFourDao(): ThirtyFourDao
    abstract fun thirtyFiveDao(): ThirtyFiveDao
    abstract fun thirtySixDao(): ThirtySixDao
    abstract fun thirtySevenDao(): ThirtySevenDao
    abstract fun thirtyEightDao(): ThirtyEightDao
    abstract fun thirtyNineDao(): ThirtyNineDao
    abstract fun fortyDao(): FortyDao
    abstract fun fortyOneDao(): FortyOneDao
    abstract fun fortyTwoDao(): FortyTwoDao
    abstract fun fortyThreeDao(): FortyThreeDao
    abstract fun fortyFourDao(): FortyFourDao
    abstract fun fortyFiveDao(): FortyFiveDao
    abstract fun fortySixDao(): FortySixDao
    abstract fun fortySevenDao(): FortySevenDao
    abstract fun fortyEightDao(): FortyEightDao
    abstract fun fortyNineDao(): FortyNineDao
    abstract fun fiftyDao(): FiftyDao
    abstract fun fiftyOneDao(): FiftyOneDao
    abstract fun fiftyTwoDao(): FiftyTwoDao
    abstract fun fiftyThreeDao(): FiftyThreeDao
    abstract fun fiftyFourDao(): FiftyFourDao
    abstract fun fiftyFiveDao(): FiftyFiveDao
    abstract fun fiftySixDao(): FiftySixDao
    abstract fun fiftySevenDao(): FiftySevenDao
    abstract fun fiftyEightDao(): FiftyEightDao
    abstract fun fiftyNineDao(): FiftyNineDao
    abstract fun sixtyDao(): SixtyDao
    abstract fun sixtyOneDao(): SixtyOneDao
    abstract fun sixtyTwoDao(): SixtyTwoDao
    abstract fun sixtyThreeDao(): SixtyThreeDao
    abstract fun sixtyFourDao(): SixtyFourDao
    abstract fun sixtyFiveDao(): SixtyFiveDao
    abstract fun sixtySixDao(): SixtySixDao
    abstract fun sixtySevenDao(): SixtySevenDao
    abstract fun sixtyEightDao(): SixtyEightDao
    abstract fun sixtyNineDao(): SixtyNineDao
    abstract fun seventyDao(): SeventyDao
    abstract fun seventyOneDao(): SeventyOneDao
    abstract fun seventyTwoDao(): SeventyTwoDao
    abstract fun seventyThreeDao(): SeventyThreeDao
    abstract fun seventyFourDao(): SeventyFourDao
    abstract fun seventyFiveDao(): SeventyFiveDao
    abstract fun seventySixDao(): SeventySixDao
    abstract fun seventySevenDao(): SeventySevenDao
    abstract fun seventyEightDao(): SeventyEightDao
    abstract fun seventyNineDao(): SeventyNineDao
    abstract fun eightyDao(): EightyDao
    abstract fun eightyOneDao(): EightyOneDao
    abstract fun eightyTwoDao(): EightyTwoDao
    abstract fun eightyThreeDao(): EightyThreeDao
    abstract fun eightyFourDao(): EightyFourDao
    abstract fun eightyFiveDao(): EightyFiveDao
    abstract fun eightySixDao(): EightySixDao
    abstract fun eightySevenDao(): EightySevenDao
    abstract fun eightyEightDao(): EightyEightDao
    abstract fun eightyNineDao(): EightyNineDao
    abstract fun ninetyDao(): NinetyDao
    abstract fun ninetyOneDao(): NinetyOneDao
    abstract fun ninetyTwoDao(): NinetyTwoDao
    abstract fun ninetyThreeDao(): NinetyThreeDao
    abstract fun ninetyFourDao(): NinetyFourDao
    abstract fun ninetyFiveDao(): NinetyFiveDao
    abstract fun ninetySixDao(): NinetySixDao
    abstract fun ninetySevenDao(): NinetySevenDao
    abstract fun ninetyEightDao(): NinetyEightDao
    abstract fun ninetyNineDao(): NinetyNineDao
    abstract fun hundredDao(): HundredDao

    abstract fun oneLinksDao(): OneLinksDao
    abstract fun twoLinksDao(): TwoLinksDao
    abstract fun threeLinksDao(): ThreeLinksDao
    abstract fun fourLinksDao(): FourLinksDao
    abstract fun fiveLinksDao(): FiveLinksDao
    abstract fun sixLinksDao(): SixLinksDao
    abstract fun sevenLinksDao(): SevenLinksDao
    abstract fun eightLinksDao(): EightLinksDao
    abstract fun nineLinksDao(): NineLinksDao
    abstract fun tenLinksDao(): TenLinksDao
    abstract fun elevenLinksDao(): ElevenLinksDao
    abstract fun twelveLinksDao(): TwelveLinksDao
    abstract fun thirteenLinksDao(): ThirteenLinksDao
    abstract fun fourteenLinksDao(): FourteenLinksDao
    abstract fun fifteenLinksDao(): FifteenLinksDao
    abstract fun sixteenLinksDao(): SixteenLinksDao
    abstract fun seventeenLinksDao(): SeventeenLinksDao
    abstract fun eighteenLinksDao(): EighteenLinksDao
    abstract fun nineteenLinksDao(): NineteenLinksDao
    abstract fun twentyLinksDao(): TwentyLinksDao
    abstract fun twentyOneLinksDao(): TwentyOneLinksDao
    abstract fun twentyTwoLinksDao(): TwentyTwoLinksDao
    abstract fun twentyThreeLinksDao(): TwentyThreeLinksDao
    abstract fun twentyFourLinksDao(): TwentyFourLinksDao
    abstract fun twentyFiveLinksDao(): TwentyFiveLinksDao
    abstract fun twentySixLinksDao(): TwentySixLinksDao
    abstract fun twentySevenLinksDao(): TwentySevenLinksDao
    abstract fun twentyEightLinksDao(): TwentyEightLinksDao
    abstract fun twentyNineLinksDao(): TwentyNineLinksDao
    abstract fun thirtyLinksDao(): ThirtyLinksDao
    abstract fun thirtyOneLinksDao(): ThirtyOneLinksDao
    abstract fun thirtyTwoLinksDao(): ThirtyTwoLinksDao
    abstract fun thirtyThreeLinksDao(): ThirtyThreeLinksDao
    abstract fun thirtyFourLinksDao(): ThirtyFourLinksDao
    abstract fun thirtyFiveLinksDao(): ThirtyFiveLinksDao
    abstract fun thirtySixLinksDao(): ThirtySixLinksDao
    abstract fun thirtySevenLinksDao(): ThirtySevenLinksDao
    abstract fun thirtyEightLinksDao(): ThirtyEightLinksDao
    abstract fun thirtyNineLinksDao(): ThirtyNineLinksDao
    abstract fun fortyLinksDao(): FortyLinksDao
    abstract fun fortyOneLinksDao(): FortyOneLinksDao
    abstract fun fortyTwoLinksDao(): FortyTwoLinksDao
    abstract fun fortyThreeLinksDao(): FortyThreeLinksDao
    abstract fun fortyFourLinksDao(): FortyFourLinksDao
    abstract fun fortyFiveLinksDao(): FortyFiveLinksDao
    abstract fun fortySixLinksDao(): FortySixLinksDao
    abstract fun fortySevenLinksDao(): FortySevenLinksDao
    abstract fun fortyEightLinksDao(): FortyEightLinksDao
    abstract fun fortyNineLinksDao(): FortyNineLinksDao
    abstract fun fiftyLinksDao(): FiftyLinksDao
    abstract fun fiftyOneLinksDao(): FiftyOneLinksDao
    abstract fun fiftyTwoLinksDao(): FiftyTwoLinksDao
    abstract fun fiftyThreeLinksDao(): FiftyThreeLinksDao
    abstract fun fiftyFourLinksDao(): FiftyFourLinksDao
    abstract fun fiftyFiveLinksDao(): FiftyFiveLinksDao
    abstract fun fiftySixLinksDao(): FiftySixLinksDao
    abstract fun fiftySevenLinksDao(): FiftySevenLinksDao
    abstract fun fiftyEightLinksDao(): FiftyEightLinksDao
    abstract fun fiftyNineLinksDao(): FiftyNineLinksDao
    abstract fun sixtyLinksDao(): SixtyLinksDao
    abstract fun sixtyOneLinksDao(): SixtyOneLinksDao
    abstract fun sixtyTwoLinksDao(): SixtyTwoLinksDao
    abstract fun sixtyThreeLinksDao(): SixtyThreeLinksDao
    abstract fun sixtyFourLinksDao(): SixtyFourLinksDao
    abstract fun sixtyFiveLinksDao(): SixtyFiveLinksDao
    abstract fun sixtySixLinksDao(): SixtySixLinksDao
    abstract fun sixtySevenLinksDao(): SixtySevenLinksDao
    abstract fun sixtyEightLinksDao(): SixtyEightLinksDao
    abstract fun sixtyNineLinksDao(): SixtyNineLinksDao
    abstract fun seventyLinksDao(): SeventyLinksDao
    abstract fun seventyOneLinksDao(): SeventyOneLinksDao
    abstract fun seventyTwoLinksDao(): SeventyTwoLinksDao
    abstract fun seventyThreeLinksDao(): SeventyThreeLinksDao
    abstract fun seventyFourLinksDao(): SeventyFourLinksDao
    abstract fun seventyFiveLinksDao(): SeventyFiveLinksDao
    abstract fun seventySixLinksDao(): SeventySixLinksDao
    abstract fun seventySevenLinksDao(): SeventySevenLinksDao
    abstract fun seventyEightLinksDao(): SeventyEightLinksDao
    abstract fun seventyNineLinksDao(): SeventyNineLinksDao
    abstract fun eightyLinksDao(): EightyLinksDao
    abstract fun eightyOneLinksDao(): EightyOneLinksDao
    abstract fun eightyTwoLinksDao(): EightyTwoLinksDao
    abstract fun eightyThreeLinksDao(): EightyThreeLinksDao
    abstract fun eightyFourLinksDao(): EightyFourLinksDao
    abstract fun eightyFiveLinksDao(): EightyFiveLinksDao
    abstract fun eightySixLinksDao(): EightySixLinksDao
    abstract fun eightySevenLinksDao(): EightySevenLinksDao
    abstract fun eightyEightLinksDao(): EightyEightLinksDao
    abstract fun eightyNineLinksDao(): EightyNineLinksDao
    abstract fun ninetyLinksDao(): NinetyLinksDao
    abstract fun ninetyOneLinksDao(): NinetyOneLinksDao
    abstract fun ninetyTwoLinksDao(): NinetyTwoLinksDao
    abstract fun ninetyThreeLinksDao(): NinetyThreeLinksDao
    abstract fun ninetyFourLinksDao(): NinetyFourLinksDao
    abstract fun ninetyFiveLinksDao(): NinetyFiveLinksDao
    abstract fun ninetySixLinksDao(): NinetySixLinksDao
    abstract fun ninetySevenLinksDao(): NinetySevenLinksDao
    abstract fun ninetyEightLinksDao(): NinetyEightLinksDao
    abstract fun ninetyNineLinksDao(): NinetyNineLinksDao
    abstract fun hundredLinksDao(): HundredLinksDao



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