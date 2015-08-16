/**
 * <p>Title: O/R Mapping(For Nw400)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW400/NW400(文章類主檔))
 */
class Nw400 {
		String manCreated
		Date dateCreated
		String manLastUpdated
		Date lastUpdated
		String locale
		String type
		Date issuedt
		String title
		String context
		String fbboardurl
		Integer browsercnts
		Integer idx = 1


		static mapping = {
			table 'NW400'
			comment 'NW400(文章類主檔)'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED" , comment:"建立人"
			dateCreated column:"DATE_CREATED" , comment:"建立時間"
			manLastUpdated column:"MAN_LAST_UPDATED" , comment:"最後更新人"
			lastUpdated column:"LAST_UPDATED" , comment:"最後更新時間"
			locale column:"LOCALE" , comment:"多國語系"
			type column:"TYPE" , comment:"類型"
			issuedt column:"ISSUEDT" , comment:"發佈日期"
			title column:"TITLE" , comment:"標題"
			context column:"CONTEXT" , comment:"內容"
			fbboardurl column:"FBBOARDURL" , comment:"FB留言版URL"
			browsercnts column:"BROWSERCNTS" , comment:"瀏覽次數"
			idx column:"IDX" , comment:"排序"
		}


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			locale(nullable:true)
			type(nullable:true)
			issuedt(nullable:true)
			title(nullable:false)
			context(nullable:false)
			fbboardurl(nullable:true)
			browsercnts(nullable:true)
			idx(nullable:true)
		}

}

