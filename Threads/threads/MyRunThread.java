package threads;


class MyRunThread implements Runnable
{
	String name;

	MyRunThread(String n)
	{
		name = n;
	}

	public void run()
	{
		for (int i = 1; i < 5; i++)
		{
			System.out.println(i+" "+name);
			try{
				Thread.sleep((long)(Math.random()*1000));
			}catch (InterruptedException e){}
		}
	}
}

