package org.intellij.images.scientific.action

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.DumbAwareAction
import org.intellij.images.editor.ImageDocument
import org.intellij.images.editor.ImageFileEditor
import org.intellij.images.scientific.ScientificUtils
import org.intellij.images.scientific.ScientificUtils.ORIGINAL_IMAGE_KEY
import java.awt.image.BufferedImage

class GrayscaleImageAction : DumbAwareAction() {
  override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

  override fun update(e: AnActionEvent) {
    val imageFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
    e.presentation.isEnabledAndVisible = imageFile?.getUserData(ScientificUtils.SCIENTIFIC_MODE_KEY) != null
  }

  override fun actionPerformed(e: AnActionEvent) {
    val imageFile = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return
    val originalImage = imageFile.getUserData(ORIGINAL_IMAGE_KEY) ?: return
    val grayscaleImage = applyGrayscale(originalImage)
    //val editor = e.getData(IMAGE_DOCUMENT_DATA_KEY ) TODO: get editor?
    //val document = (editor as ImageFileEditor).imageEditor.document as ImageDocument
    //document.value = grayscaleImage
  }

  private fun applyGrayscale(image: BufferedImage): BufferedImage {
    val grayscaleImage = BufferedImage(image.width, image.height, BufferedImage.TYPE_BYTE_GRAY)

    val graphics = grayscaleImage.createGraphics()
    graphics.drawImage(image, 0, 0, null)
    graphics.dispose()

    return grayscaleImage
  }
}