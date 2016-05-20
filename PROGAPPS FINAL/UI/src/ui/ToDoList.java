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
 
 
public class ToDoList extends JFrame {
     
    private String[] columnNames = 
        {"To DO", "Due"};
     
    private Object[][] data;
     
    private JButton jbtAddRow = new JButton("Add new row");
    private JButton jbtSave = new JButton("Save");

    private JButton jbtMenu = new JButton("Menu");
    private JButton jbtExit = new JButton("Exit");
         
    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    private JTable myJTable = new JTable(tableModel);
     
    private void saveTable() {
        try {
             File file = new File("F:\\PROGAPPS FINAL\\UI\\Todo.txt");
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
        File file = new File("F:\\PROGAPPS FINAL\\UI\\Todo.txt");
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
    
     
    public ToDoList() {
         
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
        File file = new File("F:\\PROGAPPS FINAL\\UI\\Todo.txt");
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
        
        
        

       
         
        
         
    }
      public void run() {
                setVisible(true);
                loadTable();
            }
  public static void main(String[] args) {
        
        ToDoList frame = new ToDoList();
        frame.setTitle("TO DO LIST");
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
            .addGap(0, 439, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}