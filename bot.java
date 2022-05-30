import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import javax.security.auth.login.LoginException;

/*
  @Date 2022/05/30

 */
public class bot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDA jpa = JDABuilder.createDefault("OTU3NjgxMzIwMTY5OTcxNzMz.Gcx7l_.bU7xha7PIS1HMwAPKW5_DiWALlfHWgGv3YNozQ").build();
        jpa.addEventListener(new listener());
    }

}

