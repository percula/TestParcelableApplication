package com.perculacreative.testparcelableapplication

import android.os.Parcel
import android.os.Parcelable
import paperparcel.PaperParcel
import java.util.*

/**
 * Created by peter on 8/19/17.
 */

@PaperParcel
data class AObjectPaperParcel(var data: ArrayList<BObject>) : Parcelable {

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelAObjectPaperParcel.writeToParcel(this, dest, flags)
    }

    companion object {
        @JvmField val CREATOR = PaperParcelAObjectPaperParcel.CREATOR
    }
}
