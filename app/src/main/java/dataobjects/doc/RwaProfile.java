package dataobjects.doc;

import java.util.ArrayList;

import databrokers.BrokerMessage;
import dataobjects.rwa.Contact;
import dataobjects.rwa.Message;

/**
 * Created by Administrator on 12/15/14.
 */
public class RwaProfile {

    private String strRwaId;

    private String strAddress;
    private ArrayList<Contact> lstContact;
    private ArrayList<Message> lstMessage;


    public RwaProfile(String strRwaId) {
        this.strRwaId = strRwaId;
    }

    public ArrayList<Message> getMessages() {

        lstMessage= BrokerMessage.getRwaMessages(strRwaId);
        return lstMessage;
    }
}
