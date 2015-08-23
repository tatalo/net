import grails.transaction.Transactional

@Transactional
class DataService {
    //NOs 一般開獎號碼
    //HaveSPNO 有無特別號 1:有 0:無
    //SPNOs 特別號開獎號碼

    //history1
    def lotto01 = [NOs: (1..49).collect{String.format('%02d', it)}, haveSPNO: 1] //六合彩
    def lotto02 = [NOs: (1..40).collect{String.format('%02d', it)}, haveSPNO: 0] //大福彩
    def lotto04 = [NOs: (1..38).collect{String.format('%02d', it)}, haveSPNO: 0] //38樂合彩
    def lotto05 = [NOs: (1..49).collect{String.format('%02d', it)}, haveSPNO: 1] //大樂透
    def lotto06 = [NOs: (1..49).collect{String.format('%02d', it)}, haveSPNO: 0] //49樂合彩
    def lotto07 = [NOs: (1..39).collect{String.format('%02d', it)}, haveSPNO: 0] //39樂合彩
    def lotto08 = [NOs: (1..39).collect{String.format('%02d', it)}, haveSPNO: 0] //今彩539

    //history2
    def lotto03 = [NOs: (1..38).collect{String.format('%02d', it)}, haveSPNO: 1, SPNOs: (1..8).collect{String.format('%02d', it)}] //威力彩

    //history3
    def lotto09 = [NOs: (0..9).collect{String.format('%02d', it)}, haveSPNO: 0, IDXs: [[IDX:1, NAME: '百位數'],[IDX:2, NAME: '十位數'],[IDX:3, NAME: '個位數']]] //3星彩
    def lotto10 = [NOs: (0..9).collect{String.format('%02d', it)}, haveSPNO: 0, IDXs: [[IDX:1, NAME: '千位數'],[IDX:2, NAME: '百位數'],[IDX:3, NAME: '十位數'],[IDX:4, NAME: '個位數']]] //4星彩

    //history4
    def lotto11 = [NOs: (1..80).collect{String.format('%02d', it)}, haveSPNO: 1] //賓果
}
