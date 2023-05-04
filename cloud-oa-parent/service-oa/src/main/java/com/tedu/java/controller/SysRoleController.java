package com.tedu.java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tedu.java.common.result.Result;
import com.tedu.java.model.system.SysRole;
import com.tedu.java.service.SysRoleService;
import com.tedu.java.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zyy
 * @version 1.0.0
 * @ClassName SysRoleController.java
 * @Description TODO
 * @createTime 2023年03月08日 20:17:00
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    // 注入service
    @Autowired
    private SysRoleService sysRoleService;
    // 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        boolean isSuccess = sysRoleService.removeByIds(idList);
        if(isSuccess){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }
    // 根据id删除
    @ApiOperation("根据id删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id){
        boolean isSuccess = sysRoleService.removeById(id);
        if(isSuccess){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }
    //修改角色u
    @ApiOperation("修改角色")
    @PutMapping("update")
    public Result update(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if(isSuccess){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @ApiOperation("根据id进行查询")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    // 添加角色
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result save(@RequestBody SysRole sysRole){
        // 调用service方法进行添加
        boolean isSuccess = sysRoleService.save(sysRole);
        if(isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    // 查询所有角色
    @ApiOperation("查询所有的角色")
    @GetMapping("/findAll")
    public Result findAll(){
        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }


    /**
     * 条件分页查询
     * @param page 当前页
     * @param limit 每页显示的记录数
     * @param sysRoleQueryVo
     * @return
     */
    @ApiOperation("条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo){
        // 创建一个page对象，传递分页相关参数
        Page<SysRole> pageParam = new Page<>(page,limit);
        // 封装条件,判断条件是否为空,不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if(!StringUtils.isEmpty(roleName)){
            wrapper.like(SysRole::getRoleName,roleName);
        }
        // 掉方法进行实现
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }
}
