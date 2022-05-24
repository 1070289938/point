package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.RegistrationCode;
import com.ruoyi.system.service.IRegistrationCodeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 注册码绑定Controller
 *
 * @author ruoyi
 * @date 2022-05-20
 */
@Controller
@RequestMapping("/system/code")
public class RegistrationCodeController extends BaseController
{
    private String prefix = "system/code";

    @Autowired
    private IRegistrationCodeService registrationCodeService;

    @RequiresPermissions("system:code:view")
    @GetMapping()
    public String code()
    {
        return prefix + "/code";
    }

    /**
     * 查询注册码绑定列表
     */
    @RequiresPermissions("system:code:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RegistrationCode registrationCode)
    {
        startPage();
        List<RegistrationCode> list = registrationCodeService.selectRegistrationCodeList(registrationCode);
        return getDataTable(list);
    }

    /**
     * 导出注册码绑定列表
     */
    @RequiresPermissions("system:code:export")
    @Log(title = "注册码绑定", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RegistrationCode registrationCode)
    {
        List<RegistrationCode> list = registrationCodeService.selectRegistrationCodeList(registrationCode);
        ExcelUtil<RegistrationCode> util = new ExcelUtil<RegistrationCode>(RegistrationCode.class);
        return util.exportExcel(list, "注册码绑定数据");
    }

    /**
     * 新增注册码绑定
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存注册码绑定
     */
    @RequiresPermissions("system:code:add")
    @Log(title = "注册码绑定", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RegistrationCode registrationCode)
    {
        return toAjax(registrationCodeService.insertRegistrationCode(registrationCode));
    }

    /**
     * 修改注册码绑定
     */
    @RequiresPermissions("system:code:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RegistrationCode registrationCode = registrationCodeService.selectRegistrationCodeById(id);
        mmap.put("registrationCode", registrationCode);
        return prefix + "/edit";
    }

    /**
     * 修改保存注册码绑定
     */
    @RequiresPermissions("system:code:edit")
    @Log(title = "注册码绑定", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RegistrationCode registrationCode)
    {
        return toAjax(registrationCodeService.updateRegistrationCode(registrationCode));
    }

    /**
     * 删除注册码绑定
     */
    @RequiresPermissions("system:code:remove")
    @Log(title = "注册码绑定", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(registrationCodeService.deleteRegistrationCodeByIds(ids));
    }
}
