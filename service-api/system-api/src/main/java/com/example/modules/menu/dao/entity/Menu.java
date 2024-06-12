/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.modules.menu.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.modules.menu.dao.enums.MenuTypeEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author honor
 */
@Data
@SuperBuilder
@TableName(value = "menu", autoResultMap = true)
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Schema(name = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    
    /**
     * 菜单父主键
     */
    @Schema(name = "父主键")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    /**
     * 菜单编号
     */
    @Schema(name = "菜单编号")
    private String code;

    /**
     * 菜单名称
     */
    @Schema(name = "菜单名称")
    private String name;

    /**
     * 菜单别名
     */
    @Schema(name = "菜单别名")
    private String alias;

    /**
     * 请求地址
     */
    @Schema(name = "请求地址")
    private String path;

    /**
     * 菜单资源
     */
    @Schema(name = "菜单资源")
    private String source;

    /**
     * 排序
     */
    @Schema(name = "排序")
    private Integer sort;

    /**
     * 菜单类型
     */
    @Schema(name = "菜单类型")
    private MenuTypeEnum type;

    /**
     * 操作按钮类型
     */
    @Schema(name = "操作按钮类型")
    private String action;

    /**
     * 是否打开新页面
     */
    @Schema(name = "是否打开新页面")
    private Integer isOpen;

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
