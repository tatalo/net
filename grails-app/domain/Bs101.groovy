/**
 * <p>Title: O/R Mapping(For Bs101)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (BS101/BS101(參數子檔))
 */
class Bs101 {
		String manCreated
		Date dateCreated
		String manLastUpdated
		Date lastUpdated
		String locale
		String ptype
		String pcode
		String pdesc
		Integer idx = 1


		static mapping = {
			table 'BS101'
			comment 'BS101(參數子檔)'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED" , comment:"建立人"
			dateCreated column:"DATE_CREATED" , comment:"建立時間"
			manLastUpdated column:"MAN_LAST_UPDATED" , comment:"最後更新人"
			lastUpdated column:"LAST_UPDATED" , comment:"最後更新時間"
			locale column:"LOCALE" , comment:"多國語系"
			ptype column:"PTYPE" , comment:"類型"
			pcode column:"PCODE" , comment:"代碼"
			pdesc column:"PDESC" , comment:"代碼名稱"
			idx column:"IDX" , comment:"排序"
		}


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			locale(nullable:true)
			ptype(nullable:true)
			pcode(nullable:true)
			pdesc(nullable:true)
			idx(nullable:true)
		}

}

