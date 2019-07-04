package cn.wt.springbootdemo2.controller;

import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import cn.wt.springbootdemo2.result.ResultEnum;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import cn.wt.springbootdemo2.service.PmsPersonInfoSercice;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/pmspersoninfo")
public class PmsPersonInfoController {
    @Autowired
    private PmsPersonInfoSercice pmsPersonInfoSercice;


    @PostMapping("/selectPage")
    @ResponseBody
    public ResultObject selectPage(PmsPersonInfo model,int page,int rows,String sort,String order){

        PageInfo<PmsPersonInfo> modelPage = pmsPersonInfoSercice.selectPage(model,page,rows,sort,order);
        return  ReturnResult.success(modelPage);
    }

    @PostMapping("/selectList")
    @ResponseBody
    public ResultObject selectList(PmsPersonInfo model){

        List<PmsPersonInfo> list = pmsPersonInfoSercice.selectList(model);
        return ReturnResult.success(list);
    }

    @PostMapping("/selectOne")
    @ResponseBody
    public ResultObject selectOne(Integer id){

        PmsPersonInfo model = pmsPersonInfoSercice.selectOne(id);
        return ReturnResult.success(model);
    }

    @PostMapping("/selectOne2")
    @ResponseBody
    public ResultObject selectOne2(Integer id){

        PmsPersonInfo model = pmsPersonInfoSercice.selectOne2(id);
        return ReturnResult.success(model);
    }






    @PostMapping("/save")
    @ResponseBody
    public ResultObject save(PmsPersonInfo model){
        int n = pmsPersonInfoSercice.save(model);
        if(n>0){
            return ReturnResult.success();
        }else{
            return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
        }
    }


    @PostMapping("/update")
    @ResponseBody
    public ResultObject update(PmsPersonInfo model){
        int n = pmsPersonInfoSercice.update(model);
        if(n>0){
            return ReturnResult.success();
        }else{
            return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResultObject delete(Integer id){
        int n = pmsPersonInfoSercice.delete(id);
        if(n>0){
            return ReturnResult.success();
        }else{
            return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
        }

    }


}
