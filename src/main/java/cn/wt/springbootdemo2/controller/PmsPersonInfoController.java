package cn.wt.springbootdemo2.controller;

import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import cn.wt.springbootdemo2.service.PmsPersonInfoSercice;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pmspersoninfo")
public class PmsPersonInfoController {
    @Autowired
    private PmsPersonInfoSercice pmsPersonInfoSercice;

    @PostMapping("/selectOne")
    @ResponseBody
    public PmsPersonInfo selectOne(Integer id){

        PmsPersonInfo p = pmsPersonInfoSercice.selectOne(id);
        return p;
    }

    @PostMapping("/selectPage")
    @ResponseBody
    public ResultObject selectPage(PmsPersonInfo model,int page,int rows,String sort,String order){

        Page<PmsPersonInfo> p = pmsPersonInfoSercice.selectPage(model,page,rows,sort,order);
        return  ReturnResult.success(p);
    }


    @PostMapping("/save")
    @ResponseBody
    public ResultObject save(PmsPersonInfo model){
        PmsPersonInfo person = new PmsPersonInfo();
        person.setPersonName(model.getPersonName());
        person.setAdress(model.getAdress());
        person.setPersonNumber(model.getPersonNumber());

        int p = pmsPersonInfoSercice.save(person);
        return ReturnResult.success(person);
    }

}
