package cn.wt.springbootdemo2.service;

import cn.wt.springbootdemo2.dao.PmsPersonInfoDao;
import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PmsPersonInfoSercice extends BaseService<PmsPersonInfo,PmsPersonInfoDao> {

}
