package com.example.dmi_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {
    CardView face, internet, fotografia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        face=findViewById(R.id.cFace);
        internet=findViewById(R.id.cardInternet);
        fotografia=findViewById(R.id.cardFoto);
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/Tecsag-Soft-1680758471959389/"));
                startActivity(intent);
            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("android.intent.action.VIEW", Uri.parse("https://tecsag-soft18.wixsite.com/website"));
                startActivity(intent);
            }
        });
        fotografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),foto.class );
                startActivity(intent);
            }
        });
    }
}
