/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
    
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;



/**
 *
 * @author Admin
 */
public class Schedule extends javax.swing.JFrame {

    private String[] columnNames = 
        {"Class Code","Course No.","Description", "Units", "Time & Days", "Room"};
     
    private Object[][] data;
     
    private JButton jbtAddRow = new JButton("Add new row");
    private JButton jbtSave = new JButton("Save");
    private JButton jbtLoad = new JButton("Load Table");
    private JButton jbtMenu = new JButton("Menu");
    private JButton jbtExit = new JButton("Exit");
         
    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    private JTable myJTable = new JTable(tableModel);
     
    private void saveTable() {
        try{
                //the file path
               File file = new File("C:\\Users\\Admin\\Desktop\\final_progApps\\PROGAPPS FINAL\\UI\\Text.txt");
               //if the file not exist create one
               if(!file.exists()){
                   file.createNewFile();
               }
               
               FileWriter fw = new FileWriter(file.getAbsoluteFile());
               BufferedWriter bw = new BufferedWriter(fw);
               
               //loop for jtable rows
               for(int i = 0; i < myJTable.getRowCount(); i++){
                   //loop for jtable column
                   for(int j = 0; j < myJTable.getColumnCount(); j++){
                       bw.write(myJTable.getModel().getValueAt(i, j)+"");
                       if(myJTable.getColumnCount() ==  6){
                           bw.write("\n");
                       }
                   }
                   
                   //break line at the begin 
                   //break line at the end 
                   
               }
               bw.write("\n");
               //close BufferedWriter
               bw.close();
               //close FileWriter 
               fw.close();
               
               
               }catch(Exception ex){
                   ex.printStackTrace();
               }
    }
     
     
    public void loadTable() {
        File file = new File("C:\\Users\\Admin\\Desktop\\final_progApps\\PROGAPPS FINAL\\UI\\Text.txt");
        try {
            ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(file));
            Vector rowData = (Vector)in.readObject();
            Iterator itr = rowData.iterator();
            while(itr.hasNext()) {
                tableModel.addRow((Vector) itr.next());
            }
            in.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String getRowData(){
        String data = "";
        Object[] rowData = new Object[myJTable.getColumnCount()];
           for (int i = 1; i < myJTable.getColumnCount(); i++) {
   rowData[i] = myJTable.getValueAt(2, 1);
   data = rowData[i].toString();
   
}
           return data;
    }
    
     public Schedule(){
        
         
         
        add(new JScrollPane(myJTable), BorderLayout.CENTER);
         
        JPanel panel = new JPanel(new java.awt.GridLayout(1, 6));
        panel.add(jbtAddRow);
        panel.add(jbtSave);
        panel.add(jbtMenu);
        panel.add(jbtExit);
        add(panel, BorderLayout.SOUTH);
        
        jbtAddRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (myJTable.getSelectedRow() >= 0 )
                    tableModel.insertRow (myJTable.getSelectedRow(),
                        new java.util.Vector());
                else
                    tableModel.addRow(new java.util.Vector());
            }
        });
        
        jbtSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTable();
            }
        });
 
        jbtLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTable();
            }
        });
        
        jbtMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Index i = new Index();
                i.setVisible(true);
                
                setVisible(false);
            }
        });
      
        jbtExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        
     }
     public void run() {
                setVisible(true);
                loadTable();
            }
      public static void main(String[] args) {
        
        Schedule frame = new Schedule();
        frame.setTitle("Schedule");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.loadTable();
        frame.setVisible(true);
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

