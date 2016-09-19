package zttc.itat.document.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

public class TestSearchConditionResolver {

    Map<String, Object>  testCondition;
    SearchConditionResolver conditionResolver;
    
    @Before
    public void setUp() {
    	testCondition = new HashMap<String, Object>();
    	testCondition.put("type", "");
    	conditionResolver = new SearchConditionResolver(testCondition);
    }
	@Test
	public void testConditionIsNull() {
        assert(!conditionResolver.conditionIsNull("type") );
	}

}
