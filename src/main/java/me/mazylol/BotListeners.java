package me.mazylol;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class BotListeners extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (!event.getAuthor().isBot()) {
            String messageSent = event.getMessage().getContentRaw();

            if (messageSent.equals("UwU") || messageSent.equals("uwu")) {

                event.getGuildChannel().sendMessage("Kill yourself!").queue();

            }
        }
    }
}