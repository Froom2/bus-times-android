package scaloid.example

import org.scaloid.common._
import android.graphics.Color

class HelloScaloid extends SActivity {
  lazy val meToo = new STextView("Me too")
  lazy val redBtn = new SButton(R.string.red)

  onCreate {
    contentView = new SVerticalLayout {
      style {
        case b: SButton => b.textColor(Color.RED)
        .onClick(meToo.text = "WOW YOU PRESSED THE BUTTON")
        case t: STextView => t textSize 10.dip
        case e: SEditText => e
        .backgroundColor(Color.YELLOW)
        .textColor(Color.BLACK)
      }
      STextView("I am 10 dip tall")
      meToo.here
      STextView("I am 15 dip tall") textSize 15.dip // overriding
      new SLinearLayout {
        STextView("Button: ")
        redBtn.here
      }.wrap.here
      SEditText("Hello this is a yellow space").fill
    } padding 20.dip
  }

}
