package Client;

import javax.swing.*;
import java.awt.*;


public class LoginPanel extends JPanel {

    private JTextField loginField;
    private JButton loginButton;
    private String name;
    private LoginListener loginListener;

    public LoginPanel(){
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        createComponents();
        }

    public String getName(){
        name = loginField.getText();
        return name;
    }

    private void createComponents(){
        JLabel name = new JLabel("Type your nickname below: ");
        loginField = new JTextField(15);

        loginListener = new LoginListener(this);

        loginButton = new JButton("Confirm");
        loginButton.addActionListener(loginListener);

        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new BorderLayout());
        helpPanel.add(name,BorderLayout.NORTH);
        helpPanel.add(loginField, BorderLayout.CENTER);
        helpPanel.add(loginButton, BorderLayout.SOUTH);

        this.add(helpPanel);
    }
}
