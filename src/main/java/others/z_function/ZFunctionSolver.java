package others.z_function;

/**
 * Created by Dawid Pawlak.
 */


/**
 * Calculates Z function, where
 * Z[i] - is the longest substring starting at position i, which is also
 * prefix of given word
 *
 * Z[i] = k   =>   word[0..k-1] == word[i+k-1]
 *
 * Complexity : O(n) where n = length of word
 */
public class ZFunctionSolver {

    public int [] calculateZFunction(char [] word) {
        int Z[] = new int[word.length];
        int L, R;
        L = 0; R = 0;
        for(int i=1;i<word.length;i++) {
            if(i<=R) {
                Z[i] = Math.min(Z[i-L], R-i+1);
            }
            while(i + Z[i] < word.length && word[Z[i]] == word[i+Z[i]]) {
                Z[i]++;
            }
            if(i+Z[i] - 1 > R) {
                R = i + Z[i] - 1;
                L = i;
            }
        }
        return Z;
    }

}
