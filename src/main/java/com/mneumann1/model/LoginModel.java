/**
 * 
 */
package com.mneumann1.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MNEUMANN1
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {

	@NotNull
	@Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters!")
	private String username;
	
	@NotNull
	@Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters!")
	private String password;
	
	@Override
	public String toString() {
		return "LoginModel [username = " + username + ", password = " + password + "]";
	}
	
}
