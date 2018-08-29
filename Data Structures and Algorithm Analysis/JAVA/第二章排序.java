//排序算法类的模版
public class Example
{
    public static void sort(Comparable[] a)
    
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0 }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args)
    {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

// 算法2.1 选择排序
public class Selection
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j; //less 比较大小，前者小返回True
            exch(a, i, min);  //把min的值赋值给i，等价于选取了排序的数放到该位置
        }
    }
}

//算法2.2 插入排序
public class Insertion
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i =1; i < N; i++) //从a[1]开始比较
        {   // 如果a[i]比左边小，交换，然后继续和左边比较，比较到比左边大就停止，开始i+1的索引
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }
}