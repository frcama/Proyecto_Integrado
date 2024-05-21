package com.example.proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlquileresModel extends Conexion{



    public ArrayList<Alquileres> mostrarAlquileres() {

        ArrayList<Alquileres> listaAlquileres = new ArrayList<>();

        try {
            String sql = "Select * from alquileres;";

            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                listaAlquileres.add(new Alquileres(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));

                return listaAlquileres;
            }
        } catch (SQLException e) {
            e.getMessage().toString();
        }
        return listaAlquileres;

    }
}
