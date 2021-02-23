package apaulled.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class Main extends JavaPlugin {
    public static JavaPlugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        this.getCommand("Mortgage").setExecutor(new Mortgage());
        this.getCommand("Fillinv").setExecutor(new Fillinv());
        this.getCommand("Kill").setExecutor(new Kill());
        this.getCommand("Freeze").setExecutor(new Freeze());
        this.getCommand("Unfreeze").setExecutor(new Unfreeze());
        this.getCommand("Eco").setExecutor(new Eco());
        this.getCommand("Bal").setExecutor(new Bal());
        this.getCommand("Friend").setExecutor(new FriendCommands());
        this.getCommand("Test").setExecutor(new Testing());
        this.getServer().getPluginManager().registerEvents(new FreezeListener(),this);
        this.getServer().getPluginManager().registerEvents(new SignHandler(),this);
        this.getServer().getPluginManager().registerEvents(new WashDetector(),this);
        this.getServer().getPluginManager().registerEvents(new MultiKill(),this);
        /*BukkitTask task = new BukkitRunnable() {
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.isSneaking()) {
                        player.sendMessage(Tips.getTip());
                    }
                }
            }
        }.runTaskTimer(this,0,120);*/
    }
    @Override
    public void onDisable() {
    }
    public static JavaPlugin getPlugin() {
        return plugin;
    }
}

