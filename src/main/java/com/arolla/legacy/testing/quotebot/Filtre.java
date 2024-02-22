package com.arolla.legacy.testing.quotebot;

import java.util.Collection;
import java.util.stream.Collectors;

public class Filtre implements BlogsProvider{

    BlogsProvider blogsProvider;

    public Filtre(BlogsProvider blogsProvider) {
        this.blogsProvider = blogsProvider;
    }

    @Override
    public Collection<String> getListAllBlogs() {
        return blogsProvider.getListAllBlogs().stream()
                .filter(s-> s.startsWith("T"))
                .collect(Collectors.toList());
    }
}
