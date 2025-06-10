package com.example.androidem.task1_2.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    primaryKeys = ["bouquetId", "flowerId"],
    foreignKeys = [
        ForeignKey(entity = Bouquet::class, parentColumns = ["id"], childColumns = ["bouquetId"]),
        ForeignKey(entity = Flower::class, parentColumns = ["id"], childColumns = ["flowerId"])
    ],
    tableName = "flowers_in_bouquet"
)
data class FlowersInBouquet (
    val bouquetId: Long,
    val flowerId: Long,
    val quantity: Int
)