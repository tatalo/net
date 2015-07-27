/**
 * <p>Title: O/R Mapping(For Nw300)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW300/NW300(彩球開獎資料主檔))
 */
class Nw300 {
		static mapping = {
			table 'NW300'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED"
			dateCreated column:"DATE_CREATED"
			manLastUpdated column:"MAN_LAST_UPDATED"
			lastUpdated column:"LAST_UPDATED"
			type column:"TYPE"
			periods column:"PERIODS"
			opendt column:"OPENDT"
			result column:"RESULT"
		}


		//---2.建立人  
		String manCreated
		//---3.建立時間  
		Date dateCreated
		//---4.最後更新人  
		String manLastUpdated
		//---5.最後更新時間  
		Date lastUpdated
		//---6.類型  
		String type
		//---7.期數  
		String periods
		//---8.開獎時間  
		Date opendt
		//---9.開彩結果說明  
		String result


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			type(nullable:true)
			periods(nullable:true)
			opendt(nullable:true)
			result(nullable:true)
		}

}

