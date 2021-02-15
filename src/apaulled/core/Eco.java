package apaulled.core;

import org.apache.commons.lang3.EnumUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Eco implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        if (args.length != 4) {
            sender.sendMessage(ChatColor.RED + "Correct usage: /eco <give/take> <player> <currency> <amount>");
            return true;
        }
        if (!args[0].equalsIgnoreCase("give") && !args[0].equalsIgnoreCase("take")) {
            sender.sendMessage(ChatColor.RED + "You can only 'give' or 'take' currency");
            return true;
        }

        try {
            Integer.parseInt(args[3]);
        }catch (NumberFormatException ex) { sender.sendMessage(ChatColor.RED + "You must enter a valid integer for an amount");
        return true;
        }

        if (!EnumUtils.isValidEnum(Balances.class, args[2])) {
            sender.sendMessage(ChatColor.RED + "You must enter a valid currency");
            return true;
        }

        // note: this also works if u need it
        /*try {
            Balance bal = Balances.valueOf(args[2]);
        }
        catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "You must enter a valid currency");
            return true;
        }*/

        Player target = Bukkit.getPlayer(args[1]);
        Balances currencyType = Balances.valueOf(args[2]);
        int changedAmount = Integer.parseInt(args[3]);
        String display = target.getDisplayName();

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }

        if (!Balances.currencies.containsKey(target)) {
            Balances.currencies.put(target, new HashMap<>());

            for (Balances bal : Balances.values()) {
                Balances.currencies.get(target).put(bal, 0);
            }
        }

        if (args[0].equalsIgnoreCase("give")) {
            int initialDollars = Balances.currencies.get(target).get(currencyType);
            Balances.currencies.get(target).put(currencyType, initialDollars + changedAmount);
            sender.sendMessage(display + " has been given " + changedAmount + " " + currencyType);
            return true;
        }

        if (args[0].equalsIgnoreCase("take")) {
            int initialDollars = Balances.currencies.get(target).get(currencyType);
            Balances.currencies.get(target).put(currencyType, initialDollars - changedAmount);
            sender.sendMessage(changedAmount + " " + currencyType + " have been taken from " + display);
            return true;
        }
        return true;
    }
}
