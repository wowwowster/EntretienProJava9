package hashcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class mainHashCode {

	public static void main(String[] args) {
	TheBean theBeanA= new TheBean();
	theBeanA.setNumCmdeSap(new Long(3));
	
	TheBean theBeanB= new TheBean();
	theBeanB.setNumCmdeSap(new Long(2));
	TheBean theBeanC= new TheBean();
	theBeanC.setNumCmdeSap(new Long(1));
	
	Map<TheBean,Integer> theMap = new HashMap<TheBean,Integer>();
	 theMap.put(theBeanA, new Integer(3));
	 theMap.put(theBeanB, new Integer(2));
	 theMap.put(theBeanC, new Integer(1));

	 Set cles = theMap.keySet();
	 Iterator it = cles.iterator();
	 while (it.hasNext()){
	    Object key= it.next(); // tu peux typer plus finement ici
	    Object valeur = theMap.get(key); // tu peux typer plus finement ici
	    String toto ="";
	 }


	 
		TheBeanString theBeanStringA= new TheBeanString();
		theBeanStringA.setNom("C");
		
		TheBeanString theBeanStringB= new TheBeanString();
		theBeanStringB.setNom("B");
		TheBeanString theBeanStringC= new TheBeanString();
		theBeanStringC.setNom("A");
		
		Map<TheBeanString,Integer> theMapString = new HashMap<TheBeanString,Integer>();
		theMapString.put(theBeanStringA, new Integer(3));
		theMapString.put(theBeanStringB, new Integer(2));
		theMapString.put(theBeanStringC, new Integer(1));

		 Set clesString = theMapString.keySet();
		 Iterator itString = clesString.iterator();
		 while (itString.hasNext()){
		    Object keyString= itString.next(); // tu peux typer plus finement ici
		    Object valeurString = theMapString.get(keyString); // tu peux typer plus finement ici
		    System.out.println(valeurString.toString());
		 }
		 
	}
	


}
