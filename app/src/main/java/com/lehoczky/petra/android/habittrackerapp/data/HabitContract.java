package com.lehoczky.petra.android.habittrackerapp.data;

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract() {
    }

    public final static class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "sport";

        public final static String COLUMN_HABIT_NAME = "activity";
        public final static String COLUMN_DATE_YEAR = "year";
        public final static String COLUMN_DATE_MONTH = "month";
        public final static String COLUMN_DATE_DAY = "day";
    }
}