package cn.wt.springbootdemo2.result;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ResultObject<T> {
    private Integer status;
    private String message;
    private T data;
 //   private Timestamp timestamp = new  Timestamp(System.currentTimeMillis());
    private String time =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());


    public ResultObject() {
    }

    public ResultObject(Integer status,String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ResultObject(ResultEnum resultEnum) {
        super();
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }



    public void setStatus(Integer status) {
        this.status = status;
    }



    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }



    public T getData() {
        return data;
    }



    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResultObject{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", time='" + time + '\'' +
                '}';
    }
}
