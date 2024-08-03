package org.tejas.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;


    public class TaskAdapter extends ArrayAdapter<Task> {
        private Context context;
        private List<Task> tasks;

        public TaskAdapter(Context context, List<Task> tasks) {
            super(context, 0, tasks);
            this.context = context;
            this.tasks = tasks;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
            }

            Task task = tasks.get(position);
            TextView textViewTask = view.findViewById(R.id.textViewTask);
            textViewTask.setText(task.getText());

            CheckBox checkBoxDone = view.findViewById(R.id.checkBoxDone);
            checkBoxDone.setChecked(task.isDone());

            return view;
        }
    }



