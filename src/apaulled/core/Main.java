package apaulled.core;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("Mortgage").setExecutor(new Mortgage());
        this.getCommand("Sethome").setExecutor(new SetHome());
        this.getCommand("Home").setExecutor(new Home());
        this.getCommand("Fillinv").setExecutor(new Fillinv());
        this.getCommand("Kill").setExecutor(new Kill());
        this.getCommand("Freeze").setExecutor(new Freeze());
        this.getCommand("Unfreeze").setExecutor(new Unfreeze());
        this.getCommand("Eco").setExecutor(new Eco());
        this.getCommand("Bal").setExecutor(new Bal());
        this.getCommand("Party").setExecutor(new PartyCommands());
        this.getCommand("Friend").setExecutor(new FriendCommands());
        this.getServer().getPluginManager().registerEvents(new FreezeListener(),this);
        this.getServer().getPluginManager().registerEvents(new SignHandler(),this);
        this.getServer().getPluginManager().registerEvents(new WashDetector(),this);
        //Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.broadcastMessage(String.valueOf(Tips.announcement[index]), 20, 20);
    }
    @Override
    public void onDisable() {
    }
}

