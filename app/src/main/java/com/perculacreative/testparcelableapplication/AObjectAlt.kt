package com.perculacreative.testparcelableapplication

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by peter on 8/19/17.
 */

//@PaperParcel
data class AObjectAlt(var data: ArrayList<BObject>) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(BObject.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(data)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<AObjectAlt> = object : Parcelable.Creator<AObjectAlt> {
            override fun createFromParcel(source: Parcel): AObjectAlt = AObjectAlt(source)
            override fun newArray(size: Int): Array<AObjectAlt?> = arrayOfNulls(size)
        }
    }
}