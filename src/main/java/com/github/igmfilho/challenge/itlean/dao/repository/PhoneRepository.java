package com.github.igmfilho.challenge.itlean.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.igmfilho.challenge.itlean.dao.model.PhoneEntity;

/**
 * Specifies methods used to obtain and modify phone related information
 * which is stored in the database.
 * 
 * @author Ivan Filho
 */
public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {

}
