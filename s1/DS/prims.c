#include<stdio.h>
#include<stdlib.h>
int cost[20][20],n,t[20][20],mincost=0,near[10],min;
int main()
{
	int i,j,b,k=0,l=0,c=1,p,q;
	printf("enter the number of vertices:");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		for(j=i+1;j<=n;j++)
		{
			if(i!=j)
			{
				printf("enter the cost[%d][%d]||cost[%d][%d]:",i,j,j,i);
				scanf("%d",&cost[i][j]);
				cost[j][i]=cost[i][j];
				if(cost[i][j]==0)
					{
					   cost[i][j]=999;
					   cost[j][i]=999;
					}
			}
		}
	}	
	k=1;
	l=2;
	mincost=cost[1][2];               
	t[1][1]=k;                                             
	t[1][2]=l;
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
				if(cost[i][j]!=0)
				{
					if(cost[i][j]<mincost)
					{
						k=i;
						l=j;
						mincost=cost[i][j];               
						t[1][1]=k;                                              
						t[1][2]=l;
					}
				}
		}
	}
	printf("cost matrix:\n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			if(cost[i][j]!=999)
			{
			printf("%d\t",cost[i][j]);
			}
		else
		       printf("0\t");
		}
		printf("\n\n");
	}
	for(i=1;i<=n;i++)
	{
		if(cost[i][l]<cost[i][k])
			near[i]=l;
		else
			near[i]=k;
	}
		printf("initial near :");
	for(i=1;i<=n;i++)
	{
		printf("%d       ",near[i]);
	}
	printf("\n");
	near[k]=near[l]=0;
	for(i=2;i<=n-1;i++)
	{
	c=1;
		for(j=1;j<=n;j++)
		{
			if(near[j]!=0 && c==1)
			{
			     min=cost[j][near[j]];
			     p=j;
			     c++;
			}
			else if(near[j]!=0 &&c>1)
			{
				if(cost[j][near[j]]<min)
				{
					min=cost[j][near[j]];
					p=j;
				}
			}
		}
		t[i][1]=p;
		t[i][2]=near[p];
		mincost+=cost[p][near[p]];
		near[p]=0;
		for(k=1;k<=n;k++)
		{
			if(near[k]!=0 && cost[k][near[k]]>cost[k][p])
				near[k]=p;
		}
	}
	printf("Result:\n");
	printf("Vertices       Cost\n");
	for(i=1;i<=n-1;i++)
	{
			for(j=1;j<=2;j++)
			{
				printf("%d      ",t[i][j]);
			}
			printf("   %d",cost[t[i][1]][t[i][2]]);
			printf("\n\n ");
	}
	printf("Mincost=%d      ",mincost);
	return 0;
}
