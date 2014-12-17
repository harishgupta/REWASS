package dataobjects.rwa;

/**
 * Created by Administrator on 12/16/14.
 */
public class Contact {

    private ContactType enmContactType;
    private String strTitle;
    private String strDetail;
    private String strNumber;

    public Contact(ContactType enmContactType, String strTitle, String strDetail, String strNumber) {
        this.enmContactType = enmContactType;
        this.strTitle = strTitle;
        this.strDetail = strDetail;
        this.strNumber = strNumber;
    }



}
