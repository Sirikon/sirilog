package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class breaklisten implements Listener {
    @EventHandler
    public void onPlayerBreaks(BlockBreakEvent event) throws IOException {
        logsave.savebl(event.getPlayer().getName(), "broke", event.getBlock().getType().toString(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), event.getBlock().getWorld().getName());
    }
}