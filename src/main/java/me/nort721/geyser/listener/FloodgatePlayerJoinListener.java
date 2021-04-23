package me.nort721.geyser.listener;

import godseye.GodsEyeException;
import me.nort721.geyser.GodsEyeGeyserMC;
import me.nort721.geyser.GodsEyeGeyserMCAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;

public class FloodgatePlayerJoinListener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent e) throws GodsEyeException {
        Bukkit.getScheduler().runTaskLater(GodsEyeGeyserMC.getInstance(), new Runnable() {
            @Override
            public void run() {
                GodsEyeGeyserMCAPI.attemptBypassFloodgatePLayer(e.getPlayer());
            }
        }, GodsEyeGeyserMCAPI.getDelay() * 20L);
    }
}
