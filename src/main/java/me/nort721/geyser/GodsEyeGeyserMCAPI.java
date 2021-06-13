package me.nort721.geyser;

import godseye.GodsEyeAPI;
import lombok.Getter;
import lombok.Setter;
import me.nort721.geyser.event.GodsEyeGeyserBypassEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.FloodgateAPI;

public class GodsEyeGeyserMCAPI {

    @Getter
    @Setter
    private static int delay;

    public static void attemptBypassFloodgatePLayer(Player player){
        GodsEyeGeyserBypassEvent event = new GodsEyeGeyserBypassEvent(player);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            if(!player.isOnline()) {
                return;
            }
            event.setCancelled(true);
            return;
        }
        if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId()) && GodsEyeAPI.hasProfile(player)) {
            GodsEyeAPI.setBypassed(player, true);
            Bukkit.getLogger().info("[GodsEyeGeyserMC] added " + player.getName() + " to bypassed players");
        }
    }
}
