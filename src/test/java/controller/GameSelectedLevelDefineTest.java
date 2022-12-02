/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.GameSelectedLevelDefine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gabardo
 */
public class GameSelectedLevelDefineTest {
    
    private GameSelectedLevelDefine view;
    
    /**
     * TDD Gabardo
     */
    @Test
    public void testSelecionarCorreto(){
        view = new GameSelectedLevelDefine(new GameBoardController(4, 4));
        Assertions.assertDoesNotThrow(() -> view.selecionar("nivel11.0"));
    }
}
