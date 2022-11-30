package controller;

import View.GameCreateLevel;
import dao.CreatedLevels;

/**
 *
 * @author 09062732933
 */
public class GameCreateLevelController {
    
    private GameCreateLevel createLevel;
    private CreatedLevels dao;

    public GameCreateLevelController(GameBoardController gameController) {
        dao = new CreatedLevels();
        createLevel = new GameCreateLevel(gameController);
    }   
    
    public void abrir() {
        createLevel.setVisible(true);
    }
    
    public void salvarFase(String fase) {
        dao.addLevel(fase);
    }
    
    public void getFases() {
        dao.printLevels();
    }
    
}
