package org.example.wshop;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.*;
import org.example.wshop.model.GroupType;
import org.example.wshop.model.UserGroup;
import org.example.wshop.model.Weapon;
import org.example.wshop.model.WeaponType;
import org.example.wshop.service.UserGroupService;
import org.example.wshop.service.WeaponService;

import java.util.stream.Stream;

@Singleton
@Startup
public class AppDataInit {

    @EJB
    private WeaponService weaponService;

    @EJB
    private UserGroupService userGroupService;

    Weapon[] weapons = new Weapon[] {
            new Weapon("AK-47", WeaponType.ASSAULT_RIFLE, "1SHOT160D"),
            new Weapon("AK-103", WeaponType.ASSAULT_RIFLE, "2SHOT160D"),
            new Weapon("SVD-Dragnouv", WeaponType.SNIPER_RIFLE, "3SHOT160D"),
    };

    UserGroup[] userGroups = new UserGroup[] {
            new UserGroup("Chair", GroupType.CHAIRMAN, null )
    };

    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void init() {
        userGroups[0].setEntryCost(1);

        Stream.of(weapons).forEachOrdered(weaponService::add);
        Stream.of(userGroups).forEachOrdered(userGroupService::add);
    }
}
