// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.openapi.editor.toolbar.floating

interface FloatingToolbarComponent {

  var backgroundAlpha: Float

  var showingTime: Int

  var hidingTime: Int

  var retentionTime: Int

  var autoHideable: Boolean

  fun scheduleHide()

  fun scheduleShow()

  fun hideImmediately()
}