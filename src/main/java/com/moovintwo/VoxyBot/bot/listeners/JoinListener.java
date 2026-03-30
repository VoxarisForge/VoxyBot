package com.moovintwo.VoxyBot.bot.listeners;


import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class JoinListener extends ListenerAdapter
{

    Logger logger;

    public JoinListener(Logger logger)
    {
        this.logger = logger;
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        Random rand = new Random();

        // Simplifies the strings into variables to use
        String logo = "<:voxarisforge:1488039474138185758>";
        String lineSeparator = System.lineSeparator();
        String welcomeFooter = logo + " **  Welcome to Voxaris Forge! ** " + logo;

        // List of possible welcome messages
        ArrayList<String> welcomeMessages = new ArrayList<>();
        welcomeMessages.add("** has joined the Party! ** 🎉");
        welcomeMessages.add("** entered the Arena ** ⚔️");
        welcomeMessages.add("** slid into the room ** 🚪");

        if (!event.getUser().isBot()) {
            TextChannel systemChannel = event.getGuild().getSystemChannel();
            if (systemChannel != null) {
                int randomInt = rand.nextInt(welcomeMessages.size());
                String welcomeMessage = welcomeMessages.get(randomInt);
                // Combines the strings and sends the message
                systemChannel.sendMessage(welcomeFooter + lineSeparator + lineSeparator + event.getUser().getAsMention() + welcomeMessage).queue();
            }
        }
    }
}
