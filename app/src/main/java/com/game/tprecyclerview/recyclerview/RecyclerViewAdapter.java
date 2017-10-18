package com.game.tprecyclerview.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.game.tprecyclerview.R;
import com.game.tprecyclerview.Tweet;

import java.util.List;

/**
 * Created by bourdin on 07/10/17
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Tweet> list;
//    private RecyclerViewHolder.RecyclerViewClickListener clickListener;

    //Constructeur avec en parametre notre liste de Tweets
    public RecyclerViewAdapter(List<Tweet> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même occasion indiquer la vue à inflater (à partir des layout xml)
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_tweet,viewGroup,false);

        return new RecyclerViewHolder(view);
//        return new RecyclerViewHolder(view, clickListener);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque Tweet
    @Override
    public void onBindViewHolder(RecyclerViewHolder myViewHolder, int position) {
        Tweet tweet = list.get(position);
        myViewHolder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    public void setClickListener(RecyclerViewHolder.RecyclerViewClickListener clickListener){
//        this.clickListener = clickListener;
//    }

}
