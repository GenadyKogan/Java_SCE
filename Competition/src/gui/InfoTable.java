
package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.Sportsman;


public class InfoTable extends JFrame{
    
    public InfoTable(Competition competition, int racersNumber){
        super("Competitors information");
        String[] columnNames = {"Name",
                             "Speed",
                             "Max speed",
                             "Location",
                             "Finished"};
        
        String[][] data = new String[racersNumber][5];
        int i=0;
     
        for (Competitor c: competition.getFinishedCompetitors()){
            data[i][0] = ((Sportsman) c).getName();
            data[i][1] = ""+c.getSpeed();
            data[i][2] = ""+c.getMaxSpeed();
            data[i][3] = ""+c.getLocation().getX();
            data[i][4] = "Yes";
            i++;
        }
                    
        for (Competitor c: competition.getActiveCompetitors()){
            data[i][0] = ((Sportsman) c).getName();
            data[i][1] = ""+c.getSpeed();
            data[i][2] = ""+c.getMaxSpeed();
            data[i][3] = ""+c.getLocation().getX();
            data[i][4] = "No";
            i++;
        }
                    
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
