package com.shelvin.study.java.lambdas;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by shelvin on 6/10/16 at 01:22.
 */

public class Artist
{
    private String name;
    private int age;
    private String place;
    private List<Artist> members;

    public Stream<Artist> getMembers()
    {
        return members.stream();
    }

    public boolean isSolo()
    {
        return members.isEmpty();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public boolean isFrom(String place)
    {
        if (place.equals(this.getPlace()))
        {
            return true;
        }
        return false;
    }
}
