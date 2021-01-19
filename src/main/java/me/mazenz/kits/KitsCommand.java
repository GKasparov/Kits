package me.mazenz.kits;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class KitsCommand implements CommandExecutor {
    private final Kits kits;

    public KitsCommand(Kits kits) {
        this.kits = kits;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("kits")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.YELLOW + "List of available kits:");
                    for (String kitnames : kits.getConfig().getConfigurationSection("kits").getKeys(false)) {
                        String[] eachname = kitnames.split("\\\\r?\\\\n");
                        for (String e : eachname) {
                            player.sendMessage(ChatColor.WHITE+ "[" + ChatColor.GREEN + e + ChatColor.WHITE + "]");
                        }
                    }

                } else {
                    player.sendMessage("Incorrect Syntax. /kits");
                }
            } else {
                System.out.println("This command can only be run in-game");
            }
        }
        return true;
    }
}