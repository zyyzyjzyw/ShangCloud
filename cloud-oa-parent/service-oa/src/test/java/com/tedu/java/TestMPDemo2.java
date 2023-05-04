package com.tedu.java;

import com.tedu.java.model.system.SysRole;
import com.tedu.java.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zyy
 * @version 1.0.0
 * @ClassName TestMPDemo2.java
 * @Description TODO
 * @createTime 2023年03月08日 20:11:00
 */
public class TestMPDemo2 {
    // 完成注入
    @Autowired
    private SysRoleService sysRoleService;
    // 获取全部内容
    @Test
    public void getAll(){
        List<SysRole> sysRoles = sysRoleService.list(null);
        System.out.println(sysRoles);
    }
    // 添加操作
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        sysRoleService.save(sysRole);
        System.out.println(sysRole);
    }
}
