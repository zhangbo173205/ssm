package com.itheima.Controller;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;


    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") int pageSize, String sth) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll(page, pageSize, sth);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(users);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("sth", sth);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("save")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();

        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;

    }

    @RequestMapping("/deleteRoleWithUser")
    public void deleteRoleWithUser(String rid, String uid,HttpServletResponse response,HttpServletRequest request) throws Exception {
        userService.deleteRoleByUid(rid, uid);
        response.sendRedirect(request.getContextPath()+"/user/findById?id="+uid);


    }

    @RequestMapping("/updateStatus")
    public String updateStatus(String id) throws Exception {
          userService.updateStatus(id);
        return "redirect:findAll";
    }

    @RequestMapping("/deleteById")
    public String deleteById(String id) throws Exception {
      userService.deleteById(id);
        return "redirect:findAll";
    }

    @RequestMapping("findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id",required = true) String uid) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(uid);
        List<Role> otherRole = userService.findOtherRole(uid);
        mv.addObject("user", userInfo);
        mv.addObject("roleList",otherRole);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,String[] ids) throws Exception {
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll";
    }
}
