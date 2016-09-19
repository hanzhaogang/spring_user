package zttc.itat.document.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_document")
public class Document {

	//public static final int MAX_INT = 2147647;
	
	//public static final String ROOT_GouXing= "构型文件";
	//public static final int ROOT_GouXing_ID = MAX_INT;

	//public static final String ROOT_JiHe= "几何文件";
	//public static final int ROOT_JiHe_ID = MAX_INT-1;

	//public static final String ROOT_JiSuan= "计算文件";
	//public static final int ROOT_JiSuan_ID = MAX_INT-2;

	public Document(int id, int pid, String name, String type, String creater,
			String createTime, String path) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.type = type;
		this.creater = creater;
		this.createTime = createTime;
		this.path = path;
	}

	public Document() {
		// TODO Auto-generated constructor stub
	}

	private int id;
    private int pid;
	private String name;
	private String type;
	private String creater;
	private String createTime;
	private String path;
    
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@GeneratedValue
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
