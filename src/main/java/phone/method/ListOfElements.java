package phone.method;

import java.util.ArrayList;

public class ListOfElements {
    public ArrayList typeOfTopic = new ArrayList<String>();
    public ArrayList typeOfSubcategoryList = new ArrayList<String>();
    public ArrayList listWhoCalls = new ArrayList<String>();

    private ArrayList addTypeOfTopic() {
        typeOfTopic.add("");
        typeOfTopic.add("Trmat1");
        typeOfTopic.add("Temat2");
        return typeOfTopic;
    }

    public ArrayList getTypeOfTopic() {
        addTypeOfTopic();
        return typeOfTopic;
    }

    private ArrayList addTypeOfSubcategoryList() {
        typeOfSubcategoryList.add("");
        typeOfSubcategoryList.add("Podkategoria1");
        typeOfSubcategoryList.add("Podkategoria2");
        typeOfSubcategoryList.add("Podkategoria3");
        return typeOfSubcategoryList;
    }

    public ArrayList getTypeOfSubcategoryList() {
        addTypeOfSubcategoryList();
        return typeOfSubcategoryList;
    }

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