package org.example.wshop.bean;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
import org.example.wshop.model.UserGroup;
import org.example.wshop.service.UserGroupService;

import java.io.Serializable;
import java.util.List;

@Model
public class UserGroupListBean implements Serializable {

    @EJB
    private UserGroupService userGroupService;

    private List<UserGroup> userGroups;

    @PostConstruct
    public void init() {
        userGroups = userGroupService.findAllUserGroups();
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
