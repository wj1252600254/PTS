package service;



import pojo.User;

import java.util.HashMap;

public class FindUser {
    private HashMap<String, User> stringUserHashMap;

    public FindUser() {
        this.stringUserHashMap = new HashMap<>();
    }

    /**
     * 添加用户
     *
     * @param users
     */
    public void add(User... users) {
        for (User user : users) {
            stringUserHashMap.put(user.getPhoneNumber(), user);
        }
    }

    /**
     * 删除用户
     *
     * @param pn
     */
    public void remove(String pn) {
        stringUserHashMap.remove(pn);
    }


    public User find(String number) {
        return stringUserHashMap.get(number);
    }

    public HashMap<String, User> getStringUserHashMap() {
        return stringUserHashMap;
    }

    public void setStringUserHashMap(HashMap<String, User> stringUserHashMap) {
        this.stringUserHashMap = stringUserHashMap;
    }
}
