package com.dmslob.spring.core.di;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DIConfig.class)
//or @ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class MovieFinderTest {

    private ApplicationContext context;

    @Before
    public void init() {
        System.out.println("1");
        context = new ClassPathXmlApplicationContext("spring-beans.xml");
    }

    @Test
    public void isMovieFinderExistTest() {
        SimpleMovieFinderFactory finderFactory = (SimpleMovieFinderFactory) context.getBean("simpleMovieFinderFactory");
        MovieFinder movieFinder = finderFactory.getInstance("colon");

        assertNotNull(movieFinder);
    }

    @Test
    public void isFindAllTest() {
        SimpleMovieFinderFactory finderFactory = (SimpleMovieFinderFactory) context.getBean("simpleMovieFinderFactory");
        MovieFinder movieFinder = finderFactory.getInstance("colon");

        assertNotNull(movieFinder.findAll());
    }
}
