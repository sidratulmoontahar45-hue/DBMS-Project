
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signup1 extends JFrame implements ActionListener {

long random;
JTextField nametextfield,fnametextfield,gmailtextfield,
            addresstextfield,citytextfield,statetextfield,
            pincodetextfield;
            JButton next;
            JRadioButton male,female,married,unmarried,other;
            JDateChooser dateofbirth;

    signup1(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+ 1000L);

        JLabel fromno = new JLabel("APPLICATION FORM NO: "+random);
        fromno.setFont(new Font("Raleway",Font.BOLD,38));
        fromno.setBounds(140,20,600,40);
        add(fromno);

        JLabel personaldetails = new JLabel("page 1: personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(250,80,400,30);
        add(personaldetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nametextfield = new JTextField();
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        JLabel Fname = new JLabel("Father's Name:");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,200,30);
        add(Fname);

        fnametextfield = new JTextField();
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fnametextfield.setBounds(300,190,400,30);
        add(fnametextfield);

        JLabel Birth = new JLabel("Date of Birth:");
        Birth .setFont(new Font("Raleway",Font.BOLD,20));
        Birth .setBounds(100,240,200,30);
        add(Birth );

        dateofbirth = new JDateChooser();
        dateofbirth.setBounds(300,240,400,30);
        add(dateofbirth);


        JLabel gender = new JLabel("Gender:");
        gender .setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender );

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        

      JLabel gmail = new JLabel("Email Address:");
      gmail.setFont(new Font("Raleway",Font.BOLD,20));
        gmail.setBounds(100,340,200,30);
        add(gmail );

        gmailtextfield = new JTextField();
        gmailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        gmailtextfield.setBounds(300,340,400,30);
        add(gmailtextfield);

        JLabel maritalstatas= new JLabel("Marital Status:");
        maritalstatas.setFont(new Font("Raleway",Font.BOLD,20));
        maritalstatas.setBounds(100,390,200,30);
        add(maritalstatas);

          married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addresstextfield = new JTextField();
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);

        JLabel city = new JLabel("City:");
        city .setFont(new Font("Raleway",Font.BOLD,20));
        city .setBounds(100,490,200,30);
        add(city );

        citytextfield = new JTextField();
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        statetextfield = new JTextField();
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);

        JLabel pincode = new JLabel("pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodetextfield = new JTextField();
        pincodetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pincodetextfield.setBounds(300,590,400,30);
        add(pincodetextfield);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(600,660,100,30);
        next.addActionListener(this);
        add(next);

      getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        String formno = ""+random;
        String name = nametextfield.getText();
          String fname = fnametextfield.getText();
          String birth = ((JTextField) dateofbirth.getDateEditor().getUiComponent()).getText();
          
          String gender = null;
          if (male.isSelected()){
            gender = "Male";
          }else if(female.isSelected()){
            gender = "Female";
          }

          String gmail = gmailtextfield.getText();
        
          String marrital = null;
          if(married.isSelected()){
            marrital = "Married";
          }else if(unmarried.isSelected()){
            marrital = "Unmarride";
          }else if(other.isSelected()){
            marrital = "Other";
          }

          String address = addresstextfield.getText();
          String city = citytextfield.getText();
          String state = statetextfield.getText();
          String pincode = pincodetextfield.getText();

          try{
            if(name.equals("")){
              JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
            conn c = new conn();
            String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+birth+"','"+gender+"','"+gmail+"','"+marrital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signup2(formno).setVisible(true);

          }
          }
        catch(Exception ae){
        System.out.println(ae);
          }
    }


    public static void main(String[] args) {
        new signup1();
        
    }
    
}
