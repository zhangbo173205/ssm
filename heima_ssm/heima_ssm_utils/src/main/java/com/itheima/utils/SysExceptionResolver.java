package com.itheima.utils;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zb
 * @description
 * @date 2019/6/1
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        if (e instanceof RuntimeException){
            ModelAndView mv=new ModelAndView();
            //mv.addObject("error",e.getMessage());
            mv.setViewName("error");
            return mv;
        }
        e=new Exception("服务器正忙");
        ModelAndView mv=new ModelAndView();
        //mv.addObject("error",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
