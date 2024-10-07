import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kate Little
 * */

public class SpellCheck {
    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all misspelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {



    // New pseudocode 10/1:
        // Create a new Trie
        Trie dictionaryTrie = new Trie();
        // Go through every word in dictionary and add it to the Trie
        for (String word: dictionary){
            dictionaryTrie.insert(dictionaryTrie.root, word, 0);
        }
        System.out.println(dictionaryTrie);

        // Make a second tree to represent the misspelled words
        //anytime a word is added to the Trie, also add it to an array, so that it's easy to return at the end
        return null;
    }
}
