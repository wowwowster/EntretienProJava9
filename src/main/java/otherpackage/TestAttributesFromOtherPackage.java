package otherpackage;

import test.TheClassWithAttributes;

public class TestAttributesFromOtherPackage {

	ClasseFilleFromOtherPackage classeFille  = new ClasseFilleFromOtherPackage ();
	public void go() {
	//	classeFille.defaultAccessAttribute = "";
	//	classeFille.protectedAttribute = "";
		classeFille.publicAttribute = "";
	}
}