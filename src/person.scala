// See a series of articles http://ibm.co/bFVVke

// var は変更可能な変数を表す。何も付けないと変更不可能。関数型ではそちらのほうが自然。
// コンストラクタで指定された firstName や lastNameにはアクセサが自動的に定義される。

class Person(var firstName: String, var lastName: String, var age: Int) {
  def getFirstName = firstName
  def getLastName = lastName
  def getAge = age

  def setFirstName(value: String): Unit = firstName = value
  def setLastName(value: String) = lastName = value
  def setAge(value: Int) = age = value

  override def toString =
    "[Person firstName:" + firstName + " lastName:" + lastName +
      " age:" + age + " ]"
}

object PersonApp extends Application {
  var p = new Person("Takashi", "Sasaki", 38)
  p.firstName = "隆志"
  p.lastName = "佐々木"
  Console.println(p)
}
