package cn.wt.springbootdemo2.result;

import java.util.ArrayList;

public class ReturnResult {

    public static ResultObject success(){
        return success(null);
    }

    public static ResultObject success(Object o){

        ResultObject resultObject = new ResultObject(ResultEnum.SUCCESS);
        resultObject.setData(o);
        return resultObject;
    }

    public static ResultObject error(ResultEnum resultEnum){
        return new ResultObject(resultEnum);
    }

    public static ResultObject falied(String message){
        return new ResultObject(-1,message);
    }





}
