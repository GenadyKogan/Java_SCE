package threads.priority;

class MyPriThread implements Runnable
{
	String name;

	MyPriThread(String n)
	{
		name = n;
	}

	public void run()
	{
		for (int i = 1; i < 5; i++)
		{
			System.out.println(i+" "+name);
			for(int j=0; j<=1000000; j++);
//			try {
//				Thread.sleep((long)(Math.random()*1000));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}

