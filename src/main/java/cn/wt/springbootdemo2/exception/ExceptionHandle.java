package cn.wt.springbootdemo2.exception;

import cn.wt.springbootdemo2.result.ResultEnum;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object defultExcepitonHandler(HttpServletRequest request, Exception e) {

        //自定义异常
        if(e instanceof RunException){
            RunException re = (RunException)e;

            StackTraceElement stackTraceElement= e.getStackTrace()[0];// 得到异常棧的首个元素
            logger.info("自定义异常："+re.getMessage()+"-"+re.getStatus()+"("+stackTraceElement.getFileName()+":"+stackTraceElement.getLineNumber()+")");
            return new ResultObject(re.getStatus(),re.getMessage());

        }else if(e instanceof HttpRequestMethodNotSupportedException){
            return ReturnResult.error(ResultEnum.METHOD_NOT_ALLOWED);
        }else{
            e.printStackTrace();
            return ReturnResult.error(ResultEnum.ERROR);
        }




    }


}
