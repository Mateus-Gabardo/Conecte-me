/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.BoardGamePanel;
import View.GameCreateUser;
import View.GameLogin;
import dao.DaoLogin;

/**
 *
 * @author andreellias18
 */
public class GameLoginController {
    
    private GameLogin gameLogin;
    private GameCreateUser gameCreateUser;
    private DaoLogin dao;
    BoardGamePanel novoJogo;

    public GameLoginController() {
        this.gameLogin = new GameLogin(this);
        this.gameLogin.setVisible(true);
        this.gameCreateUser = new GameCreateUser(this);
        this.gameCreateUser.setVisible(false);
        this.dao = new DaoLogin();
    }
    
    public void login(String usuario, String senha){
        if (dao.autenticaUsuario(usuario, senha)){
            gameLogin.exibirMensagem("Usuário logado com Sucesso!");
            gameLogin.setVisible(false);
            novoJogo = new BoardGamePanel();
            novoJogo.iniciar();
        }else{
            gameLogin.exibirMensagem("Usuário inválido");
            gameLogin.limparCampo();
        }
    }
    
    public void abrirCadastroUsu (){
        this.gameCreateUser.setVisible(true);
        this.gameLogin.setVisible(false);
    }
    
    public void cadastrar(String usuario, String senha){
        dao.addUsuarios(usuario+"#"+senha);
        gameLogin.exibirMensagem("Usuário Cadastrado!");
        this.gameCreateUser.setVisible(false);
        this.gameLogin.setVisible(true);
    }
    
    public GameLogin getGamelogin(){
        return this.gameLogin;
    }
    
    public BoardGamePanel getBoardGame(){
        return novoJogo;
    }
}
