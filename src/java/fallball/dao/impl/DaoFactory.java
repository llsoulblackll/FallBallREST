/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.dao.impl;

import fallball.dao.DeviceInfoDao;
import fallball.dao.PlayerDao;

/**
 *
 * @author User
 */
public final class DaoFactory {
    
    DaoFactory(){
    }
    
    static class DaoFactoryHolder{
        static DaoFactory INSTANCE = new DaoFactory();
    }
    
    public static DaoFactory getInstance(){
        return DaoFactoryHolder.INSTANCE;
    }
    
    public PlayerDao getPlayerDao(){
        return new PlayerDaoImpl();
    }
    
    public DeviceInfoDao getDeviceInfoDao(){
        return new DeviceInfoDaoImpl();
    }
    
}
