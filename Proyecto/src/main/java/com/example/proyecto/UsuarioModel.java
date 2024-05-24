package com.example.proyecto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioModel extends Conexion{

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
