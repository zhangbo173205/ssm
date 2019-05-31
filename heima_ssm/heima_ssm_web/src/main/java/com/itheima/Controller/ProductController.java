package com.itheima.Controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;


/**
 * @author zb
 * @description
 * @date 2019/5/25
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/saveProduct")
    public String saveProduct(Product product)throws Exception{
        productService.saveProduct(product);
        return "redirect:findAll";

    }

    @RequestMapping("/delectSelect")
    public String  delectSelect(String[] ids)throws Exception{
        productService.deleteIds(ids);
        return "redirect:findAll";
    }



    @RequestMapping("/findAll")
    @RolesAllowed("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") int page,
                                @RequestParam(name="pageSize",required = true,defaultValue = "4")int pageSize,String sth)throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Product> products = productService.findAll(page,pageSize,sth);
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("sth",sth);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/delectOne")
    public String  delectOne(String id)throws Exception{
        productService.deleteOne(id);
        return "redirect:findAll";
    }





}

