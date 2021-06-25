class dfs{
    //100. Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    //99. Recover Binary Search Tree
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
    public void fix(TreeNode node){
        if(node == null) return;
        fix(node.left);
        if(pre!=null&&pre.val>node.val){
            if(first==null) first=pre;
            second = node;
        }
        pre=node;
        fix(node.right);
    }
    public void recoverTree(TreeNode root) {
        fix(root);
        
        //swap first and second
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    //94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        helper(ans, root);
        return ans;
    }
    public void helper(List<Integer> a, TreeNode n){
        if(n==null) return;
        helper(a, n.left);
        a.add(n.val);
        helper(a, n.right);
    }
    //98. Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        List<Integer> a = new ArrayList<Integer>();
        helper(a, root);
        for(int i=1; i<a.size(); i++){
            if(a.get(i)<=a.get(i-1)) return false;
        }
        return true;
    }
    public void helper(List<Integer> x, TreeNode n){
        if(n==null) return;
        helper(x, n.left);
        x.add(n.val);
        helper(x, n.right);
    }
    
}
