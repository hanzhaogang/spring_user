package zttc.itat.document.model;

public class MessageBean {
	private String Message;
	private String Sender;
	private String Geter;
	private String Mess_time;
	private String FilePath;

	public String getFilePath() {
		return FilePath;
	}

	public void setFilePath(String filePath) {
		FilePath = filePath;
	}

	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public String getGeter() {
		return Geter;
	}

	public void setGeter(String geter) {
		Geter = geter;
	}

	public String getMess_time() {
		return Mess_time;
	}

	public void setMess_time(String mess_time) {
		Mess_time = mess_time;
	}

	public String getMess_content() {
		return Mess_content;
	}

	public void setMess_content(String mess_content) {
		Mess_content = mess_content;
	}

	private String Mess_content;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
}
