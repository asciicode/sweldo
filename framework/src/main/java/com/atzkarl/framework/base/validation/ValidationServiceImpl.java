package com.atzkarl.framework.base.validation;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidatorFactory;

import com.atzkarl.framework.base.dto.BaseDTO;

public class ValidationServiceImpl implements ValidationService {

    private ValidatorFactory validatorFactory;

    @Override
    public <D extends BaseDTO> void validate(D dto) {
        Set<ConstraintViolation<D>> constraintViolations = validatorFactory
                .getValidator().validate(dto);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(
                    "The following constraint violations occurred: "
                            + constraintViolations,
                    new HashSet<ConstraintViolation<?>>(constraintViolations));
        }
    }

    public void setValidatorFactory(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }
}
