import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class assign extends JFrame 
//implements ActionListener,ItemListener
{
int ref1=0;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
TextField t1,t2;
Choice c1,c2,c3,c4,c5;
Button b1,b2,b3,b4,b5,b6,b7,b8;
CheckboxGroup phase;
Checkbox cb1,cb2,cb3,cb4,cb5;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public assign()
{
l1=new Label("Enter Client ID");
l2=new Label("Request");
l3=new Label("Coding Phase");
l4=new Label("Designing Phase");
l5=new Label("Analysis Phase");
l6=new Label("Testing Phase");
l7=new Label("Complete System Phase");
l8=new Label("Employee ID");
l9=new Label("Employee ID");
l10=new Label("Employee ID");
l11=new Label("Employee ID");
l12=new Label("Employee ID");

t1=new TextField(20);
t2=new TextField(25);

t2.setEditable(false);

c1=new Choice();
c2=new Choice();
c3=new Choice();
c4=new Choice();
c5=new Choice();

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con1=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s1=con1.createStatement();

ResultSet rs1=s1.executeQuery("select * from employee where designation='Programmer'");

while(rs1.next())
{
ref1=1;
c1.add(rs1.getString(1));
}
if(ref1==0)
{
c1.add("No Employee Available");
}
ref1=0;
}


catch(Exception r)
{
}

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con2=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s2=con2.createStatement();

ResultSet rs2=s2.executeQuery("select * from employee where designation='Designer'");

while(rs2.next())
{
ref1=1;
c2.add(rs2.getString(1));
}
if(ref1==0)
{
c2.add("No Employee Available");
}
ref1=0;
}


catch(Exception r)
{
}

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con3=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s3=con3.createStatement();

ResultSet rs3=s3.executeQuery("select * from employee where designation='Operator'");

while(rs3.next())
{
ref1=1;
c3.add(rs3.getString(1));
}
if(ref1==0)
{
c3.add("No Employee Available");
}
ref1=0;
}


catch(Exception r)
{
}

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con4=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s4=con4.createStatement();

ResultSet rs4=s4.executeQuery("select * from employee where designation='Tester'");

while(rs4.next())
{
ref1=1;
c4.add(rs4.getString(1));
}
if(ref1==0)
{
c4.add("No Employee Available");
}
ref1=0;
}


catch(Exception r)
{
}

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con5=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s5=con5.createStatement();

ResultSet rs5=s5.executeQuery("select * from employee where designation='Tester'");

while(rs5.next())
{
ref1=1;
c5.add(rs5.getString(1));
}
if(ref1==0)
{
c1.add("No Employee Available");
}
ref1=0;
}


catch(Exception r)
{
}


b1=new Button("Reset");
b2=new Button("Find");
b3=new Button("Submit");
b4=new Button("Get Details");
b5=new Button("Get Details");
b6=new Button("Get Details");
b7=new Button("Get Details");
b8=new Button("Get Details");

phase=new CheckboxGroup();

cb1=new Checkbox("",phase,false);
cb2=new Checkbox("",phase,false);
cb3=new Checkbox("",phase,false);
cb4=new Checkbox("",phase,false);
cb5=new Checkbox("",phase,false);

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);

setTitle("Work Assignment");
setVisible(true);
setBounds(0,0,1920,1080);

gc.gridx=0;
gc.gridy=0;
grid.setConstraints(l1,gc);
cont.add(l1);

gc.gridx=1;
gc.gridy=0;
grid.setConstraints(t1,gc);
cont.add(t1);

gc.gridx=2;
gc.gridy=0;
grid.setConstraints(b2,gc);
cont.add(b2);

gc.gridx=0;
gc.gridy=1;
grid.setConstraints(l2,gc);
cont.add(l2);

gc.gridx=1;
gc.gridy=1;
grid.setConstraints(t2,gc);
cont.add(t2);

gc.gridx=0;
gc.gridy=2;
grid.setConstraints(cb1,gc);
cont.add(cb1);

gc.gridx=1;
gc.gridy=2;
grid.setConstraints(l3,gc);
cont.add(l3);

gc.gridx=2;
gc.gridy=2;
grid.setConstraints(l8,gc);
cont.add(l8);

gc.gridx=3;
gc.gridy=2;
grid.setConstraints(c1,gc);
cont.add(c1);

gc.gridx=4;
gc.gridy=2;
grid.setConstraints(b4,gc);
cont.add(b4);

gc.gridx=0;
gc.gridy=3;
grid.setConstraints(cb2,gc);
cont.add(cb2);

gc.gridx=1;
gc.gridy=3;
grid.setConstraints(l4,gc);
cont.add(l4);

gc.gridx=2;
gc.gridy=3;
grid.setConstraints(l9,gc);
cont.add(l9);

gc.gridx=3;
gc.gridy=3;
grid.setConstraints(c2,gc);
cont.add(c2);

gc.gridx=4;
gc.gridy=3;
grid.setConstraints(b5,gc);
cont.add(b5);

gc.gridx=0;
gc.gridy=4;
grid.setConstraints(cb3,gc);
cont.add(cb3);

gc.gridx=1;
gc.gridy=4;
grid.setConstraints(l5,gc);
cont.add(l5);

gc.gridx=2;
gc.gridy=4;
grid.setConstraints(l10,gc);
cont.add(l10);

gc.gridx=3;
gc.gridy=4;
grid.setConstraints(c3,gc);
cont.add(c3);

gc.gridx=4;
gc.gridy=4;
grid.setConstraints(b6,gc);
cont.add(b6);

gc.gridx=0;
gc.gridy=5;
grid.setConstraints(cb4,gc);
cont.add(cb4);

gc.gridx=1;
gc.gridy=5;
grid.setConstraints(l6,gc);
cont.add(l6);

gc.gridx=2;
gc.gridy=5;
grid.setConstraints(l11,gc);
cont.add(l11);

gc.gridx=3;
gc.gridy=5;
grid.setConstraints(c4,gc);
cont.add(c4);

gc.gridx=4;
gc.gridy=5;
grid.setConstraints(b7,gc);
cont.add(b7);

gc.gridx=0;
gc.gridy=6;
grid.setConstraints(cb5,gc);
cont.add(cb5);

gc.gridx=1;
gc.gridy=6;
grid.setConstraints(l7,gc);
cont.add(l7);

gc.gridx=2;
gc.gridy=6;
grid.setConstraints(l12,gc);
cont.add(l12);

gc.gridx=3;
gc.gridy=6;
grid.setConstraints(c5,gc);
cont.add(c5);

gc.gridx=4;
gc.gridy=6;
grid.setConstraints(b8,gc);
cont.add(b8);

gc.gridx=0;
gc.gridy=7;
grid.setConstraints(b1,gc);
cont.add(b1);

gc.gridx=1;
gc.gridy=7;
grid.setConstraints(b3,gc);
cont.add(b3);

}
public static void main(String arg[])
{
assign emp=new assign();
}
}