package com.atzkarl.core.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atzkarl.core.base.entity.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

}
