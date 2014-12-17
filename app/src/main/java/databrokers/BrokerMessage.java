package databrokers;

import dataobjects.rwa.Message;
import java.util.ArrayList;
/**
 * Created by Administrator on 12/16/14.
 */
public class BrokerMessage {

    private String strRwaID;
    private String strMessages;


    public BrokerMessage(String RwaID, String Messages) {
        this.strRwaID = RwaID;
        strMessages=Messages;
    }

    public static ArrayList<Message> getRwaMessages(String RwaID) {

        ArrayList<Message> lstMessage = new ArrayList<Message>();


        return lstMessage;
    }


}
