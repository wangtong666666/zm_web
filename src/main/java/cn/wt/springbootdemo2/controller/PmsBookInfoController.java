
package cn.wt.springbootdemo2.controller;

import cn.wt.springbootdemo2.entity.PmsBookInfo;
import cn.wt.springbootdemo2.service.PmsBookInfoService;
import cn.wt.springbootdemo2.result.ResultEnum;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* ********************************************************
* @ClassName: PmsBookInfoController
* @Description: id
* @author 生成Controller类
* @date 2019-11-16 下午 03:17:25 
*******************************************************
*/
@Controller
@RequestMapping("/pmsbookinfo")
public class PmsBookInfoController{

	@Autowired()
	private PmsBookInfoService PmsBookInfoSer;
	@RequestMapping("/selectPage")
	@ResponseBody
	public ResultObject seletePage(PmsBookInfo model,int page,int limit,String sort,String order){

		PageInfo<PmsBookInfo> modelPage = PmsBookInfoSer.selectPage(model,page,limit,sort,order);

		return ReturnResult.success(modelPage);
	}

	@PostMapping("/selectList")
	@ResponseBody
	public ResultObject seleteList(PmsBookInfo model){

		List<PmsBookInfo> list = PmsBookInfoSer.selectList(model);
		return ReturnResult.success(list);
	}

	@PostMapping("/selectOne")
	@ResponseBody
	public ResultObject seleteOne(Integer id){

		PmsBookInfo model = PmsBookInfoSer.selectOne(id);
		return ReturnResult.success(model);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResultObject save(PmsBookInfo model){
		model.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int n = PmsBookInfoSer.save(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public ResultObject detele(Integer id){

		int n = PmsBookInfoSer.delete(id);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/update")
	@ResponseBody
	public ResultObject update(PmsBookInfo model){

		int n = PmsBookInfoSer.update(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}


	@GetMapping("/list")
	public String list(PmsBookInfo model){
		return "PmsBookInfo/list";
	}

}

