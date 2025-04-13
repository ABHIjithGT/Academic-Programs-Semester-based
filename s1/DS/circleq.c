// Circular Queue implementation in C

#include <stdio.h>
#include<stdlib.h>

#define SIZE 5

int items[SIZE];
int front = -1, rear = -1;

// check if the queue is full
int isFull() {
  if ((front == (rear + 1) % SIZE) || (front == 0 && rear == SIZE - 1)) return 1;
  return 0;
}

// check if the queue is empty
int isEmpty() {
  if (front == -1) return 1;
  return 0;
}

// adding an element
void enQueue() {
  if (isFull())
    printf("\n Queue is full!! \n");
  else {
    if (front == -1) front = 0;
    rear = (rear + 1) % SIZE;
    int element;
    printf("Enter the Element :");
    scanf("%d",&element);
    items[rear] = element;
    printf("\n Inserted -> %d \n", element);
  }
}

// removing an element
int deQueue() {
  int element;
  if (isEmpty()) {
    printf("\n Queue is empty !! \n");
    return (-1);
  } else {
    element = items[front];
    if (front == rear) {
      front = -1;
      rear = -1;
    } 
    // Q has only one element, so we reset the 
    // queue after dequeing it. ?
    else {
      front = (front + 1) % SIZE;
    }
    printf("\n Deleted element -> %d \n", element);
    
  }
  return 0;
}

// display the queue
void display() {
  int i;
  if (isEmpty())
    printf(" \n Empty Queue\n");
  else {
    printf("\n Front -> %d ", front);
    printf("\n Items -> ");
    for (i = front; i != rear; i = (i + 1) % SIZE) {
      printf("%d ", items[i]);
    }
    printf("%d ", items[i]);
    printf("\n Rear -> %d \n", rear);
  }
}

int main() {
int choice;
    while(1)
     {
         printf(" 1.Enqueue \n 2.Dequeue \n 3.Display \n 4.Exit ");
         printf("\nEnter YOUR choice:");
         scanf("%d",&choice);
         switch(choice)
          {
              case 1:enQueue();
                     break;
              case 2:deQueue();
                     break;
              case 3:display();
                     break;
              case 4:exit(0);
              
          }

 }
}

























































//#include<stdio.h>
//#include<stdlib.h>

//int main()
//{
// int choice,start=-1,i,rear,n,avail,q[100];
// printf("Enter the limit of QUEUE:");
// scanf("%d",&n);
// rear=(n-1);
// avail=(n-1);
// printf(" 1.Insert \n 2.Display \n 3.Delete \n 4.Exit ");
// printf("\nEnter YOUR choice:");
// scanf("%d",&choice);
// while(1)
// {
// switch(choice)
 //     {
 //     
  //     case 1: if(avail>=2)
 //              {
 //               start++;
  //              printf("Enter the ELEMENT");
  //              scanf("%d",&q[start]);
  //             } 
  //             break;
 //      case 2: printf("%d",q[0]);
 //             break;
//       case 3: printf("hi");
//              break;        
 //      case 4:exit(0);
              
 //     }
//     } 
//     return 0;
//}


