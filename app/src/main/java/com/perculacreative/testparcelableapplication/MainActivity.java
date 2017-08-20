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

    private static final String PAPER_PARCEL_KEY = "paper_parcel_key";
    private static final String ALT_KEY = "alt_key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if there are extras:
        if (getIntent().getParcelableExtra(PAPER_PARCEL_KEY) == null &&
                getIntent().getParcelableExtra(ALT_KEY) == null) {
            // Extras don't exist, this is the first time this activity has been run

            // Create data that will be contained in AObjects
            ArrayList<BObject> bList = new ArrayList<>();
            bList.add(new BObject("int", new ParcelableInt(42)));
            bList.add(new BObject("string", new ParcelableString("cheese")));

            // Create AObjects
            AObjectPaperParcel aObjectPaperParcel = new AObjectPaperParcel(bList);
            AObjectAlt aObjectAlt = new AObjectAlt(bList);

            // Send intent with extras to this activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(PAPER_PARCEL_KEY, aObjectPaperParcel); // Comment this line to see that alt works
            intent.putExtra(ALT_KEY, aObjectAlt);
            startActivity(intent);
        } else {
            // Extras exist, retrieve them

            // Retrieve PaperParcel extra
            AObjectPaperParcel result = getIntent().getParcelableExtra(PAPER_PARCEL_KEY);
            if (result != null) {
                ((TextView) findViewById(R.id.text)).setText("AObjectPaperParcel Worked!");
            }

            // Retrieve Alt extra
            AObjectAlt result2 = getIntent().getParcelableExtra(ALT_KEY);
            if (result2 != null) {
                ((TextView) findViewById(R.id.textAlt)).setText("AObjectAlt Worked!");
            }

        }
    }
}
