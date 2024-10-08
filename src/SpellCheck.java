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
        TST misspelledTrie = new TST();
        ArrayList<String> misspelled = new ArrayList<String>();
        TST dictionaryTrie = new TST();
        // Go through every word in dictionary and add it to the dictionary Trie
        for (String word: dictionary){
            dictionaryTrie.insert(word);
        }

        // Traverse the text
        for (String word: text){
            // If a word doesn't exist in the dictionary or the misspelled Trie, insert into misspelled
            if (!dictionaryTrie.lookup(word) && !misspelledTrie.lookup(word)){
                misspelledTrie.insert(word);
                misspelled.add(word);
            }
        }
        // Convert arraylist of misspelled into array
        String[] misspelledList = new String[misspelled.size()];
        for (int i = 0; i < misspelled.size(); i++){
            misspelledList[i] = misspelled.get(i);
        }
        return misspelledList;
    }
}