/**
 * <p>Title: O/R Mapping(For Nw200)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW200/NW200(網站連結類主檔))
 */
class Nw200 {
		String manCreated
		Date dateCreated
		String manLastUpdated
		Date lastUpdated
		String locale
		String type
		String webnm
		String manageurl
		String manageurlBk
		String memberurl
		String memberurlBk
		Integer idx = 1


		static mapping = {
			table 'NW200'
			comment 'NW200(網站連結類主檔)'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED" , comment:"建立人"
			dateCreated column:"DATE_CREATED" , comment:"建立時間"
			manLastUpdated column:"MAN_LAST_UPDATED" , comment:"最後更新人"
			lastUpdated column:"LAST_UPDATED" , comment:"最後更新時間"
			locale column:"LOCALE" , comment:"多國語系"
			type column:"TYPE" , comment:"類型"
			webnm column:"WEBNM" , comment:"網站"
			manageurl column:"MANAGEURL" , comment:"管理URL"
			manageurlBk column:"MANAGEURL_BK" , comment:"管理URL_備份"
			memberurl column:"MEMBERURL" , comment:"會員URL"
			memberurlBk column:"MEMBERURL_BK" , comment:"會員URL_備份"
			idx column:"IDX" , comment:"排序"
		}


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			locale(nullable:true)
			type(nullable:true)
			webnm(nullable:true)
			manageurl(nullable:true)
			manageurlBk(nullable:true)
			memberurl(nullable:true)
			memberurlBk(nullable:true)
			idx(nullable:true)
		}

}

