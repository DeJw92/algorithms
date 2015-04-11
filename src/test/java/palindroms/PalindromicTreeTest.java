package palindroms;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class PalindromicTreeTest {

    private int MAXN = 20;

    private int alphabetSize = 26;

    private PalindromicTree palindromicTree;

    @Before
    public void setUp() {
        palindromicTree = new PalindromicTree(MAXN, alphabetSize);
    }

    @Test
    public void basicTestOffline() {
        String word = "wtcxaaxz";
        for(int i=0;i<word.length();i++) {
            palindromicTree.addLetter(word.charAt(i) - 'a');
        }
        assertThat(palindromicTree.getLengthOfLongestPalindrome()).isEqualTo(4);
        assertThat(palindromicTree.getNumberOfDistinctPalindromes()).isEqualTo(8);
        assertThat(palindromicTree.getNumberOfAllPalindromes()).isEqualTo(10);
    }

    @Test
    public void testPalindromeOnline() {
        String word = "malayalam";
        assertThat(palindromicTree.getLengthOfLongestPalindrome()).isEqualTo(0);
        assertThat(palindromicTree.getNumberOfAllPalindromes()).isEqualTo(0);

        palindromicTree.addLetter(word.charAt(0) - 'a'); // m
        palindromicTree.addLetter(word.charAt(1) - 'a'); // a

        assertThat(palindromicTree.getLengthOfLongestPalindrome()).isEqualTo(1);
        assertThat(palindromicTree.getNumberOfDistinctPalindromes()).isEqualTo(2);
        assertThat(palindromicTree.getNumberOfAllPalindromes()).isEqualTo(2);

        palindromicTree.addLetter(word.charAt(2) - 'a'); // l
        palindromicTree.addLetter(word.charAt(3) - 'a'); // a

        assertThat(palindromicTree.getLengthOfLongestPalindrome()).isEqualTo(3);
        assertThat(palindromicTree.getNumberOfDistinctPalindromes()).isEqualTo(4);
        assertThat(palindromicTree.getNumberOfAllPalindromes()).isEqualTo(5);

        palindromicTree.addLetter(word.charAt(4) - 'a'); // y
        palindromicTree.addLetter(word.charAt(5) - 'a'); // a
        palindromicTree.addLetter(word.charAt(6) - 'a'); // l

        assertThat(palindromicTree.getLengthOfLongestPalindrome()).isEqualTo(5);
        assertThat(palindromicTree.getNumberOfDistinctPalindromes()).isEqualTo(7);
        assertThat(palindromicTree.getNumberOfAllPalindromes()).isEqualTo(10);

        palindromicTree.addLetter(word.charAt(7) - 'a'); // a
        palindromicTree.addLetter(word.charAt(8) - 'a'); // m

        assertThat(palindromicTree.getLengthOfLongestPalindrome()).isEqualTo(9);
        assertThat(palindromicTree.getNumberOfDistinctPalindromes()).isEqualTo(9);
        assertThat(palindromicTree.getNumberOfAllPalindromes()).isEqualTo(15);
    }


}
