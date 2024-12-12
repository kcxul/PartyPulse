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
    private PartySpaceRepo partySpaceRepository;  // Renamed to follow naming conventions

    public List<PartySpace> getAllPartySpaces() {
        return partySpaceRepository.findAll();
    }

    public PartySpace findPartySpaceByID(int partySpaceId) {  // Renamed parameter
        Optional<PartySpace> partySpace = partySpaceRepository.findById(partySpaceId);
        return partySpace.orElse(null);
    }

    public void addNewPartySpace(PartySpace partySpace) {
        partySpaceRepository.save(partySpace);
    }

    public void editPartySpace(int partySpaceId, PartySpace partySpace) {  // Renamed parameter
        PartySpace existing = findPartySpaceByID(partySpaceId);
        if (existing != null) {
            // Corrected to use the 'partySpace' parameter, not the 'PartySpace' class
            existing.setPartySpaceName(partySpace.getPartySpaceName());
            existing.setChatId(partySpace.getChatId());
            existing.setPartySpaceDes(partySpace.getPartySpaceDes());
            partySpaceRepository.save(existing);
        }
    }

    public void deletePartySpaceByID(int partySpaceId) {  // Renamed parameter
        partySpaceRepository.deleteById(partySpaceId);
    }
}
