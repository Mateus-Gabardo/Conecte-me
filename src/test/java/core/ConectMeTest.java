package core;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConectMeTest {

	@Test
	public void ehMeta_verificaEstadoMetaCorreto() {
		int[][] fase = new int[][]{{0, 0, 0, 0},//
				{0, 0, 0, 0},//
				{0, 20042, 44041, 34004},//
				{0, 30220, 22130, 13400}};
		ConectMe conectMe = new ConectMe(fase, "Estado inicial");
		assertTrue("Deve retornar todos os pinos conectados corretamente", conectMe.ehMeta());	
	}
	
	@Test
	public void ehMeta_verificaEstadoMetaIncorreto() {
		int[][] fase = new int[][] {{0, 0, 0, 0},//
	            {0, 0, 0, 0},//
	            {0,20042,44041,34004},//
	            {0,30220,23130,13400}};//
		ConectMe conectMe = new ConectMe(fase, "Estado inicial");
		assertFalse(conectMe.ehMeta(), "Deve retornar afirmando que o estado não é meta");	
	}
}
