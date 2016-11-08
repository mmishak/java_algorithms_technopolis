package algorithms.seminar1.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedDeque<Item> implements IDeque<Item> {

    private LinkedList<Item> deque;
    private int size;

    public LinkedDeque(){
        deque = new LinkedList<Item>();
    }

    @Override
    public void pushFront(Item item) {
        deque.addFirst(item);
        size++;
    }

    @Override
    public void pushBack(Item item) {
        deque.addLast(item);
        size++;
    }

    @Override
    public Item popFront() {
        return deque.getFirst();
    }

    @Override
    public Item popBack() {
        return deque.getLast();
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
        return deque.iterator();
    }
}
