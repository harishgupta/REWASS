package databrokers;

import java.util.ArrayList;

import dataobjects.doc.RwaProfile;
import dataobjects.rwa.Contact;
import dataobjects.rwa.Message;

/**
 * Created by Administrator on 12/16/14.
 */
public class BrokerRwaProfile {

    private String strRwaID;
    private RwaProfile objRwaProfile;

    public BrokerRwaProfile(String RwaID) {
        this.strRwaID = RwaID;
    }

    public static ArrayList<Message> getRwaMessages(String RwaID) {

        ArrayList<Message> lstMessage = new ArrayList<Message>();

        return lstMessage;
    }

    public static ArrayList<Contact> getRwaContacts (String RwaID) {

        ArrayList<Contact> lstContact = new ArrayList<Contact>();

        return lstContact;
    }
}
