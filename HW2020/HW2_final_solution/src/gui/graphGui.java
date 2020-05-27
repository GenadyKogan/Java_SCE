package gui;

import components.Junction;
import components.LightedJunction;
import components.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class graphGui extends JPanel {

	 private ArrayList<Junction> junctions;
	    Color clr1;
	    private  ArrayList<Vehicle> vehicles;

	    public graphGui(ArrayList<Junction> junctions2,ArrayList<Vehicle> vehicles2){

	        junctions = junctions2;
	        vehicles = vehicles2;
	        clr1  = new Color(0, 0, 255);
	        for (int i = 0;i<junctions.size();i++){

	            System.out.println("Junc TTTTTTTTTTTTTTTTnumber "+ i + "X and Y:");

	            System.out.println(junctions.get(i).getX());
	            System.out.println(junctions.get(i).getY());

	            System.out.println("\n\n");

	        }

	    }
	    
	    private void drawRotetedVehicle(Graphics g, int x1, int y1, int x2, int y2, int d, int h , Color clr1  , Color clr2 ){
	        int dx = x2 - x1, dy = y2 - y1, delta = 10;
	        double D = Math.sqrt(dx*dx + dy*dy);
	        double xm = delta, xn = xm, ym = h, yn = -h, x;
	        double xm1 = delta + d, xn1 = xm1, ym1 = h, yn1 = -h, xx;
	        double sin = dy / D, cos = dx / D;
	        x = xm*cos - ym*sin + x1;
	        xx = xm1*cos - ym1*sin + x1;
	        ym = xm*sin + ym*cos + y1;
	        ym1 = xm1*sin + ym1*cos + y1;
	        xm = x;
	        xm1 = xx;
	        x = xn*cos - yn*sin + x1;
	        xx = xn1*cos - yn1*sin + x1;
	        yn = xn*sin + yn*cos + y1;
	        yn1 = xn1*sin + yn1*cos + y1;
	        xn = x;
	        xn1 = xx;
	        int[] xpoints = {(int) xm1, (int) xn1,  (int) xn, (int) xm};
	        int[] ypoints = {(int) ym1, (int) yn1, (int) yn, (int) ym};
	        g.fillPolygon(xpoints, ypoints, 4);
	        g.setColor(clr1);
	        g.fillOval((int) xm1-2,(int) ym1-2,4,4);
	        g.fillOval((int) xn1-2,(int) yn1-2,4,4);
	        g.fillOval((int) xm-2,(int) ym-2,4,4);
	        g.fillOval((int) xn-2,(int) yn-2,4,4);
	        g.setColor(clr2);

	    }



	    public void setColor (Color clr){

	        clr1 = clr;




	    }
	    
	    public void paintComponent(Graphics g)  {
	        super.paintComponent(g);





	        for (int i = 0;i<junctions.size();i++){


	            if (junctions.get(i) instanceof LightedJunction){

	                if(((LightedJunction) junctions.get(i)).getLights().getTrafficLightsOn()==true){
	                    g.setColor(Color.GREEN);
	                }else{
	                    g.setColor(Color.red);
	                }

	            }
	            else{
	                g.setColor(Color.black);
	            }








	            g.fillOval((int) (junctions.get(i).getX()), (int) (junctions.get(i).getY()), 30, 30);


	            for (int j = 0;j<junctions.size();j++) {

	                g.setColor(Color.BLACK);

	                g.drawLine((int) (junctions.get(i).getX() + 20 / 2), (int) (junctions.get(i).getY() + 20 / 2), (int) (junctions.get(j).getX() + 20 / 2), (int) (junctions.get(j).getY() + 20 / 2));


	            }

	        }

	        for(int i = 0;i<vehicles.size();i++) {


	            drawRotetedVehicle(g,(int) (vehicles.get(i).getLastRoad().getStartJunction().getX()), (int) (vehicles.get(i).getLastRoad().getStartJunction().getY()), (int) (vehicles.get(i).getLastRoad().getEndJunction().getX()), (int) (vehicles.get(i).getLastRoad().getEndJunction().getY()),  10, 4,clr1,clr1);
	        }



	    }
}
