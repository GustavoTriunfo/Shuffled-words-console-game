import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmbaralhadorFacil implements Embaralhador {
	@Override
	public String embaralhar(String palavra) {
		String palavraEmbaralhada = null;
		do {
		
		    List<String> letters = Arrays.asList(palavra.split(""));
		    Collections.shuffle(letters);
		    StringBuilder construtorEmbaralhado = new StringBuilder(palavra.length());
		    for (String k : letters) {
		    	construtorEmbaralhado.append(k);
		    	palavraEmbaralhada = construtorEmbaralhado.toString();
		    }
		}while(palavraEmbaralhada.equals(palavra));
		    return palavraEmbaralhada;
	}

}
