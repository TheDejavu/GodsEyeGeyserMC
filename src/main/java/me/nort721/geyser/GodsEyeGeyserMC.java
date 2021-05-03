package me.nort721.geyser;

import lombok.Getter;
import me.nort721.geyser.listener.FloodgatePlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class GodsEyeGeyserMC extends JavaPlugin implements Listener {

    @Getter
    private static GodsEyeGeyserMC instance;
    Plugin plugin = getServer().getPluginManager().getPlugin("GodsEye");
    YamlConfiguration conf = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "checks.yml"));

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new FloodgatePlayerJoinListener(), this);
        GodsEyeGeyserMCAPI.setDelay(conf.getInt("Login checks activation delay"));
        getLogger().info(getDescription().getName() + " GodsEyeGeyserFixer has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " GodsEyeGeyserFixer has been disabled");
    }
}
