package sirilog;

import java.io.IOException;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public final class listenchest implements Listener {
    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) throws IOException{
        if (event.getInventory().getHolder() instanceof Chest || event.getInventory().getHolder() instanceof DoubleChest){
            logsave.savebl(event.getPlayer().getName(), "opened", event.getInventory().getType().toString(), event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockY(), event.getPlayer().getLocation().getBlockZ(), event.getPlayer().getWorld().getName());
        }
    }
}