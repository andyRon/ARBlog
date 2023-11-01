package com.andyron.arblog.web;

import com.andyron.arblog.NotFoundException;
import com.andyron.arblog.service.BlogService;
import com.andyron.arblog.service.TagService;
import com.andyron.arblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Andy Ron
 */
@Controller
public class IndexController {

    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @GetMapping({"/hello"})
    @ResponseBody
    public String hello() {
        return "hello, ARBlog";
    }

//    @GetMapping("/{id}/{name}")
//    public String index(@PathVariable Integer id, @PathVariable String name) {
////        int i = 1/0;
////        String blog = null;
////        if (blog == null) {
////            throw new NotFoundException("博客不存在");
////        }
//        System.out.println("--------index---------");
//        return "index";
//    }

    @GetMapping({"/", "/index"})
    public String index(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        return "index";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) {
        model.addAttribute("page", blogService.listBlog("%"+query+"%", pageable));
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog",  blogService.getAndConvert(id));
        return "blog";
    }
}
