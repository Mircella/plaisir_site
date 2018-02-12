package app.entities;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private static UserModel userModel = new UserModel();
    private List<User>userList;
    private UserModel(){
        userList = new ArrayList<>();
    }

    public static UserModel getInstance(){
        return userModel;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

}
