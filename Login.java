
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

      JButton login, clear,signup;
      JTextField cardtextField;
      JPasswordField pintextField;

      Login(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
      Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel label = new JLabel(i3);
      label.setBounds(70,10,100,100);
      add(label);


      JLabel text = new JLabel("Welcome to ATM");
      text.setFont(new Font("Osward",Font.BOLD,38));
      text.setBounds(200,40,400,40);
      add(text);

      JLabel cardno = new JLabel("Card NO:");
      cardno.setFont(new Font("Raleway",Font.BOLD,28));
      cardno.setBounds(120,150,150,30);
      add(cardno);

      cardtextField = new JTextField();
      cardtextField.setBounds(280,150,250,30);
      add(cardtextField);

      JLabel pin = new JLabel("PIN:");
      pin.setFont(new Font("Raleway",Font.BOLD,28));
      pin.setBounds(120,220,250,40);
      add(pin);

        pintextField = new JPasswordField();
      pintextField.setBounds(280,220,250,30);
      add(pintextField);


        login = new JButton("SIGN IN");
      login.setBounds(280,300,100,30);
      login.setBackground(Color.BLACK);
      login.setForeground(Color.WHITE);
      add(login);
      login.addActionListener(this);

        clear = new JButton("CLEAR");
      clear.setBounds(420,300,100,30);
      clear.setBackground(Color.BLACK);
      clear.setForeground(Color.WHITE);
      add(clear);
      clear.addActionListener(this);

        signup = new JButton("SIGN UP");
      signup.setBounds(280,350,250,30);
      signup.setBackground(Color.BLACK);
      signup.setForeground(Color.WHITE);
      add(signup);
      signup.addActionListener(this);
      

      getContentPane().setBackground(Color.WHITE);

        setSize(700,480);
        setVisible(true);
        setLocation(350,200);
      }

        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
        cardtextField.setText("");
        pintextField.setText("");

        }else if(e.getSource() == login){
            conn Conn = new conn();
            String cardnumber = cardtextField.getText();
            String pinnumber = pintextField.getText();
           String query = "SELECT * FROM login WHERE cardnumber = '"+cardnumber+"' AND pinnumber = '"+pinnumber+"'";


          try{
          ResultSet rs = Conn.s.executeQuery(query);
          if(rs.next()){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
          }else{
            JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
          }

          }
          catch(Exception ae){
        System.out.println(ae);
          }

        }else if(e.getSource() == signup){
            setVisible(false);
            new signup1().setVisible(true);

        }


        
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        new Login();
    }

    
}
