package dataStructures.FenwickTree;

/**
 * Created by Dawid Pawlak.
 */

/**
 * Implementation of 2D fenwick tree, which allows to
 *
 * - add value to specific (x,y) field
 * - get sum of submatrix with left corner (x1,y1) and right corner (x2,y2)
 *
 * Both methods works in O(2^d log^d n) time. In this case d = 2
 */

class FenwickTree2D {
    private int tab[][];

    private int n,m;

    public FenwickTree2D(int n, int m) {
        this.n = n;
        this.m = m;
        tab = new int[n][m];
    }

    public int sum(int x, int y) {
        int sum = 0;
        for(int i=x; i>= 0; i = goDown(i)) {
            for(int j=y; j>=0; j = goDown(j)) {
                sum += tab[i][j];
            }
        }
        return sum;
    }

    public int sum(int x1, int y1, int x2, int y2) {
        int sum = sum(x2,y2);
        sum -= sum(x1-1,y2);
        sum -= sum(x2,y1-1);
        sum += sum(x1-1, y1-1);
        return sum;
    }

    public void add(int x, int y, int number) {
        for(int i=x; i< n; i = goUp(i)) {
            for(int j=y; j < m; j = goUp(j)) {
                tab[i][j] += number;
            }
        }
    }

    private int goDown(int index) {
        return (index & (index+1)) -1;
    }

    private int goUp(int index) {
        return (index | (index + 1));
    }

}