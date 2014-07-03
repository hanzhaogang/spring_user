    package zttc.itat.document.web;  


import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 可以用来处理格式比较简单的json字符串
 * @author shanl
 *
 */
public class JSONBuilder {
//	private Properties dict = new Properties();
	private Map<String,String> dict = new LinkedHashMap<String,String>(20);
	
	/**
	 * 写入一个键/值对
	 * @param key
	 * @param value
	 */
	public void put(String key, String value){		
		this.dict.put(replaceJsonChar(key), replaceJsonChar(value));
	}
	
	private String replaceJsonChar(String str){
		StringBuilder sb = new StringBuilder();		
		char[] chs = str.toCharArray();
		
		for(char c: chs){
			switch (c) { 
	        case '\"': 
	            sb.append("\\\""); 
	            break; 
	        case '\\': 
	            sb.append("\\\\"); 
	            break; 
	        case '/': 
	            sb.append("\\/"); 
	            break; 
	        case '\b': 
	            sb.append("\\b"); 
	            break; 
	        case '\f': 
	            sb.append("\\f"); 
	            break; 
	        case '\n': 
	            sb.append("\\n"); 
	            break; 
	        case '\r': 
	            sb.append("\\r"); 
	            break; 
	        case '\t': 
	            sb.append("\\t"); 
	            break; 
	        default: 
	            sb.append(c); 
	        } 
		}
		
		return sb.toString();
	}
	
	/**
	 * 返回键/值对列表
	 * @return
	 */
	public Map<String,String> getDict(){
		return dict;
	}
	
	/**
	 * 返回键所对应的值
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		return dict.get(key);
	}
	
	/**
	 * 解析json格式字符串
	 * @param json
	 */
	public void parseJsonString(String json){
		String _json = json;
		String[] ss = null;
		String[] tmp = null;		
		
		_json = _json.trim(); //去掉两端空格
		_json = _json.substring(2); //去掉 {"
		_json = _json.substring(0, _json.length()-2); //去掉 }"
		
		ss = _json.split("\",\"");
		for(String s: ss){
			tmp = s.split("\":\"");
			put(tmp[0], tmp[1]);
		}
	}
	
	/**
	 * 将数据转换成json格式字符串
	 * @return
	 */
	public String toJsonString(){
		String sb = "";
		String key = null;
		String value = null;
		Iterator<String> keys = dict.keySet().iterator();
//		Enumeration keys = dict.propertyNames(); 
		
		sb += "{";
		
		while(keys.hasNext()){
			key = keys.next();
			value = dict.get(key);
			
			sb += "\""+ key +"\":";
			sb += "\""+ value +"\",";
		}
		
		if(sb.endsWith(",") ){
			sb = sb.substring(0, sb.length()-1);
		}
		
		sb += "}";
		
		return sb.toString();
	}
	
	public String toString(){
		return toJsonString();
	}
}

