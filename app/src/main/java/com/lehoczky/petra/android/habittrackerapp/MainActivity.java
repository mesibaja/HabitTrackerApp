package com.lehoczky.petra.android.habittrackerapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lehoczky.petra.android.habittrackerapp.data.HabitContract.HabitEntry;
import com.lehoczky.petra.android.habittrackerapp.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private TextView mDatabaseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseTextView = (TextView) findViewById(R.id.database_textview);
        HabitDbHelper databaseHelper = new HabitDbHelper(this);

        addFirstHabitsToDatabase(databaseHelper);
        displayDatabaseContent(databaseHelper);
    }

    private void addFirstHabitsToDatabase(HabitDbHelper databaseHelper) {
        databaseHelper.insertHabit("Running", 2017, "July", 1);
        databaseHelper.insertHabit("Swimming", 2017, "July", 2);
        databaseHelper.insertHabit("Hiking", 2017, "July", 3);
    }

    private void displayDatabaseContent(HabitDbHelper databaseHelper) {
        Cursor cursor = databaseHelper.readAllHabits();
        int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
        int yearColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_DATE_YEAR);
        int monthColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_DATE_MONTH);
        int dayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_DATE_DAY);

        String habitDatabaseContent = "";
        cursor.moveToFirst();
        do {
            int id = cursor.getInt(idColumnIndex);
            String name = cursor.getString(nameColumnIndex);
            int year = cursor.getInt(yearColumnIndex);
            String month = cursor.getString(monthColumnIndex);
            int day = cursor.getInt(dayColumnIndex);
            habitDatabaseContent = habitDatabaseContent + id + " " + name + " " +
                    year + " " + month + " " + day + "\n";
        } while (cursor.moveToNext());

        mDatabaseTextView.setText(habitDatabaseContent);
    }
}
