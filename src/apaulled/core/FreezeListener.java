package apaulled.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.Set;

public class FreezeListener implements Listener {
    public static Set<String> List = new HashSet<String>();

    @EventHandler
    public void onMove (PlayerMoveEvent move) {
        if (List.contains(move.getPlayer().getName())) {
            move.setCancelled(true);
        }
    }
}