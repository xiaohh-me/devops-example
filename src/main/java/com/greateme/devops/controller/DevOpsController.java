package com.greateme.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试DevOps的控制器
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2023-07-17 星期一 12:18:47
 * @file DevOpsController.java
 */
@RestController
public class DevOpsController {

    /**
     * 用于测试的请求mapping
     */
    @GetMapping("/devOps")
    public String devOps() {
        return "Hello DevOps --- v1.0.0";
    }
}
