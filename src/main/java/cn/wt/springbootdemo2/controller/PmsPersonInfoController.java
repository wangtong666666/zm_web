package cn.wt.springbootdemo2.controller;

import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import cn.wt.springbootdemo2.service.PmsPersonInfoSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PmsPersonInfoController {
    @Autowired
    private PmsPersonInfoSercice pmsPersonInfoSercice;

    @RequestMapping("/pmspersoninfo/selectOne")
    public PmsPersonInfo selectOne(Integer id){

        PmsPersonInfo p = pmsPersonInfoSercice.selectOne(id);
        return p;
    }

    @RequestMapping("/pmspersoninfo/save")
    public ResultObject save(String name, String remark, Integer age){
        PmsPersonInfo person = new PmsPersonInfo();
        person.setAge(age);
        person.setName(name);
        person.setRemark(remark);

        int p = pmsPersonInfoSercice.save(person);
        return ReturnResult.success(person);
    }

}
