package com.arolla.legacy.testing.quotebot;

import java.util.Collection;

public class BlogsProviderImpl implements BlogsProvider {
    @Override
    public Collection<String> getListAllBlogs() {
        return TechBlogs.listAllBlogs();
    }
}
