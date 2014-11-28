package com.example.rbates.functionalandroid.optionexample.functional;

import com.example.rbates.functionalandroid.optionexample.Size;

import fj.data.Option;

public class DisplayImage {
    public final String file;
    private final Option<Size> size;
    public final String credit;
    public final String caption;

    public DisplayImage(String file, Option<Size> sizes, String credit, String caption) {
        this.file = file;
        this.size = sizes;
        this.credit = credit;
        this.caption = caption;
    }

    public Option<Size> getSize() {
        return size;
    }
}
