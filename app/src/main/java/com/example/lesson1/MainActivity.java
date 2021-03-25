package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(v -> editText.setText(""));

        Button buttonNext = findViewById(R.id.next);
        buttonNext.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent); //finish(); // нужнен-ли здесь finish?
            } catch (Exception ignore) { // здесь наверное вот это?: ActivityNotFoundException

            }
        });
    }
    // обработка выхода из приложения
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
        
}
