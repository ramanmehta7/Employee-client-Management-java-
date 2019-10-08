import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class problem extends JFrame implements ActionListener
{
int ref1=0,count=0;
Label l1,l2,l3,l4;
TextField t1,t2,t3;
TextArea t;
Button b1,b2,b3;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public problem()
{
l1=new Label("Client ID");
l2=new Label("Request");
l3=new Label("Enter Problem");
l4=new Label("Your Employee ID");

t1=new TextField(20);
t2=new TextField(25);
t3=new TextField(20);

t=new TextArea(5,35);

t2.setEditable(false);

b1=new Button("Find");
b2=new Button("Reset");
b3=new Button("Submit");

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);

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
grid.setConstraints(b1,gc);
cont.add(b1);

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
grid.setConstraints(l3,gc);
cont.add(l3);

gc.gridx=1;
gc.gridy=2;
grid.setConstraints(t,gc);
cont.add(t);

gc.gridx=0;
gc.gridy=3;
grid.setConstraints(l4,gc);
cont.add(l4);

gc.gridx=1;
gc.gridy=3;
grid.setConstraints(t3,gc);
cont.add(t3);

gc.gridx=0;
gc.gridy=4;
grid.setConstraints(b2,gc);
cont.add(b2);

gc.gridx=1;
gc.gridy=4;
grid.setConstraints(b3,gc);
cont.add(b3);

setTitle("Q&A Window");
setVisible(true);
setBounds(0,0,1920,1080);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
String msg=e.getActionCommand();
JOptionPane jp=new JOptionPane();

if(msg.equals("Find"))
{
if(t1.getText().length()!=0)
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con1=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s1=con1.createStatement();

ResultSet rs1=s1.executeQuery("select * from cleint where client_id=" + "'" + t1.getText() + "'");

while(rs1.next())
{
ref1=1;
t2.setText(rs1.getString(6));
}
if(ref1==0)
{
jp.showMessageDialog(this,t1.getText() + " is not a valid Client ID");
}
}
catch(Exception r)
{}
}
else
{
jp.showMessageDialog(this,"Enter Client ID first");
}
}

else if(msg.equals("Reset"))
{
t1.setText("");
t2.setText("");
t3.setText("");
t.setText("");
ref1=0;
count=0;
}

else
{

if(t.getText().length()!=0)
{
count++;
}
else
{
jp.showMessageDialog(this,"Enter the Problem that you've faced");
}


if(t3.getText().length()!=0)
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con1=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s1=con1.createStatement();

ResultSet rs1=s1.executeQuery("select * from employee where employee_id=" + "'" + t1.getText() + "'");

while(rs1.next())
{
ref1=1;
}
if(ref1==0)
{
jp.showMessageDialog(this,"Employee ID does not exists");
}
else
{
count++;
}
ref1=0;
}
catch(Exception r)
{}

}


if(count==2 && ref1==1)
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con1=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s1=con1.createStatement();

s1.executeUpdate("insert into qa values('" + t1.getText() + "','" + t2.getText() + "','" + t.getText() + "','" + t3.getText() + "')" );

jp.showMessageDialog(this,"Saved Successfully");
count=0;
ref1=0;
}
catch(Exception r)
{}
}

}
}

public static void main(String arg[])
{
problem emp=new problem();
}
}