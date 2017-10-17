package com.game.tprecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.game.tprecyclerview.recyclerview.RecyclerViewActivity;
import com.game.tprecyclerview.badmethod.BadMethodActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scrollViewLinearLayoutButton, recyclerViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initViews();
    }

    private void initViews(){
        scrollViewLinearLayoutButton = (Button) findViewById(R.id.badMethodButton);
        recyclerViewButton = (Button) findViewById(R.id.recyclerViewButton);

        scrollViewLinearLayoutButton.setOnClickListener(this);
        recyclerViewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.badMethodButton :
                startActivity(new Intent(this, BadMethodActivity.class));
                break;
            case R.id.recyclerViewButton :
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            default:
                break;
        }
    }
}
