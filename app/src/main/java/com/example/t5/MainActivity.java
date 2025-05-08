package com.example.t5; // Replace with your package name

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView studentListView;
    List<Student> students; // Use a List of Student objects

    // Sample avatar drawables (make sure you have these in res/drawable)
    // You can reuse your ic1, ic2, etc., or create new ones.
    // For simplicity, I'm using the existing ones.
    int[] avatars = {
            R.drawable.ic1,
            R.drawable.ic2,
            R.drawable.ic3,
            R.drawable.ic4,
            R.drawable.ic5,
            R.drawable.ic6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Assuming activity_main.xml has your ListView

        studentListView = findViewById(R.id.androidVersionsList); // Keep your ListView ID or change it

        // Initialize student data
        students = new ArrayList<>();
        students.add(new Student("Nguyen Duy Phuc", "21200331", avatars[0], "21200331@student.hcmus.edu.vn", "Electronics and Telecommunications", "30/09/2003"));
        students.add(new Student("Tran Van Tien", "21180023", avatars[1], "21180023@student.hcmus.edu.vn", "Physical", "22/07/2003"));
        students.add(new Student("Le Thu Van", "22001013", avatars[2], "22001013@student.hcmus.edu.vn", "Information Technology", "10/11/2004"));
        students.add(new Student("Tran Hung Dao", "21801234", avatars[3], "21801234@student.hcmus.edu.vn", "Data Science", "05/01/2003"));
        students.add(new Student("Nguyen Thi Ha", "21180234", avatars[4], "21180234@student.hcmus.edu.vn", "Biology", "30/09/2003"));
        students.add(new Student("Nguyen Quang Tuan", "21160204", avatars[5], "21160204@student.hcmus.edu.vn", "Chemistry", "12/06/2003"));


        StudentListAdapter adapter = new StudentListAdapter(this, students);
        studentListView.setAdapter(adapter);

        // Set item click listener
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student selectedStudent = students.get(position);

                Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
                intent.putExtra(StudentDetailActivity.EXTRA_STUDENT, selectedStudent);
                startActivity(intent);
            }
        });
    }

    // Renamed and modified CustomListAdapter to StudentListAdapter
    class StudentListAdapter extends ArrayAdapter<Student> {

        Context context;
        List<Student> studentList; // Use List<Student>
        LayoutInflater inflater;

        // Constructor now takes List<Student>
        StudentListAdapter(Context context, List<Student> studentList) {
            super(context, R.layout.student_list_item, studentList); // Use student_list_item.xml
            this.context = context;
            this.studentList = studentList;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.student_list_item, parent, false); // Use student_list_item.xml
                viewHolder = new ViewHolder();
                viewHolder.avatarView = convertView.findViewById(R.id.imageViewAvatar);
                viewHolder.nameText = convertView.findViewById(R.id.textViewStudentName);
                viewHolder.idText = convertView.findViewById(R.id.textViewStudentId);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Student currentStudent = studentList.get(position);

            viewHolder.avatarView.setImageResource(currentStudent.getAvatarResId());
            viewHolder.nameText.setText(currentStudent.getName());
            viewHolder.idText.setText("ID: " + currentStudent.getStudentId());

            return convertView;
        }

        // ViewHolder for student list item
        private class ViewHolder {
            ImageView avatarView;
            TextView nameText;
            TextView idText;
        }
    }
}