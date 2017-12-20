package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Client.MainStart.server;

public class LoginListener implements ActionListener {
    String name;
    LoginPanel panel;

    public LoginListener(LoginPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        name = panel.getLoginField().getName();
        if (name == null) {
            panel.getLoginField().setText("You have to enter a name.");
        } else {
            server.send("SETNAME~"+name);
        }

    }
}

