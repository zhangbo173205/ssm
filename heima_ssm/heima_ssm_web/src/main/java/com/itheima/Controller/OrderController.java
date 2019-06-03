package com.itheima.Controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zb
 * @description
 *
 * @date 2019/5/26
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @Autowired
    public ProductService productService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize, String sth) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Orders> orders = orderService.finAll(page, pageSize, sth);
        PageInfo<Orders> pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping(value = {"/findByNum"}, params = "orderNum")
    public ModelAndView findByNum(String orderNum) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders order = orderService.findByNum(orderNum);
        mv.addObject("orders", order);
        mv.setViewName("orders-show");
        return mv;
    }
    @RequestMapping(value = {"/findByNum1"}, params = "orderNum")
    public ModelAndView findByNum1(String orderNum) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders order = orderService.findByNum(orderNum);
        List<Product> products = productService.findAllForOrder();
        mv.addObject("orders", order);
        mv.addObject("products",products);
        mv.setViewName("update-orders");
        return mv;
    }



    @RequestMapping("/findOrdersByPid")
    public ModelAndView findOrdersByPid(@RequestParam(name ="id",required=true)String id)throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Orders> orders = orderService.findOrdersByPid(id);
        mv.addObject("orderList",orders);
        mv.setViewName("product-order");
        return mv;
    }

    @RequestMapping("/deleteSelect")
    public String  deleteSelect(@RequestParam(name="ids",required = true) String[] ids)throws Exception{
        orderService.deleteIds(ids);
        return "redirect:findAll";
    }

    @RequestMapping("/deleteById")
    public String deleteById(String id)throws Exception{
        orderService.deleteById(id);
        return "redirect:findAll";
    }

    @RequestMapping("/saveOrders")
    public String saveOrders(Orders order)throws Exception{
            orderService.saveOrders(order);
            return "redirect:findAll";

    }


    @RequestMapping("/updateOrders")
    public String updateOrders(Orders order)throws Exception{
        orderService.updateOrders(order);
        return "redirect:findAll";

    }

    @RequestMapping("/peoplenum")
    public @ResponseBody Orders peoplenum(@RequestBody Orders order){
       /* int number = Integer.parseInt(num.split("=")[1]);
        Orders order=new Orders();
        order.setPeopleCount(number);*/
        return order;

    }
}
