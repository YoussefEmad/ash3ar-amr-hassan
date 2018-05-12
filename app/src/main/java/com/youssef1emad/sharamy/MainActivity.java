package com.youssef1emad.sharamy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        String [] itme = getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.row_itme, R.id.txt_view, itme);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Webhtml.class);
                intent.putExtra("page",i);
                startActivity(intent);
            }
        });

    }

    public void img_share(View view) {
        String txtshare = "تطبيق اشعار عمرو حسن";
        String linkshare = "http://www.google.com";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare + "\n" + linkshare);
        startActivity(share);
        // to share this app to another apps

    }

    public void img_more(View view) {
        Intent moreApp = new Intent(Intent.ACTION_VIEW);
        moreApp.setData(Uri.parse("https://play.google.com/store?hl=en"));
        startActivity(moreApp);
    }

    public void img_email(View view) {
        try {
            String txt = " ألسلاام عليكم ورحمه الله وبركاته اقتراحى هو:";
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData(Uri.parse("mailto:"));
            sendemail.setType("message/rfc822");
            sendemail.putExtra(Intent.EXTRA_EMAIL, "youssef1emad@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT, "تطبيق اشعار عمرو حسن");
            sendemail.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(sendemail);
        }catch (Exception e){
            Toast.makeText(this, "عذرا لا يوجد تطبيق بريد", Toast.LENGTH_LONG).show();
        }
}

    public void img_close(View view) {
        finish();
    }
    }
