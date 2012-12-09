package sirilog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.bukkit.plugin.java.JavaPlugin;

public final class logsave extends JavaPlugin {
    
    public static ArrayList<String> logs = new ArrayList<>();
    
    public static void savebl(String pl, String a, String bl, Integer x, Integer y, Integer z, String w) throws IOException {
        Calendar cal = Calendar.getInstance();
        int da, mo, ye, h, m, s;
        da = cal.get(Calendar.DAY_OF_MONTH);
        mo = cal.get(Calendar.MONTH);
        ye = cal.get(Calendar.YEAR);
        h = cal.get(Calendar.HOUR_OF_DAY);
        m = cal.get(Calendar.MINUTE);
        s = cal.get(Calendar.SECOND);
        logs.add("[" + da + "/" + mo + "/" + ye + " " + h + ":" + m + ":" + s + "] " + pl + " " + a + " " + bl + " X=" + x + " Y=" + y + " Z=" + z + " " + w);
        if (logs.size() >= 15){
            finalsave();
        }
    }
    
    public static void finalsave() throws IOException{
        File sirilog = new File("plugins/SiriLog/sirilog.log");
        FileWriter fw = new FileWriter(sirilog, true);
        try (PrintWriter pw = new PrintWriter(fw)) {
            Iterator it = logs.iterator();
            while(it.hasNext()) {
               pw.println(it.next());
            }
        }
        logs.clear();
        System.out.println("[SiriLog] Saved 15 log lines");
    }
}