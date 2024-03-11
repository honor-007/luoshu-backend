package com.example.core.mybatis.base;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author honor
 */

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TenantEntity extends BaseEntity{

    /**
     * 租户ID
     */
    //@ApiModelProperty(value = "租户ID")
    private String tenantId;
}
