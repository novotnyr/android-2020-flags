package com.github.novotnyr.android.flags;

import java.util.Objects;

import androidx.annotation.DrawableRes;

public class Flag {
    private String country;
    @DrawableRes
    private int resource;

    public Flag(String country, @DrawableRes int resource) {
        this.country = country;
        this.resource = resource;
    }

    @DrawableRes
    public int getResource() {
        return resource;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flag flag = (Flag) o;
        return resource == flag.resource &&
                country.equals(flag.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, resource);
    }
}