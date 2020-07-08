package threads.synchronize;


public class Useprog
{
	public static void main (String[] args)
	{
		Message message = new Message();
		Send s = new Send(message ,1);
		Get g = new Get(message ,2);

		s.start();
		g.start();
	}
}

