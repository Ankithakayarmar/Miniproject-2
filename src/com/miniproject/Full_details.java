package com.miniproject;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Full_details extends JFrame implements ActionListener{
	JFrame f1;

	JPanel p1;
	JLabel l,l1,l2,l3,l4,l5,l6;
	JTextField tf,tf1,tf2,tf3,tf4,tf5,tf6;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	
	
	Full_details(){
		JFrame f1=new JFrame("Student Academic Details");
		JPanel p1=new JPanel();
		
		
		JTable j=new JTable();
		
		JLabel l=new JLabel("SID:");
		JLabel l1=new JLabel("KANNADA:");
		JLabel l2=new JLabel("ENGLISH:");
		JLabel l3=new JLabel("HINDI:");
		JLabel l4=new JLabel("SOCIAL SCIENCE:");
		JLabel l5=new JLabel("SCIENCE:");
		JLabel l6=new JLabel("MATHEMATICS:");
		
		JTextField tf=new JTextField("",20);
		JTextField tf1=new JTextField("",20);
		JTextField tf2=new JTextField("",20);
		JTextField tf3=new JTextField("",20);
		JTextField tf4=new JTextField("",20);
		JTextField tf5=new JTextField("",20);
		JTextField tf6=new JTextField("",20);
		
		JButton b1=new JButton("Save");
		JButton b2=new JButton("Reset");
		JButton b3=new JButton("View");
		JButton b4=new JButton("Total Marks");
		JButton b5=new JButton("Average");
		JButton b6=new JButton("Ranking");
		JButton b7=new JButton("Delete");
		JButton b8=new JButton("Update");
		JButton b9=new JButton("Logout");
		
		p1.add(l);p1.add(tf);
		p1.add(l1);p1.add(tf1);
		p1.add(l2);p1.add(tf2);	
		p1.add(l3);p1.add(tf3);
		p1.add(l4);p1.add(tf4);
		p1.add(l5);p1.add(tf5);
		p1.add(l6);p1.add(tf6);
		p1.add(j);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		f1.add(p1);
		
		f1.setBounds(100, 30, 1200,600);
		f1.setVisible(true);
	
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
	String sid=tf.getText();
	String kannada=tf1.getText();
	int len=kannada.length();
	String english=tf2.getText();
	int len1=english.length();
	String hindi=tf3.getText();
	int len2=hindi.length();
	String ss=tf4.getText();
	int len3=ss.length();
	String science=tf5.getText();
	int len4=science.length();
	String maths=tf6.getText();
	int len5=maths.length();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
			
			String query="Insert into record values('" + sid + "','" + kannada +"','" +english +"','" +hindi +"','" +ss +"','" +science +"','" +maths +"')";
			Statement st=con.createStatement();
			
			int x=st.executeUpdate(query);
			String msg="" +sid;
			msg=" \n";
			if(x==0) {
				JOptionPane.showMessageDialog(b1, "already exist");
			}
			else if(sid.equals("")) {
				
				JOptionPane.showMessageDialog(tf,"  sid required");
				
			}
			else if(kannada.equals("")) {
				
				JOptionPane.showMessageDialog(tf1,"  kannada score required");
				
			}
			else if(len!=2) {
				
				JOptionPane.showMessageDialog(tf1," Enter valid number");
				
			}
			else if(english.equals("")) {
				JOptionPane.showMessageDialog(tf2," english score required");
				
			}
			else if(len1!=2) {
				
				JOptionPane.showMessageDialog(tf2," Enter valid number");
				
			}
			else if(hindi.equals("")) {
				JOptionPane.showMessageDialog(tf3," hindi score required");
			}
			else if(len2!=2) {
				
				JOptionPane.showMessageDialog(tf3," Enter valid number");
				
			}
			else if(ss.equals("")) {
				JOptionPane.showMessageDialog(tf4,"social science score required");
			}
			else if(len3!=2) {
				
				JOptionPane.showMessageDialog(tf4," Enter valid number");
				
			}
			else if(science.equals("")) {
				JOptionPane.showMessageDialog(tf5," science score required");
			}
			else if(len4!=2) {
				
				JOptionPane.showMessageDialog(tf5," Enter valid number");
				
			}
			else if(maths.equals("")) {
				JOptionPane.showMessageDialog(tf6," maths score required");
			}
			else if(len5!=2) {
				
				JOptionPane.showMessageDialog(tf6," Enter valid number");
				
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
				
				try {
					
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");

				
				Statement st=con.createStatement();
				
				
				
				ResultSet rs=st.executeQuery("select * from record");

				
					j.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				
					
				
				catch(Exception ae)
				{
					ae.printStackTrace();							}
				
					
				
				
			}
				
				
			});

		b2.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				tf.setText(null);
				tf1.setText(null);
				tf2.setText(null);
				tf3.setText(null);
				tf4.setText(null);
				tf5.setText(null);
				tf6.setText(null);
	
	
		}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sid=tf.getText();
				String kannada=tf1.getText();
				String english=tf2.getText();
				String hindi=tf3.getText();
				String ss=tf4.getText();
				String science=tf5.getText();
				String maths=tf6.getText();
				
				
				double[] d=new double[14];
				
				d[0]=Double.parseDouble(tf.getText());
				
				d[1]=Double.parseDouble(tf1.getText());
				d[2]=Double.parseDouble(tf2.getText());
				d[3]=Double.parseDouble(tf3.getText());
				d[4]=Double.parseDouble(tf4.getText());
				d[5]=Double.parseDouble(tf5.getText());
				d[6]=Double.parseDouble(tf6.getText());
				
				
				
				d[7]=d[1] + d[2] + d[3] + d[4]+ d[5] +d[6] ;
				JOptionPane.showMessageDialog(b4,"Your total score is:" +d[7]);
			}	
			});
		
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sid=tf.getText();
				String kannada=tf1.getText();
				String english=tf2.getText();
				String hindi=tf3.getText();
				String ss=tf4.getText();
				String science=tf5.getText();
				String maths=tf6.getText();
				
				
				double[] d=new double[14];
				
				
				d[0]=Double.parseDouble(tf.getText());
				
				d[1]=Double.parseDouble(tf1.getText());
				d[2]=Double.parseDouble(tf2.getText());
				d[3]=Double.parseDouble(tf3.getText());
				d[4]=Double.parseDouble(tf4.getText());
				d[5]=Double.parseDouble(tf5.getText());
				d[6]=Double.parseDouble(tf6.getText());
				
				d[8]=(d[1] + d[2] + d[3] + d[4]+ d[5] +d[6])/6 ;
				JOptionPane.showMessageDialog(b5,"Your Average score is:" +d[8]);
				
				
				
			}
		});
		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sid=tf.getText();
				String kannada=tf1.getText();
				String english=tf2.getText();
				String hindi=tf3.getText();
				String ss=tf4.getText();
				String science=tf5.getText();
				String maths=tf6.getText();
					double[] d=new double[14];
				
					d[0]=Double.parseDouble(tf.getText());
				d[1]=Double.parseDouble(tf1.getText());
				d[2]=Double.parseDouble(tf2.getText());
				d[3]=Double.parseDouble(tf3.getText());
				d[4]=Double.parseDouble(tf4.getText());
				d[5]=Double.parseDouble(tf5.getText());
				d[6]=Double.parseDouble(tf6.getText());
				
				
				d[7]=d[0] + d[1] + d[2] + d[3]+ d[4] +d[5] ;
				
				
				
				if(d[7]>=500) {
					JOptionPane.showMessageDialog(b6,"Ranking:Very good" );
				}
				
				else if((d[7]>=400) && (d[7]<=500)){
					JOptionPane.showMessageDialog(b6,"Ranking: good" );
					
					
				}
				else if((d[7]>=350) && (d[7]<=400)){
					JOptionPane.showMessageDialog(b6,"Ranking:Poor Performance" );
					
					
				}
				else {
					JOptionPane.showMessageDialog(b6,"Ranking:Fail" );
				}
			}
				
				
			});
		
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) j.getModel();
				
				int i=j.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(b7,"Deleted successfully" );
				}
				else {
					JOptionPane.showMessageDialog(b7,"Please select a row" );
				}
			
			}	
				
			});
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) j.getModel();
				
				
				if(j.getSelectedRowCount()==1) {
					
					String sid=tf.getText();
					String kannada=tf1.getText();
					String english=tf2.getText();
					String hindi=tf3.getText();
					String ss=tf4.getText();
					String science=tf5.getText();
					String maths=tf6.getText();
					
					model.setValueAt(sid, j.getSelectedRow(),0);
					model.setValueAt(kannada, j.getSelectedRow(),1);
					model.setValueAt(english, j.getSelectedRow(),2);
					model.setValueAt(hindi, j.getSelectedRow(),3);
					model.setValueAt(ss, j.getSelectedRow(),4);
					model.setValueAt(science, j.getSelectedRow(),5);
					model.setValueAt(maths, j.getSelectedRow(),6);
					
					
					JOptionPane.showMessageDialog(b8,"Updated successfully" );
				}
				
				
			}
				
				
			});	
		b9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f1.dispose();
				JOptionPane.showMessageDialog(b9,"Successfully Logged out");
				Miniproject m=new Miniproject();
				
				
			}
		
				
				
		});
		
		
		
				
		}
	public static void main(String[] args) {
		new Full_details();
	
	
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
