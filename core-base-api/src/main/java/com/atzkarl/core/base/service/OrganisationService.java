package com.atzkarl.core.base.service;

import com.atzkarl.core.base.dto.OrganisationDTO;
import com.atzkarl.framework.base.event.FoundOneEvent;

public interface OrganisationService {
    FoundOneEvent<OrganisationDTO> findOne(Long id);
}
