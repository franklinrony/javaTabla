/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Persona persona=new Persona("rONY","CORTEZ",28,"NADA");
            persona.insertarPersona(persona);
            //insertar usuario
            //mostrar todos los registros
            
            ResultSet res=persona.mostrarPersonas();
                while (res.next()) {
                    Persona personares=persona.mostrarPersona(res);
                    System.out.print("id:"+personares.getId()+"\t");
                    System.out.print("Nombres:" + personares.getNombres()+ "\t");
                    System.out.print("Apellidos: " + personares.getApellidos());
                    System.out.println("");
                }


        } catch (SQLException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
