class dfs{
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
