/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.util;

import java.util.ResourceBundle;

/**
 *
 * @author Kevin Valdez
 */
//PREVENT INHERITENCE
public final class Util {
    //FOR COMPILER TO INTERPRET THESE AS CONSTANTS THEY NEED TO HAVE INITIALIZERS SO PROPERTIES FILE CANNOT BE USED HERE
    public static final String CONNECTION_ERROR = "08001";
    public static final String DATABASE_NOT_FOUND = "08004";
    public static final String DATBASE_REJECTED = "Se ha rechazado la conexión porque no se ha encontrado la base de datos";
    public static final String DATABASE_ERROR;
    
    static {
        ResourceBundle properties = ResourceBundle.getBundle("fallball.util.config");
        /*CONNECTION_ERROR = properties.getString("CONNECTION_ERROR");
        DATABASE_NOT_FOUND = properties.getString("DATABASE_NOT_FOUND");*/
        DATABASE_ERROR = properties.getString("DATABASE_ERROR");
    }
    
    //PREVENT INSTATIATION
    private Util(){
    }
}
