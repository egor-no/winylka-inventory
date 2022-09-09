package com.winylka;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Documented
@Constraint(validatedBy = {PermittedFormatConstraintValidator.class})
@Retention(RUNTIME)
@Target({ TYPE, FIELD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
public @interface PermittedFormats {
	
	String message() default "{invalid.format}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}

