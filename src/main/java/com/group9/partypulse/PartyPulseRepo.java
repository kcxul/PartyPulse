package com.group9.partypulse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyPulseRepo extends JpaRepository<PartyPulse, Integer>{

    void deleteAnimalById(int id);

    @Query(value = "SELECT * FROM user WHERE id = :id",nativeQuery = true)
    Optional<PartyPulse> findUserByID(int user_id);

    @Query(value = "SELECT * FROM user WHERE id = :id",nativeQuery = true)
	
    Optional<PartyPulse> findPartyPulseByID(int party_id);
}