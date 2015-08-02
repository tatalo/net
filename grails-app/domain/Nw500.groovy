/**
 * <p>Title: O/R Mapping(For Nw500)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW500/NW500(列表類主檔))
 */
class Nw500 {
		static mapping = {
			table 'NW500'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED"
			dateCreated column:"DATE_CREATED"
			manLastUpdated column:"MAN_LAST_UPDATED"
			lastUpdated column:"LAST_UPDATED"
			locale column:"LOCALE"
			type column:"TYPE"
			title column:"TITLE"
			context column:"CONTEXT"
			idx column:"IDX"
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
		//---8.標題  
		String title
		//---9.內容  
		String context
		//---10.排序  
		Long idx = 1


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			locale(nullable:true)
			type(nullable:true)
			title(nullable:true)
			context(nullable:true)
			idx(nullable:true)
		}

}

