package com.example.storingdara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.example.storingdara", Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("storedAge", 0);

        if (storedAge == 0){
            textView.setText("Your age : ");
        }else {
            textView.setText("Your age : " + storedAge);
        }

    }

    public void button(View view){

        if(!editTextNumber.getText().toString().matches("")){
            int ageText = Integer.parseInt(editTextNumber.getText().toString());
            textView.setText("Your age : "+ ageText);

            sharedPreferences.edit().putInt("storedAge", ageText).apply();


        }
    }

    public void delete(View view){
        int ageText = Integer.parseInt(editTextNumber.getText().toString());
        if (ageText != 0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your age : ");
        }

    }




}