package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public final class listenexplode implements Listener {
    @EventHandler
    public void onExplosion(ExplosionPrimeEvent event) throws IOException {
                logsave.savebl("[ENVIRONMENT]", "explosion", event.getEntityType().toString(), event.getEntity().getLocation().getBlockX(), event.getEntity().getLocation().getBlockY(), event.getEntity().getLocation().getBlockZ(), event.getEntity().getWorld().getName());
    }
}