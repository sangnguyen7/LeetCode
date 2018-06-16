public void connect(TreeLinkNode root) {
        int h = height(root);
        
        for (int i = 1; i <= h; i++){
            populateNextRight(root, i);
        }
    }
    
    public int height(TreeLinkNode root){
        if (root == null) return 0;
        
        int l_height = height(root.left);
        int r_height = height(root.right);
        
        return Math.max(l_height, r_height) + 1;
    }
    
    public TreeLinkNode populateNextRight(TreeLinkNode root, int level){
        if (root == null) return null;
        if (level == 1) return root;
        
        TreeLinkNode left = populateNextRight(root.left, level-1);
        TreeLinkNode right = populateNextRight(root.right, level-1);
        
        if (left != null){
            TreeLinkNode p = left;
            
            while (p.next != null){
                p = p.next;
            }
            
            p.next = right;
        }
        return left != null? left:right;
    }