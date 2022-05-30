import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.MiscUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;


/*
    @Date 2022/05/30
 */
public class listener extends ListenerAdapter  {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String msg = e.getMessage().getContentRaw();


        if(msg.startsWith("!id")){
            /* List<User> dd = e.getJDA().getUsers();
            for (int i = 0; i < dd.size(); i++) {
                Long log = dd.get(i).getJDA().getSelfUser().getIdLong();
                logger.info("Id id: {}"  , String.valueOf(log));
            }
             */
            MessageChannel channel = e.getChannel();
            Long  id = Objects.requireNonNull(e.getMember()).getIdLong();
            logger.info(String.valueOf(id));
            User use = e.getJDA().getUserById(id);
            sayMsg(channel ,String.valueOf(id));
        }
        if(msg.startsWith("!role")){
            MessageChannel channel = e.getChannel();
            Long  id = Objects.requireNonNull(e.getMember()).getIdLong();

            sayMsg(channel, String.valueOf(id));

            User use = e.getMember().getUser();

            sayMsg(channel, String.valueOf(use));

            List<Role> role = use != null ? use.getJDA().getRoles() : null;

            for(int i = 0; i < (role != null ? role.size() : 0); i++){
                sayMsg(channel, "rkqt: " + String.valueOf(role.get(i)));
            }
        }

        if (msg.startsWith("!ping"))
        {
            MessageChannel channel = e.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Ping!")
                    .queue(response -> {
                        response.editMessageFormat("Ping: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }
    }
     private final Logger logger = LoggerFactory.getLogger(listener.class);
    @Override
    public void onGuildJoin(GuildJoinEvent event)
    {
        MessageChannel channel = event.getGuild().getSystemChannel();

        /* Long  id = Objects.requireNonNull(event.).getIdLong();
        User use = event.getJDA().getUserById(id);
        List<Role> role = use.getJDA().getRoles();
        for(int i = 0; i < role.size(); i++){
            sayMsg(channel, "rkqt: " + String.valueOf(role.get(i)));
        }

         */


        List<User> dd = event.getJDA().getUsers();
        for (int i = 0; i < dd.size(); i++) {
              Long log = dd.get(i).getJDA().getSelfUser().getIdLong();
              logger.info("Id id: {}"  , String.valueOf(log));
        }
    }
    private void sayMsg(MessageChannel channel, String msg) {
        channel.sendMessage(msg).queue();
    }
}
