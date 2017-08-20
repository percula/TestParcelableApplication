package com.perculacreative.testparcelableapplication

/**
 * Created by peter on 8/20/17.
 */

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by peter on 7/29/17.
 */
data class PlantingSchedule(val season: Season,
                            var sowIndoorsStart: Int? = null,
                            var sowIndoorsEnd: Int? = null,
                            var transplantStart: Int? = null,
                            var transplantEnd: Int? = null,
                            var sowOutdoorsStart: Int? = null,
                            var sowOutdoorsEnd: Int? = null) : Parcelable {
    enum class Season {SPRING, FALL }

    constructor(source: Parcel) : this(
            Season.values()[source.readInt()],
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(season.ordinal)
        writeValue(sowIndoorsStart)
        writeValue(sowIndoorsEnd)
        writeValue(transplantStart)
        writeValue(transplantEnd)
        writeValue(sowOutdoorsStart)
        writeValue(sowOutdoorsEnd)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<PlantingSchedule> = object : Parcelable.Creator<PlantingSchedule> {
            override fun createFromParcel(source: Parcel): PlantingSchedule = PlantingSchedule(source)
            override fun newArray(size: Int): Array<PlantingSchedule?> = arrayOfNulls(size)
        }
    }
}