/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
 
 
public class Grades extends JFrame {
     
    private String[] columnNames = 
        {"Subject","Prelim Grade", "Midterm Grade", "Tentative Final Grade"};
     
    private Object[][] data;
     
    private JButton jbtAddRow = new JButton("Add new row");
    private JButton jbtSave = new JButton("Save");

    private JButton jbtMenu = new JButton("Menu");
    private JButton jbtExit = new JButton("Exit");
         
    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    private JTable myJTable = new JTable(tableModel);
     
    private void saveTable() {
        try {
             File file = new File("F:\\PROGAPPS FINAL\\UI\\Grade.txt");
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
                out.writeObject(tableModel.getDataVector());
                out.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
    }
     
     
    public void loadTable() {
        File file = new File("F:\\PROGAPPS FINAL\\UI\\Grade.txt");
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
    
     
    public Grades() {
         
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
        
     
         
        // Create a combo box for season
        JComboBox jcboSeason = new JComboBox();
        File file = new File("F:\\PROGAPPS FINAL\\UI\\Text1.txt");
        String data = "";
        try {
            


            InputStream in = new FileInputStream( file);
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader dat = new BufferedReader(isr);
            
            String line;
            while((line = dat.readLine()) != null)
            {
            data = line;
            jcboSeason.addItem(data);
                }
            in.close();
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
                         
        // Set combo box as the editor for the season column
        TableColumn seasonColumn = myJTable.getColumn("Subject");
        seasonColumn.setCellEditor(
        new DefaultCellEditor(jcboSeason));
        
       
         
        
         
    }
      public void run() {
                setVisible(true);
                loadTable();
            }
  public static void main(String[] args) {
        
        Grades frame = new Grades();
        frame.setTitle("Grades");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.loadTable();
        frame.setVisible(true);
 
    }
 

                

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        ViewGrades vg = new ViewGrades();
        vg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
   
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

