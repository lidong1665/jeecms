package com.jeecms.cms.entity.main.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the jc_api_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_api_info"
 */

public abstract class BaseApiInfo  implements Serializable {

	public static String REF = "ApiInfo";
	public static String PROP_CALL_TOTAL_COUNT = "callTotalCount";
	public static String PROP_CALL_WEEK_COUNT = "callWeekCount";
	public static String PROP_CALL_DAY_COUNT = "callDayCount";
	public static String PROP_ID = "id";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_CODE = "code";
	public static String PROP_URL = "url";
	public static String PROP_CALL_MONTH_COUNT = "callMonthCount";


	// constructors
	public BaseApiInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApiInfo (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseApiInfo (
		Integer id,
		String url,
		String code,
		boolean disabled,
		Integer callTotalCount,
		Integer callMonthCount,
		Integer callWeekCount,
		Integer callDayCount) {

		this.setId(id);
		this.setUrl(url);
		this.setCode(code);
		this.setDisabled(disabled);
		this.setCallTotalCount(callTotalCount);
		this.setCallMonthCount(callMonthCount);
		this.setCallWeekCount(callWeekCount);
		this.setCallDayCount(callDayCount);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private String name;
	private String url;
	private String code;
	private boolean disabled;
	private Integer limitCallDay;
	private Integer callTotalCount;
	private Integer callMonthCount;
	private Integer callWeekCount;
	private Integer callDayCount;
	private Date lastCallTime;

	// collections
	private java.util.Set<com.jeecms.cms.entity.main.ApiRecord> callRecords;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id"
     */
	public Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: api_url
	 */
	public String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: api_url
	 * @param url the api_url value
	 */
	public void setUrl (String url) {
		this.url = url;
	}


	/**
	 * Return the value associated with the column: api_code
	 */
	public String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: api_code
	 * @param code the api_code value
	 */
	public void setCode (String code) {
		this.code = code;
	}


	/**
	 * Return the value associated with the column: disabled
	 */
	public boolean isDisabled () {
		return disabled;
	}

	/**
	 * Set the value related to the column: disabled
	 * @param disabled the disabled value
	 */
	public void setDisabled (boolean disabled) {
		this.disabled = disabled;
	}

	public Integer getLimitCallDay() {
		return limitCallDay;
	}

	public void setLimitCallDay(Integer limitCallDay) {
		this.limitCallDay = limitCallDay;
	}

	/**
	 * Return the value associated with the column: call_total_count
	 */
	public Integer getCallTotalCount () {
		return callTotalCount;
	}

	/**
	 * Set the value related to the column: call_total_count
	 * @param callTotalCount the call_total_count value
	 */
	public void setCallTotalCount (Integer callTotalCount) {
		this.callTotalCount = callTotalCount;
	}


	/**
	 * Return the value associated with the column: call_month_count
	 */
	public Integer getCallMonthCount () {
		return callMonthCount;
	}

	/**
	 * Set the value related to the column: call_month_count
	 * @param callMonthCount the call_month_count value
	 */
	public void setCallMonthCount (Integer callMonthCount) {
		this.callMonthCount = callMonthCount;
	}


	/**
	 * Return the value associated with the column: call_week_count
	 */
	public Integer getCallWeekCount () {
		return callWeekCount;
	}

	/**
	 * Set the value related to the column: call_week_count
	 * @param callWeekCount the call_week_count value
	 */
	public void setCallWeekCount (Integer callWeekCount) {
		this.callWeekCount = callWeekCount;
	}


	/**
	 * Return the value associated with the column: call_day_count
	 */
	public Integer getCallDayCount () {
		return callDayCount;
	}

	/**
	 * Set the value related to the column: call_day_count
	 * @param callDayCount the call_day_count value
	 */
	public void setCallDayCount (Integer callDayCount) {
		this.callDayCount = callDayCount;
	}

	public Date getLastCallTime() {
		return lastCallTime;
	}

	public void setLastCallTime(Date lastCallTime) {
		this.lastCallTime = lastCallTime;
	}

	/**
	 * Return the value associated with the column: callRecords
	 */
	public java.util.Set<com.jeecms.cms.entity.main.ApiRecord> getCallRecords () {
		return callRecords;
	}

	/**
	 * Set the value related to the column: callRecords
	 * @param callRecords the callRecords value
	 */
	public void setCallRecords (java.util.Set<com.jeecms.cms.entity.main.ApiRecord> callRecords) {
		this.callRecords = callRecords;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.main.ApiInfo)) return false;
		else {
			com.jeecms.cms.entity.main.ApiInfo apiInfo = (com.jeecms.cms.entity.main.ApiInfo) obj;
			if (null == this.getId() || null == apiInfo.getId()) return false;
			else return (this.getId().equals(apiInfo.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}