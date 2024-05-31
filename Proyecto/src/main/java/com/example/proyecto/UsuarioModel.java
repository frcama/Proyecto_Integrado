package com.example.proyecto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Esta clase representa el modelo para el manejo de usuarios, proporciona funcionalidades como encriptar contraseñas.
 */
public class UsuarioModel extends Conexion{

    /**
     * Método para encriptar una contraseña utilizando el algoritmo MD5.
     * @param contraseña La contraseña a encriptar.
     * @return La contraseña encriptada.
     * @throws NoSuchAlgorithmException Si no se encuentra el algoritmo de encriptación especificado.
     */

  private String encriptarContraseña(String contraseña) throws NoSuchAlgorithmException{
      MessageDigest digest = MessageDigest.getInstance("MD5");
      byte[] hash = digest.digest(contraseña.getBytes());
      StringBuilder hexString = new StringBuilder();
      for (byte b : hash){
          String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
      return hexString.toString();
  }
}
