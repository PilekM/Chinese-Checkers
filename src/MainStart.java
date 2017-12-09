import java.awt.*;
import javax.swing.*;

public class MainStart
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
		});
	}
}