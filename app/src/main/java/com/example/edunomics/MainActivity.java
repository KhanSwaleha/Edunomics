package com.example.edunomics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actv;
    Button TryOurAlphabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList <String> stringList = new ArrayList<String>();
        stringList.add("Apple");
        stringList.add("React");
        stringList.add("Microsoft");
        stringList.add("Google");
        stringList.add("Node");
        stringList.add("Php");

        actv = findViewById(R.id.autoCompleteTextView);
        TryOurAlphabtn = findViewById(R.id.TryOurAlphabtn);

        AutoSuggestAdapter adapter = new AutoSuggestAdapter(this, android.R.layout.simple_list_item_1, stringList);

        actv.setAdapter(adapter);
        actv.setThreshold(1);

        TryOurAlphabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
