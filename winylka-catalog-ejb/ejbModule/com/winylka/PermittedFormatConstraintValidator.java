package com.winylka;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PermittedFormatConstraintValidator implements ConstraintValidator<PermittedFormats, String> {
	
	private static String[] permittedFormats = {"LP", "CD", "DVD", "BD", "7''", "12''", 
			"Cassette", "VHS", "8-track", "Various"	};

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Arrays.asList(permittedFormats).contains(value);
	}


}
