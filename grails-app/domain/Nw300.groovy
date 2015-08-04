/**
 * <p>Title: O/R Mapping(For Nw300)</p>
 * <p>Description: BaseDAO/SqlObj/ResultSetObj/</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Free Open Everybody Use</p>
 * @author PA-ORM TableMining 
 * @desc Groovy ORM 1.0.3 (NW300/NW300(彩球開獎資料主檔))
 */
class Nw300 {
		String manCreated
		Date dateCreated
		String manLastUpdated
		Date lastUpdated
		String type
		String periods
		Date opendt
		String result

        static hasMany = [nw301s: Nw301]

		static mapping = {
			table 'NW300'
			comment 'NW300(彩球開獎資料主檔)'
			version false 
			//---1.OBJID PK0
			id column:"objid", generator:'Power228Generator'
			manCreated column:"MAN_CREATED" , comment:"建立人"
			dateCreated column:"DATE_CREATED" , comment:"建立時間"
			manLastUpdated column:"MAN_LAST_UPDATED" , comment:"最後更新人"
			lastUpdated column:"LAST_UPDATED" , comment:"最後更新時間"
			type column:"TYPE" , comment:"類型"
			periods column:"PERIODS" , comment:"期數"
			opendt column:"OPENDT" , comment:"開獎時間"
			result column:"RESULT" , comment:"開彩結果說明"
		}


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

