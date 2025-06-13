package com.example.androidem.task1_2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets")
data class Bouquet(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val packaging: String
)