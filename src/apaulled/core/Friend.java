package apaulled.core;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Friend {
    static HashMap<Player, List<Player>> friendInvitesList = new HashMap<>();
    static HashMap<Player, List<Friend>> friendList = new HashMap<>();
    static HashMap<Player, List<Player>> friendRequestsList = new HashMap<>();
    private Player player;
    private String display;
    private List<Friend> friends = new ArrayList<Friend>();
    private List<Player> friendInvites = new ArrayList<Player>();
    private List<Player> friendRequests = new ArrayList<Player>();
    List<Player> friendInvitesTarget = new ArrayList<Player>();
    List<Friend> friendsTarget = new ArrayList<Friend>();
    List<Player> friendRequestsTarget = new ArrayList<Player>();
    private Player target;

    public Friend(Player player) {
        this.player = player;
        this.display = player.getDisplayName();
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Friend> getFriends() {
        List<Friend> friends = friendList.get(player);
        return friends;
    }

    public List<Player> getFriendInvites() {
        List<Player> friendInvites = friendInvitesList.get(player);
        return friendInvites;
    }

    public List<Player> getFriendRequests() {
        List<Player> friendRequests = friendRequestsList.get(player);
        return friendRequests;
    }

    public boolean isFriend(Player target) {
        List<Friend> friends = friendList.get(player);
        return friends.contains(target);
    }

    boolean hasFriendRequest(Player target) {
        List<Player> friendInvites = friendInvitesList.get(player);
        return friendInvites.contains(target);
    }

    void removeRequest (Player target) {
        friendInvitesTarget.remove(player);
        friendInvitesList.put(target,friendInvitesTarget);
        friendRequests.remove(target);
        friendRequestsList.put(player,friendRequests);
    }

    void addFriend(Player target) {
            Friend targetFriend = new Friend(target);
            Friend sourceFriend = new Friend(player);
            if (!friendList.containsKey(player)) {
                Friend.friendList.put(player,new ArrayList<Friend>());
            }
            if (!friendList.containsKey(target)) {
                Friend.friendList.put(target, new ArrayList<Friend>());
            }
            friends = friendList.get(player);
            friendsTarget = friendList.get(target);
            if (!friends.contains(targetFriend)) {
                friends.add(targetFriend);
                Friend.friendList.put(player,friends);
                friendsTarget.add(sourceFriend);
                Friend.friendList.put(target,friendsTarget);
                player.sendMessage(ChatColor.GREEN + "You are now friends with " + target.getDisplayName() + ".");
                target.sendMessage(ChatColor.GREEN + "You are now friends with " + player.getDisplayName() + ".");
                removeRequest(target);
            }
        }

    public void sendRequest(Player target) {

        if (!friendInvitesList.containsKey(player)) {
            Friend.friendInvitesList.put(player,new ArrayList<Player>());
        }
        if (!friendInvitesList.containsKey(target)) {
            Friend.friendInvitesList.put(target, new ArrayList<Player>());
        }
        if (!friendRequestsList.containsKey(target)) {
            Friend.friendRequestsList.put(target, new ArrayList<Player>());
        }
        friendInvitesTarget = friendInvitesList.get(target);
        friendInvites = friendInvitesList.get(player);
        friendRequestsTarget = friendRequestsList.get(target);
        if (!friendInvites.contains(target) && !friendInvitesTarget.contains(player)) {
            friendInvites.add(target);
            Friend.friendInvitesList.put(player,friendInvites);
            friendRequestsTarget.add(player);
            Friend.friendRequestsList.put(target,friendRequestsTarget);
            player.sendMessage(ChatColor.GREEN + "A friend request has been sent to " + target.getDisplayName() + ".");
            target.sendMessage(ChatColor.GREEN + player.getDisplayName() + " wants to be friends with you.");
        }
    }

    public void requestProcess (Player target) {
        sendRequest(target);
        if (friendInvitesTarget.contains(player)) {
            addFriend(target);
        }
    }

    public void removeFriend (Player target) {
        Friend targetFriend = new Friend(target);
        Friend sourceFriend = new Friend(player);
        friends = friendList.get(player);
        friendsTarget = friendList.get(target);
        player.sendMessage("1" + String.valueOf(friends));
        player.sendMessage("2" + String.valueOf(friendsTarget));
        if (friends.contains(targetFriend)) {
            friends.remove(targetFriend);
            Friend.friendList.put(player,friends);
            friendsTarget.remove(sourceFriend);
            Friend.friendList.put(target,friends);
            player.sendMessage("3" + String.valueOf(friends));
            player.sendMessage("4" + String.valueOf(friendsTarget));
        }
        player.sendMessage(ChatColor.RED + "You are no longer friends with " + target.getDisplayName() + ". They have been notified of your dumb bitchery.");
        target.sendMessage(ChatColor.RED + player.getDisplayName() + " no longer wants to be your friend. What's the tea, sis?");
    }
}