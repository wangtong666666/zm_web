package cn.wt.springbootdemo2.exception;

import cn.wt.springbootdemo2.result.ResultEnum;

public class RunException extends RuntimeException{

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public RunException(ResultEnum re){
        super(re.getMessage());
        this.status = re.getStatus();
    }

    public RunException(Integer status,String message){
        super(message);
        this.status = status;
    }

    public RunException(ResultEnum re,Exception e){
        super((e.getMessage() !=null) ? (re.getMessage()+":"+e.getMessage()) : re.getMessage());
        this.status = re.getStatus();
    }

}
