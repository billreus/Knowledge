# 1. Two Sum(数组)

双重for循环遍历

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
       if(nums == null) return null;

        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                } 
            }
        }
        return result;
    }
} 
```

## 优解

map.containsKey来寻找符合条件的第二个数

```java
class Soultion{
    public int[] twoSum(int[] nums, int target){
        if(nums==null || nums.length==0) return null;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i}
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
```

# 2. Add Two Numbers(链表)

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode list = result;
        int carry = 0; 
        int sum = 0;
            
        while(l1 != null || l2 != null){ 
            int ll1 = (l1 != null) ? l1.carry : 0;
            int ll2 = (l2 != null) ? l2.carry : 0;
            sum = ll1 + ll2 + carry;
            if(sum > 9){
                list.next = new ListNode(sum - 10);
                carry = 1;
            }
            else{
                list.next = new ListNode(sum);
                carry = 0;
            }
            list = list.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry>0) list.next = new ListNode(carry);
        return result.next; //需要从头next，使用list位置已经在最后面      
    }
}
```

# 3. Longest Substring Without Repeating Characters(字符串)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0, j=0; j<n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)));//更新左值
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j+1);//value用来给i更新左值
        }
        return ans;
    }
}
```