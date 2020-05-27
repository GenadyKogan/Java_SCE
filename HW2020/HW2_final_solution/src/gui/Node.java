package gui;

import java.util.ArrayList;

import components.Driving;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Node
{
	public String name;
	public ArrayList<Edge> Adj=new ArrayList<Edge>();
	public Vector pos,vel,acc;
	public Vector posTodraw;
	public Color color;
	public Node(Driving drive, int i)
	{

		//pos= new Vector(300+(int)(Math.random()*5), 300+(int)(Math.random()*5));

	//	pos= new Vector(300+(int)(Math.random()*300-150), 300+(int)(Math.random()*300-150));
		pos= new Vector(300+(int)drive.getMap().getJunctions().get(i).getX(), 300+(int)drive.getMap().getJunctions().get(i).getY());
		

		//vel = new Vector(0,0);
		//acc = new Vector(0,0);
		//color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		
	}
	
	
//	public Vector calForce(ArrayList<Node> ll)
//	{
//		Vector result =new Vector();
//		for(int i=0;i<ll.size();i++){
//			if(ll.get(i)== this)continue;
//			
//			Vector temp = this.pos.sub(ll.get(i).pos);
//			double temp2 = 10 / Math.pow(temp.Size(), 2);
//			
//			temp = temp.Unit().Mul(temp2);
//			result=result.add(temp);
//			
//		}
//		//System.out.println(result.Size());
//		acc = this.acc.add(result); 
//
//		return result;
//	}
//	public Vector calForceEdge( )
//	{
//		Vector result =new Vector();
//		for(int i=0;i<Adj.size();i++){ 
//			Vector temp = Adj.get(i). getForce(this); 
//			result=result.add(temp);
//			
//		} 
//		acc = this.acc.add(result); 
//
//		return result;
//	}
	
	/*public void move()
	{
		vel= vel.add(acc);
		pos= pos.add(vel);
		
		vel=vel.Mul(0.99);
		//System.out.println(pos.getX() + " , " + pos.getY());
	}
		System.out.println(pos.getX() + " , " + pos.getY());
	}*/
	
	public void Draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval((int)(posTodraw.getX()-10), (int)(posTodraw.getY()-10), 20, 20);
		g.setColor(Color.black); 
		//g.drawString(name,(int)(posTodraw.getX()-20), (int)(posTodraw.getY()-20));
	}
	
	public void setPosToDraw(Vector v)
	{
		posTodraw = v;
	}
	
	public Vector getCentroid(ArrayList<Node> ll)
	{
		double sx=0,sy=0;
		for(int i=0;i<ll.size();i++){
			 sx += ll.get(i).posTodraw.getX();
			 sy += ll.get(i).posTodraw.getY();
		}
		return new Vector(sx/ll.size(),sy/ll.size());
	}
	

}
