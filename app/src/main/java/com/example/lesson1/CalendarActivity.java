package com.example.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class CalendarActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayoutcalendar);

        Button back = findViewById(R.id.backButtonCalendar);
        back.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(CalendarActivity.this, NextActivity.class);
                startActivity(intent);
            } catch (Exception ignore) {

            }
        });
    }
}
