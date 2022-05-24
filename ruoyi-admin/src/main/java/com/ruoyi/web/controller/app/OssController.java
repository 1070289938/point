package com.ruoyi.web.controller.app;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("app/oss")
public class OssController {


    @GetMapping("getStsToken")
    public Object getStsToken() {
        //构建一个阿里云客户端，用于发起请求。
        //设置调用者（RAM用户或RAM角色）的AccessKey ID和AccessKey Secret。
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5t8oD3bJL6CYVzsB9b3D", "SqFPWJLuGOZnXozUJRKBpXTUBpYLoR");
        IAcsClient client = new DefaultAcsClient(profile);
        //构造请求，设置参数。关于参数含义和设置方法，请参见《API参考》。
        AssumeRoleRequest request = new AssumeRoleRequest();
        request.setRegionId("cn-hangzhou");
        request.setRoleArn("acs:ram::1626673180087406:role/aliyunosstokengeneratorrole");
        request.setRoleSessionName("external-username");
        //发起请求，并得到响应。
        try {
            AssumeRoleResponse response = client.getAcsResponse(request);
            AssumeRoleResponse.Credentials credentials = response.getCredentials();
            Map<String, Object> map = new HashMap<>();
            map.put("StatusCode", 200);
            map.put("AccessKeyId", credentials.getAccessKeyId());
            map.put("AccessKeySecret", credentials.getAccessKeySecret());
            map.put("SecurityToken", credentials.getSecurityToken());
            map.put("Expiration", credentials.getExpiration());
            return map;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            //错误返回
            Map<String, Object> map = new HashMap<>();
            map.put("StatusCode", 500);
            map.put("ErrorCode", "InvalidAccessKeyId.NotFound");
            map.put("ErrorMessage", "Specified access key is not found.");
            return map;
        }


    }


}
