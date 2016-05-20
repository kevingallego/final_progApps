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
 * @author LuckyChristian
 */
public class ViewSchedule extends javax.swing.JFrame {
    private JButton jbtMenu = new JButton("Menu");
    private JButton jbtEdit = new JButton("Edit");
    private JButton jbtExit = new JButton("Exit");
    private String[] columnNames = {"Class Code","Course No.","Description", "Units", "Time & Days", "Room"};
     
    private Object[][] data;
        private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    private JTable myJTable = new JTable(tableModel);
    /**
     * Creates new form ViewSchedule
     */
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
    public ViewSchedule(){
        
         
         
        add(new JScrollPane(myJTable), BorderLayout.CENTER);
         
        JPanel panel = new JPanel(new java.awt.GridLayout(1, 6));

        panel.add(jbtMenu);
        panel.add(jbtEdit);
        panel.add(jbtExit);
        add(panel, BorderLayout.SOUTH);
        
        jbtMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Index i = new Index();
                i.setVisible(true);
                
                setVisible(false);
            }
        });
        
         jbtEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 Schedule s = new Schedule();
                 s.run();
                
                
                
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
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ViewSchedule frame = new ViewSchedule();
        frame.setTitle("Schedule");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.loadTable();
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
