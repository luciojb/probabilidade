package calculos;

public class Interface {
	
	public String mostrarSomas(double[] valoresx, double[] valoresy, String opcao, String[] optionList){
		String s = "";
		for (int i=0; i<valoresx.length;i++){
			if (opcao==optionList[0])
				s+= (String.format("%.3f%s %.3f%n", valoresx[i], "⁴ = ", Math.pow(valoresx[i], 4)));
			else if (opcao==optionList[1])
				s+= (String.format("%.3f%s %.3f%n", valoresx[i], "³ = ", Math.pow(valoresx[i], 3)));
			else if (opcao==optionList[2])
				s+= (String.format("%.3f%s %.3f%n", valoresx[i], "² = ", Math.pow(valoresx[i], 2)));
			else if (opcao==optionList[3])
				s+= (String.format("%s %.3f%n", "X = ", valoresx[i]));
			else if (opcao==optionList[4])
				s+= (String.format("%.3f%s %.3f%n", valoresy[i], "² = ", Math.pow(valoresy[i], 2)));
			else if (opcao==optionList[5])
				s+= (String.format("%s %.3f%n", "Y = ", valoresy[i]));
			else if (opcao==optionList[6])
				s+= (String.format("%.3f%s %.3f %s %.3f%n", valoresx[i], "² * ", valoresy[i], " = ", Math.pow(valoresx[i], 2)*valoresy[i]));
			else if (opcao==optionList[7])
				s+= (String.format("%.3f%s %.3f %s %.3f%n", valoresx[i], " * ", valoresy[i], " = ", valoresx[i]*valoresy[i]));
			
		}
		return s;
	}
	
	public  String mostraReta(double[] coef){
		String s="";
		if(coef[1]>0)
			s="+"+String.format("%.3f", (coef[1]));
		else
			s=String.format("%.3f", (coef[1]));
			
		return (String.format("%s %.3f%s %s", "y =", coef[0], "x", s));
	}
	
	public String mostraSistema(double[] somas, int tam){
		String B1 ="";
		if(somas[1]>0)
			B1="+"+String.valueOf(somas[1]);
		else
			B1=String.valueOf(somas[1]);
		
		String C1="";
		if(somas[2]>0)
			C1="+"+String.valueOf(somas[2]);
		else
			C1=String.valueOf(somas[2]);
		
		String C2="";
		if(somas[3]>0)
			C2="+"+String.valueOf(somas[3]);
		else
			C2=String.valueOf(somas[3]);
		
		
				
		return (String.format("%.3f%s %s%s %s%s %.3f%n", somas[0], "A", B1,"B",  C1, "C =", 
				somas[6]))+(String.format("%.3f%s %s%s %s%s %.3f%n", somas[1], "A", C1,"B",  C2, "C =", 
				somas[7]))+(String.format("%.3f%s %s%s %d%s %.3f", somas[2], "A", C2,"B +",  tam, "C =", 
				somas[5]));
	}
	
	public  String mostraRegQuad(double[] incognitas){
		String B="";
		String C="";
		if (incognitas[1]>=0)
			B = "+"+String.format("%.3f", incognitas[1]);
		else
			B = String.format("%.3f", incognitas[1]);
		if (incognitas[2]>=0)
			C = "+"+String.format("%.3f", incognitas[2]);
		else
			C = String.format("%.3f", incognitas[2]);
		
		return (String.format("%s %.3f%s %s%s %s", "y =", incognitas[0], "x²", B, "x", C));
	}
	
	

	public  StringBuilder mostraJQuad(double[] x, double[] y, double[] somas, double[] incognitas){
		StringBuilder s = new StringBuilder();
		for (int i=0; i<x.length;i++){
			s.append(String.format("%s%.3f %s %.3f%s %.3f", "(", (incognitas[0]*Math.pow(x[i], 2)+
					(incognitas[1]*x[i])+(incognitas[2])), "-", y[i], ")² =",
					Math.pow(((incognitas[0]*Math.pow(x[i], 2))+
					(incognitas[1]*x[i])+
					(incognitas[2]))-y[i], 2)));
			s.append("\n");
		}
		s.append("\n"+String.format("%s %.3f", "J =",  somas[9]/y.length));
		return s;
	}
	
	public  StringBuilder mostraJReta(double[] x, double[] y, double[] somas, double[] coeficiente){
		StringBuilder s = new StringBuilder();
		for (int i=0; i<x.length;i++){
			s.append(String.format("%s%.3f %s %.3f%s %.3f", "(", ((coeficiente[0]*x[i])+
					(coeficiente[1])), "-", y[i], ")² =",
					Math.pow(((coeficiente[0]*x[i])+(coeficiente[1]))-y[i], 2)));
			s.append("\n");
		}
		s.append("\n"+String.format("%s %.3f", "J =",  somas[9]/y.length));
		return s;
	}
	
	public  String mostraQquad(double[] x, double[] y, double[] somas){
		String s = "";
		for (int i=0; i<x.length;i++) {
			s+=("(");
			s+=(String.format("%.3f %s %.3f", y[i], " - ", (somas[8]/y.length)));
			s+=(")² = ");
			s+=(String.format("%.3f", Math.pow((y[i]-(somas[8])/y.length), 2)));
			s+=("\n\n");
		}
		
		s+=(String.format("%s %.3f", "Q =",  somas[10]));
		return s;
	}
	
	public  String mostraQreta(double[] x, double[] y, double[] somas){
		String s = "";
		for (int i=0; i<x.length;i++) {
			s+=("(");
			s+=(String.format("%.3f %s %.3f", y[i], " - ", (somas[8]/y.length)));
			s+=(")² = ");
			s+=(String.format("%.3f", Math.pow((y[i]-(somas[8])/y.length), 2)));
			s+=("\n\n");
		}
		
		s+=(String.format("%s %.3f", "Q =",  somas[10]));
		return s;
	}
	
	public  StringBuilder mostraYFquad(double[] x, double[] y, double[] incognitas, double[] somas){
		StringBuilder s = new StringBuilder();
		for (int i =0; i<x.length;i++){
			s.append(String.format("%.3f", (incognitas[0]*Math.pow(x[i], 2)+(incognitas[1]*x[i])+
					(incognitas[2]))));
			s.append("\n");
		}
		s.append("Media yf = "+String.format("%.3f", (somas[8]/(x.length))));
		return s;
	}
	
	public  StringBuilder mostraYFreta(double[] x, double[] y, double[] coeficiente, double[] somas){
		StringBuilder s = new StringBuilder();
		for (int i =0; i<x.length;i++){
			s.append(String.format("%.3f", ((coeficiente[0]*x[i])+(coeficiente[1]))));
			s.append("\n");
		}
		s.append("Media yf = "+String.format("%.3f", (somas[8]/(x.length))));
		return s;
	}
	
	
}
