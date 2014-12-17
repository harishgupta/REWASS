package dataobjects.rwa;

import java.util.Date;
/**
 * Created by Administrator on 12/16/14.
 */
public class Message {

    private String strTitle;
    private Date dtCreated;
    private String strCreatedBy;
    private String strBody;
    private MessageType enmMsgType;

    public Message(String strTitle, String strBody, String strCreatedBy,
                   Date dtCreated, MessageType enmMsgType) {
        this.strTitle = strTitle;
        this.dtCreated = dtCreated;
        this.strCreatedBy = strCreatedBy;
        this.strBody = strBody;
        this.enmMsgType = enmMsgType;
    }
}
