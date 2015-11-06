package com.shelvin.java.concurrent;

import org.w3c.dom.events.MutationEvent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shelvin on 2015/11/6.
 */
public class MonitorVehicleTracker
{
    private Map<String,MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations)
    {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String,MutablePoint> getLocations()
    {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id)
    {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id,int x,int y)
    {
        MutablePoint loc = locations.get(id);
        if (loc == null)
        {
            throw new IllegalArgumentException("no such id "+id);
        }

        loc.x = x;
        loc.y = y;
    }

    private static Map<String,MutablePoint> deepCopy(Map<String,MutablePoint> m)
    {
        Map<String,MutablePoint> result = new HashMap<String, MutablePoint>();
        for (String id : m.keySet())
        {
            result.put(id,new MutablePoint(m.get(id)));
        }

        return Collections.unmodifiableMap(result);
    }
}
