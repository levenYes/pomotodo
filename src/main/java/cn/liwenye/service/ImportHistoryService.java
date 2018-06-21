package cn.liwenye.service;

import cn.liwenye.bean.LastRecord;
import cn.liwenye.dao.PomosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liwenye on 2018/01/08
 */
@Service
public class ImportHistoryService {
    @Autowired
    HttpService httpService;
    
    @Autowired
    DaoService daoService;

    @Autowired
    PomosMapper pomosMapper;

    @Value("${spring.parameter.baseUrl}")
    String baseUrl;
    
    @Value("${spring.parameter.token}")
    String token;

    public void importHistory(){
        String url;
        String laterThanDate = "2016/08/31";
        boolean ifContinue = true;
        while(ifContinue){
            url = baseUrl + laterThanDate;
            String data = httpService.sendGet(url,token);
            daoService.importDataByBatch(data);
            LastRecord lastRecord = pomosMapper.selectLastRecord();
            Date dayOfLastRecord = lastRecord.getDateOfLastRecord();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
            String lastDay = sf.format(dayOfLastRecord);
            if( laterThanDate.equals(lastDay)){
                ifContinue = false;
            }
            laterThanDate = lastDay;
        }
    }
}
