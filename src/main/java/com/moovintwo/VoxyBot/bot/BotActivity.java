package com.moovintwo.VoxyBot.bot;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.RichPresence;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;

public class BotActivity implements Activity {

    // Makes it easier for me to make activities

    String name;
    String state;
    ActivityType activityType;
    Boolean isRichPresence;

    public BotActivity(String name, String state, ActivityType activityType, Boolean isRichPresence) {
        this.name = name;
        this.state = state;
        this.activityType = activityType;
        this.isRichPresence = isRichPresence;
    }

    @Override
    public boolean isRich() {
        return isRichPresence;
    }

    @Override
    public RichPresence asRichPresence() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getUrl() {
        return "";
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }

    @Override
    public Timestamps getTimestamps() {
        return null;
    }

    @Override
    public EmojiUnion getEmoji() {
        return null;
    }

    @Override
    public Activity withState(String s) {
        return null;
    }
}
