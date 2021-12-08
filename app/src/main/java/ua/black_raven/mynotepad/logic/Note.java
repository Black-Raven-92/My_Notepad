package ua.black_raven.mynotepad.logic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Note implements Parcelable {
    private String title;
    private String date;
    private String text;
    private boolean chek;
    private int priority;
    private int id;


    public Note(int id, String title, String date, String text, boolean chek, int priority) {
        this.title = title;
        this.id = id;
        this.date = date;
        this.text = text;
        this.chek = chek;
        this.priority = priority;
    }

    protected Note(Parcel in) {
        title = in.readString();
        date = in.readString();
        text = in.readString();
        chek = in.readByte() != 0;
        priority = in.readInt();
        id = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isChek() {
        return chek;
    }

    public int getPriority() {
        return priority;
    }

    public String showNote() {
        return this.title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(text);
        dest.writeByte((byte) (chek ? 1 : 0));
        dest.writeInt(priority);
        dest.writeInt(id);
    }
}
