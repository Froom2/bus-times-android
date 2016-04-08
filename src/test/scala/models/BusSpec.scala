package models

import org.joda.time.LocalTime
import org.scalatest.{Matchers, FlatSpec}


class BusSpec extends FlatSpec with Matchers {

  "displayText" must "return a string representation of the bus" in {

    val testBus = Bus("weekday", new LocalTime(8, 13),"62")

    testBus.displayTime shouldBe "08:13"
    testBus.timetableBus shouldBe "62"

  }

}
