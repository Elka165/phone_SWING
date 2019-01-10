package phone.method;

import java.util.ArrayList;

public class ListOfElements {

    public ArrayList listWhoCalls = new ArrayList<String>();

    private ArrayList addListWhoCalls() {
        listWhoCalls.add("");
        listWhoCalls.add("poszkodowany");
        listWhoCalls.add("ubezpieczony");
        listWhoCalls.add("sprawca");
        listWhoCalls.add("zgłaszający");
        return listWhoCalls;
    }

    public ArrayList getListWhoCalls() {
        addListWhoCalls();
        return listWhoCalls;
    }

}