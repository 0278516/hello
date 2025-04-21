package com.zs.service;

import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Value;

import static com.aliyun.teautil.Common.toJSONString;

public class AliYunService {

    // 收到形如: [阿里云通知信息]尊敬的{张三}，您好，您的余额已不足10元！
    // [signName] 通知模板替换变量，传参仅为变量 TemplateParam

    // 需要在平台注册 - 签名
    private static final String signName = "阿里云通知信息";

    // 需要在平台注册 - 通知模版
    private static final String templateCode = "SMS_15305";

    @Value("${aliyun.accesskey.id}")
    private String accessKeyId;

    @Value("${aliyun.accesskey.secret}")
    private String accessKeySecret;

    public void sendSms(String mobileNo, String message) throws Exception {
        Config config = new Config().setAccessKeyId(accessKeyId).setAccessKeySecret(accessKeySecret);
        // 配置 Endpoint
        config.endpoint = "dysmsapi.aliyuncs.com";

        // 初始化请求客户端
        Client client = new Client(config);

        // 构造请求对象，请填入请求参数值
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(mobileNo)
                .setSignName(signName)
                .setTemplateCode(templateCode)
                .setTemplateParam("{\"name\":\"张三\",\"number\":\"1390000****\"}");

        // 获取响应对象
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);

        // 响应包含服务端响应的 body 和 headers
        System.out.println(toJSONString(sendSmsResponse));
    }

}