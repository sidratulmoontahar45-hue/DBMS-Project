
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel text;
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;

    Withdrawl (String pinnumber){
        this.pinnumber = pinnumber;

    setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 850);
        add(image);

        text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(215,270,700,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180,330,320,30);
        image.add(amount);


        withdraw = new JButton("Withdrawl");
        withdraw.setBounds(350,420,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(350,470,150,30);
        back.addActionListener(this);
        image.add(back);

          setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
          String number = amount.getText();
          Date date = new Date();
          if(number.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Withdraw Amount");

          }else{
            try{
            conn Conn = new conn();
            String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";

            Conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "TK "+number+" Withdraw Successfully");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
            System.out.println(e);
            }
          }

        }else if (ae.getSource() == back){
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
