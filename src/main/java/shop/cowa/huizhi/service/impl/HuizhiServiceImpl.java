package shop.cowa.huizhi.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import shop.cowa.huizhi.HttpSendJson;
import shop.cowa.huizhi.service.HuizhiService;

import java.io.Console;

@Service
public class HuizhiServiceImpl implements HuizhiService {
    public static String YUGUANTONG_CALLBACK = "http://116.62.5.115:8122/Interface/DDSB_Back";
    public static final String FAILURE = "FAILURE";
    public static final String SUCCESS = "SUCCESS";
    @Override
    public String orderListCallback(String body) {
        try {
            // send to YunGuangTong callback url;
            // save model data to order table in database.
            HttpSendJson.callPostForm(YUGUANTONG_CALLBACK, body);
            System.out.println("CBT ORDER LIST <--- " + body);
            return SUCCESS ;
        } catch (Exception e) {
            System.out.println("CBT ORDER LIST <--- " + e.getMessage());
            System.out.println("CBT ORDER LIST <--- " + body);
            return FAILURE;
        }
    }

    @Override
    public String cargoListCallback(String body) {
        try {
            // send to YunGuangTong callback url;
            // save model data to order table in database.
            System.out.println("CBT CARGO LIST <--- " + body);
            HttpSendJson.callPostForm(YUGUANTONG_CALLBACK, body);
            return SUCCESS ;
        } catch (Exception e) {
            System.out.println("CBT CARGO LIST <--- " + e.getMessage());
            System.out.println("CBT CARGO LIST <--- " + body);
            return FAILURE;
        }
    }
}
