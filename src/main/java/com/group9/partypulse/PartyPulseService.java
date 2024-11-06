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
            existing.setUserName(PartyPulse.getUserName());
            existing.setProfile_info(PartyPulse.getProfile_info());
            PartyPulseRepository.save(user);
        }
    }
    public void deleteUserByID(int user_id) {
        PartyPulseRepository.deleteAnimalById(user_id);
    }
}
