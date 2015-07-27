/**
 * <p>Title: O/R Mapping(For Nw301)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW301/NW301(彩球開獎號碼檔))
 */
class Nw301 {
		static mapping = {
			table 'NW301'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED"
			dateCreated column:"DATE_CREATED"
			manLastUpdated column:"MAN_LAST_UPDATED"
			lastUpdated column:"LAST_UPDATED"
			nw300id column:"NW300ID"
			no column:"NO"
			isspno column:"ISSPNO"
			opidx column:"OPIDX"
		}


		//---2.建立人  
		String manCreated
		//---3.建立時間  
		Date dateCreated
		//---4.最後更新人  
		String manLastUpdated
		//---5.最後更新時間  
		Date lastUpdated
		//---6.NW300ID  
		String nw300id
		//---7.開獎數字  
		Long no
		//---8.特別號註記  
		Long isspno = 0
		//---9.開獎順序  
		Long opidx = 1


		static constraints = {
			manCreated(nullable:false)
			dateCreated(nullable:true)
			manLastUpdated(nullable:false)
			lastUpdated(nullable:true)
			nw300id(nullable:true)
			no(nullable:true)
			isspno(nullable:true)
			opidx(nullable:true)
		}

}

