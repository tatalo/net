/**
 * <p>Title: O/R Mapping(For Nw301)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author TableMining 
 * @desc Groovy ORM 1.0.0 (NW301/NW301(彩球資料子檔))
 */
class Nw301 {
		static mapping = {
			table 'NW301'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'assigned'
		}


		//---2.VERSION  
	    Integer version = 1
		//---3.建立人  
		String manCreatedId
		//---4.建立時間  
		Date dateCreated
		//---5.最後更新人  
		String manLastUpdatedId
		//---6.最後更新時間  
		Date lastUpdated
		//---7.NW300ID  
		Long nw300id
		//---8.開獎數字  
		String no
		//---9.特別號註記  
		String isspno = "0"
		//---10.開獎順序  
	    Long opidx = 1


		static constraints = {
			version(nullable:false)
			manCreatedId(nullable:false)
			dateCreated(nullable:false)
			manLastUpdatedId(nullable:false)
			lastUpdated(nullable:false)
			nw300id(nullable:true)
			no(nullable:true)
			isspno(nullable:true)
			opidx(nullable:true)
		}



}

