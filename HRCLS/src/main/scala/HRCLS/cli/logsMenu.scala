package HRCLS.cli

import HRCLS.utils.input._
import HRCLS.utils.output._

import scala.io.StdIn

object logsMenu {
  def logsMenu(arg: String): Unit = {
    def showLogsCommands(): Unit = {
      println("<> add : log a new contact");
      println("<> list: list all contacts in the log");
      println("<> list_call [callSign] : list all contacts in the log with the given call sign");
      println("<> remove : remove a contact from the log");
      println("<> remove_call [callSign] : remove all contacts from the log with the given call sign");
      println("<> update [ref#] : update a contact in the log");
      println("<> help : list all available commands");
      underline("<> exit : return to the main menu");
    }
    if (arg == "") {
      //no shortcut command passed => start loop
      var loop = true;
      printTitle("<<>> Contact Logs <<>>");
      while (loop) {
        showLogsCommands();
        StdIn.readLine(">:") match {
          case cmdPattern(cmd, arg) if cmd.equals("add") => {
            println(s"add a contact to the log + $arg");
          }
          case cmdPattern(cmd, arg) if cmd.equals("list") => {
            println(s"list all contacts in the log + $arg")
          }
          case cmdPattern(cmd, arg) if cmd.equals("remove") => {
            println(s"remove contact from the log + $arg")
          }
          case cmdPattern(cmd, arg) if cmd.equals("update") => {
            println(s"update contact in the log $arg");
          }
          case cmdPattern(cmd, arg) if cmd.equals("view") => {
            println(s"view a contact in the log $arg");
          }
          case cmdPattern(cmd, arg) if cmd.equals("exit") => {
            loop = false;
          }
          case cmdPattern(cmd, arg) if cmd.equals("help") => {
            println("list all available commands");
          }
        }
      }
    }
    else {
      println(s"shortcuts logbook + $arg")
    }
  }
}
