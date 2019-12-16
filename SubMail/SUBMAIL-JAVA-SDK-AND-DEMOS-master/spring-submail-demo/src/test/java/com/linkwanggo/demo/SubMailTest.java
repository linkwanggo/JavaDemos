package com.linkwanggo.demo;

import com.linkwanggo.demo.config.MessageConfig;
import com.linkwanggo.demo.loader.ConfigLoader;
import com.linkwanggo.demo.utils.JsonUtils;
import lib.MESSAGEXsend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.StringCharacterIterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubMailTest {

    @Autowired
    private ConfigLoader configLoader;

    /**
     * 发送短信
     */
    @Test
    public void testSend() {
        MessageConfig config = configLoader.getMessageConfig();
        MESSAGEXsend submail = new MESSAGEXsend(config);
        submail.addTo("15515622393");
        submail.setProject(config.getTemplateKey());
        submail.addVar("code", "123456");
        String response = submail.xsend();
        System.out.println("接口返回数据："+ response);
        Map<String, String> stringMap = JsonUtils.toMap(response, String.class, String.class);
        assert "success".equals(stringMap.get("status"));
    }
}
