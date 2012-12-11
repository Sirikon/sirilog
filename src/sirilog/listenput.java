package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public final class listenput implements Listener {
    @EventHandler
    public void onPlayerPlaces(BlockPlaceEvent event) throws IOException {
        logsave.savebl(event.getPlayer().getName(), "put", event.getBlock().getType().toString(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), event.getBlock().getWorld().getName());
    }
}