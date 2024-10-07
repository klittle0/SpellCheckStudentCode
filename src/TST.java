import java.util.ArrayList;

public class TST {
    Node root;

    // Constructor
    public TST(){
        // Makes the 1st node.
        root = new Node(1);
    }

    // Insert a particular word into the TST
    public void insert(Node currentNode, String s, int depth){
        // BASE CASE: Have finished inserting the whole word
        if (depth == s.length()){
            currentNode.setWord();
            return;
        }
        // RECURSIVE STEPS:
        char currentLetter = s.charAt(depth);
        // If the node is uninitialized, set its value
        if (currentNode.value == '\0') {
            currentNode.setValue(currentLetter);
        }
        // Go left if letter < current node
        if (currentLetter < currentNode.value){
            if (currentNode.getNext()[0] == null){
                currentNode.getNext()[0] = new Node(1);
            }
            // Don't increment depth here, since we skip the current node
            insert(currentNode.getNext()[0], s, depth);
        }
        // Go right if letter > current node
        else if (currentLetter > currentNode.value){
            if (currentNode.getNext()[2] == null){
                currentNode.getNext()[2] = new Node(1);
            }
            // Don't increment depth here, since we skip the current node
            insert(currentNode.getNext()[2], s, depth);
        }
        // Otherwise, letter == current node, so go straight down
        else{
            if (currentNode.getNext()[1] == null){
                currentNode.getNext()[1] = new Node(1);
            }
            insert(currentNode.getNext()[1], s, depth + 1);
        }
    }

    // Error here!!
    // identify whether a particular string exists in the TST
    public boolean lookup(Node currentNode, String s, int depth){
        // BASE CASES
        // If we run into a null node, the word can't exist in the TST
        if (currentNode == null) {
            return false;
        }
        // If we've reached the end of the string, return whether we've found a word
        if (s.length() == depth){
            return currentNode.isWord();
        }

        // RECURSIVE STEPS
        char currentLetter = s.charAt(depth);
        // Go left if the letter < char at current node
        if (currentLetter < currentNode.value){
            // Don't increment depth, since we skipped the current letter
            return lookup(currentNode.getNext()[0], s, depth);
        }
        // Go right if the letter > char at current node
        if (currentLetter > currentNode.value){
            // Don't increment depth here, since we skip the current node
            return lookup(currentNode.getNext()[2], s, depth);
        }
        // otherwise, letter == char at current node, so go straight down
        return lookup(currentNode.getNext()[1], s, depth + 1);
    }
}
