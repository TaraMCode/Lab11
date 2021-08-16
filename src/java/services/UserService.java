package services;

import dataaccess.UserDB;
import models.User;

public class UserService {
    public User getByEmail(String email) {
         UserDB userdb = new UserDB();
         User user = userdb.getUserByEmail(email);
         return user;
    }
}
