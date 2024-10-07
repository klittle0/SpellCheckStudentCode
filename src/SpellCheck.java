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
        Trie dictionaryTrie = new Trie();
        // Go through every word in dictionary and add it to the Trie
        for (String word: dictionary){
            dictionaryTrie.insert(dictionaryTrie.root, word, 0);
        }
        // Print every word added to dictionary
        for (String word: dictionaryTrie.test){
            System.out.println(word);
        }
        // Make a second tree to represent the misspelled words
        Trie misspelledTrie = new Trie();
        ArrayList<String> misspelled = new ArrayList<String>();
        for (String word: text){
            // If a word doesn't exist in the dictionary & the misspelled Trie
            if (!dictionaryTrie.lookup(dictionaryTrie.root, word, 0)){
                if (!misspelledTrie.lookup(dictionaryTrie.root, word, 0)){
                    // Insert the word to misspelled
                    misspelledTrie.insert(misspelledTrie.root, word, 0);
                    misspelled.add(word);
                }
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
