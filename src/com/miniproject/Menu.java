package com.miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	JFrame f2;
	JPanel p2;
	JButton b3,b5,b6,b4,b7;
	
	Menu(){
	JFrame f2=new JFrame("Menu");
	
	JPanel p2=new JPanel();
		JButton b3=new JButton("Register New Student");
		
		JButton b5=new JButton(" Register Student Personal Details");
		JButton b6=new JButton(" View Student Personal Records");
		JButton b4=new JButton("Academic Details");
		
		JButton b7=new JButton("Logout");
		
		p2.add(b3);
		
		p2.add(b5);
		p2.add(b6);
		p2.add(b4);
		p2.add(b7);
		
		f2.add(p2);
		
		f2.setVisible(true);
		f2.setBounds(300, 180, 860, 250);
		
		
		
		
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				JOptionPane.showMessageDialog(b3, "Welcome to Register New Student Form");
				New n=new  New();
				
				
			}
		}
				
				
			);
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				JOptionPane.showMessageDialog(b5, "Welcome to Personal Details Form");
				Personal p=new Personal();
				
				
			}
		}
				
				
			);
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				JOptionPane.showMessageDialog(b4, "Welcome to Academic Details");
				Full_details f=new Full_details();
				
				
			}
		}
				
				
			);
		b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				JOptionPane.showMessageDialog(b6, "Welcome to Student Academic Details");
				Academics a=new Academics ();
				
				
			}
		}
				
				
			);
	}
	

		
	public static void main(String[] args) {
		new Menu();
		
	

}



	
	public void actionPerformed(ActionEvent e) {
		
		
	}



	
}

