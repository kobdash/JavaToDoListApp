package ToDoListAppGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ToDoListAppGUI extends javax.swing.JFrame {
   DefaultListModel<String> listModel = new DefaultListModel<>();
   private int selectedIndex; 


    public ToDoListAppGUI() {
        initComponents();
        
    }
    
    
    //Method to Save to file
    private void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < listModel.size(); i++) {
                writer.write(listModel.getElementAt(i) + System.lineSeparator());
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ToDoListAppGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Method to Load from file
    private void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.addElement(line);
                taskList.setModel(listModel);
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(ToDoListAppGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     //Method to sort task list by due date
     private void sortByDueDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Create a custom comparator for sorting based on due date
        Comparator<String> dueDateComparator = new Comparator<String>() {
            @Override
            public int compare(String task1, String task2) {
                try {
                    // Extract the due dates from the task strings
                    String dueDate1 = task1.substring(task1.indexOf("Due Date: ") + 10, task1.indexOf("Priority: "));
                    String dueDate2 = task2.substring(task2.indexOf("Due Date: ") + 10, task2.indexOf("Priority: "));

                    // Parse the due dates into Date objects for comparison
                    Date date1 = dateFormat.parse(dueDate1);
                    Date date2 = dateFormat.parse(dueDate2);

                    // Compare the due dates
                    return date1.compareTo(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0; // Handle parsing exception
                }
            }
        };

        // Get the elements from listModel as a list
        List<String> elements = Collections.list(listModel.elements());

        // Sort the elements using the custom comparator
        Collections.sort(elements, dueDateComparator);

        // Clear the existing listModel and add the sorted elements back
        listModel.clear();
        for (String element : elements) {
            listModel.addElement(element);
        }
    }
    
    //Method to Sort task list by priority
  private void sortByPriority() {
    // Create a custom comparator for sorting based on priority
    Comparator<String> priorityComparator = new Comparator<String>() {
        @Override
        public int compare(String task1, String task2) {
            // Extract the priorities from the task strings
            String priorityStr1 = task1.substring(task1.indexOf("Priority: ") + 10, task1.indexOf(", Complete: "));
            String priorityStr2 = task2.substring(task2.indexOf("Priority: ") + 10, task2.indexOf(", Complete: "));

            try {
                // Parse the priority values as integers for comparison
                int priority1 = Integer.parseInt(priorityStr1);
                int priority2 = Integer.parseInt(priorityStr2);

                // Compare the priorities
                return Integer.compare(priority2, priority1);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0; // Handle parsing exception
            }
        }
    };

    // Get the elements from listModel as a list
    List<String> elements = Collections.list(listModel.elements());

    // Sort the elements using the custom comparator
    Collections.sort(elements, priorityComparator);

    // Clear the existing listModel and add the sorted elements back
    listModel.clear();
    for (String element : elements) {
        listModel.addElement(element);
    }
}


    
    
    //Method to toggle complete status
    private void toggleCompleteStatus() {
    int selectedIndex = taskList.getSelectedIndex();
    if (selectedIndex != -1) {
        String selectedTask = listModel.get(selectedIndex);
        if (selectedTask.contains("Complete: Yes")) {
            selectedTask = selectedTask.replace("Complete: Yes", "Complete: No");
        } else {
            selectedTask = selectedTask.replace("Complete: No", "Complete: Yes");
        }
        listModel.setElementAt(selectedTask, selectedIndex);
    }
    }
    
    
   

    
     private void removeSelectedItem() {
    int selectedIndex = taskList.getSelectedIndex(); // Get the selected item index
    if (selectedIndex != -1) {
        listModel.remove(selectedIndex); // Remove the item from the listModel
    }
}

     private boolean isValidDateFormat(String date) {
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.parse(date);
        return true;
    } catch (ParseException e) {
        return false;
    }
}

private boolean isValidPriority(String priority) {
    try {
        int parsedPriority = Integer.parseInt(priority);
        if (parsedPriority >= 1 && parsedPriority <= 9) {
            return true;
        }
    } catch (NumberFormatException e) {
        // Handle parsing exceptions (e.g., non-integer input)
    }
    return false;
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editDialog = new javax.swing.JDialog();
        nameField1 = new javax.swing.JTextField();
        taskDescriptionField1 = new javax.swing.JTextField();
        dueDateField1 = new javax.swing.JTextField();
        priorityField1 = new javax.swing.JTextField();
        saveEdit = new javax.swing.JButton();
        exitEdit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        markButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        taskDescriptionField = new javax.swing.JTextField();
        dueDateField = new javax.swing.JTextField();
        priorityField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jOptionPane = new javax.swing.JOptionPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        fileSave = new javax.swing.JMenuItem();
        fileLoad = new javax.swing.JMenuItem();
        fileExit = new javax.swing.JMenuItem();
        menuSort = new javax.swing.JMenu();
        sortDueDate = new javax.swing.JMenuItem();
        sortPriority = new javax.swing.JMenuItem();

        nameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField1ActionPerformed(evt);
            }
        });

        taskDescriptionField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskDescriptionField1ActionPerformed(evt);
            }
        });

        dueDateField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueDateField1ActionPerformed(evt);
            }
        });

        priorityField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityField1ActionPerformed(evt);
            }
        });

        saveEdit.setText("Save");
        saveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditActionPerformed(evt);
            }
        });

        exitEdit.setText("Exit");

        jLabel5.setText("Name");

        jLabel6.setText("Task Description");

        jLabel7.setText("Due Date (MM/dd/yyyy)");

        jLabel8.setText("Priority (Between 1-9)");

        javax.swing.GroupLayout editDialogLayout = new javax.swing.GroupLayout(editDialog.getContentPane());
        editDialog.getContentPane().setLayout(editDialogLayout);
        editDialogLayout.setHorizontalGroup(
            editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDialogLayout.createSequentialGroup()
                .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editDialogLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(saveEdit)
                        .addGap(83, 83, 83)
                        .addComponent(exitEdit))
                    .addGroup(editDialogLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dueDateField1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(taskDescriptionField1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priorityField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editDialogLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        editDialogLayout.setVerticalGroup(
            editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDialogLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(nameField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(taskDescriptionField1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dueDateField1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(editDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveEdit)
                    .addComponent(exitEdit))
                .addGap(58, 58, 58))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java To Do App");

        jScrollPane1.setViewportView(taskList);

        jScrollPane2.setViewportView(jScrollPane1);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        markButton.setText("Mark");
        markButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addGap(34, 34, 34)
                .addComponent(editButton)
                .addGap(36, 36, 36)
                .addComponent(markButton)
                .addGap(31, 31, 31)
                .addComponent(deleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(markButton))
                .addGap(15, 73, Short.MAX_VALUE))
        );

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        taskDescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskDescriptionFieldActionPerformed(evt);
            }
        });

        priorityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Task Description");

        jLabel3.setText("Due Date  (MM/dd/yyyy)");

        jLabel4.setText("Priority (Between 1-9)");

        menuFile.setText("File");

        fileSave.setText("Save");
        fileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveActionPerformed(evt);
            }
        });
        menuFile.add(fileSave);

        fileLoad.setText("Load");
        fileLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileLoadActionPerformed(evt);
            }
        });
        menuFile.add(fileLoad);

        fileExit.setText("Exit");
        menuFile.add(fileExit);

        jMenuBar1.add(menuFile);

        menuSort.setText("Edit");

        sortDueDate.setText("Sort by Due Date");
        sortDueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDueDateActionPerformed(evt);
            }
        });
        menuSort.add(sortDueDate);

        sortPriority.setText("Sort by Priority");
        sortPriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortPriorityActionPerformed(evt);
            }
        });
        menuSort.add(sortPriority);

        jMenuBar1.add(menuSort);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dueDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                                .addComponent(taskDescriptionField)
                                .addComponent(nameField))
                            .addComponent(priorityField, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 303, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(taskDescriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dueDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priorityField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveActionPerformed
     javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int userChoice = fileChooser.showSaveDialog(this);
        if (userChoice == javax.swing.JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getAbsolutePath();
            saveToFile(fileName);
        }
    }//GEN-LAST:event_fileSaveActionPerformed

    private void sortDueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDueDateActionPerformed
        sortByDueDate();
    }//GEN-LAST:event_sortDueDateActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    String taskName = nameField.getText();
    String taskDescription = taskDescriptionField.getText();
    String dueDate = dueDateField.getText();
    String priority = priorityField.getText();
    String complete = "No"; 

    if (!taskName.isEmpty()) {
        // Check if the dueDate is a valid date format
        if (isValidDateFormat(dueDate)) {
            // Check if priority is a number
            if (isValidPriority(priority)) {
                String task = "Task Name: " + taskName + ", Description: " + taskDescription + ", Due Date: " + dueDate + ", Priority: " + priority + ", Complete: " + complete;
                listModel.addElement(task);
                taskList.setModel(listModel);
            } else {
                // Show an error message or handle invalid priority
                JOptionPane.showMessageDialog(this, "Invalid Priority. Please enter a number between 1 and 9.");
            }
        } else {
            // Show an error message or handle invalid date format
            JOptionPane.showMessageDialog(this, "Invalid Due Date Format. Please use MM/dd/yyyy.");
        }
    }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       removeSelectedItem(); 
 
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void markButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markButtonActionPerformed
   toggleCompleteStatus();
    }//GEN-LAST:event_markButtonActionPerformed

    private void priorityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priorityFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void nameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameField1ActionPerformed

    private void priorityField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityField1ActionPerformed
     
    }//GEN-LAST:event_priorityField1ActionPerformed

    private void taskDescriptionField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskDescriptionField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskDescriptionField1ActionPerformed

    private void sortPriorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortPriorityActionPerformed
            sortByPriority();       
    }//GEN-LAST:event_sortPriorityActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        selectedIndex = taskList.getSelectedIndex(); // Get the selected item index
    if (selectedIndex != -1) {
        // Get the selected item from the listModel
        String selectedItem = listModel.get(selectedIndex);

        // Split the selected item into its components
        String[] parts = selectedItem.split(", ");
        String taskName = parts[0].substring(parts[0].indexOf("Task Name: ") + 11);
        String taskDescription = parts[1].substring(parts[1].indexOf("Description: ") + 13);
        String dueDate = parts[2].substring(parts[2].indexOf("Due Date: ") + 10);
        String priority = parts[3].substring(parts[3].indexOf("Priority: ") + 10, parts[3].indexOf("Priority: ") + 11);

        // Set the values in the editDialog's text fields
        nameField1.setText(taskName);
        taskDescriptionField1.setText(taskDescription);
        dueDateField1.setText(dueDate);
        priorityField1.setText(priority);

        // Display the editDialog
        editDialog.pack();
        editDialog.setLocationRelativeTo(this);
        editDialog.setVisible(true);
    }
    }//GEN-LAST:event_editButtonActionPerformed

    private void saveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditActionPerformed
     if (selectedIndex != -1) {
    String editedTaskName = nameField1.getText();
    String editedTaskDescription = taskDescriptionField1.getText();
    String editedDueDate = dueDateField1.getText();
    String editedPriority = priorityField1.getText();
    String complete = "No"; 

    // Check if the editedDueDate is a valid date format
    if (isValidDateFormat(editedDueDate)) {
        // Check if the editedPriority is a valid number
        if (isValidPriority(editedPriority)) {
            // Create the edited item string
            String editedItem = "Task Name: " + editedTaskName + ", Description: " + editedTaskDescription +
                    ", Due Date: " + editedDueDate + ", Priority: " + editedPriority + "Complete: " + complete;;

            // Update the selected item in listModel
            listModel.setElementAt(editedItem, selectedIndex);

            // Close the dialog
            editDialog.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Priority. Please enter a number between 1 and 9.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Invalid Due Date Format. Please use MM/dd/yyyy.");
    }
}
    }//GEN-LAST:event_saveEditActionPerformed

    private void fileLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileLoadActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int userChoice = fileChooser.showOpenDialog(this);
        if (userChoice == javax.swing.JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            String fileName = fileToLoad.getAbsolutePath();
            loadFromFile(fileName);
        }
    }//GEN-LAST:event_fileLoadActionPerformed

    private void dueDateField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueDateField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dueDateField1ActionPerformed

    private void taskDescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskDescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskDescriptionFieldActionPerformed
   

        public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new ToDoListAppGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dueDateField;
    private javax.swing.JTextField dueDateField1;
    private javax.swing.JButton editButton;
    private javax.swing.JDialog editDialog;
    private javax.swing.JButton exitEdit;
    private javax.swing.JMenuItem fileExit;
    private javax.swing.JMenuItem fileLoad;
    private javax.swing.JMenuItem fileSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JOptionPane jOptionPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton markButton;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuSort;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nameField1;
    private javax.swing.JTextField priorityField;
    private javax.swing.JTextField priorityField1;
    private javax.swing.JButton saveEdit;
    private javax.swing.JMenuItem sortDueDate;
    private javax.swing.JMenuItem sortPriority;
    private javax.swing.JTextField taskDescriptionField;
    private javax.swing.JTextField taskDescriptionField1;
    private javax.swing.JList<String> taskList;
    // End of variables declaration//GEN-END:variables
}


