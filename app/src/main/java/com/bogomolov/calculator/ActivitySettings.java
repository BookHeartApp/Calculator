package com.bogomolov.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitySettings extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

            Button color_theme = findViewById(R.id.switch_color_theme);
            color_theme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent runColorTheme = new Intent(ActivitySettings.this, MainActivity.class);
                    startActivity(runColorTheme);
                }
            });


            Button black_theme = findViewById(R.id.switch_black_theme);
            black_theme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent runColorTheme = new Intent(ActivitySettings.this, MainActivity_BT.class);
                    startActivity(runColorTheme);
                }
            });


            Button white_theme = findViewById(R.id.switch_white_theme);
            white_theme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent runColorTheme = new Intent(ActivitySettings.this, MainActivity_WT.class);
                    startActivity(runColorTheme);
                }
            });
    }
}
