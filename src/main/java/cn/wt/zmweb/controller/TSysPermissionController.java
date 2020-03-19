
package cn.wt.zmweb.controller;

import cn.wt.zmweb.entity.TSysPermission;
import cn.wt.zmweb.service.TSysPermissionService;
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
* @ClassName: TSysPermissionController
* @Description: id
* @author 生成Controller类
* @date 2019-10-09 上午 06:21:34 
*******************************************************
*/
@Controller
@RequestMapping("/tsyspermission")
public class TSysPermissionController{

	@Autowired()
	private TSysPermissionService TSysPermissionSer;
	@PostMapping("/selectPage")
	@ResponseBody
	public ResultObject seletePage(TSysPermission model,int page,int rows,String sort,String order){

		PageInfo<TSysPermission> modelPage = TSysPermissionSer.selectPage(model,page,rows,sort,order);

		return ReturnResult.success(modelPage);
	}

	@PostMapping("/selectList")
	@ResponseBody
	public ResultObject seleteList(TSysPermission model){

		List<TSysPermission> list = TSysPermissionSer.selectList(model);
		return ReturnResult.success(list);
	}


	@PostMapping("/findByRoleId")
	@ResponseBody
	public ResultObject findByRoleId(Integer roleId){

		List<TSysPermission> list = TSysPermissionSer.findPermissionByRoleId(roleId);
		return ReturnResult.success(list);
	}

	@PostMapping("/selectOne")
	@ResponseBody
	public ResultObject seleteOne(Integer id){

		TSysPermission model = TSysPermissionSer.selectOne(id);
		return ReturnResult.success(model);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResultObject save(TSysPermission model){

		int n = TSysPermissionSer.save(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public ResultObject detele(Integer id){

		int n = TSysPermissionSer.delete(id);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/update")
	@ResponseBody
	public ResultObject update(TSysPermission model){

		int n = TSysPermissionSer.update(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

}

