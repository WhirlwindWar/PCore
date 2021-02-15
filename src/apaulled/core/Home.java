package apaulled.core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Home extends SetHome {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can set their home lol");
            return true;
        }
        Player player = (Player) sender;
        if(args.length >= 1) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Correct Usage: /home");
        }

        else {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "yuh traveling yuh");
            player.teleport(home);
            player.sendMessage(String.valueOf(home));
        }
        return true;
    }
}
