package qanyiovo.pvpcontrol;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class expansion extends PlaceholderExpansion {

    private final JavaPlugin plugin;

    public expansion(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "PVPControlPapi";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Qianyiovo";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params){
        if (params.equalsIgnoreCase("mode"))
        {
            if (!((Player)player).hasMetadata("pvpmode.admin")){
                return this.plugin.getConfig().getString("pvp_on");
            }
            else {
                return this.plugin.getConfig().getString("pvp_off");
            }
        }
        return null;
    }
}
