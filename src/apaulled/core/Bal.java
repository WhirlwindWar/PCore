package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Bal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        Player target = (Player) sender;
        if (!Balances.currencies.containsKey(target)) {
            Balances.currencies.put(target, new HashMap<>());

            for (Balances bal : Balances.values()) {
                Balances.currencies.get(target).put(bal, 0);
            }
        }
        sender.sendMessage("Dollars: " + Balances.currencies.get(target).get(Balances.Dollars));
        sender.sendMessage("Euros: " + Balances.currencies.get(target).get(Balances.Euros));
        sender.sendMessage("Universal: " + Balances.currencies.get(target).get(Balances.Universal));
        return true;
    }
}
