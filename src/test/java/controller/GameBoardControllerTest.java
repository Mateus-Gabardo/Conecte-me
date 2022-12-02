package controller;

import java.io.File;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameBoardControllerTest {
	
	@InjectMocks
	private GameBoardController controller;
	
	/**
	 * Teste de integração
	 * CT004
	 */
	@Test
	public void testCarregarArquivoInvalido() {
		File file = new File("./src/main/resources/test/arquivoInvalido.txt");
		Assertions.assertThatExceptionOfType(Exception.class).isThrownBy(() -> controller.trataFile(file));
	}
}
