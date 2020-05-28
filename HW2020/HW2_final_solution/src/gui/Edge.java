//package gui;
//
//import java.util.*;
//import java.awt.Color;
//import java.awt.Graphics;
//
//
//public class Edge
//{
//	public Node a,b;
//	public double length;
//	
//	public void Draw(Graphics g)
//	{	
//		g.setColor(Color.black);
//		g.drawLine ((int)(a.posTodraw.getX() ), (int)(a.posTodraw.getY() ),(int)(a.posTodraw.getX() ),(int)(b.posTodraw.getY() ));
//		
//		double xx,yy;
//		xx= (a.posTodraw.getX()  + b.posTodraw.getX() )/2;
//		yy= (a.posTodraw.getY()  + b.posTodraw.getY() )/2;
//		
//		g.drawString(""+length,(int) xx,(int) yy);
//	}
//	
//
////	public Vector getForce(Node toCal)
////	{
////		Vector dir ;
////		if(a== toCal) {
////			dir = b.pos.sub(a.pos);
////		}
////		else
////		{
////			dir = a.pos.sub(b.pos);
////		}
//////		 double t=dir.Size()-10*length;
//////		double ss = Math.signum(t) *Math.log( Math.abs(t))*0.01;
//////		//System.out.println("ss=" + ss);
//////		dir = dir.Unit().Mul(ss);
////		return dir;
////	}
//
//
//	/*public Vector getForce(Node toCal)
//	{
//		Vector dir ;
//		if(a== toCal) {
//			dir = b.pos.sub(a.pos);
//		}
//		else
//		{
//			dir = a.pos.sub(b.pos);
//		}
//		 double t=dir.Size()-10*length;
//		double ss = Math.signum(t) *Math.log( Math.abs(t))*0.01;
//		//System.out.println("ss=" + ss);
//		dir = dir.Unit().Mul(ss);
//		return dir;
//	}
//*/
//
//
//
//}
//
//
