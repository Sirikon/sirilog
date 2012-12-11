package sirilog;

import java.io.File;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    
    @Override
    public void onEnable(){        
        getServer().getPluginManager().registerEvents(new listenbreak(), this);
        getServer().getPluginManager().registerEvents(new listenput(), this);
        getServer().getPluginManager().registerEvents(new listenuse(), this);
        getServer().getPluginManager().registerEvents(new listenchest(), this);
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
	if(cmd.getName().equalsIgnoreCase("sl")) {
            if (args.length >= 1){
                switch (args[0]) {
                    case "save":
                        try {
                            logsave.finalsave();
                        } catch (IOException ex) {
                            getLogger().info("Error saving queue, aborted: " + ex.getMessage());
                        }
                        sender.sendMessage("Queue saved");
                        break;
                    case "queue":
                        sender.sendMessage(logsave.logs.size() + " in queue");
                        break;
                    default:
                        sender.sendMessage("Unknown SiriLog command");
                        break;
                }
            }else {
                sender.sendMessage("SiriLog 0.0.2 running on this server!");
            }
            return true;
        }
        return false;
    }
}