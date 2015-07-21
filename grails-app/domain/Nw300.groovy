/**
 * <p>Title: O/R Mapping(For Nw300)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author TableMining 
 * @desc Groovy ORM 1.0.0 (NW300/NW300(彩球開獎資料主檔))
 */
class Nw300 {
		static mapping = {
			table 'NW300'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'assigned'
		}


		//---2.VERSION  
		Long version = 1
		//---3.建立人  
		String manCreatedId
		//---4.建立時間  
		Date dateCreated
		//---5.最後更新人  
		String manLastUpdatedId
		//---6.最後更新時間  
		Date lastUpdated
		//---7.類型  
		String type
		//---8.期數  
		String periods
		//---9.開獎時間  
		Date opendt


		static constraints = {
			version(nullable:false)
			manCreatedId(nullable:false)
			dateCreated(nullable:false)
			manLastUpdatedId(nullable:false)
			lastUpdated(nullable:false)
			type(nullable:true)
			periods(nullable:true)
			opendt(nullable:true)
		}



}

