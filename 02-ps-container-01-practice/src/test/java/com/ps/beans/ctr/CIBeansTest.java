package com.ps.beans.ctr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
public class CIBeansTest {
    private Logger logger = LoggerFactory.getLogger(CIBeansTest.class);

    @Test
    public void testConfig() {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-01.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-02.xml");

        logger.info(" --- All beans in context --- ");
        for(String beanName :  ctx.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
        }

        //TODO 3. Retrieve beans of types ComplexBean and make sure their dependencies were correctly set.
        ComplexBeanImpl bean0 = (ComplexBeanImpl) ctx.getBean("complexBean0");
        assertNotNull(bean0.getSimpleBean());

        ComplexBeanImpl bean1 = (ComplexBeanImpl) ctx.getBean("complexBean1");
        assertNotNull(bean1.getSimpleBean());
        assertTrue(bean1.isComplex());

        ComplexBean2Impl bean2 = (ComplexBean2Impl) ctx.getBean("complexBean2");
        assertNotNull(bean2.getSimpleBean1());
        assertNotNull(bean2.getSimpleBean2());
    }
}
