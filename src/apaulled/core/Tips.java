package apaulled.core;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Tips extends JavaPlugin {
    public static String getTip() {
        List<String> tipMessages = Arrays.asList("deniz is not cool", "deniz is indeed cool", "no ma'am");
        Random rand = new Random();
        int randomitem = rand.nextInt(tipMessages.size());
        String randomMessage = tipMessages.get(randomitem);
        return randomMessage;
    }
}