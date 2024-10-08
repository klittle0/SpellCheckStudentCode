public class Trie {
    Node root;

    // Constructor
    public Trie(){
        root = new Node();
    }

    // Insert a particular word into the Trie
    public void insert(String s){
        insertHelper(root, s, 0);
    }

    public void insertHelper(Node currentNode, String s, int depth){
        // BASE CASE:
        // Once you've reached the end of the word, aka the depth = string length, stop recursion
        if (depth == s.length()){
            // set "isWord" to true
            currentNode.setWord();
            return;
        }

        int currentLetter = s.charAt(depth);
        // RECURSIVE STEPS:
        // If letter isn't a child of the current node, create a new child node
        if (currentNode.getNext()[currentLetter] == null){
            currentNode.getNext()[currentLetter] = new Node();
        }
        // Recurse, one node/level down
        insertHelper(currentNode.getNext()[currentLetter], s, depth + 1);
    }

    public boolean lookup(String s){
        return lookupHelper(root, s, 0);
    }

    // Identify whether a particular word exists in the Trie
    public boolean lookupHelper(Node currentNode, String s, int depth){
        // BASE CASES
        // aka if you've reached the end of Trie & haven't found the word, the word doesn't exist
        if (currentNode == null){
            return false;
        }

        // If you've reached the end of the word, return whether it exists in Trie or not
        if (depth == s.length()){
            return currentNode.isWord();
        }
        // RECURSIVE CALL:
        int currentLetter = s.charAt(depth);
        return lookupHelper(currentNode.getNext()[currentLetter], s, depth + 1);
    }
}