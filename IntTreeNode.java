class IntTreeNode {
    public int data;       // data stored at this IntTreeNode
    public IntTreeNode left;  // reference to left subtree
    public IntTreeNode right; // reference to right subtree
        
    // post: constructs a leaf node with given data
    public IntTreeNode(int data) {
        this(data, null, null);
    }
                
    // post: constructs a IntTreeNode with the given data and links
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}