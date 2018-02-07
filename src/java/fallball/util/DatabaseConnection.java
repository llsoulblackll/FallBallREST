/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 *
 * @author Alumno-CT
 */
public final class DatabaseConnection {

    private static final String URL;
    private static final String CREATE_URL;
    private static final String DRIVER;
    private static final String USER;
    private static final String PASSWORD;

    static {
        ResourceBundle properties = ResourceBundle.getBundle("fallball.util.config");
        URL = properties.getString("URL");
        CREATE_URL = properties.getString("CREATE_URL");
        DRIVER = properties.getString("DRIVER");
        USER = properties.getString("USER");
        PASSWORD = properties.getString("PASSWORD");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException x) {
            System.out.printf("Error al cargar el driver: %s\n", x);
        }

    }

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            /*InputStream stream = DatabaseConnection.class.getResourceAsStream("/fallball/scripts/FallBallSchema.sql");
            try(BufferedReader br = new BufferedReader(new InputStreamReader(stream))){
            Statement st = conn.createStatement();
            String[] commands = br.lines().collect(Collectors.joining()).split(";");//.replaceAll("[;]", "");
            System.out.println(String.join("", commands));
            for(String s : commands)
            st.execute(s);
            }*/
        } catch (SQLException x) {
            switch (x.getSQLState()) {
                case Util.CONNECTION_ERROR:
                    System.out.printf("%s: %s\nErrorCode: %d\nSQLState: %s\n", Util.DATABASE_ERROR, x, x.getErrorCode(), x.getSQLState());
                    //THROW EXCEPTION TO STOP EXECUTION
                    throw x;
                case Util.DATABASE_NOT_FOUND:
                    //FROM THIS STRING ONWARDS THE MESSAGE IS GENERIC, SO IT DOESNT HAVE TO NECESSARY BE A DATABASE NOT FOUND EXCEPTION
                    //WE MAKE SURE IT IS BY USING THIS STRING AS INDEX
                    final String db = "base de datos";
                    System.out.printf("Base de datos inexistente: %s\n", x.getMessage());
                    System.out.println("Creando base de datos.");
                    //System.out.println(x.getMessage().substring(0, x.getMessage().indexOf("base de datos")));
                    //ADD db AT THE END SINCE SUBSTRING IS NON INCLUSIVE
                    int index = x.getMessage().indexOf(db);
                    if(index != -1 && Util.DATBASE_REJECTED.equals(x.getMessage().substring(0, index) + db)){
                        conn = DriverManager.getConnection(CREATE_URL, USER, PASSWORD);
                        InputStream stream = DatabaseConnection.class.getResourceAsStream("/fallball/scripts/FallBallSchema.sql");
                        try(BufferedReader br = new BufferedReader(new InputStreamReader(stream)); 
                                Statement st = conn.createStatement()){
                            String sql = br.lines().collect(Collectors.joining());
                            String[] sqlStatements = sql.split(";");
                            //START FROM 1 SINCE THE FIRST ELEMENT IS A COMMENTARY(CHECK SQL FILE)
                            for(int i = 1; i < sqlStatements.length; i++)
                                st.execute(sqlStatements[i]);
                        } catch (IOException | SQLException x2){
                            System.out.println(x);
                        }
                        
                    } else 
                        System.out.println(x.getMessage().substring(0, x.getMessage().indexOf("base de datos")));
                    //System.out.printf("Base de datos inexistente: %s", x.getMessage());
                    break;
                default:
                    System.out.printf("%s: %s\nErrorCode: %d\nSQLState: %s\n", Util.DATABASE_ERROR, x, x.getErrorCode(), x.getSQLState());
                    throw x;
            }
        }
        /*catch(IOException x){
        System.out.printf("Error al leer archivo: %s\n", x);
        }*/

        return conn;
    }

}
