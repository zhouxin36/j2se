package com.j2se.drools;

import com.j2se.drools.bean2.Fire;
import com.j2se.drools.bean2.Room;
import com.j2se.drools.bean2.Sprinkler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsApplicationTests2 {
    private final static Logger logger = LoggerFactory.getLogger(DroolsApplicationTests2.class);

    private final static KieServices kieServices = KieServices.Factory.get();
    private final static KieContainer kContainer = kieServices.getKieClasspathContainer();
    private final static KieSession kSession = kContainer.newKieSession();

    @Test
    public void test1() {
        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};
        Map<String, Room> name2room = new HashMap<>();
        for (String name : names) {
            Room room = new Room(name);
            name2room.put(name, room);
            kSession.insert(room);
            Sprinkler sprinkler = new Sprinkler(room);
            kSession.insert(sprinkler);
        }

        kSession.fireAllRules();

        if(true){
            Fire kitchenFire = new Fire( name2room.get( "kitchen" ) );
            Fire officeFire = new Fire( name2room.get( "office" ) );

            FactHandle kitchenFireHandle = kSession.insert( kitchenFire );
            FactHandle officeFireHandle = kSession.insert( officeFire );

            kSession.fireAllRules();

            kSession.delete( kitchenFireHandle );
            kSession.delete( officeFireHandle );

            kSession.fireAllRules();
        }

    }

}
