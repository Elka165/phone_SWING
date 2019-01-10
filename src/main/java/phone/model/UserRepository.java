package phone.model;

public class UserRepository {
    public Boolean findUser(Integer count){
        Boolean isUser=false;
        if(count>0){
            isUser=true;
        }
        return isUser;
    }

    public Boolean isAllFieldInUser(User user){
        Boolean isUserField=false;
        if(!user.getLogin().isEmpty() && !user.getSurname().isEmpty() && !user.getName().isEmpty() && !user.getSurnameAndName().isEmpty()){
            isUserField=true;
        }
        return isUserField;
    }
}