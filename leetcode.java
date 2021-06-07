class leetcode {
    public static void main(String[] args) {
        System.out.print("hello");
    }
    //20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(!stack.empty()&&stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            }
            else if(s.charAt(i)==']'){
                if(!stack.empty()&&stack.peek()=='[')
                    stack.pop();
                else
                    return false;
            }
            else if(s.charAt(i)=='}'){
                if(!stack.empty()&&stack.peek()=='{')
                    stack.pop();
                else
                    return false;
            }
            else
                stack.push(s.charAt(i));
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode root = new ListNode();
        ListNode head = root;
        while(l1!=null&&l2!=null){
            if(l1.val > l2.val){
                root.next=l2;
                l2=l2.next;
            }
            else{
                root.next=l1;
                l1=l1.next;
            }
            root=root.next;
        }
        if(l1!=null) root.next=l1;
        if(l2!=null) root.next=l2;
        return head.next;
    }
}
