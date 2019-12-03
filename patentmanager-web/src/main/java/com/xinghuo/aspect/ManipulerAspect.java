package com.xinghuo.aspect;

import com.xinghuo.pojo.TbFlow;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.pojo.TbUser;
import com.xinghuo.service.TbFlowService;
import com.xinghuo.service.UserPatentService;
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

//@Aspect
@Component
public class ManipulerAspect {

    @Autowired
    private TbFlowService tbFlowService;

    @Autowired
    private UserPatentService userPatentService;

    @Pointcut("@annotation(com.xinghuo.target.Action)")
    public void maniPuler() {

    }
    /**
     * 前置通知：在连接点之前执行的通知
     */

    @After("maniPuler()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        TbFlow tbFlow = null;
        /**
         * 获取request对象
         */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String userName = "未知用户";
        int patentId = 1;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        if (action.name().equals("add")) {
            tbFlow = new TbFlow("新建专利",userName,new Date(),patentId,0);
            tbFlowService.addTbFlowService(tbFlow);
        } else if (action.name().equals("change")) {
            tbFlow = new TbFlow("修改专利",userName,new Date(),patentId,0);
            tbFlowService.addTbFlowService(tbFlow);
        } else if (action.name().equals("upfile")) {
            tbFlow = new TbFlow("上传文件",userName,new Date(),patentId,0);
            tbFlowService.addTbFlowService(tbFlow);
        } else if(action.name().equals("select")) {
            tbFlow = new TbFlow("查询专利",userName,new Date(),patentId,1);
            tbFlowService.addTbFlowService(tbFlow);
        } else if(action.name().equals("reconn")) {
            tbFlow = new TbFlow("认领专利", userName, new Date(), patentId, 1);
            tbFlowService.addTbFlowService(tbFlow);
        } else if(action.name().equals("regeter")) {
            tbFlow = new TbFlow("驳回申请", userName, new Date(), patentId, 1);
            tbFlowService.addTbFlowService(tbFlow);
        }
    }

}

