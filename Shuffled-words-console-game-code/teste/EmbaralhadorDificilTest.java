import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmbaralhadorDificilTest {

	@Test
	void embaralhar_embralharPalavraComLetraA_Ok() {
		//Arrange
		Embaralhador embaralhador;
		//Act
		embaralhador = FabricaEmbaralhadores.fabricarEmbaralhador("3");
		String palavraEmbaralhada = embaralhador.embaralhar("PALAVRA");
		//Assert
		assertNotEquals("palavra", palavraEmbaralhada);
		assertEquals(7,palavraEmbaralhada.length());
		assertTrue(palavraEmbaralhada.contains("4"));
	}
	
	@Test
	void embaralhar_validarSegundaExecução_Ok() {
		//Arrange
		Embaralhador embaralhador;
		//Act
		embaralhador = FabricaEmbaralhadores.fabricarEmbaralhador("3");
		String palavraEmbaralhadaComNumero = embaralhador.embaralhar("PALAVRA");
		String palavraEmbaralhadaSemNumero = embaralhador.embaralhar("PALAVRA");
		//Assert
		assertNotEquals("palavra", palavraEmbaralhadaSemNumero);
		assertEquals(7,palavraEmbaralhadaSemNumero.length());
		assertTrue(palavraEmbaralhadaComNumero.contains("4"));
		assertFalse(palavraEmbaralhadaSemNumero.contains("4"));
		
	}

}
