package controllers


import composition.composition
import models.{Bus, TimetableList}
import org.joda.time.LocalTime
import org.mockito.Matchers.any
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.PlaySpec


class BusTimesSpec extends PlaySpec with MockitoSugar {

  val mockTimetableList = mock[TimetableList]

  trait FakeComposition
    extends composition {
    override val timeTableService = mockTimetableList
  }

  val SUT = new BusTimes with FakeComposition



  "nextBus" must {

    "return the next bus when there is one" in {
      when(mockTimetableList.findNext(any[String], any[LocalTime]))
        .thenReturn(Some(Bus("Weekday", new LocalTime(11, 0), "63")))

      SUT.nextBus mustBe Right(Bus("Weekday", new LocalTime(11, 0), "63"))
    }

    "return an error when there are no more busses" in {
      when(mockTimetableList.findNext(any[String], any[LocalTime]))
        .thenReturn(None)

      SUT.nextBus mustBe Left("Moooooo no more busses :(")
    }
  }
}
