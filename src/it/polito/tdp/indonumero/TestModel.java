package it.polito.tdp.indonumero;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		model.newGame();
		int min=1;
		int max=model.getNMAX();
		
		while(model.isInGame()) {
			int t =(max+min)/2;
			System.out.format("Tra %d e %d provo : %d .",min,max,t);
			int ris=model.tentativo(t);
			
			if(ris<0) {
				min=t+1;
			}else {
				max=t-1;
			}
			System.out.println(ris);
		}
		

	}

}
