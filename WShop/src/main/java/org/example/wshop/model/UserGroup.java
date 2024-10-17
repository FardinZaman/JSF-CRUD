package org.example.wshop.model;

import jakarta.persistence.*;
import org.example.wshop.ConvertibleEntity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class UserGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private GroupType groupType;

    private Integer entryCost;

    private Integer exitCost;

    @ManyToOne
    private UserGroup parent;

    public UserGroup() {
    }

    public UserGroup(String name, GroupType groupType, UserGroup parent) {
        this.name = name;
        this.groupType = groupType;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroup userGroup = (UserGroup) o;
        return Objects.equals(id, userGroup.id) && Objects.equals(name, userGroup.name) && groupType == userGroup.groupType && Objects.equals(entryCost, userGroup.entryCost) && Objects.equals(exitCost, userGroup.exitCost) && Objects.equals(parent, userGroup.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, groupType, entryCost, exitCost, parent);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public Integer getEntryCost() {
        return entryCost;
    }

    public void setEntryCost(Integer entryCost) {
        this.entryCost = entryCost;
    }

    public Integer getExitCost() {
        return exitCost;
    }

    public void setExitCost(Integer exitCost) {
        this.exitCost = exitCost;
    }

    public UserGroup getParent() {
        return parent;
    }

    public void setParent(UserGroup parent) {
        this.parent = parent;
    }
}
