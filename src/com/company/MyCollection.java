package com.company;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation for Collection like ArrayList I suppose
 */
@SuppressWarnings("unchecked")
public class MyCollection<T> implements Collection<T> {

    /**
     * Inner array.
     */
    private T[] body;
    /**
     * Actual size of inner array.
     */
    private int size;

    /**
     * Return actual size of collection.
     *
     * @return Integer value which represents size of collection.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks whether collection is empty.
     *
     * @return True if collections size equals 0.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether collection contains given Object.
     *
     * @param o Required Object.
     * @return true if given Object exist in collection.
     */
    @Override
    public boolean contains(Object o) {
        for (T e : body) {
            if (o.equals(e)) return true;
        }
        return false;
    }

    /**
     * Method to create anonymous iterator.
     *
     * @return Iterator for this collection.
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Current position of iterator.
             */
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size && body != null;
            }

            @Override
            public T next() {
                if (position < size) {
                    return body[position++];
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                --position;
                System.arraycopy(body, position + 1, body, position, size - 1 - position);
                size--;
            }

        };
    }

    /**
     * Returns an array with elements of collection.
     *
     * @return Array with all elements of collection.
     */
    @NotNull
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Object[] tmp = body.clone();
        System.arraycopy(tmp, 0, result, 0, size);
        return result;
    }

    /**
     * Puts a collection into given array if enough space? otherwise creates another array with enough space for collection.
     *
     * @param a   Array in which convert collection.
     * @param <E> Type of array.
     * @return The array representation of collection.
     */
    @NotNull
    @Override
    public <E> E[] toArray(@NotNull E[] a) {
        E[] tmp = size <= a.length ? a : (E[]) Array.newInstance(a.getClass().getComponentType(), size);
        for (int i = 0; i < size; i++) {
            tmp[i] = ((E) body[i]);
        }
        a = tmp;
        return a;
    }

    /**
     * Adds new element to collection. If not enough space creates twice a size array.
     *
     * @param t Element to add into collection.
     * @return True if successfully added an element, otherwise false.
     */
    @Override
    public boolean add(T t) {
        if (body == null) {
            body = (T[]) Array.newInstance(t.getClass(), 1);
        }
        if (size < body.length) {
            body[size++] = t;
            return true;
        } else {
            try {
                T[] tmp = (T[]) Array.newInstance(t.getClass(), size * 2);
                System.arraycopy(body, 0, tmp, 0, size);
                tmp[size++] = t;
                body = tmp;
                return true;
            } catch (OutOfMemoryError e) {
                return false;
            }
        }
    }

    /**
     * Removes first occurrence of given object from collection.
     *
     * @param o Object to remove.
     * @return True if object was removed from collection.
     */
    @Override
    public boolean remove(Object o) {
        int ind = 0;
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (o.equals(body[i])) {
                found = true;
                ind = i;
                break;
            }
        }
        if (!found) return false;
        System.arraycopy(body, ind + 1, body, ind, size - 1 - ind);
        size--;
        return true;
    }

    /**
     * Returns true if this collection contains all of the elements in the specified collection.
     *
     * @param c collection to be checked for containment in this collection
     * @return True if this collection contains all of the elements in the specified collection
     */
    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) return false;
        }
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this collection.
     *
     * @param c collection containing elements to be added to this collection
     * @return <i>True</i> if this collection changed as a result of the call
     */
    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        for (T o : c) {
            if (!this.add(o)) return false;
        }
        return true;
    }

    /**
     * Removes all of this collection's elements that are also contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this collection
     * @return <b>true</b> if this collection changed as a result of the call
     */
    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        int initialSize = size;
        for (Object o : c) {
            this.remove(o);
        }
        return initialSize < size;
    }

    /**
     * Retains only the elements in this collection that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this collection
     * @return true if this collection changed as a result of the call.
     */
    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        /*try {
            boolean changed = false;
            MyCollection<T> tmp = new MyCollection<T>();
            for (Iterator<?> it = c.iterator(); it.hasNext(); ) {
                Object current = it.next();
                if (this.contains(current)) {
                    tmp.add((T) current);
                    changed = true;
                }
            }
            this.body = tmp.body;
            this.size = tmp.size;
            return changed;
        } catch (Exception e) {
            return false;
        }*/
        boolean changed = false;
        for (Iterator<T> it = this.iterator(); it.hasNext(); ) {
            T current = it.next();
            if (!c.contains(current)) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Removes all of the elements from this collection.
     */
    @Override
    public void clear() {
        size = 0;
    }

}