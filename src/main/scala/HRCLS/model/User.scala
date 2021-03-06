package HRCLS.model

import org.bson.types.ObjectId

import scala.io.Source
import scala.reflect.internal.util.NoSourceFile.lines

case class User( var firstName:String, var lastName:String,var callSign:String,var city:String,var state:String) {
  val _id: ObjectId=new ObjectId();
  this.firstName = firstName.capitalize;
  this.lastName = lastName.capitalize;
  this.callSign = callSign.toUpperCase;
  this.city = city.capitalize;
  this.state = state.toUpperCase;


  def apply(first: String, last: String, call: String, city: String, state: String): User = {
    User( first.capitalize, last.capitalize, call.toUpperCase, city.capitalize, state.toUpperCase);
  }
  override def toString(): String = s"$callSign : $firstName $lastName : $city, $state"
  def toStringMultiline(): String = s"$callSign\n\t$firstName $lastName\n\t$city, $state"
}