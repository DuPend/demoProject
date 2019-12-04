package com.xinghuo.controller;

import com.github.pagehelper.Page;
import com.xinghuo.common.utils.TokenUtil;
import com.xinghuo.pojo.*;
import com.xinghuo.service.*;
import com.xinghuo.target.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author:段炼 和于悦 on 2019/11/22 17:36
 * @param:
 * @return:
 * @description:专利的各种查询
 */
@RestController
public class UserPatentController {
    @Autowired
    private UserPatentService userPatentService;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private TbPlanService tbPlanService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private TbSearchService tbSearchService;

    /**
    *@Author:Yuyue
    *@Description:查询当前用户认领的专利列表
    *@Date:14:26  2019/12/3
    *@Param:
    *@Return: 用户所有被认领的专利
    */
    @RequestMapping("UserPatent")
    public PageInfo<TbPatent> getPatentByUser(@RequestParam(defaultValue = "1", value = "currentPage")int page,
                                                @RequestParam(defaultValue = "10", value = "pageSize")int rows,HttpServletRequest request)
            throws Exception {
        //通过token获取userId
        String token=request.getHeader("token");
        Map<String,String> map= TokenUtil.verifyToken(token);
        Integer userId = Integer.valueOf(map.get("userid"));
        if (userId == null || page == 0 || rows == 0 || tbUserService.selectUser(userId) == null) {
            return null;
        }
            Page<TbPatent> indicatorList = userPatentService.getPatentByUser(userId, page, rows);
            PageInfo<TbPatent> pageInfo = new PageInfo<>(indicatorList);
            return pageInfo;
    }

    /**
     * @Author:Yuyue
     * @Description:查询用户撰写后，未通过的专利
     * @Date:15:19 2019/11/24
     * @Param:
     * @Return:
     */
    @GetMapping("FailPatent")
    public PageInfo<TbPatent> getFailPatentByUser(
                                              @RequestParam(defaultValue = "1", value = "currentPage")int page,
                                              @RequestParam(defaultValue = "10", value = "pageSize")int rows,HttpServletRequest request)
            throws Exception {
        String token=request.getHeader("token");
        Map<String,String> map= TokenUtil.verifyToken(token);
        Integer userId = Integer.valueOf(map.get("userid"));
        if (userId == null || page == 0 || rows == 0 || tbUserService.selectUser(userId) == null) {
            return null;
        } else {
            Page<TbPatent> indicatorList = userPatentService.getFailPatentByUser(userId, page, rows);
            PageInfo<TbPatent> pageInfo = new PageInfo<>(indicatorList);
            return pageInfo;
        }
    }

    /**
     * @Author:Yuyue
     * @Description:查询专利详情
     * @Date:21:07 2019/11/21
     * @Param: * @param 专利id
     * @Return:
     */
    @RequestMapping("PatentDetail")
    public ResponseMessage getPatentById(Integer patentId) {
        /*System.out.println("dasdasadad"+userPatentService.getPatentById(patentId).toString());*/
        if (patentId == null || !userPatentService.selectPatent(patentId)) {
            return ResponseMessage.paramError();
        }
        return ResponseMessage.ok(userPatentService.getPatentById(patentId));
    }

    /**
     * @Author:Yuyue
     * @Description:修改专利内容
     * @Date:21:12 2019/11/21
     * @Param:
     * @Return:
     */
    @RequestMapping("updatePatent")
    @Action(name = "change")
    public ResponseMessage updatePatentById(@RequestBody TbPatent tbPatent) {
        if (tbPatent == null || !userPatentService.selectPatent(tbPatent.getPatentId())) {
            return ResponseMessage.paramError();
        }
        //获取session
        HttpSession httpSession = httpServletRequest.getSession();
        //获取当前专利的id
        httpSession.setAttribute("patentId", tbPatent.getPatentId().toString());
        System.out.println(tbPatent.getPatentId());
        if (tbPatent.getPatentId() != null) {
            try {
                userPatentService.updatePatentById(tbPatent);
                return ResponseMessage.ok();
            } catch (Exception e) {
                return ResponseMessage.error("修改失败！");
            }
        } else {
            return ResponseMessage.error("修改失败！");
        }
    }

    @PostMapping(value="uploadFile")
    @Action(name = "upfile")
    public @ResponseBody ResponseMessage uploadFile(@RequestParam("files") MultipartFile[] files, Integer patentId, Integer typeId,
                      HttpServletRequest request) {
        if (files == null || files.length <=0) {
            return ResponseMessage.error( "文件为空");
        }
            if(patentId == null || typeId ==null || !userPatentService.selectPatent(patentId)) {
                return ResponseMessage.paramError();
        }
       ResponseMessage responseMessage = uploadFileService.uploadFiles(files,patentId,typeId,request);
        /*
         * @Author 姜爽
         * @Date 8:11 2019/11/28
         * @Description  将专利id存入session
         **/
        //获取session
        HttpSession httpSession = httpServletRequest.getSession();
        //获取当前专利的id
        httpSession.setAttribute("patentId", patentId.toString());
        //如果上传成功
        if (responseMessage.isSuccess()) {
            //根据patentID查询当前进度
            int planId = userPatentService.findPatentById(patentId).getPlanId();
            //如果当前进度为交底书撰写中
            if (typeId == 1 && tbPlanService.findPlanByContent("交底书撰写中") == planId) {
                //修改进度为第一次审核;
                return updatePatentPlan(patentId,planId);
            } else {
                return ResponseMessage.ok();
            }

        } else {
            return responseMessage;
        }

    }

    /**
     * @Author:Yuyue
     * @Description:用户查询文件信息，只显示所有类别最新的文件
     * @Date:17:42 2019/11/22
     * @Param: 专利id
     * @Return: 返回文件list
     */
    @RequestMapping("SelectLatestDocument")
    List<TbDocument> selectLatestDocumentById(Integer patentId) {
        if(patentId ==null || !userPatentService.selectPatent(patentId)) {
            return null;
        }
        return userPatentService.selectLatestDocumentById(patentId);
    }

    /**
     * @Author:Yuyue
     * @Description:管理员查询出所有当前专利的文件
     * @Date:17:42 2019/11/22
     * @Param: 专利id
     * @Return: 返回文件list
     */
    @RequestMapping("SelectAllDocument") List<TbDocument> selectAllDocumentById(Integer patentId) {
        if (patentId == null || !userPatentService.selectPatent(patentId)) {
         return null;
        }
        return userPatentService.selectAllDocumentById(patentId);
    }

    /**
     * @Author:Yuyue
     * @Description:修改专利的进度
     * @Date:14:53 2019/11/24
     * @Param: 当前专利进度id，专利id
     * @Return:
     */
    @RequestMapping("updateplan")
        public ResponseMessage updatePatentPlan(Integer patentId,Integer planId) {
        if (patentId == null || planId == null || !userPatentService.selectPatent(patentId)) {
            return ResponseMessage.paramError();
        }
        try {
        TbPatent tbPatent = new TbPatent();
        if (tbPlanService.findPlanByContent("新建专利").equals(planId)) {
            tbPatent.setPatentId(patentId);
            tbPatent.setPlanId(tbPlanService.findPlanByContent("新建专利待审核"));
            userPatentService.updatePatentPlan(tbPatent);
            return ResponseMessage.ok();
        } else if (tbPlanService.findPlanByContent("方案讨论中").equals(planId)){
            tbPatent.setPatentId(patentId);
            tbPatent.setPlanId(tbPlanService.findPlanByContent("交底书撰写中"));
            userPatentService.updatePatentPlan(tbPatent);
            return ResponseMessage.ok();
        }else if (tbPlanService.findPlanByContent("交底书撰写中").equals(planId)){
            tbPatent.setPatentId(patentId);
            tbPatent.setPlanId(tbPlanService.findPlanByContent("第一次审核"));
            userPatentService.updatePatentPlan(tbPatent);
            return ResponseMessage.ok();
        }else{
            return ResponseMessage.error("当前进度无法手动修改！" );
        }
        } catch (Exception e) {
            return ResponseMessage.error("修改进度失败！");
        }
    }




    /**
     *@Author:duanlian
     *@param:
     *@return:
     *@description:所有专利
     */
    @RequestMapping("/findAll")
    public PageInfo<TbPatent> findAll(
            @RequestParam(defaultValue = "1", value = "currentPage")int page,
            @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbPatent> list = userPatentService.findAll(page, rows);
        PageInfo<TbPatent> pageInfo = new PageInfo<>(list);
        return  pageInfo;

    }


    /**
     *@Author:duanlian
     *@param:
     *@return:
     *@description:某专利的详细信息
     */
    @RequestMapping("/findDetail")
    public List<TbPatent> findDetail(Integer patentId) {
        List<TbPatent> list = userPatentService.findDetail(patentId);
        return list;
    }


    /**
     *@Author:duanlian
     *@param:
     *@return:
     *@description:条件查询
     */
    @RequestMapping("/findCondition")
    public List<TbPatent> findCondition(TbPatent patent) {
        List<TbPatent> list = tbSearchService.findCondition(patent);
        return list;
    }


    @RequestMapping("/updateCondition")
    @Action(name = "change")
    public ResponseMessage update( TbPatent tbPatent,HttpServletRequest request) throws Exception {
        System.out.println("已进入");
        int planId = userPatentService.state(tbPatent.getPatentId());
        if (planId != 2) {
            return  ResponseMessage.error("该专利已被认领，请刷新页面",500);
        } else {
            Map<String,String> map = TokenUtil.verifyToken(request.getHeader("token"));
            String writerId = map.get("userid");
            tbPatent.setWriterId(Integer.valueOf(writerId));
            int result = userPatentService.update(tbPatent);
            //获取session
            HttpSession httpSession = httpServletRequest.getSession();
            //获取当前专利的id
            httpSession.setAttribute("patentId", tbPatent.getPatentId().toString());
            if (result >= 1) {
                /**修改成功**/
                return  ResponseMessage.ok(200);
            } else {
                return ResponseMessage.error("修改失败",500);
            }
        }
    }

}