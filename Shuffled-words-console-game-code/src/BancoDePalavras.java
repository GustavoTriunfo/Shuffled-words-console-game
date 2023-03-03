import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BancoDePalavras {
	private int numeroMaximo = 0;
	
	public String retornaPalavra(String dificuldade) {
		
		String opcaoBanco = null;
		switch(dificuldade) {
		case "1": opcaoBanco = "BancoDePalavrasFacil.txt";
		                        numeroMaximo = 19;
			break;
		case "2": opcaoBanco = "BancoDePalavrasNormal.txt";
		                        numeroMaximo = 9;
			break;
		case "3": opcaoBanco = "BancoDePalavrasDificil.txt";
	                     	    numeroMaximo = 9;
			break;
		}
		
		List<String> ListaPalavras = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(opcaoBanco))) {
		    String line;
		    while ((line = reader.readLine()) != null) {
		       // process the line.
		    	ListaPalavras.add(line);
		    	//System.out.println(line);
		    }
		    reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int numero = escolhaPalavraAleatoria();
		return  ListaPalavras.get(numero).toUpperCase();
	
	}
	
	private int escolhaPalavraAleatoria() {
		int aleatorio = 0;
		Random rand = new Random();
		// Obtain a number between [0 - 19]. Lista de 20 palavras
		aleatorio = rand.nextInt(numeroMaximo);
		return aleatorio;
	}
	
	
}

