package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	
	// Indetifica o nome Si e retorna
	public String NomeSI() {
		String os = System.getProperty("os.name");
		if(os.contains("Windows")) {
			String[] vtos = os.split(" ");
			os = vtos[0];
		}
		else {
				if(os.contains("Linux")) {
					String[] vtos = os.split(" ");
					os = vtos[0];
				}
			}
		
		return os;
	}
	
	// chama e ler processo ip ------------------------------------->
	
	public void ChamaProcesso(String os) {
		
		if(os.contains("Windows")){
		String a = "";
		String process="ipconfig";
		try {
			Process ip = Runtime.getRuntime().exec(process);
			InputStream fluxo = ip.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
				while(linha!=null) {
					if(linha.contains("Adaptador")) {
						a = linha;}
						
					if(linha.contains("IPv4")){
						String[] vt= linha.split(":");
						System.out.println(a);
						System.out.println(vt[1]);
						}
					linha = buffer.readLine();}
				
				fluxo.close();
				leitor.close();
				buffer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//linux
		if(os.contains("Linux")) {
			String a = "";
			String process="ifconfig";
			try {
				Process ip = Runtime.getRuntime().exec(process);
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
					while(linha!=null) {
						if(linha.contains("Adaptador")) {
							a = linha;}
							
						if(linha.contains("IPv4")){
							String[] vt= linha.split(":");
							System.out.println(a);
							System.out.println(vt[1]);
							}
						linha = buffer.readLine();}
					
					fluxo.close();
					leitor.close();
					buffer.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		// Fim Chama e ler IpConfig --------------------------------------->
	
		// Chama Tempo medio ping ------------------------------------->
		
		public void TempoMedio(String os) {
			if(os.contains("Windows")) {
			String process="PING -4 -n 10 www.google.com.br";
			try {
				Process ip = Runtime.getRuntime().exec(process);
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha!=null) {
					if(linha.contains("M�dia"))//Obs minha versao de windows media sai assim; 
					{
						String vt[]=linha.split("ms,");
						System.out.println(vt[2]);
					}
					linha=buffer.readLine();
				}
			}
			
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
			
			//linux --------------------------
		if(os.contains("Linux")) {
			String process="ping -4 -c 10 www.google.com.br";
			try {
				Process ip = Runtime.getRuntime().exec(process);
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha!=null) {
					if(linha.contains("méd")) {
						String vt[]=linha.split("/");
						System.out.println(vt[1]);
						System.out.println(vt[4]);
					}
					linha=buffer.readLine();
				}
			}
			
			catch (Exception e) {
				e.printStackTrace();
				}
		}
		//fim linux---------------------------------
	}
		// fim classe Ping ------------------------------------>
}