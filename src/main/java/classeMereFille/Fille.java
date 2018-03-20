package classeMereFille;

public class Fille extends Mere {
	public Fille(){
		
	}

		public void presentation() {
			//super.presentation();
			System.out.println("Je suis la classe fille");
		}
		
		@Override
		 public void presentationOverrided() {
			System.out.println("Je suis la classe fille Overrided");
		}

		static public void presentationStatic() {
			System.out.println("Je suis la classe fille Static");
		}
}
