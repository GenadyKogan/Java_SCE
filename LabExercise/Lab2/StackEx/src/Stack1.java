
public class Stack1 {
	private int[] data;
	private int top;
	public Stack1() {
		top=-1;
		data=new int[10];
	}
	public void push(int x) {
		if(data.length-1==top) {
			int[] temp=new int[data.length+5];
			for(int i=0;i<data.length;i++)
				temp[i]=data[i];
			data=temp;
		}
		data[++top]=x;
	}
	public int pop() {
		return data[--top];
		
	}
	public int peek() {
		return data[top];
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public String toString() {
		String arr="";
		for(int i=0;i<=top;i++)
			arr+=(data[i]+" ");
		return arr;
	}
}
