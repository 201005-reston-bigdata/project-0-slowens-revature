package HRCLS

import HRCLS.cli.CLI
import HRCLS.utils.mongo.{closeMongoClient, getMongoDatabase, openMongoClient}


object Main extends App {
  java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE)
  openMongoClient();
  new CLI().entryPoint();
  closeMongoClient();
}
