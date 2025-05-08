// In your package (e.g., com.example.t5)
package com.example.t5; // Replace with your package name

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String name;
    private String studentId;
    private int avatarResId; // Drawable resource ID for student's picture
    private String email;
    private String major;
    private String dateOfBirth;

    public Student(String name, String studentId, int avatarResId, String email, String major, String dateOfBirth) {
        this.name = name;
        this.studentId = studentId;
        this.avatarResId = avatarResId;
        this.email = email;
        this.major = major;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public int getAvatarResId() { return avatarResId; }
    public String getEmail() { return email; }
    public String getMajor() { return major; }
    public String getDateOfBirth() { return dateOfBirth; }

    // Parcelable implementation
    protected Student(Parcel in) {
        name = in.readString();
        studentId = in.readString();
        avatarResId = in.readInt();
        email = in.readString();
        major = in.readString();
        dateOfBirth = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(studentId);
        dest.writeInt(avatarResId);
        dest.writeString(email);
        dest.writeString(major);
        dest.writeString(dateOfBirth);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}