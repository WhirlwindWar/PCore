package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        if(args.length == 3) {
            // /mortgage <principal> <annual interest rate> <period>
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Calculating...");
            MortgageCalculator mortgageCalculator = new MortgageCalculator();
            int principal = Integer.parseInt(args[0]);
            float annualInterest = Float.parseFloat(args[1]);
            byte period = Byte.parseByte(args[2]);
            double mortgage  = mortgageCalculator.calculateMortgage(principal,annualInterest,period);
            String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
            player.sendMessage(String.valueOf(mortgageFormatted));

        }

        else {
            player.sendMessage("Usage: /mortgage <principal> <annual interest rate> <period>");
        }
        return true;
    }
}
