package com.example.androidem.task1_2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidem.task1_2.entities.Flower

@Dao
interface FlowerDao {
    @Insert
    suspend fun insert(flower: Flower): Long

    @Delete
    suspend fun delete(flower: Flower)

    @Query("SELECT * FROM flowers")
    suspend fun getAllFlowers(): List<Flower>

    @Query("SELECT * FROM flowers WHERE id = :flowerId")
    suspend fun getFlowerById(flowerId: Long): Flower?

    @Query("UPDATE flowers SET quantity = quantity - :amount WHERE id = :flowerId AND quantity >= :amount")
    suspend fun reduceFlowerQuantity(flowerId: Long, amount: Int): Int
}