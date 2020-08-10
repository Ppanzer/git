/**
 * 
 */
package com.example.excalhandler.util;

/**
 * @author kanaw
 *
 */
public class MailUtil {

	public static boolean isValidMailAddress(String mail) {

		return mail.matches("^[a-z0-9_\\-]+(\\.[_a-z0-9\\-]+)*@([_a-z0-9\\-]+\\.)+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)$");
	}
}
