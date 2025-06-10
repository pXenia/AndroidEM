package com.example.androidem.task1_2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidem.task1_2.dao.BouquetDao
import com.example.androidem.task1_2.dao.FlowerDao
import com.example.androidem.task1_2.dao.FlowersInBouquetDao
import com.example.androidem.task1_2.entities.Bouquet
import com.example.androidem.task1_2.entities.Flower
import com.example.androidem.task1_2.entities.FlowersInBouquet

@Database(
    entities = [Bouquet::class, Flower::class, FlowersInBouquet::class],
    version = 2,
    exportSchema = false
)
abstract class FlowerShopDatabase : RoomDatabase() {
    abstract fun bouquetDao(): BouquetDao
    abstract fun flowerDao(): FlowerDao
    abstract fun flowersInBouquetDao(): FlowersInBouquetDao

    companion object {
        @Volatile
        private var INSTANCE: FlowerShopDatabase? = null

        fun getInstance(context: Context): FlowerShopDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlowerShopDatabase::class.java,
                    "flower_shop_database"
                )
                    .addMigrations(MIGRATION_1_2)
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            db.execSQL("""
                                CREATE TRIGGER check_flower_quantity_before_update
                                BEFORE UPDATE ON flowers
                                WHEN NEW.quantity < 0
                                BEGIN
                                    SELECT RAISE(ABORT, 'Quantity cannot be negative');
                                END;
                            """)
                            db.execSQL("""
                                CREATE TRIGGER check_flowers_in_bouquet_quantity
                                BEFORE INSERT ON flowers_in_bouquet
                                WHEN NEW.quantity < 1
                                BEGIN
                                    SELECT RAISE(ABORT, 'Quantity of flowers in bouquet cannot be negative or 0');
                                END;
                            """)
                        }
                    })
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE flowers ADD COLUMN country TEXT NOT NULL DEFAULT 'Unknown'")
        database.execSQL("ALTER TABLE bouquets ADD COLUMN packaging TEXT NOT NULL DEFAULT 'Unknown'")
    }
}