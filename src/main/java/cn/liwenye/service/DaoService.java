package cn.liwenye.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;

import cn.liwenye.bean.BookList;
import cn.liwenye.bean.Pomos;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.util.DateUtil;

@Service
public class DaoService {
	@Autowired
    PomosMapper pomosMapper;
	
	public List<BookList> bookListQuery(){
		List<BookList> bookList = pomosMapper.selectBooklist();
		return bookList;
	}
	
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
        String strCreatedAt = pomos.getCreated_at();
        Date dateCreatedAt = DateUtil.convertDate(strCreatedAt);
        pomos.setCreatedAt(dateCreatedAt);

        String strUpdatedAt = pomos.getUpdated_at();
        Date dateUpdatedAt = DateUtil.convertDate(strUpdatedAt);
        pomos.setUpdatedAt(dateUpdatedAt);

        String strStartedAt = pomos.getStarted_at();
        Date dateStartedAt = DateUtil.convertDate(strStartedAt);
        pomos.setStartedAt(dateStartedAt);

        String strEndedAt = pomos.getEnded_at();
        Date dateEndedAt = DateUtil.convertDate(strEndedAt);
        pomos.setEndedAt(dateEndedAt);

        String strLocalStartedAt = pomos.getLocal_started_at();
        Date dateLocalStartedAt = DateUtil.convertDate(strLocalStartedAt);
        pomos.setLocalStartedAt(dateLocalStartedAt);
        
        String strLocalEndedAt = pomos.getLocal_ended_at();
        Date dateLocalEndedAt = DateUtil.convertDate(strLocalEndedAt);
        pomos.setLocalEndedAt(dateLocalEndedAt);
    }
}
