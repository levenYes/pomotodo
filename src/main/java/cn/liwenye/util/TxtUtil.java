package cn.liwenye.util;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读写txt帮助类
 */
public class TxtUtil {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TxtUtil.class);
	
	/**
	 * 读取txt方法
	 * @param sourceFile 要读取的txt文件
	 * @return List<String>,将读取结果逐行放入list。异常时返回null
	 */
	public static List<String> readTxt(File sourceFile) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		// 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		List<String> strList = new ArrayList<String>();
		try {
			String str = "";
			// FileInputStream
			fis = new FileInputStream(sourceFile);
			// 从文件系统中的某个文件中获取字节
			// InputStreamReader 是字节流通向字符流的桥梁,
			isr = new InputStreamReader(fis);
			// 从字符输入流中读取文件中的内容,封装了一个newInputStreamReader的对象
			br = new BufferedReader(isr);
			while ((str = br.readLine()) != null) {
				strList.add(str);
				LOGGER.info("读取文件" + sourceFile + ":" + str);
			}
		} catch (Exception e) {
			strList = null;
			LOGGER.error("读取文件" + sourceFile + "异常");
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
				// 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return strList;
	}

	/**
	 * 写txt方法
	 * @param targetFile 要写的txt文件
	 * @param strList 要写入的信息
	 * @return boolean 是否成功写入目标文件
	 */
	public static boolean writeTxt(File targetFile,List<String> strList) {
		try {
			if(!targetFile.getParentFile().exists()){
				targetFile.getParentFile().mkdirs();
			}
			if(targetFile.exists()){
				targetFile.delete();
			}
			if(!targetFile.exists()){
				targetFile.createNewFile();
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriterWithEncoding(targetFile,"UTF-8"));
	        for (int i = 0, k = strList.size(); i < k; i++) {
				if(i < k - 1) {
					writer.write(strList.get(i) + "\r\n");
				} else {
					writer.write(strList.get(i));
				}
			}
			writer.close();
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void initMdContent(List<String> mdContent) {
		mdContent.add("---");
		mdContent.add("title: 阅读清单");

		String date = DateUtil.getThreeDayBefore();
		mdContent.add("date: "+date);

		mdContent.add("categories: 定时任务生成");
		mdContent.add("---");
		mdContent.add(" ");
		mdContent.add("作为番茄土豆的重度用户，从16年8月底开始，几乎每一次阅读都会用这个应用记录下来。" +
				"利用API接口和定时任务拉取历史记录，抽取每一本书的最后一条记录。" +
				"这样就可以看到都看过哪些书、每本书的上一次阅读是在哪一天。" +
				"利用这些数据，试图更好地安排接下来的阅读计划。" +
				"作为初步尝试，将来还会有更多的想法在此基础上发展和实现。");
		mdContent.add("<!-- more -->");
	}

}
