package com.miniproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Miniproject extends JFrame implements ActionListener{
	
	JFrame f1;
	JPanel p1;
	JLabel l1;
	JPasswordField l2;
	JTextField tf1,tf2;
	JButton b1,b2;
	
	Miniproject(){
	JFrame f1=new JFrame("Login Form");
	JPanel p1=new JPanel();
	JLabel l1=new JLabel("Username:");
	JLabel l2=new JLabel("Password:");
	JTextField tf1=new JTextField("",15);
	JPasswordField tf2=new JPasswordField("",15);
	JButton b1=new JButton("Login");
	JButton b2=new JButton("Cancel");
	p1.add(l1);
	p1.add(tf1);

	p1.add(l2);
	p1.add(tf2);
	p1.add(b1);
	p1.add(b2);
	f1.add(p1);
	p1.setBorder(new LineBorder(new Color(153,204,225)));
	p1.setBackground(new Color(176,224,230));
	p1.setBounds(10, 11, 700, 332);
	f1.setSize(560,250);
	f1.setVisible(true);
	f1.setBounds(500, 180, 560, 250);
	
	
	
	b1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
			
				try {
					String s1=tf1.getText();
					String s2=tf2.getText();
					
					if(s1.equals("Ankitha") && s2.equals("1234")) {
						System.out.println("Login Successful");
						f1.dispose();
						Menu m=new Menu();
					
						}
					else if(s1.equals("") ) {
						System.out.println("Please provide Username");
						
					}else if(s2.equals("")) {
						System.out.println("Please provide Password");
						
					}
					
					else {
						System.out.println("Invalid Username/Password");
					
				}
					
				}
					
				
				
				catch(Exception ex)
				{
					ex.printStackTrace();	
					}
			}

			
			
	});
	
	
	b2.addActionListener(new ActionListener() {
		

		public void actionPerformed(ActionEvent e) {
			tf1.setText(null);
			tf2.setText(null);
		}
			});
			
	}
	public static void main(String[] args) {

		new Miniproject();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

}
	}
			










	


