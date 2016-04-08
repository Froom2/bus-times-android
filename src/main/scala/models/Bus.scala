package models

import org.joda.time.LocalTime

case class Bus (weekday: String, timetableTime: LocalTime, timetableBus: String) {
  val displayTime = timetableTime.toString("HH:mm")
}
