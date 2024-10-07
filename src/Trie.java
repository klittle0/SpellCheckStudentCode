import java.util.ArrayList;

public class Trie {
    Node root;
    ArrayList<String> test;

    // Constructor
    public Trie(){
        // Makes the 1st node.
        // Do I need to set it equal to the value of the 1st letter shown in dictionary?
        root = new Node();
        test = new ArrayList<String>();
    }

    // THIS IS WORKING.
    public void insert(Node currentNode, String s, int depth){
        // BASE CASE:
        // Once you've reached the end of the word, aka the depth = string length, stop recursion
        if (depth == s.length()){
            // set "isWord" to true
            currentNode.setWord();
            return;
        }
        // the index where the current letter would appear in the alphabet
        // For a TST, I think it would just be depth, not depth - 1??
        int currentLetter = s.charAt(depth);

        // RECURSIVE STEPS:
        // If this letter doesn't exist in the next level of letters
        if (currentNode.getNext()[currentLetter] == null){
            // Insert this letter into the next level
            currentNode.getNext()[currentLetter] = new Node();
        }
        // Go to the next node
        insert(currentNode.getNext()[currentLetter], s, depth + 1);
    }

    // Not working. For some reason, not updating every time I add a new word??
    // Identify whether a particular word (s) exists in the Trie
    public boolean lookup(Node currentNode, String s, int depth){
        // BASE CASES
        // aka if you've reached the end of Trie & haven't found the word, aka the word doesn't exist
        if (currentNode == null){
            // System.out.println("false: " + s);
            return false;
        }
        // I THINK THE ERROR IS HERE
        // If you've reached the length of the word, return whether it exists in Trie or not
        if (depth == s.length()){
            return currentNode.isWord();
        }
        // RECURSIVE CALL:
        // Go down to the next level
        int currentLetter = s.charAt(depth);
        return lookup(currentNode.getNext()[currentLetter], s, depth + 1);
    }
}
