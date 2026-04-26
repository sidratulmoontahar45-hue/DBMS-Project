
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle;

    String fromno;

        signup3(String fromno){
            this.fromno = fromno;

    setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");


        JLabel additionaldetails = new JLabel("page 3: Account Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(250,70,400,30);
        add(additionaldetails);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r2 = new JRadioButton("Saving Account");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(300,140,200,14);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(530,140,200,20);
        add(r3);

        r1 = new JRadioButton("Current Account");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(300,180,200,20);
        add(r1);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(530,180,200,20);
        add(r4);

        ButtonGroup gaccount = new ButtonGroup();
        gaccount.add(r1);
        gaccount.add(r2);
        gaccount.add(r3);
        gaccount.add(r4);


        JLabel card = new JLabel("Card Number");
        card .setFont(new Font("Raleway",Font.BOLD,22));
        card .setBounds(100,230,200,30);
        add(card );

        JLabel number = new JLabel("XXXX-XXXX-XXXX-XX21");
        number .setFont(new Font("Raleway",Font.BOLD,14));
        number .setBounds(330,230,300,30);
        add(number);


        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,290,200,30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,14));
        pnumber.setBounds(330,290,100,30);
        add(pnumber);


        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,350,200,30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,400,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,400,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,450,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,450,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,500,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,500,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,550,600,20);
        add(c7);


        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,610,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancle = new JButton("Cancel");
        cancle.setFont(new Font("Raleway", Font.BOLD, 14));
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setBounds(420,610,100,30);
        cancle.addActionListener(this);
        add(cancle);

        getContentPane().setBackground(Color.WHITE);


            setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
        String atype = null;
        if(r1.isSelected()){ 
            atype = "Saving Account";
        }else if(r2.isSelected()){ 
            atype = "Fixed Deposit Account";
        }else if(r3.isSelected()){ 
            atype = "Current Account";
        }else if(r4.isSelected()){ 
            atype = "Recurring Deposit Account";
        }

        Random random = new Random();
        String cardnumber = "" + Math.abs(random.nextLong() % 90000000L + 5040936000000000L);
        String pinnumber = "" + Math.abs(random.nextLong() % 9000L + 1000L);


        String facility = "";
        if(c1.isSelected()){
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){
            facility = facility + " E-Statement";
        }


        try{
        if(atype.equals("")){
            JOptionPane.showMessageDialog(null,"Account type is Required");
        }else{
            conn Conn = new conn(); 
            String query1 = "insert into signupthree values('"+fromno+"','"+atype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
            String query2 = "insert into login values('"+fromno+"','"+cardnumber+"','"+pinnumber+"')";
            Conn.s.executeUpdate(query1);
            Conn.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:"+ pinnumber);
                    
                
            setVisible(false);
            new Deposit(pinnumber).setVisible(false);
        }
        }
        catch(Exception e){
            System.out.println(e);
        }

        }else if(ae.getSource() == cancle){
        setVisible(false);
        new Login().setVisible(true);

        }
        
        }

    public static void main(String[] args) {
        new signup3("");
    }
    
}
