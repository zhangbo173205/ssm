package com.itheima.Controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true ,defaultValue="1") int page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "4") int pageSize ,String sth)throws Exception{

        ModelAndView mv=new ModelAndView();
        List<Orders> orders = orderService.finAll(page,pageSize,sth);
        PageInfo<Orders> pageInfo=new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping(value={"/findByNum"},params = "orderNum")
    public  ModelAndView findDetail(String orderNum)throws Exception{
        ModelAndView mv=new ModelAndView();
        Orders order = orderService.findByNum(orderNum);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }
}
