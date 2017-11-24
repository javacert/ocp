package javaexamples.cert.collections.maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ImplementingMap<K, V> implements Map<K, V> {

    // Returns the number of entries (key/pair values) in the map
    @Override
    public int size() {
        return 0;
    }

    // Returns whether the map is empty
    @Override
    public boolean isEmpty() {
        return false;
    }

    // Returns whether a key exists in the map
    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    // Returns whether a value exists in the map
    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    // Returns the value mapped by key or null if none is mapped
    @Override
    public V get(Object key) {
        return null;
    }

    // Adds or replaces key/value pair. Returns previous value or null
    @Override
    public V put(K key, V value) {
        return null;
    }

    // Removes and returns value mapped to key. Returns null if none.
    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    // Returns a set of all keys
    @Override
    public Set<K> keySet() {
        return null;
    }

    // Returns a collection of all values
    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
