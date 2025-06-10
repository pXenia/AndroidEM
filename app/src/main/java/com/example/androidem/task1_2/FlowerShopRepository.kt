package com.example.androidem.task1_2

import androidx.room.Transaction
import com.example.androidem.task1_2.dao.BouquetDao
import com.example.androidem.task1_2.dao.FlowerDao
import com.example.androidem.task1_2.dao.FlowersInBouquetDao
import com.example.androidem.task1_2.entities.Bouquet

class FlowerShopRepository(
    private val flowerDao: FlowerDao,
    private val bouquetDao: BouquetDao,
    private val flowersInBouquetDao: FlowersInBouquetDao
) {
    // получаем сколько букетов данного типа доступно
    suspend fun getAvailableNumberOfBouquets(bouquetId: Long): Int {
        val bouquet = flowersInBouquetDao.getFlowersForBouquet(bouquetId)
        if (bouquet.isEmpty()) return 0

        val availableCounts = mutableListOf<Int>()

        for (flower in bouquet) {
            val flower = flowerDao.getFlowerById(flower.flowerId) ?: return 0
            val maxPossible = flower.quantity / flower.quantity
            availableCounts.add(maxPossible)
        }

        return availableCounts.minOrNull() ?: 0
    }

    // возвращает тип букета и доступное количество
    suspend fun getAllBouquetsWithAvailability(): List<Pair<Bouquet, Int>> {
        val bouquets = bouquetDao.getAllBouquets()
        return bouquets.map { bouquet ->
            Pair(bouquet, getAvailableNumberOfBouquets(bouquet.id))
        }
    }

    // продажа букета
    @Transaction
    suspend fun saleBouquet(bouquetId: Long): Boolean {
        val bouquet = flowersInBouquetDao.getFlowersForBouquet(bouquetId)
        if (bouquet.isEmpty()) return false

        if (getAvailableNumberOfBouquets(bouquetId) < 1) return false

        return try {
            bouquet.forEach { flower ->
                flowerDao.reduceFlowerQuantity(
                    flower.flowerId,
                    flower.quantity
                )
            }
            true
        } catch (_: Exception) {
            false
        }
    }
}