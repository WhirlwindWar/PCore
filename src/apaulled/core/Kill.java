package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        if (args.length == 0) {
            Player player = (Player) sender;
            player.setHealth(0);
            return true;
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target != null) {
            target.setHealth(0);
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Player not found.");
        return true;
    }
}
