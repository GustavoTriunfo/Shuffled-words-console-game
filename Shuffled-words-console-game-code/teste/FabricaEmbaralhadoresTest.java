import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FabricaEmbaralhadoresTest {

	@Test
	void fabricarEmbaralhador_retornarEmbaralhadorFacil_Ok() {
		//Arrange
		Embaralhador embaralhador;
		//Act
		embaralhador = FabricaEmbaralhadores.fabricarEmbaralhador("1");
		//Assert
		assertEquals(new EmbaralhadorFacil().getClass(), embaralhador.getClass());
	}
	
	@Test
	void fabricarEmbaralhador_retornarEmbaralhadorOpcao2_Ok() {
		//Arrange
		Embaralhador embaralhador;
		//Act
		embaralhador = FabricaEmbaralhadores.fabricarEmbaralhador("2");
		//Assert
		assertEquals(new EmbaralhadorFacil().getClass(), embaralhador.getClass());
	}
	
	@Test
	void fabricarEmbaralhador_retornarEmbaralhadorDificil_Ok() {
		//Arrange
		Embaralhador embaralhador;
		//Act
		embaralhador = FabricaEmbaralhadores.fabricarEmbaralhador("3");
		//Assert
		assertEquals(new EmbaralhadorDificil().getClass(), embaralhador.getClass());
	}

}
