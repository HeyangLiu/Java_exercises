class dfs{
    //104. Maximum Depth of Binary Tree
    int max=0;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        helper(root, 0);
        return max+1;
    }
    public void helper(TreeNode n, int d){
        if(n==null) return;
        helper(n.left, d+1);
        if(d>max) max=d;
        helper(n.right, d+1);
    }
    //101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        List<Integer> book = new ArrayList<Integer>();
        List<Integer> direct = new ArrayList<Integer>();
        helper(root, book, direct, 0);
        if(book.size()%2==0) return false;
        for(int i=0; i<book.size()/2; i++){
            if(book.get(i)!=book.get(book.size()-1-i)) return false;
            if(direct.get(i)==direct.get(book.size()-1-i)) return false;
        }
        return true;
    }
    public void helper(TreeNode n, List<Integer> a, List<Integer> b, int dir){
        if(n==null) return;
        helper(n.left, a, b, -1);
        a.add(n.val);
        b.add(dir);
        helper(n.right, a, b, 1);
    }
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
