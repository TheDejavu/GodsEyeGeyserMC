package me.nort721.geyser.listener;

import godseye.GodsEyeException;
import me.nort721.geyser.GodsEyeGeyserMC;
import me.nort721.geyser.GodsEyeGeyserMCAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FloodgatePlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskLater(GodsEyeGeyserMC.getInstance(), () -> {
            try {
                GodsEyeGeyserMCAPI.attemptBypassFloodgatePLayer(e.getPlayer());
            } catch (GodsEyeException ex) {
                ex.printStackTrace();
            }
        }, GodsEyeGeyserMCAPI.getDelay() * 20L);
    }
}
