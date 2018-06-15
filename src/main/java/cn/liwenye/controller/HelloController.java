package cn.liwenye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.liwenye.service.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liwenye on 2018/01/02
 */
@RestController
public class HelloController {
    @Autowired
    ImportHistoryService importHistoryService;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        importHistoryService.importHistory();
        return "hello world!";
    }
}
