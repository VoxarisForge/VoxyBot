package com.moovintwo.VoxyBot.bot;


import com.moovintwo.VoxyBot.EnvReader;
import com.moovintwo.VoxyBot.bot.listeners.JoinListener;
import com.moovintwo.VoxyBot.bot.listeners.MessageListener;
import com.moovintwo.VoxyBot.bot.listeners.ReadyListener;
import com.moovintwo.VoxyBot.bot.listeners.SlashCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.logging.Logger;

public class Bot {

    // The initial class for the bot to function

    public Bot(String name) throws InterruptedException {

        EnvReader envReader = new EnvReader();
        Logger logger = Logger.getLogger(name);

        // Initializes the EnvReader
        envReader.init();

        // Creates the Activity the bot will play
        BotActivity activity = new BotActivity("Minecraft", "Adding a Fish", Activity.ActivityType.PLAYING, true);

        JDA jda = JDABuilder.createDefault(envReader.getBotToken())
                .setActivity(activity)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
                .build();

        // Adds the listeners
        jda.addEventListener(new JoinListener(logger));
        jda.addEventListener(new MessageListener(logger));
        jda.addEventListener(new ReadyListener());
        jda.addEventListener(new SlashCommands(jda.updateCommands()));

        jda.awaitReady();

    }

}
