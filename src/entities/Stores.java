package entities;
/**
 * @author tsubasakotani
 *	店舗情報登録のためのエンティティ
 */

public class Stores {
	/**
     * フィールド
     */
    private int _id;
    private String _name;//店名
    private Double _latitude;//緯度
    private Double _longitude;//経度
    private String _icon;//アイコン
    private int _room_num;//部屋数
    private int _small_num;
    private int _middle_num;
    private int _large_num;
    private int _is_immediately;//即時利用フラグ
    private int _is_ate;//飲食物持ち込みフラグ
    private String _is_half;//半額フラグ
    private String _money_url;//価格URL
    private String _reservation_url;//予約URL
    private String _tel;
    private String _address;
    private String _holiday;
    private String _access;
    private String _business;
    private String _photo;//アイコン
    

    public Stores() {
        this._id = 0;
        this._name = "";
        this._latitude = 0.0;
        this._longitude = 0.0;
        this._icon = "";
        this._room_num = 0;
        this._small_num = 0;
        this._middle_num = 0;
        this._large_num = 0;
        this._is_immediately = 0;
        this._is_ate = 0;
        this._is_half = "";
        this._money_url = "";
        this._reservation_url = "";
        this._tel = "";
        this._address = "";
        this._holiday = "";
        this._access = "";
        this._business = "";
        this._photo = "";
        
    }

    /**
     * 投稿idのセッター
     * @param id
     */
    public void setId(int id) {
        this._id = id;
    }

    /**
     * 店名のセッター
     * @param name
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * 緯度のセッター
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this._latitude = latitude;
    }
    
    /**
     * 経度のセッター
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this._longitude = longitude;
    }

    /**
     * アイコンのセッター
     * @param icon
     */
    public void setIcon(String icon) {
        this._icon = icon;
    }
    /**
     * 写真のセッター
     * @param photo
     */
    public void setPhoto(String photo) {
        this._photo = photo;
    }

    /**
     * 部屋数のセッター
     * @param room_num
     */
    public void setRoomNum(int room_num) {
        this._room_num = room_num;
    }
    /**
     * Sの部屋数のセッター
     * @param small_num
     */
    public void setSmallNum(int small_num) {
        this._small_num = small_num;
    }
    /**
     * Mの部屋数のセッター
     * @param middle_num
     */
    public void setMiddleNum(int middle_num) {
        this._middle_num = middle_num;
    }
    /**
     * Lの部屋数のセッター
     * @param large_num
     */
    public void setLargeNum(int large_num) {
        this._large_num = large_num;
    }
    
    /**
     * 即時利用フラグのセッター
     * @param is_immediately
     */
    public void setIsImmediately(int is_immediately) {
        this._is_immediately = is_immediately;
    }

    /**
     * 飲食物持ち込みフラグのセッター
     * @param is_ate
     */
    public void setIsAte(int is_ate) {
        this._is_ate = is_ate;
    }

    /**
     * 半額フラグのセッター
     * @param is_half
     */
    public void setIsHalf(String is_half) {
        this._is_half = is_half;
    }

    /**
     * 価格URLのセッター
     * @param money_url
     */
    public void setMoneyUrl(String money_url) {
        this._money_url = money_url;
    }

    /**
     * 予約URLのセッター
     * @param reservation_url
     */
    public void setReservationUrl(String reservation_url) {
        this._reservation_url = reservation_url;
    }
    /**
     * TELのセッター
     * @param tel
     */
    public void setTel(String tel) {
        this._tel = tel;
    }
    /**
     * 所在地のセッター
     * @param address
     */
    public void setAddress(String address) {
        this._address = address;
    }
    /**
     * 定休日のセッター
     * @param holiday
     */
    public void setHoliday(String holiday) {
        this._holiday = holiday;
    }
    /**
     * アクセスのセッター
     * @param access
     */
    public void setAccess(String access) {
        this._access = access;
    }
    /**
     * 営業時間のセッター
     * @param business
     */
    public void setBusiness(String business) {
        this._business = business;
    }
 
    /**
     * 投稿idのゲッター
     * @return idのゲッター
     */
    public int getId() {
        return this._id;
    }

    /**
     * 店名のゲッター
     * @return nameのゲッター
     */
    public String getName() {
        return this._name;
    }

    /**
     * 緯度のゲッター
     * @return latitudeのゲッター
     */
    public Double getLatitude() {
        return this._latitude;
    }
    
    /**
     * 経度のゲッター
     * @return longitudeのゲッター
     */
    public Double getLongitude() {
        return this._longitude;
    }

    /**
     * アイコンのゲッター
     * @return iconのゲッター
     */
    public String getIcon() {
        return this._icon;
    }
    /**
     * 写真のゲッター
     * @return photoのゲッター
     */
    public String getPhoto() {
        return this._photo;
    }

    /**
     * 部屋数のゲッター
     * @return room_numのゲッター
     */
    public int getRoomNum() {
        return this._room_num;
    }
    /**
     * Sの部屋数のゲッター
     * @return small_numのゲッター
     */
    public int getSmallNum() {
        return this._small_num;
    }
    /**
     * Mの部屋数のゲッター
     * @return middle_numのゲッター
     */
    public int getMiddleNum() {
        return this._middle_num;
    }
    /**
     * Lの部屋数のゲッター
     * @return large_numのゲッター
     */
    public int getLargeNum() {
        return this._large_num;
    }

    /**
     * 即時利用フラグのゲッター
     * @return is_immediatelyのゲッター
     */
    public int getIsImmediately() {
        return this._is_immediately;
    }
    /**
     * 飲食物持ち込みフラグのゲッター
     * @return is_ateのゲッター
     */
    public int getIsAte() {
        return this._is_ate;
    }
    /**
     * 半額フラグのゲッター
     * @return is_halfのゲッター
     */
    public String getIsHalf() {
        return this._is_half;
    }

    /**
     * 価格URLのゲッター
     * @return money_urlのゲッター
     */
    public String getMoneyUrl() {
        return this._money_url;
    }

    /**
     * 予約URLのゲッター
     * @return reservation_urlのゲッター
     */
    public String getReservationUrl() {
        return this._reservation_url;
    }
    /**
     * TELのゲッター
     * @return telのゲッター
     */
    public String getTel() {
        return this._tel;
    }
    /**
     * 所在地のゲッター
     * @return addressのゲッター
     */
    public String getAddress() {
        return this._address;
    }
    /**
     * 定休日のゲッター
     * @return holidayのゲッター
     */
    public String getHoliday() {
        return this._holiday;
    }
    /**
     * アクセスのゲッター
     * @return accessのゲッター
     */
    public String getAccess() {
        return this._access;
    }
    /**
     * 営業時間のゲッター
     * @return businessのゲッター
     */
    public String getBusiness() {
        return this._business;
    }
}
