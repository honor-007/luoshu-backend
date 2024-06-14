package com.example.core.tool.page;

import lombok.Data;

/**
 * @Author honor
 * @Data 2024/6/13 14:22
 * @Version 1.0
 */
@Data
public class PageInfo {
    private Integer current;

    /**
     * 每页的数量
     */
    private Integer pageSize;

    /**
     * 排序的字段名
     */
    private String ascs;

    /**
     * 排序方式
     */
    private String descs;

}
