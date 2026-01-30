package gov.tn.defense.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.tn.defense.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	
	AppUser findByUsername(String username);

}
