public class Trie {
    Node root;

    // Constructor
    public Trie(){
        // Makes the 1st node.
        // Do I need to set it equal to the value of the 1st letter shown in dictionary?
        root = new Node();
    }

    // Insert a particular word into the Trie
    public void insert(Node node, String s, int depth){
        // the index where the current letter would appear in the alphabet
        // For a TST, I think it would just be depth, not depth - 1??
        int currentLetter = (int) s.charAt(depth - 1);

        // BASE CASE:
        // Once you've reached the end of the word, aka the depth = string length, stop recursion
        if (depth == s.length()){
            // set "isWord" to true
            node.getNext()[currentLetter].setWord();
            return;
        }
        // RECURSIVE STEPS:
        // If this letter doesn't exist in the next level of letters
        if (node.getNext()[currentLetter] == null){
            // Insert this letter into the next level
            node.getNext()[currentLetter] = new Node();
        }
        // Go to the next node
        insert(node.getNext()[currentLetter], s, depth + 1);
    }

    // identify whether a particular string exists in the Trie
    public boolean lookup(String s, Node currentNode, int depth){
        // BASE CASE - word exists
        // aka if you've reached the end of the word
        if (currentNode.isWord() && depth == s.length() + 1){
            return true;
        }
        // BASE CASE - word doesn't exist
        if (){
            return false;
        }
        // RECURSIVE CALL:
        // Go down to the next level
        int currentLetter = (int) s.charAt(depth - 1);
        lookup(s, currentNode.getNext()[currentLetter], depth + 1);
    }

}
