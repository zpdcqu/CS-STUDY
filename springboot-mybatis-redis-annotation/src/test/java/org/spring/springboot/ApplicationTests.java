package org.spring.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bysocket on 05/06/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {



    @Test
    public void testRedis() {

    }

    @Test
    public void testRedisCache() {


    }



    private City getShanghai(){
        return new City(1L, 10L, "上海", "人称魔都的地方");
    }

    private City getBeijing(){
        return new City(2L, 20L, "北京", "中国帝都");
    }
}
