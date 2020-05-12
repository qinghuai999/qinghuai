package com.ssq.demo.jdauto.dms.system.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.ssq.demo.jdauto.dms.common.commondata.utils.EmployeeSessionUtils;
import com.ssq.demo.jdauto.dms.system.role.entity.data.RoleDO;
import com.ssq.demo.jdauto.dms.system.role.entity.transfer.RoleDTO;
import com.ssq.demo.jdauto.dms.system.role.entity.view.RoleVO;
import com.ssq.demo.jdauto.dms.system.role.exception.DmsRoleException;
import com.ssq.demo.jdauto.dms.system.role.mapper.RoleMapper;
import com.ssq.demo.jdauto.dms.system.role.service.RoleService;
import com.ssq.demo.jdauto.util.utils.bean.BeanConvertUtils;
import com.ssq.demo.jdauto.util.utils.params.ParamsInitUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssq.demo.jdauto.dms.system.role.constant.RoleErrorCodeConstant.*;
import static com.ssq.demo.jdauto.util.constant.JdautoConstant.DISABLE_INTEGER;
import static com.ssq.demo.jdauto.util.constant.JdautoConstant.ENABLED_INTEGER;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/8 10:20 下午
 * @Description: 角色服务实现
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleVO insert(RoleDTO roleDTO) {
        // 判断角色code是否为空
        if (Strings.isNullOrEmpty(roleDTO.getCode())) {
            log.error("角色CODE为空,添加失败");
            throw new DmsRoleException(ADD_ROLE_CODE_NULL);
        }

        // 判断角色名称是否为空
        if (Strings.isNullOrEmpty(roleDTO.getName())) {
            log.error("角色名称为空,添加失败");
            throw new DmsRoleException(ADD_ROLE_NAME_NULL);
        }

        // 判断描述是否为空
        if (Strings.isNullOrEmpty(roleDTO.getDescription())) {
            log.error("角色描述为空,添加失败");
            throw new DmsRoleException(ADD_ROLE_DESCRIPTION_NULL);
        }

        // 判断角色CODE是否重复
        RoleDO roleByCode = findByCode(roleDTO.getCode());
        if (null != roleByCode) {
            log.error("角色CODE重复,添加失败");
            throw new DmsRoleException(ADD_ROLE_CODE_EXIST);
        }

        RoleDO roleDO = BeanConvertUtils.convert(roleDTO, RoleDO.class);
        // 添加创建人等信息
        ParamsInitUtils.initCreateInfo(roleDO, EmployeeSessionUtils.getEmployeeId());

        roleMapper.insert(roleDO);
        return BeanConvertUtils.convert(roleDO, RoleVO.class);
    }

    @Override
    public RoleVO updateById(RoleDTO roleDTO) {
        // 判断id是否为空
        if (null == roleDTO.getId()) {
            log.error("角色ID不存在,修改失败");
            throw new DmsRoleException(UPDATE_ROLE_ID_NULL);
        }

        // 判断id是否存在
        RoleDO roleById = findById(roleDTO.getId());
        if (null == roleById) {
            log.error("该角色不存在,修改失败");
            throw new DmsRoleException(UPDATE_ROLE_ID_NOT_EXIST);
        }

        LambdaUpdateWrapper<RoleDO> updateWrapper = new LambdaUpdateWrapper<>();
        // 判断code是否修改且重复
        if (!Strings.isNullOrEmpty(roleDTO.getCode()) && !roleDTO.getCode().equals(roleById.getCode())) {
            RoleDO roleByCode = findByCode(roleDTO.getCode());
            if (null != roleByCode) {
                log.error("该角色CODE已存在,修改失败");
                throw new DmsRoleException(UPDATE_ROLE_CODE_EXIST);
            }
            updateWrapper.set(RoleDO::getCode, roleDTO.getCode());
        }

        // 判断名称是否修改
        if (!Strings.isNullOrEmpty(roleDTO.getName()) && !roleDTO.getName().equals(roleById.getName())) {
            updateWrapper.set(RoleDO::getName, roleDTO.getName());
        }

        // 判断描述是否修改
        if (!Strings.isNullOrEmpty(roleDTO.getDescription()) && !roleDTO.getDescription().equals(roleById.getDescription())) {
            updateWrapper.set(RoleDO::getDescription, roleDTO.getDescription());
        }

        RoleDO roleDO = BeanConvertUtils.convert(roleDTO, RoleDO.class);
        // 修改更新人等
        ParamsInitUtils.initUpdateInfo(roleDO, EmployeeSessionUtils.getEmployeeId());
        updateWrapper.eq(RoleDO::getId, roleDTO.getId());

        // 修改数据
        roleMapper.update(roleDO, updateWrapper);
        return BeanConvertUtils.convert(roleDO, RoleVO.class);
    }

    @Override
    public void delete(Long roleId) {
        // 判断id是否为空
        if (null == roleId) {
            log.error("角色ID为空,删除失败");
            throw new DmsRoleException(DELETE_ROLE_ID_NULL);
        }

        // 判断id是否存在
        RoleDO roleById = findById(roleId);
        if (null == roleById) {
            log.error("该角色不存在,删除失败");
            throw new DmsRoleException(DELETE_ROLE_ID_NOT_EXIST);
        }

        LambdaUpdateWrapper<RoleDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(RoleDO::getId, roleId);
        // 删除
        roleMapper.delete(updateWrapper);

        // TODO 发送删除角色事件
    }

    @Override
    public void disabled(Long roleId) {
        // 判断id是否为空
        if (null == roleId) {
            log.error("角色ID为空,禁用失败");
            throw new DmsRoleException(DISABLE_ROLE_ID_NULL);
        }

        // 判断id是否存在
        RoleDO roleById = findById(roleId);
        if (null == roleById) {
            log.error("该角色不存在,禁用失败");
            throw new DmsRoleException(DISABLE_ROLE_ID_NOT_EXIST);
        }

        // 禁用角色
        LambdaUpdateWrapper<RoleDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(RoleDO::getIsEnabled, DISABLE_INTEGER);
        updateWrapper.eq(RoleDO::getId, roleId);
        roleMapper.update(new RoleDO(), updateWrapper);
    }

    @Override
    public void enabled(Long roleId) {
        // 判断id是否为空
        if (null == roleId) {
            log.error("角色ID为空,启用失败");
            throw new DmsRoleException(ENABLE_ROLE_ID_NULL);
        }

        // 判断id是否存在
        RoleDO roleById = findById(roleId);
        if (null == roleById) {
            log.error("该角色不存在,启用失败");
            throw new DmsRoleException(ENABLE_ROLE_ID_NOT_EXIST);
        }

        // 启用角色
        LambdaUpdateWrapper<RoleDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(RoleDO::getIsEnabled, ENABLED_INTEGER);
        updateWrapper.eq(RoleDO::getId, roleId);
        roleMapper.update(new RoleDO(), updateWrapper);
    }

    @Override
    public List<RoleVO> all(boolean isEnabled) {
        // 查询所有角色
        LambdaQueryWrapper<RoleDO> queryWrapper = new LambdaQueryWrapper<>();

        // 查询启用角色
        if (!isEnabled) {
            queryWrapper.eq(RoleDO::getIsEnabled, ENABLED_INTEGER);
        }

        List<RoleDO> roleDOList = roleMapper.selectList(queryWrapper);
        return BeanConvertUtils.convert(roleDOList,RoleVO.class);
    }

    @Override
    public IPage<RoleVO> page(RoleDTO roleDTO) {
        IPage<RoleDO> page = new Page<>(roleDTO.getCurrent(),roleDTO.getSize());
        LambdaQueryWrapper<RoleDO> queryWrapper = new LambdaQueryWrapper<>();
        if (!Strings.isNullOrEmpty(roleDTO.getCode())){
            queryWrapper.eq(RoleDO::getCode,roleDTO.getCode());
        }
        if (!Strings.isNullOrEmpty(roleDTO.getName())) {
            queryWrapper.like(RoleDO::getName, roleDTO.getName());
        }
        if (!Strings.isNullOrEmpty(roleDTO.getDescription())) {
            queryWrapper.like(RoleDO::getDescription, roleDTO.getDescription());
        }
        if (null != roleDTO.getIsEnabled()) {
            queryWrapper.eq(RoleDO::getIsEnabled, roleDTO.getIsEnabled());
        }

        IPage<RoleDO> roleDOPage = roleMapper.selectPage(page, queryWrapper);
        IPage<RoleVO> roleVOPage = new Page<>(roleDOPage.getCurrent(),roleDOPage.getSize());
        roleVOPage.setTotal(roleDOPage.getTotal());
        roleVOPage.setPages(roleDOPage.getPages());
        roleVOPage.setRecords(BeanConvertUtils.convert(roleDOPage.getRecords(),RoleVO.class));
        return roleVOPage;
    }

    @Override
    public RoleDO findById(Long roleId) {
        if (null == roleId) {
            log.error("角色ID为空,查询失败");
            throw new DmsRoleException(FIND_ROLE_ID_NULL);
        }

        LambdaQueryWrapper<RoleDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleDO::getId, roleId);
        RoleDO roleDO = roleMapper.selectOne(queryWrapper);
        return roleDO;
    }

    @Override
    public RoleDO findByCode(String code) {
        if (Strings.isNullOrEmpty(code)) {
            log.error("角色CODE为空,查询失败");
            throw new DmsRoleException(FIND_ROLE_CODE_NULL);
        }

        LambdaQueryWrapper<RoleDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleDO::getCode, code);
        RoleDO roleDO = roleMapper.selectOne(queryWrapper);
        return roleDO;
    }
}
