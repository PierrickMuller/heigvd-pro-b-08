// @GENERATOR:play-routes-compiler
// @SOURCE:D:/documents/HeigVd/Annee2/Deuxieme_Semestre/PRO/Tests2Play/pro_play_java/conf/routes
// @DATE:Sun Mar 24 22:01:21 CET 2019


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
