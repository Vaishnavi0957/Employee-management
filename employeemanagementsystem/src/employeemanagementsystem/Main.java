package employeemanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Main extends JFrame 
{
       Main() 
     {
    	 ImageIcon i1 = new ImageIcon("C:\\Users\\Kartik\\Desktop\\employeemanagementsystem\\icon\\home.jpg");  
    	 Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
    	 ImageIcon i3 = new ImageIcon(i2);
    	 JLabel img = new JLabel(i3);
    	 img.setBounds(0, 0, 1120, 630);
    	 add(img);
    	 
    	 JLabel heading = new JLabel("Employee Management System");
    	 heading.setBounds(340,150,400,60);
    	 heading.setFont(new Font("Raleway",Font.BOLD,25));
    	 img.add(heading);
    	 
    	 JButton add = new JButton("Add Employee");
    	 add.setBounds(335,270,150,60);
    	 add.setForeground(Color.white);
    	 add.setBackground(Color.black);
    	 add.addActionListener( new ActionListener() {
    		 @Override
    		 public void actionPerformed(ActionEvent e)
    		 {
    			new AddEmployee();
    			setVisible(false);
    		 }
    	 });
    	 img.add(add);
    	 
    	 
    	 JButton view = new JButton("View Employee");
    	 view.setBounds(565,270,150,60);
    	 view.setForeground(Color.white);
    	 view.setBackground(Color.black);
    	 view.addActionListener( new ActionListener() {
    		 @Override
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 new View_Employee();
    			 setVisible(false);
    			 
    		 }
    	 });
    	 img.add(view);
    	 
    	 JButton remove = new JButton("Remove Employee");
    	 remove.setBounds(440,370,150,60);
    	 remove.setForeground(Color.white);
    	 remove.setBackground(Color.black);
    	 remove.addActionListener( new ActionListener() {
    		 @Override
    		 public void actionPerformed(ActionEvent e){
    			  new RemoveEmployee();
    			  setVisible(false);
    		 }
    	 });
    	 img.add(remove); 
    	 
	    setSize(1120,630);
	    setLocation(250,100);
	    setLayout(null);
	    setVisible(true);
	}
       
	public static void main(String[] args) {
		new Main();

	}

}