/**
 * <p>Title: O/R Mapping(For Nw400)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW400/NW400(文章資料主檔))
 */
class Nw400 {
		static mapping = {
			table 'NW400'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'assigned'
			manCreated column:"MAN_CREATED"
			dateCreated column:"DATE_CREATED"
			manLastUpdated column:"MAN_LAST_UPDATED"
			lastUpdated column:"LAST_UPDATED"
			locale column:"LOCALE"
			type column:"TYPE"
			issuedt column:"ISSUEDT"
			title column:"TITLE"
			context column:"CONTEXT"
			fbboardurl column:"FBBOARDURL"
			countsurl column:"COUNTSURL"
		}


		//---2.建立人  
		String manCreated
		//---3.建立時間  
		Date dateCreated
		//---4.最後更新人  
		String manLastUpdated
		//---5.最後更新時間  
		Date lastUpdated
		//---6.多國語系  
		String locale
		//---7.類型  
		String type
		//---8.發佈日期  
		Date issuedt
		//---9.標題  
		String title
		//---10.內容  
		String context
		//---11.FB留言版URL  
		String fbboardurl
		//---12.計數器URL  
		String countsurl


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			locale(nullable:true)
			type(nullable:true)
			issuedt(nullable:true)
			title(nullable:true)
			context(nullable:true)
			fbboardurl(nullable:true)
			countsurl(nullable:true)
		}

}

