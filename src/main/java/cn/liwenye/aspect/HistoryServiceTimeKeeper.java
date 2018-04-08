package cn.liwenye.aspect;


import cn.liwenye.service.ImportHistoryService;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liwenye
 */
@Aspect
@Component
public class HistoryServiceTimeKeeper {
    @Autowired
    ImportHistoryService importHistoryService;

    private long startTime = 0;
    private long endTime = 0;

    @Pointcut("execution(* cn.liwenye.controller.HelloController.hello(..))")
    public void method() {

    }

    @Before("method()")
    public void setStartTime() {
        startTime=System.currentTimeMillis();
        }

    @After("method()")
    public void setEndTime() {
        endTime=System.currentTimeMillis();
        System.out.println("当前程序耗时："+(endTime-startTime)+"ms");
        importHistoryService.clearHistory();
    }
}
