package algorithms.seminar1.collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item> head;
    private int size;

    @Override
    public void push(Item item) {
        head = new Node<Item>(item, head);
        size++;
    }

    @Override
    public Item pop() {
        if (head == null)
            return null;

        Node<Item> tmp = head;
        head = head.next;
        size--;
        return tmp.item;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {

        Node<Item> current = head;

        @Override
        public boolean hasNext() {
            if (current != null)
                return true;
            else
                return false;
        }

        @Override
        public Item next() {
            Item tmp = current.item;
            current = current.next;
            return tmp;
        }

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
