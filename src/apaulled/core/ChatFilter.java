package apaulled.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFilter implements Listener {

    @EventHandler
    public void onSwear(AsyncPlayerChatEvent swear) {
        String message = swear.getMessage().toLowerCase();
        if (message.contains("fuck")) {
            swear.setCancelled(true);
        }
    else;
    }
}
