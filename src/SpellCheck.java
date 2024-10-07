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
        // Create a new Trie
        TST dictionaryTrie = new TST();
        // Go through every word in dictionary and add it to the Trie
        for (String word: dictionary){
            dictionaryTrie.insert(dictionaryTrie.root, word, 0);
        }

        // Make a second tree to represent the misspelled words
        TST misspelledTrie = new TST();
        ArrayList<String> misspelled = new ArrayList<String>();
        for (String word: text){
            // If a word doesn't exist in the dictionary and the misspelled Trie
            if (!dictionaryTrie.lookup(dictionaryTrie.root, word, 0) &&
                    !misspelledTrie.lookup(misspelledTrie.root, word, 0)){
                // Insert the word to misspelled
                misspelledTrie.insert(misspelledTrie.root, word, 0);
                misspelled.add(word);
            }
        }
        // Convert arraylist of misspelled into array
        String[] misspelledList = new String[misspelled.size()];
        for (int i = 0; i < misspelled.size(); i++){
            misspelledList[i] = misspelled.get(i);
            // PRINT CHECK!
            System.out.println(misspelledList[i]);
        }
        //anytime a word is added to the Trie, also add it to an array, so that it's easy to return at the end
        return misspelledList;
    }
}
