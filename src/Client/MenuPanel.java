package Client;

import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel
{	
	//private Image image;
	private JButton host = new JButton(new ImageIcon("src/Client/host.png"));
	//private JButton join = new JButton(new ImageIcon("gif.png"));
	private JButton join = new JButton(new ImageIcon("src/Client/join.png"));
	//Image background = Toolkit.getDefaultToolkit().createImage("halmafinal.png");
	private Image background; 
	
	public MenuPanel()
	{
		//image = new ImageIcon("gif.png").getImage();
		//button = new JButton("hehe");
		//this.add(new JButton("hehe"));
		background = new ImageIcon("src/Client/halmafinal.png").getImage();

		this.setLayout(null);
		add(host);
		add(join);
		//host.setPreferredSize(new Dimension(10,50));
		host.setBounds(441,471,81,30);
		//join.setPreferredSize(new Dimension(10,50));
		join.setBounds(441,519,81,30);

		//host.setBorderPainted(false); <-pozniej sie usunie komentarz
		//join.setBorderPainted(false);
		
	}
	
	
	
	public void paintsthpls(Graphics g)
	{	
		//g.drawImage(image, 20, 20, null);	
		//g.drawRect(40,40,40,40);
		g.drawImage(background, 0, 0, null);

	}
	
		@Override
    public void paintComponent(Graphics g) 
	{
        //super.paintComponent(g);  
        paintsthpls(g);        
    }
}