package com.example.modules.menu.dao.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author honor
 * @Data 2024/6/3 17:04
 * @Version 1.0
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MenuTypeEnum implements IEnum<String> {
    CATALOG("目录"),
    BUTTON("按钮");

    @Getter
    private final String desc;

    @Override
    public String getValue() {
        return name();
    }
}
