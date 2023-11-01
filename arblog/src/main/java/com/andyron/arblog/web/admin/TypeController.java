package com.andyron.arblog.web.admin;

import com.andyron.arblog.po.Type;
import com.andyron.arblog.service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Andy Ron
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
       列表
     */
    @GetMapping("/types")
    public String types(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    /**
     * 新增页面
     */
    @GetMapping("/types/input")
    public String input(Model model) {
        Type t = new Type();
        model.addAttribute("type", t);
        return "admin/types-input";
    }

    /**
     * 修改页面
     */
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    /**
     * 新增操作
        @Valid为了让验证输出到页面，BindingResult存储验证的结果，这两者要挨着，要不然会没效果
     */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes redirectAttributes) {

        if (typeService.getTypeByName(type.getName()) != null) {
            // 第一个参数必须是要验证的字段名，第二个参数自定义，第三个参数是返回给前端的错误信息
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        Type t = typeService.saveType(type);
        if (t == null) {
            redirectAttributes.addFlashAttribute("message", "新增失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "新增成功");
        }

        return "redirect:/admin/types";
    }

    /**
     * 修改操作
     */
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,@PathVariable Long id,
                           RedirectAttributes redirectAttributes) {

        if (typeService.getTypeByName(type.getName()) != null) {
            // 第一个参数必须是要验证的字段名，第二个参数自定义，第三个参数是返回给前端的错误信息
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        Type t = typeService.updateType(id, type);
        if (t == null) {
            redirectAttributes.addFlashAttribute("message", "更新失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "更新成功");
        }

        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        typeService.deleteType(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}
