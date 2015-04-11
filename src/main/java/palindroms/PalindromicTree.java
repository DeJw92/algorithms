package palindroms;

/**
 * Created by Dawid Pawlak.
 */
/**
 * Implementation of PalindromicTree, allows to
 * find number of distinct palindromes,
 * find number of all palindromes,
 * find longest palindrome
 *
 * Algorithm works online
 *
 * Complexity O(n) where n is length of word
 */
class PalindromicTree {


    private int suffixPalindromeLink[], length[], next[][], num[], word[];

    private int numberOfNodes = 0;

    private int index = 0;

    private int lastPalindrome = 0;

    private int numberOfAllPalindromes = 0;

    private int lengthOfLongestPalindrome = 0;

    /**
     *  MAXN >= length(word) + 2 ( for two extra nodes)
     *
     */
    public PalindromicTree(int MAXN, int alphabetSize) {
        suffixPalindromeLink = new int[MAXN];
        length = new int[MAXN];
        next = new int[MAXN][alphabetSize];
        num = new int[MAXN];
        word = new int[MAXN];
        init();
    }


    private void init() {
        newNode(0);
        newNode(-1);
        suffixPalindromeLink[0] = 1;
        word[0] = -1;
    }

    private int newNode(int palindromeLength) {
        lengthOfLongestPalindrome = Math.max(lengthOfLongestPalindrome, palindromeLength);
        length[numberOfNodes] = palindromeLength;
        return numberOfNodes++;
    }

    /**
     *
     * letterIndex - index of letter in alphabet
     * for example having alphabet a-z
     * a - > 0
     * z -> 25
     */
    public void addLetter(int letterIndex) {
        word[++index] = letterIndex;
        int current = getSuffixLink(lastPalindrome);
        if(next[current][letterIndex] == 0) {
            int node = newNode(length[current] + 2);
            suffixPalindromeLink[node] = next[getSuffixLink(suffixPalindromeLink[current])][letterIndex];
            next[current][letterIndex] = node;
            numberOfAllPalindromes += (num[suffixPalindromeLink[node]] + 1  - num[node]);
            num[node] = num[suffixPalindromeLink[node]] + 1;
        }
        lastPalindrome = next[current][letterIndex];
    }

    private int getSuffixLink(int x) {
        while(word[index - length[x] - 1] != word[index]) {
            x = suffixPalindromeLink[x];
        }
        return x;
    }

    public int getNumberOfDistinctPalindromes() { return numberOfNodes - 2;}

    public int getNumberOfAllPalindromes() { return numberOfAllPalindromes; }

    public int getLengthOfLongestPalindrome() {
        return lengthOfLongestPalindrome;
    }
}

