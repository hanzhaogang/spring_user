package zttc.itat.document.dao;

import java.util.Map;

public class SearchConditionResolver {

    private Map<String,Object> searchCondition;

	public SearchConditionResolver(Map<String,Object> searchCondition){
		this.searchCondition = searchCondition; 
	}

	public boolean onlyName(){
        boolean nameIsNull = conditionIsNull("name");
        boolean pidIsNull = conditionIsNull("pid");
        boolean createrIsNull = conditionIsNull("creater");
        boolean createTimeIsNull = conditionIsNull("createTime");

		if ( (!nameIsNull)&&  
             (pidIsNull)&& 
             (createrIsNull)&&
             (createTimeIsNull)
           ){
            	return true;
            }
		return false;
	}
	
	public boolean onlyPid(){

		if (!conditionIsNull("pid")&&  
             conditionIsNull("name")&& 
             conditionIsNull("creater")&&
             conditionIsNull("createTime")){
            	return true;
            }
		return false;
	}
	public boolean onlyCreater(){

		if (!conditionIsNull("creater")&&  
             conditionIsNull("name")&& 
             conditionIsNull("pid")&&
             conditionIsNull("createTime")){
            	return true;
            }
		return false;
	}
	public boolean onlyCreateTime(){

		if (!conditionIsNull("createTime")&&  
             conditionIsNull("name")&& 
             conditionIsNull("pid")&&
             conditionIsNull("creater")){
            	return true;
            }
		return false;
	}
    //	this method's abstract level is lower than the others, which should be refactored later
	public boolean conditionIsNull(String string){
	    assert searchCondition != null;	
		if (searchCondition.get(string).toString().length()==0 || searchCondition.get(string).toString().equals(string+"..")) {
			return true;
		}
		return false;
	} 
}
