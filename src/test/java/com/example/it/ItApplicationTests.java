package com.example.it;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.it.enity.User;
import com.example.it.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ItApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
    }

    @Test
    void del() {
        userMapper.deleteById(12);
    }

    @Test
    void update() {
        User user = new User();
        user.setId(1L);
        user.setName("撒6666旦");
        user.setVersion(1);
        user.setPassword("999");
        userMapper.updateById(user);
    }

    @Test
    void toSave() {
      User user = new User();
      user.setName("撒31yt2旦");
      user.setPassword("114");
      userMapper.insert(user);
    }


    @Test
    void id() {
        User user = userMapper.selectById(13L);

        System.out.println(user);
    }
    @Test
    void page() {
        IPage page = new Page(1,2);//第1页，2条

       userMapper.selectPage(page,null);

        System.out.println(page.getCurrent());//当前页数
        System.out.println(page.getSize());//每一页条数
        System.out.println(page.getPages());//一共几页
        System.out.println(page.getTotal());//当前页数据和
        System.out.println(page.getRecords());//当前页数据
    }

    @Test
    void get() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("password","1");

        List<User> user = userMapper.selectList(queryWrapper);

        System.out.println(user);
    }


    @Test
    void get2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.lambda().lt(User::getPassword,119);

        List<User> user = userMapper.selectList(queryWrapper);

        System.out.println(user);
    }

    @Test
    void get3() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();

        lambdaQueryWrapper.lt(User::getPassword,119);

        List<User> user = userMapper.selectList(lambdaQueryWrapper);

        System.out.println(user);
    }
    @Test
    void get4() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();

        lambdaQueryWrapper.lt(User::getPassword,122).or().gt(User::getPassword,124);

        List<User> user = userMapper.selectList(lambdaQueryWrapper);

        System.out.println(user);
    }

    @Test
    void contextLoads1() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.select(User::getId,User::getName);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(list);
    }
    @Test
    void contextLoad1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("count(*) as count,name");
        queryWrapper.groupBy("name");
        List<Map<String,Object>> list = userMapper.selectMaps(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void test() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

    }
}
