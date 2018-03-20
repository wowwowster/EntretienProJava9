package main.java.tests;

public class testDoublon {
	
	static int [] elts;
	static int N =10;
	static int i, j=0, longueurTabElmtsControles; 
	static int []tabElmtsControles = new int[10];
	
	public static void init()  {
	elts = new int[10];
	for (int k = 0; k <N; k++)  
	elts[k]= (int) (100*Math.random());
	    }

	public static void affiche()  {
		for(i=0;i<N; i++)
		System.out.print(elts[i]+" ");
	}

	public static void doublon()  {
		int elmtControle;
		for(j=0;j<N; j++) {
			elmtControle = elts[j];
			controlIfDoublon(elmtControle);
			ajoutDansTabElmtControle(elmtControle);
		}
 	}
	
	public static void  ajoutDansTabElmtControle (int element) {
		tabElmtsControles[j]=element;
		longueurTabElmtsControles++;
	}
	
	public static void  controlIfDoublon (int element) {
		for(int k=0;k<longueurTabElmtsControles; k++) {
			if (element==tabElmtsControles[k] ) {
				System.out.println(element +" est un doublon");
				return;
			};
			
		}
	}
	
	
	public static void main(String[] args) {
		init();
		elts[0]= 4;
		elts[2]= 4;
		elts[6]= 4;
		elts[8]= 4;
		affiche();
		System.out.println("\n-----------");
		doublon();
	  }




}
