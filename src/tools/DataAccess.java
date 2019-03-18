package tools;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Reservations;
import entities.Stores;
import entities.Time;


public class DataAccess extends Dao {
    /**
     * フィールド。
     */
    private String _sql;

    /**
     * コンストラクタ。
     *
     * @throws Exception 全ての例外。
     */
    public DataAccess() throws Exception, SQLException {
        super();
    }

    //自分の投稿の情報を抽出 
    public ArrayList<Stores> Storeselect(double lat, double lng) throws Exception, SQLException {
        ArrayList<Stores> result = new ArrayList<Stores>();
        try {
	    		double lat1 = lat - 0.00901;
	    		double lat2 = lat + 0.00901;
	    		double lng1 = lng - 0.010966;
	    		double lng2 = lng + 0.010966;
            this._sql = "SELECT id,name,latitude,longitude,icon,room_num,is_immediately,is_ate,is_half,money_url,reservation_url,tel,address,holiday,access,business,photo FROM stores ";
            this._sql += " WHERE latitude BETWEEN "+lat1+" AND "+lat2+" AND longitude BETWEEN "+lng1+" AND "+lng2+" ";
            rs = st.executeQuery(this._sql);
            Stores s = null;
            while (rs.next()) {
                s = new Stores();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setLatitude(rs.getDouble("latitude"));
                s.setLongitude(rs.getDouble("longitude"));
                s.setIcon(rs.getString("icon"));
                s.setRoomNum(rs.getInt("room_num"));
                s.setIsImmediately(rs.getInt("is_immediately"));
                s.setIsAte(rs.getInt("is_ate"));
                s.setIsHalf(rs.getString("is_half"));
                s.setMoneyUrl(rs.getString("money_url"));
                s.setReservationUrl(rs.getString("reservation_url"));
                s.setTel(rs.getString("tel"));
                s.setAddress(rs.getString("address"));
                s.setHoliday(rs.getString("holiday"));
                s.setAccess(rs.getString("access"));
                s.setBusiness(rs.getString("business"));
                s.setPhoto(rs.getString("photo"));
                result.add(s);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

	//データベースに挿入
	public void test(Stores st)throws SQLException{
        this._sql = "INSERT INTO stores(id,name,latitude,longitude,icon,room_num,is_immediately,is_ate,is_half,money_url,reservation_url,tel,address,holiday,access,business,photo,small_num,middle_num,large_num) "; 
        this._sql += "VALUES(NULL,'"+st.getName()+"',"+st.getLatitude()+","+st.getLongitude()+",'"+st.getIcon()+"',"+st.getRoomNum()+",";
        this._sql += ""+st.getIsImmediately()+","+st.getIsAte()+",'"+st.getIsHalf()+"','"+st.getMoneyUrl()+"','"+st.getReservationUrl()+"','"+st.getTel()+"',";
        this._sql += "'"+st.getAddress()+"','"+st.getHoliday()+"','"+st.getAccess()+"','"+st.getBusiness()+"','"+st.getPhoto()+"', "+st.getSmallNum()+", "+st.getMiddleNum()+", "+st.getLargeNum()+"";
        this._sql +=") ";
        
		try {
			this.st.execute(this._sql);
		}catch(SQLException e){
			throw e;
		}
	}

	//データベースに挿入
	public void ResevationInsert(Reservations res)throws SQLException{
        this._sql = "INSERT INTO reservations(id, st_id, day, arrivaltime, usetime, \n" + 
        		"numberpeople, sei, mei, tel, mail, remarks, isdelete) \n" + 
        		"VALUES (NULL, "+res.getStId()+", '"+res.getDay()+"', '"+res.getArrivaltime2()+"', '"+res.getUsetime2()+"', "+res.getNumberpeople2()+", \n" + 
        		"'"+res.getSei()+"', '"+res.getMei()+"', '"+res.getTel()+"', '"+res.getMail()+"', \n" + 
        		"'"+res.getRemarks()+"', 0)";
		try {
			this.st.execute(this._sql);
		}catch(SQLException e){
			throw e;
		}
	}

	//データベースに挿入
	public void Delete(String st)throws SQLException{
        this._sql = "DELETE FROM `stores` WHERE name = '"+st+"'";
        
		try {
			this.st.execute(this._sql);
		}catch(SQLException e){
			throw e;
		}
	}
	//データベースに挿入
	public void DeleteReservation(String st)throws SQLException{
        this._sql = "UPDATE reservations SET isdelete = 1 WHERE mail = '"+st+"'";
        
		try {
			this.st.execute(this._sql);
		}catch(SQLException e){
			throw e;
		}
	}

	public ArrayList<Reservations> ReservationsSelect(String name,String date,int nowtime) throws Exception, SQLException {
        ArrayList<Reservations> result = new ArrayList<Reservations>();
        try {
            this._sql = "SELECT st.name,re.id,re.st_id,re.day,re.arrivaltime,re.usetime,\n" + 
            		"re.numberpeople,re.sei,re.mei,re.tel,re.mail,re.remarks,re.isdelete\n" + 
            		"FROM reservations re\n" + 
            		"INNER JOIN stores st ON st.id = re.st_id\n" + 
            		"WHERE st.name = '"+name+"'\n" +
            		"AND re.isdelete = 0 \n" +
            		"AND re.day = "+date+"\n" +
            		"AND re.arrivaltime > "+nowtime+"\n"
            				+ " ORDER BY re.arrivaltime asc";
            rs = st.executeQuery(this._sql);
            Reservations r = null;
            while (rs.next()) {
            		r = new Reservations();
            		r.setName(rs.getString("st.name"));
            		r.setId(rs.getInt("re.id"));
            		r.setStId(rs.getInt("re.st_id"));
            		r.setDay(rs.getString("re.day"));
            		r.setArrivalTime(rs.getString("re.arrivaltime"));
            		r.setUseTime(rs.getString("re.usetime"));
            		r.setNumberpeople(rs.getInt("re.numberpeople"));
            		r.setSei(rs.getString("re.sei"));
            		r.setMei(rs.getString("re.mei"));
            		r.setTel(rs.getString("re.tel"));
            		r.setMail(rs.getString("re.mail"));
            		r.setRemarks(rs.getString("re.remarks"));
            		r.setIsdelete(rs.getInt("re.isdelete"));
                result.add(r);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public ArrayList<Reservations> ReservationsSelect(String name,String date) throws Exception, SQLException {
        ArrayList<Reservations> result = new ArrayList<Reservations>();
        try {
            this._sql = "SELECT st.name,re.id,re.st_id,re.day,re.arrivaltime,re.usetime,\n" + 
            		"re.numberpeople,re.sei,re.mei,re.tel,re.mail,re.remarks,re.isdelete\n" + 
            		"FROM reservations re\n" + 
            		"INNER JOIN stores st ON st.id = re.st_id\n" + 
            		"WHERE st.name = '"+name+"'\n" +
            		"AND re.isdelete = 0 \n" +
            		"AND re.day = "+date+"\n"
            				+ " ORDER BY re.arrivaltime asc";
            rs = st.executeQuery(this._sql);
            Reservations r = null;
            while (rs.next()) {
            		r = new Reservations();
            		r.setName(rs.getString("st.name"));
            		r.setId(rs.getInt("re.id"));
            		r.setStId(rs.getInt("re.st_id"));
            		r.setDay(rs.getString("re.day"));
            		r.setArrivalTime(rs.getString("re.arrivaltime"));
            		r.setUseTime(rs.getString("re.usetime"));
            		r.setNumberpeople(rs.getInt("re.numberpeople"));
            		r.setSei(rs.getString("re.sei"));
            		r.setMei(rs.getString("re.mei"));
            		r.setTel(rs.getString("re.tel"));
            		r.setMail(rs.getString("re.mail"));
            		r.setRemarks(rs.getString("re.remarks"));
            		r.setIsdelete(rs.getInt("re.isdelete"));
                result.add(r);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public String NameSelect(int id) throws Exception, SQLException {
        String result = "";
        try {
            this._sql = "SELECT st.name,re.id,re.st_id,re.day,re.arrivaltime,re.usetime,\n" + 
            		"re.numberpeople,re.sei,re.mei,re.tel,re.mail,re.remarks,re.isdelete\n" + 
            		"FROM reservations re\n" + 
            		"INNER JOIN stores st ON st.id = re.st_id\n" + 
            		"WHERE st.id = "+id+"";
            rs = st.executeQuery(this._sql);
            while (rs.next()) {
            		result = rs.getString("st.name");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

	public String RoomnumSelect(String stid,String peonum) throws Exception, SQLException {
        String result = "";
        int i_id = Integer.parseInt(stid);

        if(Integer.parseInt(peonum) <= 4) {
        		this._sql = "SELECT small_num,id ";
                try {
                    this._sql += " FROM stores WHERE id = "+i_id+" ";
                    rs = st.executeQuery(this._sql);
                    while (rs.next()) {
                    		result = rs.getString("small_num");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
        }else if(Integer.parseInt(peonum) <= 8) {
        		this._sql = "SELECT middle_num,id ";
                try {
                    this._sql += " FROM stores WHERE id = "+i_id+" ";
                    System.out.println(this._sql);
                    rs = st.executeQuery(this._sql);
                    while (rs.next()) {
                    		result = rs.getString("middle_num");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
        }else {
        		this._sql = "SELECT large_num,id ";
                try {
                    this._sql += " FROM stores WHERE id = "+i_id+" ";
                    rs = st.executeQuery(this._sql);
                    while (rs.next()) {
                    		result = rs.getString("large_num");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
        }
        return result;
    }
	public Time ReservationTimeSelect(String stid, String peonum, String date, int week) throws Exception, SQLException {
        Time t = new Time();
        this._sql = "SELECT st_id, arrivaltime, usetime, numberpeople, day FROM reservations \n" + 
        		"WHERE st_id = "+stid+" \n" + 
        		"AND day = "+date+" \n" ;
        if(Integer.parseInt(peonum) <= 4) {
        		this._sql += "AND numberpeople <= 4 ";
        }else if(Integer.parseInt(peonum) <= 8) {
        		this._sql += "AND numberpeople <= 8 AND numberpeople >= 5";
        }else {
        		this._sql += "AND numberpeople >= 9 ";
        }
        
        t.setTime(date, week);
        try {
            rs = st.executeQuery(this._sql);
            while (rs.next()) {
        		t.setTime(rs.getString("arrivaltime"),rs.getString("usetime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return t;
    }
}