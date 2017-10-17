package com.game.tprecyclerview.recyclerview;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.game.tprecyclerview.R;
import com.game.tprecyclerview.Tweet;

/**
 * Created by bourdin on 07/10/17
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    private TextView pseudo, text;
    private ImageView avatar;
    private RecyclerViewClickListener clickListener;

    //itemView est la vue correspondante à une cellule
    public RecyclerViewHolder(View itemView, RecyclerViewClickListener clickListener) {
    //public RecyclerViewHolder(View itemView) {
        super(itemView);

        pseudo = (TextView) itemView.findViewById(R.id.pseudo);
        text = (TextView) itemView.findViewById(R.id.text);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);

        itemView.setOnClickListener(this);
        this.clickListener = clickListener;
    }

    //Fonction pour remplir la cellule en fonction d'un Tweet
    public void bind(final Tweet tweet){
        pseudo.setText(tweet.getPseudo());
        text.setText(tweet.getText());
        avatar.setImageDrawable(new ColorDrawable(tweet.getColor()));
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, getAdapterPosition());
    }

}
