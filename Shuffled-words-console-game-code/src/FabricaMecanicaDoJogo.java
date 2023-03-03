
public class FabricaMecanicaDoJogo {
	
public static MecanicaDoJogo fabricarMecanica(String opcao) {
	
	switch(opcao) {
	case "1": 
	     return new MecanicaJogoNormal();
	case "2":
		 return  new MecanicaJogoNormal();
	case "3": 
		 return new MecanicaJogoDificil();
		default:System.out.println("Você digitou um char incorreto. Tente de novo!");
			return null;
	}
	
}

}
