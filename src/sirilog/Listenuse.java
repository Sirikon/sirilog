package sirilog;

import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class Listenuse implements Listener {
    @EventHandler
    public void onPlayerUses(PlayerInteractEvent event) throws IOException {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
            String whatClicked = event.getClickedBlock().getType().toString();
            if (whatClicked.contains("DOOR") || whatClicked.contains("BUTTON") || whatClicked.contains("LEVER")){
                Logsave.savebl(
                        event.getPlayer().getName(),                    // Who
                        "used",                                         // What
                        event.getClickedBlock().getType().toString(),   // With what
                        event.getClickedBlock().getX(),                 // |
                        event.getClickedBlock().getY(),                 // |--> Where
                        event.getClickedBlock().getZ(),                 // |
                        event.getClickedBlock().getWorld().getName()    // Which world
                );
            }
        }
    }
}