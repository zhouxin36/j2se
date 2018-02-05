package com.j2se.drools;

import com.j2se.drools.bean.Applicant;
import com.j2se.drools.bean.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsApplicationTests1 {
	private final static Logger logger = LoggerFactory.getLogger(DroolsApplicationTests1.class);

    private final static KieServices kieServices = KieServices.Factory.get();
    private final static KieContainer kContainer = kieServices.getKieClasspathContainer();

	@Test
	public void test1() {
		StatelessKieSession kSession = kContainer.newStatelessKieSession();
		Applicant applicant = new Applicant( "Mr John Smith", 16 );
		assertTrue( applicant.isValid() );
		logger.info("----->"+applicant);
		kSession.execute( applicant );
		assertFalse( applicant.isValid() );
        logger.info("----->"+applicant);
	}

	@Test
	public void test2(){
        StatelessKieSession kSession = kContainer.newStatelessKieSession();
        Applicant applicant = new Applicant( "Mr John Smith", 16 );
        Application application = new Application();
        assertTrue( application.isValid() );
        kSession.execute( Arrays.asList( new Object[] { application, applicant } ) );
        assertFalse( application.isValid() );
    }

    @Test
    public void test2_1(){
        StatelessKieSession kSession = kContainer.newStatelessKieSession();
        Applicant applicant = new Applicant( "Mr John Smith", 19 );
        Application application = new Application(new Date());
        assertTrue( application.isValid() );
        kSession.execute( Arrays.asList( new Object[] { application, applicant } ) );
        assertFalse( application.isValid() );
    }

}
