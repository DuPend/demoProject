package com.xinghuo.aspect;

import com.xinghuo.common.utils.FileUtil;
import com.xinghuo.pojo.TbLog;
import com.xinghuo.service.TbLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.Date;


//@Aspect
@Component
public class LogsAspect {
    @Autowired
    private TbLogService tbLogService;
    @Value("${visualPath}")
    private String downfile; //下載文件時的ip路徑
    @Value("${savepath}")
    private String savepath; //服務器上的文件實際存儲位置
    /**
     * 前置通知：在连接点之前执行的通知
     */
    @Before("execution(* com.xinghuo.controller..*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String filePath = request.getSession().getServletContext().getRealPath("/") + "/log";
        System.out.println(filePath);
        //获取当前登陆的用户名和时间
        Object object=request.getSession().getAttribute("user");
        String userName= object==null?"未知用户操作":object.toString();
        // 记录下请求内容,首先获取当前日期的log日志文件名称并查询数据库是否存在文件
        if (true) { //用户登陆成功，执行日志记录
            //不存在
            String fileName = FileUtil.getFileName();
            TbLog tbLog = tbLogService.selectLogByNameService(fileName);
            System.out.println(tbLog);
            if (tbLog == null) {
                tbLog = new TbLog();
                tbLog.setLogName(fileName);
                tbLog.setLogAddress(downfile + "log");
                tbLogService.addLogService(tbLog);
            }

            File file = FileUtil.createFile(filePath, fileName);
            String url = request.getRequestURL().toString();
            String httpMethod = request.getMethod();
            String classMethod = joinPoint.getSignature().
                    getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs());
            String message = "/n url:" + url + "/n method:" + httpMethod + "/n getmethod:"
                    + classMethod + "/n args:" + args + "/n username(" + userName + ")" + new Date() + "/n";
            FileUtil.appendMethod(savepath + "/log/" + fileName, message);
        }

    }

}

