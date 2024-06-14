package com.example.modules.user.dao.criteria;

import com.example.core.tool.page.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author honor
 * @Data 2024/6/13 13:21
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCriteria extends PageInfo {

    private String deptId;
}
