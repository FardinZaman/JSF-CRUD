package org.example.wshop;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.*;
import org.example.wshop.model.Weapon;
import org.example.wshop.model.WeaponType;
import org.example.wshop.service.WeaponService;

import java.util.stream.Stream;

@Singleton
@Startup
public class AppDataInit {

    @EJB
    private WeaponService weaponService;

    Weapon[] weapons = new Weapon[] {
            new Weapon("AK-47", WeaponType.ASSAULT_RIFLE, "1SHOT160D"),
            new Weapon("AK-103", WeaponType.ASSAULT_RIFLE, "2SHOT160D"),
            new Weapon("SVD-Dragnouv", WeaponType.SNIPER_RIFLE, "3SHOT160D"),
    };

    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void init() {
        Stream.of(weapons).forEachOrdered(weaponService::add);
    }
}
