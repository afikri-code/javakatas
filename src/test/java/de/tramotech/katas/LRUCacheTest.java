package de.tramotech.katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    @Test
    void lruCache() {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertThat(lruCache.get(1)).isEqualTo(1);       // returns 1
        lruCache.put(3, 3);    // evicts key 2
        assertThat((lruCache.get(2))).isEqualTo(-1);       // returns -1 (not found)
        assertThat(lruCache.get(3)).isEqualTo(3);       // returns 3
        lruCache.put(4, 4);    // evicts key 1

        assertThat((lruCache.get(1))).isEqualTo(-1);       // returns -1 (not found)
        assertThat((lruCache.get(3))).isEqualTo(3);       // returns 3
        assertThat((lruCache.get(4))).isEqualTo(4);       // returns 4
    }

}