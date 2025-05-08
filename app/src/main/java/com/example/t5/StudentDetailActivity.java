// In your package (e.g., com.example.t5)
package com.example.t5; // Replace with your package name

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "com.example.t5.STUDENT_DETAIL";

    private ImageView detailImageViewAvatar;
    private TextView detailTextViewName;
    private TextView detailTextViewStudentId;
    private TextView detailTextViewEmail;
    private TextView detailTextViewMajor;
    private TextView detailTextViewDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        detailImageViewAvatar = findViewById(R.id.detailImageViewAvatar);
        detailTextViewName = findViewById(R.id.detailTextViewName);
        detailTextViewStudentId = findViewById(R.id.detailTextViewStudentId);
        detailTextViewEmail = findViewById(R.id.detailTextViewEmail);
        detailTextViewMajor = findViewById(R.id.detailTextViewMajor);
        detailTextViewDOB = findViewById(R.id.detailTextViewDOB);

        Student student = getIntent().getParcelableExtra(EXTRA_STUDENT);

        if (student != null) {
            setTitle("Student Details"); // Set activity title
            detailImageViewAvatar.setImageResource(student.getAvatarResId());
            detailTextViewName.setText("Name: " + student.getName());
            detailTextViewStudentId.setText("ID: " + student.getStudentId());
            detailTextViewEmail.setText("Email: " + student.getEmail());
            detailTextViewMajor.setText("Major: " + student.getMajor());
            detailTextViewDOB.setText("Date of Birth: " + student.getDateOfBirth());
        } else {
            setTitle("Error");
            detailTextViewName.setText("No student data found.");
        }
    }
}