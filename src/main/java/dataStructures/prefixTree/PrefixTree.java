package dataStructures.prefixTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dawid Pawlak.
 */

public class PrefixTree {

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

//   ---------------------------------- PUBLIC METHODS ---------------------------- //

    /**
     * Complexity : O(L) where L is length of word
     */
    public void addWord(String word) {
        addWord(word, root, 0);
    }

    /**
     * Complexity : O(L) where L is length of word
     */
    public int countWords(String word) {
        return countWords(word, root, 0);
    }

    /**
     * Complexity : O(L) where L is length of prefix
     */
    public int countPrefixes(String prefix) {
        return countPrefixes(prefix, root, 0);
    }

    /**
     * Complexity: O(L * S) where L is length of word and S is a size of an alphabet
     */
    public int countWordsWithNcharactersChanged(String word, int numberOfCharactersToChange) {
        return countWordsWithNcharactersChanged(word, root, 0, numberOfCharactersToChange);
    }

    /**
     * Complexity : O(L * S) where L is length of word and S is a size of an alphabet
     */

    public int countWordsWithMissingExactlyNCharacters(String word, int numberOfCharactersToMiss) {
        return countWordsWithMissingNCharacters(word, root, 0, numberOfCharactersToMiss);
    }


//    -------------------------------------  PRIVATE METHODS ----------------------------//

    private void addWord(String word, Node node, int index) {
        node.prefixes++;
        if(index >= word.length()) {
            node.words++;
            return;
        }
        char letter = word.charAt(index);

        if(!node.letters.containsKey(letter)) {
            node.letters.put(letter, new Node());
        }
        addWord(word, node.letters.get(letter), index+1);

    }

    private int countWords(String word, Node node, int index) {
        if(index >= word.length()) {
            return node.words;
        }
        char letter = word.charAt(index);
        if(!node.letters.containsKey(letter)) return 0;

        return countWords(word, node.letters.get(letter), index+1);
    }

    private int countPrefixes(String prefix, Node node, int index) {
        if(index >=  prefix.length()) return node.prefixes;

        char letter = prefix.charAt(index);
        if(!node.letters.containsKey(letter)) return 0;

        return countPrefixes(prefix, node.letters.get(letter), index+1);
    }

    private int countWordsWithNcharactersChanged(String word, Node node, int index, int numberOfCharactersToChange) {
        if(index >= word.length() && numberOfCharactersToChange == 0) return node.words;
        if(index >= word.length() || numberOfCharactersToChange < 0) return 0;

        int count = 0;
        for(char letter : node.letters.keySet()) {
                if(letter == word.charAt(index)) {
                    count += countWordsWithNcharactersChanged(word, node.letters.get(letter), index + 1, numberOfCharactersToChange);
                } else {
                    count += countWordsWithNcharactersChanged(word, node.letters.get(letter), index + 1, numberOfCharactersToChange - 1);
                }
        }
        return count;
    }

    private int countWordsWithMissingNCharacters(String word, Node node, int index, int numberOfCharactersToMiss) {
        int count = 0;
        if(numberOfCharactersToMiss < 0 || index + numberOfCharactersToMiss > word.length()) return 0;
        else if(index + numberOfCharactersToMiss == word.length()) count = node.words;
        else if(index >= word.length()) return 0;

        for(char letter : node.letters.keySet()) {
                int actualIndex = index;
                int actualMissing = numberOfCharactersToMiss;
                while(actualIndex < word.length() && (word.charAt(actualIndex)  != letter)) {
                    actualIndex++;
                    actualMissing--;
                }
                count += countWordsWithMissingNCharacters(word, node.letters.get(letter), actualIndex+1, actualMissing);
        }
        return count;
    }

    private class Node {
        private Map<Character, Node> letters;
        private int words;
        private int prefixes;

        public Node() {
            letters = new HashMap<>();
        }
    }

}
