package org.personal.mason.demo.dto;

import org.personal.mason.demo.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: masonmei
 * Date: 11/3/12
 * Time: 1:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserListDto {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }
}
