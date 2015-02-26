package dataStructures.prefixTree;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class PrefixTreeTest {

    private PrefixTree prefixTree;

    @Before
    public void setUp() {
        prefixTree = new PrefixTree();
    }


    @Test
    public void shouldCountWordOccurences() {
        prefixTree.addWord("aaa");
        prefixTree.addWord("aba");
        prefixTree.addWord("aaa");
        prefixTree.addWord("aaaaaaaa");
        prefixTree.addWord("aaa");

        assertThat(prefixTree.countWords("aaa")).isEqualTo(3);
        assertThat(prefixTree.countWords("aba")).isEqualTo(1);
        assertThat(prefixTree.countWords("aaaaaaaa")).isEqualTo(1);
        assertThat(prefixTree.countWords("aa")).isEqualTo(0);
    }

    @Test
    public void shouldCountPrefixesOccurences() {
        prefixTree.addWord("aaab");
        prefixTree.addWord("aacd");
        prefixTree.addWord("aaaaab");
        prefixTree.addWord("caaaaaaaa");
        prefixTree.addWord("cade");
        prefixTree.addWord("aacddd");
        prefixTree.addWord("aacddd");

        assertThat(prefixTree.countPrefixes("aaa")).isEqualTo(2);
        assertThat(prefixTree.countPrefixes("aa")).isEqualTo(5);
        assertThat(prefixTree.countPrefixes("ca")).isEqualTo(2);
        assertThat(prefixTree.countPrefixes("caaaaaaaa")).isEqualTo(1);
        assertThat(prefixTree.countPrefixes("aacd")).isEqualTo(3);
        assertThat(prefixTree.countPrefixes("cadea")).isEqualTo(0);
    }

    @Test
    public void shouldCountWordsWithExactlyNcharactersChanged() {
        prefixTree.addWord("aaabf");
        prefixTree.addWord("fgacb");
        prefixTree.addWord("abcde");
        prefixTree.addWord("accddt");
        prefixTree.addWord("wxyzt");

        assertThat(prefixTree.countWordsWithNcharactersChanged("aaaaa", 2)).isEqualTo(1);
        assertThat(prefixTree.countWordsWithNcharactersChanged("aaaaa", 4)).isEqualTo(2);
        assertThat(prefixTree.countWordsWithNcharactersChanged("axxddx", 3)).isEqualTo(1);
        assertThat(prefixTree.countWordsWithNcharactersChanged("aaabf", 1)).isEqualTo(0);
        assertThat(prefixTree.countWordsWithNcharactersChanged("wxyrz", 1)).isEqualTo(0);

    }

    @Test
    public void shouldCountWordsWithExactlyNcharactersMissed() {
        prefixTree.addWord("aa");
        prefixTree.addWord("cg");
        prefixTree.addWord("at");
        prefixTree.addWord("ta");
        prefixTree.addWord("cz");
        prefixTree.addWord("aaa");
        prefixTree.addWord("aaa");
        prefixTree.addWord("tyz");
        prefixTree.addWord("tyy");
        prefixTree.addWord("ytz");


        assertThat(prefixTree.countWordsWithMissingExactlyNCharacters("aata",2)).isEqualTo(3);
        assertThat(prefixTree.countWordsWithMissingExactlyNCharacters("acgaataaz", 7)).isEqualTo(5);
        assertThat(prefixTree.countWordsWithMissingExactlyNCharacters("aaa", 0)).isEqualTo(2);
        assertThat(prefixTree.countWordsWithMissingExactlyNCharacters("atcz", 2)).isEqualTo(2);
        assertThat(prefixTree.countWordsWithMissingExactlyNCharacters("tyyz",1)).isEqualTo(2);
    }


}
