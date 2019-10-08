
package cn.wt.springbootdemo2.controller;

import cn.wt.springbootdemo2.entity.TSysRolePermission;
import cn.wt.springbootdemo2.service.TSysRolePermissionService;
import cn.wt.springbootdemo2.result.ResultEnum;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* ********************************************************
* @ClassName: TSysRolePermissionController
* @Description: id
* @author 生成Controller类
* @date 2019-10-09 上午 06:21:48 
*******************************************************
*/
@Controller
@RequestMapping("/tsysrolepermission")
public class TSysRolePermissionController{

	@Autowired()
	private TSysRolePermissionService TSysRolePermissionSer;
	@PostMapping("/selectPage")
	@ResponseBody
	public ResultObject seletePage(TSysRolePermission model,int page,int rows,String sort,String order){

		PageInfo<TSysRolePermission> modelPage = TSysRolePermissionSer.selectPage(model,page,rows,sort,order);

		return ReturnResult.success(modelPage);
	}

	@PostMapping("/selectList")
	@ResponseBody
	public ResultObject seleteList(TSysRolePermission model){

		List<TSysRolePermission> list = TSysRolePermissionSer.selectList(model);
		return ReturnResult.success(list);
	}

	@PostMapping("/selectOne")
	@ResponseBody
	public ResultObject seleteOne(Integer id){

		TSysRolePermission model = TSysRolePermissionSer.selectOne(id);
		return ReturnResult.success(model);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResultObject save(TSysRolePermission model){

		int n = TSysRolePermissionSer.save(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public ResultObject detele(Integer id){

		int n = TSysRolePermissionSer.delete(id);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/update")
	@ResponseBody
	public ResultObject update(TSysRolePermission model){

		int n = TSysRolePermissionSer.update(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

}

