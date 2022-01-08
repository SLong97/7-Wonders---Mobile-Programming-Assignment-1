package com.example.thesevenwonders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class WonderActivity extends AppCompatActivity {


    TextView textWonder;
    Button textWonderName;
    TextView textWonderLocation;
    ImageView imageWonder;
    Button first,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonder);

        initViews();

        Intent intent = getIntent();
        String wonderName = intent.getStringExtra("wonderName");
        String wonderLocation = intent.getStringExtra("wonderLocation");
        String wonderImage = intent.getStringExtra("wonderImage");
        String wonderInfo = intent.getStringExtra("wonderInfo");
        String wonderCode = intent.getStringExtra("wonderCode");

        wonderName = "\uD83D\uDCCD" + wonderName;

        Wonder wonder = new Wonder(wonderName,wonderLocation,wonderImage,wonderInfo,wonderCode);

        setData(wonder);


        first = findViewById(R.id.button1);
        second = findViewById(R.id.button2);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new wonderFragment());
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new wonderFragment2());
            }
        });


        textWonderName = findViewById(R.id.textWonderName);
        textWonderName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/place/"+ wonderCode);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });



    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame1,fragment);
        fragmentTransaction.commit();

    }

    private void setData(Wonder wonder) {

        textWonder.setText(wonder.getWonderInformation());
        textWonderName.setText(wonder.getWonderName());
        textWonderLocation.setText(wonder.getWonderLocation());
        Glide.with(this)
                .asBitmap().load(wonder.getWonderImageURL())
                .into(imageWonder);


    }

    private void initViews() {

        textWonder = findViewById(R.id.textWonder);
        textWonderName = findViewById(R.id.textWonderName);
        textWonderLocation = findViewById(R.id.textWonderLocation);
        imageWonder = findViewById(R.id.imageWonder);

    }
}