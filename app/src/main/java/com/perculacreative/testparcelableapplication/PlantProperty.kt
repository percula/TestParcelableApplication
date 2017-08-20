package com.perculacreative.testparcelableapplication

/**
 * Created by peter on 8/20/17.
 */


import android.os.Parcel
import android.os.Parcelable
import paperparcel.PaperParcel

@PaperParcel
data class PlantProperty(var key: String, var value: Parcelable) : Parcelable {
//    constructor(key: String, string: String) : this(key, ParcelableString(string))
//    constructor(key: String, int: Int) : this(key, ParcelableInt(int))
//    constructor(key: String, double: Double) : this(key, ParcelableDouble(double))
//    constructor(key: String, float: Float) : this(key, ParcelableFloat(float))
//    constructor(key: String, boolean: Boolean) : this(key, ParcelableBoolean(boolean))

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelPlantProperty.writeToParcel(this, dest, flags)
    }

    companion object {
        @JvmField val CREATOR = PaperParcelPlantProperty.CREATOR
    }
//
//    fun <T> get(): T? {
//        if (value is ParcelablePrimitive<*>) {
//            try {
//                return (value as? ParcelablePrimitive<T>)?.getVal()
//            } catch (e: ClassCastException) {
//                return null
//            }
//        }
//        return null
//    }
}

//
//data class ParcelableInt(var int: Int) : ParcelablePrimitive<Int>(int) {
//    constructor(source: Parcel) : this(
//            source.readInt()
//    )
//
//    override fun describeContents() = 0
//
//    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
//        writeInt(int)
//    }
//
//    companion object {
//        @JvmField val CREATOR: Parcelable.Creator<ParcelableInt> = object : Parcelable.Creator<ParcelableInt> {
//            override fun createFromParcel(source: Parcel): ParcelableInt = ParcelableInt(source)
//            override fun newArray(size: Int): Array<ParcelableInt?> = arrayOfNulls(size)
//        }
//    }
//}
//
//data class ParcelableDouble(var double: Double) : ParcelablePrimitive<Double>(double) {
//    constructor(source: Parcel) : this(
//            source.readDouble()
//    )
//
//    override fun describeContents() = 0
//
//    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
//        writeDouble(double)
//    }
//
//    companion object {
//        @JvmField val CREATOR: Parcelable.Creator<ParcelableDouble> = object : Parcelable.Creator<ParcelableDouble> {
//            override fun createFromParcel(source: Parcel): ParcelableDouble = ParcelableDouble(source)
//            override fun newArray(size: Int): Array<ParcelableDouble?> = arrayOfNulls(size)
//        }
//    }
//}
//
//data class ParcelableFloat(var float: Float) : ParcelablePrimitive<Float>(float) {
//    constructor(source: Parcel) : this(
//            source.readFloat()
//    )
//
//    override fun describeContents() = 0
//
//    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
//        writeFloat(float)
//    }
//
//    companion object {
//        @JvmField val CREATOR: Parcelable.Creator<ParcelableFloat> = object : Parcelable.Creator<ParcelableFloat> {
//            override fun createFromParcel(source: Parcel): ParcelableFloat = ParcelableFloat(source)
//            override fun newArray(size: Int): Array<ParcelableFloat?> = arrayOfNulls(size)
//        }
//    }
//}
//
//data class ParcelableBoolean(var boolean: Boolean) : ParcelablePrimitive<Boolean>(boolean) {
//    constructor(source: Parcel) : this(
//            1 == source.readInt()
//    )
//
//    override fun describeContents() = 0
//
//    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
//        writeInt((if (boolean) 1 else 0))
//    }
//
//    companion object {
//        @JvmField val CREATOR: Parcelable.Creator<ParcelableBoolean> = object : Parcelable.Creator<ParcelableBoolean> {
//            override fun createFromParcel(source: Parcel): ParcelableBoolean = ParcelableBoolean(source)
//            override fun newArray(size: Int): Array<ParcelableBoolean?> = arrayOfNulls(size)
//        }
//    }
//}
