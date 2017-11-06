package javaexamples.cert.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

// Notes
// 1. Queues are typically used for sorting elements prior to processing them.
// 2. Assumed to be FIFO (first in first out), unless stated otherwise.
// 3. Some implementations are LIFO (last in first out).
// 4. LinkedList, in addition to being a List is a double-ended queue (insert and remove elements from front and back of queue).
//    Since it implements both List and Queue, it sacrifices some performance.
// 5. ArrayDeque is a 'pure' double-ended queue and is more efficient than LinkedList.
// 6. public interface Deque<E> extends Queue<E>
// 7. When talking about LIFO, people say push/poll/peek
// 8. When talking about FIFO, people say offer, poll, peek

// Methods to note in ArrayDeque:
// 1. add --> Adds an element to the back of the queue and returns true, or throws an exception
// 2. element() --> Returns next element or throws an exception if empty queue
// 3. offer --> Adds an element to the back of the queue and returns whether successful
// 4. remove --> Removes and returns next element or throws an exception if empty queue
// 5. push --> Adds an element to the front of the queue (exists in Deque<E> only)
// 6. poll --> Removes and returns next element or returns null if empty queue
// 7. peek --> Returns next element or returns null if empty queue
// 8. pop --> Removes and returns next element or throws an exception if empty queue
//            (in stack class only and not Queue interface - Stack<E> extends Vector)
public class ImplementingQueue<E> implements Queue<E> {

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
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
