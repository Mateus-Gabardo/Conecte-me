package controller;

import java.io.File;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameBoardControllerTest {
	
	private GameBoardController controller;        
	
	/**
	 * Teste de integração
	 * CT004
	 */
	@Test
	public void testCarregarArquivoInvalido() {
            controller = new GameBoardController(4,4);
            File file = new File("./src/main/resources/test/arquivoInvalido.txt");
            
            Assertions.assertThatExceptionOfType(Exception.class)
                    .isThrownBy(() -> controller.trataFile(file));
	}
        
        /**
         * Teste de Sistema
         * CT005
         */
        @Test
        public void testCarregarArquivoCorreto(){
            int[][] valid = new int[][]{{0,0,0,32000},{10020,0,0,0},{0,0,0,0},{0,0,0,0}};
            File file = new File("./src/main/resources/stages/nivel1.0.txt");
            controller = new GameBoardController(4,4);
            List<Integer> list = controller.trataFile(file);
            
            Assertions.assertThat(controller.getMatrizByList(list)).isEqualTo(valid);
        }
}
