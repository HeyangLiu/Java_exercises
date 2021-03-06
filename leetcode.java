class leetcode {
    public static void main(String[] args) {
        System.out.print("hello");
    }
    //392. Is Subsequence
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        if(s.length()==0) return true;
        int j=0;
        for(int i=0; i<t.length()&&j<s.length(); i++){
            if(s.charAt(j)==t.charAt(i))
                j++;
        }
        return j==s.length();
    }
    //389. Find the Difference
    public char findTheDifference(String s, String t) {
        int[] book = new int[26];
        int i=0;
        for(; i<26; i++){
            book[i]=0;
        }
        int j=0;
        for(i=0; i<t.length(); i++){
            j=(int)(t.charAt(i)-'a');
            book[j]++;
        }
        for(i=0; i<s.length(); i++){
            j=(int)(s.charAt(i)-'a');
            book[j]--;
        }
        for(i=0; i<26; i++){
            if(book[i]>0) return (char)(i+'a');
        }
        return (char)('a'-1);
    }
    //387. First Unique Character in a String
    public int firstUniqChar(String s) {
        int[] book = new int[26];
        int i=0;
        for(;i<26; i++){
            book[i]=0;
        }
        int j=0;
        for(i=0; i<s.length(); i++){
            j=(int)(s.charAt(i)-'a');
            book[j]++;
        }
        for(i=0; i<s.length(); i++){
            j=(int)(s.charAt(i)-'a');
            if(book[j]==1) return i;
        }
        return -1;
    }
    //383. Ransom Note
    public boolean canConstruct(String ran, String mag) {
        int[] book = new int[26];
        int i=0, j=0;
        for(; i<26; i++){
            book[i]=0;
        }
        for(i=0; i<mag.length(); i++){
            j=(int)(mag.charAt(i)-'a');
            book[j]++;
        }
        for(i=0; i<ran.length(); i++){
            j=(int)(ran.charAt(i)-'a');
            book[j]--;
        }
        for(i=0; i<26; i++){
            if(book[i]<0) return false;
        }
        return true;
    }
    //367. Valid Perfect Square
    public boolean isPerfectSquare(int num) {
        double i=0;
        for(; i*i<num; i++){
            if(i*i==num) break;
        }
        return (i*i==num);
    }
    //278. First Bad Version
    public int firstBadVersion(int n) {
        int l=1, r=n;
        int mid;
        while(l<r){
            mid=l+(r-l)/2;//instead of (l+r)/2 to avoid overflow
            if(isBadVersion(mid)){
                
                r=mid;
            }
            else{
                l=mid+1;
            }
            
        }
        return l;
    }
    //338. Counting Bits
    public int[] countBits(int n) {
        int[] ans = new int [n+1];
        ans[0]=0;
        for(int i=1; i<n+1; i++){
            ans[i]=ans[i/2]+i%2;
        }
        return ans;
    }
    //268. Missing Number
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(; i<nums.length; i++){
            if(nums[i]!=i) return i;
        }
        return i;
    }
    //263. Ugly Number
    public boolean isUgly(int n) {
        if(n==0) return false;
        if(n==1) return true;
        while(n%2==0){
            n=n/2;
        }
        while(n%3==0){
            n=n/3;
        }
        while(n%5==0){
            n=n/5;
        }
        return n==1;
    }
    //258. Add Digits
    public int addDigits(int n) {
        if(n==0) return 0;
        if(n%9==0) return 9;
        return n%9;
    }
    //231. Power of Two
    public boolean isPowerOfTwo(int n) {
        int power=1;
        for(int i=0; i<31; i++){
            if(power==n) return true;
            if(power>n) return false;
            
            power=power*2;
        }
       
        return false;
    }
    //219. Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i], i);
            }
            else{
                if(i-map.get(nums[i])<=k){
                    return true;
                }
                else{
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
    //217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> a = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            if(a.contains(nums[i])==false){
                a.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }
    //206. Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ArrayList<Integer> book = new ArrayList<Integer> ();
        while(head!=null){
            book.add(head.val);
            head=head.next;
        }
        ListNode ans = new ListNode();
        ListNode cur = ans;
        for(int i=book.size()-1; i>-1; i--){
            cur.next = new ListNode(book.get(i));
            cur=cur.next;
        }
        return ans.next;
    }
    //205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int [] book = new int[128];
        for(int i=0; i<128; i++){
            book[i]=0;
        }
        for(int j=0; j<s.length(); j++){
            int x = s.charAt(j);
            if(book[x]==0){
                book[x] = (int)t.charAt(j);
            }
            else{
                if(book[x]!=(int)t.charAt(j)){
                    return false;
                }
            }
        }
        for(int i=0; i<128; i++){
            book[i]=0;
        }
        for(int j=0; j<t.length(); j++){
            int x = t.charAt(j);
            if(book[x]==0){
                book[x] = (int)s.charAt(j);
            }
            else{
                if(book[x]!=(int)s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    //204. Count Primes
    public int countPrimes(int n) {
        if(n<3) return 0;
        //if(n<4) return n-1;
        boolean [] book = new boolean[n];
        for(int x=2; x<n; x++){
            book[x]=true;
        }
        for(int i=2; i<n; i++){
            if(book[i]==true){
                for(int j=2; j*i<n; j++){
                    book[i*j]=false;
                }
            }
        }
        int ans = 0;
        for(int a=2; a<n; a++){
            if(book[a]==true){
                ans++;
            }
        }
        return ans;
    }
    //203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null) return head;
        while(cur!=null&&cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }
            else
                cur=cur.next;
        }
        return head;
    }
    //202. Happy Number
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<Integer>();
        int num = 0;
        while(true){
            num=0;
            while(n>0){
                num+=(n%10)*(n%10);
                n=n/10;
            }
            //System.out.println(num);
            if(num==1){
                return true;
            }
            else{
                if(nums.contains(num)){
                    return false;
                }
                else{
                    nums.add(num);
                }
            }
            n=num;
        }
        //return false;
    }
    //172. Factorial Trailing Zeroes
    public int trailingZeroes(int n) {
        if(n==0) return 0;
        int ans =0, j=0;
        for(int i=5; i<n+1; i+=5){
            ans++;
            j=i;
            while(j/5%5==0){
                ans++;
                j=j/5;
            }
        }
        return ans;
    }
    //169. Majority Element
    public int majorityElement(int[] nums) {
        int count=0;
        Integer candidate = null;
        for(int n : nums){
            if(count==0){
                candidate = n;
            }
            count+=(n==candidate)? 1: -1;
        }
        return candidate;
    }
    //171. Excel Sheet Column Number
    public int titleToNumber(String c) {
        int power =1;
        int cur, ans=0;
        for(int i=c.length()-1; i>-1; i--){
            cur = (int)(c.charAt(i)-'@');
            ans+=cur*power;
            power*=26;
        }
        return ans;
    }
    //168. Excel Sheet Column Title
    public String convertToTitle(int c) {
        String ans = "";
        int cur;
        do{
            cur=c%26;
            if(cur==0){
                ans="Z"+ans;
                c=c-26;
            }
            else{
                ans=(char)('A'+c%26-1)+ans;
                c=c-c%26;
            }
            
            c=c/26;
        }while(c>0);
        return ans;
    }
    //167. Two Sum II - Input array is sorted
    public int[] twoSum(int[] n, int tar) {
        int l=0, r=n.length-1;
        while(r>l){
            if(n[l]+n[r]==tar){
                return new int [] {l+1, r+1};
            }
            else if(n[l]+n[r]<tar){
                l++;
            }
            else{
                r--;
            }
        }
        return new int [] {};
    }
    //136. Single Number
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
    //125. Valid Palindrome
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        //System.out.println(s);
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    //122. Best Time to Buy and Sell Stock II
    public int maxProfit(int[] prices) {
        int low=prices[0];
        int ans=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                ans+=prices[i]-prices[i-1];
            }
            
        }
        return ans;
    }
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int max=0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<low){
                low=prices[i];
            }
            else if(max<prices[i]-low){
                max=prices[i]-low;
            }
        }
        return max;
    }
    //118. Pascal's Triangle
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> one = new ArrayList<Integer> ();
        one.add(1);
        res.add(one);
        if(n==1) return res;
        List<Integer> two = new ArrayList<Integer> ();
        two.add(1);
        two.add(1);
        res.add(two);
        if(n==2) return res;
        int x=0;
        for(int i=2; i<n; i++){
            List<Integer> t = new ArrayList<Integer> ();
            t.add(1);
            for(int j=1; j<i; j++){
                x=res.get(i-1).get(j-1)+res.get(i-1).get(j);
                t.add(x);
            }
            t.add(1);
            res.add(t);
        }
        return res;
    }
    //88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] mer = new int[m+n];
        int i=0, j=0, k=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                mer[k]=nums1[i];
                i++;
            }
            else{
                mer[k]=nums2[j];
                j++;
            }
            k++;
        }
        for(;i<m; i++){
            mer[k]=nums1[i];
            k++;
        }
        for(;j<n; j++){
            mer[k]=nums2[j];
            k++;
        }
        for(i=0; i<m+n; i++){
            nums1[i]=mer[i];
        }
    }
    //83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }
            else
                cur=cur.next;
        }
        return head;
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
