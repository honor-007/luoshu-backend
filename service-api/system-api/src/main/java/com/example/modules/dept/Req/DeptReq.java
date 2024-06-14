package com.example.modules.dept.Req;

import com.example.core.mybatis.base.TenantEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

/**
 * @author honor
 */

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class DeptReq  {
    private String id;

}
