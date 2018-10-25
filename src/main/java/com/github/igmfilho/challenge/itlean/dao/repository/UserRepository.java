package com.github.igmfilho.challenge.itlean.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.igmfilho.challenge.itlean.dao.model.UserEntity;

/**
 * Specifies methods used to obtain and modify user related information
 * which is stored in the database.
 * 
 * @author Ivan Filho
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	/**
     * Finds a user by using the email as a search criteria.
     * @param email
     * @return  The user whose email is an exact match with the given email.
     *          If no user is found, this method returns null.
     */
    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.email) = LOWER(:email)")	
	UserEntity findByEmail(String email);

}