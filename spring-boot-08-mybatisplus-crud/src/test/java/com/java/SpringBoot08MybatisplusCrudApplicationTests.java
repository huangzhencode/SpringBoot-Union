package com.java;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.enums.GradeEnum;
import com.java.enums.SexEnum;
import com.java.mapper.UserMapper;
import com.java.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.util.*;

@SpringBootTest
class SpringBoot08MybatisplusCrudApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setUserName("谢谢");
        user.setAge(22);
        user.setName("xiexie");
        user.setPassword("1111");
        user.setGrade(GradeEnum.HIGH);
        user.setSex(SexEnum.WOMAN);
        userMapper.insert(user);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(1);
        user.setName("wocao");
        userMapper.updateById(user);
    }

    @Test
    void testUpdate() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("user_name", "xxxx")
                .set("password", "aaqqq")
                .set("email", "qqqqqq")
                .eq("id", 1);
        int result = userMapper.update(null, wrapper);
        System.out.println(result);
    }

    /**
     * // 根据 ID 查询
     * T selectById(Serializable id);
     * // 根据 entity 条件，查询一条记录
     * T selectOne(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     *
     * // 查询（根据ID 批量查询）
     * List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
     * // 根据 entity 条件，查询全部记录
     * List<T> selectList(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     * // 查询（根据 columnMap 条件）
     * List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
     * // 根据 Wrapper 条件，查询全部记录
     * List<Map<String, Object>> selectMaps(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     * // 根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
     * List<Object> selectObjs(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     *
     * // 根据 entity 条件，查询全部记录（并翻页）
     * IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     * // 根据 Wrapper 条件，查询全部记录（并翻页）
     * IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     * // 根据 Wrapper 条件，查询总记录数
     * Integer selectCount(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
     */
    @Test
    void testSelectById(){
        System.out.println(userMapper.selectById(7));

    }

    @Test
    void testSelectOne(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "xieya");

        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void testSelectBatchIds(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectList(){
        //查询全部
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    void testSelectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("password", "123");
        List<User> users = userMapper.selectByMap(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectMaps(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123")
                .gt("age", 20);
        List<Map<String, Object>> list_map = userMapper.selectMaps(wrapper);
        for (Map<String, Object> map : list_map) {
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                System.out.println( s +  "====>"  + map.get(s));
            }
            System.out.println("-----------------------------");
        }
    }


    @Test
    void testSelectObjs(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123")
                .gt("age", 20);
        //只返回第一个字段的值  此处返回id
        List<Object> list = userMapper.selectObjs(wrapper);
        for (Object o : list) {
            System.out.println(o);
        }

    }


    @Test
    void testSelectPage(){
        Page<User> page = new Page<>();

        //Current:当前页，Size：每页大小
        page.setCurrent(2).setSize(2);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123")
                .gt("age", 20);


        Page<User> userPage = userMapper.selectPage(page, wrapper);
        System.out.println("当前页码" + userPage.getCurrent());
        System.out.println("当前页的数量" + userPage.getSize());
        System.out.println("总记录数" + userPage.getTotal());

        List<User> records = userPage.getRecords();
        for (User record : records) {
            System.out.println(record);
        }

    }
    @Test
    void testSelectCount(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123")
                .gt("age", 20);

        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);

    }

    /**
     * // 根据 entity 条件，删除记录
     * int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
     * // 删除（根据ID 批量删除）
     * int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
     * // 根据 ID 删除
     * int deleteById(Serializable id);
     * // 根据 columnMap 条件，删除记录
     * int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
     */

    @Test
    void testDelete(){
        QueryWrapper<User> w = new QueryWrapper<>();
        w.lt("age", "20");
        userMapper.delete(w);
    }

    @Test
    void testDeleteBatchIds(){
        //没有5号不会报错，会将1,3删除
        userMapper.deleteBatchIds(Arrays.asList(6,7,8));
    }
    @Test
    void testDeleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("age", "22");
        map.put("password", "123");
        userMapper.deleteByMap(map);
    }

    @Test
    void testFindUserById(){
        User user = userMapper.findUserById(6);
        System.out.println(user);
    }

    @Test
    void testAllEq1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "黄振");
        map.put("age", "20");
        map.put("password", null);
        wrapper.allEq(map);
        userMapper.selectList(wrapper);
    }
    @Test
    void testAllEq2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "黄振");
        map.put("age", "20");
        map.put("password", null);
        wrapper.allEq(map,false);
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testAllEq3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "黄振");
        map.put("age", "20");
        map.put("password", null);
        wrapper.allEq((k,v) -> (k.equals("age") || k.equals("name")),map);
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void testOrderByDESC(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testLikeLeft(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeLeft("name", "振");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    void testFindAll(){
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
