import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class company extends JFrame implements ActionListener
{
MenuBar bar;
Menu menu1,menu2,menu3;
MenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10;
JLabel l=new JLabel();
JPanel jp=new JPanel();

public company()
{
bar=new MenuBar();

menu1=new Menu("Employee");
menu2=new Menu("Client");
menu3=new Menu("Analyse");

item1=new MenuItem("New");
item2=new MenuItem("Search");
item3=new MenuItem("Update Details");
item4=new MenuItem("Delete");

item5=new MenuItem("Add New");
item6=new MenuItem("Search Client");
item7=new MenuItem("Update Client Details");
item8=new MenuItem("Delete Details");

item9=new MenuItem("Analysis Phase");
item10=new MenuItem("Assign Work");

menu1.add(item1);
menu1.add(item2);
menu1.add(item3);
menu1.add(item4);

menu2.add(item5);
menu2.add(item6);
menu2.add(item7);
menu2.add(item8);

menu3.add(item9);
menu3.add(item10);

bar.add(menu1);
bar.add(menu2);
bar.add(menu3);

setMenuBar(bar);

setTitle("company");
setVisible(true);
setBounds(0,0,1920,1080);

l.setIcon(new ImageIcon("C:\\Users\\Desktop\\Programing\\Java\\Project\\614445570.jpg"));

jp.add(l);

add(jp);

validate();

item1.addActionListener(this);
item2.addActionListener(this);
item3.addActionListener(this);
item4.addActionListener(this);
item5.addActionListener(this);
item6.addActionListener(this);
item7.addActionListener(this);
item8.addActionListener(this);
item9.addActionListener(this);
item10.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
String msg=e.getActionCommand();

if(msg.equals("New"))
{
employee emp=new employee();
}

else if(msg.equals("Search"))
{
search_emp emp=new search_emp();
}

else if(msg.equals("Update Details"))
{
update_emp emp=new update_emp();
}

else if(msg.equals("Delete"))
{
delete_emp emp=new delete_emp();
}

else if(msg.equals("Add New"))
{
client emp=new client();
}

else if(msg.equals("Search Client"))
{
search_clt emp=new search_clt();
}

else if(msg.equals("Update Client Details"))
{
update_clt emp=new update_clt();
}

else if(msg.equals("Delete Client Details"))
{
delete_clt emp=new delete_clt();
}

else if(msg.equals("Analysis Phase"))
{
phases emp=new phases();
}

else if(msg.equals("Assign Work"))
{
assign emp=new assign();
}

}

public static void main(String arg[])
{
company cmp=new company();
}
}