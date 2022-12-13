/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.BoardGamePanel;
import dao.DaoLogin;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Captor;
import static org.mockito.Mockito.verify;

/**
 *
 * @author andreellias18
 */
public class GameLoginTest {
    
    private GameLoginController loginController;
    
     /**
     * TDD
     */
    
    @Test
    public void testTDDValidarUsuario(){
        
        DaoLogin dao = new DaoLogin();
        dao.addUsuarios("usuario#12345");
        String usuario = "usuario";
        String senha = "12345";
        assertTrue(dao.autenticaUsuario(usuario, senha));
    }
    
    @Test
    public void testInicializarJogo() {
        loginController = new GameLoginController();
        DaoLogin dao = new DaoLogin();
        String usuario = "admin";
        String senha = "admin";
        dao.addUsuarios(usuario+"#"+senha);
        loginController.login(usuario, senha);
        assertTrue(loginController.getBoardGame() != null);
    }
    
    @Test
    public void testCriaUsuario() {
        DaoLogin dao = new DaoLogin();
        String usuarionovo = "usuario";
        String senhanovo = "12345";
        dao.addUsuarios(usuarionovo+"#"+senhanovo);
        boolean equals = false;
        for (String usuario : dao.getUsuarios()) {
            if (usuario.split("#")[0].equals(usuarionovo) && usuario.split("#")[1].equals(senhanovo)){
                equals = true;
            }
        }
        assertTrue(equals);
    }
    
    @Test
    public void testInserirNovoUsu() {
        loginController = new GameLoginController();
        DaoLogin dao = new DaoLogin();
        String usuarionovo = "usuario";
        String senhanovo = "12345";
        dao.addUsuarios(usuarionovo+"#"+senhanovo);
        boolean equals = false;
        if (loginController.getGamelogin().getUsu().equals("") && loginController.getGamelogin().getSen().equals(""))
            equals = true;
        assertTrue(equals);
    }
}
