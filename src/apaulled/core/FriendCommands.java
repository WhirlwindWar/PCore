package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FriendCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        Player source = (Player) sender;
        Friend friend = new Friend(source);

        //friend list
        if (args[0].equalsIgnoreCase("list")) {
            source.sendMessage(ChatColor.BLUE + "Friends:");
            source.sendMessage(ChatColor.BLUE + "--------");
            for (Friend targetFriends : friend.getFriends()) {
                source.sendMessage(targetFriends.getPlayer().getDisplayName());
            }
            return true;
        }

        //friend invites
        if (args[0].equalsIgnoreCase("invites")) {
            source.sendMessage(ChatColor.BLUE + "Pending Friend Invites:");
            source.sendMessage(ChatColor.BLUE + "------------------------");
            for (Player targetFriendInvites : friend.getFriendInvites()) {
                source.sendMessage(targetFriendInvites.getPlayer().getDisplayName());
            }
            return true;
        }

        //friend requests
        if (args[0].equalsIgnoreCase("requests")) {
            source.sendMessage(ChatColor.BLUE + "Pending Friend Requests:");
            source.sendMessage(ChatColor.BLUE + "------------------------");
            for (Player targetFriendRequests : friend.getFriendRequests()) {
                source.sendMessage(targetFriendRequests.getPlayer().getDisplayName());
            }
            return true;
        }

        //friend add
        if (args[0].equalsIgnoreCase("add")) {
            friend.requestProcess(Bukkit.getPlayer(args[1]));
            return true;
        }

        //friend remove
        if (args[0].equalsIgnoreCase("remove")) {
            friend.removeFriend(Bukkit.getPlayer(args[1]));
            return true;
        }
        return true;
    }
}
