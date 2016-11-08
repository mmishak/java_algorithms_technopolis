package algorithms.seminar1.iterators;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 * <p>
 * Time = O(n + k * log n),
 * n — количество итераторов
 * k — суммарное количество элементов
 */
public class MergingPeekingIncreasingIterator implements Iterator<Integer> {

    private Comparator<PeekingIncreasingIterator> comparator = (p1, p2) -> p1.peek().compareTo(p2.peek());
    private IPeekingIterator[] peekingIterator;
    private Integer[] nextValue;

    public MergingPeekingIncreasingIterator(IPeekingIterator... peekingIterator) {

        this.peekingIterator = peekingIterator;
        nextValue = new Integer[peekingIterator.length];
        for (int i = 0; i < this.peekingIterator.length; i++) {
            if (this.peekingIterator[i].hasNext())
                nextValue[i] = (Integer) this.peekingIterator[i].next();
        }
    }

    @Override
    public boolean hasNext() {

        for (int i = 0; i < nextValue.length; i++) {
            if (nextValue[i] != null)
                return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        Integer min = null;
        int index = 0;
        for (int i = 0; i < nextValue.length; i++) {
            if ( nextValue[i] != null && (min == null || nextValue[i] < min) ){
                min = nextValue[i];
                index = i;
            }
        }

        if (peekingIterator[index].hasNext())
            nextValue[index] = (Integer) peekingIterator[index].next();
        else
            nextValue[index] = null;

        return min;
    }
}
