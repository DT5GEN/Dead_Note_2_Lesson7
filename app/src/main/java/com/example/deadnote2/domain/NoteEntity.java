package com.example.deadnote2.domain;

import android.os.Parcel;
import android.os.Parcelable;

//POJO
public class NoteEntity implements Parcelable {
    private String id;
    private int color;
    private String headingText;
    private String storyOfTheMurderText;


    public NoteEntity(String id, int color) {
        this.id = id;
        this.color = color;
    }


    protected NoteEntity(Parcel in) {
        id = in.readString();
        color = in.readInt();
        headingText = in.readString();
        storyOfTheMurderText = in.readString();
    }

    public static final Creator<NoteEntity> CREATOR = new Creator<NoteEntity>() {
        @Override
        public NoteEntity createFromParcel(Parcel in) {
            return new NoteEntity(in);
        }

        @Override
        public NoteEntity[] newArray(int size) {
            return new NoteEntity[size];
        }
    };

    public NoteEntity(String id, String toString) {
    }

    public NoteEntity() {

    }

    public String getId() {
        return id;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getHexString() {
        return Integer.toHexString(color);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeInt(color);
        parcel.writeString(headingText);
        parcel.writeString(storyOfTheMurderText);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }
}
