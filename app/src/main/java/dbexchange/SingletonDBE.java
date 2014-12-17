package dbexchange;

import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.util.Log;

import java.io.IOException;

/**
 * Created by Administrator on 12/17/14.
 */
public class SingletonDBE {

    private static SingletonDBE ourInstance = new SingletonDBE();
    private String TAG="SingletonDBE";


    public static SingletonDBE getInstance() {
        return ourInstance;
    }

    private SingletonDBE() {

    }
}
