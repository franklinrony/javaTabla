/*
 * Clase para hacer las conexiones a la bd
 * Fecha creacion: 28/12/2014
 * Fecha modificacion:
 * Creador:Franklin Rony Cortez
 */

package pruebadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin Rony Cortez
 */
public class Conexion {
    Connection con;
    private final String usuario="root";
    private final String password="root";
    private final String dbname="pruebadb";
    private final String url = "jdbc:mysql://localhost/"+dbname;
    //log de eventos
    private Logger log=Logger.getLogger("logs");

    //creamos el constructor
    public Conexion(){
        //manejar al conexion a la base de datos
        try {
            //Registrar el Driver de conexion
            Class.forName("com.mysql.jdbc.Driver");
            //Realizar conexion con los parametros enviados.
            con=DriverManager.getConnection(url, usuario, password);
            log.log(Level.INFO, "Conexion realizada con exito!");
        } 
        catch(ClassNotFoundException e){
            log.log(Level.SEVERE,"Driver no encontrado.");
        }
        catch(SQLException e){
            log.log(Level.SEVERE, "Parametros de conexion incorrectos.");
            
        }
        catch (Exception e) {
            log.log(Level.SEVERE,"Problema no determinado al intentar realizar la conexion con la BD.");
        }
        
    }
    //enviar conexion bd
    public Connection getConexion(){
        return con;
    }
    //cerrar conexion
    public void cerrarConexion(){
        try{
            if(con!=null){
                con.close();
                log.log(Level.INFO,"Conexion cerrada con exito!");
            }
        }
        catch(SQLException e){
            log.log(Level.SEVERE,"no se puede cerrar la conexion");
        }
        catch(Exception e){
          log.log(Level.SEVERE,"Error inesperado al cerrar la conexion.");  
        }
    }
}
