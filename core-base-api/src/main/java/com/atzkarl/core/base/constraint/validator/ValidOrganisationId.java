package com.atzkarl.core.base.constraint.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.atzkarl.core.base.constraint.ValidOrganisationIdValidator;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = ValidOrganisationIdValidator.class)
public @interface ValidOrganisationId {
    String message() default "Organisation id not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
