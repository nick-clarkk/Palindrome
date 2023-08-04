import java.util.*;

/**
 * CircularArrayQueue: Stores data using the abstract data type of a queue, implements all the methods
 * of the java.util.Queue class
 *
 * @param <E> data type of elements to be stored in the arrayList
 *
 */
@SuppressWarnings("unchecked")
public class CircularArrayQueue<E> implements Queue {

    private E[] queueArray;
    int mHead;
    int mTail;
    int mCapacity;
    int mSize;


    /**
     * Initializes an array using the abstract data type queue.
     *
     * @param maxSize the size of the array
     */
    public CircularArrayQueue(int maxSize) {
        queueArray = (E[])new Object[maxSize];
        mHead = -1;
        mTail = -1; //-1 because once we add something we want it to point to head and tail
        mCapacity = maxSize;
        mSize = 0;
    }


    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param o the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws NullPointerException if the specified element is null.
     */
    @Override
    public boolean offer(Object obj) {
        if(obj == null)
            throw new NullPointerException();
        if(mSize == mCapacity)
            reallocate();
        if(mHead == -1)
            mHead++;
        mTail = (mTail + 1) % mCapacity; //want mTail to stay within bounds so use %
        queueArray[mTail] = (E) obj;
        mSize++;
        return true;
    }




    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param o the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     */
    @Override
    public boolean add(Object obj) {
        if(mTail == mCapacity)
            throw new IllegalStateException();
        return offer(obj);
    }



    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public Object poll() {
        if(mHead == -1) //mSize == 0
            return null;
        E element = queueArray[mHead];
        mHead++;
        mSize--;
        return element;
    }


    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll() poll()} only in that it throws an exception if
     * this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public Object remove() {
        if(mSize == 0)
            throw new NoSuchElementException();
        return poll();
    }


    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public Object element() {
        if(mSize == 0)
            throw new NoSuchElementException();
        return queueArray[mHead];
    }


    /**
     * Returns the element at the head of the queue. Returns null if
     * the queue is empty.
     *
     * @return element at the head of the queue.
     */
    @Override
    public Object peek() {
        if(mSize == 0)
            return null;
        return queueArray[mHead];
    }


    /**
     * Helper method that creates an array twice the size of the
     * original array.
     */
    public void reallocate() {
        int newCapacity = mCapacity * 2;
        int j = mHead;
        E[] newArray = (E[]) new Object[newCapacity];
        for(int i = 0; i < mCapacity; i++) {
            newArray[i] = queueArray[j];
            j = (j+1) % mCapacity;
        }
        mHead = 0;
        mTail = mCapacity - 1;
        mCapacity = newCapacity;
        queueArray = newArray;
    }






    /**
     * The following methods were inherited from java.util.Collectoins and
     * were not implemented in this homework assignment.
     * size(), isEmpty(), contatins(Object o), iterator(), toArray(), toAarray(Object[] a), remove(Object o), addAll(Collection c), clear(), retainAll(Collection c), removeAll(Collection c), containsAll(Collection c)
     */
    @Override
    public int size() {
        return mSize;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object obj) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
}

