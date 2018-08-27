//1.2.7栈的链表实现
public class Stack<Item>
{
    private Node first; //栈顶（最近添加的元素）
    private int N;
    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty(){ return first == null;}
    public int size{return N;}
    pubilc void push(Item item)
    { 
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;  
    }
    pubilc Item pop()
    {//从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}

//1.2.8队列的链表实现（先进先出）
public class Queue<Item>
{
    private Node first; //最找添加的结点链接
    private Node last; //最近添加的结点链接
    private int N;
    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty(){ return first == null;}
    public int size{return N;}
    pubilc void enqueue(Item item)
    { //向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;  
    }
    pubilc Item dequeue()
    {//从表头删除元素
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }
}

//1.2.9背包的链表实现
import java.util.Iterator;

public class Bag<Item>  implements Iterable<Item>
{
    private Node first;
    
    private class Node
    {
        Item item;
        Node next;
    }
    
    public void add(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    
    //迭代器，可以给队列，栈实现遍历列表迭代
    public Iterator<Item> iterator()
    { return new ListIterator(); }
    
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        { return current != null; }
        
        public void remove() { }
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}