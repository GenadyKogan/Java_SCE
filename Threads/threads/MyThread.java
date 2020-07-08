package threads;


class MyThread extends Thread
{
	MyThread(String caption)
	{
		super(caption);
	}

	public void run()
	{
		for(int i = 1; i < 5; i++)
		{
			System.out.println(i+" "+getName());
			try{
				sleep ((long)(Math.random()*1000));
			}catch (InterruptedException e){}
		}
	}
}

