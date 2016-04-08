package scaloid.busMain

import controllers.BusTimes
import org.scaloid.common._
import android.graphics.Color

class busView extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      style {
        case t: STextView => t
          .textSize(20.dip)
          .backgroundColor(Color.rgb(200, 100, 150))
          .textColor(Color.BLACK)
          .padding(20)
      }
      STextView("The next bus is a number " +
        BusTimes.nextBusNumber +
        " at " +
        BusTimes.nextBusTime)
    } padding 20.dip
  }

}
