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
            if (
                    event.getClickedBlock().getState() instanceof InventoryHolder ||
                    "ENDER_CHEST".equals(event.getClickedBlock().getType().toString()) ||
                    Configs.customchest.contains(event.getClickedBlock().getTypeId())
            ){
                new Logsave().savebl(
                        event.getPlayer().getName(),                    // Who
                        "opened",                                       // What
                        event.getClickedBlock().getType().toString(),   // With what
                        String.valueOf(event.getClickedBlock().getX()), // |
                        String.valueOf(event.getClickedBlock().getY()), // |--> Where
                        String.valueOf(event.getClickedBlock().getZ()), // |
                        event.getClickedBlock().getWorld().getName()    // Which world
                );
            }
        }
    }
}