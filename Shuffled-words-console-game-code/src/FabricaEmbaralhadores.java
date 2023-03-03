
public class FabricaEmbaralhadores {

	public static Embaralhador fabricarEmbaralhador(String opcao)
	{
		switch(opcao) {
		case "1":
			return new EmbaralhadorFacil();
		case "2":
			return new EmbaralhadorFacil();
		case "3": 
			return new EmbaralhadorDificil();
		default:
			return new EmbaralhadorFacil();
		}
		
	}
	
}
