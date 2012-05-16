//Scala���׋�

////////////////////////////////////////////////
//References
//http://www.ibm.com/developerworks/jp/java/library/j-scala02198.html
//Ted Neward, Principal, Neward & Associates
////////////////////////////////////////////////

//�R���X�g���N�^�̓N���X�Ɉ�������̂悤���B
//�L������\���N���X Rational
class Rational(n: Int, d: Int) {

  //���̑��̃R���X�g���N�^���`���邱�Ƃ��ł���悤���B
  def this(d: Int) = { this(0, d) }

  //�񕪂��邽�߂ɍő���񐔂����߂郁�\�b�h���`���Ă���B
  //�Ō�ɕ]���������̒l���֐��̒l�ɂȂ�悤���B
  //return�L�[���[�h���g�����Ƃ��ł���炵���B
  private def gcd(x: Int, y: Int): Int =
    {
      if (x == 0) y
      else if (x < 0) gcd(-x, y)
      else gcd(y % x, x)
    }

  private val g = gcd(n, d)

  //�����o�ϐ��̒�`�ł͂Ȃ��ăA�N�Z�T�B
  val numerator: Int = n / g
  val denominator: Int = d / g

  //���Z�q�̂悤�ȋL�������\�b�h�̎��ʎq�Ƃ��Ďg����悤���B
  //this���g��Ȃ��Ă��N���X�̃����o�ɃA�N�Z�X�ł���悤���B
  def +(that: Rational) =
    new Rational(numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator)
  def -(that: Rational) =
    new Rational(numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator)
  def *(that: Rational) =
    new Rational(numerator * that.numerator, denominator * that.denominator)
  def /(that: Rational) =
    new Rational(numerator * that.denominator, denominator * that.numerator)

  //�P�����Z�q�Ƃ��ĐU�镑���֐������ɂ�unary_������B
  def unary_~ = new Rational(denominator, numerator)

  override def toString() =
    "Rational: [" + numerator + " / " + denominator + "]"
}

//�N���X��`�����邱�Ɩ��������Ȃ�I�u�W�F�N�g����邱�Ƃ��ł���B
//���s�̂��߂̃G���g���|�C���g�����I�u�W�F�N�g��Application�N���X����p�����ăC���X�^���X�����B
object MyApplication extends Application {
  var r1 = new Rational(1, 3)
  var r2 = new Rational(2, 5)
  var r3 = r1 - r2
  var r4 = r1 + r2
  Console.println("r1 = " + r1)
  Console.println("r2 = " + r2)
  Console.println("r3 = " + r3)
  Console.println("r4 = " + r4)
}