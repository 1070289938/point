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
import com.ruoyi.system.domain.QueryKeyword;
import com.ruoyi.system.service.IQueryKeywordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 热门查询关键词Controller
 *
 * @author ruoyi
 * @date 2022-06-08
 */
@Controller
@RequestMapping("/system/keyword")
public class QueryKeywordController extends BaseController
{
    private String prefix = "system/keyword";

    @Autowired
    private IQueryKeywordService queryKeywordService;

    @RequiresPermissions("system:keyword:view")
    @GetMapping()
    public String keyword()
    {
        return prefix + "/keyword";
    }

    /**
     * 查询热门查询关键词列表
     */
    @RequiresPermissions("system:keyword:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QueryKeyword queryKeyword)
    {
        startPage();
        List<QueryKeyword> list = queryKeywordService.selectQueryKeywordList(queryKeyword);
        return getDataTable(list);
    }

    /**
     * 导出热门查询关键词列表
     */
    @RequiresPermissions("system:keyword:export")
    @Log(title = "热门查询关键词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QueryKeyword queryKeyword)
    {
        List<QueryKeyword> list = queryKeywordService.selectQueryKeywordList(queryKeyword);
        ExcelUtil<QueryKeyword> util = new ExcelUtil<QueryKeyword>(QueryKeyword.class);
        return util.exportExcel(list, "热门查询关键词数据");
    }

    /**
     * 新增热门查询关键词
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存热门查询关键词
     */
    @RequiresPermissions("system:keyword:add")
    @Log(title = "热门查询关键词", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QueryKeyword queryKeyword)
    {
        return toAjax(queryKeywordService.insertQueryKeyword(queryKeyword));
    }

    /**
     * 修改热门查询关键词
     */
    @RequiresPermissions("system:keyword:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        QueryKeyword queryKeyword = queryKeywordService.selectQueryKeywordById(id);
        mmap.put("queryKeyword", queryKeyword);
        return prefix + "/edit";
    }

    /**
     * 修改保存热门查询关键词
     */
    @RequiresPermissions("system:keyword:edit")
    @Log(title = "热门查询关键词", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QueryKeyword queryKeyword)
    {
        return toAjax(queryKeywordService.updateQueryKeyword(queryKeyword));
    }

    /**
     * 删除热门查询关键词
     */
    @RequiresPermissions("system:keyword:remove")
    @Log(title = "热门查询关键词", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(queryKeywordService.deleteQueryKeywordByIds(ids));
    }
}
