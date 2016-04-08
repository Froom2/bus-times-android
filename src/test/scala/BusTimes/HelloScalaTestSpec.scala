package BusTimes

import org.scalatest.{FlatSpec, Matchers}

class HelloScalaTestSpec extends FlatSpec with Matchers {

  "one plus one" must "be two" in {
    1 + 1 shouldBe 2
  }

}
