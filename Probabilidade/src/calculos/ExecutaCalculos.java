package calculos;

import javax.swing.JOptionPane;

public class ExecutaCalculos {
	
	public static double[] adicionaValores(String s){
		String[] array = s.split(",");
		double[] xV = new double[array.length];
		for (int i=0; (i<array.length); i++){
			xV[i] = Integer.parseInt(array[i]);
		}
		
		return xV;
	}
	
	public static void main(String[] args) {
		
		
		String cX = (String) JOptionPane.showInputDialog(null, "Entre com o conjunto de valores X, \nEx.: 1,2.5,3.6,4,5,6.... sem espaços:");
		double[] x = adicionaValores(cX);
		cX = (String) JOptionPane.showInputDialog(null, "Entre com o conjunto de valores Y, \nEx.: 1,2.5,3.6,4,5,6.... sem espaços:");
		double[] y = adicionaValores(cX);
		
		//double[] x= {5, 8, 7, 10, 6, 7, 9, 3, 8, 2};
		//double[] y= {6, 9, 8, 10, 5, 7, 8, 4, 6, 2};
		
		CR crQuad = new CR(x, y, 1);
		crQuad.inicializaVariaveis();
		
		CR crReta = new CR(x,y, 2);
		crReta.inicializaVariaveis();
		
		//JOptionPane.showMessageDialog(null, "\n\na= "+String.format("%.3f",cr.coeficientesReta[0]));
		
		/*
		System.out.println("A = "+cr.incognitas[0]);
		System.out.println("A = "+cr.incognitas[1]);
		System.out.println("A = "+cr.incognitas[2]);
		*/
		
		String[] somas = { "1 - Soma de x⁴", "2 - Soma de x³", "3 - Soma de x²", "4 - Soma de x",
				"5 - Soma de y²", "6 - Soma de y", "7 - Soma de x²y", "8 - Soma de xy", "9 - Totais", "10 - Sair" };
		
		String[] fazer = { "1 - Calcular Coeficiente de Correlação Linear", "2 - Calcular e Mostrar o Ajustamento da Reta", 
				"3 - Mostrar o Sistema Para Regressão Quadrática", "4 - Mostrar a Equação Quadrática Resolvida", "5 - Calcular e Mostrar R² ",
				"6 - Mostrar J, Q e yf, assim como a média de yf", "7 - Mostrar Somas x⁴ e etc...", "8 - Sair"};
		
				
		String input = "";
		
		do {
			input = (String) JOptionPane.showInputDialog(null, "O que você deseja fazer?\nSelecione 8 para sair.",
			        "Probabilidade e Estatística", JOptionPane.QUESTION_MESSAGE, null, // Use // default // icon
			        fazer, // Array de escolhas possíveis
			        fazer[0]); // Escolha padrão
			if (input==fazer[0])
				JOptionPane.showMessageDialog(null, input+"\n\nr= "+String.format("%.3f",crQuad.correlacao));
			else if (input==fazer[1])
				JOptionPane.showMessageDialog(null, input+"\n\nReta: "+crQuad.i.mostraReta(crQuad.coeficientesReta));
			else if(input==fazer[2])
				JOptionPane.showMessageDialog(null, input+"\n\nSistema:  \n\n"+crQuad.i.mostraSistema(crQuad.somas, x.length));
			else if(input==fazer[3])
				JOptionPane.showMessageDialog(null, input+"\n\nEquação Quadrática: "+crQuad.i.mostraRegQuad(crQuad.incognitas));
			else if(input==fazer[4]){
				JOptionPane.showMessageDialog(null, input+"\n\n--------------------------------\n\nCOM EQUAÇÃO QUADRÁTICA: ");
				JOptionPane.showMessageDialog(null, input+"\n\nR²: "+String.format("%.3f", crQuad.coefDeterminacao));
				JOptionPane.showMessageDialog(null, input+"\n\n--------------------------------\n\nCOM EQUAÇÃO DE PRIMEIRO GRAU: ");
				JOptionPane.showMessageDialog(null, input+"\n\nR²: "+String.format("%.3f", crReta.coefDeterminacao));
				
			} else if(input==fazer[5]){
				JOptionPane.showMessageDialog(null, input+"\n\n--------------------------------\n\nCOM EQUAÇÃO QUADRÁTICA: ");
				JOptionPane.showMessageDialog(null, input+"\n"+crQuad.i.mostraJQuad(x, y, crQuad.somas, crQuad.incognitas));
				JOptionPane.showMessageDialog(null, input+"\n"+crQuad.i.mostraQquad(x, y, crQuad.somas));
				JOptionPane.showMessageDialog(null, input+"\n"+crQuad.i.mostraYFquad(x, y, crQuad.incognitas, crQuad.somas));
				JOptionPane.showMessageDialog(null, input+"\nMedia de yf = "+String.format("%.3f", crQuad.somas[8]/x.length));
				
				JOptionPane.showMessageDialog(null, input+"\n\n--------------------------------\n\nCOM EQUAÇÃO DE PRIMEIRO GRAU: ");
				JOptionPane.showMessageDialog(null, input+"\n"+crReta.i.mostraJReta(x, y, crReta.somas, crReta.coeficientesReta));
				JOptionPane.showMessageDialog(null, input+"\n"+crReta.i.mostraQreta(x, y, crReta.somas));
				JOptionPane.showMessageDialog(null, input+"\n"+crReta.i.mostraYFreta(x, y, crReta.coeficientesReta, crReta.somas));
				JOptionPane.showMessageDialog(null, input+"\nMedia de yf = "+String.format("%.3f", crReta.somas[8]/x.length));
			}
			else if(input==fazer[6]){
				String sum = "";
				do {
					sum = (String) JOptionPane.showInputDialog(null, "O que você deseja fazer?\nSelecione 8 para sair.",
					        "Probabilidade e Estatística", JOptionPane.QUESTION_MESSAGE, null, // Use // default // icon
					        somas, // Array de escolhas possíveis
					        somas[0]); // Escolha padrão
				
					JOptionPane.showMessageDialog(null, sum+"\n\n"+crQuad.i.mostrarSomas(x, y, sum, somas));
					
					if (sum==somas[8]){
						JOptionPane.showMessageDialog(null, sum+"\n\nTotais para equação quadrática:\n"+
								String.format("%s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s %.3f %n", 
										"x⁴ = ", crQuad.somas[0], "x³ = ", crQuad.somas[1],"x² = ", crQuad.somas[2],
										"x = ", crQuad.somas[3],"y² = ", crQuad.somas[4],"y = ", crQuad.somas[5],
										"x²*y = ", crQuad.somas[6],"x*y = ", crQuad.somas[7],"yf =", crQuad.somas[8]));
						JOptionPane.showMessageDialog(null, sum+"\n\nTotais para equação de primeiro grau:\n"+
								String.format("%s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s%.3f%n %s %.3f %n", 
										"x⁴ = ", crReta.somas[0], "x³ = ", crReta.somas[1],"x² = ", crReta.somas[2],
										"x = ", crReta.somas[3],"y² = ", crReta.somas[4],"y = ", crReta.somas[5],
										"x²*y = ", crReta.somas[6],"x*y = ", crReta.somas[7],"yf =", crReta.somas[8]));
					}
					
					
				} while (sum!=somas[9]);
			}
		} while (input!=fazer[7]);
	}
}
