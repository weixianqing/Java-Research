package com.shelvin.study.java.lambdas;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * Created by shelvin on 6/10/16 at 01:24.
 */

public class LT
{
    public Set<String> findLongTrack(List<Album> albums)
    {
        Set<String> trackNames = new HashSet<>();

        for (Album album : albums)
        {
            for (Track track : album.getTracks())
            {
                if (track.getTime() > 60)
                {
                    trackNames.add(track.getName());
                }
            }
        }

        return trackNames;
    }

    public Set<String> findLongTracksRefactor1(List<Album> albums)
    {
        Set<String> trackNames = new HashSet<>();

        albums.stream().forEach(album -> album.getTracks().forEach(track ->
                {
                    if (track.getTime() > 60)
                    {
                        trackNames.add(track.getName());
                    }
                })
        );

        return trackNames;
    }

    public Set<String> findLongTracksRefactor2(List<Album> albums)
    {
        Set<String> trackNames = new HashSet<>();

        albums.stream().forEach(album -> album.getTracks().stream().filter(track -> track.getTime() > 60).map(Track::getName).forEach(trackNames::add));

        return trackNames;
    }

    public Set<String> findLongTracksRefactor3(List<Album> albums)
    {
        Set<String> trackNames = new HashSet<>();

        albums.stream().flatMap(album -> album.getTracks().stream()).filter(track -> track.getTime() > 60).map(Track::getName).forEach(trackNames::add);

        return trackNames;
    }

    public Set<String> findLongTrackRefactor4(List<Album> albums)
    {
        return albums.stream().flatMap(album -> album.getTracks().stream()).filter(track -> track.getTime() > 60).map(Track::getName).collect(Collectors.toSet());
    }

    public static void printTrackLengthStatistics(Album album)
    {
        IntSummaryStatistics trackLengthStatics = album.getTracks().stream().mapToInt(Track::getTime).summaryStatistics();
        System.out.println(trackLengthStatics.getAverage());
        System.out.println(trackLengthStatics.getMax());
        System.out.println(trackLengthStatics.getMin());
        System.out.println(trackLengthStatics.getSum());
    }

    public Optional<Artist> biggestGroup(Stream<Artist> artistStream)
    {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artistStream.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    public double averageNumberOfTracks(List<Album> list)
    {
        return list.stream().collect(Collectors.averagingInt(album -> album.getTracks().size()));
    }

    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists)
    {
        return artists.collect(Collectors.partitioningBy(artist -> artist.isSolo()));
    }

    public Map<Boolean, List<Artist>> bandsAndSoloMR(Stream<Artist> artists)
    {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums)
    {
        return albums.collect(Collectors.groupingBy(album -> album.getMainMusicians()));
    }

    public String formatArtist(List<Artist> artists)
    {
        return artists.stream().map(Artist::getName).collect(Collectors.joining(",", "[", "]"));
    }

    public Map<Artist, Integer> numOfAlbumOfArtist(Stream<Album> albums)
    {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusicians));
        Map<Artist, Integer> numberOfAlbum = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> artistListEntry : albumsByArtist.entrySet())
        {
            numberOfAlbum.put(artistListEntry.getKey(), artistListEntry.getValue().size());
        }

        return numberOfAlbum;
    }

    public Map<Artist, Long> numOfArtist(Stream<Album> albums)
    {
        return albums.collect(Collectors.groupingBy(Album::getMainMusicians, Collectors.counting()));
    }

    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums)
    {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusicians));
        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> artistListEntry : albumsByArtist.entrySet())
        {
            nameOfAlbums.put(artistListEntry.getKey(), artistListEntry.getValue().stream().map(Album::getName).collect(Collectors.toList()));
        }
        return nameOfAlbums;
    }

    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums)
    {
        return albums.collect(Collectors.groupingBy(Album::getMainMusicians, mapping(Album::getName, toList())));
    }

    public String prettyPrint(List<Artist> artists)
    {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Artist artist : artists)
        {
            if (stringBuilder.length() > 1)
            {
                stringBuilder.append(",");
            }

            stringBuilder.append(artist.getName());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String prettyPrintImpro1(List<Artist> artists)
    {
        StringBuffer stringBuffer = new StringBuffer("[");

        artists.stream().map(artist -> artist.getName()).forEach(name -> {
            if (stringBuffer.length() > 1)
            {
                stringBuffer.append(",");
            }

            stringBuffer.append(name);
        });

        stringBuffer.append("]");

        return stringBuffer.toString();
    }

    public String prettyPrintImpro2(List<Artist> artists)
    {
        StringBuilder stringBuilder = artists.stream().map(Artist::getName).reduce(new StringBuilder(), (builder, name) -> {
            if (builder.length() > 0)
            {
                builder.append(",");
            }

            builder.append(name);
            return builder;
        }, StringBuilder::append);

        stringBuilder.insert(0, "[");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String prettyPrintImpro3(List<Artist> artists)
    {
        StringCombiner stringCombiner = artists.stream().map(Artist::getName).reduce(new StringCombiner(",", "[", "]"), StringCombiner::add, StringCombiner::merge);
        return stringCombiner.toString();
    }
}
