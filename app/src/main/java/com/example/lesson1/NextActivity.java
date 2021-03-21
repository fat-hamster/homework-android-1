package com.example.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class NextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayoutsecond);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(NextActivity.this, MainActivity.class);
                startActivity(intent);
            } catch (Exception ignore) {

            }
        });

        Button calendarButton = findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(NextActivity.this, CalendarActivity.class);
                startActivity(intent);
            } catch (Exception ignore) {

            }
        });
    }
}
