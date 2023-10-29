package edu.hw3.Task8;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public class BackwardIterator<T> implements Iterator<T> {
    private final Collection<T> collection;
    private Integer size;
    private final T[] a;

    public BackwardIterator(Class<T> c, Collection<T> collection) {
        this.collection = collection;
        size = collection.size();
        this.a = (T[]) Array.newInstance(c, size);
        collection.toArray(this.a);
    }

    @Override
    public boolean hasNext() {
        return size > 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        --size;
        return a[size];
    }

    public String toString() {
        String result = "[";
        while (hasNext()) {
            result += next() + ", ";
        }
        if (result.equals("[")) {
            return "[]";
        }
        return result.substring(0, result.length() - 2) + "]";
    }
}
