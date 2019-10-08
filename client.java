import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class client extends JFrame implements ActionListener,ItemListener
{
int id;
String req="",lang="",plt="",data="";
int ref=0,count=0;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
TextField t1,t2,t3,t4,t5,t6,t7;
Button b1,b2;
Choice c1,c2,c3,c4;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public client()
{
l1=new Label("Request ID");
l2=new Label("Client Name");
l3=new Label("Address");
l4=new Label("Contact Number");
l5=new Label("Email ID");
l6=new Label("Type of Request");
l7=new Label("Language Used");
l8=new Label("Platform");
l9=new Label("DataBase");
l10=new Label("Time duration(days)");
l11=new Label("Amount");

t1=new TextField(20);
t2=new TextField(20);
t3=new TextField(30);
t4=new TextField(20);
t5=new TextField(30);
t6=new TextField(10);
t7=new TextField(10);

t1.setEditable(false);

b1=new Button("Submit");
b2=new Button("Reset");

c1=new Choice();
c2=new Choice();
c3=new Choice();
c4=new Choice();

c1.add("Web Designing");
c1.add("Application Project");
c1.add("Software Project");
c1.add("Android");

c2.add("Java");
c2.add("php");
c2.add("C++");
c2.add("Python");

c3.add("Android");
c3.add("IOS");
c3.add("Win8");
c3.add("Windows");

c4.add("MS SQL");
c4.add("MS Access");
c4.add("MS excel");

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);

setTitle("Client Window");
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

gc.gridx=0;
gc.gridy=1;
grid.setConstraints(l2,gc);
cont.add(l2);

gc.gridx=1;
gc.gridy=1;
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
grid.setConstraints(c1,gc);
cont.add(c1);

gc.gridx=0;
gc.gridy=6;
grid.setConstraints(l7,gc);
cont.add(l7);

gc.gridx=1;
gc.gridy=6;
grid.setConstraints(c2,gc);
cont.add(c2);

gc.gridx=2;
gc.gridy=6;
grid.setConstraints(l8,gc);
cont.add(l8);

gc.gridx=3;
gc.gridy=6;
grid.setConstraints(c3,gc);
cont.add(c3);

gc.gridx=0;
gc.gridy=7;
grid.setConstraints(l9,gc);
cont.add(l9);

gc.gridx=1;
gc.gridy=7;
grid.setConstraints(c4,gc);
cont.add(c4);

gc.gridx=0;
gc.gridy=8;
grid.setConstraints(l10,gc);
cont.add(l10);

gc.gridx=1;
gc.gridy=8;
grid.setConstraints(t6,gc);
cont.add(t6);

gc.gridx=2;
gc.gridy=8;
grid.setConstraints(l11,gc);
cont.add(l11);

gc.gridx=3;
gc.gridy=8;
grid.setConstraints(t7,gc);
cont.add(t7);

gc.gridx=0;
gc.gridy=9;
grid.setConstraints(b2,gc);
cont.add(b2);

gc.gridx=1;
gc.gridy=9;
grid.setConstraints(b1,gc);
cont.add(b1);

b1.addActionListener(this);
b2.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
c4.addItemListener(this);
}

public void itemStateChanged(ItemEvent e)
{
req=c1.getSelectedItem();
lang=c2.getSelectedItem();
plt=c3.getSelectedItem();
data=c4.getSelectedItem();
}

public void actionPerformed(ActionEvent e)
{
String msg=e.getActionCommand();
JOptionPane j=new JOptionPane();
JOptionPane jp=new JOptionPane();
JOptionPane jpp=new JOptionPane();

if(msg.equals("Reset"))
	{
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
	t7.setText("");
	count=0;
	}
else
	{
try
{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con1=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s=con1.createStatement();

		ResultSet r1=s.executeQuery("select client_id from client order by client_id");
		while(r1.next())
			{
			id=Integer.parseInt(r1.getString(1));
			}
id++;
t1.setText(id+"");
}

	catch(Exception rr)
	{
	jp.showMessageDialog(this,rr.getMessage());
	}


	if(t3.getText().length()==0)
		{
		jp.showMessageDialog(this,"please, Enter Your Address");
		}
	else
		{
		count++;
		}
//
	if(t4.getText().length()==0)
		{
		jp.showMessageDialog(this,"Please, Enter your Contact Number");
		}
	else
		{
		if(t4.getText().length()==10)
			{
			count++;
			}
		else
			{
			count=0;
			jpp.showMessageDialog(this,"Contact Number must contain 10 Digits only");
			ref=1;
			}
//
		int flag=0;
	if(ref==0)
	{
		for(int i=0;i<t4.getText().length();i++)
			{
			int no=t4.getText().charAt(i);
			if(no>=48 && no<=57)
				{
				}
			else
				{
				flag=1;
				break;
				}
			}
//
			if(flag==0)	
				{
				count++;
				}
			else
				{
				count=0;
				jpp.showMessageDialog(this,"Contact Number must contain 10 Digits");
				}
	}	
		}
//
	if(t5.getText().length()==0)
		{
		jp.showMessageDialog(this,"Please, Enter your E-mail address");
		}
	else
		{
		int n=t5.getText().length();
		int a=t5.getText().indexOf('@');
		int b=t5.getText().indexOf('@',a+1);
		int c=t5.getText().indexOf('.');
		int d=t5.getText().indexOf('.',c+1);
		int g=-1;
//
		if(d!=-1)
			{
			g=t5.getText().indexOf('.',d+1);
			}
//
		if(a==-1 || a==0 || a==n-1 || b!=-1 || c==-1 || c==a+1 || c==n-1 || d==c+1 || d==n-1 || g!=-1)
			{
			j.showMessageDialog(this,"Invalid E-Mail Address");
			count=0;
			}
		else
			{
			count++;
			}
		}
//

	if(t2.getText().length()==0)
		{
		jp.showMessageDialog(this,"Please, Enter Your Name");
		}
	else
		{
		count++;
		}
//
	if(t6.getText().length()==0)
		{
		jp.showMessageDialog(this,"Please, Enter the time duration in which you want your work to be done");
		}
	else
		{
		count++;
		}
//
	if(t7.getText().length()==0)
		{
		jp.showMessageDialog(this,"Please, Enter your budget amount");
		}
	else
		{
		count++;
		}

//
	if(req.length()==0)
		{
		jp.showMessageDialog(this,"Please, Choose the Type Of Request option");
		}
	else
		{
		count++;
		}
//
	if(lang.length()==0)
		{
		jp.showMessageDialog(this,"Please, Choose the Language option");
		}
	else
		{
		count++;
		}
//
	if(plt.length()==0)
		{
		jp.showMessageDialog(this,"Please, Choose the Platform option");
		}
	else
		{
		count++;
		}
//
	if(data.length()==0)
		{
		jp.showMessageDialog(this,"Please, Choose the DataBase option");
		}
	else
		{
		count++;
		}
	//

if(count==11)
{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();
		
				
		s1.executeUpdate("insert into client values('" + t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "','" + req + "','" + lang + "','" + plt + "','" + data + "','" +  t6.getText() + "','" +  t7.getText() + "')" );

//
	j.showMessageDialog(this,"The following record of the new Client has been saved successfully. Your Client ID is " + t1.getText());
		}

	catch(Exception r)
		{
		j.showMessageDialog(this,r.getMessage());
		}
req="";
lang="";
plt="";
data="";
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
	}
count=0;
}
}


public static void main(String arg[])
{
client clt=new client();
}
}