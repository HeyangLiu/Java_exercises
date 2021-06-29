class dfs{
    //130. Surrounded Regions
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0; i<n; i++){
            helper(board, 0, i, m, n);
            helper(board, m-1, i, m, n);
        }
        for(int i=0; i<m; i++){
            helper(board, i, 0, m, n);
            helper(board, i, n-1, m, n);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='#')board[i][j]='O';
                else board[i][j]='X';
            }
        }
    }
    public void helper(char[][] board, int i, int j, int m, int n){
        if(i<0||j<0||i==m||j==n||board[i][j]!='O'){
            return;
        }
        if(board[i][j]=='O') board[i][j]='#';
        helper(board, i, j+1, m, n);
        helper(board, i, j-1, m, n);
        helper(board, i+1, j, m, n);
        helper(board, i-1, j, m, n);
    }
    //129. Sum Root to Leaf Numbers
    int ans =0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root, 0);
        return ans;
    }
    public void helper(TreeNode n, int x){
        if(n==null) return;
        x+=n.val;
        if(n.left==null&&n.right==null){
            ans+=x;
            return;
        }
        helper(n.left, x*10);
        helper(n.right, x*10);
    }
    //144. Binary Tree Preorder Traversal
    List<Integer> ans;
    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        if(root==null) return ans;
        helper(root);
        return ans;
    }
    public void helper(TreeNode n){
        if(n==null) return;
        ans.add(n.val);
        helper(n.left);
        helper(n.right);
    }
    //117. Populating Next Right Pointers in Each Node II
    public Node connect(Node root) {
        if(root==null) return root;
        List<List<Node>> ans = new ArrayList<>();
        List<Node> temp = new ArrayList<>();
        int i=0;
        temp.add(root);
        ans.add(new ArrayList<>(temp));
        temp.removeAll(temp);
        while(true){
            boolean going = false;
            for(int j=0; j<ans.get(i).size(); j++){
                if(ans.get(i).get(j).left!=null){
                    temp.add(ans.get(i).get(j).left);
                    going = true;
                }
                
                if(ans.get(i).get(j).right!=null){
                    temp.add(ans.get(i).get(j).right);
                    going = true;
                }
                
            }
            if(going==false) break;
            ans.add(new ArrayList<>(temp));
            temp.removeAll(temp);
            i++;
        }
        for(i=0; i<ans.size(); i++){
            int j=0;
            for(; j<ans.get(i).size()-1; j++){
                ans.get(i).get(j).next=ans.get(i).get(j+1);
            }
            ans.get(i).get(j).next=null;
        }
        return root;
    }
    //116. Populating Next Right Pointers in Each Node
    public Node connect(Node root) {
        if(root==null) return root;
        List<List<Node>> ans = new ArrayList<>();
        List<Node> temp = new ArrayList<>();
        int i=0;
        temp.add(root);
        ans.add(new ArrayList<>(temp));
        temp.removeAll(temp);
        while(ans.get(i).get(0).left!=null){
            for(int j=0; j<ans.get(i).size(); j++){
                temp.add(ans.get(i).get(j).left);
                temp.add(ans.get(i).get(j).right);
            }
            ans.add(new ArrayList<>(temp));
            temp.removeAll(temp);
            i++;
        }
        for(i=0; i<ans.size(); i++){
            int j=0;
            for(; j<ans.get(i).size()-1; j++){
                ans.get(i).get(j).next=ans.get(i).get(j+1);
            }
            ans.get(i).get(j).next=null;
        }
        return root;
    }
    //111. Minimum Depth of Binary Tree
    int ans=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        
        helper(root, 1);
        return ans;
    }
    public void helper(TreeNode n, int d){
        if(n==null) return;
        helper(n.left, d+1);
        if(n.left==null&&n.right==null&&d<ans) ans=d;
        helper(n.right, d+1);
    }
    //113. Path Sum II
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        
        helper(root, new ArrayList<>(), targetSum, ans);
        return ans;
    }
    
    public void helper(TreeNode n, List<Integer> sum, int s, List<List<Integer>> ans){
        if(n==null) return;
        sum.add(n.val);
        if(n.left==null&&n.right==null){
            if(n.val==s){
                ans.add(new ArrayList<>(sum));
                sum.remove(sum.size()-1);
                return;
            }
        }
        helper(n.left, sum, s-n.val, ans);
        helper(n.right, sum, s-n.val, ans);
        sum.remove(sum.size()-1);
    }
    //112. Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        List<Integer> sum = new ArrayList<Integer> ();
        helper(root, sum, root.val);
        for(int i=0; i<sum.size(); i++){
            if(sum.get(i)==targetSum) return true;
        }
        return false;
    }
    public void helper(TreeNode n, List<Integer> sum, int s){
        if(n==null) return;
        if(n.left!=null)
        helper(n.left, sum, s+n.left.val);
        if(n.left==null&&n.right==null) sum.add(s);
        if(n.right!=null)
        helper(n.right, sum, s+n.right.val);
    }
    //110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root){
        if(root ==  null) return true;
        return Math.abs(height(root.left) - height(root.right))<= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public  int height(TreeNode n){
        if(n == null ) return 0;
        return Math.max(height(n.left) , height(n.right)) + 1;
    }
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
