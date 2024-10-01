public class Node {
    boolean isWord;
    Node[] next;
    // Constructor
    public Node(){
        isWord = false;
        next = new Node[3];
    }

    // Returns whether a word is real
    public boolean isWord(){
        return isWord;
    }

    // Sets a node to a new value
    public void setWord(){

    }

    public Node[] getNext(){
        return next;
    }
}
