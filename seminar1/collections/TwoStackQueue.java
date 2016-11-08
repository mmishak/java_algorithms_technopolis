package algorithms.seminar1.collections;

import java.util.Iterator;

public class TwoStackQueue<Item> implements IQueue<Item> {

    private IStack<Item> stack1;
    private IStack<Item> stack2;
    private int size;

    public TwoStackQueue() {
        stack1 = new LinkedStack<Item>();
        stack2 = new LinkedStack<Item>();
    }

    @Override
    public void enqueue(Item item) {
        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }
        stack1.push(item);
        for (int i = 0; i < size; i++) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    @Override
    public Item dequeue() {
        Item item = stack1.pop();
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new TwoStackQueueIterator();
    }

    private class TwoStackQueueIterator implements Iterator<Item> {

        int currentPointer = 0;

        @Override
        public boolean hasNext() {
            if (currentPointer != size)
                return true;
            else
                return false;
        }

        @Override
        public Item next() {
            Item item;
            for (int i = 0; i < currentPointer; i++) {
                stack2.push(stack1.pop());
            }
            item = stack1.pop();
            stack1.push(item);
            for (int i = 0; i < currentPointer; i++) {
                stack1.push(stack2.pop());
            }
            currentPointer++;
            return item;
        }

    }

}
