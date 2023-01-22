package com.example.prescript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class userInterface extends AppCompatActivity {

    private static int selectMed(int i) {
        switch (i) {
            case 0:
                return R.id.med0;
            case 1:
                return R.id.med1;
            case 2:
                return R.id.med2;
        }
        throw new RuntimeException();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.DISPLAY_NAME);
        TextView textView = (TextView) findViewById(R.id.displayName);
        textView.setText(text);

        List<TextView> medications = new ArrayList<>();

        int medCount = intent.getIntExtra(MainActivity.MEDICATION_COUNT, 0);
        int i;
        for (i = 0; i < medCount; i++) {
            String medName = intent.getStringExtra(MainActivity.MEDICATION_NAMES.get(i));
            String medTime = intent.getStringExtra(MainActivity.MEDICATION_TIMES.get(i));
            medications.add((TextView) findViewById(selectMed(i)));
            String setTo = medName + " (" + medTime + ")   ";
            medications.get(i).setText(setTo);
        }

        for (; i < MainActivity.UPPER_LIMIT_OF_MEDS_PER_PERSON; i++) {
            medications.add((TextView) findViewById(selectMed(i)));
            String setTo = "";
            medications.get(i).setText(setTo);
        }

    }
}