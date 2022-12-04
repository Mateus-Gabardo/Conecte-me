package controller;

import View.GameCreateLevel;
import java.util.List;

import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameCreateLevelTest {

    private GameBoardController controller;
    private GameCreateLevel view;
    
    @Test
    public void testTDDValidarFaseNova(){
        int[][] valid = new int[][]{{10001, 0, 0, 20100}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        boolean equal = true;
        controller = new GameBoardController(4, 4);
        view = new GameCreateLevel(controller);
        view.setLevel(0, "10001");
        view.setLevel(3, "20100");
        int[][] salvar = controller.getMatrizByList(controller.trataFaseSalva(view.getLevel()));
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                if (valid[i][j] != salvar[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }
    
    

    @Test
    public void testSalvarFaseNova() {
        int[][] valid = new int[][]{{10001, 0, 0, 20100}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        String fase = "10001, 0, 0, 20100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        controller = new GameBoardController(4, 4);
        controller.salvarNovaFase(fase);

        List<Integer> list = controller.trataFaseSalva(fase);

        Assertions.assertThat(controller.getMatrizByList(list)).isEqualTo(valid);
    }
    
    @Test
    public void testFaseSalva() {
        String fase = "10001, 0, 0, 20100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        controller = new GameBoardController(4, 4);
        int size = controller.getLevels().size();
        controller.salvarNovaFase(fase);
        assertTrue(controller.getLevels().size() == size + 1);
    }
    
    
    
}
