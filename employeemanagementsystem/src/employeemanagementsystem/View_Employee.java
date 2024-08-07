package employeemanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class View_Employee extends  JFrame implements ActionListener {

	JTable table;
	Choice choiceEMP;
	JButton srch,print,update,back;
	
	View_Employee()
	{
		
		getContentPane().setBackground(new Color(255,131,122));
		JLabel search = new JLabel("Searh by employee id ");
		search.setBounds(20,20,150,20);
		add(search);
		
		
		choiceEMP = new Choice();
		choiceEMP.setBounds(180,20,150,20);
		add(choiceEMP);
		
		try
		{
			Conn con =  new Conn();
			ResultSet resultset = con.statement.executeQuery("select * from employe");
			 while(resultset.next())
			 {
				 choiceEMP.add(resultset.getString("empID"));
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		table = new JTable();
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.statement.executeQuery("select * from employe");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(0,100,900,600);
		add(jp);
		
		srch = new JButton("Search");
		srch.setBounds(20,70,80,20);
		srch.addActionListener(this);
		add(srch);
		
		print = new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(220,70,80,20);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(320,70,80,20);
		back.addActionListener(this);
		add(back);
		
		setSize(900,700);
		setLayout(null);
		setLocation(300,100);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == srch)
		{
			String query = "select * from employe where empID = '"+choiceEMP.getSelectedItem()+"'";
		    try
		    {
		    	 Conn c = new Conn();
		    	 ResultSet rs = c.statement.executeQuery(query);
		    	 table.setModel(DbUtils.resultSetToTableModel(rs));
		    }
		    catch(Exception E)
		    {
		    	E.printStackTrace();
		    }
		}
		else if(e.getSource()== print)
		{
			try
			{
				table.print();
			}
			catch(Exception E)
			{
				E.printStackTrace();
			}
		}
		else if(e.getSource() == update)
		{
			setVisible(false);
			new UpdateEmployee(choiceEMP.getSelectedItem());
		}
		else
		{
			setVisible(false);
			new Main();
		}
	}
	
	public static void main(String[] args) 
	{
		new View_Employee();
		
	}

}
