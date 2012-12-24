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
            if (
                    whatClicked.contains("DOOR") ||
                    whatClicked.contains("BUTTON") ||
                    whatClicked.contains("LEVER") ||
                    Configs.customint.contains(event.getClickedBlock().getTypeId())
            ){
                new Logsave().savebl(
                        event.getPlayer().getName(),                    // Who
                        "used",                                         // What
                        event.getClickedBlock().getType().toString(),   // With what
                        String.valueOf(event.getClickedBlock().getX()), // |
                        String.valueOf(event.getClickedBlock().getY()), // |--> Where
                        String.valueOf(event.getClickedBlock().getZ()), // |
                        event.getClickedBlock().getWorld().getName()    // Which world
                );
            }
        }
    }
}