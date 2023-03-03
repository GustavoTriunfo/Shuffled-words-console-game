import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmbaralhadorFacilTest {

	@Test
	void embaralhar_embralharPalavraFacil_Ok() {
		//Arrange
		Embaralhador embaralhador;
		//Act
		embaralhador = FabricaEmbaralhadores.fabricarEmbaralhador("1");
		String palavraEmbaralhada = embaralhador.embaralhar("palavra");
		//Assert
		assertNotEquals("palavra", palavraEmbaralhada);
		assertEquals(7,palavraEmbaralhada.length());
	}

}
