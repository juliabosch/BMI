package com.smarherd.bmilab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //mode = 0 -> metric type
    //mode = 1 -> imoerial type
    private int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BMIViewModel mViewModel = new ViewModelProvider(this).get(BMIViewModel.class);
        mViewModel.mode = mode;

        final TextView bmiText = findViewById(R.id.bmi_text);
        final EditText heighText = findViewById(R.id.heighEditText);
        final EditText massText = findViewById(R.id.massEditText);
        Button countButton = findViewById(R.id.button);

        final BMICounter bmi = new BMICounter();

        countButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   String heighString = heighText.getText().toString();
                   String massString = massText.getText().toString();

                   double heigh = getDoubleValue(heighString);
                   double mass = getDoubleValue(massString);

                   String text = "ERROR: enter correct values for heigh and mass";
                   if (heigh != -1 && mass != -1) {
                       double result;
                       bmi.setHeight(heigh);
                       bmi.setMass(mass);

                       if (mode == 0) {
                           result = bmi.getMetricBMI();
                           //mViewModel.setBmi(bmi.getMetricBMI());
                           //double aux = mViewModel.bmi;
                           text = Double.toString(result);
                       } else {
                           result = bmi.getImperialBMI();
                           text = Double.toString(result);
                       }
                       mViewModel.bmi = result;
                       mViewModel.range = bmi.getRange();

                       switch(bmi.getRange()) {
                           case 0:
                               bmiText.setTextColor(Color.BLUE);
                               break;

                           case 1:
                               bmiText.setTextColor(Color.GREEN);
                               break;

                           case 2:
                               bmiText.setTextColor(Color.YELLOW);
                               break;

                           case 3:
                               bmiText.setTextColor(Color.RED);
                               break;
                       }
                   }
                   bmiText.setText(text);

               }
           });

        bmiText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivityForResult(intent, bmi.getRange());
            }
        });


    }

    public double getDoubleValue(String value) {
        double doubleValue = -1;
        if(!value.isEmpty() || !value.matches("")) {
            try
            {
                doubleValue = Double.parseDouble(value);
                // it means it is double
            } catch (Exception e1) {
                // this means it is not double
                e1.printStackTrace();
            }
        }
        return doubleValue;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView heighText = findViewById(R.id.heighText);
        TextView massText = findViewById(R.id.weigthText);

        switch (item.getItemId()) {
            case R.id.metric_type:
                mode = 0;
                heighText.setText(R.string.height_centimeters);
                massText.setText(R.string.weight_kg);
                return true;

            case R.id.imperial_type:
                mode = 1;
                heighText.setText(R.string.height_inches);
                massText.setText(R.string.weight_lbs);
                return true;

            case R.id.about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}