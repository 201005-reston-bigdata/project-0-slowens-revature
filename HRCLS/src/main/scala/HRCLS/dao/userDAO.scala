package HRCLS.dao

import HRCLS.model.User
import HRCLS.utils.mongo.{getMongoCollectionWithCodec, getResults}

import org.mongodb.scala.MongoCollection
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.bson.codecs.Macros.createCodecProvider
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.bson.types.ObjectId
import org.mongodb.scala.model.Filters

object userDAO {
  val codec  = fromRegistries(fromProviders(classOf[User]), DEFAULT_CODEC_REGISTRY);
  val collection : MongoCollection[User] = getMongoCollectionWithCodec("HRCLS", "user_info", codec);

  def pushToMongo(user: User){
    val list = getResults(collection.countDocuments());
    if (list(0)== 1){
      val res = getResults(collection.replaceOne(Filters.eq("_id", user._id), user))
    }
    else {
      getResults(collection.insertOne(user)).foreach(println);
    }
  }
  def getFromMongo(): User = {
    try{
      getResults(collection.find()).head;
    }catch{
      case e:IndexOutOfBoundsException =>  User(new ObjectId(), "none", "none", "none", "none", "none");
    }
  }
}
