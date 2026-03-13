package org.arcesinho.Repo;

import java.sql.*;
import java.util.Optional;

public class AlumnoRepo {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";
    public static final int INT_ERROR_VALUE = -1;

    //Crud

    public Optional<AlumnoEntity> read(int id){

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){

            PreparedStatement stmt = conn.prepareStatement("select a.id, a.nombre, a.apellidos, a.dni, a.id_grupo" +
                    "from alumnos a where id = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            AlumnoEntity a = null;

            if(rs.next()){
                a = new AlumnoEntity(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("apellidos"), rs.getString("dni"), rs.getInt("id_grupo"));
            }

            return Optional.ofNullable(a);

        }catch (SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public int delete(int id){

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement stmt = conn.prepareStatement("delete from alumnos where id = ?");
            stmt.setInt(1, id);

            return stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            return INT_ERROR_VALUE;
        }
    }

    public int insert(String nombre, String apellidos, String dni, int id_grupo){

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            PreparedStatement stmt = conn.prepareStatement("insert into alumnos(nombre, apellidos, dni, id_grupo) values(?,?,?,?)");
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, dni);
            stmt.setInt(4, id_grupo);

            stmt.executeQuery();

            PreparedStatement stmt2 = conn.prepareStatement("update alumnos set nombre=ADRIAN WHERE nombre=Adrian");
            return stmt2.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
            return INT_ERROR_VALUE;
        }


    }
}
