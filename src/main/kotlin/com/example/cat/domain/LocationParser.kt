package com.example.cat.domain

import org.springframework.stereotype.Component

@Component
class LocationParser {
    companion object{
        fun toString(location: Location): String {
            return if (location.address != null) "${location.latitute}:${location.longitude}:${location.address}"
            else "${location.latitute}:${location.longitude}"
        }

        fun parse(location: String): Location {
            val parsingPart = location.split(":")
            return Location(
                latitute = parsingPart[0].toDouble(),
                longitude = parsingPart[1].toDouble(),
                address = when (parsingPart.size) {
                    3 -> parsingPart[2]
                    else -> null
                }
            )
        }
    }
}

