package com.group9.partypulse.PartySpace;
import com.group9.partypulse.PartySpace.PartySpace;
import com.group9.partypulse.PartySpace.PartySpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartySpaceService {

    @Autowired
    private PartySpaceRepo PartySpaceRepository;

    public List<PartySpace> getAllPartySpaces() {
        return PartySpaceRepository.findAll();
    }

    public PartySpace findPartySpaceByID(int PartySpace_id) {
        Optional<PartySpace> partySpace = PartySpaceRepository.findById(PartySpace_id);
        return PartySpace.orElse(null);
    }

    public void addNewPartySpace(PartySpace partySpace) {
        PartySpaceRepository.save(PartySpace);
    }

    public void editPartySpace(int PartySpace_id, PartySpace partySpace) {
        PartySpace existing = findPartySpaceByID(PartySpace_id);
        if (existing != null) {
            existing.setPartySpaceName(PartySpace.getPartySpaceName());
            existing.setchatid(PartySpace.getchatid());
            existing.setPartySpace_des(PartySpace.getPartySpace_des());
            PartySpaceRepository.save(existing);
        }
    }

    public void deletePartySpaceByID(int PartySpace_id) {
        PartySpaceRepository.deleteById(PartySpace_id);
    }
}