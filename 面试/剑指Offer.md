<!-- TOC -->

- [字符串](#字符串)
    - [StringBuffer](#stringbuffer)
- [list](#list)
    - [ArrayList](#arraylist)
    - [Stack](#stack)
    - [Queue](#queue)
- [数据结构类](#数据结构类)
    - [LinkedList](#linkedlist)
        - [3.从头到尾打印链表](#3从头到尾打印链表)
        - [14.链表中倒数第k个结点](#14链表中倒数第k个结点)
        - [15.反转链表](#15反转链表)
        - [16.合并两个排序的链表](#16合并两个排序的链表)
        - [19.顺时针打印矩阵](#19顺时针打印矩阵)
    - [Tree](#tree)
        - [4.重建二叉树](#4重建二叉树)
        - [17.树的子结构](#17树的子结构)
        - [18.二叉树的镜像](#18二叉树的镜像)
        - [22.从上往下打印二叉树](#22从上往下打印二叉树)
        - [23.二叉搜索树的后序遍历](#23二叉搜索树的后序遍历)
    - [Stack & Queue](#stack--queue)
        - [5.用两个栈实现队列](#5用两个栈实现队列)
        - [20.包含min函数的栈](#20包含min函数的栈)
        - [21.栈的压入、弹出序列](#21栈的压入弹出序列)
- [算法类](#算法类)
    - [斐波那契数列](#斐波那契数列)
        - [7.斐波那契数列](#7斐波那契数列)
        - [8.跳格子](#8跳格子)
    - [9.变态跳台阶](#9变态跳台阶)
        - [10.矩形覆盖](#10矩形覆盖)
    - [位运算](#位运算)
        - [11.二进制中1的个数](#11二进制中1的个数)
        - [12.数值的整数次方](#12数值的整数次方)
    - [搜索算法](#搜索算法)
        - [1. 二维数组中的查找](#1-二维数组中的查找)
        - [6.旋转数组的最小数字](#6旋转数组的最小数字)
    - [其它算法](#其它算法)
        - [2.替换空格](#2替换空格)
        - [13.调整数组顺序死奇数位于偶数前面](#13调整数组顺序死奇数位于偶数前面)

<!-- /TOC -->

# 字符串

## StringBuffer

* appen():连接，添加
* insert():添加
* reverse():反转
* replace(start, end, words):替换
* substring(start, end):截取
* delete(start, end):删除
* indexOf(words, start):查找

# list

## ArrayList

* add():添加
* remove(num):删除指定下标值，赋值时等效于队列的弹出

## Stack

* push()：入栈
* pop():弹栈
* peek():栈顶值
* empty():是否为空

## Queue

Queue queue = new LinkedList();
offer():加入队列
poll():弹出队列

# 数据结构类

## LinkedList

### 3.从头到尾打印链表

使用栈

```java
import java.util.Stack;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> list = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        while(listNode != null){
            list.push(listNode.val);
            listNode=listNode.next;
        }
        while(!list.isEmpty()){
            res.add(list.pop());
        }
        return res;
    }
}
```

使用递归

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode preNode = listNode;
        if(preNode != null) {
            if(preNode.next != null){
                list = printListFromTailToHead(preNode.next);
            }
            list.add(preNode.val);
        }
        return list;
    }
}
```

### 14.链表中倒数第k个结点

两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了

```java
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode pre = head;
        ListNode last = head;
        if(head == null || k<=0) return null;
        for(int i=1; i<k; i++){
            if(last.next != null){
                last = last.next;
            }
            else {return null;}
        }
        while(last.next != null){
            pre = pre.next;
            last = last.next;
        }
        return pre;
    }
}
```

### 15.反转链表

确定三个节点，next用于记录head用于移动，head和pre用于更改链表方向，之后向右移动一位。

```java
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
```

### 16.合并两个排序的链表

非递归，新建链表指向

```java
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode current = new ListNode(0);//用于输出，头在起点
        ListNode list = current;
        while(list1 !=null && list2 != null){
            if(list1.val >= list2.val){
                list.next = list2;
                list2 = list2.next;
            }
            else if(list1.val < list2.val){
                list.next = list1;
                list1 = list1.next;
            }
            list = list.next;
        }
        if(list1 == null){
               list.next = list2;
        }
         else if(list2 == null){
               list.next = list1;
         }
        return current.next;
    }
}
```

递归
```java
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }
        else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
```

### 19.顺时针打印矩阵

限制圈

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int cycle = ((row<col ? row : col)-1)/2+1;
        ArrayList res = new ArrayList();
        for(int i=0; i<cycle; i++){
            for(int j=i; j<col-i; j++){//横向从左往右
                res.add(matrix[i][j]);
            }
            for(int k=i+1; k<row-i; k++){//纵向从上往下
                res.add(matrix[k][col-1-i]);
            }
            for(int m=col-2-i;(m>=i)&&(row-i-1!=i); m--){//横向从右往左,单行只打印一次
                res.add(matrix[row-1-i][m]);
            }
            for(int n=row-2-i; (n>i)&&(col-i-1!=i); n--){//纵向从下往上,单列只打印一次
                res.add(matrix[n][i]);
            }
        }
        return res;
    }
}
```

纯数组限制版

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left=0, right=col-1, top=0, bottom=row-1;
        ArrayList res = new ArrayList();
        while(left <= right && bottom >= top){
            for(int i=left; i<=right; ++i){
                res.add(matrix[top][i]);
            }
            for(int i=top+1; i<=bottom; ++i){
                res.add(matrix[i][right]);
            }
            if(top != bottom){
                for(int i=right-1; i>=left; --i){
                    res.add(matrix[bottom][i]);
                }
            }
            if(right != left){
                for(int i=bottom-1; i>top; --i){
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
```

## Tree

### 4.重建二叉树

前序遍历用于判断每个主节点，中序遍历用于判断左右个数

```java
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length) return null;
        return construct(pre, 0, in, 0, in.length-1);
    }
    private TreeNode construct(int[] pre,int preStart,int preEnd, int[] in, int inStart, int inEnd){
        if(inStart>inEnd || preStart>preEnd) return null;//空节点
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i=inStart; i<=inEnd; i++){
            if(pre[preStart] == in[i]){
                root.left = construct(pre, preStart+1, preStart+i-inStart, in, inStart, i-1);
                root.right = construct(pre, preStart+1+i-inStart, preEnd, in, i+1, inEnd);
                break;
            }
        }
        return root;
    }
}
```

### 17.树的子结构

```java
public class Solution {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }            
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
               }
            }
            //返回结果
        return result;
    }
 
    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2{
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {  
                return false;
        }        
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
    }
}
```

### 18.二叉树的镜像

```java
public class Solution {
    public void Mirror(TreeNode root) {
        TreeNode tmp = null;
        if(root == null)return;
        tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        Mirror(root.right);
        Mirror(root.left);
    }
}
```

### 22.从上往下打印二叉树

用arraylist模拟一个队列来存储相应的TreeNode，用tmp提取节点val，再把左右节点压入队列。

```java
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        ArrayList<TreeNode> queue = new ArrayList();
        if(root == null) return list;
        queue.add(root);
        while( queue.size() != 0){
            TreeNode tmp = queue.remove(0);
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
            list.add(tmp.val);
        }
        return list;
    }
}
```

使用队列

```java
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return list;
        queue.offer(root);
        while( queue.size() != 0){
            TreeNode tmp = queue.poll();
            if(tmp.left != null){
                queue.offer(tmp.left);
            }
            if(tmp.right != null){
                queue.offer(tmp.right);
            }
            list.add(tmp.val);
        }
        return list;
    }
}
```

### 23.二叉搜索树的后序遍历

已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。

从最右的root节点开始，从左往右遍历比它小的，再遍历比它大的，遍历完则继续下一个。

```java
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        int index = 0;
        if(len==0)return false;
        while(len != 1){
            len -= 1;
            while(sequence[index] < sequence[len]){
                index++;
            }
            while(sequence[index] > sequence[len]){
                index++;
            }
            if(index < len) return false;
            index = 0;
        }
        return true;
    }
}
```

## Stack & Queue

### 5.用两个栈实现队列

入队：将元素进栈A

出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；

```java
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        int val;
        if(stack2.empty()){
            while(!stack1.empty()){
                val = stack1.peek();
                stack1.pop();
                stack2.push(val);
            }
        }
        return stack2.pop();
    }
}
```

### 20.包含min函数的栈

两个stack一个存数据，一个存每次的最小值

```java
import java.util.Stack;

public class Solution {
    
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int node) {
        data.push(node);
        if(minStack.isEmpty() || node < minStack.peek()){
            minStack.push(node);
        }
        else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        minStack.pop();
        data.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
```

### 21.栈的压入、弹出序列

借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。

```java
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int i=0; i<pushA.length; i++){
            if(pushA[i] != popA[j]){
                stack.push(pushA[i]);
            }
            else{
                j++;
            }
        }
        while(j != popA.length){
            if(popA[j] == stack.pop()) j++;
            else return false;
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
```

优化

```java
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }
}
```

# 算法类

## 斐波那契数列

### 7.斐波那契数列

```java
public class Solution {
    public int Fibonacci(int n) {
        int res=0;
        int pre=1;
        int prepre=0;
        if(n==0) return 0;
        if(n==1) return 1;
        for(int i=2;i<=n;i++){
            res = pre + prepre;
            prepre = pre;
            pre = res; 
        }
        return res;
    }
}
```

### 8.跳格子

a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);

b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)

c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 

d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2

e.可以发现最终得出的是一个斐波那契数列：

           | 1, (n=1)

f(n) =     | 2, (n=2)

           | f(n-1)+f(n-2) ,(n>2,n为整数)

```java
public class Solution {
    public int JumpFloor(int target) {
        if(target ==0) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else return JumpFloor(target - 1)+JumpFloor(target - 2);
    }
}
```

## 9.变态跳台阶

1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。

2）n = 1时，只有1种跳法，f(1) = 1

1) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2) 

2) n = 3时，会有三种跳得方式，1阶、2阶、3阶，

    那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)

    因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)

3) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：

    f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
    
4) 由以上已经是一种结论，但是为了简单，我们可以继续简化：

    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)

    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)

    可以得出：

    f(n) = 2*f(n-1)

5) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：

              | 1       ,(n=0 ) 

f(n) =        | 1       ,(n=1 )

              | 2*f(n-1),(n>=2)

```java
public class Solution {
    public int JumpFloorII(int target) {
        if(target == 0) return 1;
        if(target == 1) return 1;
        return 2*JumpFloorII(target-1);
    }
}
```

### 10.矩形覆盖

target <= 0 大矩形为<= 2*0,直接return 0；
target = 1 大矩形为2*1，只有一种摆放方法，return1；
target = 2 大矩形为2*2，有两种摆放方法，return2；
target = n 分为两步考虑：
* 第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
* 第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
因为，摆放了一块1*2的小矩阵（用√√表示），对应下方的1*2（用××表示）摆放方法就确定了，所以为f(targte-2)

```java
public class Solution {
    public int RectCover(int target) {
        if(target < 1) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else return RectCover(target-1)+RectCover(target-2);
    }
}
```

## 位运算

### 11.二进制中1的个数

负数向左移位的话最高位补1 ！ 因此需要一点点特殊操作，可以将最高位的符号位1变成0，也就是n & 0x7FFFFFFF，这样就把负数转化成正数了，唯一差别就是最高位由1变成0，因为少了一个1，所以count加1。

如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。

举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。

```java
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        if(n<0){//补码
            n = n & 0x7FFFFFFF;
            count++;
        }
        while(n>0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
```

### 12.数值的整数次方

基础遍历复杂度n

```java
public class Solution {
    public double Power(double base, int exponent) {
        double res = 1;
        for(int i=0; i<Math.abs(exponent); i++){
            res *= base; 
        }
        if(exponent < 0){
            res = 1/res;
        }
        return res;
  }
}
```

递归复杂度nlogn

* 当n为偶数，a^n =（a^n/2）*（a^n/2）
* 当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a

```java
public class Solution {
     public static double power(double base, int exponent) {
            int n = Math.abs(exponent);
            double result = 0.0;
            if (n == 0)
                return 1.0;
            if (n == 1)
                return base;
             
            result = power(base, n >> 1);//正数移位相当于十进制/2
            result *= result;
            if ((n & 1) == 1) // 如果指数n为奇数，则要再乘一次底数base
                result *= base;
            if (exponent < 0) // 如果指数为负数，则应该求result的倒数
                result = 1 / result;
             
            return result;
        }
}
```

## 搜索算法

### 1. 二维数组中的查找

遍历复杂度过高，采取的方法是先用右上角的数比较，如果右上角的数大了就左移一列，如果小了就下移一行。

```java
public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length, col = array[0].length;
        boolean res = false;
        if(row>0 && col>0 && array!=null){
            int rows = 0, cols = col-1; 
            while(cols>=0 && rows<row){
                if( target == array[rows][cols]){
                    res = true;
                    break;
                }
                if(target < array[rows][cols]){
                    cols--;
                }
                else{
                    rows++;
                }
            }
        }
        return res;
    }
}
```

### 6.旋转数组的最小数字

二分查找

```java
public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left]>=array[right]) {
            if(right-left==1){
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

```

## 其它算法

### 2.替换空格

使用indexOf寻找空格，subSequence来截取字母，最后添加%20和字母

```java
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int len = str.length();
        int index = 0;
        int fromIndex = 0;
        StringBuffer res = new StringBuffer();
        while(index<len){
            index = str.indexOf(" ", fromIndex);
            if(index>=0){
                res.append(str.subSequence(fromIndex, index)).append("%20");
                index += 1;
                fromIndex = index;
            }
            else{
                res.append(str.subSequence(fromIndex, len));
                break;
            }
            
        }
        return res.toString();
    }
}
```

### 13.调整数组顺序死奇数位于偶数前面

遇到奇数左移一位，类似快排

```java
public class Solution {
    public void reOrderArray(int [] array) {
        int len = array.length;
        int num = 0;//扫描的基数个数，用于偶数移位
        for(int i=0; i<len; i++){
            if(array[i] % 2 == 1){
                int j = i;
                while(j > num){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                num++;
            }
        }
    }
}
```

类似插入排序

```java
public class Solution {
    public void reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){//奇
                int temp=array[i];//存奇
                int j=i-1;
                while(j>=0 && array[j]%2==0){//奇且左为偶
                    array[j+1]=array[j];//放偶
                    j--;
                }
                array[j+1]=temp;//偶全部存放完了，放奇
            }
        }
    }            
}
```