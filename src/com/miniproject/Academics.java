package com.miniproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Academics extends JFrame implements ActionListener{

	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextArea tf;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
	JButton b1,b2;
	
	Academics(){
		JFrame f1=new JFrame("Student Personal Details");
		JPanel p1=new JPanel();
		
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
		
		JButton b1=new JButton("View");
		JButton b2=new JButton("Back");
		
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
		f1.add(p1);
		
		
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		
		tf6.setEditable(false);
		tf7.setEditable(false);
		tf8.setEditable(false);
		tf9.setEditable(false);
		tf.setEditable(false);
		tf10.setEditable(false);
		tf11.setEditable(false);
		f1.setVisible(true);
		f1.setBounds( 240, 150,890,300);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			
						try {
							String studentid=tf1.getText();
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
							
									PreparedStatement st=con.prepareStatement("select * from personal where sid=?");
							st.setString(1, studentid);
							ResultSet rs=st.executeQuery();
							if(rs.next()) {
								String studentname=rs.getString(2);
								String level=rs.getString(3);
								String email=rs.getString(4);
								String gender=rs.getString(5);
								String dob=rs.getString(6);
								String fathername=rs.getString(7);
								String mothername=rs.getString(8);
								String phone=rs.getString(9);
							
								String address=rs.getString(10);
								String city=rs.getString(11);
								String state=rs.getString(12);
								
								tf2.setText(studentname);
								tf3.setText(level);
								tf4.setText(email);
								tf5.setText(gender);
								tf6.setText(dob);
								tf7.setText(fathername);
								tf8.setText(mothername);
								tf9.setText(phone);
								tf.setText(address);
								tf10.setText(city);
								tf11.setText(state);
								
							}
							else{
								JOptionPane.showMessageDialog(null," ID not found");
							}
						}
							catch(Exception ae)
							{
								ae.printStackTrace();							
								}
							
					
						};
				});
		
		
		
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f1.dispose();
				JOptionPane.showMessageDialog(b2,"Welcome Back to Menu Page");
				Menu n=new  Menu();
				
				
			}
		
				
				
		});
	}
	
	public static void main(String[] args) {
		
new Academics();
	}




	
	public void actionPerformed(ActionEvent e) {
		
		
	}
}