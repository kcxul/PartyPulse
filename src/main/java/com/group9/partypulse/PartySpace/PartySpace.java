package com.group9.partypulse.PartySpace;
import jakarta.persistence.*;

@Entity
@Table()
public class PartySpace {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PartySpace_id;

    @Column
    private String PartySpaceName;

    @Id
    @GeneratedValue
    private int chatid;

    @Column
    private String partySpace_des;



    public PartySpace(int PartySpace_id, String PartySpaceName, int chatid, String partySpace_des) {
        this.PartySpace_id = PartySpace_id;
        this.PartySpaceName = PartySpaceName;
        this.chatid = chatid
        this.partySpace_des = partySpace_des;
    }

    public PartySpace(String PartySpaceName, int chatid, String partySpace_des) {
        this.PartySpaceName = PartySpaceName;
        this.chatid = chatid
        this.partySpace_des = partySpace_des;
    }
    public PartySpace() {
    }

    public int getPartySpace_id() {
        return PartySpace_id;
    }

    public void setPartySpace_id(int PartySpace_id) {
        this.PartySpace_id = PartySpace_id;
    }

    public String getPartySpaceName() {
        return PartySpaceName;
    }

    public void setPartySpaceName(String PartySpaceName) {
        this.PartySpaceName = PartySpaceName;
    }



    public int getchatid() {
        return chatid;
    }

    public void setchatid(int chatid) {
        this.chatid = chatid;
    }

    public String getPartySpace_des() {
        return partySpace_des;
    }

    public void setPartySpace_des(String partySpace_des) {
        this.partySpace_des = partySpace_des;
    }

}

