package threads.synchronize;


public class Message
{
	int contents;
	boolean flag = false;

	public synchronized void put(int i)
	{
		while (flag == true)
		{
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		contents = i;
		flag = true;
		notify();
	}

	public synchronized int get()
	{
		while (flag == false)
		{
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		flag = false;
		notify();
		return contents;
	}
}


