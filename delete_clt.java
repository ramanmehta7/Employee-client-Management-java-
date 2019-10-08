import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class delete_clt extends JFrame implements ActionListener
{
int ref1=0;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
Button b1,b2,b3;
TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public delete_clt()
{
l1=new Label("Enter Employee ID");
l2=new Label("Name");
l3=new Label("Address");
l4=new Label("Contact Number");
l5=new Label("Email");
l6=new Label("Type of Request");
l7=new Label("Language");
l8=new Label("Platform");
l9=new Label("DataBase");
l10=new Label("Time Duration(days)");
l11=new Label("Amount");


b1=new Button("Delete");
b2=new Button("Reset");
b3=new Button("Get Details");

t1=new TextField(20);
t2=new TextField(20);
t3=new TextField(30);
t4=new TextField(20);
t5=new TextField(30);
t6=new TextField(25);
t7=new TextField(25);
t8=new TextField(25);
t9=new TextField(25);
t10=new TextField(10);
t11=new TextField(10);

t1.setEditable(true);
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

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);


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
grid.setConstraints(b3,gc);
cont.add(b3);

gc.gridx=1;
gc.gridy=9;
grid.setConstraints(b2,gc);
cont.add(b2);

gc.gridx=2;
gc.gridy=9;
grid.setConstraints(b1,gc);
cont.add(b1);

setTitle("Client Window");
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
t9.setText("");
t10.setText("");
t11.setText("");
ref1=0;
}

else if(msg.equals("Delete"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s1=con.createStatement();

if(ref1==1)
{
s1.executeUpdate("delete from client where client_id=" + "'" +
t1.getText() + "'");

jp.showMessageDialog(this,"The Client ID " + t1.getText() + " has been deleted");

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
}
else
{
jp.showMessageDialog(this,"Search for his/her Details first and confirm if you wanna delete the Client ID " + t1.getText());
}
ref1=0;
}
catch(Exception r)
{
jp.showMessageDialog(this,r.getMessage());
}
}

else
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s1=con.createStatement();

ResultSet rs=s1.executeQuery("select * from client where client_id=" + "'" + t1.getText() + "'");

while(rs.next())
{
ref1=1;
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
if(ref1==0)
{
jp.showMessageDialog(this,"The Client ID " + t1.getText() + " doesn't exists");
}
}
catch(Exception r)
{
jp.showMessageDialog(this,r.getMessage());
}
}
}

public static void main(String arg[])
{
delete_clt emp=new delete_clt();
}
}