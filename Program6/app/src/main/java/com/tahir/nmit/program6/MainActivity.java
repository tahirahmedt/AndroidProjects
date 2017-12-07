package com.tahir.nmit.program6;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.but2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i1 =new Intent();
                /*Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(i, 1);*/

                Intent i1 = new Intent();
                PendingIntent pi1 = PendingIntent.getActivity(MainActivity.this, 0, i1, 0);
                Notification notify = new Notification.Builder(MainActivity.this)
                        .setTicker("Ticket Title")
                        .setContentTitle("Notification!!")
                        .setContentText("This is Notification Example")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .addAction(R.mipmap.ic_launcher, "Action 1", pi1)
                        .addAction(R.mipmap.ic_launcher_round, "Action 2", pi1)
                        .setContentIntent(pi1).getNotification();
                notify.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0, notify);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(i, 1);
            }
        });
    }

    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        Cursor c = getContentResolver().query(uri,null,null,null,null);
        c.moveToFirst();
        int index = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        String no = c.getString(index);
        Toast.makeText(MainActivity.this,no,Toast.LENGTH_SHORT);
        TextView tv =findViewById(R.id.textview2);
        tv.setText(no);
    }
}
