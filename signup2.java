
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class signup2 extends JFrame implements ActionListener {

long random;
            JTextField nid;
            JButton next;
            JRadioButton syes,sno,eyes,eno;
            
            JComboBox religion,category,income,education,occupation;

            String fromno;

    signup2(String fromno){
      this.fromno = fromno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // Random ran = new Random();
        //  random = Math.abs((ran.nextLong()%9000L)+ 1000L);
        

        JLabel additionaldetails = new JLabel("page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(250,80,400,30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

      String arr[] = {"Muslim","Hindu","Christain","Other"};
        religion = new JComboBox(arr);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,140,400,30);
        add(religion);


        JLabel Fname = new JLabel("Category:");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,200,30);
        add(Fname);

        String arr1[] = {"General","OBC","SC","ST","Others"};
        category = new JComboBox(arr1);
        category.setBackground(Color.WHITE);
        category.setBounds(300,190,400,30);
        add(category);


        JLabel Birth = new JLabel("Income:");
        Birth .setFont(new Font("Raleway",Font.BOLD,20));
        Birth .setBounds(100,240,200,30);
        add(Birth );

        String arr2[] = {"< 50,000","< 1,50,000","< 2,50,000","Upto 10,00,000","Null"};
        income = new JComboBox(arr2);
        income.setBackground(Color.WHITE);
        income.setBounds(300,240,400,30);
        add(income);


        JLabel city = new JLabel("Education:");
        city .setFont(new Font("Raleway",Font.BOLD,20));
        city .setBounds(100,290,200,30);
        add(city );

        String arr3[] = {"Non Graduate","Graduate","HSC","SSC","Others"};
        education = new JComboBox(arr3);
        education.setBackground(Color.WHITE);
        education.setBounds(300,290,400,30);
        add(education);

        

        JLabel gmail = new JLabel("Occupation:");
      gmail.setFont(new Font("Raleway",Font.BOLD,20));
        gmail.setBounds(100,340,200,30);
        add(gmail );

        String arr4[] = {"Salaried","Self Employed","Business","Student","Others"};
        occupation = new JComboBox(arr4);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,340,400,30);
        add(occupation);


        JLabel address= new JLabel("NID Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,390,200,30);
        add(address);

        nid = new JTextField();
        nid.setFont(new Font("Raleway",Font.BOLD,14));
        nid.setBounds(300,390,400,30);
        add(nid);


        
        JLabel gender = new JLabel("Senior Citizen:");
        gender .setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,450,200,30);
        add(gender );

        syes = new JRadioButton("Yes");
        syes.setBounds(300,450,60,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450,450,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(syes);
        gendergroup.add(sno);



        JLabel maritalstatas= new JLabel("Existing Account:");
        maritalstatas.setFont(new Font("Raleway",Font.BOLD,20));
        maritalstatas.setBounds(100,510,200,30);
        add(maritalstatas);

          eyes = new JRadioButton("Yes");
        eyes.setBounds(300,510,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450,510,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(eyes);
        maritalgroup.add(eno);
      

        

      
        
        //  JLabel state = new JLabel("State:");
        // state.setFont(new Font("Raleway",Font.BOLD,20));
        // state.setBounds(100,540,200,30);
        // add(state);

        // statetextfield = new JTextField();
        // statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        // statetextfield.setBounds(300,540,400,30);
        // add(statetextfield);

        

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
        String sreligion = (String)religion.getSelectedItem();
          String scategory = (String)category.getSelectedItem();
          String sincome = (String)income.getSelectedItem();
          String seducation = (String)education.getSelectedItem();
          String soccupation = (String)occupation.getSelectedItem();
          

          String SC = null;
          if (syes.isSelected()){
            SC = "YES";
          }else if(sno.isSelected()){
            SC = "NO";
          }

          
      
          String EX = null;
          if(eyes.isSelected()){
            EX = "Married";
          }else if(eno.isSelected()){
          EX = "Unmarride";
          }

          String snid = nid.getText();
        

          try{
          
            conn c = new conn();
            String query = "insert into signuptow values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+snid+"','"+SC+"','"+EX+"')";
            c.s.executeUpdate(query);
          
            setVisible(false);
            new signup3(fromno).setVisible(true);
          }
          catch(Exception ae){
        System.out.println(ae);
          }
    }


    public static void main(String[] args) {
        new signup2("");
        
    }
    
}
