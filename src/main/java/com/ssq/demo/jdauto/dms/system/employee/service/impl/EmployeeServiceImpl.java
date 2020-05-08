package com.ssq.demo.jdauto.dms.system.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.ssq.demo.jdauto.dms.common.commondata.utils.EmployeeSessionUtils;
import com.ssq.demo.jdauto.dms.system.employee.entity.data.EmployeeDO;
import com.ssq.demo.jdauto.dms.system.employee.entity.transfer.EmployeeDTO;
import com.ssq.demo.jdauto.dms.system.employee.entity.view.EmployeeVO;
import com.ssq.demo.jdauto.dms.system.employee.exception.DmsEmployeeException;
import com.ssq.demo.jdauto.dms.system.employee.mapper.EmployeeMapper;
import com.ssq.demo.jdauto.dms.system.employee.service.EmployeeService;
import com.ssq.demo.jdauto.util.constant.JdautoConstant;
import com.ssq.demo.jdauto.util.utils.bean.BeanConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.ssq.demo.jdauto.dms.system.employee.constant.EmployeeErrorCodeConstant.*;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 9:19 下午
 * @Description: 员工服务实现
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeVO add(EmployeeDTO employeeDTO) {
        // 实体转换工具
        EmployeeDO employeeDO = BeanConvertUtils.convert(employeeDTO, EmployeeDO.class);
        // 添加创建人创建时间
        employeeDO.setCreatedBy(EmployeeSessionUtils.getEmployeeId().toString());
        employeeDO.setUpdatedBy(EmployeeSessionUtils.getEmployeeId().toString());
        Date date = new Date();
        employeeDO.setCreatedTime(date);
        employeeDO.setUpdatedTime(date);

        // 校验code是否为空
        if (Strings.isNullOrEmpty(employeeDTO.getCode())){
            log.error("员工编码不能为空,添加失败");
            throw new DmsEmployeeException(ADD_CODE_NULL);
        }

        // 校验登录名是否为空
        if (Strings.isNullOrEmpty(employeeDTO.getLoginName())){
            log.error("员工登录名不能为空,添加失败");
            throw new DmsEmployeeException(ADD_LOGIN_NAME_NULL);
        }

        // 校验邮箱是否为空
        if (Strings.isNullOrEmpty(employeeDTO.getEmail())){
            log.error("员工邮箱不能为空,添加失败");
            throw new DmsEmployeeException(ADD_EMAIL_NULL);
        }

        // 校验手机号是否为空
        if (Strings.isNullOrEmpty(employeeDTO.getMobile())){
            log.error("员工手机号不能为空,添加失败");
            throw new DmsEmployeeException(ADD_MOBILE_NULL);
        }

        // 校验code是否重复
        EmployeeVO employeeByCode = findByCode(employeeDTO.getCode());
        if (null != employeeByCode){
            log.error("该编码已存在,添加失败");
            throw new DmsEmployeeException(ADD_CODE_EXIST);
        }

        // 校验登录名是否重复
        EmployeeVO employeeByLoginName = findByLoginName(employeeDTO.getLoginName());
        if (null != employeeByLoginName){
            log.error("该登录名已存在,添加失败");
            throw new DmsEmployeeException(ADD_LOGIN_NAME_EXIST);
        }

        // 校验手机号是否重复
        EmployeeVO employeeByMobile = findByMobile(employeeDTO.getMobile());
        if (null != employeeByMobile){
            log.error("该手机号已存在,添加失败");
            throw new DmsEmployeeException(ADD_MOBILE_EXIST);
        }


        // 添加数据
        employeeMapper.insert(employeeDO);

        // TODO 发送通知 添加事件

        return BeanConvertUtils.convert(employeeDO, EmployeeVO.class);
    }

    @Override
    public EmployeeVO update(EmployeeDTO employeeDTO) {
        // 判断id是否为空
        if (null == employeeDTO.getId()){
            log.error("员工id为空,更新失败");
            throw new DmsEmployeeException(UPDATE_ID_NULL);
        }

        // 判断员工是否存在
        EmployeeVO employeeById = findById(employeeDTO.getId());
        if (null == employeeById){
            log.error("员工id不存在,更新失败");
            throw new DmsEmployeeException(UPDATE_ID_NULL);
        }

        // 存储数据
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setId(employeeDTO.getId());

        // 判断code是否重复且有变动
        if (!Strings.isNullOrEmpty(employeeDTO.getCode())
                && !employeeDTO.getCode().equals(employeeById.getCode())){
            EmployeeVO employeeByCode = findByCode(employeeDTO.getCode());
            if (null != employeeByCode){
                log.error("员工CODE重复,更新失败");
                throw new DmsEmployeeException(UPDATE_CODE_EXIST);
            }
            employeeDO.setCode(employeeDTO.getCode());
        }

        // 判断登录名是否重复
        if (!Strings.isNullOrEmpty(employeeDTO.getLoginName())
                && !employeeDTO.getLoginName().equals(employeeById.getLoginName())){
            EmployeeVO employeeByLoginName = findByLoginName(employeeDTO.getLoginName());
            if (null != employeeByLoginName){
                log.error("登录名重复,更新失败");
                throw new DmsEmployeeException(UPDATE_LOGIN_NAME_EXIST);
            }
            employeeDO.setLoginName(employeeDTO.getLoginName());
        }


        // 判断邮箱是否重复
        if (!Strings.isNullOrEmpty(employeeDTO.getEmail())
                && employeeDTO.getEmail().equals(employeeById.getEmail())){
            EmployeeVO employeeByEmail = findByEmail(employeeDTO.getEmail());
            if (null != employeeByEmail){
                log.error("邮箱重复,更新失败");
                throw new DmsEmployeeException(UPDATE_EMAIL_EXIST);
            }
            employeeDO.setEmail(employeeDTO.getEmail());
        }


        // 判断手机号是否重复
        if (!Strings.isNullOrEmpty(employeeDTO.getMobile())
                && employeeDTO.getMobile().equals(employeeById.getMobile())){
            EmployeeVO employeeByMobile = findByMobile(employeeDTO.getMobile());
            if (null != employeeByMobile){
                log.error("手机号重复,更新失败");
                throw new DmsEmployeeException(UPDATE_MOBILE_EXIST);
            }
            employeeDO.setMobile(employeeDTO.getMobile());
        }

        // 判断密码是否为空
        if (!Strings.isNullOrEmpty(employeeDTO.getPassword())){
            employeeDO.setPassword(employeeDTO.getPassword());
        }

        // 判断员工名称是否为空
        if (!Strings.isNullOrEmpty(employeeDTO.getName())){
            employeeDO.setName(employeeDTO.getName());
        }

        // 判断员工类型是否为空
        if (null != employeeDTO.getType()){
            employeeDO.setType(employeeDTO.getType());
        }

        // 判断员工性别是否为空
        if (null != employeeDTO.getSex()){
            employeeDO.setSex(employeeDTO.getSex());
        }

        // 修改更新人及更新时间
        employeeDO.setUpdatedBy(EmployeeSessionUtils.getEmployeeId().toString());
        employeeDO.setUpdatedTime(new Date());

        // 更新员工信息
        employeeMapper.updateById(employeeDO);

        // TODO 查询组织是否发生变化

        return BeanConvertUtils.convert(employeeDO,EmployeeVO.class);
    }

    @Override
    public void disabled(Long employeeId) {
        // 判断员工id是否为空
        if (null == employeeId){
            log.error("员工id为空,禁用失败");
            throw new DmsEmployeeException(DISABLED_ID_NULL);
        }

        // 查询员工信息是否存在
        EmployeeVO employeeById = findById(employeeId);
        if (null == employeeById){
            log.error("员工信息不存在,禁用失败");
            throw new DmsEmployeeException(DISABLED_ID_NOT_EXIST);
        }

        // 禁用该员工
        LambdaUpdateWrapper<EmployeeDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(EmployeeDO::getIsEnabled, JdautoConstant.DISABLE_INTEGER);
        updateWrapper.set(EmployeeDO::getUpdatedBy, EmployeeSessionUtils.getEmployeeId());
        updateWrapper.set(EmployeeDO::getUpdatedTime, new Date());
        updateWrapper.eq(EmployeeDO::getId,employeeId);
        employeeMapper.update(new EmployeeDO(), updateWrapper);
    }

    @Override
    public void enabled(Long employeeId) {
        // 判断哪该员工id是否为空
        if (null == employeeId){
            log.error("员工id不存在,启用失败");
            throw new DmsEmployeeException(ENABLED_ID_NULL);
        }

        // 判断该员工是否存在
        EmployeeVO emloyeeById = findById(employeeId);
        if (null == emloyeeById){
            log.error("员工信息不存在,启用失败");
            throw new DmsEmployeeException(ENABLED_ID_NOT_EXIST);
        }

        // 启用该员工
        LambdaUpdateWrapper<EmployeeDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(EmployeeDO::getIsEnabled, JdautoConstant.ENABLED_INTEGER);
        updateWrapper.set(EmployeeDO::getUpdatedBy, EmployeeSessionUtils.getEmployeeId());
        updateWrapper.set(EmployeeDO::getUpdatedTime, new Date());
        updateWrapper.eq(EmployeeDO::getId, employeeId);
        employeeMapper.update(new EmployeeDO(), updateWrapper);

    }

    @Override
    public IPage<EmployeeVO> page(EmployeeDTO employeeDTO) {
        IPage<EmployeeDO> page = new Page<>(employeeDTO.getCurrent(),employeeDTO.getSize());
        // 按条件查询
        LambdaQueryWrapper<EmployeeDO> queryWrapper = new LambdaQueryWrapper<>();

        // 按登录名查询
        if (!Strings.isNullOrEmpty(employeeDTO.getLoginName())) {
            queryWrapper.like(EmployeeDO::getLoginName, employeeDTO.getLoginName());
        }

        // 按用户名称查询
        if (!Strings.isNullOrEmpty(employeeDTO.getName())) {
            queryWrapper.like(EmployeeDO::getName, employeeDTO.getName());
        }

        // 按编码查询
        if (!Strings.isNullOrEmpty(employeeDTO.getCode())) {
            queryWrapper.like(EmployeeDO::getCode, employeeDTO.getCode());
        }

        // 按类型查询
        if (null != employeeDTO.getType()) {
            queryWrapper.eq(EmployeeDO::getType, employeeDTO.getType());
        }

        // 按是否启用查询
        if (null != employeeDTO.getIsEnabled()) {
            queryWrapper.eq(EmployeeDO::getIsEnabled, employeeDTO.getIsEnabled());
        }

        // 按邮箱查询
        if (!Strings.isNullOrEmpty(employeeDTO.getEmail())) {
            queryWrapper.like(EmployeeDO::getEmail, employeeDTO.getEmail());
        }

        // 按手机号查询
        if (!Strings.isNullOrEmpty(employeeDTO.getMobile())) {
            queryWrapper.like(EmployeeDO::getMobile, employeeDTO.getMobile());
        }

        // TODO 通过组织id查询(多选查询)

        // 分页 数据转换
        IPage<EmployeeDO> employeeDO = employeeMapper.selectPage(page,queryWrapper);
        IPage<EmployeeVO> employeeVOPage = new Page<>(employeeDO.getCurrent(),employeeDO.getSize());
        employeeVOPage.setTotal(employeeDO.getTotal());
        employeeVOPage.setPages(employeeDO.getPages());
        employeeVOPage.setRecords(BeanConvertUtils.convert(employeeDO.getRecords(),EmployeeVO.class));
        return employeeVOPage;
    }

    @Override
    public EmployeeVO findById(Long id) {
        // 判断id是否存在
        if (null == id){
            log.error("id不存在,查询失败");
            throw new DmsEmployeeException(FIND_ID_NULL);
        }

        // 通过id查询用户信息
        LambdaQueryWrapper<EmployeeDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeDO::getId, id);
        EmployeeDO employeeDO = employeeMapper.selectOne(queryWrapper);
        return BeanConvertUtils.convert(employeeDO,EmployeeVO.class);
    }

    @Override
    public EmployeeVO findByCode(String code) {
        // 判断员工编码是否为空
        if (Strings.isNullOrEmpty(code)){
            log.error("员工编码不能为空,查询失败");
            throw new DmsEmployeeException(FIND_CODE_NULL);
        }

        // 通过编码查询用户信息
        LambdaQueryWrapper<EmployeeDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeDO::getCode, code);
        EmployeeDO employeeDO = employeeMapper.selectOne(queryWrapper);
        return BeanConvertUtils.convert(employeeDO,EmployeeVO.class);
    }

    @Override
    public EmployeeVO findByLoginName(String loginName) {
        // 校验登录名是否为空
        if (Strings.isNullOrEmpty(loginName)){
            log.error("员工登录名不能为空,添加失败");
            throw new DmsEmployeeException(FIND_LOGIN_NAME_NULL);
        }

        // 通过登录名查询用户信息
        LambdaQueryWrapper<EmployeeDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeDO::getLoginName, loginName);
        EmployeeDO employeeDO = employeeMapper.selectOne(queryWrapper);
        return BeanConvertUtils.convert(employeeDO,EmployeeVO.class);
    }

    @Override
    public EmployeeVO findByEmail(String email) {
        // 校验邮箱是否为空
        if (Strings.isNullOrEmpty(email)){
            log.error("员工邮箱不能为空,添加失败");
            throw new DmsEmployeeException(FIND_EMAIL_NULL);
        }

        // 通过邮箱查询用户信息
        LambdaQueryWrapper<EmployeeDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeDO::getEmail, email);
        EmployeeDO employeeDO = employeeMapper.selectOne(queryWrapper);
        return BeanConvertUtils.convert(employeeDO, EmployeeVO.class);
    }

    @Override
    public EmployeeVO findByMobile(String mobile) {
        // 校验手机号是否为空
        if (Strings.isNullOrEmpty(mobile)){
            log.error("员工手机号不能为空,添加失败");
            throw new DmsEmployeeException(FIND_MOBILE_NULL);
        }

        // 通过手机号查询用户信息
        LambdaQueryWrapper<EmployeeDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeDO::getMobile, mobile);
        EmployeeDO employeeDO = employeeMapper.selectOne(queryWrapper);
        return BeanConvertUtils.convert(employeeDO, EmployeeVO.class);
    }
}
