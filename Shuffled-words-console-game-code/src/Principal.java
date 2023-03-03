import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Principal {
	private static Clip clipEfeito2, clipMenu, clipModoFacilENormal, clipModoDificil, clipMusicaFinal;
	public static String palavraDigitada = null; 
	private static Scanner ler = new Scanner(System.in);
	  private static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
	  private static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
	  private static final String CYAN_BOLD = "\033[1;36m";   // CYAN
	  private static final String RESET = "\033[0m";
	  private static final String BLACK_BOLD = "\033[1;30m";  // BLACK
	  private static final String RED_BOLD = "\033[1;31m";
	  private static final String GREEN_BOLD = "\033[1;32m";  // GREEN
	  private static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	  private static final String WHITE_BOLD = "\033[1;37m";  // WHITE
	
	
	public static void main(String[] args) throws InterruptedException {
		
		BancoDePalavras bancoPalavra = new BancoDePalavras();
		
		//Fabrica da mecanica do jogo
		MecanicaDoJogo mecanica;
		
		//Fabrica de embaralhadores
		Embaralhador embaralhador;
		
		String palavraEmbaralhada = "";
	
		
		String opcaoDificuldade= null;
		boolean opcaoContinuar = false;
		String opcaoContinua = null;
		 boolean retorno = false;
		
		
			
		do {
			 musicaMenu();
			efeitoSonoro2();
			try {
				printWithDelays("\n                                                                   █▀ █▀▀ ░░█ ▄▀█   █▄▄ █▀▀ █▀▄▀█   █░█ █ █▄░█ █▀▄ █▀█   ▄▀█ █▀█\r\n"
						+ "                                                                   ▄█ ██▄ █▄█ █▀█   █▄█ ██▄ █░▀░█   ▀▄▀ █ █░▀█ █▄▀ █▄█   █▀█ █▄█" + "\n", TimeUnit.MILLISECONDS, 5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printWithDelays("\n" + "                                                ██████╗░░█████╗░██╗░░░░░░█████╗░██╗░░░██╗██████╗░░█████╗░  ███████╗███╗░░██╗██╗░██████╗░███╗░░░███╗░█████╗░\r\n"
					+ "			                        ██╔══██╗██╔══██╗██║░░░░░██╔══██╗██║░░░██║██╔══██╗██╔══██╗  ██╔════╝████╗░██║██║██╔════╝░████╗░████║██╔══██╗\r\n"
					+ "		          	        	██████╔╝███████║██║░░░░░███████║╚██╗░██╔╝██████╔╝███████║  █████╗░░██╔██╗██║██║██║░░██╗░██╔████╔██║███████║\r\n"
					+ "			          	        ██╔═══╝░██╔══██║██║░░░░░██╔══██║░╚████╔╝░██╔══██╗██╔══██║  ██╔══╝░░██║╚████║██║██║░░╚██╗██║╚██╔╝██║██╔══██║\r\n"
					+ "				                ██║░░░░░██║░░██║███████╗██║░░██║░░╚██╔╝░░██║░░██║██║░░██║  ███████╗██║░╚███║██║╚██████╔╝██║░╚═╝░██║██║░░██║\r\n"
					+ "			                   	╚═╝░░░░░╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝  ╚══════╝╚═╝░░╚══╝╚═╝░╚═════╝░╚═╝░░░░░╚═╝╚═╝░░╚═\"", TimeUnit.MILLISECONDS, 3);
			clipEfeito2.stop();
			System.out.println("\n\n                                                                                                                              By Gustavo Costa de Andrade\n");
			
			 printWithDelays("                                                                              Descubra que palavra embaralhada é essa!\n", TimeUnit.MILLISECONDS, 55);

		System.out.println(WHITE_BOLD +"\nEscolha a dificuldade: \n" + RESET);
		System.out.println(GREEN_BOLD + "Fácil:1"  + RESET);
		System.out.println(YELLOW_BOLD + "\nNormal:2"  + RESET);
		System.out.println(RED_BOLD + "\nDificil:3"  + RESET);
		
		
		do {
			do {
			 opcaoDificuldade = ler.nextLine();
			 efeitoSonoro1();
			 if(!opcaoDificuldade.equals("1") && !opcaoDificuldade.equals("2") && !opcaoDificuldade.equals("3")) {
				 System.out.println("Você digitou um char incorreto. Tente de novo!");
			 }
			}while(!opcaoDificuldade.equals("1") && !opcaoDificuldade.equals("2") && !opcaoDificuldade.equals("3"));
			 mecanica = FabricaMecanicaDoJogo.fabricarMecanica(opcaoDificuldade);
			 embaralhador = FabricaEmbaralhadores.fabricarEmbaralhador(opcaoDificuldade);

			
				 clipMenu.stop();
				 if(opcaoDificuldade.equals("1") || opcaoDificuldade.equals("2")) {
					 musicaModoFacilENormal();
				 }
				 if(opcaoDificuldade.equals("3")) {
					 musicaModoDificil();
					 efeitoSonoroFloweyComeco();
					 System.out.println("\n\n\n");
					 printWithDelays("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠖⣛⠉⠉⠉⠉⠉⠛⠒⠦⣄⣀⡤⠖⠛⠉⠉⠉⠉⠉⣙⠓⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⢠⡞⠁⠀⠀⠈⠙⠳⣄⣀⣤⣶⣶⣶⣾⣿⣶⣶⣶⣤⣀⣠⠞⠋⠁⠀⠀⠈⠳⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⡟⠀⠀⠀⠀⣠⣴⣾⣿⠿⠟⠛⠋⠉⠉⠉⠉⢙⠛⠻⠿⣿⣷⣦⣄⠀⠀⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⣀⣤⠶⠖⠛⠋⠉⠙⣳⣾⣿⠟⠉⠀⠀⠀⣰⣶⡀⠀⠀⢠⣾⣆⠀⠀⠀⠉⠻⣿⣿⣶⠚⠛⠉⠙⠛⠲⠶⣤⣀⠀⠀⠀\r\n"
					 		+ "⠀⣴⠟⠉⠀⠀⠀⠀⠀⢀⣼⣿⠟⠁⠀⠀⠀⠀⠀⣿⣿⣇⠀⠀⣼⣿⣿⠀⠀⠀⠀⠀⠈⠻⣿⣷⡀⠀⠀⠀⠀⠀⠀⠉⠳⣄⠀\r\n"
					 		+ "⣾⠁⠀⠀⠚⠒⠲⠶⠦⣼⣿⡟⠀⠀⠀⠀⠀⠀⠀⣿⣿⡿⠀⠀⢿⣿⣿⠃⠀⠀⠀⠀⠀⠀⢹⣿⣧⣤⠶⠖⠊⠉⠀⠀⠀⠘⡆\r\n"
					 		+ "⣧⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠁⠀⠀⠀⠀⡄⠀⠀⢿⣿⠃⠀⠀⠸⣿⡟⠀⠀⢠⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢠⡇\r\n"
					 		+ "⠘⢷⣀⠀⠀⠀⠀⠀⠀⢻⣿⣇⠀⠀⠀⠀⠙⢦⣤⣄⣀⣀⣀⣀⣀⣈⣤⣤⡴⠞⠀⠀⠀⠀⢰⣿⡟⠀⠀⠀⠀⠀⠀⢀⣴⠏⠀\r\n"
					 		+ "⠀⠀⠙⠷⢤⣀⣀⡀⠀⠈⢿⣿⣆⠀⠀⠀⠀⠀⠹⢦⣈⠉⠉⠉⠉⢁⣠⠟⠀⠀⠀⠀⠀⣠⣿⣿⣅⣀⣀⣀⣤⠴⠞⠋⠁⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠈⠉⣩⡿⠛⠻⣿⣷⣄⡀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠀⠀⠀⠀⢀⣠⣾⣿⠟⠉⠓⢦⣄⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⢀⡴⠛⠻⢿⣿⣶⣤⣄⣀⣀⠀⠀⠀⠀⣀⣀⣠⣤⣶⣿⡿⠟⠙⠶⣄⠀⠀⠉⢷⡀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⢰⡏⠀⠀⢠⠟⠀⠀⠀⠀⠈⠙⠛⠿⠿⠿⣿⣿⣿⣿⣿⠿⠟⠛⠋⠁⠀⠀⠀⠀⠙⡆⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠘⣧⠀⠀⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣿⣿⣿⣿⣿⡦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⣠⡟⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠈⠛⠶⢤⣄⣀⣀⣠⣤⠤⠴⠒⠋⣱⣿⣿⣿⣿⣿⡟⠁⠈⠙⠒⠦⠤⣤⣄⣀⣠⣤⠴⠞⠉⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠟⠛⠛⠻⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡟⠀⠀⠀⢠⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡆⠀⠀⠈⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣦⡀⠀⠈⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⡀⠀⠀⠙⣆⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣆⠀⠀⠀⠀⣼⠃⠀⠀⠀⢸⡄⠀⣾⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣆⠀⣠⠞⠁⠀⠀⠀⠀⠀⡇⣰⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣧⣄⡀⠀⠀⠀⠀⣠⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠙⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀", TimeUnit.MILLISECONDS, 1);
				 }
				 retorno = true;
			
			 
		}while(retorno == false); //Verifica se a opção é válida
		do {
			String palavraEscolhida = bancoPalavra.retornaPalavra(opcaoDificuldade);
			palavraEmbaralhada = embaralhador.embaralhar(palavraEscolhida);
			System.out.println(WHITE_BACKGROUND + BLACK_BOLD + "\nPalavraEnigma => " + BLACK_BACKGROUND + WHITE_BOLD + palavraEmbaralhada + RESET);
			System.out.println("Digite a palavra:");
			palavraDigitada = ler.nextLine().toUpperCase();
			efeitoSonoro1();
			if (mecanica.compararPalavras(palavraEscolhida, palavraDigitada))
			{
				if(opcaoDificuldade.equals("3")){
					efeitoSonoroFloweyAcertou();
				}
				System.out.println(WHITE_BACKGROUND + GREEN_BOLD +"\nParabéns você acertou!! "+ RESET + " \nSua Pontuação atual é:" + CYAN_BOLD + mecanica.recuperarPontuacao() + RESET);
			}
			else
			{
				if (mecanica.recuperarStatus() == true)
				{
					if(opcaoDificuldade.equals("3")){
						efeitoSonoroFloweyErrou();
					}
					System.out.println(BLACK_BACKGROUND + RED_BOLD + "\nVocê errou!!" + RESET + "\nVocê ainda tem: " + mecanica.qtdTentivasRestantes() + " tentativa(s).");
				}
				else
				{
                   if(opcaoDificuldade.equals("1")||opcaoDificuldade.equals("2")){
                	   clipModoFacilENormal.stop();
					}
					efeitoSonoroGameOver();
                     if(opcaoDificuldade.equals("3")){
                    	 clipModoDificil.stop();
                    	 printWithDelays("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠉⠁⠀⠉⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉⠁⢠⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠉⠉⠙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠛⠛⠳⠶⢤⣀⡀⠀⠀⠀⠀⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⡼⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠳⢤⣀⠀⠀⠀⠀⠈⠿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⣼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣦⣄⣠⣄⣤⣬⣿⠿⠿⠿⠿⠿⠿⠿⣷⣿⣿⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣬⣿⣿⠿⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠿⢿⣷⣤⡀⠀⠀⠀⠀⠀⣠⣾⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⣦⡀⢀⣴⠿⠛⠉⠉⠀⠀⠀⠀⠠⠽⠿⠿⢿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣶⣦⣤⣤⣤⣤⣤⣄⡀⢠⣾⡟⠁⠀⠀⠀⣠⣶⣶⣶⣦⣄⠀⠀⠀⠀⣠⣶⣶⣶⣤⣄⠀⠀⠀⠀⠘⢿⣿⣟⠁⠀⠀⣀⣤⠖⠛⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠛⠛⢻⣿⡟⠀⠀⠀⣴⣿⣿⣿⡿⢻⣿⣿⣷⠀⠀⢸⣿⣿⠟⢿⣿⣿⣷⣄⠀⠀⠀⠈⣿⣿⣤⣶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠀⣿⣿⢠⣾⠀⣾⣿⣿⣿⣿⣷⣶⣿⣿⡿⠀⠀⠘⣿⣿⣷⣾⣿⣿⣿⣿⣷⠴⣦⠀⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⠈⠛⠶⣤⣀⡈⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠀⣀⣠⣶⠟⢀⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣸⣿⡇⠀⠀⠈⢻⣿⣷⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣿⠟⠋⠀⠀⣼⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⣠⠶⠛⠛⠻⣿⣿⡀⠀⠀⠀⠙⢿⣿⣇⣤⣄⠀⢀⣠⣤⡀⠀⣀⣀⠀⣿⣿⠏⠀⠀⠀⢠⣿⣿⠓⠲⠶⢶⣦⣤⣤⣤⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣷⠀⠀⠀⢀⣀⡤⠖⠊⠁⠀⠀⠀⠀⠘⣿⣷⡀⠀⠀⠀⠀⢻⡟⠙⢿⡶⢿⣿⣿⡷⠼⢻⣿⣿⢿⡟⠀⠀⠀⠀⣾⣿⠇⠀⠀⠀⠀⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣦⣤⠔⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠁⠈⠻⠟⠁⠀⠀⠈⠁⠈⠁⠀⠀⢀⣾⣿⠏⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣬⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣿⣿⠟⠁⠀⠻⣿⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣾⠟⠋⠀⠀⠀⠉⠛⠦⡀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣷⣄⣀⣀⣀⣀⣠⣴⣾⣿⣿⣿⡟⠁⠀⠀⠀⠀⣿⡿⠿⠿⣿⣶⣶⣦⣤⣤⣤⣤⣴⣶⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢦⡀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠸⠁⠀⠀⠀⠀⠈⠉⠛⠻⢿⣿⣿⣿⣯⣭⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡆⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⡿⠛⠛⠿⠿⣿⣿⣿⣷⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⣧⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠈⠙⠻⢿⣿⣿⣷⣦⣄⣀⠀⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⢀⡆⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣦⣄⡀⠀⠀⠀⠀⠀⠀⠉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⢠⡞⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⡞⠀⠀⠀⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⢀⣾⢟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣷⠀⠙⢿⣿⣟⣿⠟⠁⠀⠀⠀⠀⢀⣤⣴⢟⣡⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠻⣷⣄⣴⡿⠋⠁⠀⠀⠀⠀⣠⣾⢿⣿⣿⡿⠋⢠⣿⢻⡟⡿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠘⢿⣿⡀⠀⠀⠀⣀⣤⡾⠛⠁⢸⣿⠃⠀⠀⣸⡏⣘⢀⡇⢰⣟⣿⢰⡎⢨⡋⣿⣹⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
                    	 		+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠙⢿⣿⣿⣿⠟⠉⠀⠀⠀⣾⡗⠀⣠⣾⣿⣴⣿⣿⣷⣿⣿⣿⣾⣷⣾⣾⣦⣿⣿⣿⣿⣿⣿⣿⣿⣿", TimeUnit.MILLISECONDS, 1);
					}
                    System.out.println(BLACK_BACKGROUND + RED_BOLD + "\nVocê errou!!" + RESET);
					System.out.println(BLACK_BACKGROUND + RED_BOLD + "Você não tem mais tentativas!! \nGAME OVER!" + RESET);
					System.out.println( GREEN_BOLD + "\nPontuação Total: " + CYAN_BOLD + mecanica.recuperarPontuacao() + RESET);
				}
			}
		}while(mecanica.recuperarStatus() == true && mecanica.recuperarPontuacao() < 50); //Verifica se o jogo terminou
		if(mecanica.recuperarPontuacao() >= 50) {
			if(opcaoDificuldade.equals("1")||opcaoDificuldade.equals("2")) {
				clipModoFacilENormal.stop();
			}
			if(opcaoDificuldade.equals("3")) {
				clipModoDificil.stop();
			}
			
			musicaFinalCompleto();
			for(int i = 0; i < 15; i++) {
				System.out.println("\n");
			}
			System.out.println(WHITE_BOLD + "                                                                                   🏅Parabéns! Você completou o jogo!!🏅" + RESET);
			if(opcaoDificuldade.equals("3")) {
				System.out.println("                                                                                            +=={::::::::::::::>");
				for(int i = 0; i < 7; i++) {
					System.out.println("\n");
				}
			}else {
			for(int i = 0; i < 8; i++) {
				System.out.println("\n");
			}
			}
			System.out.println( GREEN_BOLD + "\nPontuação Total: " + CYAN_BOLD + mecanica.recuperarPontuacao() + RESET);
			
		}
		System.out.println(WHITE_BOLD + "Deseja jogar de novo?\nSim:1\nNão:2" + RESET);
		do { 
			opcaoContinua = ler.nextLine();
			efeitoSonoro1();
			
			switch(opcaoContinua) {
			case "1": opcaoContinuar = true;
			if(mecanica.recuperarPontuacao() >= 50) {
				clipMusicaFinal.stop();
			}
				break;
			case "2": opcaoContinuar = false;
				break;
				default: System.out.println("Você digitou um char incorreto. Tente De novo!\n");
					break;
			}
		}while(!opcaoContinua.equals("1") && !opcaoContinua.equals("2") ); //Verifica se a escolha foi válida
			for(int i = 0; i < 50; i++) {
				System.out.println("\n");
			}
		}while(opcaoContinuar == true); //Verifica se o jogador quer continuar o jogo
}
	

	public static void printWithDelays(String data, TimeUnit unit, long delay)
	        throws InterruptedException {
	    for (char ch : data.toCharArray()) {
	        System.out.print(ch);
	        unit.sleep(delay);
	    }
	}
	
	private static void efeitoSonoro1() {
		try {
		File file = new File("SoundEffect.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  Clip clipEfeito = AudioSystem.getClip();
		  clipEfeito.open(audioStream);
		  clipEfeito.start();
		  clipEfeito.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void efeitoSonoro2() {
		try {
		File file = new File("undyne-efeito.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  clipEfeito2 = AudioSystem.getClip();
		  clipEfeito2.open(audioStream);
		  clipEfeito2.start();
		  clipEfeito2.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void efeitoSonoroGameOver() {
		try {
		File file = new File("Undertale-Omega-Flowey_s-Laugh.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  clipEfeito2 = AudioSystem.getClip();
		  clipEfeito2.open(audioStream);
		  clipEfeito2.start();
		  clipEfeito2.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void efeitoSonoroFloweyComeco() {
		try {
		File file = new File("That_s-a-Wonderful-Idea_.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  clipEfeito2 = AudioSystem.getClip();
		  clipEfeito2.open(audioStream);
		  clipEfeito2.start();
		  clipEfeito2.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void efeitoSonoroFloweyAcertou() {
		try {
		File file = new File("flowey-says-triple.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  clipEfeito2 = AudioSystem.getClip();
		  clipEfeito2.open(audioStream);
		  clipEfeito2.start();
		  clipEfeito2.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void efeitoSonoroFloweyErrou() {
		try {
		File file = new File("Undertale-newlaugh.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  clipEfeito2 = AudioSystem.getClip();
		  clipEfeito2.open(audioStream);
		  clipEfeito2.start();
		  clipEfeito2.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void musicaMenu() {
		try {
			 File fileAudio = new File("Undertale-OST_-006-Uwa__-So-Temperate♫.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  clipMenu = AudioSystem.getClip();
			  clipMenu.open(audioStream);
			  clipMenu.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void musicaModoFacilENormal() {
		try {
			 File fileAudio = new File("Undertale-OST_-005-Ruins.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  clipModoFacilENormal = AudioSystem.getClip();
			  clipModoFacilENormal.open(audioStream);
			  clipModoFacilENormal.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	private static void musicaModoDificil() {
		try {
			 File fileAudio = new File("Undertale-OST_-031-Waterfall.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  clipModoDificil = AudioSystem.getClip();
			  clipModoDificil.open(audioStream);
			  clipModoDificil.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	private static void musicaFinalCompleto() {
		try {
			 File fileAudio = new File("Undertale-OST_-011-Determination.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  clipMusicaFinal = AudioSystem.getClip();
			  clipMusicaFinal.open(audioStream);
			  clipMusicaFinal.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
}
