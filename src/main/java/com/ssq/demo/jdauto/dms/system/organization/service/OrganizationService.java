package com.ssq.demo.jdauto.dms.system.organization.service;

import com.ssq.demo.jdauto.dms.system.organization.entity.data.OrganizationDO;
import com.ssq.demo.jdauto.dms.system.organization.entity.transfer.OrganizationDTO;
import com.ssq.demo.jdauto.dms.system.organization.entity.view.OrganizationVO;

import java.util.List;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/9 11:52 上午
 * @Description: 组织服务
 */
public interface OrganizationService {

    // 新增组织
    OrganizationVO insert(OrganizationDTO organizationDTO);

    // 修改组织
    OrganizationVO updateById(OrganizationDTO organizationDTO);

    // 禁用组织
    void disabled(Long orgId);

    // 启用组织
    void enabled(Long orgId);

    // 删除组织
    void delete(Long OrgId);

    // 查询组织(是否包含禁用组织)
    List<OrganizationVO> all(boolean isEnabled);

    // 查询父组织
    List<OrganizationVO> findParents(Long orgId);

    // 查询某父组织下所有子组织
    List<OrganizationVO> findChildren(Long orgId);

    // 通过id查询某一组织
    OrganizationDO findById(Long orgId);

    // 通过code查询组织
    OrganizationDO findByCode(String code);

}
