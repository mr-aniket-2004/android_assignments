package com.example.question2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    Button button ,btn ;
    EditText dateinput;
    int aday,amonth,ayear;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.datepicker);
        button = findViewById(R.id.btnsubmit);
        btn = findViewById(R.id.getDate);
        dateinput = findViewById(R.id.dateinput);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day , month, year;
                day = String.valueOf(datePicker.getDayOfMonth());
                month = String.valueOf(datePicker.getMonth()+1);
                year = String.valueOf(datePicker.getYear());
                Toast.makeText(MainActivity.this, "The date Selected - "+day +"/" +month+"/"+year,Toast.LENGTH_LONG).show();

            }
        });

        dateinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = dateinput.getText().toString().trim();
               Toast.makeText(MainActivity.this,"The selected Date -"+date,Toast.LENGTH_LONG).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void selectDate() {

        final Calendar calendar = Calendar.getInstance();
        ayear = calendar.get(Calendar.YEAR);
        amonth = calendar.get(Calendar.MONDAY);
        aday = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateinput.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }

        },ayear,amonth,aday);
        datePickerDialog.show();



    }
}