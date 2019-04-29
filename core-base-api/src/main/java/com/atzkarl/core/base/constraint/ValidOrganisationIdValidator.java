package com.atzkarl.core.base.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.atzkarl.core.base.constraint.validator.ValidOrganisationId;
import com.atzkarl.core.base.dto.OrganisationDTO;
import com.atzkarl.core.base.service.OrganisationService;
import com.atzkarl.framework.base.event.FoundOneEvent;

public class ValidOrganisationIdValidator implements ConstraintValidator<ValidOrganisationId, Long> {

    @Autowired
    private OrganisationService organisationService;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        FoundOneEvent<OrganisationDTO> foundOne = organisationService.findOne(value);
        return foundOne.isEntityFound();
    }

}
