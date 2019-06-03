package com.itheima.Controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        if (!"".equals(product.getDepartureTime())&&!"".equals(product.getProductPrice())){
            productService.saveProduct(product);
            return "redirect:findAll";
        }else {
            return "saveProduct";
        }
    }

    @RequestMapping("/deleteSelect")
    public String  deleteSelect(@RequestParam(name="ids",required = true) String[] ids)throws Exception{
        productService.deleteIds(ids);
        return "redirect:findAll";
    }



    @RequestMapping("/findAll")
    @RolesAllowed("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name="pageSize",required = true,defaultValue = "4")Integer pageSize,@RequestParam(name="sth",required = true,defaultValue = "null")String sth)throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Product> products = productService.findAll(page,pageSize,sth);
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("sth",sth);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/deleteOne")
    public String  deleteOne(String id)throws Exception{
        productService.deleteOne(id);
        return "redirect:findAll";
    }

    @RequestMapping("/findByPnum")
    public @ResponseBody boolean findByPnum(@RequestBody Product product) throws Exception {
        System.out.println("异步请求");
        System.out.println(product);
        product = productService.findByPnum(product);

        if (product==null){
            return false;
        }else{
            return true;
        }


    }
    @RequestMapping("/updateStatusClose")
    public String  updateStatusClose(@RequestParam(name="ids",required = true) String[] ids)throws Exception{
        productService.updateStatusClose(ids);
        return "redirect:findAll";
    }


    @RequestMapping("/updateStatusOpen")
    public String  updateStatusOpen(@RequestParam(name="ids",required = true) String[] ids)throws Exception{
        productService.updateStatusOpen(ids);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name="id",required = true )String id)throws Exception{
       Product product=productService.findByPid(id);
       ModelAndView mv=new ModelAndView();
       mv.addObject("product",product);
       mv.setViewName("updateProduct");
       return mv;
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(Product product)throws Exception{
            productService.updateProduct(product);
            return "redirect:findAll";

    }

    @RequestMapping("/findAllForOrder")

    public ModelAndView findAllForOrder()throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Product> products = productService.findAllForOrder();
        mv.addObject("products",products);
        mv.setViewName("save-orders");
        return mv;
    }
}

