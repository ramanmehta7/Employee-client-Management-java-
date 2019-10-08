import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class search_emp extends JFrame implements ActionListener,ItemListener
{
String choice="";
int ram=0,ref=0;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
Button b1,b2;
TextField  t1,t2,t3,t4,t5,t6,t7,t8,t9;
Choice c4;
List  c1;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public search_emp()
{
l1=new Label("Employee I'D");
l2=new Label("Name");
l3=new Label("Department");
l4=new Label("Designation");
l5=new Label("Gender");
l6=new Label("Address");
l7=new Label("Contact Number");
l8=new Label("Email I'D");
l9=new Label("Expertise");
l10=new Label("Search By");

b1=new Button("Search");
b2=new Button("Reset");

t1=new TextField(20);
t2=new TextField(20);
t3=new TextField(30);
t4=new TextField(20);
t5=new TextField(30);
t6=new TextField(20);
t7=new TextField(20);
t8=new TextField(20);
t9=new TextField(20);

t1.setEditable(false);
t2.setEditable(false);
t3.setEditable(false);
t4.setEditable(false);
t5.setEditable(false);
t6.setEditable(false);
t7.setEditable(false);
t8.setEditable(false);
t9.setEditable(false);

c4=new Choice();

c1=new List(3,false);

c1.add("Employee ID of your search");

c4.add("Employee ID");
c4.add("Name");
c4.add("Department");
c4.add("Designation");
c4.add("Contact Number");
c4.add("Expertise");

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);

gc.gridx=0;
gc.gridy=0;
grid.setConstraints(l10,gc);
cont.add(l10);

gc.gridx=4;
gc.gridy=1;
grid.setConstraints(c1,gc);
cont.add(c1);

gc.gridx=1;
gc.gridy=0;
grid.setConstraints(c4,gc);
cont.add(c4);

gc.gridx=0;
gc.gridy=1;
grid.setConstraints(l1,gc);
cont.add(l1);

gc.gridx=1;
gc.gridy=1;
grid.setConstraints(t1,gc);
cont.add(t1);

gc.gridx=0;
gc.gridy=2;
grid.setConstraints(l2,gc);
cont.add(l2);

gc.gridx=1;
gc.gridy=2;
grid.setConstraints(t2,gc);
cont.add(t2);

gc.gridx=0;
gc.gridy=3;
grid.setConstraints(l3,gc);
cont.add(l3);

gc.gridx=1;
gc.gridy=3;
grid.setConstraints(t7,gc);
cont.add(t7);

gc.gridx=2;
gc.gridy=3;
grid.setConstraints(l4,gc);
cont.add(l4);

gc.gridx=3;
gc.gridy=3;
grid.setConstraints(t8,gc);
cont.add(t8);

gc.gridx=0;
gc.gridy=4;
grid.setConstraints(l5,gc);
cont.add(l5);

gc.gridx=1;
gc.gridy=4;
grid.setConstraints(t6,gc);
cont.add(t6);

gc.gridx=0;
gc.gridy=5;
grid.setConstraints(l6,gc);
cont.add(l6);

gc.gridx=1;
gc.gridy=5;
grid.setConstraints(t3,gc);
cont.add(t3);

gc.gridx=0;
gc.gridy=6;
grid.setConstraints(l7,gc);
cont.add(l7);

gc.gridx=1;
gc.gridy=6;
grid.setConstraints(t4,gc);
cont.add(t4);

gc.gridx=2;
gc.gridy=6;
grid.setConstraints(l8,gc);
cont.add(l8);

gc.gridx=3;
gc.gridy=6;
grid.setConstraints(t5,gc);
cont.add(t5);

gc.gridx=0;
gc.gridy=7;
grid.setConstraints(l9,gc);
cont.add(l9);

gc.gridx=1;
gc.gridy=7;
grid.setConstraints(t9,gc);
cont.add(t9);

gc.gridx=3;
gc.gridy=1;
grid.setConstraints(b1,gc);
cont.add(b1);

gc.gridx=1;
gc.gridy=9;
grid.setConstraints(b2,gc);
cont.add(b2);

setTitle("Employee Section");
setVisible(true);
setBounds(0,0,1920,1080);

b1.addActionListener(this);
b2.addActionListener(this);

c4.addItemListener(this);
}

//

public void itemStateChanged(ItemEvent e)
{
choice=c4.getSelectedItem();
if(choice.equals("Employee ID"))
	{
	t1.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	}

if(choice.equals("Name"))
	{
	t2.setEditable(true);
	t1.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	}

if(choice.equals("Department"))
	{
	t7.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t1.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	}

if(choice.equals("Designation"))
	{
	t8.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t1.setEditable(false);
	t9.setEditable(false);
	}

if(choice.equals("Contact Number"))
	{
	t4.setEditable(true);
	t2.setEditable(false);
	t1.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	}

if(choice.equals("Expertise"))
	{
	t9.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t1.setEditable(false);
	}

}

//

public void actionPerformed(ActionEvent e)
{
String msg=e.getActionCommand();
JOptionPane j=new JOptionPane();
if(msg.equals("Reset"))
	{
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
	t7.setText("");
	t8.setText("");
	t9.setText("");

	t1.setEditable(false);
	t2.setEditable(false);
	t3.setEditable(false);
	t4.setEditable(false);
	t5.setEditable(false);
	t6.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	
	c1.removeAll();
	c1.add("Employee ID of your search");

	}
else
{
	c1.removeAll();
	c1.add("Employee ID of your search");

	if(choice.equals("Employee ID"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");

		Statement s1=con.createStatement();
		ResultSet rs=s1.executeQuery("select * from employee where employee_id=" + "'" + t1.getText() + "'");

		while(rs.next())
		{
			ram=1;
		t1.setText(rs.getString(1));
		t2.setText(rs.getString(2));
		t7.setText(rs.getString(3));
		t8.setText(rs.getString(4));
		t6.setText(rs.getString(5));
		t3.setText(rs.getString(6));
		t4.setText(rs.getString(7));
		t5.setText(rs.getString(8));
		t9.setText(rs.getString(9));
		}

	if(ram==0)
		{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		j.showMessageDialog(this,"Record not found");
		}

		}
	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}

if(choice.equals("Name"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from employee where name=" + "'" + t2.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from employee where name=" + "'" + t2.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t7.setText(rs1.getString(3));
		t8.setText(rs1.getString(4));
		t6.setText(rs1.getString(5));
		t3.setText(rs1.getString(6));
		t4.setText(rs1.getString(7));
		t5.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one Employee has NAME," + t2.getText() +". Please, search through Employee ID");
	}

	if(ram==0)
		{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
	
	}

	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}

if(choice.equals("Department"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from employee where department=" + "'" + t7.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from employee where department=" + "'" + t7.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t7.setText(rs1.getString(3));
		t8.setText(rs1.getString(4));
		t6.setText(rs1.getString(5));
		t3.setText(rs1.getString(6));
		t4.setText(rs1.getString(7));
		t5.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one Employee work under" + t7.getText()  + "department. Please, search through Employee ID");
	}

	if(ram==0)
		{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
		}
	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}

if(choice.equals("Designation"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from employee where designation=" + "'" + t8.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from employee where designation=" + "'" + t8.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t7.setText(rs1.getString(3));
		t8.setText(rs1.getString(4));
		t6.setText(rs1.getString(5));
		t3.setText(rs1.getString(6));
		t4.setText(rs1.getString(7));
		t5.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one Employee work under " + t8.getText() + ". Please, search through Employee ID");
	}

	if(ram==0)
		{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
	}

	catch(Exception r)
	{
	j.showMessageDialog(this,"Error : " + r.getMessage());
	}
	}

if(choice.equals("Contact Number"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from employee where contact=" + "'" + t4.getText() + "'");

		while(rs.next())
			{
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			t7.setText(rs.getString(3));
			t8.setText(rs.getString(4));
			t6.setText(rs.getString(5));
			t3.setText(rs.getString(6));
			t4.setText(rs.getString(7));
			t5.setText(rs.getString(8));
			t9.setText(rs.getString(9));
			ram=1;
			}
	if(ram==0)
		{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
		}
	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}

if(choice.equals("Expertise"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from employee where expertise=" + "'" + t9.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from employee where expertise=" + "'" + t9.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t7.setText(rs1.getString(3));
		t8.setText(rs1.getString(4));
		t6.setText(rs1.getString(5));
		t3.setText(rs1.getString(6));
		t4.setText(rs1.getString(7));
		t5.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one Employee has Expertise in " + t9.getText() + ". Please, search through Employee ID");
	}

	if(ram==0)
		{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
		}
	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}
ref=0;
}
}

public static void main(String arg[])
{
search_emp emp=new search_emp();
}

}