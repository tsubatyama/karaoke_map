package entities;

public class Time {

	/**
     * フィールド
     */
    private String  _time;
    private String  _datatime;
    private String  _displaytime;
    private int  _nine;
    private int  _ninehalf;
    private int  _ten;
    private int  _tenhalf;
    private int  _eleven;
    private int  _elevenhalf;
    private int  _twelve;
    private int  _twelvehalf;
    private int  _thirteen;
    private int  _thirteenhalf;
    private int  _fourteen;
    private int  _fourteenhalf;
    private int  _fifteen;
    private int  _fifteenhalf;
    private int  _sixteen;
    private int  _sixteenhalf;
    private int  _seventeen;
    private int  _seventeenhalf;
    private int  _eightteen;
    private int  _eightteenhalf;
    private int  _nineteen;
    private int  _nineteenhalf;
    private int  _twenty;
    private int  _twentyhalf;
    private int  _twentyone;
    private int  _twentyonehalf;
    

    public Time() {
		  this._time = "";
		  this._datatime = "";
		  this._displaytime = "";
		  this._nine = 0;
		  this._ninehalf = 0;
		  this._ten = 0;
		  this._tenhalf = 0;
		  this._eleven = 0;
		  this._elevenhalf = 0;
		  this._twelve = 0;
		  this._twelvehalf = 0;
		  this._thirteen = 0;
		  this._thirteenhalf = 0;
		  this._fourteen = 0;
		  this._fourteenhalf = 0;
		  this._fifteen = 0;
		  this._fifteenhalf = 0;
		  this._sixteen = 0;
		  this._sixteenhalf = 0;
		  this._seventeen = 0;
		  this._seventeenhalf = 0;
		  this._eightteen = 0;
		  this._eightteenhalf = 0;
		  this._nineteen = 0;
		  this._nineteenhalf = 0;
		  this._twenty = 0;
		  this._twentyhalf = 0;
		  this._twentyone = 0;
		  this._twentyonehalf = 0;
    }
    
    //予約時刻を設定
    public void setTime(String arrivaltime, String usetime) {
        int a_time = Integer.parseInt(arrivaltime);//int　来店時間
        int u_time = Integer.parseInt(usetime);//int 使用時間

        int a_len = String.valueOf(a_time).length();//ながさ
        int u_len = String.valueOf(u_time).length();
        String arihour = "";
        String ariminu = "";
        String usehour = "";
        String useminu = "";
        
        if(a_len == 3) {
            arihour = arrivaltime.substring(0,1);
            ariminu = arrivaltime.substring(1,3);
        }else {
        		arihour = arrivaltime.substring(0,2);
            ariminu = arrivaltime.substring(2,4);
        }
        if(u_len == 3) {
        		usehour = usetime.substring(0,1);
        		useminu = usetime.substring(1,3);
        }else {
        		usehour = usetime.substring(0,2);
        		useminu = usetime.substring(2,4);
        }
		int int_arihour = Integer.parseInt(arihour);
		int int_ariminu = Integer.parseInt(ariminu);
		int int_usehour = Integer.parseInt(usehour);
		int int_useminu = Integer.parseInt(useminu);
		
		int cnt = 0;
		if(int_useminu == 0) {//利用時間の計算
			 cnt = int_usehour * 2;
		}else {
			cnt = int_usehour * 2 + 1;
		}
		
		for(;cnt >= 0 ; cnt--) {
			switch(int_arihour){
				case 9:
					if(int_ariminu == 0) {
						this._nine += 1;
					}else {
						this._ninehalf += 1;
					}
					break;
				case 10:
					if(int_ariminu == 0) {
						this._ten += 1;
					}else {
						this._tenhalf += 1;
					}
					break;	
				case 11:
					if(int_ariminu == 0) {
						this._eleven += 1;
					}else {
						this._elevenhalf += 1;
					}
					break;	
				case 12:
					if(int_ariminu == 0) {
						this._twelve += 1;
					}else {
						this._twelvehalf += 1;
					}
					break;	
				case 13:
					if(int_ariminu == 0) {
						this._thirteen += 1;
					}else {
						this._thirteenhalf += 1;
					}
					break;	
				case 14:
					if(int_ariminu == 0) {
						this._fourteen += 1;
					}else {
						this._fourteenhalf += 1;
					}
					break;	
				case 15:
					if(int_ariminu == 0) {
						this._fifteen += 1;
					}else {
						this._fifteenhalf += 1;
					}
					break;	
				case 16:
					if(int_ariminu == 0) {
						this._sixteen += 1;
					}else {
						this._sixteenhalf += 1;
					}
					break;	
				case 17:
					if(int_ariminu == 0) {
						this._seventeen += 1;
					}else {
						this._seventeenhalf += 1;
					}
					break;	
				case 18:
					if(int_ariminu == 0) {
						this._eightteen += 1;
					}else {
						this._eightteenhalf += 1;
					}
					break;	
				case 19:
					if(int_ariminu == 0) {
						this._nineteen += 1;
					}else {
						this._nineteenhalf += 1;
					}
					break;	
				case 20:
					if(int_ariminu == 0) {
						this._twenty += 1;
					}else {
						this._twentyhalf += 1;
					}
					break;	
				case 21:
					if(int_ariminu == 0) {
						this._twentyone += 1;
					}else {
						this._twentyonehalf += 1;
					}
					break;	
			}
			
			if(int_ariminu == 0) {
				int_ariminu = 30;
			}else {
				int_ariminu = 0;
				int_arihour += 1;
			}
		}
    }
    public void setTime(String date , int week) {
    		this._datatime = date;
    		this._displaytime = date.substring(0,4) + "年" + date.substring(4,6) + "月" + date.substring(6,8) + "日";
		date = date.substring(6,8);
    		switch(week) {
    		case 1:
    			this._time = date + "(日)";
    			break;
    		case 2:
    			this._time = date + "(月)";
    			break;
    		case 3:
    			this._time = date + "(火)";
    			break;
    		case 4:
    			this._time = date + "(水)";
    			break;
    		case 5:
    			this._time = date + "(木)";
    			break;
    		case 6:
    			this._time = date + "(金)";
    			break;
    		case 7:
    			this._time = date + "(土)";
    			break;
    		}
    }
    public String getDate() {
		return this._datatime;
    }
    public String getDisplayTime() {
		return this._displaytime;
    }
    public String getTime() {
		return this._time;
    }

    public String getRoomNine(int num) {//可能な部屋数cccc
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
    	    if(this._nine >= half_num) {
        		return "×";
        }else if(this._nine >= three_num){
        		return "△";
        }else {
        		return "◯";
        }
    }
    
    public String getRoomNineHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._ninehalf >= half_num) {
	    		return "×";
	    }else if(this._ninehalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomTen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._ten >= half_num) {
    		return "×";
	    }else if(this._ten >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomTenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._tenhalf >= half_num) {
	    		return "×";
	    }else if(this._tenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomEleven(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._eleven >= half_num) {
    		return "×";
	    }else if(this._eleven >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomElevenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._elevenhalf >= half_num) {
	    		return "×";
	    }else if(this._elevenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomTwelve(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._twelve >= half_num) {
    		return "×";
	    }else if(this._twelve >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomTwelveHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._twelvehalf >= half_num) {
	    		return "×";
	    }else if(this._twelvehalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomThirteen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._thirteen >= half_num) {
    		return "×";
	    }else if(this._thirteen >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomThirteenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._thirteenhalf >= half_num) {
	    		return "×";
	    }else if(this._thirteenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomFourteen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._fourteen >= half_num) {
    		return "×";
	    }else if(this._fourteen >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomFourteenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._fourteenhalf >= half_num) {
	    		return "×";
	    }else if(this._fourteenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomFifteen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._fifteen >= half_num) {
    		return "×";
	    }else if(this._fifteen >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomFifteenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._fifteenhalf >= half_num) {
	    		return "×";
	    }else if(this._fifteenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomSixteen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._sixteen >= half_num) {
    		return "×";
	    }else if(this._sixteen >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomSixteenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._sixteenhalf >= half_num) {
	    		return "×";
	    }else if(this._sixteenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomSeventeen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._seventeen >= half_num) {
    		return "×";
	    }else if(this._seventeen >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomSeventeenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._seventeenhalf >= half_num) {
	    		return "×";
	    }else if(this._seventeenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomEightteen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._eightteen >= half_num) {
    		return "×";
	    }else if(this._eightteen >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomEightteenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._eightteenhalf >= half_num) {
	    		return "×";
	    }else if(this._eightteenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomNineteen(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._nineteen >= half_num) {
    		return "×";
	    }else if(this._nineteen >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomNineteenHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._nineteenhalf >= half_num) {
	    		return "×";
	    }else if(this._nineteenhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomTwenty(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._twenty >= half_num) {
    		return "×";
	    }else if(this._twenty >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomTwentyHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._twentyhalf >= half_num) {
	    		return "×";
	    }else if(this._twentyhalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
    
    public String getRoomTwentyOne(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._twentyone >= half_num) {
    		return "×";
	    }else if(this._twentyone >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }

    public String getRoomTwentyOneHalf(int num) {//可能な部屋数
		if(num == 0) {
			return "×";
		}
		Double half_num = (double)num / 2;//予約できる部屋数
		Double three_num = (double)num / 3;
	    if(this._twentyonehalf >= half_num) {
	    		return "×";
	    }else if(this._twentyonehalf >= three_num){
	    		return "△";
	    }else {
	    		return "◯";
	    }
    }
}
