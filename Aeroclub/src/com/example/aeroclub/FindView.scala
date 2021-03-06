package com.example.aeroclub

import android.app.Activity
import android.view.View

// http://robots.thoughtbot.com/post/5836463058/scala-a-better-java-for-android
trait FindView extends Activity {
  def findView [WidgetType] (id: Int): WidgetType = {
    findViewById(id).asInstanceOf[WidgetType]
  }
}

class ViewWithOnClick(view: View) {
  def onClick(action: View => Any) = {
    view.setOnClickListener(new View.OnClickListener() {
      def onClick(v: View) { action(v) }
    })
  }
}

object FindView extends Activity {
  implicit def addOnClickToViews(view: View) = new ViewWithOnClick(view)
}