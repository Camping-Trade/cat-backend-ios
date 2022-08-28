package com.example.cat.domain

class Location(
    val latitute: Double,
    val longitude: Double,
    val address: String? = null,
) {
    override fun toString(): String {
        return "Location(latitute=$latitute, longitude=$longitude, address=$address)"
    }
}
