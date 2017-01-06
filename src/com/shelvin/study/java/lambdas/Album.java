package com.shelvin.study.java.lambdas;

import java.util.List;

/**
 * Created by shelvin on 6/10/16 at 21:12.
 */

public class Album
{
    private String name;
    private List<Artist> singers;
    private List<Track> tracks;


    public Artist getMainMusicians()
    {
        return singers.get(0);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Artist> getSingers()
    {
        return singers;
    }

    public void setSingers(List<Artist> singers)
    {
        this.singers = singers;
    }

    public List<Track> getTracks()
    {
        return tracks;
    }

    public void setTracks(List<Track> tracks)
    {
        this.tracks = tracks;
    }
}
