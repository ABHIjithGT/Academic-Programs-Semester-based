#include <stdio.h>
#define max 10
void add(int *set,int element)
{
	if(element>=0 && element<max)
	{
		*set|=(1<<element);
	}
}

int u(int set1,int set2)
{
	return set1 | set2;
}

int i(int set1,int set2)
{
	return set1 & set2;
}

int d(int set1,int set2)
{
	return set1 & ~set2;
}
int d1(int set1,int set2)
{
	return set2 & ~set1;
}

void dis(int set)
{
	printf("Bitstring:");
	for(int i=max-1;i>=0;i--)
	{
		printf("%d ",(set>>i)&1);
	}
	printf("\nElements: ");
	for(int i=0;i<max;i++)
	{
		if(set&(1<<i))
		{
			printf("%d ",i);
		}
	}
	printf("\n");
}

int main()
{
	int set1=0,set2=0,element;
	printf("Enter (-1 to terminate):\n");
	while(1)
	{
		printf("Enter set1:");
		scanf("%d",&element);
		if(element==-1)
			break;
		add(&set1,element);
	}
	printf("Enter (-1 to terminate):\n");
	while(1)
	{
		printf("Enter set2:");
		scanf("%d",&element);
		if(element==-1)
			break;
		add(&set2,element);
	}
	printf("set 1:\n");
	dis(set1);
	printf("set 2:\n");
	dis(set2);
	
	int ur=u(set1,set2);
	printf("union:\n");
	dis(ur);
	
	int ir=i(set1,set2);
	printf("intersection:\n");
	dis(ir);
	
	int dr=d(set1,set2);
	printf("difference:\n");
	dis(dr);
	
	int d1r=d1(set1,set2);
	printf("difference:\n");
	dis(d1r);
	
	return 0;
}
