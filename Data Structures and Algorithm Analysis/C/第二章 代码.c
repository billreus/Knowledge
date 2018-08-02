#include <stdio.h>
#include <Part 2.h>
/* 测试一个链表是否为空表 */

int
IsEmpty(List L)
{
    return L->Next == NULL;
}

/* 测试当前位置是否是链表的末尾函数 */

int
IsLast(Position P, List L)
{
    return P->Next == NULL;
}

/* 返回某个元素在表中的位置(Element指位置对应元素)) */

Position
Find( ElementType X, List L)
{
    Position P;

    P = L->Next;
    while(P != NULL && P->Element != X)
        P = P->Next;
    
    return P;
}

/* 找出X的表元前驱元P */

Position
FindPrevious( ElementType X, List L)
{
    Position P;

    P = L;
    while( P->Next != NULL && P->Next->Element != X)
        P = P->Next;
    
    return P;
}

/* 删除表L中的某个元素X */

void
Delete(ElementType X, List L)
{
    Position P, TmpCell;

    P = FindPrevious(X, L); 

    if(!IsLast(P, L))
    {
        TmpCell = P->Next;
        P->Next = TmpCell->Next;
        free(TmpCell);
    }
}

/* 链表中插入元素 */

void
Insert(ElementType X, List L, Position P)
{
    Position TmpCell;

    /* 分配新单元地址 */
    TmpCell = malloc( sizeof( struct Node ) );
    if( TmpCell == NULL )
        FatalError( "Out of space !!" );
    
    TmpCell->Element = X;
    TmpCell->Next = P->Next;
    P->Next = TmpCell;
}