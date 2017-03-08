package com.shelvin.study.java.lambdas;

/**
 * Created by shelvin on 12/10/16 at 21:17.
 */

public class StringCombiner
{
    private final String delim;
    private final String prefix;
    private final String suffix;
    private final StringBuilder stringBuilder;

    public StringCombiner(String delim, String prefix, String suffix)
    {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        stringBuilder = new StringBuilder();
    }

    public StringCombiner add(String component)
    {
        if (areAtStart())
        {
            stringBuilder.append(prefix);
        } else
        {
            stringBuilder.append(delim);
        }
        stringBuilder.append(component);
        return this;
    }

    public StringCombiner merge(StringCombiner other)
    {
        stringBuilder.append(other.stringBuilder);

        return this;
    }

    private boolean areAtStart()
    {
        return stringBuilder.length() == 0;
    }

    public String toString()
    {
        if (areAtStart())
        {
            stringBuilder.append(prefix);
        }
        stringBuilder.append(suffix);
        return stringBuilder.toString();
    }
}
