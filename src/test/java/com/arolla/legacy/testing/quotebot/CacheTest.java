package com.arolla.legacy.testing.quotebot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;

public class CacheTest {
    @Test
    void laSourceEstAppeléeUnePremièreFois() {
        //Arrange
        final MyBlogsProvider blogsProvider = new MyBlogsProvider();
        final CacheInstance cacheInstance = new MyCacheInstance();
        final AdSpace adSpace = new AdSpace(blogsProvider, cacheInstance);
        //Act
        adSpace.getAllBlogs();
        //Assert
        int nbAppelSource = blogsProvider.nbDeFois;
        Assertions.assertEquals(1, nbAppelSource);
    }

    @Test
    void laSourceEstAppeléeUneEtUneSeuleFois() {
        //Arrange
        final MyBlogsProvider blogsProvider = new MyBlogsProvider();
        final CacheInstance cacheInstance = new MyCacheInstance();
        final AdSpace adSpace = new AdSpace(blogsProvider, cacheInstance);
        //Act
        adSpace.getAllBlogs();
        adSpace.getAllBlogs();
        //Assert
        int nbAppelSource = blogsProvider.nbDeFois;
        Assertions.assertEquals(1, nbAppelSource);
    }

    private static class MyBlogsProvider implements BlogsProvider {
        int nbDeFois;

        @Override
        public Collection<String> getListAllBlogs() {
            nbDeFois++;
            return null;
        }
    }

    private static class MyCacheInstance implements CacheInstance {

        private HashMap<String, Collection<String>> stringCollectionHashMap = new HashMap<>();

        @Override
        public HashMap<String, Collection<String>> getCache() {
            return stringCollectionHashMap;
        }
    }
}
