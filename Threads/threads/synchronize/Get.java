package threads.synchronize;


public class Get extends Thread
{
	Message message;
	int id;

	public Get(Message m, int i)
	{
		message = m;
		id = i;
	}

	public void run()
	{
		int value = 0;
		for (int g=0; g<5; g++)
		{
			value = message.get();
			System.out.println("the "+value+" message was received by: "+id);
		}
	}
}

