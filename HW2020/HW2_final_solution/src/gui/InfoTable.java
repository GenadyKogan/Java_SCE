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

    public InfoTable(ArrayList<Vehicle> vehicles){
        String[][] rec2 = new String[vehicles.size()][5];
        for (int i=0; i<vehicles.size();i++) {

            rec2[i][0]= String.valueOf(vehicles.get(i).getId());
            rec2[i][1] = vehicles.get(i).getVehicleType().toString();
            rec2[i][2] = vehicles.get(i).getLastRoad().toString();
            rec2[i][3] = String.valueOf(vehicles.get(i).getTimeOnCurrentPart());
            rec2[i][4] = String.valueOf(vehicles.get(i).getVehicleType().getAverageSpeed());

        }
        String[] header = { "Vehicle", "Type", "Location" , "Time on loc", "Speed"};
        JTable table = new JTable(rec2, header);
        this.add(new JScrollPane(table));
        this.setVisible(true);

    }


}
