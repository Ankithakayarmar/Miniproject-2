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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class New extends JFrame implements ActionListener{
	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5;
	JTextArea tf4;
	JTextField tf1,tf2,tf3,tf5,tf;
	
	
	JButton b1,b2,b3,b4;
	
	 New(){
		 JFrame f1=new JFrame("Register New Student");
		
		 JPanel p1=new JPanel();
			JLabel l1=new JLabel("First name:");
		
			JLabel l2=new JLabel("Last name:");
			JLabel l3=new JLabel("Gender:");
			JLabel l4=new JLabel("Date Of Birth:");
			
		
			JLabel l5=new JLabel("Contact Number:");
			JLabel l6=new JLabel("Address:");
			
			
			
			JTextField tf1=new JTextField("",13);
			
			
			JTextField tf2=new JTextField("",13);
			
			
			JTextField tf=new JTextField("",13);
			JTextField tf3=new JTextField("",13);
			JTextField tf5=new JTextField("",13);
			JTextArea tf4=new JTextArea("",5,15);
			JButton b1=new JButton("Register");
			JButton b2=new JButton("Reset");
			JButton b3=new JButton("View");
			JButton b4=new JButton("Back");
			
			
			p1.add(l1);p1.add(tf1);
			
			p1.add(l2);p1.add(tf2);	

			p1.add(l3);p1.add(tf5);
			p1.add(l4);p1.add(tf);

			p1.add(l5);p1.add(tf3);
			p1.add(l6);p1.add(tf4);
			p1.add(b1);
			p1.add(b2);
			p1.add(b3);
			p1.add(b4);
		
			f1.add(p1);
			f1.setVisible(true);
			f1.setBounds( 350, 150,500,400);
			
			

			b1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						String firstname=tf1.getText();
						String lastname=tf2.getText();
						String gender=tf5.getText();
						String dob=tf.getText();
						String contact=tf3.getText();
						int len=contact.length();
						String address=tf4.getText();
						String msg="" +firstname;
						msg=" \n";
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
						String query="Insert into register values('" + firstname +"','" +lastname +"','" +gender +"','" +dob +"','" +contact +"','" +address +"')";
						Statement st=con.createStatement();
						int x=st.executeUpdate(query);
						String msg1="" +firstname;
						msg1=" \n";
						if(x==0) {
							JOptionPane.showMessageDialog(b1, "already exist");
						}
						else if(firstname.equals("")) {
							JOptionPane.showMessageDialog(tf1,"Firstname required");
						}
						else if(lastname.equals("")) {
							JOptionPane.showMessageDialog(tf2,"Lastname required");
						}
						else if(gender.equals("")) {
							JOptionPane.showMessageDialog(tf5,"gender field cannot be empty");
						}
						else if(dob.equals("") ){
							JOptionPane.showMessageDialog(tf,"DOB required");
						}
						else if(len!=10) {
							JOptionPane.showMessageDialog(tf3, "Enter valid phone number");
						}
						
						else if(address.equals("")) {
							JOptionPane.showMessageDialog(tf4,"address required");
						}
						else {
							JOptionPane.showMessageDialog(b1, "Welcome, "  +msg1+"Your records are successfully created");
						}
			
			con.close();
			
			
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
						}

			});	
	 
	 
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String firstname=tf1.getText();
					String lastname=tf2.getText();
					String gender=tf5.getText();
					
					String dob=tf.getText();
					String contact=tf3.getText();
					
					String address=tf4.getText();
					
					if(firstname!=null && lastname!=null ) {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
									Statement st=con.createStatement();
							ResultSet rs=st.executeQuery("select * from register");
							
							
							while(rs.next()) {
								System.out.println("firstname: " + rs.getString(1)+"\n" +  "lastname:"+rs.getString(2)+"\n" + "gender:" + rs.getString(3)+"\n" + "dob:" + rs.getString(4)+"\n" +
										"contact:" + rs.getString(5)+"\n"+"address:" + rs.getString(6)+"\n");
							
							}}
							catch(Exception ae)
							{
								ae.printStackTrace();							
								}
							
					
						}
					
					
				}	
			
			});

		b2.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				tf1.setText(null);
				tf2.setText(null);
				tf5.setText(null);
				tf.setText(null);
				tf3.setText(null);
				tf4.setText(null);
			}
				});
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f1.dispose();
				JOptionPane.showMessageDialog(b4,"Welcome Back to Menu Page");
				Menu n=new  Menu();
				
				
			}
		
				
				
		});
		
	 }
	 		
	 
	public static void main(String[] args) {
		
	new New();
	
	
	}


	public void actionPerformed1(ActionEvent e ) {
		
		
	
	}





public void actionPerformed(ActionEvent e) {
	
	
}
}



