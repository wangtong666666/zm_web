
package cn.wt.springbootdemo2.controller;

import cn.wt.springbootdemo2.entity.TSysUser;
import cn.wt.springbootdemo2.service.TSysUserService;
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
* @ClassName: TSysUserController
* @Description: id
* @author 生成Controller类
* @date 2019-10-09 上午 06:17:54 
*******************************************************
*/
@Controller
@RequestMapping("/authc/tsysuser")
public class TSysUserController{

	@Autowired()
	private TSysUserService TSysUserSer;




	@PostMapping("/findAllUserInfoByUserName")
	@ResponseBody
	public ResultObject findAllUserInfoByUserName(TSysUser model){
		TSysUser user = TSysUserSer.findAllUserInfoByUserName(model.getUserName());
		return ReturnResult.success(user);
	}




	@PostMapping("/selectPage")
	@ResponseBody
	public ResultObject seletePage(TSysUser model,int page,int rows,String sort,String order){

		PageInfo<TSysUser> modelPage = TSysUserSer.selectPage(model,page,rows,sort,order);

		return ReturnResult.success(modelPage);
	}

	@PostMapping("/selectList")
	@ResponseBody
	public ResultObject seleteList(TSysUser model){

		List<TSysUser> list = TSysUserSer.selectList(model);
		return ReturnResult.success(list);
	}

	@PostMapping("/selectOne")
	@ResponseBody
	public ResultObject seleteOne(Integer id){

		TSysUser model = TSysUserSer.selectOne(id);
		return ReturnResult.success(model);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResultObject save(TSysUser model){

		int n = TSysUserSer.save(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public ResultObject detele(Integer id){

		int n = TSysUserSer.delete(id);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

	@PostMapping("/update")
	@ResponseBody
	public ResultObject update(TSysUser model){

		int n = TSysUserSer.update(model);
		if(n>0){
			return ReturnResult.success();
		}else{
			return ReturnResult.error(ResultEnum.ERROR_UNKNOW);
		}
	}

}

