package com.perculacreative.testparcelableapplication

/**
 * Created by peter on 8/20/17.
 */

import android.os.Parcel
import android.os.Parcelable
import paperparcel.PaperParcel
import java.util.*

/**
 * MetaData for a Plant Object
 */
@PaperParcel
open class PlantMetaData(
        var key: String? = null,
        var shareType: ShareType = PlantMetaData.ShareType.PUBLIC,
        var parentName: String = "",
        var parentKey: String? = null,
        var varietyName: String = "",
        var categories: MutableList<String> = ArrayList<String>(),
        var compatible: MutableList<String> = ArrayList<String>(),
        var combative: MutableList<String> = ArrayList<String>(),
        var spacing: Double = 1.0,
        var plantingSchedules: MutableList<PlantingSchedule> = ArrayList<PlantingSchedule>(),
        var metaDataProperties: MutableList<PlantProperty> = ArrayList<PlantProperty>(),
        var iconFileName: String? = null,
        var imageFileName: String? = null,
        var creationDate: Date = Date()) : Parcelable, Comparable<PlantMetaData> {
    constructor(plant: Plant) :
            this(plant.key,
                    plant.shareType,
                    plant.parentName,
                    plant.parentKey,
                    plant.varietyName,
                    plant.categories,
                    plant.compatible,
                    plant.combative,
                    plant.spacing,
                    plant.plantingSchedules,
                    plant.metaDataProperties,
                    plant.iconFileName,
                    plant.imageFileName,
                    plant.creationDate)

    enum class ShareType {PUBLIC, SHARED, PRIVATE }

    override fun compareTo(other: PlantMetaData): Int {
        return this.parentName.compareTo(other.parentName)
    }

    /**
     * Determines if the plants are combative
     * @param other Plant to check against
     * *
     * @return True if they are combative, false otherwise
     */
    fun isCombative(other: PlantMetaData): Boolean {
        val thisPlantName = this.parentName.toLowerCase()
        val otherPlantName = other.parentName.toLowerCase()

        return this.combative.contains(otherPlantName) || other.combative.contains(thisPlantName)
    }

    /**
     * Determines if the plants are compatible
     * @param other Plant to check against
     * *
     * @return True if they are compatible, false otherwise (does not necessarily mean they are
     * * combative, just that they aren't especially compatible)
     */
    fun isCompatible(other: PlantMetaData): Boolean {
        val thisPlantName = this.parentName.toLowerCase()
        val otherPlantName = other.parentName.toLowerCase()

        return this.compatible.contains(otherPlantName) || other.compatible.contains(thisPlantName)
    }

    fun setPlantingSchedule(schedule: PlantingSchedule) {
        for ((index, property) in plantingSchedules.withIndex()) {
            if (property.season == schedule.season) {
                plantingSchedules[index] = schedule
                return
            }
        }
        plantingSchedules.add(schedule)
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelPlantMetaData.writeToParcel(this, dest, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelPlantMetaData.CREATOR
    }

}