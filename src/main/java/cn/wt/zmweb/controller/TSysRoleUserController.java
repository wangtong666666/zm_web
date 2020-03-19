
package cn.wt.zmweb.controller;

import cn.wt.zmweb.entity.TSysRoleUser;
import cn.wt.zmweb.service.TSysRoleUserService;
import cn.wt.zmweb.result.ResultEnum;
import cn.wt.zmweb.result.ResultObject;
import cn.wt.zmweb.result.ReturnResult;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* ********************************************************
* @ClassName: TSysRoleUserController
* @Description: id
* @author 生成Controller类
* @date 2019-10-09 上午 06:22:02 
*******************************************************
*/
@Controller
@RequestMapping("/tsysroleuser")
public class TSysRoleUserController{

	@Autowired()
	private TSysRoleUserService TSysRoleUserSer;
	@PostMapping("/selectPage")
	@ResponseBody
	public ResultObject seletePage(TSysRoleUser model,int page,int rows,String sort,String order){

		PageInfo<TSysRoleUser> modelPage = TSysRoleUserSer.selectPage(model,page,rows,sort,order);

		return ReturnResult.success(modelPage);
	}

	@PostMapping("/selectList")
	@ResponseBody
	public ResultObject seleteList(TSysRoleUser model){

		List<TSysRoleUser> list = TSysRoleUserSer.selectList(model);
		return ReturnResult.success(list);
	}

	@PostMapping("/selectOne")
	@ResponseBody
	public ResultObject seleteOne(Integer id){

		TSysRoleUser model = TSysRoleUserSer.selectOne(id);
		return ReturnResult.success(model);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResultObject save(TSysRoleUser model){

		int n = TSysRoleUserSer.save(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public ResultObject detele(Integer id){

		int n = TSysRoleUserSer.delete(id);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/update")
	@ResponseBody
	public ResultObject update(TSysRoleUser model){

		int n = TSysRoleUserSer.update(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

}

