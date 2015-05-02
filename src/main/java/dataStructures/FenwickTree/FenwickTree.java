package dataStructures.FenwickTree;

/**
 * Created by Dawid Pawlak.
 */

/**
 * Implementation of fenwick tree ( binary indexed tree),
 * which allows to :
 *
 * - increase/decrease value in array in O(log n)
 * - get sum of range [L,R] from that array in O(log n)
 *
 */

class FenwickTree {
    private int tab[];

    public FenwickTree(int n) {
        tab = new int[n];
    }

    /**
     * Allows to set initial values in O(n) time
     */
    public FenwickTree(int A[]) {
        tab = new int[A.length];
        for(int i=0;i<A.length;i++) {
            tab[i] += A[i];
            int j = goUp(i);
            if (j < A.length) tab[j] += tab[i];
        }
    }

    public void add(int index, int number) {
        while(index < tab.length) {
            tab[index] += number;
            index = goUp(index);
        }
    }

    public int sum(int left, int right) {
        return sum(right) - sum(left-1);
    }

    private int goDown(int index) {
        return (index & (index+1)) -1;
    }

    private int goUp(int index) {
        return (index | (index + 1));
    }

    private int sum(int right) {
        int sum = 0;
        while(right >= 0) {
            sum += tab[right];
            right = goDown(right);
        }
        return sum;
    }

}
