package me.nort721.geyser;

import godseye.GodsEyeAPI;
import godseye.GodsEyeException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.floodgate.FloodgateAPI;

import java.io.File;

public final class GodsEyeGeyserMC extends JavaPlugin implements Listener {
    Plugin plugin= getServer().getPluginManager().getPlugin("GodsEye");
    YamlConfiguration conf = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "checks.yml"));
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(getDescription().getName() + " GodsEyeGeyserFixer has been enabled");
        getLogger().info(getDescription().getName() + " activation delay: " + conf.getInt("Login checks activation delay"));
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " GodsEyeGeyserFixer has been disabled");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent e) throws GodsEyeException {

        Bukkit.getScheduler().runTaskLater(this, new Runnable() {
            @Override
            public void run() {
                if (FloodgateAPI.isBedrockPlayer(e.getPlayer()) && GodsEyeAPI.hasProfile(e.getPlayer())) {
                    GodsEyeAPI.setBypassed(e.getPlayer(), true);
                    getLogger().info(getDescription().getName() + " added " + e.getPlayer().getName() + " to bypassed players");
                }
            }
        }, conf.getInt("Login checks activation delay") * 20L);
    }
}
