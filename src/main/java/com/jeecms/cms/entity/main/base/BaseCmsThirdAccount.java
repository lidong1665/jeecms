package com.jeecms.cms.entity.main.base;

import java.io.Serializable;

import com.jeecms.core.entity.CmsUser;


/**
 * This is an object that contains data related to the jc_third_account table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_third_account"
 */

public abstract class BaseCmsThirdAccount  implements Serializable {

	public static String REF = "CmsThirdAccount";
	public static String PROP_SOURCE = "source";
	public static String PROP_ACCOUNT_KEY = "accountKey";
	public static String PROP_USERNAME = "username";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsThirdAccount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsThirdAccount (Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsThirdAccount (
		Long id,
		String accountKey,
		String username,
		String source) {

		this.setId(id);
		this.setAccountKey(accountKey);
		this.setUsername(username);
		this.setSource(source);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
	private String accountKey;
	private String username;
	private String source;
	private CmsUser user;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="account_id"
     */
	public Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: account_key
	 */
	public String getAccountKey () {
		return accountKey;
	}

	/**
	 * Set the value related to the column: account_key
	 * @param accountKey the account_key value
	 */
	public void setAccountKey (String accountKey) {
		this.accountKey = accountKey;
	}


	/**
	 * Return the value associated with the column: username
	 */
	public String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: username
	 * @param username the username value
	 */
	public void setUsername (String username) {
		this.username = username;
	}


	/**
	 * Return the value associated with the column: source
	 */
	public String getSource () {
		return source;
	}

	/**
	 * Set the value related to the column: source
	 * @param source the source value
	 */
	public void setSource (String source) {
		this.source = source;
	}

	public CmsUser getUser() {
		return user;
	}

	public void setUser(CmsUser user) {
		this.user = user;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.main.CmsThirdAccount)) return false;
		else {
			com.jeecms.cms.entity.main.CmsThirdAccount cmsThirdAccount = (com.jeecms.cms.entity.main.CmsThirdAccount) obj;
			if (null == this.getId() || null == cmsThirdAccount.getId()) return false;
			else return (this.getId().equals(cmsThirdAccount.getId()));
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