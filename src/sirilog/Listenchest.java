package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;

public final class Listenchest implements Listener {
    @EventHandler
    public void onInventoryOpen(PlayerInteractEvent event) throws IOException{
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (event.getClickedBlock().getState() instanceof InventoryHolder || "ENDER_CHEST".equals(event.getClickedBlock().getType().toString())){
                Logsave.savebl(
                        event.getPlayer().getName(),                    // Who
                        "opened",                                       // What
                        event.getClickedBlock().getType().toString(),   // With what
                        event.getClickedBlock().getX(),                 // |
                        event.getClickedBlock().getY(),                 // |--> Where
                        event.getClickedBlock().getZ(),                 // |
                        event.getClickedBlock().getWorld().getName()    // Which world
                );
            }
        }
    }
}