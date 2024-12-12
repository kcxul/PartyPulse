package com.group9.partypulse.PartySpace;
import com.group9.partypulse.PartySpace.PartySpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartySpaceRepo extends JpaRepository<PartySpace, Integer> {


}

