#include <stdio.h>
#include <Part2_Queue.h>


/*测试队列是否为空---数组实现*/
int IsEmpty(Queue Q)
{
    return Q->Size == 0;
}

/*构造空队列*/
void MakeEmpty(Queue Q)
{
    Q->Size = 0;
    Q->Front = 1;
    Q->Rear = 0;
}

/*入队*/
static int Succ(int Value, Queue Q) //循环数组
{
    if(++Value == Q->Capacity)
        Value = 0;
    return Value;
}

void Enqueue(ElementType X, Queue Q)
{
    if(IsFull(Q))
        Error("Full queue");
    else
    {
        Q->Size++;
        Q->Rear = Succ(Q->Rear, Q);
        Q->Array[Q->Rear] = X;
    }
}