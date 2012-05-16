//Scalaお勉強

////////////////////////////////////////////////
//References
//http://www.ibm.com/developerworks/jp/java/library/j-scala02198.html
//Ted Neward, Principal, Neward & Associates
////////////////////////////////////////////////

//コンストラクタはクラスに一つが推奨のようだ。
//有理数を表すクラス Rational
class Rational(n: Int, d: Int) {

  //その他のコンストラクタを定義することもできるようだ。
  def this(d: Int) = { this(0, d) }

  //約分するために最大公約数を求めるメソッドを定義している。
  //最後に評価した式の値が関数の値になるようだ。
  //returnキーワードを使うこともできるらしい。
  private def gcd(x: Int, y: Int): Int =
    {
      if (x == 0) y
      else if (x < 0) gcd(-x, y)
      else gcd(y % x, x)
    }

  private val g = gcd(n, d)

  //メンバ変数の定義ではなくてアクセサ。
  val numerator: Int = n / g
  val denominator: Int = d / g

  //演算子のような記号もメソッドの識別子として使えるようだ。
  //thisを使わなくてもクラスのメンバにアクセスできるようだ。
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

  //単項演算子として振る舞う関数を作るにはunary_をつける。
  def unary_~ = new Rational(denominator, numerator)

  override def toString() =
    "Rational: [" + numerator + " / " + denominator + "]"
}

//クラス定義をすること無くいきなりオブジェクトを作ることができる。
//実行のためのエントリポイントを持つオブジェクトはApplicationクラスから継承してインスタンスを作る。
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