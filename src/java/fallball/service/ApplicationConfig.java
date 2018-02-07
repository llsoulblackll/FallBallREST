/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.service;

import fallball.dao.DeviceInfoDao;
import fallball.dao.PlayerDao;
import fallball.dao.impl.DaoFactory;
import fallball.entity.DeviceInfo;
import java.util.Set;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Alumno-CT
 */
//NEEDED, CANNOT BE BLANK, IF BLANK USE web.xml INSTEAD TO SPECIFY ROUTE
@javax.ws.rs.ApplicationPath("api")//webresources
//EXTEND FROM ResourceConfig INSTEAD OF Application(default) SINCE IT PROVIDES UTILY METHODS TO USE DEPENDENCY INJECTION
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        
        //LOOKS FOR RESOURCES(ENDPOINTS) ON SPECIFIED PACKAGES
        packages(this.getClass().getPackage().getName());
        
        //MANUALLY REGISTERS RESOURCES IN THIS CASE A BINDER FOR DI
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                //BIND THE IMPLEMENTATION TO THE INTERFACE FOR DI
                this.bind(deviceInfoDao()).to(DeviceInfoDao.class);
                this.bind(playerDao()).to(PlayerDao.class);
            }
        });
    }

    private DeviceInfoDao deviceInfoDao(){
        return DaoFactory.getInstance().getDeviceInfoDao();
    }
    
    private PlayerDao playerDao(){
        return DaoFactory.getInstance().getPlayerDao();
    }
    
    /*@Override
    public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
    }*/

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    /*private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(fallball.service.PlayerDataService.class);
    }*/
    
}
