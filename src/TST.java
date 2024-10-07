public class TST {
    Node root;

    // Constructor
    public TST(){
        // Makes the 1st node.
        // Do I need to set it equal to the value of the 1st letter shown in dictionary?
        // YES
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
        int currentLetter = s.charAt(depth);
        // Set the node value, if it doesn't currently have a value
        if (currentNode.value == -1){
            currentNode.setValue(currentLetter);
        }
        // Go left if letter <
        if (currentLetter < currentNode.value){
            if (currentNode.getNext()[0] == null){
                currentNode.getNext()[0] = new Node(1);
            }
            // Don't increment depth here, since the current node isn't part of the word
            insert(currentNode.getNext()[0], s, depth);
        }
        // Go right if letter >
        if (currentLetter > currentNode.value){
            if (currentNode.getNext()[2] == null){
                currentNode.getNext()[2] = new Node(1);
            }
            // Don't increment depth here, since the current node isn't part of the word
            insert(currentNode.getNext()[2], s, depth);
        }
        // Go straight if letter ==
        if (currentLetter == currentNode.value){
            if (currentNode.getNext()[1] == null){
                currentNode.getNext()[1] = new Node(1);
            }
            insert(currentNode.getNext()[1], s, depth + 1);
        }
    }

    // identify whether a particular string exists in the TST
    // Change return type to boolean
    public void lookup(String s){

    }

    // Prints out the whole tree for debugging
    public void printTree(){

    }
}
