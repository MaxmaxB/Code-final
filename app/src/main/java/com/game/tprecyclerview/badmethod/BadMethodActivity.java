package com.game.tprecyclerview.badmethod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.game.tprecyclerview.R;

//La méthode à ne pas faire
public class BadMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_method);
    }
}
