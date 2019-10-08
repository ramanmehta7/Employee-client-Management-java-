import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class phases extends JFrame implements ActionListener
{
String str="";
int ref=0,ref1=0;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
TextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
Button b1,b2,b3;
List c1;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public phases()
{
l1=new Label("Enter Client ID");
l2=new Label("Request");
l3=new Label("Language");
l4=new Label("Platform");
l5=new Label("Coding Phase(days)");
l6=new Label("Designing Phase(days)");
l7=new Label("Analysis Phase(days)");
l8=new Label("Testing Phase(days)");
l9=new Label("Complete System Testing(days)");
l10=new Label("The present Client IDs are..");

t1=new TextField(20);
t2=new TextField(25);
t3=new TextField(25);
t4=new TextField(25);
t5=new TextField(20);
t6=new TextField(20);
t7=new TextField(20);
t8=new TextField(20);
t9=new TextField(20);

t1.setEditable(true);
t2.setEditable(false);
t3.setEditable(false);
t4.setEditable(false);
t5.setEditable(false);
t6.setEditable(false);
t7.setEditable(false);
t8.setEditable(false);
t9.setEditable(false);

b1=new Button("Find");
b2=new Button("Reset");
b3=new Button("Submit");

c1=new List(5,false);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con2=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s2=con2.createStatement();

ResultSet rs2=s2.executeQuery("select client_id from client order by client_id");

while(rs2.next())
{
c1.add(rs2.getString(1));
}
}
catch(Exception rrr)
{
}

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);

setTitle("Analysis");
setVisible(true);
setBounds(0,0,1000,1000);

gc.gridx=0;
gc.gridy=0;
grid.setConstraints(l1,gc);
cont.add(l1);

gc.gridx=1;
gc.gridy=0;
grid.setConstraints(t1,gc);
cont.add(t1);

gc.gridx=3;
gc.gridy=0;
grid.setConstraints(l10,gc);
cont.add(l10);

gc.gridx=4;
gc.gridy=0;
grid.setConstraints(c1,gc);
cont.add(c1);

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

gc.gridx=2;
gc.gridy=1;
grid.setConstraints(l3,gc);
cont.add(l3);

gc.gridx=3;
gc.gridy=1;
grid.setConstraints(t3,gc);
cont.add(t3);

gc.gridx=4;
gc.gridy=1;
grid.setConstraints(l4,gc);
cont.add(l4);

gc.gridx=5;
gc.gridy=1;
grid.setConstraints(t4,gc);
cont.add(t4);

gc.gridx=0;
gc.gridy=2;
grid.setConstraints(l5,gc);
cont.add(l5);

gc.gridx=1;
gc.gridy=2;
grid.setConstraints(t5,gc);
cont.add(t5);

gc.gridx=0;
gc.gridy=3;
grid.setConstraints(l6,gc);
cont.add(l6);

gc.gridx=1;
gc.gridy=3;
grid.setConstraints(t6,gc);
cont.add(t6);

gc.gridx=0;
gc.gridy=4;
grid.setConstraints(l7,gc);
cont.add(l7);

gc.gridx=1;
gc.gridy=4;
grid.setConstraints(t7,gc);
cont.add(t7);

gc.gridx=0;
gc.gridy=5;
grid.setConstraints(l8,gc);
cont.add(l8);

gc.gridx=1;
gc.gridy=5;
grid.setConstraints(t8,gc);
cont.add(t8);

gc.gridx=0;
gc.gridy=6;
grid.setConstraints(l9,gc);
cont.add(l9);

gc.gridx=1;
gc.gridy=6;
grid.setConstraints(t9,gc);
cont.add(t9);

gc.gridx=0;
gc.gridy=7;
grid.setConstraints(b2,gc);
cont.add(b2);

gc.gridx=1;
gc.gridy=7;
grid.setConstraints(b3,gc);
cont.add(b3);

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

t8.setEditable(false);
t9.setEditable(false);
t5.setEditable(false);
t6.setEditable(false);
t7.setEditable(false);
ref=0;
ref1=0;
}

else if(msg.equals("Find"))
{
if(t1.getText().length()!=0)
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s=con.createStatement();

ResultSet rs=s.executeQuery("select * from client where client_id=" + "'" + t1.getText() + "'");

while(rs.next())
{
ref=1;
ref1=1;
t2.setText(rs.getString(6));
t3.setText(rs.getString(7));
t4.setText(rs.getString(8));

t5.setEditable(true);
t6.setEditable(true);
t7.setEditable(true);
t8.setEditable(true);
t9.setEditable(true);
}
if(ref==0)
{
jp.showMessageDialog(this,t1.getText() + " doesn't exist has a Client ID");
}
}

catch(Exception r)
{
jp.showMessageDialog(this,r.getMessage());
}

}

else
{
jp.showMessageDialog(this,"Seems like you didn't searched for anything");
}


}

else
{
if(ref1==1)
{
if(t5.getText().length()==0 || t6.getText().length()==0 || t7.getText().length()==0 || t8.getText().length()==0 || t9.getText().length()==0)
{
jp.showMessageDialog(this,"Provide the whole Information. Make your Costumer Happy!! :)");
}
else
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con1=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
Statement s1=con1.createStatement();

 s1.executeUpdate("insert into result values('" + t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "','" + t6.getText() + "','" + t7.getText() + "','" + t8.getText() + "','" + t9.getText() + "')" );

jp.showMessageDialog(this,"Information Saved :)");

t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
ref=0;
ref1=0;
}
catch(Exception rr)
{
jp.showMessageDialog(this,rr.getMessage());
}
}
}
else
{
jp.showMessageDialog(this,"First Search before analysing the Request. Hmm...");
}
}

}

public static void main(String arg[])
{
phases emp=new phases();
}
}