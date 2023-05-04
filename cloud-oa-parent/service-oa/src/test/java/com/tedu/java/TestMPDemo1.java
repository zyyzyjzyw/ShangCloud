package com.tedu.java;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.java.mapper.SysRoleMapper;
import com.tedu.java.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;

/**
 * @author zyy
 * @version 1.0.0
 * @ClassName TestMPDemo1.java
 * @Description TODO
 * @createTime 2023年03月07日 21:11:00
 */
@SpringBootTest
public class TestMPDemo1 {
    // 完成注入
    @Autowired
    private SysRoleMapper sysRoleMapper;
    // 获取全部内容
    @Test
    public void getAll(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);
    }
    // 添加操作
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        sysRoleMapper.insert(sysRole);
        System.out.println(sysRole);
    }
    // 修改操作
    @Test
    public void update(){
        // 根据id进行查询
        SysRole sysRole = sysRoleMapper.selectById(9);
        // 设置修改的值
        sysRole.setRoleName("zyy角色管理员");
        // 调用方法实现最终修改
        sysRoleMapper.updateById(sysRole);
    }
    // 根据id进行删除
    @Test
    public void delete(){
        sysRoleMapper.deleteById(9);
    }
    // 批量删除
    public void deleteBath(){
        sysRoleMapper.deleteBatchIds(Arrays.asList(1,2));
    }
    // 条件查询
    @Test
    public void testQuery(){
        // 创建条件对象
        QueryWrapper<SysRole> wrapper = new QueryWrapper();
        wrapper.eq("role_name","总经理");
        // 调用mp方法实现查询操作
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);

    }
    @Test
    public void testQuery1(){
        // 创建条件对象
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleCode,"role");
        // 调用mp方法实现查询操作
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);

    }
}
