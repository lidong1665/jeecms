package com.jeecms.cms.entity.assist;

import com.jeecms.cms.entity.assist.base.BaseCmsScoreItem;



public class CmsScoreItem extends BaseCmsScoreItem {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsScoreItem () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsScoreItem (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsScoreItem (
		Integer id,
		com.jeecms.cms.entity.assist.CmsScoreGroup group,
		String name,
		Integer score,
		Integer priority) {

		super (
			id,
			group,
			name,
			score,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}