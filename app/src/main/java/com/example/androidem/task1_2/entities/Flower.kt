package com.example.androidem.task1_2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flowers")
data class Flower(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val color: String,
    val quantity: Int,
    val country: String
)
