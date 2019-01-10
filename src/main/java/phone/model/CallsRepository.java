package phone.model;

import phone.sql.SqlQuery;

import java.util.ArrayList;

public class CallsRepository {
    private ArrayList typeOfTopic = new ArrayList<String>();
    public ArrayList typeOfSubcategoryList = new ArrayList<String>();
    private SqlQuery sqlQuery=new SqlQuery();


    public ArrayList getTypeOfTopic() {
        typeOfTopic.clear();
        setTypeOfTopic();
        return typeOfTopic;
    }

    private void setTypeOfTopic() {
        sqlQuery.addTopicListFromDatabase(typeOfTopic);
    }


    public ArrayList getTypeOfSubcategoryList(String topic) {
        typeOfSubcategoryList.clear();
        setTypeOfSubcategoryList(topic);
        return typeOfSubcategoryList;
    }

    public void setTypeOfSubcategoryList(String topic) {
        sqlQuery.addSubcategoryListFromDatabase(typeOfSubcategoryList, topic);
    }
}