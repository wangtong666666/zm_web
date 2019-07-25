package cn.wt.springbootdemo2.controller;


import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import cn.wt.springbootdemo2.redis.RedisFactoryJson;
import cn.wt.springbootdemo2.redis.RedisFactoryString;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {



    @Autowired
    private RedisFactoryString redisTemplateString;

    @Autowired
    private RedisFactoryJson redisTemplateJson;

    @PostMapping("setKey")
    @ResponseBody
    public ResultObject<String> test(String key,String value){
        redisTemplateString.set(key,value);

        String value2 = redisTemplateString.get(key);

        return ReturnResult.success(value2);
    }


    @GetMapping("setObject")
    @ResponseBody
    public ResultObject<Object> setObject(){
        PmsPersonInfo person = new PmsPersonInfo();
        person.setPersonNumber(1);
        person.setAdress("adress");
        person.setPersonName("name");
        redisTemplateJson.set("json:person",person);

        person = (PmsPersonInfo) redisTemplateJson.get("json:person");

        return ReturnResult.success(person);
    }

}
