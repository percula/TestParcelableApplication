package com.perculacreative.testparcelableapplication

import android.os.Parcel
import android.os.Parcelable
import paperparcel.PaperParcel

/**
 * Created by peter on 8/19/17.
 */

@PaperParcel
data class BObject(var key: String, var value: Parcelable) : Parcelable {

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelBObject.writeToParcel(this, dest, flags)
    }

    companion object {
        @JvmField val CREATOR = PaperParcelBObject.CREATOR
    }
}
