class TreeNodeFlag{
    TreeNode min;
    TreeNode max;
    boolean b;
    
    TreeNodeFlag(TreeNode minNode, TreeNode maxNode, boolean value){
        min = minNode;
        max = maxNode;
        b = value;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        
        TreeNodeFlag leftNode = maxValidBST(root.left);
        TreeNodeFlag rightNode = minValidBST(root.right);
        if (!leftNode.b || !rightNode.b)
            return false;
        return (leftNode.max == null || root.val > leftNode.max.val) && (rightNode.min == null || root.val < rightNode.min.val);
    }
    
    public TreeNodeFlag maxValidBST(TreeNode root){
        if (root == null || (root.left == null && root.right == null))
            return new TreeNodeFlag(root, root, true);
        TreeNodeFlag leftNode = maxValidBST(root.left);
        TreeNodeFlag rightNode = minValidBST(root.right);
        if (!leftNode.b || !rightNode.b)
            return new TreeNodeFlag(null, null, false);
        if ((leftNode.max != null && leftNode.max.val >= root.val)|| (rightNode.min != null && rightNode.min.val <= root.val))
            return new TreeNodeFlag(null, null, false);
        
        leftNode.max = rightNode.max != null? rightNode.max : rightNode.min != null? rightNode.min : root;
        
        return leftNode;
    }
    
    public TreeNodeFlag minValidBST(TreeNode root){
        if (root == null || (root.left == null && root.right == null))
            return new TreeNodeFlag(root, root, true);
        TreeNodeFlag leftNode = maxValidBST(root.left);
        TreeNodeFlag rightNode = minValidBST(root.right);
        if (!leftNode.b || !rightNode.b)
            return new TreeNodeFlag(null, null, false);
        if ((leftNode.max != null && leftNode.max.val >= root.val)|| (rightNode.min != null && rightNode.min.val <= root.val))
            return new TreeNodeFlag(null, null, false);
        
        rightNode.min = leftNode.min != null? leftNode.min : leftNode.max != null? leftNode.max : root;
        
        return rightNode;
    }