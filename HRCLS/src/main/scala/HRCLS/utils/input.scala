package HRCLS.utils

import scala.util.matching.Regex

object input {
  val cmdPattern: Regex = "(\\w+)\\s*(.*)".r();
}
