package com.moovintwo.VoxyBot.bot.listeners;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;


import static net.dv8tion.jda.api.interactions.commands.OptionType.STRING;

public class SlashCommands extends ListenerAdapter {

    // Same thing with msg listener, actively no use for this

    public SlashCommands(CommandListUpdateAction commands) {

        /*commands.addCommands(Commands.slash("say", "Makes the bot say what you tell it to")
                .setContexts(InteractionContextType.ALL)
                .setIntegrationTypes(IntegrationType.ALL)
                .addOption(STRING, "content", "What the bot should say", true));*/


        commands.queue();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        // Only accept commands from guilds
        if (event.getGuild() == null) { return; }
        switch (event.getName()) {
            case "say":
                // content is required so no null-check here
                say(event, event.getOption("content").getAsString());
                break;
            default:
                event.reply("I can't handle that command right now :(")
                        .setEphemeral(true)
                        .queue();
        }
    }

    public void say(SlashCommandInteractionEvent event, String content) {
        // This requires no permissions
        event.reply(content).queue();
    }

}