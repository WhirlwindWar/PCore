package apaulled.core;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Fillinv implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        Player player = (Player) sender;
        String material = args[0].toUpperCase();
        Material validCheck = Material.matchMaterial(material);
        if(validCheck == null) {
            player.sendMessage("You have entered an invalid item ID, try again.");
        }
        else if(args.length == 1) {
            // /fillinv <item>
            ItemStack itemStack = new ItemStack(Material.STRING.valueOf(material), 2304);
            player.getInventory().addItem(itemStack);
        }
        else {
            player.sendMessage("Usage: /fillinv <item>");
        }
        return true;
    }
}
