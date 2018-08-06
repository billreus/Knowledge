#include <stdio.h>
#include <Part2_Stack.h>

/*测试栈是否为空栈*/

int
IsEmpty(Stack S)
{
    return S->Next == NULL;
}

/*创建一个空栈--链表实现*/

Stack
CreateStack(void)
{
    Stack S;

    S = malloc( sizeof( struct Node ) );
    if( S = NULL )
        FatalError( "Out of space!" );
    S->Next == NULL;
    MakeEmpty( S );
    return S;
}

void 
MakeEmpty( Stack S )
{
    if( S == NULL )
        Error("Must use CreatStack first");
    else
        while( !IsEmpty( S ) )
            Pop( S );
}

/*Push进栈--链表实现*/

void Push( ElementType X, Stack S )
{
    PtrToNode TmpCell;

    TmpCell = malloc( sizeof( struct Node ) );
    if( S = NULL )
        FatalError( "Out of space!" );
    else
    {
        TmpCell->Element = X;
        TmpCell->Next = S->Next;
        S->Next = TmpCell;
    }
} //方法同链表插入元素

/*返回栈顶*/

ElementType Top( Stack S )
{
    if( !IsEmpty( S ) )
        return S->Next->Element;
    Error("Empty stack");
    return 0;
}

/*从栈弹出元素*/
void Pop( Stack S )
{
    PtrToNode FirstCell;

    if( IsEmpty( S ) )
        Error("Empty stack");
    else
    {
        FirstCell = S->Next;
        S->Next = S->Next->Next;
        free( FirstCell );
    }
}