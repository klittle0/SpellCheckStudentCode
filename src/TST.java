public class TST {
    Node root;

    // Constructor
    public TST(){
        // Makes the 1st node.
        // Do I need to set it equal to the value of the 1st letter shown in dictionary?
        // YES
        root = new Node();
    }

    // Insert a particular word into the TST
    public void insert(Node node, String s, int depth){
        // BASE CASE: Have finished inserting the whole word
        if (depth == s.length()){
            return;
        }
        // Set the node value, if it doesn't currently have a value
        if (node.value == -1){
            node.setValue(s.charAt(depth));
            // set "isWord" to true
            node.setWord();
        }


        // the index where the current letter would appear in the alphabet
        // For a TST, I think it would just be depth, not depth - 1??
        int currentLetter = s.charAt(depth);

        // Three cases:
        // If the current letter = value at node
        if (currentLetter = ){

        }
        //
        if (currentLetter > ){

        }
        if (currentLetter < ){

        }

        // If this letter doesn't exist in the next level of letters
        if (node.getNext()[currentLetter] == null){
            // Insert this letter into the next level
            node.getNext()[currentLetter] = new Node();
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
