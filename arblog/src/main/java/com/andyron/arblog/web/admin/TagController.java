package com.andyron.arblog.web.admin;

import com.andyron.arblog.po.Tag;
import com.andyron.arblog.service.TagService;
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
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 5, sort ={"id"}, direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model) {
        model.addAttribute("page", tagService.listTag( pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes redirectAttributes) {

        if(tagService.getTagByName(tag.getName()) != null) {
            result.rejectValue("name", "nameError", "不能添加重复的标签");
        }

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        Tag t = tagService.saveTag(tag);
        if (t == null) {
            redirectAttributes.addFlashAttribute("message", "新增失败");
        } else  {
            redirectAttributes.addFlashAttribute("message", "新增成功");

        }
        return "redirect:admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result, @PathVariable Long id,
                           RedirectAttributes redirectAttributes) {

        if(tagService.getTagByName(tag.getName()) != null) {
            result.rejectValue("name", "nameError", "不能添加重复的标签");
        }

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        Tag t = tagService.updateTage(id, tag);
        if (t == null) {
            redirectAttributes.addFlashAttribute("message", "新增失败");
        } else  {
            redirectAttributes.addFlashAttribute("message", "新增成功");

        }
        return "redirect:admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(Long id, RedirectAttributes redirectAttributes) {
        tagService.deleteTage(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:admin/tags";
    }
}
