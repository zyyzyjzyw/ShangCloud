package com.tedu.java;


import com.tedu.java.mapper.SysRoleMapper;
import com.tedu.java.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
