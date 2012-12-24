package sirilog;

import java.io.IOException;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class Listenwand implements Listener {
    @EventHandler
    public void onWand(PlayerInteractEvent event) throws IOException {
        if (event.getAction() == Action.LEFT_CLICK_BLOCK){
            if (event.getPlayer().getItemInHand().getType() == Material.WOOD_PICKAXE){
                event.setCancelled(true);
                int x = event.getClickedBlock().getX();
                int y = event.getClickedBlock().getY();
                int z = event.getClickedBlock().getZ();
                String w = event.getClickedBlock().getWorld().getName();
                
                Configs.loc1 = x + " " + y + " " + z + " " + w;
                event.getPlayer().sendMessage("Selected Block #1");
            }
        }else if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (event.getPlayer().getItemInHand().getType() == Material.WOOD_PICKAXE){
                event.setCancelled(true);
                int x = event.getClickedBlock().getX();
                int y = event.getClickedBlock().getY();
                int z = event.getClickedBlock().getZ();
                String w = event.getClickedBlock().getWorld().getName();
                
                Configs.loc2 = x + " " + y + " " + z + " " + w;
                event.getPlayer().sendMessage("Selected Block #2");
            }
        }
    }
}