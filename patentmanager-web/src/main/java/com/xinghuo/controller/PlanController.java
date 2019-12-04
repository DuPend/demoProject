package com.xinghuo.controller;

import com.xinghuo.pojo.Result;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.TbPlanService;
import com.xinghuo.service.UserPatentService;
import com.xinghuo.target.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:管理员审核专利
 * @Author: LiuJian
 * @Date: 2019/11/21 0021 17:24
 * @Version: V1.0
 */
@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private UserPatentService userPatentService;

    @Autowired
    private TbPlanService planService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //根据进度内容查询进度id
    public Integer selectPlanId(String planContent) {
        /**
         * @Description:根据进度内容查询进度id
         * @Author: LiuJian
         * @Date: 2019/11/22 0022 10:51
         * @Param: [planContent]
         * @Return: java.lang.Integer
         */
        return planService.findPlanByContent(planContent);
    }

    //审核专利
    @Action(name = "check")
    @RequestMapping("/checkPatent")
    public Result checkPatent(Integer patentId, Integer flag) {
       /**
        * @Description: 管理员对专利各个阶段的审核
        * @Author: LiuJian
        * @Date: 2019/11/22 0022 11:29
        * @Param: [patentId, flag]
        * @Return: com.xinghuo.entity.Result
        */
        //获取session
        HttpSession httpSession = httpServletRequest.getSession();
        //获取当前专利的id
        httpSession.setAttribute("patentId", patentId.toString());
        Result result = new Result(false, null);
        //根据专利id查询专利信息
        TbPatent tbPatent = userPatentService.findPatentById(patentId);
        //查询当前专利的进度id
        int planId = tbPatent.getPlanId();
        //定义变量--正常
        String agree = "正常";

        //判断是否通过
        try {
            //新建专利后的初审
            if (planId == selectPlanId("新建专利待审核")) {
                //flag==0时为通过
                if (flag == 0) {
                    //查询进度Id并设置在专利属性中
                    tbPatent.setPlanId(selectPlanId("待认领"));
                    //根据专利id修改状态表对应专利的状态
                    planService.updateStatus(patentId, agree);
                    result.setMessage("通过");
                } else {
                    tbPatent.setPlanId(selectPlanId("新建专利"));
                    planService.updateStatus(patentId, "新建专利未通过");
                    result.setMessage("未通过");
                }
            }

            //提交撰写书后的第一次审核
            if (planId == selectPlanId("第一次审核")) {
                //flag==0时为通过
                if (flag == 0) {
                    //查询进度Id并设置在专利属性中
                    tbPatent.setPlanId(selectPlanId("第二次审核"));
                    //根据专利id修改状态表对应专利的状态
                    planService.updateStatus(patentId, agree);
                    result.setMessage("通过");
                } else {
                    tbPatent.setPlanId(selectPlanId("交底书撰写中"));
                    planService.updateStatus(patentId, "第一次审核未通过");
                    result.setMessage("未通过");
                }
            }

            //第二次审核
            if (planId == selectPlanId("第二次审核")) {
                //flag==0时为通过
                if (flag == 0) {
                    //查询进度Id并设置在专利属性中
                    tbPatent.setPlanId(selectPlanId("文档维护"));
                    //根据专利id修改状态表对应专利的状态
                    planService.updateStatus(patentId, agree);
                    result.setMessage("通过");
                } else {
                    tbPatent.setPlanId(selectPlanId("交底书撰写中"));
                    planService.updateStatus(patentId, "第二次审核未通过");
                    result.setMessage("未通过");
                }
            }
            result.setSuccess(true);
            //修改专利的进度状态
            userPatentService.updPlan(tbPatent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
