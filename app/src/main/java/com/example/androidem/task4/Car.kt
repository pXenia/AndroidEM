package com.example.androidem.task4


enum class CarColor {
    TRANSPARENT, WHITE, BLACK, SILVER
}

// Builder
class Car private constructor(
    val model: String,
    val color: CarColor,
    val year: Int
) {
    class Builder {
        private var model: String = "Unknown"
        private var color: CarColor = CarColor.TRANSPARENT
        private var year: Int = 2000

        fun setModel(model: String): Builder = apply { this.model = model }
        fun setColor(color: CarColor): Builder = apply { this.color = color }
        fun setYear(year: Int): Builder = apply { this.year = year }

        fun build(): Car {
            return Car(model, color, year)
        }
    }
}

// Abstract Factory
interface CarFactory {
    fun createRenaultLogan(): Car
    fun createSkodaOctavia(): Car
}

// пример, реализация 2х фабрик
class CarFactory1 : CarFactory {
    override fun createRenaultLogan() = Car.Builder()
        .setModel("Renault Logan")
        .setColor(CarColor.SILVER)
        .setYear(2014)
        .build()

    override fun createSkodaOctavia() = Car.Builder()
        .setModel("Skoda Octavia")
        .setColor(CarColor.BLACK)
        .setYear(2017)
        .build()
}

class CarFactory2 : CarFactory {
    override fun createRenaultLogan() = Car.Builder()
        .setModel("Renault Logan")
        .setColor(CarColor.WHITE)
        .setYear(2009)
        .build()

    override fun createSkodaOctavia() = Car.Builder()
        .setModel("Skoda Octavia")
        .setColor(CarColor.WHITE)
        .setYear(2017)
        .build()
}







