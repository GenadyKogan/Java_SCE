import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tournament {
	final int NUMBER_OF_PLAYERS = 8;
	private String name, file_name;
	QueueAsList playersQueue;
	ObjectOutputStream playerOut;
	ObjectInputStream playerIn;
	
	public Tournament(String name, String file_name) {
		this.name = new String(name);
		this.file_name = new String(file_name);
		playersQueue = new QueueAsList();
		playerOut = null;
		playerIn = null;
		
		// Fill players queue
		try{			
			//FileInputStream theFile = // TODO
			//playerIn = // TODO
			
			System.out.println("Load from file");
			for(int i=0; i<NUMBER_OF_PLAYERS; i++)
				playersQueue.enqueue((Player)(playerIn.readObject()));
			playerIn.close();			
		}
		catch(IOException e){
			if(playerIn==null)
			{
				playersQueue.enqueue(new Player("Novak Djokovic",10000));
				playersQueue.enqueue(new Player("Andy Murray",9000));
				playersQueue.enqueue(new Player("Roger Federer",8000));
				playersQueue.enqueue(new Player("Stanislas Wawrinka",7000));
				playersQueue.enqueue(new Player("Rafael Nadal",6000));
				playersQueue.enqueue(new Player("Kei Nishikori",5000));
				playersQueue.enqueue(new Player("Tomas Berdych",4000));
				playersQueue.enqueue(new Player("David Ferrer",3000));
			}
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//try{
		//	FileOutputStream theFile = // TODO
			//playerOut = // TODO
		//}
		//catch(IOException e){			
		//}
	}

	//private Player simulateGame(Player first, Player second) {
		 // TODO
	//	}
	
	public void simulateTournament() {
		System.out.println("*******************************************************");
		System.out.println("Tennis tournament \""+name+"\" is starting now");
		System.out.println("*******************************************************");
		 // TODO
	}	
	
	public void printPlayers() {
		System.out.println("Players ranking:");
		// TODO
	}
}