package com.moovintwo.VoxyBot.bot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.logging.Logger;

public class MessageListener extends ListenerAdapter
{

    Logger logger;

    public MessageListener(Logger logger)
    {

        this.logger = logger;

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        /*if (event.isFromType(ChannelType.PRIVATE))
        {

            logger.log(Level.INFO, String.format("[PM] %s: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay()));

        }
        else
        {

            logger.log(Level.INFO, String.format("[%s][%s] %s: %s\n", event.getGuild().getName(), event.getChannel().getName(), event.getMember().getEffectiveName(), event.getMessage().getContentDisplay()));

        }*/
    }
}
