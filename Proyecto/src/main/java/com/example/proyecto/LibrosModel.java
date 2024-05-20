package com.example.proyecto;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibrosModel extends Conexion {

    public ArrayList<Libros> mostrarLibros() {

        ArrayList<Libros> listaLibros = new ArrayList<>();

        try {
            String sql = "Select * from libros;";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                listaLibros.add(new Libros(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));

                return listaLibros;
            }
        } catch (SQLException e) {
            e.getMessage().toString();
        }
        return listaLibros;

    }


}
