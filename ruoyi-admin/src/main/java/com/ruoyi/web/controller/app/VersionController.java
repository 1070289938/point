package com.ruoyi.web.controller.app;

import com.ruoyi.common.annotation.RequestLimits;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.IVersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 版本相关接口
 */

@RestController
@RequestMapping("app/version")
public class VersionController {

    @Autowired
    private IVersionsService versionsService;

    /**
     * 获取当前最新版本接口
     *
     * @return
     */
    @PostMapping("get/thisVersion")
    @RequestLimits
    public AjaxResult getThisVersion() {
        return AjaxResult.success(versionsService.getThisVersion());
    }


}
