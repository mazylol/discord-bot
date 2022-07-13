package me.mazylol.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.awt.*;


public class BotCommands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("fart")) {

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Fart");
            eb.setDescription("A massive fart :skunk:");
            eb.setColor(Color.blue);

            event.replyEmbeds(eb.build()).queue();

        } else if (event.getName().equals("food")) {

            OptionMapping option = event.getOption("name");

            if (option == null) {
                event.reply("for some reason a food was not provided").queue();
                return;
            }

            String favoriteFood = option.getAsString();

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Your favorite food is:");
            eb.setDescription(favoriteFood);
            eb.setColor(Color.blue);

            event.replyEmbeds(eb.build()).queue();


        } else if (event.getName().equals("sum")) {

            OptionMapping operand1 = event.getOption("operand1");
            OptionMapping operand2 = event.getOption("operand2");

            if (operand1 == null || operand2 == null) {
                event.reply("No numbers were provided.").queue();
                return;
            }

            String sum = String.valueOf(operand1.getAsInt() + operand2.getAsInt());

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Sum", null);
            eb.setDescription(sum);
            eb.setColor(Color.blue);

            event.replyEmbeds(eb.build()).queue();

        }

    }
}