
public class MecanicaJogoDificil implements MecanicaDoJogo {
private int qtdMaxTentativas = 3;
private int qtdTentativas = 0;
private int pontuacao = 0;

	
	@Override
	public boolean compararPalavras(String palavraEscolhida, String palavraDigitada) {
		
		if (palavraEscolhida.equals(palavraDigitada))
		{
			pontuacao += 10;
			return true;
		}
		else
		{
			qtdTentativas++;
			return false;
		}
		
	}


	@Override
	public boolean recuperarStatus() {
		if (qtdTentativas == qtdMaxTentativas)
			return false;
		else
			return true;
	}


	@Override
	public int recuperarPontuacao() {
		return pontuacao;
	}


	@Override
	public int qtdTentivasRestantes() {
		return  qtdMaxTentativas - qtdTentativas;
	}
	

}
