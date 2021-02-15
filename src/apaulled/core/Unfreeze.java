package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unfreeze implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target != null) {
                player.sendMessage(target.getName() + " has been un-frozen!");
                FreezeListener.List.remove(target.getName());
                return true;
            }
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }
        return true;
    }
}