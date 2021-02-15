package apaulled.core;

import org.bukkit.entity.Player;
import java.util.HashMap;

enum Balances {
    Dollars, Euros, Universal;
    public static HashMap<Player, HashMap<Balances, Integer>> currencies = new HashMap<>();
}
