package main.java.tests.patternmail;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;



public class EmailValidatorTest {
 
		 
		private EmailValidator emailValidator;
	 
		@Before 
		public void initData() {
			emailValidator = new EmailValidator();
		}
	 
		 
		public Object[][] ValidEmailProvider() {
			return new Object[][] { { new String[] { "creditlogement@yahoo.com",
				"creditlogement-100@yahoo.com", "creditlogement.100@yahoo.com",
				"creditlogement111@creditlogement.com", "creditlogement-100@creditlogement.net",
				"creditlogement.100@creditlogement.com.au", "creditlogement@1.com",
				"creditlogement@gmail.com.com", "creditlogement+100@gmail.com",
				"creditlogement-100@yahoo-test.com","cecile.detraversay@ca-aquitaine.fr" } } };
		}
	 
	 
		public Object[][] InvalidEmailProvider() {
			return new Object[][] { { new String[] { "creditlogement", "creditlogement@.com.my",
				"creditlogement123@gmail.a", "creditlogement123@.com", "creditlogement123@.com.com",
				".creditlogement@creditlogement.com", "creditlogement()*@gmail.com", "creditlogement@%*.com",
				"creditlogement..2002@gmail.com", "creditlogement.@gmail.com",
				"creditlogement@creditlogement@gmail.com", "creditlogement@gmail.com.1a" } } };
		}
		
		@Test
		public void testValidEmail() {
			String[] Email = new String[] { "creditlogement@yahoo.com",
					"creditlogement-100@yahoo.com", "creditlogement.100@yahoo.com",
					"creditlogement111@creditlogement.com", "creditlogement-100@creditlogement.net",
					"creditlogement.100@creditlogement.com.au", "creditlogement@1.com",
					"creditlogement@gmail.com.com", "creditlogement+100@gmail.com",
					"creditlogement-100@yahoo-test.com","cecile.detraversay@ca-aquitaine.fr" } ;
			for (String temp : Email) {
				boolean valid = emailValidator.validate(temp);
				System.out.println("Email is valid A : " + temp + " , " + valid);
				Assert.assertEquals(valid, true);
			}
	 
		}
	 
		/*	@Test
		public void testInValidEmail() {
			String[] Email = new String[] { "creditlogement", "creditlogement@.com.my",
					"creditlogement123@gmail.a", "creditlogement123@.com", "creditlogement123@.com.com",
					".creditlogement@creditlogement.com", "creditlogement()*@gmail.com", "creditlogement@%*.com",
					"creditlogement..2002@gmail.com", "creditlogement.@gmail.com",
					"creditlogement@creditlogement@gmail.com", "creditlogement@gmail.com.1a" } ;
	 
			for (String temp : Email) {
				boolean valid = emailValidator.validate(temp);
				System.out.println("Email is valid B : " + temp + " , " + valid);
				Assert.assertEquals(valid, false);
			}
		}*/
		
		@Test
		public void testValidEmailCL() {
			String[] Email = new String[] { "cecile.detraversay@ca-aquitaine.fr","creditlogement@yahoo.com",
					"creditlogement-100@yahoo.com", "creditlogement.100@yahoo.com",
					"creditlogement111@creditlogement.com", "creditlogement-100@creditlogement.net",
					"creditlogement.100@creditlogement.com.au", "creditlogement@1.com",
					"creditlogement@gmail.com.com", "creditlogement+100@gmail.com",
					"creditlogement-100@yahoo-test.com" } ;
			 
			for (String temp : Email) {
				boolean valid = emailValidator.validateCL(temp);
				System.out.println("Email is valid CL A : " + temp + " , " + valid);
				Assert.assertEquals(valid, true);
			}
	 
		}
	 
	/*	@Test
		public void testInValidEmailCL( ) {
			String[] Email = new String[] { "creditlogement", "creditlogement@.com.my",
					"creditlogement123@gmail.a", "creditlogement123@.com", "creditlogement123@.com.com",
					".creditlogement@creditlogement.com", "creditlogement()*@gmail.com", "creditlogement@%*.com",
					"creditlogement..2002@gmail.com", "creditlogement.@gmail.com",
					"creditlogement@creditlogement@gmail.com", "creditlogement@gmail.com.1a"
					,"Carl.LAURIER@cea.fr", "anne-cecile.fabret@cea.fr", "c.laurier-prestataire@creditlogement.fr"
					, "Cindy.desseigne@ca-franchecomte.fr", "Cindy.desseigne@cda-cda-franchecomte.fr", "Cindy.desseigne@cddda-franchecomte.fr"
					, "Cindy.desseigne@ca2002franchecomte.fr"} ;
			for (String temp : Email) {
				boolean valid = emailValidator.validateCL(temp);
				System.out.println("Email is valid CL B: " + temp + " , " + valid);
				//Assert.assertEquals(valid, false);
			}
		}*/
	}
