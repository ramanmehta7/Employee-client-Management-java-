import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class user extends JFrame implements ActionListener
{
Label l1,l2;
TextField t1,t2;
Button b1,b2;

GridBagLayout grid;
GridBagConstraints gc;
Container cont = getContentPane();

public user()
{
l1=new Label("Username");
l2=new Label("Password");

t1=new TextField(20);
t2=new TextField(20);

t2.setEchoChar('*');

b1=new Button("Log in");
b2=new Button("Reset");

grid=new GridBagLayout();
gc=new GridBagConstraints();
cont.setLayout(grid);

setTitle("USER");
setVisible(true);
setBounds(150,150,400,400);

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
grid.setConstraints(b1,gc);
cont.add(b1);

gc.gridx=1;
gc.gridy=2;
grid.setConstraints(b2,gc);
cont.add(b2);

b1.addActionListener(this);
b2.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
String msg=e.getActionCommand();
JOptionPane jp=new JOptionPane();

if(msg.equals("Reset"))
{
t1.setText("");
t2.setText("");
}
else
{
if(t1.getText().equals("admin") && t2.getText().equals("admin"))
{
jp.showMessageDialog(this,"Access Provided");
company cmp=new company();
}
else
{
jp.showMessageDialog(this,"Log-in Unsuccessful");
}
}
}

public static void main(String arg[])
{
user us=new user();
}
}