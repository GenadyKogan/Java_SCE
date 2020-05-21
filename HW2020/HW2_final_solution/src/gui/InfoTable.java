package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import components.Vehicle;
////




public class InfoTable extends JFrame{

    public InfoTable(Vehicle vehicle, int racersNumber){
        super("Vehicles information");
        
        String[] columnNames = {"Vihicle #","Type","Location","Time on loc","Speed"};
        String[][] data = new String[racersNumber][5];
        int i=0;
     

       /* for (Vehicle vehicle: vehicle.){
=======
      /*  for (Vehicle vehicle: vehicle.getFinishedCompetitors()){
>>>>>>> branch 'master' of https://github.com/GenadyKogan/Java_SCE.git
        	data[i][0] =  String.valueOf(vehicle.getId());
            data[i][1] = ""+vehicle.getVehicleType();
            data[i][2] = ""+vehicle.getCurrentRoute();
            data[i][3] = ""+vehicle.getVehicleType().getAverageSpeed();
            data[i][4] = "Yes";
            i++;
        }
                    
<<<<<<< HEAD
        for (Vehicle vehicle: vehicle.)){
        	data[i][0] =  String.valueOf(vehicle.getId());
=======
        for (Vehicle vehicle: vehicle.getActiveCompetitors()){
            data[i][0] = String.valueOf(vehicle.getId());
>>>>>>> branch 'master' of https://github.com/GenadyKogan/Java_SCE.git
            data[i][1] = ""+vehicle.getVehicleType();
            data[i][2] = ""+vehicle.getCurrentRoute();
            data[i][3] = ""+vehicle.getVehicleType().getAverageSpeed();
            data[i][4] = "No";
            i++;
        }*/
                    
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel tabPan = new JPanel();
        tabPan.add(scrollPane);                   

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(tabPan);
        pack();
        setVisible(true); 
    }
}
