import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel text;
    JButton b1,b2,b3,b4,b5,b6,exit;
    String pinnumber;


    Transactions(String pinnumber){
      
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 850);
        add(image);
        
        text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(215,270,700,35);
        image.add(text);
        
      
        b1 = new JButton("DEPOSIT");
        b1.setBounds(170,350,150,30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
      b2.setBounds(360,350,150,30);
      b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(170,390,150,30);
        b3.addActionListener(this);
        image.add(b3);
        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(360,390,150,30);
        b4.addActionListener(this);
        image.add(b4);
        b5 = new JButton("PIN CHANGE");
        b5.setBounds(170,430,150,30);
          b5.addActionListener(this);
        image.add(b5);
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(360,430,150,30);
        b6.addActionListener(this);
        image.add(b6);
        exit = new JButton("EXIT");
        exit.setBounds(360,470,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
  
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        } else if(ae.getSource() == b1){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);

        }else if(ae.getSource() == b2){
          setVisible(false);
          new Withdrawl(pinnumber).setVisible(true);

        }else if(ae.getSource() == b3){
          setVisible(false);
          new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == b6){
          setVisible(false);
          new BalanceEnquiry(pinnumber).setVisible(true);
        }
    

    }
    
    public static void main(String[] args){
    new Transactions("");//.setVisible(true);
    }
}