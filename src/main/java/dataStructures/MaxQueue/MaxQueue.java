package dataStructures.MaxQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Dawid Pawlak.
 */

/**
 * Implementation of max queue, which allows to
 * add element to back in O(1),
 * remove element from the beginning in O(1) on average, O(n) worst case
 * get max value of queue in O(1)
 *
 * if empty return Integer.MIN_VALUE as max
 */

public class MaxQueue {

    private Deque<Pair> inBox = new ArrayDeque<>();
    private Deque<Pair> outBox = new ArrayDeque<>();

    public void pushBack(int value) {
        int max = value;
        if(!inBox.isEmpty() && inBox.getLast().y > max) {
            max = inBox.getLast().y;
        }
        inBox.add(new Pair(value,max));
    }

    public void removeFront() {
        if(outBox.isEmpty()) {
            copyInboxToOutbox();
        }
        if(!outBox.isEmpty()) {
            outBox.removeLast();
        }
    }
    private void copyInboxToOutbox() {
        int max = Integer.MIN_VALUE;
        while(!inBox.isEmpty()) {
            Pair top = inBox.removeLast();
            max = Math.max(max, top.x);
            outBox.add(new Pair(top.x, max));

        }
    }

    public int getMax() {
        int max = Integer.MIN_VALUE;
        if(!inBox.isEmpty()) max = Math.max(max, inBox.getLast().y);
        if(!outBox.isEmpty()) max = Math.max(max, outBox.getLast().y);
        return max;
    }



    private class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
