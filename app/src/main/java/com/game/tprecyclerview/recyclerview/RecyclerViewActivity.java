package com.game.tprecyclerview.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.game.tprecyclerview.R;
import com.game.tprecyclerview.Tweet;
import com.game.tprecyclerview.Tweets;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Tweet> tweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initButtons();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //On génére la liste de Tweets
        tweets = Tweets.generateTweets();

        //Nous créons un Adapter et on lui fournit notre liste de Tweets.
        //cet adapter servira à remplir notre recyclerview
        recyclerViewAdapter = new RecyclerViewAdapter(tweets);

        //On l'associe à notre RecyclerView
        recyclerView.setAdapter(recyclerViewAdapter);

        //On set un ClickListener à cet adapter
        recyclerViewAdapter.setClickListener(itemClickListener);

        //ItemDecoration
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //ItemAnimator
        recyclerView.setItemAnimator(new RecyclerViewItemAnimator());
    }

    //Ajout un élément à la recyclerView à l'index position
    public void addTweetAtPosition(Tweet tweet, int position) {
        tweets.add(position, tweet); // on insère le nouveau Tweet dans notre liste d'article lié à l'adapter
        recyclerViewAdapter.notifyItemInserted(position); // on notifie à l'adapter ce changement
    }

    //Supprimer un élément de la recyclerView à l'index position
    public void removeTweetAtPosition(int position) {
        try {
            tweets.remove(position); // on supprime le Tweet
            recyclerViewAdapter.notifyItemRemoved(position); // on notifie à l'adapter ce changement
        }catch (Exception e){}
    }

    private View.OnClickListener changeLayoutButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.linearLayoutButton:
                    //On change le LayoutManager afin que l'agencement des cellules soit de façon verticale, comme une ListView
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    break;
                case R.id.gridLayoutButton:
                    //On change le LayoutManager pour adapter en grille avec 2 cellules par ligne
                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                    break;
                case R.id.staggeredLayoutButton:
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                    break;
                case R.id.addTweetButton:
                    addTweetAtPosition(new Tweet(Color.GREEN, "Hello", "New Tweet"), 2);
                    break;
            }
        }
    };

    //On créé un événement de clic sur notre RecyclerView
    RecyclerViewHolder.RecyclerViewClickListener itemClickListener = new RecyclerViewHolder.RecyclerViewClickListener() {
        @Override
        public void onClick(View view, int position) {
            Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_SHORT).show();

            //Méthode à compléter
            removeTweetAtPosition(position);
        }
    };

    private void initButtons(){
        Button linearayoutButton, gridLayoutButton, staggeredLayoutButton, addTweetButton;

        linearayoutButton = (Button) findViewById(R.id.linearLayoutButton);
        gridLayoutButton = (Button) findViewById(R.id.gridLayoutButton);
        staggeredLayoutButton = (Button) findViewById(R.id.staggeredLayoutButton);
        addTweetButton = (Button) findViewById(R.id.addTweetButton);

        linearayoutButton.setOnClickListener(changeLayoutButtonListener);
        gridLayoutButton.setOnClickListener(changeLayoutButtonListener);
        staggeredLayoutButton.setOnClickListener(changeLayoutButtonListener);
        addTweetButton.setOnClickListener(changeLayoutButtonListener);
    }
}
