package sirilog;

import java.io.File;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    
    @Override
    public void onEnable(){        
        getServer().getPluginManager().registerEvents(new breaklisten(), this);
        getServer().getPluginManager().registerEvents(new putlisten(), this);
        getServer().getPluginManager().registerEvents(new uselisten(), this);
        File sirilogdir = new File("plugins/SiriLog");
        File sirilog = new File("plugins/SiriLog/sirilog.log");
        if (!(sirilog.exists())){
            try {
                sirilogdir.mkdir();
                sirilog.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error creating the log file");
            }
        }
        getLogger().info("SiriLog started fine");
    }
 
    @Override
    public void onDisable() {
        try {
            logsave.finalsave();
            getLogger().info("Queue saved");
        } catch (IOException ex) {
            getLogger().info("Error saving Queue");
        }
        getLogger().info("SiriLog clossed");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	if(cmd.getName().equalsIgnoreCase("sl")){
		sender.sendMessage("SiriLog v0.0.1 running on this server!");
		return true;
	}
	return false; 
    }
}