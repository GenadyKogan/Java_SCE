package threads;


public class RunThr
{
	public static void main(String args[])
	{
		MyRunThread t1 = new MyRunThread ("t1");
		MyRunThread t2 = new MyRunThread ("t2");

		Thread t11 = new Thread(t1);
		Thread t22 = new Thread(t2);

		t11.start();
		t22.start();
	}
}

