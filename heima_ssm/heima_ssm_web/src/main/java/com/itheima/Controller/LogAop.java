package com.itheima.Controller;

import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zb
 * @description
 * @date 2019/5/31
 */

@Aspect
public  class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date visiteTime; //开始时间
    private Class clazz;    //访问的类
    private Method method;  //访问的方法

    /**
     * 前置通知,主要是获取开始时间,执行类是哪一个.执行的是哪一个方法
     * @param jp
     */
    @Before("execution(* com.itheima.Controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception {
        //System.out.println(111111);
        visiteTime=new Date();
        clazz=jp.getTarget().getClass();//其他访问的类
        String methodName=jp.getSignature().getName();//获取方法方法的名称
        Object[] args = jp.getArgs();
        if (args==null|| args.length==0){
            method = clazz.getMethod(methodName); //获取无参的方法
        }else{
           Class[] classArgs=new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i]!=null) {
                    classArgs[i] = args[i].getClass();
                }else{
                    classArgs[i] = String.class;
                }
            }
            method=clazz.getMethod(methodName,classArgs);  //获取有参的方法
        }


    }

    /**
     *
     * @param jp
     *
     */
    @After("execution(* com.itheima.Controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        //System.out.println(22222222);
        long time=new Date().getTime()-visiteTime.getTime();

        //获取url
        if (clazz!=null&&method!=null&&clazz!=LogAop.class){
            RequestMapping classAnno =(RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnno!=null){
                String classValue= classAnno.value()[0];
                //获取方法上的requestMapping对象
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String methodvalue = methodAnnotation.value()[0];
                    String url="";
                    url=classValue+methodvalue;
                    //获取访问的ip地址
                    String ip = request.getRemoteAddr();
                    //获取当前的用户
                    SecurityContext context = SecurityContextHolder.getContext(); //获取上下文中的user
                    User principal =(User) context.getAuthentication().getPrincipal();
                    String username = principal.getUsername();
                    SysLog sysLog=new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visiteTime);
                    sysLogService.save(sysLog);
                }
            }
        }

    }
}
