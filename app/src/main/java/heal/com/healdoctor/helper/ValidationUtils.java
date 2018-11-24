package heal.com.healdoctor.helper;

import android.text.TextUtils;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,15}$";
	private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
	
	private static final String MOBILE_PATTERN = "^[+][0-9]{10,13}$";
	
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[.][a-zA-Z]{2,4}$";
	  
	
	/**
	 * ^                    # Start of the line
	 * [a-z0-9_-]	     	# Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
	 * {3,15}  				# Length at least 3 characters and maximum length of 15 
	 * $                    # End of the line
	 * @param username
	 * @return boolean 
	 * @author Abhi
	 */	
	public static boolean validateUserName(final String username)
	{
		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();
	}
		
	/**
	 * (						# Start of group
  			(?=.*\d)			#   must contains one digit from 0-9
  			(?=.*[a-z])			#   must contains one lowercase characters
  			(?=.*[A-Z])			#   must contains one uppercase characters
  			(?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
              .					#   match anything with previous condition checking
                {6,20}			#   length at least 6 characters and maximum of 20	
		)						# End of group
		
	 * @param password
	 * @param confirm password
	 * @return boolean 
	 * @author Abhi
	 */
	public static boolean validatePassword(final String password){
		
		Log.v("validatePassword : ", "password : " + password);
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		
		// boolean temp = matcher.matches();
		// Log.v("validatePassword : ", "Result : "+temp);
		
		return matcher.matches();
	}
	
	/**
	 * ^\+[0-9]{10,13}$ 		# upto length 13 and including achar + infront.
	 * @param mobile number
	 * @return boolean 
	 * @author Abhi
	 */
	public static boolean validateMobNumebr(final String mobNumber){
		
		Log.v("validateMobNumebr : ", "mobNumber : " + mobNumber);
		Pattern pattern = Pattern.compile(MOBILE_PATTERN);
		Matcher matcher = pattern.matcher(mobNumber);
		
		// boolean temp = matcher.matches();
		// Log.v("validatePassword : ", "Result : "+temp);
		
		return matcher.matches();
	}
	
	public final static boolean validateEmailAddress(CharSequence target) {
		if (TextUtils.isEmpty(target)) {
			return false;
		} else {
			return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
		}
	}
	
	/**
	 * ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$
	 * @param email address
	 * @return boolean
	 * @author Swapnil Sonar
	 */
	public static boolean validateEmailID(final String emailAddress){
		
		Log.v("validateEmailAddress : ", "emailAddress : " + emailAddress);
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailAddress);
		
		// boolean temp = matcher.matches();
		// Log.v("validatePassword : ", "Result : "+temp);
		
		return matcher.matches();
	}
	
}
