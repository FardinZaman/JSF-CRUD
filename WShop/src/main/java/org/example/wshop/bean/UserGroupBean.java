package org.example.wshop.bean;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import org.example.wshop.model.GroupType;
import org.example.wshop.model.UserGroup;
import org.example.wshop.service.UserGroupService;
import org.omnifaces.cdi.ViewScoped;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserGroupBean implements Serializable {

    @EJB
    private UserGroupService userGroupService;

    private UserGroup userGroup;

    private int costCounter = 1;

    @PostConstruct
    public void init() {
        this.userGroup = new UserGroup();
    }

    public List<UserGroup> getChildren(UserGroup parent) {
        return userGroupService.findChildren(parent);
    }

    public void dfs(UserGroup userGroup) {
        if(userGroup == null) {
            return;
        }

        userGroup.setEntryCost(costCounter++);

        List<UserGroup> children = getChildren(userGroup);

        for(UserGroup child : children) {
            dfs(child);
        }

        userGroup.setExitCost(costCounter++);
        userGroupService.update(userGroup);
    }

    public void calculateAndSetCosts() {
        UserGroup startNode = userGroupService.findChair();
        dfs(startNode);
    }

    public String addUserGroup() {
        userGroupService.add(this.userGroup);
        calculateAndSetCosts();
        return "user-group-list?faces-redirect=true";
    }

    public GroupType[] getGroupTypes() {
        return GroupType.values();
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
