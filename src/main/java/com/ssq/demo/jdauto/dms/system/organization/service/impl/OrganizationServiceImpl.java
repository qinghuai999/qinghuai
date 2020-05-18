package com.ssq.demo.jdauto.dms.system.organization.service.impl;

import com.ssq.demo.jdauto.dms.system.organization.entity.data.OrganizationDO;
import com.ssq.demo.jdauto.dms.system.organization.entity.transfer.OrganizationDTO;
import com.ssq.demo.jdauto.dms.system.organization.entity.view.OrganizationVO;
import com.ssq.demo.jdauto.dms.system.organization.service.OrganizationService;

import java.util.List;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/9 11:52 上午
 * @Description: 组织服务实现
 */
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public OrganizationVO insert(OrganizationDTO organizationDTO) {
        return null;
    }

    @Override
    public OrganizationVO updateById(OrganizationDTO organizationDTO) {
        return null;
    }

    @Override
    public void disabled(Long orgId) {

    }

    @Override
    public void enabled(Long orgId) {

    }

    @Override
    public void delete(Long OrgId) {

    }

    @Override
    public List<OrganizationVO> all(boolean isEnabled) {
        return null;
    }

    @Override
    public List<OrganizationVO> findParents(Long orgId) {
        return null;
    }

    @Override
    public List<OrganizationVO> findChildren(Long orgId) {
        return null;
    }

    @Override
    public OrganizationDO findById(Long orgId) {
        return null;
    }

    @Override
    public OrganizationDO findByCode(String code) {
        return null;
    }
}
