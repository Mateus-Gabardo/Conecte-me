package core;

import controller.GameBoardController;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ConectMeTest {
//Unitário
    //Gabardo
	@Test
	public void ehMeta_verificaEstadoMetaCorreto() {
		int[][] fase = new int[][] { { 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0 }, //
				{ 0, 20042, 44041, 34004 }, //
				{ 0, 30220, 22130, 13400 } };
		ConectMe conectMe = new ConectMe(fase, "Estado inicial");
		assertTrue(conectMe.ehMeta(), "Deve retornar todos os pinos conectados corretamente");
	}
    
    //Daniel
    @Test
    public void getMatrizByList_verificaMatrizIncorreta() {
        List<Integer> fase = new ArrayList<>();
                fase.add(0);
                fase.add(0);
                fase.add(0);
        GameBoardController gameBoardController = new GameBoardController(4, 4);
        int[][] matriz = gameBoardController.getMatrizByList(fase);
        
        assertTrue(matriz.length == 4 && matriz[0].length == 4, "Matriz do tamanho incorreto");
    }

	@Test
	public void ehMeta_verificaEstadoMetaIncorreto() {
		int[][] fase = new int[][] { { 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0 }, //
				{ 0, 20042, 44041, 34004 }, //
				{ 0, 30220, 23130, 13400 } };//
		ConectMe conectMe = new ConectMe(fase, "Estado inicial");
		assertFalse(conectMe.ehMeta(), "Deve retornar afirmando que o estado não é meta");
	}
}
