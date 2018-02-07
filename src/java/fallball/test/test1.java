/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.test;

import fallball.dao.DeviceInfoDao;
import fallball.dao.PlayerDao;
import fallball.dao.impl.DaoFactory;
import fallball.entity.DeviceInfo;
import fallball.entity.PlayerData;
import fallball.util.DatabaseConnection;
import fallball.util.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class test1 {
    //<editor-fold defaultstate="collapsed" desc="some desc">
    public static void main(String[] args) {
        //DeviceInfoDao dao = DaoFactory.getInstance().getDeviceInfoDao();
        PlayerDao pdao = DaoFactory.getInstance().getPlayerDao();
        //dao.create(new DeviceInfo("somed id", "some platform", "some os"));
        
        /*dao.findAll().forEach((d) -> {
            System.out.printf("%s - %s - %s\n", d.deviceId, d.os, d.platform);
        });*/
        
        pdao.create(new PlayerData.Player("The master", 20f, 1));
        pdao.create(new PlayerData.Player("Im the best", 50f, 2));
        pdao.create(new PlayerData.Player("your daddy", 30f, 3));
        pdao.create(new PlayerData.Player("Can't stop me now", 70f, 2));
        pdao.create(new PlayerData.Player("who the hell are you?", 20f, 1));
        pdao.create(new PlayerData.Player("sweet love", 20f, 1));
        pdao.create(new PlayerData.Player("here i come", 30f, 2));
        pdao.create(new PlayerData.Player("soulblack", 50f, 3));
        pdao.create(new PlayerData.Player("ozymandias", 80f, 3));
        pdao.create(new PlayerData.Player("defected", 80f, 3));
        pdao.create(new PlayerData.Player("who's your daddy?", 80f, 3));
        pdao.create(new PlayerData.Player("the man", 80f, 3));
        pdao.create(new PlayerData.Player("cheetah", 80f, 3));
        pdao.create(new PlayerData.Player("whatever", 80f, 3));
        pdao.findAll().forEach((p) -> {
            System.out.printf("%d - %s - %f - %d\n", p.playerId, p.playerName, p.playerScore, p.level);
        });
        
        //pdao.delete("");
        Connection conn = null;
        Statement st = null; 
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT SCHEMANAME FROM SYS.SYSSCHEMAS");
            while(rs.next())
                System.out.println(rs.getString(1));
        } catch(SQLException x){
            System.out.printf("%s: %s\n", Util.DATABASE_ERROR, x);
        } finally {
            try {
                if(conn.isValid(0))
                    conn.close();
                if(!st.isClosed())
                    st.close();
                if(!rs.isClosed())
                    rs.close();
            } catch (SQLException x2){
                System.out.printf("%s: %s\n", Util.DATABASE_ERROR, x2);
            } /*catch (NullPointerException x2) {
            System.out.println("");
            }*/
        }
        
        
    }
    //</editor-fold>
}
