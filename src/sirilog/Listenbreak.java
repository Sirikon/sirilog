package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class Listenbreak implements Listener {
    @EventHandler
    public void onPlayerBreaks(BlockBreakEvent event) throws IOException {
        new Logsave().savebl(
                event.getPlayer().getName(),            // Who
                "broke",                                // What
                event.getBlock().getType().toString(),  // With what
                String.valueOf(event.getBlock().getX()),// |
                String.valueOf(event.getBlock().getY()),// |--> Where
                String.valueOf(event.getBlock().getZ()),// |
                event.getBlock().getWorld().getName()   // Which world
        );
    }
}