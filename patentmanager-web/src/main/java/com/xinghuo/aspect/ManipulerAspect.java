package com.xinghuo.aspect;

import com.xinghuo.pojo.TbFlow;
import com.xinghuo.pojo.TbUser;
import com.xinghuo.service.TbFlowService;
import com.xinghuo.target.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class ManipulerAspect {

    @Autowired
    private TbFlowService tbFlowService;

    @Pointcut("@annotation(com.xinghuo.target.Action)")
    public void manipuler() {

    }
    /**
     * 前置通知：在连接点之前执行的通知
     */

    @After("manipuler()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取当前登陆的用户名和时间
        HttpSession session = request.getSession();
        Object object=request.getSession().getAttribute("user");
        String userName= object==null?"未知用户操作":((TbUser) object).getUserName();
        String tempPatentId = (String) session.getAttribute("patentId");
        int patentId = Integer.valueOf(tempPatentId);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        TbFlow tbFlow = new TbFlow();
        if (action.name().equals("add")) {
            tbFlow.setPatentId(patentId);
            tbFlow.setEditUser(userName);
            tbFlow.setEditSelectioin("增加");
            tbFlow.setFlowDate(new Date());
            tbFlowService.addTbFlowService(tbFlow);
        } else if (action.name().equals("change")) {
            tbFlow.setPatentId(patentId);
            tbFlow.setEditUser(userName);
            tbFlow.setEditSelectioin("修改");
            tbFlow.setFlowDate(new Date());
            tbFlowService.addTbFlowService(tbFlow);
        } else if (action.name().equals("upfile")) {
            tbFlow.setPatentId(patentId);
            tbFlow.setEditUser(userName);
            tbFlow.setEditSelectioin("上传文件");
            tbFlow.setFlowDate(new Date());
            tbFlowService.addTbFlowService(tbFlow);
        }
    }

}

