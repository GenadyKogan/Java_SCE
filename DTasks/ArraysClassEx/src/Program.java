import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Program {
	public static void main(String[] args) {
		int[] arr= {2,3,7,1,5};
		int[] newArr=Arrays.copyOf(arr, 10);
//		System.out.println("arr is:"+Arrays.toString(arr));
//		System.out.println("arr is:"+Arrays.toString(newArr));
//		System.out.println(Arrays.equals(arr, newArr));
		int[] newArr2=Arrays.copyOf(arr, arr.length);
//		System.out.println(Arrays.equals(arr, newArr2));
		int[] arr3=arr;
		System.out.println("arr3 is: "+Arrays.toString(arr3)+"\narr is: "+Arrays.toString(arr));
		arr3[1]=5;
		System.out.println("arr3 is: "+Arrays.toString(arr3)+"\narr is: "+Arrays.toString(arr));
	}
}
