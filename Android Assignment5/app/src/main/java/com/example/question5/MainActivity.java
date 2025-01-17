package com.example.question5;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView input1, input2;
    private Button add,sub,multi,div;
    String t1,t2;
    int num1, num2,result;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        add = findViewById(R.id.Add);
        sub = findViewById(R.id.Sub);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.division);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult("+");
            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult("-");
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult("*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult("/");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void showResult(String symbol){
        t1 = input1.getText().toString().trim();
        t2 = input2.getText().toString().trim();
        num1 = Integer.parseInt(input1.getText().toString().trim());
        num2 = Integer.parseInt(input2.getText().toString().trim());
        if (num1<=0&& num2<=0){
            Toast.makeText(MainActivity.this,"Please enter Positive number",Toast.LENGTH_LONG).show();
        }
        switch (symbol){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result =num1/num2;
                break;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("The Result of Expression");
        builder.setMessage("The Result of  "+num1 + symbol+ num2+"  is  "+result);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }


}