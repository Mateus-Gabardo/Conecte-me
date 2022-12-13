/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreellias18
 */
public class DaoLogin {
    
    private List<String> usuarios = new ArrayList<>();
    

    public DaoLogin() {
        this.usuarios.add("admin#admin");
    }

    public List<String> getUsuarios() {
        return usuarios;
    }

    public void addUsuarios(String usuario) {
        this.usuarios.add(usuario);
    }
    
    public boolean autenticaUsuario(String usuario, String senha){
        boolean retorno = false;
        for (String usu : usuarios) {
            if (usu.split("#")[0].equals(usuario) && usu.split("#")[1].equals(senha)){
                retorno = true;
                break;
            }
        }
        return retorno;
    }
}
