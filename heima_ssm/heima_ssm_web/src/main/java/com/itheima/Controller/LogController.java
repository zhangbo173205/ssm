package com.itheima.Controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/31
 */
@Controller
@RequestMapping("/syslog")
public class LogController {

    @Autowired
    public SysLogService sysLogService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize, String sth) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs= sysLogService.findAll(page, pageSize, sth);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("sth", sth);
        mv.setViewName("syslog-list");
        return mv;
    }

    @RequestMapping("/deleteSelect")
    public String  deleteSelect(@RequestParam(name="ids",required = true) String[] ids)throws Exception{
        sysLogService.deleteIds(ids);
        return "redirect:findAll";
    }

    @RequestMapping("/deleteAll")
    public String  deleteAll()throws Exception{
        sysLogService.deleteAll();
        return "redirect:findAll";
    }
}
