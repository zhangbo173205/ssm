package com.itheima.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zb
 * @description
 * @date 2019/5/25
 */

public class DefaultController {



    protected String redirect(@PathVariable("path") String path) {//@PathVariable 将路径传入参数
        return path;
    }
}
