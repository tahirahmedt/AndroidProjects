package com.tahir.nmit.program2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ListView FlowerList;
    FlowerAdapter mAdapter;
    String a;
    String flower[] = {"Rose", "Jasmine", "lily", "tulips","lotus","Rose", "Jasmine", "lily", "tulips","lotus" };

    List<String> flowerlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Intent i2 = getIntent();
        //Bundle b = i2.getExtras();
        //a= b.getString(MainActivity.msg);
        Intent intent = getIntent();
        FlowerList = findViewById(R.id.listflower);

        for (String flowername: flower) {
            flowerlist.add(flowername);
        }

        mAdapter = new FlowerAdapter(SecondActivity.this, flowerlist);
        FlowerList.setAdapter(mAdapter);
    }
}
