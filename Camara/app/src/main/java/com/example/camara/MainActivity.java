package com.example.camara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button boton_camara;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton_camara= findViewById(R.id.CAPTURAR);
        imagen= findViewById(R.id.imageView);

        boton_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirCamara();


            }
        });
    }
    private  void abrirCamara(){
        Intent intet = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // if (intet.resolveActivity(getPackageManager()) !=null){
        startActivityForResult(intet, 1);
        //  }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imBitmap);
        }
    }
}


