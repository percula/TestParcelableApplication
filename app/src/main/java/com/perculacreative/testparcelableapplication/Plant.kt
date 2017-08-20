package com.perculacreative.testparcelableapplication

/**
 * Created by peter on 8/20/17.
 */


import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * This simple object represents a plant varietyName and contains all it's attributes.
 */
//@PaperParcel
data class Plant(var description: String = "",
                 var properties: ArrayList<PlantProperty> = ArrayList<PlantProperty>()) : PlantMetaData(), Parcelable {
    fun setPlantProperty(plantProperty: PlantProperty) {
        for ((index, property) in properties.withIndex()) {
            if (property.key == plantProperty.key) {
                properties[index] = plantProperty
                return
            }
        }
        properties.add(plantProperty)
    }

    fun getPlantProperty(key: String): PlantProperty? {
        return properties.firstOrNull { it.key == key }
    }

    fun <T> getPlantPropertyValue(key: String): T? {
//        return getPlantProperty(key)?.get() //TODO: FIX
        return null
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.createTypedArrayList(PlantProperty.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(description)
        writeTypedList(properties)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Plant> = object : Parcelable.Creator<Plant> {
            override fun createFromParcel(source: Parcel): Plant = Plant(source)
            override fun newArray(size: Int): Array<Plant?> = arrayOfNulls(size)
        }
    }
}

object PlantProperties {
    const val WHEN = "when"

    const val SUN = "sun"
    enum class Sun {FULL, PART, SHADE}

    const val PH = "ph"
    enum class Ph {VERY_ACIDIC, ACIDIC, SLIGHTLY_ACIDIC, NEUTRAL, SLIGHTLY_BASIC, BASIC, VERY_BASIC }

    const val PLANTING_CONSIDERATIONS = "considerations"
    const val GROW_FROM_SEED = "grow_from_seed"
    const val TRANSPLANTING = "transplanting"
    const val WATERING = "watering"
    const val FEEDING = "feeding"
    const val OTHER_CARE = "other_care"
    const val DISEASES = "disesases" // TODO: Make list
    const val PESTS = "pests" // TODO: Make list
    const val HARVESTING = "harvesting"
    const val STORAGE = "storage"
}
