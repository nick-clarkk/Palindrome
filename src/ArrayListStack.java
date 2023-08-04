


import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayListStack: Stores data using the abstract data type of a stack, utilizing the two main methods for
 * data manipulation push() and pop().
 *
 * @param <E> data type of elements to be stored in the arrayList
 *

 */
@SuppressWarnings("unchecked")
public class ArrayListStack<E> implements StackInterface {

    private ArrayList<E> arrayStack;


    /**
     * Default Constructor, initializes an empty arrayList.
     */
    public ArrayListStack() {
        arrayStack = new ArrayList<>();
    }

    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return arrayStack.isEmpty();
    }

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    @Override
    public Object peek() {
        if(arrayStack.isEmpty())
            throw new EmptyStackException();
        return arrayStack.get(arrayStack.size() - 1);
    }

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    @Override
    public Object pop() {
        if(arrayStack.isEmpty())
            throw new EmptyStackException();
        return arrayStack.remove(arrayStack.size() - 1);
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    @Override
    public Object push(Object obj) {
        arrayStack.add((E)obj);
        return obj;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    public int size() {
        return arrayStack.size();
    }

}

