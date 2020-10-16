package HRCLS.model

import org.bson.codecs.configuration.CodecRegistries.{fromProviders => providers, fromRegistries}
import org.bson.types.ObjectId
import org.mongodb.scala.MongoClient

case class CallSign(val _id: ObjectId=new ObjectId(), var firstName:String, var lastName:String, var callSign:String, var city:String, var state:String) {

  this.firstName = firstName.capitalize;
  this.lastName = lastName.capitalize;
  this.callSign = this.callSign.toUpperCase;
  this.city = city.capitalize;
  this.state = state.toUpperCase;

  def apply(_id: ObjectId, first: String, last: String, call: String, city: String, state: String): CallSign = {
    CallSign(_id, first.capitalize, last.capitalize, call.toUpperCase, city.capitalize, state.toUpperCase);
  }
  override def toString(): String = s"$callSign : $firstName $lastName : $city, $state"
  def toStringMultiline(): String = s"$callSign\n\t$firstName $lastName\n\t$city, $state"
}