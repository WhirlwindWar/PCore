package apaulled.core;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignHandler implements Listener {

    @EventHandler
    public void onChangeSign(SignChangeEvent signChange) {
        int i = 0;

        for (i = 0;i <= 3;i++) {
            String line = signChange.getLine(i);
            String lineFinal = ChatColor.translateAlternateColorCodes('&',line);
            signChange.setLine(i, lineFinal);
        }
    }
}
