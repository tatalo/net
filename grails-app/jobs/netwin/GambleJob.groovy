package netwin


class GambleJob {
    static triggers = {
      simple repeatInterval: 50000l // execute job once in 5 seconds
    }

    def execute() {
        println "排程開始"
        // execute job
    }
}
