package gui;

public class Main
{
	public static void main(String[] args)
	{
		int n= 50000;
		int x[] = new int [n];
		long a,b;
		////////////////////////////////
		for(int i=0;i< n;i++)
		{
			x[i] = (int )(Math.random() * 2*n);
			//System.out.print(x[i]+",");
		}
		System.out.println();
		//System.out.println(Arrays.toString( x));
		
		a= System.currentTimeMillis();
		bubbleSort(x);
		b= System.currentTimeMillis();
		//System.out.println(Arrays.toString( x));
		System.out.println("Buble Sort " + (b-a));
		
		for(int i=0;i< n;i++)
		{
			x[i] = (int )(Math.random() * 2*n);
		//	System.out.print(x[i]+",");
		}
		System.out.println();
		//System.out.println(Arrays.toString( x));
		
		a= System.currentTimeMillis();
		selectionSort(x);
		b= System.currentTimeMillis();
		//System.out.println(Arrays.toString( x));
		System.out.println("selection Sort " + (b-a));
		
		
		for(int i=0;i< n;i++)
		{
			x[i] = (int )(Math.random() * 2*n);
			//System.out.print(x[i]+",");
		}
		//System.out.println();
		//////////////////
		a= System.currentTimeMillis();
		insertionSort(x);
		b= System.currentTimeMillis();
		//System.out.println(Arrays.toString( x));
		System.out.println("insertion Sort " + (b-a));
		
		
		for(int i=0;i< n;i++)
		{
			x[i] = (int )(Math.random() * 2*n);
			//System.out.print(x[i]+",");
		}
		//System.out.println();
		 
		a= System.currentTimeMillis();
		mergeSort(x,0,x.length-1);
		b= System.currentTimeMillis();
		//System.out.println(Arrays.toString( x));
		System.out.println("Merge Sort " + (b-a));
	}
	
	public static void bubbleSort(int [] a)
	{
		for(int i=0;i< a.length ; i++)
		{
			for(int j=0;j< a.length-i-1 ; j++)
			{
				if(a[j] > a[j+1])
				{
					int t=a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
		}
	}
	
	
	public static void selectionSort(int [] a)
	{
		for(int i=0;i< a.length ; i++)
		{
			int max_index = 0;
			for(int j=0;j< a.length-i ; j++)
			{
				if(a[j] > a[max_index])
				{
					max_index=j;
				}
			}
			int t=a[a.length-i-1];
			a[a.length-i-1] = a[max_index];
			a[max_index] = t;
		}
	}
	
	public static void insertionSort(int [] a)
	{
		for(int i=1;i< a.length ; i++)
		{
			int j;
			int temp = a[i];
			
			for( j=i-1;j>= 0 ; j--)
			{
				if(a[j] > temp)
				{
					a[j+1]=a[j];
				}
				else break;
			}
			a[j+1] = temp;
		}
	}
	
	public static void mergeSort(int [] a,int l,int r)
	{
		 if(l>=r) return;
		 int mid = (l + r)/2;
		 mergeSort(  a, l, mid);
		 mergeSort(  a, mid+1 , r);
		 
		 int i,j,k;
		 i= l;
		 j= mid+1;
		 
		 int [] temp = new int [a.length];
		 k= l;
		 while(true)
		 {
			
			 if(i <= mid && a[i] < a[j])
			 {
				 temp [k] = a[i];
				 i++;
				 k++;
			 }
			 else if(j <= r)
			 {
				 temp [k] = a[j];
				 j++;
				 k++;
			 }
			 
			 if(i > mid || j > r)
				 break;
		 }
		 
		 while(i<= mid)
		 {
			 temp [k] = a[i];
			 i++;
			 k++;
		 }

		 while(j<= r)
		 {
			 temp [k] = a[j];
			 j++;
			 k++;
		 }
		 
		 for(  i=l;i<=r
				 ;i++)
		 {
			 a[i] = temp[i];
		 }
	}
	

}