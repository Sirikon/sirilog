package sirilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;

public class MySQL {
    
    public static Connection con;
    
    public boolean connect() {
        FileConfiguration d = Configs.config;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://" + d.getString("recordings.mysql.server") +
                    "/" + d.getString("recordings.mysql.database"),
                    d.getString("recordings.mysql.user"),
                    d.getString("recordings.mysql.pass")
            );
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        System.out.println("[SiriLog] Successful connection to database");
        return true;
    }
    
    public ArrayList<String[]> getData(String q) throws SQLException{
        ArrayList<String[]> l = new ArrayList();
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(q)) {
            while (rs.next()){
                    l.add(new String[] {
                        rs.getObject("id").toString(),
                        rs.getObject("date").toString(),
                        rs.getObject("user").toString(),
                        rs.getObject("action").toString(),
                        rs.getObject("block").toString(),
                        rs.getObject("x").toString(),
                        rs.getObject("y").toString(),
                        rs.getObject("z").toString()
                    });
            }
        }
        return l;
    }
    
    public boolean writeData(ArrayList<String[]> list){
        Iterator li = list.iterator();
        String q = "INSERT INTO `logs` (`date`, `user`, `action`, `block`, `x`, `y`, `z`, `world`) VALUES ";
        while (li.hasNext()){
            String[] d = (String[]) li.next();
            q +=
                    "('" +
                    d[2] + "-" + d[1] + "-" + d[0] + " " + d[3] + ":" + d[4] + ":" + d[5] + "', '" +
                    d[6] + "', '" +
                    d[7] + "', '" +
                    d[8] + "', '" +
                    d[9] + "', '" +
                    d[10] + "', '" +
                    d[11] + "', '" +
                    d[12] + "')";
            
            if (li.hasNext()){
                q += ",";
            }
        }   
        try {
            Statement st = con.createStatement();
            st.executeUpdate(q);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public void defaultDb(){
        String q = "CREATE TABLE IF NOT EXISTS `logs` ("
                + "`id` int(11) NOT NULL AUTO_INCREMENT,"
                + "`date` datetime NOT NULL,"
                + "`user` varchar(255) COLLATE utf8_spanish_ci NOT NULL,"
                + "`action` varchar(255) COLLATE utf8_spanish_ci NOT NULL,"
                + "`block` varchar(255) COLLATE utf8_spanish_ci NOT NULL,"
                + "`x` int(11) NOT NULL,"
                + "`y` int(11) NOT NULL,"
                + "`z` int(11) NOT NULL,"
                + "`world` varchar(255) COLLATE utf8_spanish_ci NOT NULL,"
                + "PRIMARY KEY (`id`)"
                + ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1";

        try {
            Statement st = con.createStatement();
            st.executeUpdate(q);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
