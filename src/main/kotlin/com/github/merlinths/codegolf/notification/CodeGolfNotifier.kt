package com.github.merlinths.codegolf.notification

import com.github.merlinths.codegolf.MyBundle
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

private const val GROUP_ID = "CodeGolf Notifications"
private val TITLE = MyBundle.message("title")

object CodeGolfNotifier {
    private val notificationGroup =
        NotificationGroupManager
            .getInstance()
            .getNotificationGroup(GROUP_ID)

    fun info(
        project: Project,
        content: String
    ) {
        notificationGroup
            .createNotification(TITLE, content, NotificationType.INFORMATION)
            .notify(project)
    }
}