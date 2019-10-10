package cn.wt.springbootdemo2.service;

import cn.wt.springbootdemo2.entity.BaseEntity;
import cn.wt.springbootdemo2.exception.RunException;
import cn.wt.springbootdemo2.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class BaseService<T extends BaseEntity,M extends BaseMapper<T>>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public M dao;


    /**
     * PageInfo:
     *     private int pageNum;//当前页
     *     private int pageSize;//每页的数量
     *     private int size;//当前页的数量
     *     //由于startRow和endRow不常用，这里说个具体的用法
     *     //可以在页面中"显示startRow到endRow 共size条数据"
     *     private int startRow; //当前页面第一个元素在数据库中的行号
     *     private int endRow;//当前页面最后一个元素在数据库中的行号
     *     private long total; //总记录数
     *     private int pages; //总页数
     *     private List<T> list;//结果集
     *     private int firstPage; //第一页
     *     private int prePage;//前一页
     *     private boolean isFirstPage = false;//是否为第一页
     *     private boolean isLastPage = false;  //是否为最后一页
     *     private boolean hasPreviousPage = false;//是否有前一页
     *     private boolean hasNextPage = false;//是否有下一页
     *     private int navigatePages;//导航页码数
     *     private int[] navigatepageNums;//所有导航页号
     */
    public PageInfo<T> selectPage(T model, int page, int rows, String sort, String order) {
        Page<T> pageHelper = PageHelper.startPage(page,rows,order);
        PageInfo<T> pageInfo =  new PageInfo<T>(dao.selectPage(model));
        return pageInfo;
    }

    @Transactional
    public List<T> selectList(T obj) {

        return dao.selectList(obj);
    }
    @Transactional
    public T selectOne(Integer id) {

        return dao.selectOne(id);
    }
    @Transactional
    public int update(T obj) {
        try {
            return dao.update(obj);
        }catch (Exception e){
            e.printStackTrace();
            throw new RunException(500,"空指针异常");
        }
    }
    @Transactional
    public int save(T obj) {
        try {
            return dao.save(obj);
        }catch (Exception e){
            e.printStackTrace();
            throw new RunException(500,"空指针异常");
        }
    }
    @Transactional
    public int delete(Integer id) {
        return dao.delete(id);
    }


}
