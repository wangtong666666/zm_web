package cn.wt.zmweb.controller;


import cn.wt.zmweb.redis.RedisFactoryJson;
import cn.wt.zmweb.redis.RedisFactoryString;
import cn.wt.zmweb.result.ResultObject;
import cn.wt.zmweb.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
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
      /*  PmsPersonInfo person = new PmsPersonInfo();
        person.setPersonNumber(1);
        person.setAdress("adress");
        person.setPersonName("name");
        redisTemplateJson.set("json:person",person);

        person = (PmsPersonInfo) redisTemplateJson.get("json:person");*/

        return ReturnResult.success(null);
    }

}
