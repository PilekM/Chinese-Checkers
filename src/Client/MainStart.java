package Client;

import java.awt.*;
import javax.swing.*;

public class MainStart
{
	//static MyServer server;
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
				//server.getInstance();
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setSize(965,748);
				frame.setResizable(false);
		});
	}
}