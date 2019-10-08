import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class search_clt extends JFrame implements ActionListener,ItemListener
{
String choice="";
int ram=0,ref=0;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
Button b1,b2;
TextField  t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
Choice c4;
List  c1;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public search_clt()
{
l1=new Label("Client I'D");
l2=new Label("Name");
l3=new Label("Address");
l4=new Label("Contact Number");
l5=new Label("Email ID");
l6=new Label("Type of Request");
l7=new Label("Language");
l8=new Label("Platform");
l9=new Label("DataBase");
l10=new Label("Time Duration(Days)");
l11=new Label("Amount");
l12=new Label("Search By");

b1=new Button("Search");
b2=new Button("Reset");

t1=new TextField(20);
t2=new TextField(20);
t3=new TextField(30);
t4=new TextField(20);
t5=new TextField(30);
t6=new TextField(25);
t7=new TextField(20);
t8=new TextField(25);
t9=new TextField(25);
t10=new TextField(20);
t11=new TextField(20);

t1.setEditable(false);
t2.setEditable(false);
t3.setEditable(false);
t4.setEditable(false);
t5.setEditable(false);
t6.setEditable(false);
t7.setEditable(false);
t8.setEditable(false);
t9.setEditable(false);
t10.setEditable(false);
t11.setEditable(false);

c4=new Choice();

c1=new List(4,false);

c1.add("Employee ID of your search");

c4.add("Client ID");
c4.add("Name");
c4.add("Type of Request");
c4.add("Language");
c4.add("Platform");
c4.add("DataBase");
c4.add("Contact Number");

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);

gc.gridx=0;
gc.gridy=0;
grid.setConstraints(l12,gc);
cont.add(l12);

gc.gridx=1;
gc.gridy=0;
grid.setConstraints(c4,gc);
cont.add(c4);

gc.gridx=3;
gc.gridy=0;
grid.setConstraints(c1,gc);
cont.add(c1);

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
grid.setConstraints(t3,gc);
cont.add(t3);

gc.gridx=0;
gc.gridy=4;
grid.setConstraints(l4,gc);
cont.add(l4);

gc.gridx=1;
gc.gridy=4;
grid.setConstraints(t4,gc);
cont.add(t4);

gc.gridx=2;
gc.gridy=4;
grid.setConstraints(l5,gc);
cont.add(l5);

gc.gridx=3;
gc.gridy=4;
grid.setConstraints(t5,gc);
cont.add(t5);

gc.gridx=0;
gc.gridy=5;
grid.setConstraints(l6,gc);
cont.add(l6);

gc.gridx=1;
gc.gridy=5;
grid.setConstraints(t6,gc);
cont.add(t6);

gc.gridx=2;
gc.gridy=5;
grid.setConstraints(l7,gc);
cont.add(l7);

gc.gridx=3;
gc.gridy=5;
grid.setConstraints(t7,gc);
cont.add(t7);

gc.gridx=0;
gc.gridy=6;
grid.setConstraints(l8,gc);
cont.add(l8);

gc.gridx=1;
gc.gridy=6;
grid.setConstraints(t8,gc);
cont.add(t8);

gc.gridx=2;
gc.gridy=6;
grid.setConstraints(l9,gc);
cont.add(l9);

gc.gridx=3;
gc.gridy=6;
grid.setConstraints(t9,gc);
cont.add(t9);

gc.gridx=0;
gc.gridy=7;
grid.setConstraints(l10,gc);
cont.add(l10);

gc.gridx=1;
gc.gridy=7;
grid.setConstraints(t10,gc);
cont.add(t10);

gc.gridx=2;
gc.gridy=7;
grid.setConstraints(l11,gc);
cont.add(l11);

gc.gridx=3;
gc.gridy=7;
grid.setConstraints(t11,gc);
cont.add(t11);

gc.gridx=3;
gc.gridy=1;
grid.setConstraints(b1,gc);
cont.add(b1);

gc.gridx=1;
gc.gridy=8;
grid.setConstraints(b2,gc);
cont.add(b2);

setTitle("Client Window");
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
if(choice.equals("Client ID"))
	{
	t1.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	t6.setEditable(false);
	}

if(choice.equals("Name"))
	{
	t2.setEditable(true);
	t1.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	t6.setEditable(false);
	}

if(choice.equals("Type of Request"))
	{
	t6.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t1.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	t7.setEditable(false);
	}

if(choice.equals("Language"))
	{
	t7.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t8.setEditable(false);
	t1.setEditable(false);
	t9.setEditable(false);
	t6.setEditable(false);
	}

if(choice.equals("Contact Number"))
	{
	t4.setEditable(true);
	t2.setEditable(false);
	t1.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	t6.setEditable(false);
	}

if(choice.equals("Platform"))
	{
	t8.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t9.setEditable(false);
	t1.setEditable(false);
	t6.setEditable(false);
	}

if(choice.equals("DataBase"))
	{
	t9.setEditable(true);
	t2.setEditable(false);
	t4.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t1.setEditable(false);
	t6.setEditable(false);
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
	t10.setText("");
	t11.setText("");

	t1.setEditable(false);
	t2.setEditable(false);
	t3.setEditable(false);
	t4.setEditable(false);
	t5.setEditable(false);
	t6.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
	t9.setEditable(false);
	t10.setEditable(false);
	t11.setEditable(false);

	c1.removeAll();
	c1.add("Employee ID of your search");

	}
else
{
	c1.removeAll();
	c1.add("Employee ID of your search");

	if(choice.equals("Client ID"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");

		Statement s1=con.createStatement();
		ResultSet rs=s1.executeQuery("select * from client where client_id=" + "'" + t1.getText() + "'");

		while(rs.next())
		{
			ram=1;
		t1.setText(rs.getString(1));
		t2.setText(rs.getString(2));
		t3.setText(rs.getString(3));
		t4.setText(rs.getString(4));
		t5.setText(rs.getString(5));
		t6.setText(rs.getString(6));
		t7.setText(rs.getString(7));
		t8.setText(rs.getString(8));
		t9.setText(rs.getString(9));
		t10.setText(rs.getString(10));
		t11.setText(rs.getString(11));
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
		t10.setText("");
		t11.setText("");
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

		ResultSet rs=s1.executeQuery("select * from client where name=" + "'" + t2.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from client where name=" + "'" + t2.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t3.setText(rs1.getString(3));
		t4.setText(rs1.getString(4));
		t5.setText(rs1.getString(5));
		t6.setText(rs1.getString(6));
		t7.setText(rs1.getString(7));
		t8.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
		t10.setText(rs1.getString(10));
		t11.setText(rs1.getString(11));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one Client has NAME, " + t2.getText() +". Please, search through Client ID. Following Client IDs of different clients with NAME " + t2.getText() + " has been provided in the List present");
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
		t10.setText("");
		t11.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
	
	}

	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}

if(choice.equals("Type of Request"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from client where request=" + "'" + t6.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from client where request=" + "'" + t6.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t3.setText(rs1.getString(3));
		t4.setText(rs1.getString(4));
		t5.setText(rs1.getString(5));
		t6.setText(rs1.getString(6));
		t7.setText(rs1.getString(7));
		t8.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
		t10.setText(rs1.getString(10));
		t11.setText(rs1.getString(11));
}
	}
	else
	{
	j.showMessageDialog(this,"More than one client has Request as " + t6.getText()  + " . Please, search through client ID. Following Client IDs of different clients with Type of Request as " + t6.getText() + " has been provided in the List present");
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

if(choice.equals("Language"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from client where lang=" + "'" + t7.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from client where lang=" + "'" + t7.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t3.setText(rs1.getString(3));
		t4.setText(rs1.getString(4));
		t5.setText(rs1.getString(5));
		t6.setText(rs1.getString(6));
		t7.setText(rs1.getString(7));
		t8.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
		t10.setText(rs1.getString(10));
		t11.setText(rs1.getString(11));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one Client ask for " + t7.getText() + " Language code. Please, search through client ID. Following Client IDs of different clients asking for " + t7.getText() + " Language has been provided in the List present");
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
		t10.setText("");
		t11.setText("");
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

		ResultSet rs=s1.executeQuery("select * from client where contact=" + "'" + t4.getText() + "'");

		while(rs.next())
			{
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
			t4.setText(rs.getString(4));
			t5.setText(rs.getString(5));
			t6.setText(rs.getString(6));
			t7.setText(rs.getString(7));
			t8.setText(rs.getString(8));
			t9.setText(rs.getString(9));
			t10.setText(rs.getString(10));
			t11.setText(rs.getString(11));
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
		t10.setText("");
		t11.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
		}
	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}

if(choice.equals("Platform"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from client where platform=" + "'" + t8.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from client where platform=" + "'" + t8.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t3.setText(rs1.getString(3));
		t4.setText(rs1.getString(4));
		t5.setText(rs1.getString(5));
		t6.setText(rs1.getString(6));
		t7.setText(rs1.getString(7));
		t8.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
		t10.setText(rs1.getString(10));
		t11.setText(rs1.getString(11));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one client requested platform as " + t8.getText() + ". Please, search through client ID. Following Client IDs of different clients asking for " + t8.getText() + " Platform has been provided in the List present");
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
		t10.setText("");
		t11.setText("");
		j.showMessageDialog(this,"Sorry Record is Not Available");
		}
		}
	catch(Exception r)
		{
		j.showMessageDialog(this,"Error : " + r.getMessage());
		}
	}


if(choice.equals("DataBase"))
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();

		ResultSet rs=s1.executeQuery("select * from client where data=" + "'" + t9.getText() + "'");

		while(rs.next())
			{
			ram=1;
			ref++;
		c1.add(rs.getString(1));
			}

		ResultSet rs1=s1.executeQuery("select * from client where data=" + "'" + t9.getText() + "'");
	if(ref==1 || ref==0)
	{
	while(rs1.next())
	{
		t1.setText(rs1.getString(1));
		t2.setText(rs1.getString(2));
		t3.setText(rs1.getString(3));
		t4.setText(rs1.getString(4));
		t5.setText(rs1.getString(5));
		t6.setText(rs1.getString(6));
		t7.setText(rs1.getString(7));
		t8.setText(rs1.getString(8));
		t9.setText(rs1.getString(9));
		t10.setText(rs1.getString(10));
		t11.setText(rs1.getString(11));
	}
	}
	else
	{
	j.showMessageDialog(this,"More than one client requested DataBase to be " + t9.getText() + ". Please, search through client ID. Following Client IDs of different clients asking for " + t9.getText() + " Platform has been provided in the List present");
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
		t10.setText("");
		t11.setText("");
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
search_clt emp=new search_clt();
}

}