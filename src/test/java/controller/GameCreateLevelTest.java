package controller;

import java.io.File;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameCreateLevelTest {

    private GameBoardController controller;

    /**
     * Teste de integração CT004
     */
    @Test
    public void testCarregarArquivoInvalido() {
        controller = new GameBoardController(4, 4);
        File file = new File("./src/main/resources/test/arquivoInvalido.txt");

        Assertions.assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> controller.trataFile(file));
    }

    /**
     * Teste de Sistema CT005
     */
    @Test
    public void testSalvarFaseNova() {
        int[][] valid = new int[][]{{10001, 0, 0, 20100}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        String fase = "10001, 0, 0, 20100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        controller = new GameBoardController(4, 4);
        controller.salvarNovaFase(fase);
        
        List<Integer> list = controller.trataFaseSalva(fase);

        Assertions.assertThat(controller.getMatrizByList(list)).isEqualTo(valid);
    }
}
