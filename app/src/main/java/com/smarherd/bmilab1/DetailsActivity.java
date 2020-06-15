package com.smarherd.bmilab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    private String bmi;
    private int range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView bmiTextView = findViewById(R.id.bmi_value);
        TextView rangeTextView = findViewById(R.id.bmi_range);
        TextView descriptionTextView = findViewById(R.id.range_description);

        range = getIntent().getIntExtra("range", 0);
        bmi = getIntent().getStringExtra("bmi");

        bmiTextView.setText(bmi);

        switch(range) {
            case 0:
                rangeTextView.setText(R.string.underweight);
                descriptionTextView.setText(R.string.underweight_description);
                break;

            case 1:
                rangeTextView.setText(R.string.normal_weight);
                descriptionTextView.setText(R.string.normal_weight_description);
                break;

            case 2:
                rangeTextView.setText(R.string.overweight);
                descriptionTextView.setText(R.string.overweight_description);
                break;

            case 3:
                rangeTextView.setText(R.string.obesity);
                descriptionTextView.setText(R.string.obesity_description);
                break;
        }


    }
}