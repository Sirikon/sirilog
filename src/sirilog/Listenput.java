package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public final class Listenput implements Listener {
    @EventHandler
    public void onPlayerPlaces(BlockPlaceEvent event) throws IOException {
        new Logsave().savebl(
                event.getPlayer().getName(),            // Who
                "put",                                  // What
                event.getBlock().getType().toString(),  // With what
                String.valueOf(event.getBlock().getX()),// |
                String.valueOf(event.getBlock().getY()),// |--> Where
                String.valueOf(event.getBlock().getZ()),// |
                event.getBlock().getWorld().getName()   // Which world
        );
    }
}