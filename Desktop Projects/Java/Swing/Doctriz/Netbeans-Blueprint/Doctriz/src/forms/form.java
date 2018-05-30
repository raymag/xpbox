package forms;

/**
 *
 * @author Mag
 */
public class form {
    int id;
    private String action = "";
    private String method = "POST";
    String[] elements = {}; 
    
    public void setAction(String act){
        action = act;
    }
    
    public String getAction(){
        return action;
    }
    
    public void setMethod(String meth){
        method = meth;
    }
    
    public String getMethod(){
        return method;
    }

    public form(int numForms) {
        id = numForms;
    }
   }
