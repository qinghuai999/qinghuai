package com.ssq.demo.jdauto.dms.system.role.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssq.demo.jdauto.dms.system.role.entity.data.RoleDO;
import com.ssq.demo.jdauto.dms.system.role.entity.transfer.RoleDTO;
import com.ssq.demo.jdauto.dms.system.role.entity.view.RoleVO;

import java.util.List;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/8 8:55 下午
 * @Description: 角色信息服务
 */
public interface RoleService {

    /**
     * 新增角色
     * @param roleDTO
     * @return
     */
    RoleVO insert(RoleDTO roleDTO);

    /**
     * 修改角色
     * @param roleDTO
     * @return
     */
    RoleVO updateById(RoleDTO roleDTO);

    /**
     * 删除角色
     * @param roleId
     */
    void delete(Long roleId);

    /**
     * 禁用角色
     * @param roleId
     */
    void disabled(Long roleId);

    /**
     * 启用角色
     * @param roleId
     */
    void enabled(Long roleId);

    /**
     * 查询所有角色
     * @param isEnabled
     * @return
     */
    List<RoleVO> all(boolean isEnabled);

    /**
     * 分页查询
     * @param roleDTO
     * @return
     */
    IPage<RoleVO> page(RoleDTO roleDTO);

    /**
     * 根据id查询角色
     * @param roleId
     * @return
     */
    RoleDO findById(Long roleId);

    /**
     * 根据CODE查询角色
     * @param code
     * @return
     */
    RoleDO findByCode(String code);

    // TODO 根据角色id查询角色列表
}
