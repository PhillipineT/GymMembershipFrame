package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.membership.Member;

/**
 *
 * @author MemaniV
 */
public class GymMembershipFrame extends JFrame {
    //panels
    private JPanel headingPnl;
    private JPanel clientPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractsPnl;
    private JPanel personalTrainerOptionPnl;
    private JPanel membershipPnl;
    private JPanel commentsPnl;
    private JPanel btnsPnl;
    private JPanel headingClientCombinedPnl;
    private JPanel membershipCommentsCombinedPnl;
    private JPanel mainPnl;
    
    //labels
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel personalTrainerLbl;
    private JLabel contractTypeLbl;
    
    //textfields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;
    
    //combobox
    private JComboBox genderComboBox;
    
    //radio buttons
    private JRadioButton monthToMonthRadBtn;
    private JRadioButton sixMonthsRadBtn;
    private JRadioButton annualRadBtn;
    
    //checkbox
    private JCheckBox personalTrainerChkBx;
    
    //buttongroup
    private ButtonGroup btnGrp;
    
    //textarea
    private JTextArea commentsArea;
    
    //scrollpane
    private JScrollPane scrollableTxtArea;
    
    //private button
    private JButton registerBtn;
    private JButton clearBtn;
    private JButton displayBtn;
    private JButton exitBtn;
    private JButton searchBtn;
    private JButton updateBtn;
    private JButton removeBtn;
    private JButton update;
    
    
          
    private ArrayList<Member> members;
    //construct the gui
    public GymMembershipFrame(){
        //set the frame
        setTitle("Gym membership");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
                
        members = new ArrayList<>();
        //create panels
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        clientPnl = new JPanel(new GridLayout(4,1,1,1));
        clientPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Client details"));
        
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        contractsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalTrainerOptionPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        membershipPnl = new JPanel(new GridLayout(2,1,1,1));
        membershipPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Contract options"));
        
        commentsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        btnsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headingClientCombinedPnl = new JPanel(new BorderLayout());
        membershipCommentsCombinedPnl = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());
        
        //create labels
        headingLbl = new JLabel("Membership Form");
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLbl.setForeground(Color.BLUE);
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        nameLbl = new JLabel("Name:       ");
        surnameLbl = new JLabel("Surname: ");
        idNoLbl = new JLabel("Id no:         ");
        genderLbl = new JLabel("Gender:     ");     
        contractTypeLbl = new JLabel("Type of contract: ");
        personalTrainerLbl = new JLabel("Select the checkbox if you need a personal trainer ");
        
        //create textfields
        nameTxtFld = new JTextField(10);
        surnameTxtFld = new JTextField(10);
        idNoTxtFld = new JTextField(10);
        
        //create combobox
        genderComboBox = new JComboBox();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");

        //create radio buttons
        monthToMonthRadBtn = new JRadioButton("Month-to-month");
        sixMonthsRadBtn = new JRadioButton("Six months");
        annualRadBtn = new JRadioButton("Annual");  
        
        //create csheck box
        personalTrainerChkBx = new JCheckBox();
        
        //create button group
        btnGrp = new ButtonGroup();
        btnGrp.add(monthToMonthRadBtn);
        btnGrp.add(sixMonthsRadBtn);
        btnGrp.add(annualRadBtn);
        
        //create text area
        commentsArea = new JTextArea(15,50);
        commentsArea.setEditable(false);
        commentsArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Member(s) details"));
        
        scrollableTxtArea = new JScrollPane(commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //create buttons 
        registerBtn = new JButton("REGISTER");
        registerBtn.addActionListener(new RegisterBtnListener());
               
        displayBtn = new JButton("DISPLAY MEMBERS");
        displayBtn.addActionListener(new DisplayBtnListener());
        
        clearBtn = new JButton("CLEAR");
        clearBtn.addActionListener(new ClearBtnListener());
        
        exitBtn = new JButton("EXIT");
        exitBtn.addActionListener(new ExitBtnListener());
        
        searchBtn = new JButton("SEARCH");
        searchBtn.addActionListener(new SearchBtnListener());
        
        update = new JButton("UPDATE");
        update.addActionListener(new UpdateBtbListener());
        
        //add components to panels
        headingPnl.add(headingLbl); //--> first collective panel
        
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        
        idNoPnl.add(idNoLbl);
        idNoPnl.add(idNoTxtFld);
        
        genderPnl.add(genderLbl);
        genderPnl.add(genderComboBox);
        
        clientPnl.add(namePnl); //---> second collective panel
        clientPnl.add(surnamePnl);
        clientPnl.add(idNoPnl);
        clientPnl.add(genderPnl);
        
        headingClientCombinedPnl.add(headingPnl, BorderLayout.NORTH);
        headingClientCombinedPnl.add(clientPnl, BorderLayout.CENTER);
        
        contractsPnl.add(contractTypeLbl);
        contractsPnl.add(monthToMonthRadBtn); //---> third collective panel
        contractsPnl.add(sixMonthsRadBtn);
        contractsPnl.add(annualRadBtn);
        
        personalTrainerOptionPnl.add(personalTrainerLbl);
        personalTrainerOptionPnl.add(personalTrainerChkBx);
        
        membershipPnl.add(contractsPnl);
        membershipPnl.add(personalTrainerOptionPnl);
        
        commentsPnl.add(scrollableTxtArea); //---> fourth collective panel
        
        membershipCommentsCombinedPnl.add(membershipPnl, BorderLayout.NORTH);
        membershipCommentsCombinedPnl.add(commentsPnl, BorderLayout.CENTER);
        
        btnsPnl.add(registerBtn); //--> fifth colelctive panel
        btnsPnl.add(searchBtn);
        btnsPnl.add(update);
        btnsPnl.add(displayBtn);
        btnsPnl.add(clearBtn);
        btnsPnl.add(exitBtn);
        
                
        mainPnl.add(headingClientCombinedPnl, BorderLayout.NORTH);
        mainPnl.add(membershipCommentsCombinedPnl, BorderLayout.CENTER);
        mainPnl.add(btnsPnl, BorderLayout.SOUTH);
        
        add(mainPnl);
      
        pack();
        
        setResizable(false);
        
        setVisible(true);
    }
    
    //helper method for clearing fields
    private void clearFields(){
        nameTxtFld.setText("");
        surnameTxtFld.setText("");
        idNoTxtFld.setText("");
        personalTrainerChkBx.setSelected(false);
        btnGrp.clearSelection();
        commentsArea.setText("");
        
        nameTxtFld.setFocusable(true);
    }
    
    //anonymous class for registering a member. It handles the REGISTER button.
    private class RegisterBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {      
            //write source code here to accomplish the task
            String name,surname,idNo,gender,contractType;
            boolean isPersonalTrainerNeeded;
            
            name = nameTxtFld.getText();
            surname = surnameTxtFld.getText();
            idNo = idNoTxtFld.getText();
            gender = (String) genderComboBox.getSelectedItem();
            isPersonalTrainerNeeded = personalTrainerChkBx.isSelected();
            contractType = "";
            
            if(monthToMonthRadBtn.isSelected()){
                contractType = "Month-to-month";
            }else if(sixMonthsRadBtn.isSelected()){
                contractType = "Six mpnths";
            }else if(annualRadBtn.isSelected()){
                contractType = "Annual";
            }
            Member member = new Member(name, surname, idNo, gender, contractType, isPersonalTrainerNeeded);
            members.add(member);
            
            commentsArea.setText("Successful registered the member");
        }
    }
    
    private class ClearBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            clearFields();
        }
    }

    //anonymous class for exiting the application. It handles the EXIT button.    
    private class ExitBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //write source code here to accomplish the task
            System.exit(0);
        }
    }
    public class SearchBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String idNo = JOptionPane.showInputDialog("Enter the id no of member to search:");
            
            if(idNo != null && !idNo.isEmpty()){
                for (Member member : members) {
                    if(member.getIdNo().equals(idNo)){
                       commentsArea.setText(String.format(
                       "Name: %s\nSurname: %s\nID No: %s\nGender: %s\nContract Type: %s\nPersonal Trainer: %s\n",
                        member.getName(),member.getSurname(),member.getIdNo(),member.getGender(),member.getContractType(),member.getIsPersonalTrainerNeeded()));
                        
                       return;
                    }
                }
                 commentsArea.setText("Member with ID " +idNo+ " not found.");

            }
            else{
                commentsArea.setText("No ID provided.");
            }
        }
    }
    public class UpdateBtbListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String idNo = JOptionPane.showInputDialog("Enter ID No for memver to update: ");
            
            if(idNo != null && !idNo.isEmpty()){
                for (Member member : members) {
                    if(member.getIdNo().equals(idNo)){
                        // Load member data into text fields for editing
                        nameTxtFld.setText(member.getName());
                        surnameTxtFld.setText(member.getSurname());
                        idNoTxtFld.setText(member.getIdNo());
                        genderComboBox.setSelectedItem(member.getGender());
                        personalTrainerChkBx.setSelected(member.getIsPersonalTrainerNeeded());
                        if(member.getContractType().equals("Month-to-month")){
                            monthToMonthRadBtn.setSelected(true);
                        }else if (member.getContractType().equals("Six months")){
                            sixMonthsRadBtn.setSelected(true);
                        }else if (member.getContractType().equals("Annual")){
                            annualRadBtn.setSelected(true);
                        
                        }
                        JOptionPane.showMessageDialog(null, "Update the details and click REGISTER to save changes.");
                        return;
                    }
                }
                    commentsArea.setText("Member with ID " +idNo + " not found");
            }else{
                commentsArea.setText("No ID provided.");
            }
        }
        
    }
    public static void main(String[] args){
        new GymMembershipFrame();
    }

}


