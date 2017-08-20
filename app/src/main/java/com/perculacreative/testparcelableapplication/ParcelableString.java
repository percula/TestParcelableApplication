package com.perculacreative.testparcelableapplication;

import android.os.Parcel;
import android.os.Parcelable;

import paperparcel.PaperParcel;

/**
 * Created by peter on 8/19/17.
 */

public class ParcelableString implements Parcelable {

    String string;

    public ParcelableString(String string) {
        this.string = string;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.string);
    }

    protected ParcelableString(Parcel in) {
        this.string = in.readString();
    }

    public static final Parcelable.Creator<ParcelableString> CREATOR = new Parcelable.Creator<ParcelableString>() {
        @Override
        public ParcelableString createFromParcel(Parcel source) {
            return new ParcelableString(source);
        }

        @Override
        public ParcelableString[] newArray(int size) {
            return new ParcelableString[size];
        }
    };
}
