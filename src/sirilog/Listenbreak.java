package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class Listenbreak implements Listener {
    @EventHandler
    public void onPlayerBreaks(BlockBreakEvent event) throws IOException {
        Logsave.savebl(
                event.getPlayer().getName(),            // Who
                "broke",                                // What
                event.getBlock().getType().toString(),  // With what
                event.getBlock().getX(),                // |
                event.getBlock().getY(),                // |--> Where
                event.getBlock().getZ(),                // |
                event.getBlock().getWorld().getName()   // Which world
        );
    }
}