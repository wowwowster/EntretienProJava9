package main.java.tests.patternmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator {

	 

	 
		private Pattern pattern;
		private Pattern patternCL;
		private Matcher matcher;
	 
		private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		private static final String EMAIL_PATTERN_CL = 
				"^[A-Za-z0-9.\\-_]{3,}@[A-Za-z0-9]{3,}(\\.[A-Za-z]{2,})$";
		
				/*	private static final String EMAIL_PATTERN_CL = "^([a-zA-Z0-9_-]+\\.)*[a-zA-Z0-9_-]+@([a-zA-Z0-9-]{2,}\\.)+[a-zA-Z]{2,10}$";*/

		
		public EmailValidator() {
			pattern = Pattern.compile(EMAIL_PATTERN);
			patternCL = Pattern.compile(EMAIL_PATTERN_CL);
			
		}
	 
		/**
		 * Validate hex with regular expression
		 * 
		 * @param hex
		 *            hex for validation
		 * @return true valid hex, false invalid hex
		 */
		public boolean validate(final String hex) {
	 
			matcher = pattern.matcher(hex);
			return matcher.matches();
	 
		}
		
		
		public boolean validateCL(final String hex) {
			 
			matcher = patternCL.matcher(hex);
			return matcher.matches();
	 
		}
	}
