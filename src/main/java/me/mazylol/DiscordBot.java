package me.mazylol;

import me.mazylol.commands.BotCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    public static void main(String[] args) throws LoginException, InterruptedException {
        Dotenv dotenv;
        dotenv = Dotenv.configure().load();
        JDA bot = JDABuilder.createDefault(dotenv.get("TOKEN"))
                .setActivity(Activity.playing("with your mom"))
                .addEventListeners(new BotCommands(), new BotListeners())
                .build().awaitReady();

        Guild guild = bot.getGuildById("823309399317676083");

        if (guild != null) {
            guild.upsertCommand("fart", "Fart really hard").queue();
            guild.upsertCommand("food", "Name your favorite food.")
                    .addOption(OptionType.STRING, "name", "The name of your favorite food", true)
                    .queue();
            guild.upsertCommand("sum", "Adds two numbers together")
                    .addOption(OptionType.INTEGER, "operand1", "the first number", true)
                    .addOption(OptionType.INTEGER, "operand2", "the second number", true)
                    .queue();
        }

    }

}