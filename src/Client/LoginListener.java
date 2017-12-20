package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import static Client.MainStart.server;

public class LoginListener implements ActionListener {
    String name;
    LoginPanel panel;

    public LoginListener(LoginPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           name = panel.getName();
       //    server.send("SETNAME~"+name);
    }
}
