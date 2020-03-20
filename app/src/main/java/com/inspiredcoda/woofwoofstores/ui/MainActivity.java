package com.inspiredcoda.woofwoofstores.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inspiredcoda.woofwoofstores.Home;
import com.inspiredcoda.woofwoofstores.R;

public class MainActivity extends AppCompatActivity {


    TextView woofText, storeText;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.dog_face);
        woofText = findViewById(R.id.woof_woof_txt);
        storeText = findViewById(R.id.stores_txt);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Home.class);
                Pair[] pairs = new Pair[3];

                pairs[0] = new Pair<View, String>(logo, "logo_trans");
                pairs[1] = new Pair<View, String>(woofText, "woof_trans");
                pairs[2] = new Pair<View, String>(storeText, "stores_trans");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                    MainActivity.this.finish();
                }else{
                    startActivity(intent);
                }
            }
        }, 3000);

    }
}
