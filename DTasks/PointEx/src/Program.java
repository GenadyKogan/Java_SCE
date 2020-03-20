import java.util.Arrays;

public class Program {
	public static void main(String[] args) {
		Point[] arr=new Point[3];
		for(int i=0;i<arr.length;i++)
			arr[i]=new Point(i, i);
		Point[] copyArr=Arrays.copyOf(arr, arr.length);
		//copyArr[0].setX(77);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(copyArr));
		Point[] arr1=new Point[4];
		for(int i=0;i<arr1.length;i++)
			arr1[i]=new Point(i, i);
		Point[] arr2=Arrays.copyOf(arr1, arr1.length);
		Point[] arr3=arr1;
		arr3[0].setX(77);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		arr1[2]=new Point(5, 5);
		arr2[2]=new Point(6, 6);
		System.out.println("\n");
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));

	}
}
