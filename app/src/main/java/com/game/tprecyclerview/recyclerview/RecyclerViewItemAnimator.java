package com.game.tprecyclerview.recyclerview;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

/**
 * Created by bourdin on 09/10/17
 */

public class RecyclerViewItemAnimator extends SimpleItemAnimator {

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .rotationX(90)
                .setDuration(1000)
                .start();
        return false;
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .rotationX(360)
                .setDuration(1000)
                .start();
        return false;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
        return false;
    }

    @Override
    public void runPendingAnimations() {

    }

    @Override
    public void endAnimation(RecyclerView.ViewHolder item) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
