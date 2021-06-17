package com.bogomolov.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Life Cycle";
    private CalculatorModel calculator;
    private TextView table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_table);

        if (savedInstanceState == null) {
            makeToast("Первый запуск - onCreat()");
        }
        else {
            makeToast("Повторный запуск - onCreat()");
        }

        int [] numbersId = new int[] {
          R.id.button_0,
          R.id.button_1,
          R.id.button_2,
          R.id.button_3,
          R.id.button_4,
          R.id.button_5,
          R.id.button_6,
          R.id.button_7,
          R.id.button_8,
          R.id.button_9,
        };

        int[] actionsId = new int[] {
          R.id.button_plus,
          R.id.button_minus,
          R.id.button_multiplication,
          R.id.button_division,
          R.id.button_result,
          R.id.button_ac,
        };

        table = findViewById(R.id.table);


        calculator = new CalculatorModel();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              calculator.onNumberPressed(v.getId());
              table.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionPressed(v.getId());
                table.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numbersId.length; i++){
            findViewById(numbersId[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < actionsId.length; i++){
            findViewById(actionsId[i]).setOnClickListener(actionButtonClickListener);
        }

        Button button_setting = findViewById(R.id.button_setting);
        button_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runSettings = new Intent(MainActivity.this, ActivitySettings.class);
                startActivity(runSettings);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart()");
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        makeToast("onSaveInstanceState()");
    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        makeToast("Повторный запуск - onRestoreInstanceState()");
    }

    private void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT) .show();
        Log.d(TAG, message);
    }

}
