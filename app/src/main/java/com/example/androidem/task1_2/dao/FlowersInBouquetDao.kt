package com.example.androidem.task1_2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidem.task1_2.entities.FlowersInBouquet

@Dao
interface FlowersInBouquetDao {
    @Insert
    suspend fun insert(flowersInBouquet: FlowersInBouquet)

    @Query("UPDATE flowers_in_bouquet SET quantity = :newQuantity WHERE bouquetId = :bouquetId AND flowerId = :flowerId AND :newQuantity > 0")
    suspend fun updateFlowerQuantity(bouquetId: Long, flowerId: Long, newQuantity: Int)

    @Delete
    suspend fun delete(flowersInBouquet: FlowersInBouquet)

    @Query("SELECT * FROM flowers_in_bouquet WHERE bouquetId = :bouquetId")
    suspend fun getFlowersForBouquet(bouquetId: Long): List<FlowersInBouquet>
}