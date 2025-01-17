package com.example.question3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String RESULT_KEY = "RESULT";

    private TextView inputText;
    private Button btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.no);

        btn = findViewById(R.id.calculate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputText.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
                    return;
                }

                int value = Integer.parseInt(input);
                if (value <= 0) {
                    Toast.makeText(MainActivity.this, "Please enter a positive number", Toast.LENGTH_LONG).show();
                    return;
                }

                long result = 1;
                for (int i = 1; i <= value; i++) {
                    result *= i;
                }
                Intent i = new Intent(MainActivity.this, Result.class);
                i.putExtra(RESULT_KEY, result);
                startActivity(i);

            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}