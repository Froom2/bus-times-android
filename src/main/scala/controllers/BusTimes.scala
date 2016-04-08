
package controllers

import composition.compositionReal
import models.Bus
import org.joda.time.LocalDateTime


class BusTimes extends compositionReal {

  def nextBusTime: String = {

    val next: Option[Bus] = timeTableService
      .findNext(timeService.dayType(timeService.nowLocalDate), timeService.nowLocalTime) // need to sort out so it deals with weekdays properly

    next match {
      case Some(bus) => bus.displayTime
      case _ => "Moooooo no more busses :("
    }
  }

  def nextBusNumber: String = {

    val next: Option[Bus] = timeTableService
      .findNext(timeService.dayType(timeService.nowLocalDate), timeService.nowLocalTime) // need to sort out so it deals with weekdays properly

    next match {
      case Some(bus) => bus.timetableBus
      case _ => "Moooooo no more busses :("
    }
  }

}


object BusTimes extends BusTimes
