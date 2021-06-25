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
    
}
