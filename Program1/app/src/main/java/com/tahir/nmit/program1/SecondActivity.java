package com.tahir.nmit.program1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView texts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        texts = findViewById(R.id.text);

        Intent i2 = new Intent(getIntent());
        Bundle b = i2.getExtras();
        Toast.makeText(this, "Inside Second Activity: " + b.getString(MainActivity.msg), Toast.LENGTH_SHORT).show();
    }
}
