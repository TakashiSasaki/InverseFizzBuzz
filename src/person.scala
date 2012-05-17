// See a series of articles http://ibm.co/bFVVke

// var �͕ύX�\�ȕϐ���\���B�����t���Ȃ��ƕύX�s�\�B�֐��^�ł͂�����̂ق������R�B
// �R���X�g���N�^�Ŏw�肳�ꂽ firstName �� lastName�ɂ̓A�N�Z�T�������I�ɒ�`�����B

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
  p.firstName = "���u"
  p.lastName = "���X��"
  Console.println(p)
}
