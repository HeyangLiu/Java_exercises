class leetcode {
    public static void main(String[] args) {
        System.out.print("hello");
    }
    //70. Climbing Stairs
    public int climbStairs(int n) {
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<n+1; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //67. Add Binary
    public String addBinary(String a, String b) {
        String x = "";
        //String last="";
        int r = 0;//remianing length
        int l=a.length();//the shorter one
        int remain = 0;//0 if a is shorter, 1 b is shorter, 2 same
        if(b.length()<l){
            l=b.length();
            remain = 1;
        }
        else if(b.length()==l){
            remain =2;
        }
        int car = 0;
        char j = ' ';
        for(int i=a.length()-1, k=b.length()-1; i>-1&&k>-1; i--, k--){
            j = (char)(a.charAt(i)+b.charAt(k)-'0'+car);
            if(j=='2'){
                car=1;
                x='0'+x;
            }
            else if(j=='3'){
                car=1;
                x='1'+x;
            }
            else{
                car=0;
                x=j+x;
            }
        }
        if(remain==2){//same length
            if(car==1)//with carry
                x='1'+x;
        }
        else if(remain==1){//b shorter
            r=a.length()-l;
            if(car==0){
                x=a.substring(0, r)+x;
            }
            else{
                for(int i=r-1; i>-1; i--){
                    j=(char)(a.charAt(i)+car);
                    if(j=='2'){
                        car=1;
                        x='0'+x;
                    }
                    else if(j=='3'){
                        car=1;
                        x='1'+x;
                    }
                    else{
                        car=0;
                        x=j+x;
                    }
                }
                if(car==1)//with carry
                    x='1'+x;
            }
            
        }
        else{//a is shorter
            r=b.length()-l;
            if(car==0){
                x=b.substring(0, r)+x;
            }
            else{
                for(int i=r-1; i>-1; i--){
                    j=(char)(b.charAt(i)+car);
                    if(j=='2'){
                        car=1;
                        x='0'+x;
                    }
                    else if(j=='3'){
                        car=1;
                        x='1'+x;
                    }
                    else{
                        car=0;
                        x=j+x;
                    }
                }
                if(car==1)//with carry
                    x='1'+x;
            }
        }
        return x;
    }
    //66. Plus One
    public int[] plusOne(int[] digits) {
        int carry = 0, cur=digits.length-1;
        digits[cur]++;
        if(digits[cur]==10){
            digits[cur]=0;
            carry=1;
        }
        cur--;
        while(carry==1&&cur>-1){
            digits[cur]++;
            if(digits[cur]==10){
                digits[cur]=0;
                carry=1;
            }
            else carry=0;
            cur--;
        }
        if(carry==0) return digits;
        else{
            int [] ans=new int[digits.length+1];
            ans[0]=1;
            for(int i=1; i<digits.length+1; i++){
                ans[i]=digits[i-1];
            }
            return ans;
        }
    }
    // 58. Length of Last Word
    public int lengthOfLastWord(String s) {
        int r =-1;
        int l =-1;
        int i=s.length()-1;
        boolean foundR = false, foundL=false;
        for(;i>-1;i--){
            if(s.charAt(i)!=' '){
                if(foundR==false){
                    r=i;
                    foundR=true;
                } 
            }
            else{
                if(foundR==true){
                    l=i;
                    break;
                }
            }
        }
        if(r==-1) return 0; //r not found
        if(l==-1){//l not found
            return r+1;
        }
        return r-l;//both found
    }
    //697. Degree of an Array
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap(),
        left = new HashMap(), right=new HashMap();
        int most=0;
        for(int i=0; i<nums.length; i++){
            if(left.get(nums[i])==null) left.put(nums[i], i);
            right.put(nums[i], i);
            if(map.get(nums[i])==null){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i])+1);
                //map.get(nums[i])=map.get(nums[i])+1;
            }
            if(map.get(nums[i])>most){
                most = map.get(nums[i]);
            }
        }
        int min = nums.length;
        for(int x : map.keySet()){
            if(map.get(x)==most)
                min = Math.min(min, right.get(x)-left.get(x)+1);
        }
        return min;
    }
    //53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sums[] = new int[n];
        sums[0]=nums[0];
        int max = sums[0];
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i]+sums[i-1]){
                sums[i]=nums[i];
            }
            else{
                sums[i]=nums[i]+sums[i-1];
            }
            max =Math.max(max, sums[i]);
        }
        return max;
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
