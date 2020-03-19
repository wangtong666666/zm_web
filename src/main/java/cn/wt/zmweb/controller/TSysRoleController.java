
package cn.wt.zmweb.controller;

import cn.wt.zmweb.entity.TSysRole;
import cn.wt.zmweb.service.TSysRoleService;
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
* @ClassName: TSysRoleController
* @Description: id
* @author 生成Controller类
* @date 2019-10-09 上午 06:20:17 
*******************************************************
*/
@Controller
@RequestMapping("/tsysrole")
public class TSysRoleController{

	@Autowired()
	private TSysRoleService TSysRoleSer;
	@PostMapping("/selectPage")
	@ResponseBody
	public ResultObject seletePage(TSysRole model,int page,int rows,String sort,String order){

		PageInfo<TSysRole> modelPage = TSysRoleSer.selectPage(model,page,rows,sort,order);

		return ReturnResult.success(modelPage);
	}

	@PostMapping("/selectList")
	@ResponseBody
	public ResultObject seleteList(TSysRole model){

		List<TSysRole> list = TSysRoleSer.selectList(model);
		return ReturnResult.success(list);
	}

	@PostMapping("/selectOne")
	@ResponseBody
	public ResultObject seleteOne(Integer id){

		TSysRole model = TSysRoleSer.selectOne(id);
		return ReturnResult.success(model);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResultObject save(TSysRole model){

		int n = TSysRoleSer.save(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public ResultObject detele(Integer id){

		int n = TSysRoleSer.delete(id);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/update")
	@ResponseBody
	public ResultObject update(TSysRole model){

		int n = TSysRoleSer.update(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

}

