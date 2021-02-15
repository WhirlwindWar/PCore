package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You must specify a player!");
            return true;
        }
        if (args.length >= 1) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target != null) {
                player.sendMessage(target.getName() + " has been frozen!");
                FreezeListener.List.add(target.getName());
                return true;
            }
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }
        return true;
    }
}