package qanyiovo.pvpcontrol;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import qanyiovo.pvpcontrol.command.pvpcp;


public final class papi extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null)
        {
            new expansion(this).register();
            this.getCommand("pvpcp").setExecutor(new pvpcp(this));
            getLogger().info("PVPControlPapi is enable.");
        }
        else {
            Bukkit.getPluginManager().disablePlugin(this);
            getLogger().info("Can't find PlaecholderAPI, PVPControlPapi is disable.");
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getPluginManager().disablePlugin(this);
    }
}
