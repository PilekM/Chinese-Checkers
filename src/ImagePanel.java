import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel
{	
	private Image image;

	public ImagePanel()
	{
		image = new ImageIcon("wolf.png").getImage();
	}
	
	
	
	public void paintsthpls(Graphics g)
	{	
		g.drawImage(image, 20, 20, null);
			
		g.drawRect(40,40,40,40);

	}
	
		@Override
    public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);  
        paintsthpls(g);        
    }
}