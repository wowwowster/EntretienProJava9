package hashcode;

import java.io.Serializable;

public class TheBeanString implements Serializable {

private String nom;

@Override
public int hashCode() {
	return nom.hashCode();
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TheBeanString  other = (TheBeanString ) obj;
	if ("".equals(nom)) {
			return false;
	} else if (nom .equals(other.nom))
		return false;
	return true;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

}
