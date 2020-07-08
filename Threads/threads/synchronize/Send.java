package threads.synchronize;


public class Send extends Thread
{
	Message message;
	int id;

	public Send(Message m, int i)
	{
		message = m;
		id = i;
	}

	public void run()
	{
		for (int g=0; g<5; g++)
		{
			message.put(g);
			System.out.println("the "+g+" message was sent by: "+id);
			try{
				sleep((long)(Math.random()*1000));
			}
			catch(InterruptedException e){}
		}
	}
}

