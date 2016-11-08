package algorithms.seminar1.iterators;

import java.util.Iterator;

/**
 * Итератор возвращающий последовательность из двух возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 * <p>
 * Time = O(k),
 * k — суммарное количество элементов
 */
public class MergingIncreasingIterator implements Iterator<Integer> {

    private IncreasingIterator first;
    private IncreasingIterator second;
    private Integer nextFirst;
    private Integer nextSecond;

    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;

        if (this.first.hasNext())
            nextFirst = first.next();
        if (this.second.hasNext())
            nextSecond = second.next();
    }

    @Override
    public boolean hasNext() {
        return nextFirst != null || nextSecond != null;
    }

    @Override
    public Integer next() {
        Integer min = null;
        int flag = 0;

        if (nextFirst != null)
            flag = 1;
        if (nextSecond != null && (nextFirst == null || nextSecond < nextFirst))
            flag = 2;
        switch (flag){
            case 1:
                min = nextFirst;
                if (first.hasNext())
                    nextFirst = first.next();
                else
                    nextFirst = null;
                break;
            case 2:
                min = nextSecond;
                if (second.hasNext())
                    nextSecond = second.next();
                else
                    nextSecond = null;
                break;
            default:
                return min;
        }
        return min;
    }

}

