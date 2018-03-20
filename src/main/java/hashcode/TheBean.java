package hashcode;

import java.io.Serializable;

public class TheBean implements Serializable {

private Long numCmdeSap;

@Override
public int hashCode() {
	return numCmdeSap.hashCode();
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TheBean  other = (TheBean ) obj;
	if (numCmdeSap == 0) {
		if (other.numCmdeSap != 0)
			return false;
	} else if (numCmdeSap != other.numCmdeSap)
		return false;
	return true;
}

public Long getNumCmdeSap() {
	return numCmdeSap;
}

public void setNumCmdeSap(Long numCmdeSap) {
	this.numCmdeSap = numCmdeSap;
}


}
