package com.tahir.nmit.program5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendemail();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmessage();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchdailer();
            }
        });
    }

    protected void sendemail(){
        Intent i1 = new Intent(Intent.ACTION_SEND);
        i1.setData(Uri.parse("mailto:"));
        i1.setType("text/plain");
        i1.putExtra(Intent.EXTRA_EMAIL, new String[]{"tahirahmedt97@gmail.com"});
        i1.putExtra(Intent.EXTRA_SUBJECT,"Mail from Program 5 app");
        i1.putExtra(Intent.EXTRA_TEXT,"Sample text");
        startActivity(i1);
    }

    protected void launchdailer(){
        Intent i2 = new Intent(Intent.ACTION_DIAL);
        startActivity(i2);
    }

    protected void sendmessage(){
        Uri uri = Uri.parse("smsto:12346556");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "Here you can set the SMS text to be sent");
        startActivity(it);

        /*
        *
        *
        public void sendSMS(View v)
        {
            String number = "12346556";  // The number on which you want to send SMS
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
        }
        *
        * */

        Toast.makeText(MainActivity.this, "SMS sent", Toast.LENGTH_LONG).show();
    }
}
