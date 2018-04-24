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
    HttpService HttpService;

    @Autowired
    PomosMapper pomosMapper;

    @Value("${basicUrl}")
    private String baseUrl;

    public void importHistory(){
        String url;
        String laterThanDate = "2016/08/31";
        boolean ifContinue = true;
        while(ifContinue){
            url = baseUrl + laterThanDate;
            String data = HttpService.sendGet(url);
            HttpService.importDataByBatch(data);
            LastRecord lastRecord = pomosMapper.selectLastRecord();
            Date dayOfLastRecord = lastRecord.getDateOfLastRecord();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
            String lastDay = sf.format(dayOfLastRecord);
            if( laterThanDate.equals(lastDay)){
                ifContinue = false;
            }
            laterThanDate = lastDay;
        }
        pomosMapper.deleteDuplicatedRecord();
    }

    public void clearHistory(){
        pomosMapper.deleteAll();
    }
}
