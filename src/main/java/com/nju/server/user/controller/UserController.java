package com.nju.server.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.nju.server.admin.entity.Admin;
import com.nju.server.common.okhttp.OkHttpCli;
import com.nju.server.common.response.ApiResult;
import com.nju.server.user.entity.WxUserCode;
import com.nju.server.user.entity.WxUserOpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private OkHttpCli okHttpCli;

    @PostMapping("/openid")
    public ApiResult addAdmin(@RequestBody WxUserCode wxUserCode){

        ApiResult<WxUserOpenId> resp = new ApiResult<>();

        String code = wxUserCode.getCode();

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx7ef15c12db74f6c5&secret=c4bfbfea88ba43ebdd19bf00f4f66aa8&js_code="+ code+"&grant_type=authorization_code";

        String res = okHttpCli.doGet(url);

        JSONObject outJson = JSONObject.parseObject(res);

        if(outJson.containsKey("openid")){
            String openid = (String) outJson.get("openid");
            WxUserOpenId wxUserOpenId= new WxUserOpenId();
            wxUserOpenId.setOpenId(openid);
            resp.setData(wxUserOpenId);
            resp.setMessage("获取到用户openid");
        }else{
            resp.setMessage("没有到用户openid");
        }

        return resp;



    }
}
