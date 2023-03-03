import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmbaralhadorDificil implements Embaralhador {
	private int embaralhadorSelecionado = 0;
	
	
	@Override
	public String embaralhar(String palavra) {
		
		    List<String> letters = Arrays.asList(palavra.split(""));
		    Collections.shuffle(letters);
		    StringBuilder construtorEmbaralhado = new StringBuilder(palavra.length());
		    for (String k : letters) {
		    	construtorEmbaralhado.append(k);
		    }
		    //return construtorEmbaralhado.toString();
		    String palavraRecebida = construtorEmbaralhado.toString();
		    if(embaralhadorSelecionado == 0) {
		    String palavraENumeros = palavraRecebida;
			if(palavraENumeros.contains("A")) {
				palavraENumeros = palavraENumeros.replace("A", "4");
			}
			if(palavraENumeros.contains("I")) {
				palavraENumeros = palavraENumeros.replace("I", "1");
			}
			if(palavraENumeros.contains("O")) {
				palavraENumeros = palavraENumeros.replace("O", "0");
			}
			if(palavraENumeros.contains("E")) {
				palavraENumeros = palavraENumeros.replace("E", "3");
			}
			embaralhadorSelecionado = 1;
			return palavraENumeros;
		    }
		    else {
		    	embaralhadorSelecionado = 0;
		    	String palavraRetornada = construtorEmbaralhado.reverse().toString();
		    	return palavraRetornada;
		    }
	}



	

}
