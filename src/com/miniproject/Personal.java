package com.miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Personal extends JFrame implements ActionListener{
	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextArea tf;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
	
	JButton b1,b2,b3,b4;
	
	Personal(){
		
	
		JFrame f1=new JFrame("Student Personal Details");
		JPanel p1=new JPanel();
		JTable j=new JTable();
		JLabel l1=new JLabel("Student ID:");
		JLabel l2=new JLabel("StudentName:");
		JLabel l3=new JLabel("Class:");
		JLabel l4=new JLabel("Email-ID:");
		JLabel l5=new JLabel("Gender:");
		JLabel l6=new JLabel("DOB:");
		JLabel l7=new JLabel("FatherName:");
		JLabel l8=new JLabel("MotherName:");
		JLabel l9=new JLabel("PhoneNumber:");
		JLabel l10=new JLabel("Address:");
		JLabel l11=new JLabel("City:");
		JLabel l12=new JLabel("State:");
		
		
		JTextField tf1=new JTextField("",13);
		JTextField tf2=new JTextField("",13);
		JTextField tf3=new JTextField("",13);
		JTextField tf4=new JTextField("",13);
		JTextField tf5=new JTextField("",13);
		JTextField tf6=new JTextField("",13);
		JTextField tf7=new JTextField("",13);
		JTextField tf8=new JTextField("",13);
		JTextField tf9=new JTextField("",13);
		JTextArea tf=new JTextArea("",5,13);
		JTextField tf10=new JTextField("",13);
		JTextField tf11=new JTextField("",13);
		
		
		
		JButton b1=new JButton("Save");
		JButton b2=new JButton("Reset");
		JButton b3=new JButton("View");
		
		JButton b4=new JButton("Back");

		p1.add(l1);p1.add(tf1);
		p1.add(l2);p1.add(tf2);	
		p1.add(l3);p1.add(tf3);
		p1.add(l4);p1.add(tf4);
		p1.add(l5);p1.add(tf5);
		p1.add(l6);p1.add(tf6);
		p1.add(l7);p1.add(tf7);
		p1.add(l8);p1.add(tf8);
		p1.add(l9);p1.add(tf9);
		p1.add(l10);p1.add(tf);
		p1.add(l11);p1.add(tf10);
		p1.add(l12);p1.add(tf11);
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		p1.add(b4);
		f1.add(p1);
		f1.setVisible(true);
		f1.setBounds( 250, 50,880,400);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			
				String studentid=tf1.getText();
				
				String studentname=tf2.getText();
				String level=tf3.getText();
				String email=tf4.getText();
				String gender=tf5.getText();
				String dob=tf6.getText();
				String fathername=tf7.getText();
				String mothername=tf8.getText();
				String phone=tf9.getText();
				int len=phone.length();
				String address=tf.getText();
				String city=tf10.getText();
				String state=tf11.getText();
		
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
					
					
					String query="Insert into personal values('" + studentid +"','" +studentname +"','" +level +"','" +email +"','" +gender +"','" +dob +"','" +fathername +"','" +mothername +"','" +phone +"','" +address +"','" +city +"','" +state +"')";
					Statement st=con.createStatement();
					
					int x=st.executeUpdate(query);
					String msg="" +studentid;
					msg=" \n";
				
					if(x==0) {
						JOptionPane.showMessageDialog(b1, "already exist");
					}
					
					else if(studentid.equals("")){
						
						JOptionPane.showMessageDialog(tf1,"ID required ");
						
					}
					else if(studentname.equals("")) {
						JOptionPane.showMessageDialog(tf2,"name required");
						
					}
					else if(level.equals("")) {
						JOptionPane.showMessageDialog(tf3,"Class required");
					}
					else if(email.equals("")) {
						JOptionPane.showMessageDialog(tf4,"Email-ID required");
					}
					else if(gender.equals("")) {
						JOptionPane.showMessageDialog(tf5,"gender required");
					}
					else if(dob.equals("")) {
						JOptionPane.showMessageDialog(tf6,"Date of birth required");
					}
					else if(fathername.equals("")) {
						JOptionPane.showMessageDialog(tf7,"Fathername required");
					}
					else if(mothername.equals("")) {
						JOptionPane.showMessageDialog(tf8,"Mothername required");
					}
					else if(phone.equals("")) {
						JOptionPane.showMessageDialog(tf9,"Number required");
					}
					else if(len!=10) {
						JOptionPane.showMessageDialog(tf3, "Enter valid phone number");
					}
					else if(address.equals("")) {
						JOptionPane.showMessageDialog(tf,"address required");
					}
					else if(city.equals("")) {
						JOptionPane.showMessageDialog(tf10,"city name required");
					}
					else if(state.equals("")) {
						JOptionPane.showMessageDialog(tf11," state name required");
					}
					
					else{
						JOptionPane.showMessageDialog(b1, "Welcome, " +msg+ "Your records are successfully created");
					}
				
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
		});	
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
					
			

				String studentid1=tf1.getText();
				String studentname=tf2.getText();
				String level=tf3.getText();
				String email=tf4.getText();
				String gender=tf5.getText();
				String dob=tf6.getText();
				String fathername=tf7.getText();
				String mothername=tf8.getText();
				String phone=tf9.getText();
			
				String address=tf.getText();
				String city=tf10.getText();
				String state=tf11.getText();
		
				if(studentid1!=null && studentname!=null ) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
								Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from personal");
						
						
						while(rs.next()) {
							System.out.println("studentid: " + rs.getInt(1)+"\n" +  "studentname:"+rs.getString(2)+"\n" + "level:" + rs.getString(3)+"\n" + "email:" + rs.getString(4)+"\n" +
									"gender:" + rs.getString(5)+"\n" +"dob:" + rs.getString(6)+"\n" + "fathername:" + rs.getString(7)+"\n"+ "mothername:" + rs.getString(8)+"\n" +"phone:" + rs.getString(9)+"\n" +"address:" + rs.getString(10)+"\n "+ "city:" + rs.getString(11)+"\n"+ "state:" + rs.getString(12)+"\n");
						
						}}
						catch(Exception ae)
						{
							ae.printStackTrace();							}
						
				
					}
				
				
			}	
	}
		);

	b2.addActionListener(new ActionListener() {
		

		public void actionPerformed(ActionEvent e) {
			tf1.setText(null);
			tf2.setText(null);
			tf3.setText(null);
			tf4.setText(null);
			tf5.setText(null);
			tf6.setText(null);
			tf7.setText(null);
			tf8.setText(null);
			tf9.setText(null);
			tf.setText(null);
			
			tf10.setText(null);
			tf11.setText(null);
			
		}
			});

	
		
	b4.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			f1.dispose();
			JOptionPane.showMessageDialog(b4,"Welcome Back to Menu Page");
			Menu n=new  Menu();
			
			
		}
	}
			
			
		);
	
	
		
	}
	public static void main(String[] args) {
	new	Personal();

	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
