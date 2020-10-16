package HRCLS.dao

import HRCLS.model.CallSign
import HRCLS.utils.mongo.{getMongoCollectionWithCodec, getResults}
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.bson.codecs.Macros.createCodecProvider
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.{MongoClient, MongoCollection}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object callSignDAO {
  val codec  = fromRegistries(fromProviders(classOf[CallSign]), MongoClient.DEFAULT_CODEC_REGISTRY);
  val collection : MongoCollection[CallSign] = getMongoCollectionWithCodec("HRCLS", "user_info", codec);

  def getAllCallSigns(): Seq[CallSign] = {
    getResults(collection.find());
  }
  def addCallSign(call: CallSign): Unit = {
    collection.find(equal("callSign", call.callSign)).toFuture().onComplete {
      case Success(v) if v.length == 0 => { collection.insertOne(call).toFuture().onComplete( _ => "insert") }
      case Success(v) => {}
      case Failure(e) => e.printStackTrace();
    }
  }
  def editCallSign(call: String, obj: CallSign): Unit = {
    collection.findOneAndReplace(equal("callSign", call), obj).toFuture().onComplete {
      case Success(v) => "replace" ;
      case Failure(e) => e.printStackTrace();
    }
  }
  def removeCallSign(call: String): Unit = {
    collection.findOneAndDelete(equal("callSign", call)).toFuture().onComplete {
      case Success(v) if v == null => { s"$call was not found in the directory" };
      case Success(v) => { s"$call has been removed from the directory" };
      case Failure(e) => e.printStackTrace();
    }
  }
  def getCallSign(call: String): CallSign = {
    try {
      getResults((collection.find(equal("callSign", call))))(0)
    }catch {
      case e:IndexOutOfBoundsException => null
    }
  }
}
