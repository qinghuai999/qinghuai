package com.ssq.demo.jdauto.dms.common.log.enums;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 10:04 下午
 * @Description: 模块
 */
public enum  ModulesEnum {
    SYSTEM("system", "系统模块"),
    ;

    /**
     * 模块
     */
    private String module;

    /**
     * 描述
     */
    private String description;

    /**
     * 有参构造
     * @param module
     * @param description
     */
    ModulesEnum(String module, String description) {
        this.module = module;
        this.description = description;
    }


    /**
     * 构造方法
     * @return
     */
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
