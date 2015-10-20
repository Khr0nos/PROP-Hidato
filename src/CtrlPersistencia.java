import java.lang.String;
import java.util.ArrayList;

public class CtrlPersistencia{
    //PRIVATE ATTRIBUTES
    private class control {

        //PRIVATE ATTRIBUTES
        private boolean error;
        private String msg;

        //PUBLIC METHODS

        //Returns true if the last store/load operation was succesfull, false otherwise
        public boolean success();
        //Returns a string explaining the last error ocurred
        public String getMsg();
    }
    //PUBLIC METHODS

    //Public constructor
    public CtrlPersistencia();

    //Returns an array of arrays of strings (table) in the file located in path
    public ArrayList<ArrayList<String>> loadTable(String path);

    //Stores an array of arrays of strings (table) in the file located in path
    public void storeTable(ArrayList<ArrayList<String>> table, String path);
}