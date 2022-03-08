/*
 Autor:Vicente Leonel Vásquez Hernádez
  fecha creación: 08-03-2022
  fecha actualización:
  Descripción: clase Conexion
 */
package bd;

import java.sql.*;


public class Conexion {

    private final Connection connection;
    private final String url;
    private final String user;
    private final String pwd;

    public Conexion() {

    }

    public Conexion(Connection connection, String url, String user, String pwd) {
        this.connection = connection;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public void conectar() {

    }

    public void desconectar() {

    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        
        
    }

}
