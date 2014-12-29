/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebadb;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Franklin Rony Cortez
 */
public class Persona {
    
    //campos
    private int id;
    private String nombres,apellidos,profesion;
    private int edad;
    //conexion a la bd
    private  Conexion conn;
    //log de eventos
    private static final Logger log = Logger.getLogger("logs");
    //construir un objeto persona
    public Persona(String nombres, String apellidos, int edad,String profesion)  {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.profesion = profesion;
    }
    public Persona(){
    }
    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getProfesion() {
        return profesion;
    }

    public int getEdad() {
        return edad;
    }
    //mostrar listado personas
    public ResultSet  mostrarPersonas(){
        //resultado de la consulta
        ResultSet res=null;
        //cache temporal con los resultados
        CachedRowSet tmpRs=null;
        //conexion a la bd
        conn=new Conexion();
        try {
            Statement st=conn.getConexion().createStatement();
            res=st.executeQuery("SELECT * FROM persona");    
            tmpRs=new CachedRowSetImpl();
            tmpRs.populate(res);
        } 
        catch (SQLException e) {
            log.log(Level.SEVERE, "No se pudieron obtener los registros de la tabla persona.");
            e.printStackTrace();
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "No se pudo hacer la consulta por un error desconocido");
        }
        finally{
            try {
                //liberar recursos
                res.close();
                log.log(Level.INFO,"Resultset liberado");
                conn.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return tmpRs;
    }
    public Persona mostrarPersona(ResultSet personas){
        Persona persona=new Persona();
        try {
                persona.id=personas.getInt(1);
                persona.nombres=personas.getString(2);
                persona.apellidos=personas.getString(3);
                persona.edad=personas.getInt(4);
                persona.profesion=personas.getString(5);

        } 
        catch(SQLException e){
            log.log(Level.SEVERE, "No se pudo efectuar la consulta");
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "No se pudo efectuar la consulta");
        }
        return persona;
    }
    
    //insertar datos en la bd
    public void insertarPersona(Persona persona){
        conn=new Conexion();
        PreparedStatement pst=null;
        try {
            pst = conn.getConexion().prepareStatement("INSERT INTO persona(nombres,apellidos,edad,profesion) VALUES(?,?,?,?)");
            //parametros a enviar
            pst.setString(1, persona.getNombres());
            pst.setString(2, persona.getApellidos());
            pst.setInt(3, persona.getEdad());
            pst.setString(4, persona.getProfesion());
            //ejecutar actualizacion
            pst.executeUpdate();
            log.log(Level.INFO,"Registro persona insertado con exito!");
        } 
        catch(SQLException e){
            log.log(Level.SEVERE,"No se pudo insertar el registro persona");
            e.printStackTrace();            
        }
        catch (Exception e) {
            log.log(Level.SEVERE,"Registro no insertado por error desconocido");
        }
        finally{
            conn.cerrarConexion();
        }
    }
}
