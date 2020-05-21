package com.halen.cache;


import com.halen.cache.bean.Employee;
import com.halen.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBoot01CacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate empRedisTemplate;

    /**
     * Redis五大数据类型
     * String(字符串)、list（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *stringRedisTemplate.opsForValue()
     * stringRedisTemplate.opsForList()
     * stringRedisTemplate.opsForSet()
     * stringRedisTemplate.opsForHash()
     * stringRedisTemplate.opsForZSet()
     */
    @Test
    public void test01() {
//        stringRedisTemplate.opsForValue().append("msg", "hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
//        stringRedisTemplate.opsForList().leftPush("mylist", "1");
//        stringRedisTemplate.opsForList().leftPush("mylist", "2");
//        stringRedisTemplate.opsForList().leftPush("mylist", "3");
    }

    @Test
    public void test02() {
        Employee emp = employeeMapper.getEmpById(1);
        // 默认如果保存对象，使用JDK序列号机制，序列化后的数据保存到Redis中
//        redisTemplate.opsForValue().set("emp-01",emp);
        // 1、将数据以JSON的方式保存
        // 1.1自己将对象转为json
        // 1.2 RedisTemplate默认的序列化规则
        empRedisTemplate.opsForValue().set("emp-01", emp);
    }

    @Test
    public void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}
