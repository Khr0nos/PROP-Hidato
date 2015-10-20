import java.lang.String;
import java.util.ArrayList;

public class CtrlPersistencia{
    //PRIVATE ATTRIBUTES
    private class control {

        //PRIVATE ATTRIBUTES
        private boolean error;
        private String msg;

        //PUBLIC METHODS
        //Public constructor
        public control() {
            error = false;
            msg = "";
        }
        //Returns true if the last store/load operation was succesfull, false otherwise
        public boolean success() {
            return not error;
        }
        //Returns a string explaining the last error ocurred
        public String getMsg() {
            return msg;
        }
        //Sets the error variable
        public void setError(){
            error = not error;
        }
        //Sets the error message
        public void setMsg(String message) {
            msg = message;
        }
    }
    private control ctrl;
    //PUBLIC METHODS

    //Public constructor
    public CtrlPersistencia() {
        ctrl = new control();
    }
    //Returns an array of arrays of strings (table) in the file located in path
    public ArrayList<ArrayList<String>> loadTable(String path);
    //Stores an array of arrays of strings (table) in the file located in path
    public void storeTable(ArrayList<ArrayList<String>> table, String path);
}