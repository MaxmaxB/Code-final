package com.game.tprecyclerview;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bourdin on 07/10/17
 */
//Classe pour gérer les Tweets
public class Tweets {
    private static String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    private static int[] colors = new int[]{
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW
    };

    private static int getRandomColor(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(colors.length);
        return colors[randomIndex];
    }

    public static List<Tweet> generateTweets(){
        List<Tweet> tweets = new ArrayList<Tweet>();

        for(int i = 0 ; i < prenoms.length; i++)
            tweets.add(new Tweet(getRandomColor(), prenoms[i], "Tweet " + i));

        return tweets;
    }

    public static List<Tweet> generateBigTweets(){
        List<Tweet> tweets = new ArrayList<Tweet>();

        for(int i = 0 ; i < 2000; i++)
            tweets.add(new Tweet(getRandomColor(), "Salut !", "ca va ? " + i));

        return tweets;
    }
}
