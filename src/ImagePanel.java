import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel
{	
	//private Image image;
	private JButton host = new JButton("Host");
	private JButton join = new JButton("wolf.png");

	public MenuPanel()
	{
		//image = new ImageIcon("gif.png").getImage();
		//button = new JButton("hehe");
		//this.add(new JButton("hehe"));
		add(host);
		add(join);
		
	}
	
	
	
	public void paintsthpls(Graphics g)
	{	
		//g.drawImage(image, 20, 20, null);	
		//g.drawRect(40,40,40,40);

	}
	
		@Override
    public void paintComponent(Graphics g) 
	{
        //super.paintComponent(g);  
        paintsthpls(g);        
    }
}