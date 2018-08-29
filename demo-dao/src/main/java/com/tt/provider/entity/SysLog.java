package com.tt.provider.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog {
    /**
     * 记录id
     */
    @Id
    private Long id;

    /**
     * 日志类型 1-登录 2-访问 3-操作 4-异常 5-授权
     */
    private Integer type;

    /**
     * 操作用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 操作用户名
     */
    private String username;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 调用方法
     */
    private String method;

    private String params;

    /**
     * 操作ip地址
     */
    private String ip;

    /**
     * 操作结果 1-成功 2-失败
     */
    private Byte result;

    /**
     * 操作描述
     */
    private String remark;

    /**
     * 操作时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 获取记录id
     *
     * @return id - 记录id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置记录id
     *
     * @param id 记录id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取日志类型 1-登录 2-访问 3-操作 4-异常 5-授权
     *
     * @return type - 日志类型 1-登录 2-访问 3-操作 4-异常 5-授权
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置日志类型 1-登录 2-访问 3-操作 4-异常 5-授权
     *
     * @param type 日志类型 1-登录 2-访问 3-操作 4-异常 5-授权
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取操作用户id
     *
     * @return user_id - 操作用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置操作用户id
     *
     * @param userId 操作用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取操作用户名
     *
     * @return username - 操作用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作用户名
     *
     * @param username 操作用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户操作
     *
     * @return operation - 用户操作
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置用户操作
     *
     * @param operation 用户操作
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 获取调用方法
     *
     * @return method - 调用方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置调用方法
     *
     * @param method 调用方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return params
     */
    public String getParams() {
        return params;
    }

    /**
     * @param params
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取操作ip地址
     *
     * @return ip - 操作ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置操作ip地址
     *
     * @param ip 操作ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取操作结果 1-成功 2-失败
     *
     * @return result - 操作结果 1-成功 2-失败
     */
    public Byte getResult() {
        return result;
    }

    /**
     * 设置操作结果 1-成功 2-失败
     *
     * @param result 操作结果 1-成功 2-失败
     */
    public void setResult(Byte result) {
        this.result = result;
    }

    /**
     * 获取操作描述
     *
     * @return remark - 操作描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置操作描述
     *
     * @param remark 操作描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取操作时间
     *
     * @return gmt_create - 操作时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置操作时间
     *
     * @param gmtCreate 操作时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}