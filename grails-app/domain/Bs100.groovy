/**
 * <p>Title: O/R Mapping(For Bs100)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (BS100/BS100(參數主檔))
 */
class Bs100 {
		String manCreated
		Date dateCreated
		String manLastUpdated
		Date lastUpdated
		String locale
		String systype
		String ptype
		String pdesc


		static mapping = {
			table 'BS100'
			comment 'BS100(參數主檔)'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED" , comment:"建立人"
			dateCreated column:"DATE_CREATED" , comment:"建立時間"
			manLastUpdated column:"MAN_LAST_UPDATED" , comment:"最後更新人"
			lastUpdated column:"LAST_UPDATED" , comment:"最後更新時間"
			locale column:"LOCALE" , comment:"多國語系"
			systype column:"SYSTYPE" , comment:"系統類型"
			ptype column:"PTYPE" , comment:"類型"
			pdesc column:"PDESC" , comment:"類型名稱"
		}


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			locale(nullable:true)
			systype(nullable:true)
			ptype(nullable:true)
			pdesc(nullable:true)
		}

}

