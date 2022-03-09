/*
 Autor:Vicente Leonel Vásquez Hernádez
  fecha creación: 08-03-2022
  fecha actualización: 09-03-2022
  Descripción: clase Conexion
 */
package bd;

import java.sql.*;


public class Conexion {
    public Connection conexion;
    private Connection connection;
    private  String url;
    private  String user;
    private  String pwd;

    public Conexion() {

    }

    public Conexion(Connection connection, String url, String user, String pwd) {
        this.connection = connection;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public Connection conectar() {
     url="jdbc:postgresql://localhost/Sportswear";
        user="postgres";
        pwd="leonel92";
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection(url,user,pwd);
            System.out.println("conexion establecida");
             
        }catch(Exception ex){
            System.out.println("1"+ex);
        }
        
        return connection;
    }

    public void desconectar() {
        try{
           conexion.close();
            System.out.println("cerrando conexion...");
        }catch(Exception ex){
            System.out.println("2"+ex);
        }
    }

    /*public Connection getConnection() {
        
    }*/

    public static void main(String[] args) {
        Conexion con =new Conexion();
        con.conectar();
        con.desconectar();
        
    }

}
