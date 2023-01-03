package com.github.merlinths.codegolf.threading

import com.intellij.openapi.application.ApplicationManager

fun executeWriteAction(action: Runnable) =
        with(ApplicationManager.getApplication()) {
            executeOnPooledThread {
                runWriteAction(action)
            }
        }