package zttc.itat.model;

import java.util.List;
import java.util.Map;

/*
 * a Pager class, which has a generics parameter
 */
public class Pager<T> {

	/**
	 * 分页的大小
	 */
	private int size;
	/**
	 * 分页的起始页
	 */
	private int offset;
	/**
	 * 总记录数
	 */
	private long total;
	/**
	 * 分页的数据
	 */
	private List<T> datas;

	
	/*
	 * default constructor
	 */
	public Pager() {
		
	}

	/*
	 * constructor with List
	 */
	public Pager(List<T> listUser) {
		datas = listUser;
		
	}


	/*
	 * construct a Pager based on a hashmap contained the result. 
	 */
	public Pager(Map<String, T> resultMap) {
		/*
		 * for
		 * resultMap.get
		 */
		
		
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void testDatas(){
	    datas.get(0);	
	}
}
