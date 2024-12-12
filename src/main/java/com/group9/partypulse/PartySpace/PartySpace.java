package com.group9.partypulse.PartySpace;

import jakarta.persistence.*;

@Entity
@Table()
public class PartySpace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PartySpace_id;

    @Column(nullable = false)
    private String PartySpaceName;

    @Column(nullable = false)
    private int chatId;

    @Column(nullable = false)
    private String partySpace_des;

    // Constructors
    public PartySpace(int PartySpace_id, String PartySpaceName, int chatId, String partySpace_des) {
        this.PartySpace_id = PartySpace_id;
        this.PartySpaceName = PartySpaceName;
        this.chatId = chatId;
        this.partySpace_des = partySpace_des;
    }

    public PartySpace(String PartySpaceName, int chatId, String partySpace_des) {
        this.PartySpaceName = PartySpaceName;
        this.chatId = chatId;
        this.partySpace_des = partySpace_des;
    }

    public PartySpace() {
    }

    // Getters and setters
    public int getPartySpaceId() {
        return PartySpace_id;  // Changed method name to camelCase
    }

    public void setPartySpaceId(int PartySpace_id) {
        this.PartySpace_id = PartySpace_id;
    }

    public String getPartySpaceName() {
        return PartySpaceName;
    }

    public void setPartySpaceName(String PartySpaceName) {
        this.PartySpaceName = PartySpaceName;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getPartySpaceDes() {
        return partySpace_des;
    }

    public void setPartySpaceDes(String partySpaceDes) {
        this.partySpace_des = partySpaceDes;
    }
}
