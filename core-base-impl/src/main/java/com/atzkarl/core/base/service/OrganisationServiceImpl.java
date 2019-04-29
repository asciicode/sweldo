package com.atzkarl.core.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atzkarl.core.base.dto.OrganisationDTO;
import com.atzkarl.core.base.dto.entity.converter.OrganisationDTOEntityConverter;
import com.atzkarl.core.base.entity.Organisation;
import com.atzkarl.core.base.repository.OrganisationRepository;
import com.atzkarl.framework.base.event.FoundOneEvent;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    @Autowired
    private OrganisationDTOEntityConverter converter;
    @Autowired
    private OrganisationRepository repository;

    private Organisation getEntity(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public FoundOneEvent<OrganisationDTO> findOne(Long id) {
        FoundOneEvent<OrganisationDTO> foundOneEvent;
        Organisation entity = getEntity(id);
        if (entity != null) {
            foundOneEvent = new FoundOneEvent<>(id, converter.fromEntity(entity));
        } else {
            foundOneEvent = new FoundOneEvent<>(id, false);
        }
        return foundOneEvent;
    }

}
