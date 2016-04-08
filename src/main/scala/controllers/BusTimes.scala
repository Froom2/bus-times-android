
package controllers

import composition.compositionReal
import models.Bus
import org.joda.time.LocalDateTime


class BusTimes extends compositionReal {

  def nextBus: Either[String, Bus] = {

    val next: Option[Bus] = timeTableService
      .findNext(timeService.dayType(timeService.nowLocalDate), timeService.nowLocalTime) // need to sort out so it deals with weekdays properly

    next match {
      case Some(bus) => Right(bus)
      case _ => Left("Moooooo no more busses :(")
    }
  }
}


object BusTimes extends BusTimes
