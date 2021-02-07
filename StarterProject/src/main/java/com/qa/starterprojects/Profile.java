package com.qa.starterprojects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Profile {
	
	@Size(min =2,max=50)
	private String forename;
	
	@Size(min =2,max=50)
	private String surname;
	
	@Pattern(regexp=("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$"))
	private String dateOfBirth;
	
	private String gender;
	
	@NotNull
	private String ethnicity;
	
	

}
