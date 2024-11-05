package com.group9.partypulse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyPulseService {

    @Autowired
    private PartyPulseRepository PartyPulseRepository;

    public List<user> getAllUsers() {
        return PartyPulseRepository.findAll();
    }

    public user finduserByID(int user_id) {
        Optional<user> user = PartyPulseRepository.findUserByID(user_id);
        return user.orElse(null);
    }

    public void addNewUser(PartyPulse user) {
        PartyPulseRepository.save(user);
    }
}
