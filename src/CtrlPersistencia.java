import java.lang.String;
import java.util.ArrayList;

public class CtrlPersistencia{
    //Private attributes
    private class control {
        private boolean error;
        private String msg;
        public boolean success();
        public String getMsg();
    }
    //Public methods
    public CtrlPersistencia();
    public ArrayList<ArrayList<String>> loadTabla();
    public void storeTabla();
}