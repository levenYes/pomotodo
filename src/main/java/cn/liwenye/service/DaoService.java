package cn.liwenye.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;

import cn.liwenye.bean.Pomos;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.util.DateUtil;

public class DaoService {
	@Autowired
    PomosMapper pomosMapper;
	
    public void importData(String data){
    	List<Pomos> pomosList = JSONArray.parseArray(data, Pomos.class);
        for (Pomos pomos : pomosList) {
        	convertDate(pomos);
            pomosMapper.insert(pomos);
        }
    }

    public void importDataByBatch(String data){
    	List<Pomos> pomosList = JSONArray.parseArray(data, Pomos.class);
    	 for (Pomos pomos : pomosList) {
    		 convertDate(pomos);
        }
        pomosMapper.insertByBatch(pomosList);
        pomosMapper.deleteDuplicatedRecord();
    }
    
    private void convertDate(Pomos pomos) {
    	//created_at
        String strCreatedAt = pomos.getCreated_at();
        Date dateCreatedAt = DateUtil.convertDate(strCreatedAt);
        pomos.setCreatedAt(dateCreatedAt);
        //updated_at
        String strUpdatedAt = pomos.getUpdated_at();
        Date dateUpdatedAt = DateUtil.convertDate(strUpdatedAt);
        pomos.setUpdatedAt(dateUpdatedAt);
        //started_at
        String strStartedAt = pomos.getStarted_at();
        Date dateStartedAt = DateUtil.convertDate(strStartedAt);
        pomos.setStartedAt(dateStartedAt);
        //ended_at
        String strEndedAt = pomos.getEnded_at();
        Date dateEndedAt = DateUtil.convertDate(strEndedAt);
        pomos.setEndedAt(dateEndedAt);
        //local_started_at
        String strLocalStartedAt = pomos.getLocal_started_at();
        Date dateLocalStartedAt = DateUtil.convertDate(strLocalStartedAt);
        pomos.setLocalStartedAt(dateLocalStartedAt);
        //local_ended_at
        String strLocalEndedAt = pomos.getLocal_ended_at();
        Date dateLocalEndedAt = DateUtil.convertDate(strLocalEndedAt);
        pomos.setLocalEndedAt(dateLocalEndedAt);
    }
}
