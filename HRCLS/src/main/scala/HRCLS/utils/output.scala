package HRCLS.utils

object output {
  def printTitle(str: String): Unit = {
    val bracket = "=" * str.length
    printf("%s\n%s\n%s\n", bracket, str, bracket);
  }
  def upperline(str: String): Unit = {
    val bracket = "=" * str.length
    printf("%s\n%s\n", bracket, str);
  }
  def underline(str: String): Unit = {
    val bracket = "=" * str.length
    println(s"$str\n$bracket");
  }
}
