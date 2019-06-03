package com.itheima.Controller;



import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.RoleService;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
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
 * @date 2019/5/29
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    public RoleService roleService;


    @RequestMapping("/deletePermissionWithRole")
    public void deletePermissionWithRole(String pid, String rid,String uid, HttpServletRequest request, HttpServletResponse response) throws Exception{
        roleService.deletePermissionWithRole(rid,pid);
        if (uid!=null&&uid.length()>0&&!"null".equals(uid)) {
            response.sendRedirect(request.getContextPath() + "/user/findById?id=" + uid);
        }else{
            response.sendRedirect(request.getContextPath() + "/permission/findById?id="+pid);
        }
    }


    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name="pageSize",required = true,defaultValue = "4")Integer pageSize,@RequestParam(name="sth",required = true,defaultValue = "null")String sth) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Role> roles = roleService.findAll(page, pageSize, sth);
        PageInfo<Role> pageInfo=new PageInfo<>(roles);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }


    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/save")
    public String save( Role role) throws Exception {
        if (!"".equals(role.getRoleDesc())&&!"".equals(role.getRoleName())){
            roleService.save(role);
            return "redirect:findAll";
        }else {
            return "role-add";
        }

    }

    @RequestMapping("/deleteById")
    public String deleteById(String id) throws Exception {
        roleService.deleteById(id);
        return "redirect:findAll";
    }

/*    @RequestMapping("/deleteById")
    public String deleteById(String id) throws Exception {
        userService.deleteById(id);
        return "redirect:findAll";
    }*/

    /**
     * 查询出指定的Role和他没有绑定的权限
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name="id",required = true) String rid) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(rid);
        List<Permission> otherPermission = roleService.findOtherPermission(rid);
        mv.addObject("role",role);
        mv.addObject("pList",otherPermission);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * 添加权限到指定role中
     * @param rid
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String rid,@RequestParam(name="ids",required = true) String[] ids) throws Exception {
        roleService.addPermissionToRole(rid,ids);
        return "redirect:findAll";
    }


}
