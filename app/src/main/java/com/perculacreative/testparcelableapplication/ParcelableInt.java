package com.perculacreative.testparcelableapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by peter on 8/19/17.
 */

public class ParcelableInt implements Parcelable {
    int integer;

    public ParcelableInt(int integer) {
        this.integer = integer;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.integer);
    }

    protected ParcelableInt(Parcel in) {
        this.integer = in.readInt();
    }

    public static final Parcelable.Creator<ParcelableInt> CREATOR = new Parcelable.Creator<ParcelableInt>() {
        @Override
        public ParcelableInt createFromParcel(Parcel source) {
            return new ParcelableInt(source);
        }

        @Override
        public ParcelableInt[] newArray(int size) {
            return new ParcelableInt[size];
        }
    };
}
