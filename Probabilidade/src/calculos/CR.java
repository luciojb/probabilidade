
package calculos;

public class CR {
	public double[] somas = new double[11];
	public double[] x;
	public double[] y;
	public double coefDeterminacao, correlacao;
	public double[] incognitas = new double[3];
	public double[] coeficientesReta = new double [2];
	public Interface i;
	public int opcao;
	
	public CR(double[] x, double[] y, int opcao){
		this.x = x;
		this.y = y;
		i = new Interface();
		this.opcao=opcao;
	}
	
	public void inicializaVariaveis(){
		somas();
		coefCorrelacao();
		ajustaReta();
		calculaCramer();
		somaYF(opcao);
		somaJQ(opcao);
		coefDeterminacao = (1 - (somas[9]/somas[10]));
	}
	
	
	public void somas(){
		for (int i=0; i<x.length;i++){
			
			//Soma os valores de x⁴.
			somas[0]+=(Math.pow(x[i], 4));
			
			//soma os valores de x³.
			somas[1]+=(Math.pow(x[i], 3));
			
			//Soma os valores de x².
			somas[2]+=(Math.pow(x[i], 2));
			
			//Soma os valores de x.
			somas[3]+=x[i];
			
			//Soma os valores de y².
			somas[4]+=Math.pow(y[i], 2);
			
			//Soma os valores de y.
			somas[5]+=y[i];
			
			//Soma os valores de x²*y.
			somas[6]+=Math.pow(x[i], 2)*y[i];
			
			//Soma os valores de x*y.
			somas[7]+=x[i]*y[i];
		}
	}
	
	public void somaJQ(int opcao){
		if (opcao == 1){
		
			for (int i=0; i<x.length; i++){
				//Soma os valores de J.
				somas[9]+=Math.pow(((incognitas[0]*Math.pow(x[i], 2))+(incognitas[1]*x[i])+(incognitas[2]))-y[i], 2);
				
				//Soma os valores de Q.
				somas[10]+=Math.pow((y[i]-(somas[8])/y.length), 2);
			}
		} else {
			
			for (int i=0; i<x.length; i++){
				//Soma os valores de J.
				somas[9]+=Math.pow(((coeficientesReta[0]*(x[i]))+coeficientesReta[1])-y[i], 2);
				
				//Soma os valores de Q.
				somas[10]+=Math.pow((y[i]-(somas[8])/y.length), 2);
			}
		}
		
	}
	

	
	
	
	public void coefCorrelacao(){
		final int n = x.length; 
		correlacao =  (
				((n*somas[7])-(somas[3]*somas[5]))
				/
				(Math.sqrt(((n*somas[2])-Math.pow(somas[3], 2))*((n*somas[4])-Math.pow(somas[5], 2))))
				);
	}
	
	public void ajustaReta(){
		
		final int n = x.length;
		
		//Este será coeficiente A!
		coeficientesReta[0] = ((n*somas[7])-(somas[3]*somas[5]))
							/
							((n*somas[2])-Math.pow(somas[3], 2));
		//Este será coeficiente B!
		coeficientesReta[1] = ((somas[5]/n)-(coeficientesReta[0]*(somas[3]/n)));
		
	}
	
	
	public void calculaCramer(){
		final int n = x.length;
		double D = (somas[0]*somas[2]*n)+
				(somas[1]*somas[3]*somas[2])+
				(somas[2]*somas[1]*somas[3])-
				(Math.pow(somas[2], 3))-
				(somas[0]*Math.pow(somas[3], 2))-
				(Math.pow(somas[1], 2)*n);
		
		
		double DX = (somas[6]*somas[2]*n)+
				(somas[1]*somas[3]*somas[5])+
				(somas[2]*somas[7]*somas[3])-
				(Math.pow(somas[2], 2)*somas[5])-
				(somas[6]*Math.pow(somas[3], 2))-
				(somas[1]*somas[7]*n);
		
		double DY = (somas[0]*somas[7]*n)+
				(somas[6]*somas[3]*somas[2])+
				(somas[2]*somas[1]*somas[5])-
				(Math.pow(somas[2], 2)*somas[7])-
				(somas[0]*somas[3]*somas[5])-
				(somas[6]*somas[1]*n);
				
		double DZ = (somas[0]*somas[2]*somas[5])+
				(somas[1]*somas[7]*somas[2])+
				(somas[6]*somas[1]*somas[3])-
				(Math.pow(somas[2], 2)*somas[6])-
				(somas[0]*somas[3]*somas[7])-
				(somas[5]*Math.pow(somas[1], 2));
		
		incognitas[0]= DX/D;
		incognitas[1]= DY/D;
		incognitas[2]= DZ/D;
		
		
	}
	
	public void somaYF(int opcao){
		if (opcao==1){
			for (int i=0; i<x.length; i++){
				//Soma os valores de yf.
				somas[8]+=((incognitas[0]*(Math.pow(x[i], 2)))+(incognitas[1]*x[i])+(incognitas[2]));
			}
		} else {
			for (int i=0; i<x.length; i++){
				//Soma os valores de yf.
				somas[8]+=((coeficientesReta[0]*x[i])+(coeficientesReta[1]));
			}
		}
	}
	
}
