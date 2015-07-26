/**
 * <p>Title: O/R Mapping(For Bs101)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (BS101/BS101(參數子檔))
 */
class Bs101 {
		static mapping = {
			table 'BS101'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
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
		String ptype
		//---8.代碼  
		String pcode
		//---9.代碼名稱  
		String pdesc
		//---10.排序  
		Long idx = "1"


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

