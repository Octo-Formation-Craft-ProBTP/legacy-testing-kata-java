package com.arolla.legacy.testing.quotebot;

import java.util.Collection;

public class AdSpace implements BlogsProvider {

	//private static Map<String, Collection<String>> cache = new HashMap<String, Collection<String>>();
    // FIXME : only return blogs that start with a 'T'
    private BlogsProvider blogsProvider;
	private CacheInstance cacheInstance;

	public AdSpace() {
        blogsProvider = new BlogsProviderImpl();
		cacheInstance = new CacheInstanceImpl();
    }

	public AdSpace(BlogsProvider blogsProvider, CacheInstance cacheInstance) {
        this.blogsProvider = blogsProvider;
        this.cacheInstance = cacheInstance;
    }

	public static Collection<String> getAdSpaces() {
		return new AdSpace().getListAllBlogs();
	}

	public  Collection<String> getListAllBlogs() {
		if (cacheInstance.getCache().containsKey("blogs list")) {
			return cacheInstance.getCache().get("blogs list");
		}
        Collection<String> listAllBlogs = blogsProvider.getListAllBlogs();
		cacheInstance.getCache().put("blogs list", listAllBlogs);
		return listAllBlogs;
	}

}
