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
    //26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int i =0;
        for(int j=0; j<nums.length; j++){
            nums[i++]=nums[j];
            while(j!=nums.length-1&&nums[j]==nums[j+1]){
                j++;
            }
        }
        return i;
    }
    //27. Remove Element
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        if(nums.length==1){
            if(nums[0]==val) return 0;
            else return 1;
        }
        int last = nums.length -1;
        int i=0;
        for(; i<nums.length; i++){
            if(nums[i]==val){
                while(last>-1&&nums[last]==val){
                    last--;
                }
                
                if(last>i){
                    nums[i]=nums[last];
                    nums[last]=val;
                }
                else break;
            }
        }
        
        return i;
    }
    //28. Implement strStr()
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        if(l==0) return 0;
        //if(haystack.equals(needle)) return 0;
        for(int i=0; i<haystack.length()-l+1; i++){
            if(haystack.substring(i, i+l).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    //35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int mid = (l+r)/2;
        while(r>=l){
            if(target>nums[mid]){
                l=mid+1;
                mid=(l+r)/2;
            }
            else if(target<nums[mid]){
                r=mid-1;
                mid=(l+r)/2;
            }
            else{
                return mid;
            }
        }
        if(nums[mid]<target) return mid+1;
        return mid;
    }
}
