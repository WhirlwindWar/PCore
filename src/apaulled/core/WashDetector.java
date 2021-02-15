package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CauldronLevelChangeEvent;

public class WashDetector implements Listener {

    @EventHandler
    public void onWash (CauldronLevelChangeEvent wash) {
        if (String.valueOf(wash.getReason()) == "ARMOR_WASH") {
            wash.setCancelled(true);
        }
    }
}
