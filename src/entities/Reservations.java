package entities;

public class Reservations {
	/**
     * フィールド
     */
	private int _id;
	private String _name;
	private int _st_id;
	private String _day;
	private String _arrivaltime;
	private String _usetime;
	private int _numberpeople;
	private String _sei;
	private String _mei;
	private String _tel;
	private String _mail;
	private String _remarks;
	private int _isdelete;
	
	public Reservations(){
		this._id = 0;
		this._name = "";
		this._st_id = 0;
		this._day = "";
		this._arrivaltime = "";
		this._usetime = "";
		this._numberpeople = 0;
		this._sei = "";
		this._mei = "";
		this._tel = "";
		this._mail = "";
		this._remarks = "";
		this._isdelete = 0;
	}
    public void setId(int num) {
        this._id = num;
    }
    public void setName(String val) {
        this._name = val;
    }
    public void setStId(int num) {
        this._st_id = num;
    }
    public void setDay(String val) {
        this._day = val;
    }
    public void setArrivalTime(String val) {
        this._arrivaltime = val;
    }
    public void setUseTime(String val) {
        this._usetime = val;
    }
    public void setNumberpeople(int num) {
        this._numberpeople = num;
    }
    public void setSei(String val) {
        this._sei = val;
    }
    public void setMei(String val) {
        this._mei = val;
    }
    public void setTel(String val) {
        this._tel = val;
    }
    public void setMail(String val) {
        this._mail = val;
    }
    public void setRemarks(String val) {
        this._remarks = val;
    }
    public void setIsdelete(int num) {
        this._isdelete = num;
    }
    public int getId() {
        return this._id;
    }
    public String getName() {
        return this._name;
    }
    public int getStId() {
        return this._st_id;
    }
    public String getDay() {
        return this._day;
    }
    public String getArrivaltime() {
    		String arrivaltime = "";
    		String time = this._arrivaltime;
    		int len = time.length();
    		if(len == 3) {
    			arrivaltime = time.substring(0, 1) + "：" + time.substring(1,3);
    		}else {
    			arrivaltime = time.substring(0, 2) + "：" + time.substring(2,4);
//    			aa += "：";
//    			aa += time.substring(2,4);
    		}
        return arrivaltime;
    }
    public String getArrivaltime2() {
    		return this._arrivaltime;
    }
    public String getUsetime() {
		String usetime = "";
		String time = this._usetime;
		int len = time.length();
		if(len == 3) {
			String judge = time.substring(1,3);
			if(judge.equals("00")) {
				usetime = time.substring(0, 1) + "時間";
			}else {
				usetime = time.substring(0, 1) + "時間" + time.substring(1,3) + "分";
			}
		}else if(len == 2) {
			usetime = time + "分";
		}else {
			String judge = time.substring(2,4);
			if(judge.equals("00")) {
				usetime = time.substring(0, 2) + "時間";
			}else {
				usetime = time.substring(0, 2) + "時間" + time.substring(2,4) + "分";
			}
//			aa += "：";
//			aa += time.substring(2,4);
		}
        return usetime;
    }

    public String getUsetime2() {
    		return this._usetime;
    }
    public String getNumberpeople() {
    		String str_number;
    		str_number = String.valueOf(this._numberpeople) + "人";
        return str_number;
    }
    public int getNumberpeople2() {
		return this._numberpeople;
    }	
    
    public String getSei() {
        return this._sei;
    }
    public String getMei() {
        return this._mei;
    }
    public String getTel() {
        return this._tel;
    }
    public String getMail() {
        return this._mail;
    }
    public String getRemarks() {
        return this._remarks;
    }
    public int getIsdelete() {
        return this._isdelete;
    }
}
