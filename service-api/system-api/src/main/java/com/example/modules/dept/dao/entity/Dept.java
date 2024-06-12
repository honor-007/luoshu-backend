package com.example.modules.dept.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @Author honor
 * @Data 2024/6/12 15:25
 * @Version 1.0
 */
@Data
@SuperBuilder
@TableName(value = "dept", autoResultMap = true)
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Schema(name = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 租户ID
     */
    @Schema(name = "租户ID")
    private String tenantId;

    /**
     * 父主键
     */
    @Schema(name = "父主键")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    /**
     * 祖级机构主键
     */
    @Schema(name = "祖级机构主键")
    private String ancestors;

    /**
     * 部门名
     */
    @Schema(name = "部门名")
    private String deptName;

    /**
     * 部门全称
     */
    @Schema(name = "部门全称")
    private String fullName;

    /**
     * 排序
     */
    @Schema(name = "排序")
    private Integer sort;

    /**
     * 备注
     */
    @Schema(name = "备注")
    private String remark;

    /**
     * 是否已删除
     */
    @TableLogic
    @Schema(name = "是否已删除")
    private Integer isDeleted;


}
