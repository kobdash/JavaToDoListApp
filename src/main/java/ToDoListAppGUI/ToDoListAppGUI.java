package ToDoListAppGUI;

import com.mycompany.todolistapp.Task;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoListAppGUI extends javax.swing.JFrame {
    private List<Task> taskList = new ArrayList<>();

    public ToDoListAppGUI() {
        initComponents();
        updateTaskList();
    }

    private void updateTaskList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Add task names to the list model
        for (Task task : taskList) {
            listModel.addElement(task.getTaskName());
        }

        // Set the list model to the JList
        jList1.setModel(listModel);
    }

    private void deleteSelectedTask() {
        int selectedIndex = jList1.getSelectedIndex();

        if (selectedIndex >= 0) {
            // Remove the selected task from the taskList
            taskList.remove(selectedIndex);

            // Update the GUI to reflect the deletion
            updateTaskList();
        } else {
            // Inform the user that they need to select a task
            JOptionPane.showMessageDialog(this, "Please select a task to delete.", "No Task Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        taskNameField1 = new javax.swing.JTextField();
        dueDateField1 = new javax.swing.JTextField();
        priorityScoreField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        taskNameField = new javax.swing.JTextField();
        dueDateField = new javax.swing.JTextField();
        priorityScoreField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        markButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        load = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        sortDue = new javax.swing.JMenuItem();
        sortPriority = new javax.swing.JMenuItem();

        taskNameField1.setText("Task Name");

        dueDateField1.setText("Due Date");

        priorityScoreField1.setText("Priority Score");

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dueDateField1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(taskNameField1)
                            .addComponent(priorityScoreField1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)))
                    .addContainerGap(55, Short.MAX_VALUE)))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(taskNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dueDateField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(priorityScoreField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jScrollPane1);

        taskNameField.setText("Task Name");

        dueDateField.setText("Due Date");

        priorityScoreField.setText("Priority Score");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");

        deleteButton.setText("Mark");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        markButton.setText("Delete");
        markButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(taskNameField)
                        .addComponent(priorityScoreField, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(markButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(taskNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(priorityScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(markButton)
                    .addComponent(deleteButton))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        load.setText("Load");
        jMenu1.add(load);

        exit.setText("Exit");
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        sortDue.setText("Sort by Due Date");
        sortDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDueActionPerformed(evt);
            }
        });
        jMenu2.add(sortDue);

        sortPriority.setText("Sort by Priority");
        jMenu2.add(sortPriority);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void sortDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortDueActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Get input values from text fields
        String taskName = taskNameField.getText();
        LocalDate dueDate = Task.parseDueDate(dueDateField.getText());
        Task.Priority priority = Task.parsePriority(priorityScoreField.getText());

        // Create a new Task
        Task newTask = new Task(taskName, dueDate, priority);

        // Add the new task to the taskList
        taskList.add(newTask);

        // Clear the text fields
        taskNameField.setText("");
        dueDateField.setText("");
        priorityScoreField.setText("");

        // Update the GUI to display the new task in the list
        updateTaskList();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void markButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markButtonActionPerformed
       
deleteSelectedTask(); 
    }//GEN-LAST:event_markButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteSelectedTask();
    }//GEN-LAST:event_deleteButtonActionPerformed
   

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            ToDoListAppGUI gui = new ToDoListAppGUI();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dueDateField;
    private javax.swing.JTextField dueDateField1;
    private javax.swing.JButton editButton;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem load;
    private javax.swing.JButton markButton;
    private javax.swing.JTextField priorityScoreField;
    private javax.swing.JTextField priorityScoreField1;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem sortDue;
    private javax.swing.JMenuItem sortPriority;
    private javax.swing.JTextField taskNameField;
    private javax.swing.JTextField taskNameField1;
    // End of variables declaration//GEN-END:variables
}
