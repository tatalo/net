/**
 * <p>Title: O/R Mapping(For Bs100)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (BS100/BS100(參數主檔))
 */
class Bs100 {
		static mapping = {
			table 'BS100'
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
		//---7.系統類型  
		String systype
		//---8.類型  
		String ptype
		//---9.類型名稱  
		String pdesc


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

