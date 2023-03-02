package view;
import controller.RedesController;
import javax.swing.JOptionPane;
public class main {

	public static void main(String args[]) {
		RedesController si = new RedesController();
		int opc=0;
		String os = si.NomeSI();
		while(opc!=9){
		opc=Integer.parseInt(JOptionPane.showInputDialog("1-Chamar Metodo Ip\n2-Chamar Metodo Ping\n9-Finalizar"));	
		switch(opc){case 1: si.ChamaProcesso(os);
					break;
					case 2: si.TempoMedio(os);
					break;
					case 9: JOptionPane.showMessageDialog(null, "Finalizado");
					break;
					default:JOptionPane.showMessageDialog(null, "Opção Invalida");
					break;
			}
		}
	}	
}

