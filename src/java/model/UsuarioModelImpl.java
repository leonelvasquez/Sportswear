/*
 Autor:Vicente Leonel Vásquez Hernádez
  fecha creación: 11-03-2022
  fecha actualización: 14-03-2022
  Descripción: clase UsuarioModelImpl
 */
package model;

import bd.Conexion;
import entity.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModelImpl implements IUsuarioModel {

    private Conexion conexion;
    private Connection connection;
    private static Usuario usuario;

    public void crearRegistro(Usuario usuario) throws SQLException {
        try {

            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();

            String sql = "insert into usuario(codigo,nombreUsuario,contraseña) values(?,?,?)";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getCodigo());
                statement.setString(2, usuario.getNombreUsuario());
                statement.setString(3, usuario.getContraseña());
                statement.executeUpdate();
                System.out.println("datos insertados correctamente...");

            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("error:" + e.getMessage());
        }

    }

    @Override
    public void crearRegisto(Usuario usuario) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {

            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();

            String sql = "update usuario set codigo=?,nombreUsuario=?,contraseña=? where codigo=?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getCodigo());
                statement.setString(2, usuario.getNombreUsuario());
                statement.setString(3, usuario.getContraseña());
                statement.setString(4, usuario.getCodigo());
                statement.executeUpdate();
                System.out.println("datos actualizados correctamente...");

            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("error:" + e.getMessage());
        }

    }

    @Override
    public List<Usuario> obtenerRegistros() {
        List<Usuario> listaUsuario = null;
        try {
            ResultSet resultSet;
            listaUsuario = new ArrayList<>();
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();
            String sql = "select *from usuario";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setCodigo(resultSet.getString(1));
                    usuario.setNombreUsuario(resultSet.getString(2));
                    usuario.setContraseña(resultSet.getString(3));

                    listaUsuario.add(usuario);
                }

            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("error:" + e.getMessage());
        }
        return listaUsuario;
    }

    @Override
    public Usuario obtenerRegistro(String codigo) {
        Usuario usuario = null;
        try {
            ResultSet resultSet;
            usuario = new Usuario();
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();
            String sql = "select *from usuario where codigo=?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, codigo);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    usuario.setCodigo(resultSet.getString(1));
                    usuario.setNombreUsuario(resultSet.getString(2));
                    usuario.setContraseña(resultSet.getString(3));

                }
            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("error:" + e.getMessage());
        }
        return usuario;
    }

    // @Override
    // public void eliminarResgistro(int idUsuario)
    public void eliminarResgistro(String codigo) {
        try {

            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();

            String sql = "delete from usuario where codigo=?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, codigo);
                statement.executeUpdate();
                System.out.println("datos eliminado correctamente...");

            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {

        UsuarioModelImpl um = new UsuarioModelImpl();
        Usuario u = new Usuario();

        u.setCodigo("1234");
        u.setNombreUsuario("luis");
        u.setContraseña("ab");
        // um.crearRegistro(u);
        // um.actualizarRegistro(u);
        // um.eliminarResgistro("1233");
        //  um.obtenerRegistros();
        // System.out.println(um.obtenerRegistros().toString());
        //um.obtenerRegistros();

        //System.out.println(um.obtenerRegistro("123"));  
        // um.obtenerRegistro("1233");
    }

}
