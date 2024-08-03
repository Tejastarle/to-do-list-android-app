package org.tejas.todolistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button buttonAddTask;
    private ListView listViewTasks;
    private ArrayAdapter<Task> TaskAdapter;
    private List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAddTask = findViewById(R.id.buttonAddTask);
        listViewTasks = findViewById(R.id.listViewTasks);

        tasks = new ArrayList<>();
        TaskAdapter taskAdapter = new TaskAdapter(this, tasks);
        listViewTasks.setAdapter(taskAdapter);

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskText = editTextTask.getText().toString();
                if (!taskText.isEmpty()) {
                    Task task = new Task(taskText, false);
                    tasks.add(task);
                    taskAdapter.notifyDataSetChanged();
                    editTextTask.setText("");
                }
            }
        });

        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = tasks.get(position);
                task.setDone(!task.isDone());
                taskAdapter.notifyDataSetChanged();
            }
        });
    }
}