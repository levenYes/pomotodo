package cn.liwenye.service;

import cn.liwenye.bean.LastRecord;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.schedule.TaskImportNewRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liwenye on 2018/01/09
 */
@Service
public class ImportNewRecordService {
    @Autowired
    HttpService httpService;

    @Autowired
    PomosMapper pomosMapper;
    
    @Value("${spring.parameter.baseUrl}")
    String baseUrl;

    private Log logger = LogFactory.getLog(TaskImportNewRecord.class);
    
    private static final String INIT_DATE = "2016/08/31";

    public void update(){
        String url;
        Date dayOfLastRecord;
        LastRecord lastRecord = pomosMapper.selectLastRecord();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        if(lastRecord != null) {
            dayOfLastRecord = lastRecord.getDateOfLastRecord();
        } else {
            try {
                dayOfLastRecord = sf.parse(INIT_DATE);
            } catch (ParseException e) {
                dayOfLastRecord = new Date();
                logger.error("设置最后一天日期发生异常", e);
            }
        }
        String lastDay = sf.format(dayOfLastRecord);
        url = baseUrl + lastDay;
        String data = httpService.sendGet(url);
        httpService.importData(data);
    }
}
