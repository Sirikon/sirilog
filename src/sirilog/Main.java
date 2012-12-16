package sirilog;

import java.io.File;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    
    @Override
    public void onEnable(){
        
        File sirilogdir =   new File("plugins" + File.separator + "SiriLog");
        File sirilog =      new File("plugins" + File.separator + "SiriLog" + File.separator + "sirilog.log");
        File sirilogconf =  new File("plugins" + File.separator + "SiriLog" + File.separator + "config.yml");
        
        if (!(sirilog.exists())){
            try {
                sirilogdir.mkdir();
                sirilog.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error creating the log file");
            }
        }
        
        if (!(sirilogconf.exists())){
            try {
                sirilogconf.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error creating the config file");
            }
        }
        
        FileConfiguration conf = getConfig();
        
        if(!conf.contains("recordings.showlogsaved")) {
            conf.set("recordings.showlogsaved", false);
        }
        if(!conf.contains("recordings.savelimit")) {
            conf.set("recordings.savelimit", 30);
        }
        if(!conf.contains("log.breakblock")) {
            conf.set("log.breakblock", true);
        }
        if(!conf.contains("log.placeblock")) {
            conf.set("log.placeblock", true);
        }
        if(!conf.contains("log.openchest")) {
            conf.set("log.openchest", true);
        }
        if(!conf.contains("log.explosions")) {
            conf.set("log.explosions", true);
        }
        if(!conf.contains("log.playerinteractions")) {
            conf.set("log.playerinteractions", true);
        }
        
        saveConfig();
        Configs.config = conf;
        
        if (conf.getBoolean("log.breakblock")){
            getServer().getPluginManager().registerEvents(new Listenbreak(), this);
        }
        if (conf.getBoolean("log.placeblock")){
            getServer().getPluginManager().registerEvents(new Listenput(), this);
        }
        if (conf.getBoolean("log.playerinteractions")){
            getServer().getPluginManager().registerEvents(new Listenuse(), this);
        }
        if (conf.getBoolean("log.openchest")){
            getServer().getPluginManager().registerEvents(new Listenchest(), this);
        }
        if (conf.getBoolean("log.explosions")){
            getServer().getPluginManager().registerEvents(new Listenexplode(), this);
        }
        
        getLogger().info("SiriLog started fine");
    }
 
    @Override
    public void onDisable() {
        try {
            Logsave.finalsave();
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
                            Logsave.finalsave();
                        } catch (IOException ex) {
                            getLogger().info("Error saving queue, aborted: " + ex.getMessage());
                        }
                        sender.sendMessage("Queue saved");
                        break;
                    case "queue":
                        sender.sendMessage(Logsave.logs.size() + " in queue");
                        break;
                    case "reload":
                        reloadConfig();
                        Configs.config = getConfig();
                        sender.sendMessage("Configurations reloaded");
                        break;
                    default:
                        sender.sendMessage("Unknown SiriLog command");
                        break;
                }
            }else {
                sender.sendMessage("SiriLog 0.0.4 running on this server!");
            }
            return true;
        }
        return false;
    }
}