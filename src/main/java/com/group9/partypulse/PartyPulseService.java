package com.group9.partypulse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyPulseService {

    @Autowired
    private PartyPulseRepo PartyPulseRepository;

    public List<PartyPulse> getAllUsers() {
        return PartyPulseRepository.findAll();
    }

    public PartyPulse findUserByID(int user_id) {
        Optional<PartyPulse> user = PartyPulseRepository.findUserByID(user_id);
        return user.orElse(null);
    }

    public void addNewUser(PartyPulse user) {
        PartyPulseRepository.save(user);
    }
    public void editUser(int user_id, PartyPulse user) {
        PartyPulse existing = findUserByID(user_id);
        if (existing != null) {
            existing.setUserName(user.getUserName());
            existing.setProfile_info(user.getProfile_info());
            PartyPulseRepository.save(existing);
        }
    }
    public void deleteUserByID(int user_id) {
        PartyPulseRepository.deleteAnimalById(user_id);
    }

	public void addNewPartySpace(PartyPulse partySpace) {
		PartyPulseRepository.save(partySpace);
	}

    public List<PartyPulse> getAllPartySpaces() {
        return PartyPulseRepository.findAll();
    }

    public PartyPulse findPartySpaceByID(int partyspace_id) {
        return PartyPulseRepository.findPartyPulseByID(partyspace_id).orElse(null);
    }

	    public void deletePartySpaceByID(int partyspace_id) {
        PartyPulseRepository.deleteById(partyspace_id);
    }

}
