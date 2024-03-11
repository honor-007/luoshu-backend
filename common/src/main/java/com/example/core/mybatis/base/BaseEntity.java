package com.example.core.mybatis.base;

//import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author honor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEntity implements Serializable {

    /**
     * 创建人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 创建时间
     */
    //@ApiModelProperty(value = "创建时间")
    private Instant createTime;

    /**
     * 更新人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "更新人")
    private Long updateUser;

    /**
     * 更新时间
     */
    //@ApiModelProperty(value = "更新时间")
    private Instant updateTime;

    /**
     * 状态[1:正常]
     */
    //@ApiModelProperty(value = "业务状态")
    private Integer status;

    /**
     * 状态[0:未删除,1:删除]
     */
    @TableLogic(
            value = "0",
            delval = "1"
    )
    @TableField(
            value = "is_deleted",
            fill = FieldFill.INSERT
    )
    private Integer isDeleted;
}
