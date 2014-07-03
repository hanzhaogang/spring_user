package zttc.itat.document.dao;

import java.util.Map;

public class SearchConditionResolver {

    private Map<String,Object> searchCondition;

	public SearchConditionResolver(Map<String,Object> searchCondition){
		this.searchCondition = searchCondition; 
	}

	public boolean onlyName(){
        boolean nameIsNull = conditionIsNull("name");
        boolean typeIsNull = conditionIsNull("type");
        boolean createrIsNull = conditionIsNull("creater");
        boolean createTimeIsNull = conditionIsNull("createTime");

		if ( (!nameIsNull)&&  
             (typeIsNull)&& 
             (createrIsNull)&&
             (createTimeIsNull)
           ){
            	return true;
            }
		return false;
	}
	
	public boolean onlyType(){

		if (!conditionIsNull("type")&&  
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
             conditionIsNull("type")&&
             conditionIsNull("createTime")){
            	return true;
            }
		return false;
	}
	public boolean onlyCreateTime(){

		if (!conditionIsNull("createTime")&&  
             conditionIsNull("name")&& 
             conditionIsNull("type")&&
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
