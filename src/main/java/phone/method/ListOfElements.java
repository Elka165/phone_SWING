package phone.method;

import java.util.ArrayList;

public class ListOfElements {
    public ArrayList typeOfDamageList = new ArrayList<String>();
    public ArrayList typeOfRecipientList = new ArrayList<String>();
    public ArrayList listOfCity = new ArrayList<String>();
    public ArrayList listOfPermissions= new ArrayList();

    private ArrayList addTypeOfDamage() {
        typeOfDamageList.add("");
        typeOfDamageList.add("EH");
        typeOfDamageList.add("MTU");
        return typeOfDamageList;
    }

    public ArrayList getTypeOfDamageList() {
        addTypeOfDamage();
        return typeOfDamageList;
    }

    private ArrayList addTypeOfRecipientList() {
        typeOfRecipientList.add("");
        typeOfRecipientList.add("Sąd");
        typeOfRecipientList.add("Komornik");
        typeOfRecipientList.add("UM");
        return typeOfRecipientList;
    }

    public ArrayList getTypeOfRecipientList() {
        addTypeOfRecipientList();
        return typeOfRecipientList;
    }

    private ArrayList addListOfCity() {
        listOfCity.add("");
        return listOfCity;
    }

    public ArrayList getListOfCity() {
        addListOfCity();
        return listOfCity;
    }

    private ArrayList addListOfPermissions() {
        listOfPermissions.add("");
        listOfPermissions.add("podstawowe");
        listOfPermissions.add("administracyjne");
        return listOfPermissions;
    }

    public ArrayList getListOfPermissions() {
        addListOfPermissions();
        return listOfPermissions;
    }
}