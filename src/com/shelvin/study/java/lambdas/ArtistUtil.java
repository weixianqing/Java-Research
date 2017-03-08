package com.shelvin.study.java.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shelvin on 6/10/16 at 01:25.
 */

public class ArtistUtil
{
    static final String[] places = {"beijing", "shanghai", "hongkong", "boston", "newyork", "losangles", "berlin", "london", "aidingbao", "taian"};

    public static List<Artist> getArtists()
    {
        List<Artist> artists = new ArrayList<>();

        for (int i = 0; i < 20; i++)
        {
            Artist artist = new Artist();
            artist.setName("artist " + i);
            artist.setAge(i);
            Random random = new Random();
            int place = random.nextInt(10);
            artist.setPlace(places[place]);
            artists.add(artist);
        }

        return artists;
    }
}
