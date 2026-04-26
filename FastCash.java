import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JLabel text;
    JButton b1,b2,b3,b4,b5,b6,exit;
    String pinnumber;


    FastCash(String pinnumber){
      
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 850);
        add(image);
        
        text = new JLabel("Select Withdral Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(215,270,700,35);
        image.add(text);
        
    
        b1 = new JButton("TK 500");
        b1.setBounds(170,350,150,30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("TK 1000");
      b2.setBounds(360,350,150,30);
      b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("TK 2000");
        b3.setBounds(170,390,150,30);
        b3.addActionListener(this);
        image.add(b3);
        b4 = new JButton("TK 5000");
        b4.setBounds(360,390,150,30);
        b4.addActionListener(this);
        image.add(b4);
        b5 = new JButton("TK 10000");
        b5.setBounds(170,430,150,30);
          b5.addActionListener(this);
        image.add(b5);
        b6 = new JButton("TK 20000");
        b6.setBounds(360,430,150,30);
        b6.addActionListener(this);
        image.add(b6);
        exit = new JButton("BACK");
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
          setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn Conn = new conn();

            try{
             ResultSet rs = Conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){

                  if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                  }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                  }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null,"Insufficient balance");
                  return;
                }
              Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                Conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "TK. "+amount+" Debited Successfully");
                setVisible(false);
          new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
              System.out.println(e);
            }
        }
    
    }
    
    public static void main(String[] args){
    new FastCash("");//.setVisible(true);
    }
}