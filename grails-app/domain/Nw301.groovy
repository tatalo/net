/**
 * <p>Title: O/R Mapping(For Nw301)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW301/NW301(彩球開獎號碼檔))
 */
class Nw301 {
		String manCreated
		Date dateCreated
		String manLastUpdated
		Date lastUpdated
		Nw300 nw300id
		Integer no
		Integer isspno = 0
		Integer opidx = 1


		static mapping = {
			table 'NW301'
			comment 'NW301(彩球開獎號碼檔)'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED" , comment:"建立人"
			dateCreated column:"DATE_CREATED" , comment:"建立時間"
			manLastUpdated column:"MAN_LAST_UPDATED" , comment:"最後更新人"
			lastUpdated column:"LAST_UPDATED" , comment:"最後更新時間"
			nw300id column:"NW300ID" , comment:"NW300ID"
			no column:"NO" , comment:"開獎數字"
			isspno column:"ISSPNO" , comment:"特別號註記"
			opidx column:"OPIDX" , comment:"開獎順序"
		}


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

