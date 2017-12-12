import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel
{	
	public ImagePanel()
	{
		//image = new ImageIcon("wolf").getImage();
	}
	
	public void paintsthpls(Graphics g)
	{	
		g.drawImage("wolf.png", 20, 20, null);
			
		g.drawRect(40,40,40,40);

	}
}