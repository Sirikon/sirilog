package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public final class Listenexplode implements Listener {
    @EventHandler
    public void onExplosion(ExplosionPrimeEvent event) throws IOException {
        new Logsave().savebl(
                "[ENVIRONMENT]",                                            // Who
                "explosion",                                                // What
                event.getEntityType().toString(),                           // With what
                String.valueOf(event.getEntity().getLocation().getBlockX()),// |
                String.valueOf(event.getEntity().getLocation().getBlockY()),// |--> Where
                String.valueOf(event.getEntity().getLocation().getBlockZ()),// |
                event.getEntity().getWorld().getName()                      // Which world
        );
    }
}