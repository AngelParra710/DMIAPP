package com.example.dmi_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class foto extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE=1;
    ImageView img;
    Bitmap bitmap;
    CardView confirmar;
    int contador=0;
    int leucocito=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, REQUEST_IMAGE_CAPTURE);

        confirmar=findViewById(R.id.carConfirmar);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int width=img.getDrawable().getIntrinsicWidth();
                int height=img.getDrawable().getIntrinsicHeight();
                int pixel;
                int r;
                int g;
                int b;


                for (int i=0;i<height;i++){
                    for (int j=0;j<width;j++){

                        pixel=bitmap.getPixel(j,i);
                        r= Color.red(pixel);
                        g=Color.green(pixel);
                        b=Color.blue(pixel);
                        if (r>250&&r<255 && g>248&&g<252 && b>248&&b<253) {
                            leucocito=0;
                        }
                    }
                }
                sweetdialogsucces("Felicidades", "Continue cuidandose" );


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        img=findViewById(R.id.img);
        if (requestCode==REQUEST_IMAGE_CAPTURE &&resultCode == RESULT_OK) {
            Bundle extras=data.getExtras();
            bitmap= (Bitmap)extras.get("data");
            img.setImageBitmap(bitmap);
            String s="hola";
        }
    }

    public void sweetdialogsucces(String title, String Meesage){
        new SweetAlertDialog(foto.this,SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(title)
                .setContentText(Meesage)
                .setConfirmText("Aceptar")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .show();

    }
}
