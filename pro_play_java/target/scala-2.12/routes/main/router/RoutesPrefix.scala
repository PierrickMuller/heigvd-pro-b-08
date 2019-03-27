// @GENERATOR:play-routes-compiler
// @SOURCE:D:/TIC/HEIG/S4/PRO/PRO-2019-B-08/pro_play_java/conf/routes
// @DATE:Mon Mar 25 12:52:56 CET 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
