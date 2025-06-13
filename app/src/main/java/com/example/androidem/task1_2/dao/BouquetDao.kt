package com.example.androidem.task1_2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidem.task1_2.entities.Bouquet


@Dao
interface BouquetDao {
    @Insert
    suspend fun insert(bouquet: Bouquet): Long

    @Update
    suspend fun update(bouquet: Bouquet)

    @Delete
    suspend fun delete(bouquet: Bouquet)

    @Query("SELECT * FROM bouquets")
    suspend fun getAllBouquets(): List<Bouquet>

    @Query("SELECT * FROM bouquets WHERE id = :bouquetId")
    suspend fun getBouquetById(bouquetId: Long): Bouquet?
}