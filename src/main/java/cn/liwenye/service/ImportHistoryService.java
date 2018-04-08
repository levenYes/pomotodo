package cn.liwenye.service;

import cn.liwenye.bean.LastRecord;
import cn.liwenye.dao.PomosMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void importHistory(){
        String url;
        String laterThanDate = "2016/08/31";
        boolean ifContinue = true;
        while(ifContinue){
            String baseUrl = "https://api.pomotodo.com/1/pomos?offset=0&limit=100&abandoned=false&manual=false&started_later_than=";
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
