package javaexamples.cert.collections.sets;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Notes
// 1. Use a set when you don't want to allow duplicate entries. Beyond that, each Set offers its own functionality
//    - HashSet - stores its elements in a hash table (uses hashCode) - the most common set but you lose ordering - O(1)
//    - TreeSet - stores its elements in a sorted tree structure - O(log n) - Implements NavigableSet interface.
public class ImplementingSet<E> implements Set<E> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
