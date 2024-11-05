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
        return PartyPulseRepo.findAll();
    }

    public PartyPulse findUserByID(int user_id) {
        Optional<PartyPulse> user = PartyPulseRepository.findUserByID(user_id);
        return user.orElse(null);
    }

    public void addNewUser(PartyPulse user) {
        PartyPulseRepo.save(user);
    }
}
