package com.perculacreative.testparcelableapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by peter on 8/19/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (getIntent().getParcelableExtra("A") == null) {
//            ArrayList<BObject> bList = new ArrayList<>();
//            bList.add(new BObject("int", new ParcelableInt(42)));
//            bList.add(new BObject("string", new ParcelableString("cheese")));
//
//            AObject aObject = new AObject(bList);
//
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.putExtra("A", aObject);
//            startActivity(intent);
//        } else {
//            AObject aObjectResult = getIntent().getParcelableExtra("A");
//            ((TextView) findViewById(R.id.text)).setText("It Worked!");
//        }

        if (getIntent().getParcelableExtra("PLANT") == null) {
            ArrayList<PlantProperty> properties = new ArrayList<>();
            properties.add(new PlantProperty("string", new ParcelableString("cheese")));
            properties.add(new PlantProperty("int", new ParcelableInt(42)));

            Plant plant = new Plant();
            plant.setProperties(properties);

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("PLANT", plant);
            startActivity(intent);
        } else {
            Plant plantResult = getIntent().getParcelableExtra("PLANT");
            ((TextView) findViewById(R.id.text)).setText("It Worked!");
        }
    }
}
