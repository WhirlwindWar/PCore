package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.List;

public class MultiKill implements Listener {
    HashMap<Player, Integer> multiKillList = new HashMap<>();
    Boolean isActive;
    @EventHandler
    public void onDie (EntityDeathEvent entityDeath) {
        Player player = entityDeath.getEntity().getKiller();
        if (!multiKillList.containsKey(player)) {
            multiKillList.put(player, 0);
        }
        int currentKills = multiKillList.get(player);
        multiKillList.put(player, currentKills + 1);
        player.sendMessage(String.valueOf(currentKills));
        isActive = true;
        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
            @Override
            public void run() {
                player.sendMessage("out debug 1");
                if (isActive) {
                    isActive = false;
                    player.sendMessage("debug 1");
                }
            }
            }, 40L);
        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
            @Override
            public void run() {
                player.sendMessage("out debug 2");
                if (!isActive) {
                    multiKillList.put(player, 0);
                    player.sendMessage("debug 2");
                }
            }
        }, 120L);
    }
}
