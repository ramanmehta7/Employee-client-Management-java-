import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class employee extends JFrame implements ActionListener,ItemListener
{
String dep="",des="",exp="";
int count=0,ref=0;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
Button b1,b2;
TextField  t1,t2,t3,t4,t5;
Choice c1,c2,c3;
CheckboxGroup gender;
Checkbox male,female;

GridBagLayout grid;
GridBagConstraints gc;
Container cont=getContentPane();

public employee()
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

b1=new Button("Submit");
b2=new Button("Reset");

t1=new TextField(20);
t2=new TextField(20);
t3=new TextField(30);
t4=new TextField(20);
t5=new TextField(30);

c1=new Choice();
c2=new Choice();
c3=new Choice();

c1.add("Web Designing");
c1.add("Android Development");
c1.add("Application Development");
c1.add("Information Security");
c1.add("Software Development");

c2.add("Programmer");
c2.add("Designer");
c2.add("Tester");
c2.add("Operator");
c2.add("Care Taker");
c2.add("Security");

c3.add("Android");
c3.add("Web Development");
c3.add("Designing");
c3.add("Information Security");
c3.add("Application Project");

gender=new CheckboxGroup();

male=new Checkbox("Male",gender,false);
female=new Checkbox("Female",gender,false);

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
grid.setConstraints(c1,gc);
cont.add(c1);

gc.gridx=2;
gc.gridy=2;
grid.setConstraints(l4,gc);
cont.add(l4);

gc.gridx=3;
gc.gridy=2;
grid.setConstraints(c2,gc);
cont.add(c2);

gc.gridx=0;
gc.gridy=3;
grid.setConstraints(l5,gc);
cont.add(l5);

gc.gridx=1;
gc.gridy=3;
grid.setConstraints(male,gc);
cont.add(male);

gc.gridx=2;
gc.gridy=3;
grid.setConstraints(female,gc);
cont.add(female);

gc.gridx=0;
gc.gridy=4;
grid.setConstraints(l6,gc);
cont.add(l6);

gc.gridx=1;
gc.gridy=4;
grid.setConstraints(t3,gc);
cont.add(t3);

gc.gridx=0;
gc.gridy=5;
grid.setConstraints(l7,gc);
cont.add(l7);

gc.gridx=1;
gc.gridy=5;
grid.setConstraints(t4,gc);
cont.add(t4);

gc.gridx=2;
gc.gridy=5;
grid.setConstraints(l8,gc);
cont.add(l8);

gc.gridx=3;
gc.gridy=5;
grid.setConstraints(t5,gc);
cont.add(t5);

gc.gridx=0;
gc.gridy=6;
grid.setConstraints(l9,gc);
cont.add(l9);

gc.gridx=1;
gc.gridy=6;
grid.setConstraints(c3,gc);
cont.add(c3);

gc.gridx=0;
gc.gridy=7;
grid.setConstraints(b1,gc);
cont.add(b1);

gc.gridx=1;
gc.gridy=7;
grid.setConstraints(b2,gc);
cont.add(b2);

setTitle("Employee Section");
setVisible(true);
setBounds(0,0,1920,1080);

b1.addActionListener(this);
b2.addActionListener(this);

c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
}

//

public void itemStateChanged(ItemEvent e)
{
dep=c1.getSelectedItem();
des=c2.getSelectedItem();
exp=c3.getSelectedItem();
}

//

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
	male.setState(false);
	female.setState(false);
	dep="";
	des="";
	exp="";
	}
else
	{
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

	if(t1.getText().length()==0)
		{
		jp.showMessageDialog(this,"Please, Enter the Employee I'D");
		}
	else
		{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con.createStatement();
		
		ResultSet rs=s1.executeQuery("select employee_id from employee where employee_id=" + "'" + t1.getText() + "'");

		while(rs.next())
		{
		jp.showMessageDialog(this,"This Employee ID already exists");
		count=0;
		}
		}
		catch(Exception r)
		{
		jp.showMessageDialog(this,r.getMessage());
		}
		count++;
		}

//

if(count==6)
{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con1=DriverManager.getConnection("jdbc:odbc:javadata","sa","ram");
		Statement s1=con1.createStatement();
		
		String gen="";
		if(male.getState()==true)
			{
			gen=male.getLabel();
			}
		else
			{
			gen=female.getLabel();
			}
//
		
		s1.executeUpdate("insert into employee values('" + t1.getText() + "','" + t2.getText() + "','" + dep + "','" + des + "','" + gen + "','" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "','" + exp + "')" );

//
	j.showMessageDialog(this,"The following record of the new Employee has been saved successfully");

	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	male.setState(false);
	female.setState(false);
	dep="";
	des="";
	exp="";	

	}

	catch(Exception r)
		{
		j.showMessageDialog(this,r.getMessage());
		}
	}
count=0;
}
}

public static void main(String arg[])
{
employee emp=new employee();
}

}