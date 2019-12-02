package com.xinghuo.controller;

import com.xinghuo.pojo.TbUser;
import com.xinghuo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 姜爽
 * @Date 8:11 2019/11/28
 * @Description  登陆
 */
@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;
    @RequestMapping("/logincheck")
    @ResponseBody
    public TbUser loginCheckController(@RequestBody TbUser tbUser, HttpServletRequest request) {
        if(     tbUser==null
                ||(tbUser.getUserName()==null||"".equals(tbUser.getUserName()))
                ||(tbUser.getPassword()==null||"".equals(tbUser.getPassword()))
                ||(tbUser.getRole()==null||"".equals(tbUser.getRole()))
        )
            return null;
       /* Map<String,Object> objectMap=(HashMap<String,Object>)request.getSession().getAttribute("user");
        //若是用户已经登录则拒绝重复登录,在此处认为username是唯一值
        if(objectMap != null && objectMap.get(tbUser.getUserName()) != null) return null;*/


        TbUser tempUser = tbUserService.showUserByNameService(tbUser.getUserName());

        if(tempUser==null) return null;

        if(!tempUser.getPassword().equals(tbUser.getPassword())) return null;

        request.getSession().setAttribute("user",tempUser);

        /*if(objectMap != null){
            objectMap.put(tbUser.getUserName(),tempUser);
        }else{
            Map<String,Object> objectMaptmp=new HashMap<>();
            objectMaptmp.put(tbUser.getUserName(),tempUser);
            request.getSession().setAttribute("user",objectMaptmp);
        }*/
        return tempUser;
    }
    @RequestMapping("/changePass")
    @ResponseBody
    public String changePassword(@RequestBody TbUser tbUser) {
        int result = tbUserService.updateUserService(tbUser);
        if (result > 0) {
            return "success";
        } else {
            return "false";
        }
    }
}
