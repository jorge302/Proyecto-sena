package com.mycompany.jdbctest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbctest1 {

    public static void main(String[] args) {
       String usuario="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/jdbctest";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //insercion de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'jleonardo');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualización de datos
             statement.execute("UPDATE `usuarios` SET `nombre` = 'jmedina' WHERE `usuarios`.`nombre` = 'jjorge';");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Eliminación de datos
             statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 2");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Jdbctest1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
