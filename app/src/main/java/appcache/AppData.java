package appcache;

import com.couchbase.lite.Database;

/**
 * Created by Administrator on 12/17/14.
 */
public class AppData {
    private static AppData ourInstance = new AppData();
    private Database cblMainDB;
    public static AppData getInstance() {
        return ourInstance;
    }

    private AppData() {
    }

    /*Couchbase lite Main Database object */
    public Database getCblMainDB() {    return cblMainDB;  }
    public void setCblMainDB(Database CblMainDB) { this.cblMainDB = CblMainDB;  }
}
