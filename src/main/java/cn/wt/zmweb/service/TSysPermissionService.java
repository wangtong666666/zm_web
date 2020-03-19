
package cn.wt.zmweb.service;

import cn.wt.zmweb.entity.TSysPermission;
import cn.wt.zmweb.dao.TSysPermissionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* ********************************************************
* @ClassName: TSysPermissionService
* @Description: id
* @author 生成service类
* @date 2019-10-09 上午 06:21:34 
*******************************************************
*/
@Service
public class TSysPermissionService extends BaseService<TSysPermission,TSysPermissionDao>{

    @Transactional
    public List<TSysPermission> findPermissionByRoleId(Integer roleId) {

        return dao.findPermissionByRoleId(roleId);
    }
}

