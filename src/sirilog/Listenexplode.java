package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public final class Listenexplode implements Listener {
    @EventHandler
    public void onExplosion(ExplosionPrimeEvent event) throws IOException {
        Logsave.savebl(
                "[ENVIRONMENT]",                                // Who
                "explosion",                                    // What
                event.getEntityType().toString(),               // With what
                event.getEntity().getLocation().getBlockX(),    // |
                event.getEntity().getLocation().getBlockY(),    // |--> Where
                event.getEntity().getLocation().getBlockZ(),    // |
                event.getEntity().getWorld().getName()          // Which world
        );
    }
}