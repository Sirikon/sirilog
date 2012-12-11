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
        if (event.getInventory().getHolder() instanceof Chest){
            logsave.savebl(event.getPlayer().getName(), "opened", "CHEST", event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockY(), event.getPlayer().getLocation().getBlockZ(), event.getPlayer().getWorld().getName());
        }else if (event.getInventory().getHolder() instanceof DoubleChest){
            logsave.savebl(event.getPlayer().getName(), "opened", "DOUBLE_CHEST", event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockY(), event.getPlayer().getLocation().getBlockZ(), event.getPlayer().getWorld().getName());
        }
    }
}