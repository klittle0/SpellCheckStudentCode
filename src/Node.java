public class Node {
    boolean isWord;
    Node[] next;
    // What value should be associated with this??? An int? A char?
    int value;

    static int TRIE_CHILDREN = 256;
    static int TST_CHILDREN = 3;
    // Constructor
    public Node(){
        isWord = false;
        next = new Node[TRIE_CHILDREN];
    }

    // Second constructor: this is a node for a TST
    public Node(int i){
        isWord = false;
        // 3 null nodes branch off of each node
        next = new Node[TST_CHILDREN];
        value = -1;
    }

    // Returns whether a real word ends here
    public boolean isWord(){
        return isWord;
    }

    // Sets it so that the real word ends here
    public void setWord(){
        isWord = true;
    }

    public void setValue(int i){
        value = i;
    }

    public Node[] getNext(){
        return next;
    }
}
