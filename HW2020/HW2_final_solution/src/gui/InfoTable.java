package gui;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import components.Vehicle;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;


public class InfoTable extends JFrame{

/**
 * constructor
 * @param vehicles
 * Create a table with data for a Vehicle
 */
    public InfoTable(ArrayList<Vehicle> vehicles){
        String[] header = { "Vehicle", "Type", "Location" , "Time on loc", "Speed"};
        String[][] string1 = new String[vehicles.size()][5];
        for (int i=0; i<vehicles.size();i++) {
        	string1[i][0]= String.valueOf(vehicles.get(i).getId());
        	string1[i][1] = vehicles.get(i).getVehicleType().toString();
        	string1[i][2] = vehicles.get(i).getLastRoad().toString();
            string1[i][3] = String.valueOf(vehicles.get(i).getTimeOnCurrentPart());
            string1[i][4] = String.valueOf(vehicles.get(i).getVehicleType().getAverageSpeed());

        }

        JTable table = new JTable(string1, header);
        this.add(new JScrollPane(table));
        this.setSize(500, 500);
        this.setVisible(true);
    }


}
