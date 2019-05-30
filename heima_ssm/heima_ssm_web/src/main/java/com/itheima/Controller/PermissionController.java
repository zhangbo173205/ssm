package com.itheima.Controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/29
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    public PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") int pageSize, String sth) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Permission> list = permissionService.findAll(page, pageSize, sth);
        PageInfo<Permission> pageInfo=new PageInfo<>(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;


    }

    @RequestMapping("save")
    public String save(Permission p) throws Exception {
        permissionService.save(p);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id)throws Exception{
        ModelAndView mv = new ModelAndView();
        Permission p = permissionService.findById(id);
        mv.addObject("permission", p);
        mv.setViewName("Permission-show");
        return mv;
    }
}
