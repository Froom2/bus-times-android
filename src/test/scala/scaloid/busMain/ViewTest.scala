package scaloid.busMain

import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.{Robolectric, RobolectricTestRunner}
import scaloid.busMain.busView

@RunWith(classOf[RobolectricTestRunner])
@Config(manifest = "src/main/AndroidManifest.xml")
class ViewTest {
  @Test def testButtonPressed(): Unit = {
    val activity = Robolectric.setupActivity(classOf[busView])
    assertTrue(activity.meToo.text == "Me too")
    activity.redBtn.performClick()
    assertTrue(activity.meToo.text == "WOW YOU PRESSED THE BUTTON")
  }
}