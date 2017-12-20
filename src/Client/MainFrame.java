package Client;

import javax.swing.*;

public class MainFrame extends JFrame
{
	public MainFrame()
	{
		setSize(640,320);
		setTitle("The best game ever made GOTY Edition");
		add(new LoginPanel());
	}
}