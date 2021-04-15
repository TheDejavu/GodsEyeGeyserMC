package me.nort721.geyser;

import godseye.GodsEyeAPI;
import godseye.GodsEyeException;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.floodgate.FloodgateAPI;

public final class GodsEyeGeyserMC extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(getDescription().getName() + " GodsEyeGeyserFixer has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " GodsEyeGeyserFixer has been disabled");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent e) throws GodsEyeException {
        if (FloodgateAPI.isBedrockPlayer(e.getPlayer()) && GodsEyeAPI.hasProfile(e.getPlayer())) {
            GodsEyeAPI.setBypassed(e.getPlayer(), true);
            getLogger().info(getDescription().getName() + " added " + e.getPlayer().getName() + " to bypassed players");
        }
    }
}
