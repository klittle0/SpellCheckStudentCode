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

        ArrayList<String> misspelled = new ArrayList<>();
        // The index corresponds to the index of the word in the dictionary array.
        // The value corresponds to the root of the word.
        // If the word is its own root, value = 0
        int[] trees = new int[dictionary.length];

        // Pseudocode:
        // Condense book.text file into an arraylist which features each word once
        ArrayList<String> condensedText = new ArrayList<>();
        for (String word : text){
            if (!condensedText.contains(word)){
                condensedText.add(word);
            }
            // Is there a way I can give this a constant time lookup??
            // I could make an array of the same size & initialize it, but it would have a lot of empty "0" spaces
            // Like a ton of them! Would that extra space be worth it??
            // And then at the end, once I have a list of all unique word instances, I would have to work through a bunch of
            // null spaces
        }
        // Turn the dictionary into a forest of clusters, where the root is their shared prefix
        // Pseudocode:
        String nodeAbove = dictionary[0];
        for (int i = 1; i < dictionary.length; i++){
            String current = dictionary[i];
            // Check to see if the current word starts with the previous addition to the tree
            if (nodeAbove.equals(current.substring(0, nodeAbove.length()))){
                // If the word starts w/ previous addition, set current's root to previous value
                trees[i] = i - 1;
                // set new previous value
                nodeAbove = current;
            }
            // Otherwise, check each node all the way up to the tree's root to see if the current word
            // Can be added anywhere into the tree
            // If it can't be, just leave it as its own root
            else {
                // What are the repercussions of starting this == 1?? None, right, since it's immediately changed later?
                int positionInDict = 1;
                // While not at the root of the cluster:
                while (trees[positionInDict] != 0){
                    // Find the root of the nodeAbove, aka move 1 word up the cluster
                    // Need to find the corresponding root, as listed in trees
                    // Get the root from the dictionary
                    // Get the index of nodeAbove in the dictionary
                   for (int j = 0; j < dictionary.length; j++){
                       if (dictionary[j].equals(nodeAbove)){
                           positionInDict = j;
                           break;
                       }
                   }
                    // Get the root of the node above, based on its index in the dictionary
                    int rootPos = trees[positionInDict];
                    nodeAbove = dictionary[rootPos];

                    // Check to see if the current word starts with the previous addition to the tree
                    if (nodeAbove.equals(current.substring(0, nodeAbove.length()))){
                        // If the word starts w/ previous addition, set current's root to previous value
                        trees[i] = positionInDict;
                        // set new previous value
                        nodeAbove = current;
                   }
                }
            }
            // If the next word is an extension of the previous node, list its root as the previous node
            // Otherwise, trace it up to the previous node
            //then, continue the same check up to the base node
            // If the base node isn't a root of the word, it has to be its own root, so keep its value at 0
        }
        // Need to check each word in book against root of all clusters
        for (String word: condensedText){
            for (int i = 0; i < trees.length; i++){
                // Aka, if this value corresponds to the root of a tree
                if (trees[i] == 0){
                    // Check to see if the word starts with this prefix
                    if(word.substring(0, dictionary[i].length()).contains(dictionary[i])){
                        // If yes, we know that the word might fit somewhere in this cluster
                        // Go through all the nodes of the cluster & see if it equals any of them
                        // I must check the
                    }
                }
            }
        }


    // New pseudocode 10/1:
        // Create a new Trie
        // Go through every word in dictionary and add it to the Trie

        // Make a second tree to represent the misspelled words
        //

        return null;
    }
}
